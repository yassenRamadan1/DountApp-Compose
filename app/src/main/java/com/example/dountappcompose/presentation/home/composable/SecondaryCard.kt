package com.example.dountappcompose.presentation.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dountappcompose.R
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.bodySmall
import com.example.dountappcompose.ui.theme.labelSmall
import com.example.dountappcompose.ui.theme.labelXSmall
import com.example.dountappcompose.ui.theme.text_color60

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryCard(modifier: Modifier=Modifier
                  ,image: Painter = painterResource(id = R.drawable.che_secodary_card)
                  ,textReference:String= "strawberry_wheel"
                  , price:String="22"
                  ,onClickCard :() -> Unit={}){
    ConstraintLayout(modifier.height(170.dp)) {
        val (imageCons,cardCons)= createRefs()
        Card(shape = RoundedCornerShape( 20.dp,20.dp,10.dp,10.dp)
            , colors = CardDefaults.cardColors(White)
            , elevation = CardDefaults.cardElevation(1.dp)
            , onClick = onClickCard
            ,modifier = Modifier
                .width(138.dp)
                .height(111.dp)
                .constrainAs(cardCons) {
                    bottom.linkTo(parent.bottom)
                }
        )   {
            Column(modifier = Modifier.fillMaxSize()
                ,verticalArrangement = Arrangement.spacedBy(8.dp)
                , horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text =  textReference
                , style = labelXSmall
                , modifier = Modifier.padding(top = 40.dp)
                , color = text_color60
            )
            Text(text = "$$price"
                , style = bodySmall
                , color = text_color60
            )

            }

        }

        Image(painter = image, contentDescription = ""
            ,modifier = Modifier
                .size(104.dp)
                .constrainAs(imageCons) {
                    top.linkTo(parent.top, margin = 4.dp)
                    centerHorizontallyTo(parent)
                })

    }
}
@Preview
@Composable
fun PreviewCard(){
    SecondaryCard()
}