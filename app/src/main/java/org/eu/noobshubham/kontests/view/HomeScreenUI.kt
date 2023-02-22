package org.eu.noobshubham.kontests.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.eu.noobshubham.kontests.R
import org.eu.noobshubham.kontests.model.Kontests

@Composable
fun KontestsItem(kontests: Kontests) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 2.dp
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Column(modifier = Modifier.padding(all = 16.dp)) {
                    Text(text = "${kontests.site}'s", fontSize = 16.sp)
                    Text(
                        text = kontests.name,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(verticalAlignment = Alignment.Bottom) {
                        Icon(
                            painter = painterResource(id = R.drawable.hourglass),
                            contentDescription = "duration",
                            modifier = Modifier
                                .size(16.dp)
                                .offset(x = (-2).dp)
                        )
                        Text(text = "3hrs", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = kontests.status, fontWeight = FontWeight.Bold)
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.hackerrank),
                    contentDescription = "source site logo",
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterVertically)
                )
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
                    Text(text = "Start Time")
                    Icon(
                        painter = painterResource(id = R.drawable.finish_line),
                        contentDescription = "Start Time Icon"
                    )
                    Text(text = "Start Time")
                }
                Button(
                    onClick = { /* ... */ },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Know More",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Know More")
                }
            }
        }
    }
}