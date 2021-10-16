package baseboll

import nextstep.utils.Console
import nextstep.utils.Randoms

class Application

fun main(args: Array<String>) {
    var hasGameStop = false
    var gamePlay = true
    while (gamePlay) {
        if (hasGameStop) {
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val regame = Console.readLine()
            when (regame) {
                "1" -> hasGameStop = false
                else -> gamePlay = false
            }
        }
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
            val inputString = s.split("".toRegex()).toTypedArray()

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
}

private fun makeTargetNum1(): Array<String> {
    val ret: Array<String>
    while (true) {
        var checkZero = false
        val randomNum = Integer.toString(Randoms.pickNumberInRange(111, 999))
        println(randomNum)
        if (randomNum.contains("0")) {
            checkZero = true
        }
        val hs = HashSet<String>()
        val split = randomNum.split("".toRegex()).toTypedArray()
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


