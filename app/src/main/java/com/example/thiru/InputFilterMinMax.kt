package com.example.thiru

import android.text.InputFilter
import android.text.Spanned

class InputFilterMinMax(private val min: String, private val max: String) : InputFilter {

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = (dest.toString() + source.toString()).toDouble()
            if (isInRange(min, max, input))
                return null
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return ""
    }

    private fun isInRange(a: String, b: String, c: Double): Boolean {
        return if (b.toDouble() > a.toDouble()) c >= a.toDouble() && c <= b.toDouble()
        else c >= b.toDouble() && c <= a.toDouble()
    }
}
