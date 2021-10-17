package util

import nextstep.utils.Randoms
import type.Number
import type.ResultType
import java.lang.RuntimeException

const val MIN_VALUE = 1
const val MAX_VALUE = 9
const val MAX_COUNT = 2
class RandomValue {

    private var tempArray = IntArray(10) { it * 1 }
    private var resultArray = mutableListOf<ResultType>()

    fun createRandomNumber(): ArrayList<ResultType> {
        initializeProperties()

        for(i in 0..MAX_COUNT){
            createNumber(i)
        }
        return ArrayList(resultArray)
    }

    private fun initializeProperties() {
        tempArray = IntArray(10) {it * 1}
        resultArray = mutableListOf()
    }

    private fun createNumber(i: Int) {
        val createNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
        if(tempArray[createNumber] != 0){
            tempArray[createNumber] = 0
            resultArray.add(Number(i, createNumber))
            return
        }
        createNumber(i)
    }


}