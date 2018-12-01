package com.sample.libraryhostsample

import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Sagar on 11/30/2018.
 */

fun AppCompatActivity.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun TextInputLayout.getText(): String = this.editText?.text.toString().trim()
