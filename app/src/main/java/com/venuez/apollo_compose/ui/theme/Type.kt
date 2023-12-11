package com.venuez.apollo_compose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.venuez.apollo_compose.R

// Declare the font families
object AppFont {
    val Poppins_Font = FontFamily(
        Font(R.font.poppins_light),
        Font(R.font.poppins_light_italic, style = FontStyle.Italic),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_medium_italic, FontWeight.Medium, style = FontStyle.Italic),
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_bold_italic, FontWeight.Bold, style = FontStyle.Italic)
    )
}

private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.Poppins_Font),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.Poppins_Font),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.Poppins_Font),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Poppins_Font),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.Poppins_Font),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.Poppins_Font),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.Poppins_Font),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.Poppins_Font),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.Poppins_Font),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.Poppins_Font),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.Poppins_Font),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.Poppins_Font),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.Poppins_Font),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.Poppins_Font),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.Poppins_Font)
)