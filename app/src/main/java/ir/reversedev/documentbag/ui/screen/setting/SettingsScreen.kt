package ir.reversedev.documentbag.ui.screen.setting

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.theme.bgCard
import ir.reversedev.documentbag.ui.theme.roundedCornerShapeMedium
import ir.reversedev.documentbag.ui.theme.textColor

@Composable
fun SettingScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(bottom = 56.dp, start = 16.dp, top = 16.dp, end = 16.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            shape = MaterialTheme.shapes.roundedCornerShapeMedium,
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.bgCard,
                MaterialTheme.colorScheme.bgCard
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = stringResource(id = R.string.settings),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.textColor
            )
            SettingsViewItem(
                R.drawable.ic_language,
                stringResource(id = R.string.change_language)
            ) {}
            SettingsViewItem(
                R.drawable.ic_theme,
                stringResource(id = R.string.dark_theme)
            ) {}
            SettingsViewItem(
                R.drawable.ic_lock,
                stringResource(id = R.string.security)
            ) {}
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            shape = MaterialTheme.shapes.roundedCornerShapeMedium,
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.bgCard,
                MaterialTheme.colorScheme.bgCard
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = stringResource(id = R.string.info),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.textColor
            )
            SettingsViewItem(R.drawable.ic_star, stringResource(id = R.string.rate_us)) {}
            SettingsViewItem(R.drawable.ic_apps, stringResource(id = R.string.our_applications)) {}
            SettingsViewItem(R.drawable.ic_info, stringResource(id = R.string.about_us)) {}

        }


    }
}

@Composable
fun SettingsViewItem(
    @DrawableRes image: Int,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp)
            .background(MaterialTheme.colorScheme.bgCard)
            .clickable(
                onClick = { onClick() },
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = true,
                    color = Color(0xFF7A3DB4)
                )
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 32.dp),
            color = MaterialTheme.colorScheme.textColor
        )
    }
}