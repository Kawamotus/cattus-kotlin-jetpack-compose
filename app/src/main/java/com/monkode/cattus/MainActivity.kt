package com.monkode.cattus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.monkode.cattus.ui.theme.CattusTheme
import androidx.navigation.compose.rememberNavController

import com.monkode.cattus.routes.Navigation
import com.monkode.cattus.ui.screens.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CattusTheme { /**
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                } **/
                //LoginScreen()
                Navigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CattusTheme {
        Navigation()
    }
}