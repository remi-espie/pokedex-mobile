package fr.dopolytech.mobidex.ui.design

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@Composable
fun BannerWrapper(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val bannerHeight = with(LocalDensity.current) { (configuration.screenHeightDp.dp).toPx() / 10 }
    val screenWidth = with(LocalDensity.current) { configuration.screenWidthDp.dp.toPx() }

    Surface {
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            TopBannerTemplate(bannerHeight, screenWidth)

            // main content
            Layout(
                modifier = modifier,
                content = content,
            ) { measurables, constraints ->
                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints)
                }

                layout(constraints.maxWidth, constraints.maxHeight) {
                    var yPosition = 0
                    placeables.forEach { placeable ->
                        placeable.placeRelative(x = 0, y = yPosition)
                        yPosition += placeable.height
                    }
                }
            }


        }
    }
}

@Composable
private fun TopBannerTemplate(height: Float, screenWidth: Float) {
    val heightToDp = with(LocalDensity.current) { height.toDp() }
    val backgroundColor = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = heightToDp)
    ) {
        Canvas(modifier = Modifier, onDraw = {
            // red rectangle
            drawRect(
                color = Color(0xFFE42828),
                size = Size(screenWidth + 1, height)
            )

            // black border
            val border = height / 8
            drawRect(
                color = Color(0xFF000000),
                topLeft = Offset(0f, height - border),
                size = Size(screenWidth + 1, border)
            )

            // circle variables
            val size = height
            val x = screenWidth / 2 - height / 2
            val y = height / 2
            val offset = height / 3

            // outer black half-moon
            drawArc(
                color = Color(0xFF000000),
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(x - offset / 2, y - offset / 2),
                size = Size(size + offset, size + offset)
            )

            // inner white half-moon
            drawArc(
                color = backgroundColor,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(x, y + 2),
                size = Size(size, size)
            )
        })
    }
}

@Composable
private fun BottomBannerTemplate() {

}