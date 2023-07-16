package com.example.dountappcompose.presentation.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dountappcompose.R
import com.example.dountappcompose.Screens
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.background_color
import com.example.dountappcompose.ui.theme.bodyLarge
import com.example.dountappcompose.ui.theme.labelLarge
import com.example.dountappcompose.ui.theme.primary_color
import com.example.dountappcompose.ui.theme.secondary_color
import com.example.dountappcompose.ui.theme.text_color100
import com.example.dountappcompose.ui.theme.titleXLarge
@Composable
fun OnBoardingScreen(
    navController: NavHostController
){
    OnBoardingContent(){
        navController.navigate(Screens.Home.route)
    }
}

@Composable
fun OnBoardingContent(
    onClickGetStarted: () -> Unit={}
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
            .fillMaxSize()
            .background(color = background_color)){
        ConstraintLayout() {
            val (purpleDonutImg
                    ,pinkDonutImg
                    , donutsImg,gonutText
                    ,smallDonutImg,halfDonutImg,textBody,button) = createRefs()
            Image(painter = painterResource(id = R.drawable.purpledonut)
                , contentDescription =" "
                ,
                Modifier
                    .size(186.dp)
                    .constrainAs(purpleDonutImg) {
                        top.linkTo(parent.top, margin = -(18.dp))
                    })
            Image(painter = painterResource(id = R.drawable.pink_donut)
                , contentDescription =" "
                ,
                Modifier
                    .height(155.dp)
                    .width(210.dp)
                    .constrainAs(pinkDonutImg) {
                        start.linkTo(purpleDonutImg.end, margin = 8.dp)
                        top.linkTo(parent.top, margin = 24.dp)
                    })
            Image(painter = painterResource(id = R.drawable.dounts)
                , contentDescription =" "
                , Modifier
                    .width(900.dp)
                    .height(600.dp)
                    .constrainAs(donutsImg) {
                        top.linkTo(parent.top, margin = -(16.dp))
                    })
            Image(painter = painterResource(id = R.drawable.small_donut)
                , contentDescription =" "
                , Modifier
                    .width(94.dp)
                    .height(69.dp)
                    .constrainAs(smallDonutImg) {
                        top.linkTo(purpleDonutImg.bottom, margin = (120.dp))
                        start.linkTo(parent.start, margin = 24.dp)
                    })
            Text(text = stringResource(R.string.gonuts_with_donuts)
                , color = primary_color
                , modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(0.6f)
                    .padding(start = 24.dp)
                    .constrainAs(gonutText) {
                        top.linkTo(donutsImg.bottom, margin = -(180.dp))

                    }, style = titleXLarge)
            Image(painter = painterResource(id = R.drawable.half2)
                , contentDescription =" "
                , Modifier
                    .width(209.dp)
                    .height(165.dp)
                    .constrainAs(halfDonutImg) {
                        top.linkTo(gonutText.top, margin = -(16.dp))
                        end.linkTo(parent.end, margin = -(50.dp))
                    })
            Text(text = stringResource(R.string.on_boarding_text)
                , color = secondary_color
                , modifier = Modifier
                    .width(348.dp)
                    .constrainAs(textBody) {
                        top.linkTo(gonutText.bottom)
                        start.linkTo(gonutText.start, margin = 24.dp)
                    }, style = bodyLarge)
            Button(onClickGetStarted
                , modifier = Modifier
                    .width(348.dp)
                    .height(67.dp)
                    .constrainAs(button) {
                        top.linkTo(textBody.bottom, margin = 30.dp)
                        centerHorizontallyTo(parent)
                    }
                ,colors = ButtonDefaults.buttonColors(White)) {
                Text(text = stringResource(R.string.get_started)
                    , style = labelLarge, color = text_color100)
            }

        }
    }
}
@Preview
@Composable
fun OnBoardingPreview(){
    OnBoardingContent()
}