package com.example.redfincodechallenge.mainView.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import com.example.redfincodechallenge.R
import com.example.redfincodechallenge.constants.GlobalConstants
import com.example.redfincodechallenge.rest.model.ResultApiItem

@Composable
fun ItemRow(data: ResultApiItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_16_dp),
                vertical = dimensionResource(
                    id = R.dimen.dimen_8_dp
                )
            ),
        elevation = dimensionResource(id = R.dimen.dimen_4_dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.dimen_8_dp)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.dimen_8_dp)
            )
        ) {
            Image(
                painter = rememberImagePainter(data = GlobalConstants.FOOD_TRUCK_IMAGE_URL),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_4_dp))),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = data.applicant.toString(),
                style = MaterialTheme.typography.h6
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp))
            ) {
                Text(
                    text = stringResource(id = R.string.location_TEXT),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = data.location.toString(),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(CenterVertically)
                )
            }
            Text(
                text = data.optionaltext.toString(),
                style = MaterialTheme.typography.caption
            )
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp))
            ) {
                Text(
                    text = stringResource(id = R.string.service_hours_TEXT),
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "${data.starttime} - ${data.endtime}",
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}