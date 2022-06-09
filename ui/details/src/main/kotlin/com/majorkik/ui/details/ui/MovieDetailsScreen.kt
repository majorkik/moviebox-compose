package com.majorkik.ui.details.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import arrow.core.getOrElse
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.majorkik.common.AppDateFormat
import com.majorkik.core.ui.components.getSmallProfilePlaceholder
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.BackdropPath
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.model.ProfilePath
import com.ramcosta.composedestinations.annotation.Destination
import com.soywiz.klock.Date
import io.dokar.expandabletext.ExpandableText
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf
import com.majorkik.core.ui.R as CoreRes

private object MovieDetailsDimens {
    val contentHorizontalPadding = PaddingValues(horizontal = 16.dp)
}

@Destination(navArgsDelegate = MovieDetailsNavArgs::class)
@Composable
fun MovieDetailsScreen(navController: NavController) {
    MovieBoxContent(viewModel = getViewModel { parametersOf(navController.currentBackStackEntry) })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun MovieBoxContent(viewModel: MovieDetailsViewModel) {
    val state = viewModel.container.stateFlow.collectAsState()
    var overviewExpanded by remember { mutableStateOf(false) }

    when (val screenState = state.value.screen) {
        is State.MovieDetailsState -> {
            val details = screenState.data

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState())
            ) {
                // Image pager
                HorizontalPager(count = details.posters.count()) { page ->
                    AsyncImage(
                        model = details.backdrops.getOrNull(page)
                            ?.build(size = BackdropPath.Size.Original)
                            .orEmpty(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(400.dp)
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                // Movie title
                Text(
                    text = details.title,
                    color = MovieBoxTheme.colors.details.textPrimary,
                    style = MovieBoxTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(MovieDetailsDimens.contentHorizontalPadding)
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(8.dp))

                // Release date + status
                ReleaseDate(
                    releaseDate = details.releaseDate,
                    releaseStatus = details.status,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.size(8.dp))

                // Genres
                Text(
                    text = details.genres.joinToString { genre -> genre.name.capitalize(Locale.current) },
                    color = MovieBoxTheme.colors.details.textPrimary,
                    style = MovieBoxTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clip(CircleShape)
                        .clickableWithSimpleRipple {
                            /* no-op */
                        }
                        .padding(MovieDetailsDimens.contentHorizontalPadding)
                        .padding(vertical = 2.dp)
                )

                Spacer(modifier = Modifier.size(16.dp))

                // Action button
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Button(
                        onClick = { /* no-op */ },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            hoveredElevation = 0.dp,
                            focusedElevation = 0.dp
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .fillMaxWidth()
                            .weight(1f),
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = MovieBoxTheme.colors.primary, // TODO: refactor
                            contentColor = MovieBoxTheme.colors.white,
                            disabledContentColor = MovieBoxTheme.colors.secondary
                        )
                    ) {
                        Text(
                            text = "Will watch",
                            maxLines = 1,
                            style = MovieBoxTheme.typography.titleSmall
                        )
                    }

                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(MovieBoxTheme.colors.primary)// TODO: refactor
                            .size(48.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = CoreRes.drawable.ic_options_black_24),
                            contentDescription = null,
                            tint = Color.White // TODO: refactor
                        )
                    }

                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(MovieBoxTheme.colors.details.btnBgSecondary)
                            .size(48.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = CoreRes.drawable.ic_round_favorite_black_24),
                            contentDescription = null,
                            tint = MovieBoxTheme.colors.details.favoriteBtnDefault,
                        )
                    }
                }

                Spacer(modifier = Modifier.size(16.dp))

                // Overview
                ExpandableText(
                    text = details.overview ?: "",
                    modifier = Modifier
                        .padding(MovieDetailsDimens.contentHorizontalPadding)
                        .animateContentSize()
                        .clickable { overviewExpanded = !overviewExpanded },
                    style = MovieBoxTheme.typography.textMedium,
                    color = MovieBoxTheme.colors.backgroundReverse, // TODO: refactor
                    maxLines = 3,
                    expanded = overviewExpanded,
                    toggleContent = {
                        Text(
                            text = if (overviewExpanded) " Show less" else " Show more",
                            style = MovieBoxTheme.typography.textMedium,
                            color = MovieBoxTheme.colors.primary // TODO: refactor
                        )
                    }
                )

                Spacer(modifier = Modifier.size(16.dp))

                // Tagline
                Tagline(tagline = details.tagline)

                Spacer(modifier = Modifier.size(16.dp))

                // Credits
                CreditsBlock(
                    casts = details.casts,
                    totalAmount = details.casts.count() + details.crews.count(),
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.size(16.dp))

                // Budget & Revenue
                InfoBlock(
                    title = "${details.revenue} / ${details.budget} $",
                    description = "Revenue / Budget",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding)
                )

                Spacer(modifier = Modifier.size(8.dp))

                InfoBlock(
                    title = details.originalTitle,
                    description = "Original title",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding)
                )
            }
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Error state")
            }
        }
    }
}

