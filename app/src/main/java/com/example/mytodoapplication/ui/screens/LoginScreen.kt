package com.example.mytodoapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mytodoapplication.R
import com.example.mytodoapplication.ui.components.ButtonComponent
import com.example.mytodoapplication.ui.components.PasswordTextFieldComponent
import com.example.mytodoapplication.ui.components.SocialMediaLogin
import com.example.mytodoapplication.ui.components.TextComponent
import com.example.mytodoapplication.ui.components.TextFieldComponent
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            Spacer(modifier = Modifier.weight(0.2f))

            TextButton(
                onClick = {
                    scope.launch {
                        navController.navigate(Routes.ON_BOARDING_SCREEN_4)
                    }
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "back"
                )
            }

            Spacer(modifier = Modifier.weight(0.4f))

            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                textValue = "Login",
                textSize = 32.sp,
                fontWeight = FontWeight(700),
                colorValue = colorResource(id = R.color.text_medium),
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                textAlign = TextAlign.Start,
            )

            Spacer(modifier = Modifier.weight(0.6f))

            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                textValue = "Username",
                textSize = 16.sp,
                fontWeight = FontWeight(400),
                colorValue = colorResource(id = R.color.text_medium),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                textAlign = TextAlign.Start
            )

            TextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                labelValue = "Enter your username"
            )

            Spacer(modifier = Modifier.weight(0.3f))

            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                textValue = "Password",
                textSize = 16.sp,
                fontWeight = FontWeight(400),
                colorValue = colorResource(id = R.color.text_medium),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                textAlign = TextAlign.Start
            )

            PasswordTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                labelValue = "Password"
            )

            Spacer(modifier = Modifier.weight(0.65f))

            ButtonComponent(text = "Login",
                onClick = {
                    scope.launch {
                        //TODO: Navigate to Login Screen
                    }
                }
            )

            Spacer(modifier = Modifier.weight(0.35f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .size(1.dp)
                        .border(1.dp, color = colorResource(id = R.color.text_medium)),
                )

                Text(text = "or")

                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .size(1.dp)
                        .border(1.dp, color = colorResource(id = R.color.text_medium)),
                )
            }

            Spacer(modifier = Modifier.weight(0.35f))

            SocialMediaLogin(icon = R.drawable.google_logo, text = "Login with Google") {
                scope.launch {
                    //TODO: Navigate to Login Screen
                }
            }

            Spacer(modifier = Modifier.weight(0.2f))

            SocialMediaLogin(icon = R.drawable.apple, text = "Login with Apple") {
                scope.launch {
                    //TODO: Navigate to Login Screen
                }
            }

            Spacer(modifier = Modifier.weight(0.5f))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color =  colorResource(id = R.color.text_medium),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        )
                    ) {
                        append("Don't have account?")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.text_medium),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )
                    ) {
                        append(" ")
                        append("Register")
                    }
                })
            }

            Spacer(modifier = Modifier.weight(0.25f))
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}