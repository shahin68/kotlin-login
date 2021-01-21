package com.shahin.login.extensions

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.simpleInputWatcher(block: (Editable) -> Unit) {
    addTextChangedListener(
        object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                block.invoke(s)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        }
    )
}