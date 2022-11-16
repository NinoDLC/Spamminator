package ui

import DI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.atoms.presets.PresetRadioGroup
import ui.atoms.spam.SpamButton
import ui.utils.FlowHorizontalAlignment
import ui.utils.FlowRow
import ui.utils.FlowVerticalAlignment
import ui.utils.SizeMode

@Composable
fun MainScreen() {
    val liveInfoRepository = DI.liveInfoRepository
    val stationRepository = DI.stationRepository

    Column(
        modifier = Modifier.fillMaxSize(),
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

        PresetRadioGroup()

        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
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
                    SpamButton(stationRepository.getStationEntity("1"), displayIcon = true)
                    SpamButton(stationRepository.getStationEntity("2"), displayIcon = true)
                    SpamButton(stationRepository.getStationEntity("7"), displayIcon = true)
                    SpamButton(stationRepository.getStationEntity("5"), displayIcon = true)
                    SpamButton(stationRepository.getStationEntity("4"), displayIcon = true)
                    SpamButton(stationRepository.getStationEntity("6"), displayIcon = true)
                }
            }
        }

        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
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
                    SpamButton(stationRepository.getStationEntity("64"))
                    SpamButton(stationRepository.getStationEntity("65"))
                    SpamButton(stationRepository.getStationEntity("66"))
                    SpamButton(stationRepository.getStationEntity("74"))
                    SpamButton(stationRepository.getStationEntity("78"))
                    SpamButton(stationRepository.getStationEntity("69"))
                    SpamButton(stationRepository.getStationEntity("71"))
                    SpamButton(stationRepository.getStationEntity("70"))
                    SpamButton(stationRepository.getStationEntity("77"))
                    SpamButton(stationRepository.getStationEntity("95"))
                }
            }
        }

        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
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
                    SpamButton(stationRepository.getStationEntity("401"))
                    SpamButton(stationRepository.getStationEntity("409"))
                    SpamButton(stationRepository.getStationEntity("408"))
                    SpamButton(stationRepository.getStationEntity("402"))
                    SpamButton(stationRepository.getStationEntity("403"))
                    SpamButton(stationRepository.getStationEntity("405"))
                    SpamButton(stationRepository.getStationEntity("406"))
                    SpamButton(stationRepository.getStationEntity("404"))
                    SpamButton(stationRepository.getStationEntity("407"))
                }
            }
        }

        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
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
                    SpamButton(stationRepository.getStationEntity("605"))
                    SpamButton(stationRepository.getStationEntity("75"))
                    SpamButton(stationRepository.getStationEntity("601"))
                    SpamButton(stationRepository.getStationEntity("606"))
                    SpamButton(stationRepository.getStationEntity("604"))
                    SpamButton(stationRepository.getStationEntity("603"))
                    SpamButton(stationRepository.getStationEntity("602"))
                }
            }
        }

        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
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
                    SpamButton(stationRepository.getStationEntity("11"))
                    SpamButton(stationRepository.getStationEntity("12"))
                    SpamButton(stationRepository.getStationEntity("13"))
                    SpamButton(stationRepository.getStationEntity("14"))
                    SpamButton(stationRepository.getStationEntity("15"))
                    SpamButton(stationRepository.getStationEntity("16"))
                    SpamButton(stationRepository.getStationEntity("17"))
                    SpamButton(stationRepository.getStationEntity("18"))
                    SpamButton(stationRepository.getStationEntity("19"))
                    SpamButton(stationRepository.getStationEntity("20"))
                    SpamButton(stationRepository.getStationEntity("21"))
                    SpamButton(stationRepository.getStationEntity("22"))
                    SpamButton(stationRepository.getStationEntity("23"))
                    SpamButton(stationRepository.getStationEntity("24"))
                    SpamButton(stationRepository.getStationEntity("25"))
                    SpamButton(stationRepository.getStationEntity("26"))
                    SpamButton(stationRepository.getStationEntity("27"))
                    SpamButton(stationRepository.getStationEntity("28"))
                    SpamButton(stationRepository.getStationEntity("29"))
                    SpamButton(stationRepository.getStationEntity("30"))
                    SpamButton(stationRepository.getStationEntity("31"))
                    SpamButton(stationRepository.getStationEntity("32"))
                    SpamButton(stationRepository.getStationEntity("33"))
                    SpamButton(stationRepository.getStationEntity("34"))
                    SpamButton(stationRepository.getStationEntity("36"))
                    SpamButton(stationRepository.getStationEntity("37"))
                    SpamButton(stationRepository.getStationEntity("38"))
                    SpamButton(stationRepository.getStationEntity("39"))
                    SpamButton(stationRepository.getStationEntity("40"))
                    SpamButton(stationRepository.getStationEntity("41"))
                    SpamButton(stationRepository.getStationEntity("42"))
                    SpamButton(stationRepository.getStationEntity("43"))
                    SpamButton(stationRepository.getStationEntity("44"))
                    SpamButton(stationRepository.getStationEntity("45"))
                    SpamButton(stationRepository.getStationEntity("46"))
                    SpamButton(stationRepository.getStationEntity("47"))
                    SpamButton(stationRepository.getStationEntity("48"))
                    SpamButton(stationRepository.getStationEntity("49"))
                    SpamButton(stationRepository.getStationEntity("50"))
                    SpamButton(stationRepository.getStationEntity("54"))
                    SpamButton(stationRepository.getStationEntity("68"))
                    SpamButton(stationRepository.getStationEntity("90"))
                    SpamButton(stationRepository.getStationEntity("91"))
                    SpamButton(stationRepository.getStationEntity("92"))
                    SpamButton(stationRepository.getStationEntity("93"))
                }
            }
        }
    }
}

private val mainStationIds = listOf(
    "1",
    "2",
    "7",
    "64",
    "65",
    "66",
    "74",
    "78",
    "69",
    "71",
    "70",
    "77",
    "95",
    "5",
    "11",
    "12",
    "13",
    "14",
    "15",
    "16",
    "17",
    "18",
    "19",
    "20",
    "21",
    "22",
    "23",
    "24",
    "25",
    "26",
    "27",
    "28",
    "29",
    "30",
    "31",
    "32",
    "33",
    "34",
    "36",
    "37",
    "38",
    "39",
    "40",
    "41",
    "42",
    "43",
    "44",
    "45",
    "46",
    "47",
    "48",
    "49",
    "50",
    "54",
    "68",
    "90",
    "91",
    "92",
    "93",
    "4",
    "401",
    "409",
    "408",
    "402",
    "403",
    "405",
    "406",
    "404",
    "407",
    "6",
    "605",
    "75",
    "601",
    "606",
    "604",
    "603",
    "602",
)