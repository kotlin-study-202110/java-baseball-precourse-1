package util

import type.Ball
import type.Number
import type.ResultType

class BallMatcher: Matcher{

    override fun match(standard:ArrayList<ResultType>, target: ArrayList<ResultType>): MutableList<ResultType> {
        val result = target.toMutableList()
        target.forEach {
            if(it is Number){
                for(index in 0..2){
                    if(it.v == standard[index].value){
                        result[it.i] = Ball(it.i, it.v)
                    }
                }
            }
        }
        return result
    }
}