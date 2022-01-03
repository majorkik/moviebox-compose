package com.majorkik.ui.movie.details.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
internal fun ImagePager(
    imageLinks: List<String>,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState()
) {
    HorizontalPager(
        count = imageLinks.count(),
        state = pagerState
    ) { page ->
        Image(
            painter = rememberImagePainter(data = imageLinks[page]),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
internal fun HorizontalIndicator(count: Int, modifier: Modifier = Modifier, currentIndex: Int = 0) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val indicatorWidth = screenWidth.minus(DimenLocal.Indicators.totalHorizontalPadding).div(count).dp

    if (count != 0 && screenWidth > 0) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            (0 until count).forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 1.dp)
                        .width(indicatorWidth)
                        .height(DimenLocal.Indicators.heightDp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (index == currentIndex) Color.White else Color.White.copy(alpha = 0.25f))
                )
            }
        }
    }
}
