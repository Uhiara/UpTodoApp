package com.example.mytodoapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mytodoapplication.R
import com.example.mytodoapplication.ui.components.ButtonComponent
import com.example.mytodoapplication.ui.components.TextButtonComponent
import com.example.mytodoapplication.ui.components.TextComponent
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen4(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            Spacer(modifier = Modifier.weight(0.05f))

            TextButton(
                onClick = {
                    navController.navigate(Routes.ON_BOARDING_SCREEN_3)
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "back"
                )
            }

            Spacer(modifier = Modifier.weight(0.04f))

            TextComponent(
                modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                textValue = "Welcome to UpTodo",
                textSize = 32.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                colorValue = colorResource(id = R.color.display_small),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.padding(24.dp))

            TextComponent(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                textValue = "Please login to your account or create new account to continue",
                textSize = 16.sp,
                fontWeight = FontWeight(400),
                colorValue = colorResource(id = R.color.text_medium),
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.weight(0.8f))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                ButtonComponent(text = "LOGIN",
                    onClick = {
                        navController.navigate(Routes.LOGIN_SCREEN)
                    }
                )

                Spacer(modifier = Modifier.padding(8.dp))

                TextButtonComponent(text = "CREATE ACCOUNT",
                    onClick = {
                        navController.navigate(Routes.REGISTRATION_SCREEN)
                    }
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))

        }
    }
}

@Preview
@Composable
fun OnBoardingScreen4Preview() {
    OnBoardingScreen4(rememberNavController())
}