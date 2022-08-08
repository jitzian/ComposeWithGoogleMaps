package com.example.composeandgmaps.detailView.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeandgmaps.R
import com.example.composeandgmaps.detailView.model.MarkerData
import com.example.composeandgmaps.ui.app.ComposeGoogleMapsScreen

@Composable
fun BottomSheetRestaurantPreview(data: MarkerData) {
    ComposeGoogleMapsScreen {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.dimen_16_dp)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp)),
        ) {
            Text(
                text = data.applicant,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = data.location.toString(),
                style = MaterialTheme.typography.caption
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(
                            id = R.dimen.dimen_8_dp
                        )
                    ),
                color = MaterialTheme.colors.onSecondary
            )
            Text(
                text = data.locationDesc.toString(),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Justify
            )
            Text(
                text = data.optionalText.toString(),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BottomSheetRestaurantPreviewPrev() {
    BottomSheetRestaurantPreview(
        data = MarkerData(
            applicant = "Bay Area Dots, LLC",
            location = "900 BEACH ST",
            locationDesc = "Northwest Corner of Hyde & Beach Streets, on Beach.  Approximately 12' West of the Hyde St & Beach St crosswalk. Located against the wall with plant/ bushes.",
            optionalText = "Hot dogs, condiments, soft pretzels, soft drinks, coffee,cold beverages, pastries, bakery goods, cookies, icecream, candy, soups, churros, chestnuts, nuts, fresh fruit, fruit juices, desserts, potato chips and popcorn."
        )
    )
}