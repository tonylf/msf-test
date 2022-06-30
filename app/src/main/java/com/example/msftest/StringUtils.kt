package com.example.msftest

object StringUtils {

    fun String?.isFirstLetterCapital() = !this.isNullOrEmpty() && this.first().isUpperCase()
}