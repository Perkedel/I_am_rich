package com.perkedel.iamrich.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme

@Composable
actual fun HTLauncherTheme(
    darkTheme: Boolean ,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean ,
    content: @Composable () -> Unit
) {
    // http://material-foundation.github.io?primary=%230052EB&bodyFont=Ubuntu&displayFont=Ubuntu&colorMatch=true
    MaterialTheme(
        colorScheme = rememberColorScheme(
            darkTheme = darkTheme,
            dynamicColor = dynamicColor,
        ),
        typography = Typography,
        content = content
    )
}

//enum class ForceColorScheme {
//    Light, Dark
//}

@Composable
actual fun rememberColorScheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    forceTheme: Boolean ,
    forceLightDark:Boolean ,
    forceDark:Boolean ,
    darkVoidBackground:Boolean ,
): ColorScheme {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !forceTheme-> {
            val context = LocalContext.current
            if(darkVoidBackground){
                if (darkTheme || (forceLightDark && forceDark)) dynamicDarkColorScheme(context).copy(background = Color.Black) else dynamicLightColorScheme(context)
            } else {
                if (darkTheme || (forceLightDark && forceDark)) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }
        }

        darkTheme || (forceLightDark && forceDark) -> DarkColorScheme
        else -> LightColorScheme
    }
    return colorScheme
}