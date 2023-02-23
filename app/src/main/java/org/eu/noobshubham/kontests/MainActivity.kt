package org.eu.noobshubham.kontests

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.eu.noobshubham.kontests.model.Kontests
import org.eu.noobshubham.kontests.ui.theme.KONTESTSTheme
import org.eu.noobshubham.kontests.view.KontestsItem
import org.eu.noobshubham.kontests.viewModel.MainViewModel

class MainActivity : ComponentActivity() {

    // got help from https://github.com/lubnamariyam/MovieList_Retrofit_API_In_Compose
    private val mainViewModel by viewModels<MainViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KONTESTSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                     ContestsList(contests = mainViewModel.kontestsListResponse)
                }
            }
        }
    }
}

@Composable
fun ContestsList(contests: List<Kontests>) {
    LazyColumn {
        itemsIndexed(contests) { _, item -> KontestsItem(kontests = item) }
    }
}
