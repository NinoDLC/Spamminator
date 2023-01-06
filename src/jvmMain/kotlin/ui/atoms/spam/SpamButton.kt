package ui.atoms.spam

import DI
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import data.station.model.StationEntity
import kotlinx.coroutines.Dispatchers
import org.jetbrains.skia.Image.Companion.makeFromEncoded
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

@Composable
fun SpamButton(stationEntity: StationEntity, displayIcon: Boolean = false) {
    val spamViewModel = DI.getSpamViewModel(stationEntity)

    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0.7F, 0.7F, 0.7F, 0.3F).compositeOver(Color(stationEntity.color))
        ),
        onClick = { spamViewModel.onClick() },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (displayIcon) {
                Image(
                    modifier = Modifier.height(50.dp).width(100.dp),
                    contentScale = ContentScale.Crop,
                    bitmap = loadNetworkImage(stationEntity.icon),
                    contentDescription = null
                )
            }
            val spamCount: State<Int?> = spamViewModel.spamCountFlow.collectAsState(null, Dispatchers.IO)
            Text(
                if (spamCount.value == null) {
                    "Spam ${stationEntity.name}"
                } else {
                    "Spammed ${stationEntity.name} ${spamCount.value} times..."
                }
            )
        }
    }
}

@Preview
@Composable
fun SpamButtonPreview() {
    SpamButton(
        stationEntity = DI.stationRepository.getStationEntity("1")
    )
}

@Preview
@Composable
fun SpamButtonWithIconPreview() {
    SpamButton(
        stationEntity = DI.stationRepository.getStationEntity("1"),
        displayIcon = true
    )
}

private fun loadNetworkImage(link: String): ImageBitmap {
    val url = URL(link)
    val connection = url.openConnection() as HttpURLConnection
    connection.connect()

    val inputStream = connection.inputStream
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return makeFromEncoded(byteArray).toComposeImageBitmap()
}