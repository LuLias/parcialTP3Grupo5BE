package com.example.parcialtp3grupo5be.components

import android.content.Context
import android.util.AttributeSet
import com.example.parcialtp3grupo5be.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class CustomSegmentedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialButtonToggleGroup(context, attrs, defStyleAttr) {

    init {
        // Set initial checked button
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSegmentedButton, defStyleAttr, 0)
            val checkedButtonId = typedArray.getResourceId(R.styleable.CustomSegmentedButton_checkedButton, -1)
            if (checkedButtonId != -1) {
                check(checkedButtonId)
            }
            typedArray.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (i in 0 until childCount) {
            val button = getChildAt(i) as? MaterialButton ?: continue
            if (button.visibility == GONE) {
                continue
            }
            val builder = button.shapeAppearanceModel.toBuilder()
            button.shapeAppearanceModel = builder.setTopLeftCornerSize(80f)
                .setBottomLeftCornerSize(80f)
                .setTopRightCornerSize(80f)
                .setBottomRightCornerSize(80f).build()
        }
    }
}
