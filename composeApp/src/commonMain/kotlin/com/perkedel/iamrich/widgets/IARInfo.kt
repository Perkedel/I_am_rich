@file:OptIn(ExperimentalLayoutApi::class)

package com.perkedel.iamrich.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun IARInfo(
    modifier: Modifier = Modifier,
    onNavBack:()->Unit = {},
    versionString:String = stringResource(Res.string.version),
){
    val localUriHandler = LocalUriHandler.current
//    val view:View = LocalView.current
    val sourceCodeUrl = stringResource(Res.string.source_code_url)
    val websiteUrl = stringResource(Res.string.website_url)
    DownloadCarDetector()
    Spacer(
        modifier = Modifier.padding(32.dp)
    )
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        // https://developer.android.com/develop/ui/compose/layouts/flow
        Button(
            onClick = {
//                navController.navigateUp()
                onNavBack()
            },
        ){
            Icon(Icons.AutoMirrored.Default.ArrowBack,"")
            Spacer(
                modifier = Modifier.padding(8.dp)
            )
            Text(stringResource(Res.string.back_button))
        }
        Button(
            onClick = {
                // TODO: open Github
                // https://appkickstarter.com/blog/open-url-compose-multiplatform YES WORK
                // https://www.repeato.app/opening-a-url-in-androids-web-browser-from-your-application/
                // https://stackoverflow.com/questions/3004515/sending-an-intent-to-browser-to-open-specific-url
                localUriHandler.openUri(sourceCodeUrl)
            },
        ){
            Icon(Icons.Default.Code,"")
            Spacer(
                modifier = Modifier.padding(8.dp)
            )
            Text(stringResource(Res.string.source_code_button))
        }
//        Button(
//            onClick = {
//
//            },
//        ){
//            Icon(Icons.Default.Code,"")
//            Spacer(
//                modifier = Modifier.padding(8.dp)
//            )
//            Text(stringResource(Res.string.source_code_button))
//        }
        Button(
            onClick = {
                localUriHandler.openUri(websiteUrl)
            },
        ) {
            Icon(Icons.Default.Web, "")
            Spacer(
                modifier = Modifier.padding(8.dp)
            )
            Text(stringResource(Res.string.website_button))
        }

    }
    Spacer(
        modifier = Modifier.padding(32.dp)
    )
    Text(
        text = stringResource(Res.string.iar_disclaimer)
    )
    Text(
        text = stringResource(Res.string.iar_disclaimer_long)
    )
    Spacer(
        modifier = Modifier.padding(32.dp)
    )
//    Text("Ver ${stringResource(Res.string.version)}")
    Text("Ver ${versionString}")
}