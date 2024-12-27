package com.example.onboarding.presentation.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.onboarding.domain.Page
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.presentation.Dimens.MediumPadding1
import com.example.common.presentation.Dimens.MediumPadding2
import com.example.common.presentation.ui.theme.MyNewsAppTheme
import com.example.onboarding.R
import com.example.onboarding.domain.pages

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
){
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = com.example.common.R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = com.example.common.R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    MyNewsAppTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}