package util

import type.Number
import type.ResultType

interface Matcher {

    fun match(standard:ArrayList<ResultType>, target: ArrayList<ResultType>): MutableList<ResultType>
}