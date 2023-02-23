package org.eu.noobshubham.kontests.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.eu.noobshubham.kontests.R
import org.eu.noobshubham.kontests.model.Kontests

@Composable
fun KontestsItem(kontests: Kontests) {
    val visitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(kontests.url))
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            "${kontests.name} is happening on ${kontests.site} at ${kontests.start_time}.\n" +
                    "For More: ${kontests.url}" +
                    "\n\nThanks for using KONTESTS." +
                    "\n\nDeveloped by SHUBHAM :love:"
        )
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = 2.dp
    ) {
        Column {
            Column(modifier = Modifier.padding(all = 16.dp)) {
                Text(
                    text = "${kontests.site}'s",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(R.font.rubik_regular)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = kontests.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    fontStyle = FontStyle(R.font.rubik_semibold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Icon(
                        painter = painterResource(id = R.drawable.hourglass),
                        contentDescription = "duration",
                        modifier = Modifier
                            .size(16.dp)
                            .offset(x = (-2).dp)
                    )
                    Text(text = "${kontests.formatDuration}hrs", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = kontests.status, fontWeight = FontWeight.Bold)
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Icon(
                        painterResource(id = R.drawable.clock),
                        contentDescription = "Start Time Icon"
                    )
                    Text(text = kontests.start_time)
                    /*
                    Icon(
                        painter = painterResource(id = R.drawable.finish_line),
                        contentDescription = "Start Time Icon"
                    )
                     Text(text = kontests.end_time)
                     */
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                ) {
                    OutlinedButton(
                        onClick = { context.startActivity(shareIntent) },
                        contentPadding = PaddingValues(
                            start = 10.dp,
                            top = 6.dp,
                            end = 10.dp,
                            bottom = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            backgroundColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share Contest",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        Text(text = "SHARE")
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Button(
                        onClick = { context.startActivity(visitIntent) },
                        // Uses ButtonDefaults.ContentPadding by default
                        contentPadding = PaddingValues(
                            start = 10.dp,
                            top = 6.dp,
                            end = 10.dp,
                            bottom = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        // Inner content including an icon and a text label
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Know More",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("KNOW MORE")
                    }
                }
            }
        }
    }
}