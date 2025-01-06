package com.perkedel.iamrich.func

import androidx.compose.runtime.Composable
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.version
import org.jetbrains.compose.resources.stringResource

@Composable
actual fun VersionString(): String {
    return stringResource(Res.string.version)
}