@Composable
fun ReleaseDate(releaseDate: Date?, releaseStatus: String?, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(MovieDetailsDimens.contentHorizontalPadding)
    ) {
        Text(
            text = AppDateFormat.parseReadableDate(releaseDate).getOrElse { "" },
            color = MovieBoxTheme.colors.details.textPrimary,
            style = MovieBoxTheme.typography.bodyMedium
        )

        if (releaseStatus != null) {
            Text(
                text = releaseStatus,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(MovieBoxTheme.colors.details.placeholderBg)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = MovieBoxTheme.colors.details.textPlaceholder,
                style = MovieBoxTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun Tagline(tagline: String?) {
    val quoteLeadingId = "quote_leading_id"
    val quoteTrailingId = "quote_trailing_id"

    val inlineContentMap = mapOf(
        quoteLeadingId to buildQuoteInlineContent(CoreRes.drawable.ic_quote_leading_yellow_12),
        quoteTrailingId to buildQuoteInlineContent(CoreRes.drawable.ic_quote_trailing_yellow_12),
    )

    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = quoteLeadingId)
        append(tagline ?: "")
        appendInlineContent(id = quoteTrailingId)
    }

    AnimatedVisibility(visible = tagline.isNullOrBlank().not()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .heightIn(min = 40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MovieBoxTheme.colors.details.backgroundSecondary)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = annotatedString,
                style = MovieBoxTheme.typography.text,
                modifier = Modifier.align(Alignment.CenterVertically),
                inlineContent = inlineContentMap,
                color = MovieBoxTheme.colors.details.textPrimary
            )
        }
    }
}

private fun buildQuoteInlineContent(@DrawableRes drawableRes: Int) = InlineTextContent(
    Placeholder(12.sp, 12.sp, PlaceholderVerticalAlign.TextTop)
) {
    Icon(
        painter = painterResource(id = drawableRes),
        modifier = Modifier
            .size(12.dp),
        contentDescription = "",
        tint = MovieBoxTheme.colors.details.textPrimary
    )
}

@Composable
private fun InfoBlock(title: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MovieBoxTheme.typography.textMedium,
            color = MovieBoxTheme.colors.details.textPrimary
        )

        Text(
            text = description,
            style = MovieBoxTheme.typography.captionMedium,
            color = MovieBoxTheme.colors.details.textSecondary
        )
    }
}

@Composable
private fun CreditsBlock(
    casts: List<MovieDetails.Cast>,
    totalAmount: Int,
    modifier: Modifier = Modifier
) {
    Row {
        Row(
            modifier = modifier
                .clip(CircleShape)
                .clickableWithSimpleRipple { /* no-op */ }
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy((-8).dp)
        ) {
            casts.take(n = 5).forEach { cast ->
                AsyncImage(
                    model = cast.profilePath?.build(size = ProfilePath.Size.Width45),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .border(
                            width = 2.dp,
                            color = MovieBoxTheme.colors.details.background,
                            shape = CircleShape
                        )
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(MovieBoxTheme.colors.details.placeholderBg),
                    placeholder = getSmallProfilePlaceholder(isLight = MovieBoxTheme.colors.isLight),
                    error = getSmallProfilePlaceholder(isLight = MovieBoxTheme.colors.isLight)
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(32.dp)
                    .border(
                        width = 2.dp,
                        color = MovieBoxTheme.colors.details.background,
                        shape = CircleShape
                    )
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(MovieBoxTheme.colors.details.placeholderBg)
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "More",
                    style = MovieBoxTheme.typography.captionMedium,
                    color = MovieBoxTheme.colors.details.textPlaceholder,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (totalAmount > 5) {
            Text(
                text = "+ $totalAmount Cast (including crew)",
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MovieBoxTheme.colors.details.textPrimary,
                style = MovieBoxTheme.typography.captionMedium
            )
        }
    }
}
