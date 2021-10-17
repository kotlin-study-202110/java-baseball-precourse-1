package util

import type.ResultType
import type.Strike

class StrikeMatcher: Matcher {

    override fun match(standard:ArrayList<ResultType>, target: ArrayList<ResultType>): MutableList<ResultType> {
        var result = target.toMutableList()
        for (index in 0..2) {
            if(standard[index].value == target[index].value){
                result[index] = Strike(result[index].index!!, result[index].value!!)
            }
        }
        return result;
    }
}