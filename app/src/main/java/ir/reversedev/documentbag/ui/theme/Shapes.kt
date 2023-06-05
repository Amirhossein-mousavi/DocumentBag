package ir.reversedev.documentbag.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes.roundedCornerShapeMedium: Shape
    @Composable get() = RoundedCornerShape(16.dp)
val Shapes.roundedCornerShapeSmall: Shape
    @Composable get() = RoundedCornerShape(4.dp)