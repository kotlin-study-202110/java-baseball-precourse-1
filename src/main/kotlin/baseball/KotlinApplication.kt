package baseball

import type.Number
import type.ResultType

class KotlinApplication

fun main() {
    // TODO 숫자 야구 게임 구현
    GameManager().start()

}

//fun List<String>.match(value: List<String>?): String{
//    var result = StringBuilder()
//    // strike check
//    for(i in 1..3){
//        if (this[i] == value!![i]) {
//            result.append("스트라이크")
//        }
//    }
//    return result.toString()
//}

fun Int.split(): ArrayList<ResultType> {
    if (this !in 100..999)
        throw RuntimeException("올바른 값이 아닙니다.")

    return arrayListOf(Number(0,this/100), Number(1, (this - (100*(this/100))) / 10), Number(2, (this - (100*(this/100))) % 10))
}