package com.example.etechcollectionapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.LightGreen
import com.example.e_techcollectionapp.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = DarkGreen,
    secondary = LightGreen
)

private val LightColorScheme = lightColorScheme(
    primary = DarkGreen,
    secondary = LightGreen
)

@Composable
fun EtechCollectionAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
