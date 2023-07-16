@file:Suppress("UNUSED_EXPRESSION")

package com.example.dountappcompose.presentation.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dountappcompose.R
import com.example.dountappcompose.composable.CustomFrame
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.bodySmall
import com.example.dountappcompose.ui.theme.labelLarge
import com.example.dountappcompose.ui.theme.labelSmall
import com.example.dountappcompose.ui.theme.light_blue
import com.example.dountappcompose.ui.theme.secondary_color
import com.example.dountappcompose.ui.theme.text_color100
import com.example.dountappcompose.ui.theme.text_color60

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainCard(modifier: Modifier = Modifier
             , icon: Painter = painterResource(id = R.drawable.pink_heart)
             ,image: Painter = painterResource(id = R.drawable.black_donut_main_card)
             ,colors: Color = light_blue
             ,text:String=  "strawberry_wheel_body"
             ,label:String=  "strawberry_wheel"
             ,priceAfterOffer:String= "20"
             ,price:String= "16"
             ,onClickMainCard :()-> Unit = {}
){
    Box(
        modifier
            .wrapContentHeight()
            .width(210.dp)){
        ConstraintLayout(modifier = Modifier.height(315.dp)) {
            val (imageCons,cardCons)= createRefs()
            Card(onClickMainCard,
                modifier
                    .width(175.dp)
                    .height(315.dp)
                    .constrainAs(cardCons) {
                        top.linkTo(parent.top)
                    }
                ,colors= CardDefaults.cardColors(colors)
                , shape = RoundedCornerShape(20.dp)
            ) {
                ConstraintLayout {
                    val (iconCons,labelCons,bodyCons,priceAfterOfferCons,priceCons)= createRefs()
                    CustomFrame(
                        modifier = Modifier.constrainAs(iconCons) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    ){
                        Icon(painter = icon
                            ,contentDescription =""
                            , tint = secondary_color
                            , modifier = Modifier.size(20.dp)

                        )
                    }
                    Text( label
                        , style = labelSmall
                        , modifier = Modifier.constrainAs(labelCons){
                        top.linkTo(iconCons.bottom, margin = 155.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                    })
                    Text(  text
                        , style = bodySmall
                        , color = text_color60
                        , maxLines = 3
                        , modifier =Modifier.width(140.dp).constrainAs(bodyCons){
                            top.linkTo(labelCons.bottom)
                            start.linkTo(parent.start, margin = 16.dp)
                        })
                    Text( "$$price"
                        , style = labelLarge
                        , color = text_color100
                        , modifier =Modifier.constrainAs(priceCons){
                            top.linkTo(bodyCons.bottom, margin = 4.dp)
                            end.linkTo(parent.end)
                        })
                    Text(  "$$priceAfterOffer"
                        , style = bodySmall.copy(textDecoration = TextDecoration.LineThrough)
                        , color = text_color60
                        , modifier =Modifier.constrainAs(priceAfterOfferCons){
                            bottom.linkTo(priceCons.bottom)
                            end.linkTo(priceCons.start, margin = 6.dp)
                        })

                }
            }
            Image(painter = image, contentDescription = ""
                ,modifier = Modifier
                    .size(138.dp)
                    .constrainAs(imageCons) {
                        top.linkTo(parent.top, margin = 32.dp)
                        start.linkTo(parent.start, margin = 80.dp)
                    })
        }
    }
}
@Preview
@Composable
fun Preview(){
    MainCard()
}
