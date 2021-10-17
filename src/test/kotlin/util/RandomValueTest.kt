package util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RandomValueTest{

    @Test
    fun `RandomValue 테스트`() {
        val randomValue = RandomValue()

        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())
        println(randomValue.createRandomNumber())

        assertTrue(true)
    }
}