package com.example.dountappcompose.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dountappcompose.R
import com.example.dountappcompose.Screens
import com.example.dountappcompose.presentation.home.composable.MainCard
import com.example.dountappcompose.presentation.home.composable.SecondaryCard
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.bodyLarge
import com.example.dountappcompose.ui.theme.bodyMedium
import com.example.dountappcompose.ui.theme.bodySmall
import com.example.dountappcompose.ui.theme.frame_back_ground
import com.example.dountappcompose.ui.theme.labelLarge
import com.example.dountappcompose.ui.theme.primary_color
import com.example.dountappcompose.ui.theme.text_color100
import com.example.dountappcompose.ui.theme.text_color60
import com.example.dountappcompose.ui.theme.titleLarge

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    HomeScreenContent(state){
        navController.navigate(Screens.Details.route)
    }
}
@Composable
fun HomeScreenContent(
    homeUiState: HomeUiState= HomeUiState(),
    onClickCard: ()->Unit ={}
){
    Box(modifier = Modifier
        .fillMaxSize().padding(bottom = 52.dp)
        .background(White)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            ,contentPadding= PaddingValues(vertical = 42.dp)
        ){
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(115.dp)
                    , modifier = Modifier.padding(start = 24.dp, top = 16.dp)) {
                    Text(text = stringResource(R.string.let_s_gonuts), style = titleLarge, color = primary_color)
                    Image(painter = painterResource(id = R.drawable.search_icon)
                        ,contentDescription =""
                        , modifier = Modifier.size(45.dp)
                    )
                }
            }
            item {
                Text(text = stringResource(R.string.order_your_favourite_donuts_from_here)
                    ,color = text_color60
                    , style = bodyMedium
                    , modifier = Modifier.padding(start = 24.dp)
                )
            }
            item {
                Text(text = stringResource(R.string.today_offers)
                    ,color = text_color100
                    ,style = labelLarge
                    , modifier = Modifier.padding(top = 42.dp, start = 24.dp, bottom = 24.dp)
                )
            }
            item {
                LazyRow (modifier = Modifier, contentPadding = PaddingValues(horizontal = 24.dp)){
                    items(homeUiState.donuts.size){
                        if (it<2){
                            MainCard(
                                image = painterResource(id = homeUiState.donuts[it].imageRef)
                                ,colors = homeUiState.donuts[it].color
                                , text = homeUiState.donuts[it].donutBody
                                , label = homeUiState.donuts[it].donutNme
                                , priceAfterOffer = homeUiState.donuts[it].priceAfterOffer.toString()
                                , price = homeUiState.donuts[it].price.toString()
                                , onClickMainCard = onClickCard
                            )
                        }
                    }
                }
            }
            item {
                Text(text = stringResource(R.string.donuts)
                    ,color = text_color100
                    ,style = labelLarge
                    , modifier = Modifier.padding(top = 36.dp, start = 24.dp)
                )
            }
            item {
                LazyRow (horizontalArrangement = Arrangement.spacedBy(12.dp)){
                    items(homeUiState.donuts.size-2){
                        if (it in 2..4){
                            SecondaryCard(
                                image = painterResource(id = homeUiState.donuts[it].imageRef)
                                , textReference = homeUiState.donuts[it].donutNme
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}