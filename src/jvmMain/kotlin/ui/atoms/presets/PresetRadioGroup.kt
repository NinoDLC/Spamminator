package ui.atoms.presets

import DI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PresetRadioGroup() {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(8.dp)) {
            Text("Preset")

            val presetRepository = DI.presetRepository

            var selectedPreset by remember { mutableStateOf(presetRepository.preset) }
            Row(
                modifier = Modifier.selectableGroup(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Preset.values().forEach {
                    RadioButton(
                        selected = it == selectedPreset,
                        onClick = {
                            selectedPreset = it
                            presetRepository.preset = it
                        }
                    )
                    Text(text = it.label)
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