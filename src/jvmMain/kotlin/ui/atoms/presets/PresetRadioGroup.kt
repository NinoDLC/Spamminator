package ui.atoms.presets

import DI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.update

@Composable
fun PresetCheckBoxes() {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(8.dp)) {
            Text("Preset")

            val presetRepository = DI.presetRepository

            val selectedPresets = presetRepository.presetsFlow.collectAsState()
            Row(
                modifier = Modifier.selectableGroup(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Preset.values().forEach { preset ->
                    Checkbox(
                        checked = selectedPresets.value.contains(preset),
                        onCheckedChange = {
                            presetRepository.presetsFlow.update {
                                if (selectedPresets.value.contains(preset)) {
                                    it - preset
                                } else {
                                    it + preset
                                }
                            }
                        }
                    )
                    Text(text = preset.label)
                }
            }
        }
    }
}

enum class Preset(
    val label: String,
    val value: String,
) {
    X1("1x", "360x360"),
    X1_5("1.5x", "540x540"),
    X2("2x", "720x720"),
    X3("3x", "1080x1080"),
    X4("4x", "1440x1440"),
}