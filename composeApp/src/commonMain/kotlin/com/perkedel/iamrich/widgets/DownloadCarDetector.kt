package com.perkedel.iamrich.widgets

//import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.*
import org.jetbrains.compose.resources.StringResource

@Composable
expect fun DownloadCarDetector()

enum class InstallReaction( val speech:StringResource = Res.string.install_reaction_unknown, val whoCares:StringResource = Res.string.nah_who_cares_unknown){
    UNKNOWN(speech = Res.string.install_reaction_unknown, whoCares = Res.string.nah_who_cares_unknown),
    GOOGLE_PLAY(speech = Res.string.install_reaction_google_play, whoCares = Res.string.nah_who_cares_google_play),
}