package com.perkedel.iamrich.func

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
actual fun VersionString():String{
    val pm:android.content.pm.PackageManager = LocalContext.current.packageManager
    val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        pm.getPackageInfo(LocalContext.current.packageName, 0).longVersionCode
    } else {
        pm.getPackageInfo(LocalContext.current.packageName, 0).versionCode.toLong()
    }
    val versionName = pm.getPackageInfo(LocalContext.current.packageName, 0).versionName
    return "$versionName (itt. $versionCode)"
}