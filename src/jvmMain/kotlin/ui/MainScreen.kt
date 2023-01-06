package ui

import DI
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.atoms.presets.PresetCheckBoxes
import ui.atoms.spam.SpamButton
import ui.utils.FlowHorizontalAlignment
import ui.utils.FlowRow
import ui.utils.FlowVerticalAlignment
import ui.utils.SizeMode

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MainScreen() {
    val liveInfoRepository = DI.liveInfoRepository
    val stationRepository = DI.stationRepository
    val spamRepository = DI.spamRepository

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            val totalCalls = liveInfoRepository.totalCallsFlow.collectAsState(0)
            Text(
                modifier = Modifier.weight(1F).padding(8.dp),
                text = "Total calls = ${totalCalls.value}",
                textAlign = TextAlign.End
            )

            val totalFails = liveInfoRepository.totalFailsFlow.collectAsState(0)
            Text(
                modifier = Modifier.weight(1F).padding(8.dp),
                text = "Total fails = ${totalFails.value}",
                textAlign = TextAlign.Start
            )
        }

        PresetCheckBoxes()

        // Main
        val mainStations = listOf(
            stationRepository.getStationEntity("1"),
            stationRepository.getStationEntity("2"),
            stationRepository.getStationEntity("7"),
            stationRepository.getStationEntity("5"),
            stationRepository.getStationEntity("4"),
            stationRepository.getStationEntity("6"),
        )
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            onClick = {
                mainStations.forEach { stationEntity ->
                    spamRepository.toggleSpam(stationEntity)
                }
            }
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Main"
                )
                FlowRow(
                    modifier = Modifier.padding(bottom = 8.dp),
                    sizeMode = SizeMode.Expand,
                    horizontalAlignment = FlowHorizontalAlignment.Center,
                    horizontalSpacing = 8.dp,
                    verticalAlignment = FlowVerticalAlignment.Center,
                    verticalSpacing = 0.dp,
                    lastLineAlignment = FlowHorizontalAlignment.Center
                ) {
                    mainStations.forEach { stationEntity ->
                        SpamButton(stationEntity = stationEntity, displayIcon = true)
                    }
                }
            }
        }

        // FIP
        val fipStations = listOf(
            stationRepository.getStationEntity("64"),
            stationRepository.getStationEntity("65"),
            stationRepository.getStationEntity("66"),
            stationRepository.getStationEntity("74"),
            stationRepository.getStationEntity("78"),
            stationRepository.getStationEntity("69"),
            stationRepository.getStationEntity("71"),
            stationRepository.getStationEntity("70"),
            stationRepository.getStationEntity("77"),
            stationRepository.getStationEntity("95"),
        )
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            onClick = {
                fipStations.forEach { stationEntity ->
                    spamRepository.toggleSpam(stationEntity)
                }
            }
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "FIP"
                )
                FlowRow(
                    modifier = Modifier,
                    sizeMode = SizeMode.Expand,
                    horizontalAlignment = FlowHorizontalAlignment.Center,
                    horizontalSpacing = 8.dp,
                    verticalAlignment = FlowVerticalAlignment.Center,
                    verticalSpacing = 0.dp,
                    lastLineAlignment = FlowHorizontalAlignment.Center
                ) {
                    fipStations.forEach { stationEntity ->
                        SpamButton(stationEntity)
                    }
                }
            }
        }

        // Musique
        val musiqueStations = listOf(
            stationRepository.getStationEntity("401"),
            stationRepository.getStationEntity("409"),
            stationRepository.getStationEntity("408"),
            stationRepository.getStationEntity("402"),
            stationRepository.getStationEntity("403"),
            stationRepository.getStationEntity("405"),
            stationRepository.getStationEntity("406"),
            stationRepository.getStationEntity("404"),
            stationRepository.getStationEntity("407"),
        )
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            onClick = {
                musiqueStations.forEach { stationEntity ->
                    spamRepository.toggleSpam(stationEntity)
                }
            }
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Musique"
                )
                FlowRow(
                    modifier = Modifier,
                    sizeMode = SizeMode.Expand,
                    horizontalAlignment = FlowHorizontalAlignment.Center,
                    horizontalSpacing = 8.dp,
                    verticalAlignment = FlowVerticalAlignment.Center,
                    verticalSpacing = 0.dp,
                    lastLineAlignment = FlowHorizontalAlignment.Center
                ) {
                    musiqueStations.forEach { stationEntity ->
                        SpamButton(stationEntity)
                    }
                }
            }
        }

        // Mouv
        val mouvStations = listOf(
            stationRepository.getStationEntity("605"),
            stationRepository.getStationEntity("75"),
            stationRepository.getStationEntity("601"),
            stationRepository.getStationEntity("606"),
            stationRepository.getStationEntity("604"),
            stationRepository.getStationEntity("603"),
            stationRepository.getStationEntity("602"),
        )
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            onClick = {
                mouvStations.forEach { stationEntity ->
                    spamRepository.toggleSpam(stationEntity)
                }
            }
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Mouv'"
                )
                FlowRow(
                    modifier = Modifier,
                    sizeMode = SizeMode.Expand,
                    horizontalAlignment = FlowHorizontalAlignment.Center,
                    horizontalSpacing = 8.dp,
                    verticalAlignment = FlowVerticalAlignment.Center,
                    verticalSpacing = 0.dp,
                    lastLineAlignment = FlowHorizontalAlignment.Center
                ) {
                    mouvStations.forEach { stationEntity ->
                        SpamButton(stationEntity)
                    }
                }
            }
        }

        // Bleu
        val bleuStations = listOf(
            stationRepository.getStationEntity("11"),
            stationRepository.getStationEntity("12"),
            stationRepository.getStationEntity("13"),
            stationRepository.getStationEntity("14"),
            stationRepository.getStationEntity("15"),
            stationRepository.getStationEntity("16"),
            stationRepository.getStationEntity("17"),
            stationRepository.getStationEntity("18"),
            stationRepository.getStationEntity("19"),
            stationRepository.getStationEntity("20"),
            stationRepository.getStationEntity("21"),
            stationRepository.getStationEntity("22"),
            stationRepository.getStationEntity("23"),
            stationRepository.getStationEntity("24"),
            stationRepository.getStationEntity("25"),
            stationRepository.getStationEntity("26"),
            stationRepository.getStationEntity("27"),
            stationRepository.getStationEntity("28"),
            stationRepository.getStationEntity("29"),
            stationRepository.getStationEntity("30"),
            stationRepository.getStationEntity("31"),
            stationRepository.getStationEntity("32"),
            stationRepository.getStationEntity("33"),
            stationRepository.getStationEntity("34"),
            stationRepository.getStationEntity("36"),
            stationRepository.getStationEntity("37"),
            stationRepository.getStationEntity("38"),
            stationRepository.getStationEntity("39"),
            stationRepository.getStationEntity("40"),
            stationRepository.getStationEntity("41"),
            stationRepository.getStationEntity("42"),
            stationRepository.getStationEntity("43"),
            stationRepository.getStationEntity("44"),
            stationRepository.getStationEntity("45"),
            stationRepository.getStationEntity("46"),
            stationRepository.getStationEntity("47"),
            stationRepository.getStationEntity("48"),
            stationRepository.getStationEntity("49"),
            stationRepository.getStationEntity("50"),
            stationRepository.getStationEntity("54"),
            stationRepository.getStationEntity("68"),
            stationRepository.getStationEntity("90"),
            stationRepository.getStationEntity("91"),
            stationRepository.getStationEntity("92"),
            stationRepository.getStationEntity("93"),
        )
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            onClick = {
                bleuStations.forEach { stationEntity ->
                    spamRepository.toggleSpam(stationEntity)
                }
            }
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Bleu"
                )
                FlowRow(
                    modifier = Modifier,
                    sizeMode = SizeMode.Expand,
                    horizontalAlignment = FlowHorizontalAlignment.Center,
                    horizontalSpacing = 8.dp,
                    verticalAlignment = FlowVerticalAlignment.Center,
                    verticalSpacing = 0.dp,
                    lastLineAlignment = FlowHorizontalAlignment.Center
                ) {
                    bleuStations.forEach { stationEntity ->
                        SpamButton(stationEntity)
                    }
                }
            }
        }
    }
}