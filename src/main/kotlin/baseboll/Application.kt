package baseboll

import nextstep.utils.Console
import nextstep.utils.Randoms

class Application

var hasGameStop = false
var gamePlay = true
fun main(args: Array<String>) {
    while (gamePlay) {

        isRegame()
        basebollGameLogic()
    }
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

private fun basebollGameLogic() {
    val strings = makeTargetNum1()
    for (str in strings) {
        println("키 : $str")
    }
    while (!hasGameStop && gamePlay) {
        var strike = 0
        var boll = 0
        print("숫자를 입력해주세요 : ")
        val s = Console.readLine()
        // 숫자가 세자리 인지 검증
        val inputString = s.split("").filter { it!=null&&it!="" }.toMutableList()



        if (verifiedRandomNum(inputString)) continue


        // gameLogicCheck
        for (i in inputString.indices) {
            for (j in strings.indices) {
                if (inputString[i] == strings[j] && i == j) {
                    strike++
                } else if (inputString[i] == strings[j] && i != j) {
                    boll++
                }
            }
        }
        println("$strike : 스트라이크 ")
        println("$boll: boll ")
        println(s)
        if (strike == 3) {
            hasGameStop = true
        }
    }
}

private fun verifiedRandomNum(subList: MutableList<String>): Boolean {
    var inputNumCheck = false;

    try {
        if (subList.size == 3) inputNumCheck = true else {
            inputNumCheck = false; fail("에러발생")
        }
    } catch (e: Exception) {
        println(e.message)
    } finally {
        if (!inputNumCheck) return true
    }
    return false
}

private fun isRegame() {
    if (hasGameStop) {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val regame = Console.readLine()
        when (regame) {
            "1" -> hasGameStop = false
            else -> gamePlay = false
        }
    }
}

private fun makeTargetNum1(): MutableList<String> {
    var ret: MutableList<String>
    while (true) {
        var checkZero = false
        val randomNum = Integer.toString(Randoms.pickNumberInRange(111, 999))
        println(randomNum)
        if (randomNum.contains("0")) {
            checkZero = true
        }
        val hs = HashSet<String>()
        val split = randomNum.split("").filter { it!=null&&it!="" }.toMutableList()


        for (i in split.indices) {
            hs.add(split[i])
        }
        if (hs.size >= 3 && checkZero == false) {
            ret = split
            break
        }
    }
    return ret
}


