package ir.reversedev.documentbag.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.reversedev.documentbag.R

@Composable
fun Loading3dots(isDark: Boolean) {
    val composition by rememberLottieComposition(
        spec =
        if (isDark)
            LottieCompositionSpec.RawRes(R.raw.loading3dotsdark)
        else
            LottieCompositionSpec.RawRes(R.raw.loading3dotslight)
    )
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)


}