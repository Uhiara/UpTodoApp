package com.example.mytodoapplication.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mytodoapplication.R
import com.example.mytodoapplication.ui.components.CommonButton
import com.example.mytodoapplication.ui.components.CommonTextButton
import com.example.mytodoapplication.ui.components.ImageComponent
import com.example.mytodoapplication.ui.components.PageIndicator
import com.example.mytodoapplication.ui.components.TextComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen1(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    currentPage: Int,
) {
    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
        ) {

            Spacer(modifier = Modifier.weight(0.1f))

            val pagerState = rememberPagerState(initialPage = 0) {
                2
            }
            val buttonState = remember {
                derivedStateOf {
                    if (pagerState.currentPage == 0) {
                        listOf("", "Next")
                    } else listOf("", "")
                }
            }

            val skipScope = rememberCoroutineScope()

            CommonTextButton(text = "Skip",
                onClick = {
                    skipScope.launch {
                        navController.navigate(Routes.ON_BOARDING_SCREEN_4)
                    }
                })


            ImageComponent(imageValue = R.drawable.onboarding1)

            Spacer(modifier = Modifier.weight(0.3f))

            PageIndicator(
                modifier = Modifier.fillMaxWidth(),
                pageSize = 3,
                selectedPage = currentPage
            )

            Spacer(modifier = Modifier.weight(0.3f))

            TextComponent(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                textValue = "Manage your tasks",
                textSize = 32.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                colorValue = colorResource(id = R.color.display_small),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.weight(0.3f))

            TextComponent(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                textValue = "You can easily manage all of your daily tasks in DoMe for free",
                textSize = 16.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                colorValue = colorResource(id = R.color.text_medium),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    val scope = rememberCoroutineScope()
                    CommonTextButton(text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    CommonButton(text = buttonState.value[1],
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 3) {
                                    //TODO: Navigate to Home Screen
                                } else {
                                    navController.navigate(Routes.ON_BOARDING_SCREEN_2)
                                }
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}

@Preview
@Composable
fun OnBoardingScreen1Preview() {
    OnBoardingScreen1(
        rememberNavController(),
        modifier = Modifier.fillMaxSize(),
        currentPage = 0
    )
}