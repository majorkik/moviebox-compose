package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.CoreDrawable
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.core.ui.theme.MBTheme

@Composable
internal fun Toolbar(onLoginClick: () -> Unit, onOpenSettings: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LoginButton(onLoginClick)

        IconButton(onClick = onOpenSettings) {
            Icon(
                painter = painterResource(id = CoreDrawable.ic_nut_bolt_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.background.opposite
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    MBTheme {
        Box {
            Toolbar(
                onLoginClick = {},
                onOpenSettings = {}
            )
        }
    }
}
