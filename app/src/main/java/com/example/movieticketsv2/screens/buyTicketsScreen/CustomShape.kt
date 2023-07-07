package com.example.movieTicket.screens.buyTicketsScreen

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CustomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = createPath(size.width, size.height)
        )
    }

    private fun createPath(width: Float, height: Float): Path {
        val path = Path()
        val curveHeight = height * 0.2f

        path.moveTo(0f, curveHeight)
        path.quadraticBezierTo(
            width / 2f,
            -curveHeight,
            width,
            curveHeight
        )

        path.lineTo(width, height)
        path.quadraticBezierTo(
            width / 1.5f,
            height - curveHeight,
            0f,
            height
        )
        path.close()

        return path
    }
}