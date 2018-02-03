package com.example.mazena.quicknotes.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by mazena on 27.01.18.
 */

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}