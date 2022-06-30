package com.example.msftest

import com.example.msftest.StringUtils.isFirstLetterCapital
import org.junit.Test
import org.junit.Assert.*

class StringUnitTest {

    @Test
    fun first_letter_upper_case() {
        assertTrue("First letter".isFirstLetterCapital())
    }

    @Test
    fun first_letter_lower_case() {
        assertFalse("first letter".isFirstLetterCapital())
    }
}