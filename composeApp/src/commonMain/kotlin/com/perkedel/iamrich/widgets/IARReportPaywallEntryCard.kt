@file:OptIn(ExperimentalFoundationApi::class)

package com.perkedel.iamrich.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.anti_paywallism_Button
import com.perkedel.iamrich.R.anti_paywallism_clickHere
import com.perkedel.iamrich.R.anti_paywallism_reportButton
import com.perkedel.iamrich.R.anti_paywallism_reportContact
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun IARReportPaywallEntryCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onLongClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
//            .combinedClickable(
//                onClick = onClick,
//                onLongClick = onLongClick,
//            )
    ){
        Row {
            Box(
                modifier = Modifier.sizeIn(
                    maxWidth = 48.dp,
                    maxHeight = 48.dp,
                )
            ){
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column {
                Text(
                    text = stringResource(Res.string.anti_paywallism_Button),
//                    text = "AA\nBB",
                )
                Button(
                    onClick = onClick,
                ){
                    Text(
                        text = stringResource(Res.string.anti_paywallism_clickHere)
                    )
                }
            }
        }
    }
}