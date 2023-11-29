package com.example.selling
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationStrategy

@Serializable
data class ShopItem(var desc:String, var cost:String, var last_cost:String, var sale:String, var rating:String, var users:Int, var img:Int, var liked:Boolean)
