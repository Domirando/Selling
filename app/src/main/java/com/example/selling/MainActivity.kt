package com.example.selling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.selling.ui.theme.SellingTheme
import kotlinx.serialization.json.Json

// Inside your Application class or at an appropriate place in your app setup
val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    encodeDefaults = true
    // Add any other configuration you may need
}
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                var name = remember {
                    mutableStateOf(TextFieldValue(""))
                }
                var names = mutableListOf<String>()
//                Nav()
                Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    TextField(value = name.value, onValueChange = { newText ->
                        name.value = newText
                    }, label = { Text(text = "Ismingiz:")}, placeholder = { Text(text = "Maftuna")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))
                    Button(onClick = { names.add(name.value.text) }) {
                        Text(text = "OK")
                    }
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(names) { name ->
                            Text(text = name)
                        }
                    }
                }
            }
    }
}