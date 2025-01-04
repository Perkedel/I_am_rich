@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class,
    ExperimentalLayoutApi::class
)

package com.perkedel.iamrich

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.perkedel.iamrich.R.Res
import com.perkedel.iamrich.R.app_name
import com.perkedel.iamrich.R.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.perkedel.iamrich.ui.theme.HTLauncherTheme
import com.perkedel.iamrich.ui.theme.rememberColorScheme
import com.perkedel.iamrich.widgets.DownloadCarDetector
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
//import androidx.compose.ui.platform.LocalContext

@Composable
@Preview
fun App(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
) {
    // https://github.com/philipplackner/ContactsComposeMultiplatform
    // https://youtu.be/XWSzbMnpAgI
    // https://youtu.be/vvP5vnmzY84
    // https://stackoverflow.com/a/29092698/9079640
    // https://youtu.be/WT9-4DXUqsM
    // https://github.com/philipplackner/CMP-Bookpedia/tree/master
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen:String = backStackEntry?.destination?.route ?: "main"
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val canNavigateBack:Boolean = navController.previousBackStackEntry != null
//    val view: View = LocalView.current
    HTLauncherTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor,
    ) {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
        Surface {
            Scaffold(
                modifier = Modifier,
                topBar = {
                    TopAppBar(
                        modifier = Modifier,
                        title = {
                            Text(text = when{
                                currentScreen == "main" -> stringResource(Res.string.app_name_translatable)
                                else -> stringResource(Res.string.app_name_translatable)
                            })
                        },
                        navigationIcon = {
                            if(canNavigateBack){
                                IconButton(
                                    onClick = {
//                                        view.playSoundEffect(SoundEffectConstants.CLICK)
                                        navController.navigateUp()
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                        contentDescription = stringResource(Res.string.back_button)
                                    )
                                }
                            }
                        }
                    )
                },
                snackbarHost = {
                    // https://developer.android.com/develop/ui/compose/components/snackbar
                    // https://youtu.be/_yON9d9if6g?si=l5HVadsldckAuErk
                    SnackbarHost(
                        hostState = snackbarHostState
                    )
                },
            ) { innerPadding ->
                SharedTransitionLayout {
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                    ){
                        composable(
                            route = "main",
//                            exitTransition = {
//                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .fillMaxSize()
                                ,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(64.dp)
                                    ,
                                    imageVector = Icons.Default.Diamond,
                                    contentDescription = ""
                                )
                                Text(
//                        text = "I am rich",
                                    text = stringResource(Res.string.app_name_translatable),
//                        text = getString(Res.string.app_name),
                                )
                                Spacer(
                                    modifier = Modifier.padding(16.dp)
                                )
                                Button(
                                    onClick = {
                                        navController.navigate("info")
                                    }
                                ){
                                    Icon(Icons.Default.Info,"")
                                    Spacer(
                                        modifier = Modifier.padding(8.dp)
                                    )
                                    Text("Info")
                                }
                            }
                        }
                        composable(
                            route = "info"
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .fillMaxSize()
                                ,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = stringResource(Res.string.iar_manifesto),
                                    fontSize = 32.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                    )
                                Spacer(
                                    modifier = Modifier.padding(16.dp)
                                )
                                Text(
                                    text = stringResource(Res.string.iar_congratulations),
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Spacer(
                                    modifier = Modifier.padding(32.dp)
                                )
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
                                            navController.navigateUp()
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
                                        },
                                    ){
                                        Icon(Icons.Default.Code,"")
                                        Spacer(
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        Text(stringResource(Res.string.source_code_button))
                                    }
                                    Button(
                                        onClick = {

                                        },
                                    ){
                                        Icon(Icons.Default.Code,"")
                                        Spacer(
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        Text(stringResource(Res.string.source_code_button))
                                    }

                                }
                                Text("Ver ${stringResource(Res.string.version)}")
                            }
                        }
                    }
                }

            }
        }


//        Surface(
//            modifier = Modifier.fillMaxSize().navigationBarsPadding().statusBarsPadding(),
////            color = rememberColorScheme(
////                darkTheme = darkTheme,
////                dynamicColor = dynamicColor,
////            ).background
//        ) {
//            Column {
//                Icon(Icons.Default.Diamond, "")
//                Text(
//                    "I am rich",
//
//                )
//            }
//        }

    }
}