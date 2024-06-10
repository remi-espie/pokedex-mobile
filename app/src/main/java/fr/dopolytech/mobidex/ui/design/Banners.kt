package fr.dopolytech.mobidex.ui.design

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import fr.dopolytech.mobidex.ui.theme.PokemonBackground


@Composable
fun BannerWrapper(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current

    val percentage = 0.1f
    val spacing = 15.dp

    val bannerHeight = with(LocalDensity.current) {
        (configuration.screenHeightDp.dp).toPx() * percentage
    }
    val contentHeight = configuration.screenHeightDp.dp * (1f - 2 * percentage) - (spacing * 2)

    val screenWidth = with(LocalDensity.current) { configuration.screenWidthDp.dp.toPx() }

    Surface {
        Column(verticalArrangement = Arrangement.spacedBy(spacing)) {
            TopBannerTemplate(bannerHeight, screenWidth)

            // main content
            Surface(modifier = Modifier.size(contentHeight)) {
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

            BottomBannerTemplate(height = bannerHeight, screenWidth = screenWidth)
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
            // -- BASE RECTANGLES --

            // red rectangle
            drawRect(
                color = PokemonBackground,
                size = Size(screenWidth + 1, height)
            )

            // black border
            val border = height / 8
            drawRect(
                color = Color.Black,
                topLeft = Offset(0f, height - border),
                size = Size(screenWidth + 1, border)
            )


            // -- CENTERED HALF-MOON "chm" --

            // circle variables
            val chmSize = height
            val chmX = screenWidth / 2 - height / 2
            val chmY = height / 2
            val chmOffset = height / 3

            // outer black half-moon
            drawArc(
                color = Color.Black,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(chmX - chmOffset / 2, chmY - chmOffset / 2),
                size = Size(chmSize + chmOffset, chmSize + chmOffset)
            )

            // inner white half-moon
            drawArc(
                color = backgroundColor,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(chmX, chmY + 2),
                size = Size(chmSize, chmSize)
            )


            val cornersQmSize = chmSize / 1.5f
            val cornersQmOffset = chmOffset / 2f

            // -- TOP-LEFT QUARTER-MOON --

            drawArc(
                color = Color.Black,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    -cornersQmSize / 2 - cornersQmOffset / 2,
                    -cornersQmSize / 2 - cornersQmOffset / 2
                ),
                size = Size(cornersQmSize + cornersQmOffset, cornersQmSize + cornersQmOffset)
            )

            drawArc(
                color = PokemonBackground,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(-cornersQmSize / 2, -cornersQmSize / 2),
                size = Size(cornersQmSize, cornersQmSize)
            )


            // -- TOP-RIGHT QUARTER-MOON --

            drawArc(
                color = Color.Black,
                startAngle = 90f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    screenWidth - cornersQmSize / 2 - cornersQmOffset / 2,
                    -cornersQmSize / 2 - cornersQmOffset / 2
                ),
                size = Size(cornersQmSize + cornersQmOffset, cornersQmSize + cornersQmOffset)
            )

            drawArc(
                color = PokemonBackground,
                startAngle = 90f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    screenWidth - cornersQmSize / 2,
                    -cornersQmSize / 2
                ),
                size = Size(cornersQmSize, cornersQmSize)
            )
        })
    }
}

@Composable
private fun BottomBannerTemplate(height: Float, screenWidth: Float) {
    val heightToDp = with(LocalDensity.current) { height.toDp() }
    val backgroundColor = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = heightToDp)
    ) {
        Canvas(modifier = Modifier, onDraw = {
            // -- BASE RECTANGLES --

            // red rectangle
            drawRect(
                color = PokemonBackground,
                size = Size(screenWidth + 1, height)
            )

            // black border
            val border = height / 8
            drawRect(
                color = Color.Black,
                topLeft = Offset(0f, 0f),
                size = Size(screenWidth + 1, border)
            )


            // -- CENTERED HALF-MOON "chm" --

            // circle variables
            val chmSize = height
            val chmX = screenWidth / 2 - height / 2
            val chmY = -height / 2
            val chmOffset = height / 3

            // outer black half-moon
            drawArc(
                color = Color.Black,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(chmX - chmOffset / 2, chmY - chmOffset / 2),
                size = Size(chmSize + chmOffset, chmSize + chmOffset)
            )

            // inner white half-moon
            drawArc(
                color = backgroundColor,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(chmX, chmY - 2),
                size = Size(chmSize, chmSize)
            )


            val cornersQmSize = chmSize / 1.5f
            val cornersQmOffset = chmOffset / 2f

            // -- BOTTOM-LEFT QUARTER-MOON --

            drawArc(
                color = Color.Black,
                startAngle = 270f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    -cornersQmSize / 2 - cornersQmOffset / 2,
                    cornersQmSize - cornersQmOffset / 2
                ),
                size = Size(cornersQmSize + cornersQmOffset, cornersQmSize + cornersQmOffset)
            )

            drawArc(
                color = PokemonBackground,
                startAngle = 270f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    -cornersQmSize / 2,
                    cornersQmSize
                ),
                size = Size(cornersQmSize, cornersQmSize)
            )


            // -- BOTTOM-RIGHT QUARTER-MOON --

            drawArc(
                color = Color.Black,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    screenWidth - cornersQmSize / 2 - cornersQmOffset / 2,
                    cornersQmSize - cornersQmOffset / 2
                ),
                size = Size(cornersQmSize + cornersQmOffset, cornersQmSize + cornersQmOffset)
            )

            drawArc(
                color = PokemonBackground,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(
                    screenWidth - cornersQmSize / 2,
                    cornersQmSize
                ),
                size = Size(cornersQmSize, cornersQmSize)
            )
        })
    }
}