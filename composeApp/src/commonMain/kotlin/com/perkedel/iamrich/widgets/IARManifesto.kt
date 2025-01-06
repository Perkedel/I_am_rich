package com.perkedel.iamrich.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.iar_congratulations
import com.perkedel.iamrich.R.iar_manifesto
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun IARManifesto(
    modifier: Modifier = Modifier,
    scrollable:Boolean = false,
){
    val withScrolableModifier = if(scrollable){
        modifier.verticalScroll(rememberScrollState())
    }else{
        modifier
    }
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(Res.string.iar_manifesto),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = stringResource(Res.string.iar_congratulations),
            fontSize = 8.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.padding(32.dp)
        )
    }
}