package com.example.spotifyclonecoding

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerDecoration(
    private val topSpace : Int,
    private val startSpace : Int,
    private val endSpace : Int,
    private val bottomSpace : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildLayoutPosition(view)
        val count = state.itemCount

        outRect.left = startSpace
        outRect.right = endSpace
        outRect.bottom = bottomSpace
        outRect.top = topSpace

    }
}