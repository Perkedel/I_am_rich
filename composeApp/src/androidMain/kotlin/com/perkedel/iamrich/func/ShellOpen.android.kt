package com.perkedel.iamrich.func

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
//import androidx.core.content.ContextCompat.startActivity
import org.jetbrains.compose.resources.getString

actual fun shellOpenUri(uri: String) {
//    startIntent(Intent.ACTION_VIEW, Uri.parse(uri))
    val i = Intent(Intent.ACTION_VIEW)
    i.setData(Uri.parse(uri))
//    startActivity(i)

}