package ir.reversedev.documentbag.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.reversedev.documentbag.R

@Composable
fun Loading3dots(isDark: Boolean, size: Dp = 100.dp) {
    val composition by rememberLottieComposition(
        spec =
        if (isDark)
            LottieCompositionSpec.RawRes(R.raw.loading3dotsdark)
        else
            LottieCompositionSpec.RawRes(R.raw.loading3dotslight)
    )
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.size(size = size)
    )


}