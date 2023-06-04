package ir.reversedev.documentbag.ui.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.theme.primaryColor
import ir.reversedev.documentbag.ui.theme.roundedCornerShapeMedium

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val navigation = rememberSystemUiController()
    navigation.setStatusBarColor(MaterialTheme.colorScheme.primaryColor)
    navigation.isNavigationBarVisible = false
    val items = listOf(
        HomeItem(R.drawable.ic_birth_certificate, stringResource(id = R.string.birthـcertificate)),
        HomeItem(R.drawable.ic_national_card, stringResource(id = R.string.national_card)),
        HomeItem(R.drawable.ic_debit_card, stringResource(id = R.string.debitـcard)),
        HomeItem(R.drawable.ic_driver, stringResource(id = R.string.driving_licence)),
        HomeItem(R.drawable.ic_soldier, stringResource(id = R.string.military_service_license)),
        HomeItem(R.drawable.ic_student, stringResource(id = R.string.student_card)),
        HomeItem(R.drawable.ic_car, stringResource(id = R.string.car_card)),
        HomeItem(R.drawable.ic_passport, stringResource(id = R.string.passport)),
    )
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp), columns = GridCells.Fixed(2)
    ) {
        items(items.size) {
            HomeScreenItem(
                image = items[it].image, title = items[it].title
            ) {

            }
        }
    }
}

@Composable
fun HomeScreenItem(
    @DrawableRes image: Int,
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .clip(MaterialTheme.shapes.roundedCornerShapeMedium)
                .background(Color.LightGray)
                .clickable {
                    onClick
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 75.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            )
        }
    }
}