package com.example.ilovechess

import junit.framework.TestCase
import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

class BoardAdapterTest : TestCase() {
   val data = mutableListOf<Int>()

    @Test
    fun checkSetFunCtion(){
        val bA = BoardAdapter()
        bA.initData()
        assertEquals(bA.data.size, 64)
        println(bA.data)
    }
}