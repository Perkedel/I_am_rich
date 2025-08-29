package com.perkedel.iamrich.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.anti_paywallism_Description
import com.perkedel.iamrich.R.anti_paywallism_Title
import com.perkedel.iamrich.R.anti_paywallism_reportButton
import com.perkedel.iamrich.R.anti_paywallism_reportContact
import com.perkedel.iamrich.R.anti_paywallism_reportContact_post
import com.perkedel.iamrich.R.anti_paywallism_reportContact_template
import com.perkedel.iamrich.R.anti_paywallism_reportEmail
import com.perkedel.iamrich.R.anti_paywallism_reportTemplate
import com.perkedel.iamrich.R.anti_paywallism_reportURL
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun IARReportPaywallForm(
//    padding: PaddingValues = PaddingValues(),
    modifier: Modifier = Modifier
//        .padding(padding)
    ,
    isCompact:Boolean = false,
) {
    val localUriHandler = LocalUriHandler.current
    val reportURL = stringResource(Res.string.anti_paywallism_reportURL)
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.anti_paywallism_Title),
        )
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = stringResource(Res.string.anti_paywallism_Description),
        )
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        if(isCompact){
            // usual vertical stack
        } else {
            // TODO: make below cards side by side
        }
        Card(
            modifier = Modifier,
        ){
            Column(){
                Text(
                    text = stringResource(Res.string.anti_paywallism_reportButton),
                    fontSize = 24.sp
                )
                Button(
                    onClick = {
                        localUriHandler.openUri(reportURL)
                    }
                ){
                    Text(
                        stringResource(Res.string.anti_paywallism_reportURL),
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        Card(
            modifier = Modifier,
        ){
            Column(){
                Text(
                    text = stringResource(Res.string.anti_paywallism_reportContact),
                    fontSize = 24.sp
                )
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                    ,
                ){
                    Text(
                        text = stringResource(Res.string.anti_paywallism_reportEmail),
                        fontSize = 32.sp
                    )
                }
                Text(
                    text = stringResource(Res.string.anti_paywallism_reportContact_post),
                    fontSize = 8.sp
                )
                Spacer(
                    modifier = Modifier.padding(12.dp)
                )

                Text(
                    text = stringResource(Res.string.anti_paywallism_reportContact_template),
                    fontSize = 24.sp
                )
                TextField(
                    modifier = Modifier,
                    placeholder = {
                        Text("")
                    },
//                    enabled = false,
                    readOnly = true,
                    value = stringResource(Res.string.anti_paywallism_reportTemplate),
                    onValueChange = {},
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                // copy this whole string to clipboard
                            },
                            modifier = Modifier,
                        ){
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "",
                            )
                        }
                    }
                )
            }
        }
    }
}