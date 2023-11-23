package com.example.selling

import androidx.compose.foundation.Image
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

@Composable
fun Card(item: ShopItem){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(400.dp)
        ) {
            Column {
                Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd){
                    Image(
                        painter = painterResource(id = item.img),
                        contentDescription = "Background Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .height(200.dp),
                        )
                    if (item.liked){
                        Image(modifier = Modifier.padding(0.dp, 10.dp, 15.dp, 0.dp), painter = painterResource(id = R.drawable.heart_broken_red), contentDescription = item.desc)
                    } else{
                        Image(modifier = Modifier.padding(0.dp, 10.dp, 15.dp, 0.dp), painter = painterResource(id = R.drawable.heart_broken_black), contentDescription = item.desc)
                    }
                }
                Column (modifier = Modifier
                    .fillMaxWidth()){
                    Text(
                        modifier = Modifier.padding(0.dp, 15.dp),
                        text = item.desc,
                        style = TextStyle(color= Color.Black,fontSize = 24.sp)
                    )
                    Row (modifier = Modifier.padding(0.dp, 15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                        Text(
                            modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                            text = item.cost,
                            style = TextStyle(color= Color.Black,fontSize = 24.sp)
                        )
                        Text(
                            modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                            text = item.last_cost,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                        )
                        Text(
                            text = item.sale,
                            style = TextStyle(color= Color.Red,fontSize = 24.sp)
                        )
                    }
                    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                        Image(modifier = Modifier.size(30.dp), painter = painterResource(id = R.drawable.star), contentDescription = item.desc)
                        Text(
                            text = "${item.rating} (${item.users})",
                            style = TextStyle(color= Color.Red,fontSize = 24.sp)
                        )
                    }

                }

        }
    }
}