package ui.utils

/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.*
import kotlin.math.max

/**
 * A composable that places its children in a horizontal flow. Unlike [Row], if the
 * horizontal space is too small to put all the children in one row, multiple rows may be used.
 *
 * Note that just like [Row], flex values cannot be used with [FlowRow].
 *
 * @param modifier The modifier to be applied to the FlowRow.
 * @param sizeMode The size of the layout in the main axis direction.
 * @param horizontalAlignment The alignment of each row's children in the main axis direction.
 * @param horizontalSpacing The main axis spacing between the children of each row.
 * @param verticalAlignment The alignment of each row's children in the cross axis direction.
 * @param verticalSpacing The cross axis spacing between the rows of the layout.
 * @param lastLineAlignment Overrides the main axis alignment of the last row.
 */
@Composable
fun FlowRow(
    modifier: Modifier,
    sizeMode: SizeMode,
    horizontalAlignment: FlowHorizontalAlignment,
    horizontalSpacing: Dp,
    verticalAlignment: FlowVerticalAlignment,
    verticalSpacing: Dp,
    lastLineAlignment: FlowHorizontalAlignment,
    content: @Composable () -> Unit
) {
    fun Placeable.mainAxisSize() = width
    fun Placeable.crossAxisSize() = height

    Layout(content, modifier) { measurables, outerConstraints ->
        val sequences = mutableListOf<List<Placeable>>()
        val crossAxisSizes = mutableListOf<Int>()
        val crossAxisPositions = mutableListOf<Int>()

        var mainAxisSpace = 0
        var crossAxisSpace = 0

        val currentSequence = mutableListOf<Placeable>()
        var currentMainAxisSize = 0
        var currentCrossAxisSize = 0

        val mainAxisMin = outerConstraints.minWidth
        val mainAxisMax = outerConstraints.maxWidth
        val crossAxisMin = outerConstraints.minHeight

        val childConstraints = Constraints(maxWidth = mainAxisMax)

        // Return whether the placeable can be added to the current sequence.
        fun canAddToCurrentSequence(placeable: Placeable) =
            currentSequence.isEmpty() || currentMainAxisSize + horizontalSpacing.roundToPx() +
                placeable.mainAxisSize() <= mainAxisMax

        // Store current sequence information and start a new sequence.
        fun startNewSequence() {
            if (sequences.isNotEmpty()) {
                crossAxisSpace += verticalSpacing.roundToPx()
            }
            sequences += currentSequence.toList()
            crossAxisSizes += currentCrossAxisSize
            crossAxisPositions += crossAxisSpace

            crossAxisSpace += currentCrossAxisSize
            mainAxisSpace = max(mainAxisSpace, currentMainAxisSize)

            currentSequence.clear()
            currentMainAxisSize = 0
            currentCrossAxisSize = 0
        }

        for (measurable in measurables) {
            // Ask the child for its preferred size.
            val placeable = measurable.measure(childConstraints)

            // Start a new sequence if there is not enough space.
            if (!canAddToCurrentSequence(placeable)) startNewSequence()

            // Add the child to the current sequence.
            if (currentSequence.isNotEmpty()) {
                currentMainAxisSize += horizontalSpacing.roundToPx()
            }
            currentSequence.add(placeable)
            currentMainAxisSize += placeable.mainAxisSize()
            currentCrossAxisSize = max(currentCrossAxisSize, placeable.crossAxisSize())
        }

        if (currentSequence.isNotEmpty()) {
            startNewSequence()
        }

        val mainAxisLayoutSize = if (mainAxisMax != Constraints.Infinity && sizeMode == SizeMode.Expand) {
            mainAxisMax
        } else {
            max(mainAxisSpace, mainAxisMin)
        }
        val crossAxisLayoutSize = max(crossAxisSpace, crossAxisMin)

        layout(mainAxisLayoutSize, crossAxisLayoutSize) {
            sequences.forEachIndexed { i, placeables ->
                val childrenMainAxisSizes = IntArray(placeables.size) { j ->
                    placeables[j].mainAxisSize() +
                        if (j < placeables.lastIndex) horizontalSpacing.roundToPx() else 0
                }
                val arrangement = if (i < sequences.lastIndex) {
                    horizontalAlignment.arrangement
                } else {
                    lastLineAlignment.arrangement
                }
                // TODO(soboleva): rtl support
                // Handle vertical direction
                val mainAxisPositions = IntArray(childrenMainAxisSizes.size) { 0 }
                with(arrangement) {
                    arrange(mainAxisLayoutSize, childrenMainAxisSizes, mainAxisPositions)
                }
                placeables.forEachIndexed { j, placeable ->
                    val crossAxis = when (verticalAlignment) {
                        FlowVerticalAlignment.Start -> 0
                        FlowVerticalAlignment.End ->
                            crossAxisSizes[i] - placeable.crossAxisSize()

                        FlowVerticalAlignment.Center ->
                            Alignment.Center.align(
                                IntSize.Zero,
                                IntSize(
                                    width = 0,
                                    height = crossAxisSizes[i] - placeable.crossAxisSize()
                                ),
                                LayoutDirection.Ltr
                            ).y
                    }
                    placeable.place(
                        x = mainAxisPositions[j],
                        y = crossAxisPositions[i] + crossAxis
                    )
                }
            }
        }
    }
}

/**
 * Used to specify the alignment of a layout's children, in cross axis direction.
 */
enum class FlowVerticalAlignment {
    /**
     * Place children such that their center is in the middle of the cross axis.
     */
    Center,

    /**
     * Place children such that their start edge is aligned to the start edge of the cross axis.
     */
    Start,

    /**
     * Place children such that their end edge is aligned to the end edge of the cross axis.
     */
    End,
}

/**
 * Used to specify how a layout chooses its own size when multiple behaviors are possible.
 */
enum class SizeMode {
    /**
     * Minimize the amount of free space by wrapping the children,
     * subject to the incoming layout constraints.
     */
    Wrap,

    /**
     * Maximize the amount of free space by expanding to fill the available space,
     * subject to the incoming layout constraints.
     */
    Expand
}

/**
 * Used to specify the alignment of a layout's children, in main axis direction.
 */
enum class FlowHorizontalAlignment(internal val arrangement: Arrangement.Vertical) {
    /**
     * Place children such that they are as close as possible to the middle of the main axis.
     */
    Center(Arrangement.Center),

    /**
     * Place children such that they are as close as possible to the start of the main axis.
     */
    Start(Arrangement.Top),

    /**
     * Place children such that they are as close as possible to the end of the main axis.
     */
    End(Arrangement.Bottom),

    /**
     * Place children such that they are spaced evenly across the main axis, including free
     * space before the first child and after the last child.
     */
    SpaceEvenly(Arrangement.SpaceEvenly),

    /**
     * Place children such that they are spaced evenly across the main axis, without free
     * space before the first child or after the last child.
     */
    SpaceBetween(Arrangement.SpaceBetween),

    /**
     * Place children such that they are spaced evenly across the main axis, including free
     * space before the first child and after the last child, but half the amount of space
     * existing otherwise between two consecutive children.
     */
    SpaceAround(Arrangement.SpaceAround);
}