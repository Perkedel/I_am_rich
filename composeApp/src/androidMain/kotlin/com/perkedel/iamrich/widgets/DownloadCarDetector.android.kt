package com.perkedel.iamrich.widgets

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.*
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
actual fun DownloadCarDetector() {
    // https://stackoverflow.com/a/70421558/9079640
    // https://stackoverflow.com/a/10809481/9079640
    // https://stackoverflow.com/a/23263067/9079640

    val context = LocalContext.current
    val pm = context.packageManager

    val selfInfo = pm.getApplicationInfo(context.packageName, 0)
    var selfInstalledFrom:String = ""
    var namedInstaller:String = "RepoStore"
    var reactionSpeech:String = "Oh Hai Install what"
    var whoCares:String = "bla bla bla"

    try{
        selfInstalledFrom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            pm.getInstallSourceInfo(context.packageName).installingPackageName
        } else {
            pm.getInstallerPackageName(context.packageName)
        } ?: "---"
    } catch (e: Exception){
        selfInstalledFrom = "___"
        e.printStackTrace()
    }

    try {
//        namedInstaller = when(selfInstalledFrom){
//            "com.android.vending" -> "Google Play"
//            "com.amazon.venezia" -> "Amazon App Store"
////        "com.huawei.appmarket" -> "Huawei App Gallery"
////        "com.oppo.market" -> "OPPO App Market"
////        "com.samsung.android.appmarket" -> "Samsung App Market"
////        "com.xiaomi.market" -> "Xiaomi App Market"
////        "com.vivo.appstore" -> "Vivo App Store"
////        "com.sonyericsson.home" -> "Sony App Store"
////        "com.lge.appstore" -> "LG App Store"
//            "com.google.android.packageinstaller" -> "Manually APK"
//            "com.whatsapp" -> "WhatsApp Attachment"
////        "org.telegram.messenger" -> "Telegram Attachment"
//            "org.mozilla.firefox" -> "Mozilla Firefox"
//            "org.android.chrome" -> "Google Chrome"
//            else -> pm.getApplicationLabel(pm.getApplicationInfo(selfInstalledFrom,0)).toString()
//        }
        namedInstaller =
            if(selfInstalledFrom != "---")
                pm.getApplicationLabel(pm.getApplicationInfo(selfInstalledFrom,0)).toString()
            else "???"
    } catch (e:Exception){
        namedInstaller = "___"
        e.printStackTrace()
    }

    reactionSpeech = when(selfInstalledFrom){
        "com.android.vending" -> stringResource(Res.string.install_reaction_google_play)
        "com.amazon.venezia" -> stringResource(Res.string.install_reaction_unknown)
        else -> stringResource(Res.string.install_reaction_unknown)
    }
    whoCares = when(selfInstalledFrom){
        "com.android.vending" -> stringResource(Res.string.nah_who_cares_google_play)
        else -> stringResource(Res.string.nah_who_cares_unknown)
    }
    try {

    } catch (e:Exception){
        reactionSpeech = Res.string.install_reaction_unknown.toString()
        whoCares = Res.string.install_reaction_unknown.toString()
        e.printStackTrace()
    }

    Card(
    ) {
        Box(
            modifier = Modifier.padding(8.dp)
        ){
            Column {
                Text("Installed From ${namedInstaller} (${selfInstalledFrom})")
                Spacer(
                    modifier = Modifier.padding(8.dp)
                )
                Text(text = reactionSpeech)
                Spacer(
                    modifier = Modifier.padding(2.dp)
                )
                Row {
                    Text(
                        text = stringResource(Res.string.nah_who_cares),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(
                    modifier = Modifier.padding(2.dp)
                )
                Text(text = whoCares)
            }
        }
    }
}