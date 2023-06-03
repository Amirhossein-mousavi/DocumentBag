package ir.reversedev.documentbag.ui.components

<<<<<<< HEAD
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
=======
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
>>>>>>> 0e67d8f (create Loading3dots components)
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.reversedev.documentbag.R

@Composable
<<<<<<< HEAD
fun Loading3dots(isDark: Boolean) {
=======
fun Loading3dots(isDark: Boolean, size: Dp = 100.dp) {
>>>>>>> 0e67d8f (create Loading3dots components)
    val composition by rememberLottieComposition(
        spec =
        if (isDark)
            LottieCompositionSpec.RawRes(R.raw.loading3dotsdark)
        else
            LottieCompositionSpec.RawRes(R.raw.loading3dotslight)
    )
<<<<<<< HEAD
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
=======
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.size(size = size)
    )
>>>>>>> 0e67d8f (create Loading3dots components)


}