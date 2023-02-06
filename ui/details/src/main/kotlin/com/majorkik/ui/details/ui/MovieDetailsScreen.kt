package com.majorkik.ui.details.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arrow.core.getOrElse
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.majorkik.common.AppDateFormat
import com.majorkik.core.localization.StringResource
import com.majorkik.core.ui.CoreDrawable
import com.majorkik.core.ui.components.getSmallProfilePlaceholder
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MBTheme
import com.majorkik.tmdb.api.model.BackdropPath
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.model.ProfilePath
import com.majorkik.tmdb.api.model.movieDetailsPreview
import com.ramcosta.composedestinations.annotation.Destination
import com.soywiz.klock.Date
import io.dokar.expandabletext.ExpandableText
import org.koin.androidx.compose.getViewModel

@Destination(navArgsDelegate = MovieDetailsNavArgs::class)
@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel = getViewModel()) {
    val state by viewModel.container.stateFlow.collectAsState()

    MovieDetailsScreen(state)
}

@Composable
internal fun MovieDetailsScreen(state: MovieDetailsViewState) {
    when (state.screen) {
        is State.MovieDetailsState -> MovieDetailsContent(details = state.screen.data)
        else -> ErrorStateContent()
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailsContent(details: MovieDetails) {
    var overviewExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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

        // Movie title
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = details.title,
                color = MBTheme.colors.text.primary,
                style = MBTheme.typography.header.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )

            // Release date + status
            ReleaseDate(
                releaseDate = details.releaseDate,
                releaseStatus = details.status,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // Genres
            Text(
                text = details.genres.joinToString { genre -> genre.name.capitalize(Locale.current) },
                color = MBTheme.colors.text.primary,
                style = MBTheme.typography.body.medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .clickableWithSimpleRipple {
                        /* no-op */
                    }
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 2.dp)
            )
        }

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
                    backgroundColor = MBTheme.colors.background.accent,
                    contentColor = MBTheme.colors.text.primaryOnDark
                )
            ) {
                Text(
                    text = stringResource(StringResource.details_will_watch),
                    maxLines = 1,
                    style = MBTheme.typography.header.titleSmall,
                )
            }

            Surface(
                onClick = { },
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(12.dp),
                color = MBTheme.colors.background.elevation1
            ) {
                Icon(
                    painter = painterResource(id = CoreDrawable.ic_options_black_24),
                    contentDescription = null,
                    tint = MBTheme.colors.foreground.infoAccent,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(12.dp)
                )
            }

            Surface(
                onClick = { },
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(12.dp),
                color = MBTheme.colors.background.elevation1
            ) {
                Icon(
                    painter = painterResource(id = CoreDrawable.ic_round_favorite_black_24),
                    contentDescription = null,
                    tint = MBTheme.colors.foreground.infoAccent,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(16.dp)
                )
            }
        }

        // Overview
        ExpandableText(
            text = details.overview ?: "",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .animateContentSize()
                .clickable { overviewExpanded = !overviewExpanded },
            style = MBTheme.typography.body.textMedium,
            color = MBTheme.colors.text.primary,
            maxLines = 3,
            expanded = overviewExpanded,
            toggleContent = {
                @StringRes val textRes = if (overviewExpanded) {
                    StringResource.details_show_less
                } else {
                    StringResource.details_show_more
                }

                Text(
                    text = " " + stringResource(textRes),
                    style = MBTheme.typography.body.textMedium,
                    color = MBTheme.colors.background.accent
                )
            }
        )

        // Tagline
        Tagline(tagline = details.tagline)

        // Credits
        CreditsBlock(
            casts = details.casts,
            totalAmount = details.casts.count() + details.crews.count(),
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        // Budget & Revenue
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            InfoBlock(
                title = stringResource(
                    StringResource.details_revenue_slash_budget_value,
                    details.revenue,
                    details.budget
                ),
                description = stringResource(StringResource.details_revenue_slash_budget),
                modifier = Modifier.padding(horizontal = 16.dp)

            )

            InfoBlock(
                title = details.originalTitle,
                description = stringResource(StringResource.details_original_title),
                modifier = Modifier.padding(horizontal = 16.dp)

            )
        }
    }
}

@Composable
private fun ErrorStateContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(StringResource.error_state))
    }
}

@Composable
private fun ReleaseDate(releaseDate: Date?, releaseStatus: String?, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = AppDateFormat.parseReadableDate(releaseDate).getOrElse { "" },
            color = MBTheme.colors.text.primary,
            style = MBTheme.typography.body.medium
        )

        if (releaseStatus != null) {
            Text(
                text = releaseStatus,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(MBTheme.colors.background.opposite)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = MBTheme.colors.text.primaryOnOpposite,
                style = MBTheme.typography.body.medium
            )
        }
    }
}

@Composable
private fun Tagline(tagline: String?) {
    val quoteLeadingId = "quote_leading_id"
    val quoteTrailingId = "quote_trailing_id"

    val inlineContentMap = mapOf(
        quoteLeadingId to buildQuoteInlineContent(CoreDrawable.ic_quote_leading_yellow_12),
        quoteTrailingId to buildQuoteInlineContent(CoreDrawable.ic_quote_trailing_yellow_12),
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
                .background(MBTheme.colors.background.elevation1)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = annotatedString,
                style = MBTheme.typography.body.text,
                modifier = Modifier.align(Alignment.CenterVertically),
                inlineContent = inlineContentMap,
                color = MBTheme.colors.text.primary
            )
        }
    }
}

private fun buildQuoteInlineContent(@DrawableRes drawableRes: Int) = InlineTextContent(
    Placeholder(12.sp, 12.sp, PlaceholderVerticalAlign.TextTop)
) {
    Icon(
        painter = painterResource(id = drawableRes),
        modifier = Modifier.size(12.dp),
        contentDescription = "",
        tint = MBTheme.colors.text.primary
    )
}

@Composable
private fun InfoBlock(title: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MBTheme.typography.body.textMedium,
            color = MBTheme.colors.text.primary
        )

        Text(
            text = description,
            style = MBTheme.typography.ui.captionMedium,
            color = MBTheme.colors.text.secondary
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
                            color = MBTheme.colors.background.base,
                            shape = CircleShape
                        )
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(MBTheme.colors.background.opposite),
                    placeholder = getSmallProfilePlaceholder(isLight = MBTheme.colors.isLight),
                    error = getSmallProfilePlaceholder(isLight = MBTheme.colors.isLight)
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(32.dp)
                    .border(
                        width = 2.dp,
                        color = MBTheme.colors.background.base,
                        shape = CircleShape
                    )
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(MBTheme.colors.background.opposite)
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = stringResource(StringResource.common_more),
                    style = MBTheme.typography.ui.captionMedium,
                    color = MBTheme.colors.text.primaryOnDark,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (totalAmount > 5) {
            Text(
                text = stringResource(StringResource.details_casts_count_plus, totalAmount),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MBTheme.colors.text.primary,
                style = MBTheme.typography.ui.captionMedium,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun MovieDetailsPreview() {
    MBTheme(isDark = false) {
        MovieDetailsScreen(
            state = MovieDetailsViewState(
                screen = State.MovieDetailsState(
                    data = movieDetailsPreview()
                )
            )
        )
    }
}
