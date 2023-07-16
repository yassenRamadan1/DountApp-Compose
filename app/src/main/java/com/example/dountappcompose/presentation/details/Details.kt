package com.example.dountappcompose.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dountappcompose.R
import com.example.dountappcompose.Screens
import com.example.dountappcompose.composable.BottomSheet
import com.example.dountappcompose.composable.CustomFrame
import com.example.dountappcompose.presentation.details.composable.IconBack
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.background_color
import com.example.dountappcompose.ui.theme.bodyMedium
import com.example.dountappcompose.ui.theme.labelLarge
import com.example.dountappcompose.ui.theme.labelMedium
import com.example.dountappcompose.ui.theme.primary_color
import com.example.dountappcompose.ui.theme.secondary_color
import com.example.dountappcompose.ui.theme.text_color100
import com.example.dountappcompose.ui.theme.text_color60
import com.example.dountappcompose.ui.theme.titleLarge

@Composable
fun DetailsScreen(
    navController: NavHostController
){
    DetailsScreenContent(){
        navController.popBackStack(Screens.Home.route, false)
    }
}
@Composable
fun DetailsScreenContent(
    onClickBack:()->Unit={}
){

    Column(horizontalAlignment = Alignment.CenterHorizontally
        , modifier = Modifier
            .fillMaxSize()
            .background(background_color)
        ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 24.dp)){
            IconBack (onClickBack)
        }
        Image(painter = painterResource(id = R.drawable.black_donut_main_card)
            , contentDescription =""
            , modifier = Modifier.size(300.dp)
        )
        ConstraintLayout() {
            val (cardCons)= createRefs()
            BottomSheet {
                Text(text = stringResource(id =R.string.strawberry_wheel)
                    , modifier = Modifier.padding(start = 38.dp,top=24.dp)
                    , style = titleLarge
                    , color = primary_color
                )
                Text(text = stringResource(R.string.about_gonut)
                    , modifier = Modifier.padding(start = 38.dp,top=16.dp)
                    , style = labelMedium
                    , color = text_color100
                )
                Text(text = stringResource(R.string.strawberry_wheel_body)
                    , modifier = Modifier
                        .padding(start = 38.dp)
                        .width(320.dp)
                    , style = bodyMedium
                    , color = text_color60
                )
                Text(text = stringResource(R.string.quantity)
                    , modifier = Modifier.padding(start = 38.dp,top=10.dp)
                    , style = labelMedium
                    , color = text_color100
                )
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                    Card(colors = CardDefaults.cardColors(White)
                        , elevation = CardDefaults.cardElevation(0.5.dp)
                        , modifier = Modifier.padding(start = 38.dp)
                    ){
                        CustomFrame(
                            shape = RoundedCornerShape(15.dp),
                            modifier= Modifier,
                            size = 45.dp,
                        ) {
                            Text(text = "-", style = titleLarge)
                        }
                    }
                    Card(colors = CardDefaults.cardColors(White)
                        , elevation = CardDefaults.cardElevation(0.5.dp)){
                        CustomFrame(
                            shape = RoundedCornerShape(15.dp),
                            modifier= Modifier,
                            size = 45.dp,
                        ) {
                            Text(text = "1", style = titleLarge)
                        }
                    }
                    Card(colors = CardDefaults.cardColors(White)
                        , elevation = CardDefaults.cardElevation(0.5.dp)){
                        CustomFrame(
                            shape = RoundedCornerShape(15.dp),
                            modifier= Modifier,
                            size = 45.dp,
                            color = Color.Black
                        ) {
                            Text(text = "+", style = titleLarge, color = White)
                        }
                    }
                }
                Row(modifier = Modifier.padding(start = 38.dp,top=10.dp)
                    , horizontalArrangement = Arrangement.spacedBy(26.dp)
                    ,verticalAlignment =Alignment.CenterVertically
                ) {
                    Text(text = "$16"
                        , style = titleLarge
                        , color = text_color100
                    )
                    Button(onClick = { /*TODO*/ }
                        , modifier = Modifier
                            .width(230.dp)
                            .height(67.dp)
                        , colors = ButtonDefaults.buttonColors(primary_color)
                    ) {
                        Text(text = "Add to card", style = labelLarge)
                    }
                }
            }
            Card(colors = CardDefaults.cardColors(White)
                , elevation = CardDefaults.cardElevation(0.75.dp)
                , modifier = Modifier.constrainAs(cardCons){
                    end.linkTo(parent.end, margin = 32.dp)
                    top.linkTo(parent.top, margin = -(22.5).dp)
                }
            ){
                CustomFrame(
                    shape = RoundedCornerShape(15.dp),
                    modifier= Modifier,
                    size = 45.dp,
                ) {
                    Icon(painter = painterResource(id = R.drawable.vector)
                        ,contentDescription =""
                        , tint = secondary_color
                        , modifier = Modifier.size(28.dp)

                    )
                }
            }
        }
    }

}
@Preview
@Composable
fun DetailsScreenPreview(){
    DetailsScreenContent()
}