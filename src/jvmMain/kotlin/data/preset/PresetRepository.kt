package data.preset

import kotlinx.coroutines.flow.MutableStateFlow
import ui.atoms.presets.Preset

class PresetRepository {
    val presetsFlow = MutableStateFlow(Preset.values().toList())
}