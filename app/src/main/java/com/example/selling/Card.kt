package com.example.selling

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@SuppressLint("SuspiciousIndentation")
@Composable
fun Card(item: ShopItem, navController: NavController){
    var sell = remember {
        mutableStateOf(item)
    }
    val serializedUser = json.encodeToString(item)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(400.dp)
                .clickable(onClick = {
                    navController.navigate("details_screen/$serializedUser")
                })
        ) {
            Column {
                Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd){
                    Image(
                        painter = painterResource(id = sell.value.img),
                        contentDescription = "Background Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .height(200.dp),
                        )
                    if (sell.value.liked){
                        Image(modifier = Modifier
                            .padding(0.dp, 10.dp, 15.dp, 0.dp)
                            .clickable(onClick = {
                                sell.value.liked = !sell.value.liked
                            }), painter = painterResource(id = R.drawable.heart_broken_red), contentDescription = sell.value.desc)
                    } else{
                        Image(modifier = Modifier
                            .padding(0.dp, 10.dp, 15.dp, 0.dp)
                            .clickable(onClick = {
                                sell.value.liked = !sell.value.liked
                            }), painter = painterResource(id = R.drawable.heart_broken_black), contentDescription = sell.value.desc)
                    }
                }
                Column (modifier = Modifier
                    .fillMaxWidth()){
                    Text(
                        modifier = Modifier.padding(0.dp, 15.dp),
                        text = sell.value.desc,
                        style = TextStyle(color= Color.Black,fontSize = 24.sp)
                    )
                    Row (modifier = Modifier.padding(0.dp, 15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                        Text(
                            modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                            text = sell.value.cost,
                            style = TextStyle(color= Color.Black,fontSize = 24.sp)
                        )
                        Text(
                            modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                            text = sell.value.last_cost,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                        )
                        Text(
                            text = sell.value.sale,
                            style = TextStyle(color= Color.Red,fontSize = 24.sp)
                        )
                    }
                    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                        Image(modifier = Modifier.size(30.dp), painter = painterResource(id = R.drawable.star), contentDescription = sell.value.desc)
                        Text(
                            text = "${sell.value.rating} (${sell.value.users})",
                            style = TextStyle(color= Color.Red,fontSize = 24.sp)
                        )
                    }

                }

        }
    }
}