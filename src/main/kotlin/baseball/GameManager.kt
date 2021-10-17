package baseball

import nextstep.utils.Console
import type.Ball
import type.ResultType
import type.Strike
import util.BallMatcher
import util.RandomValue
import util.StrikeMatcher

class GameManager {

    private var isStarted = true
    private var computerNumbers = arrayListOf<ResultType>()

    init {
        setComputerNumber()
    }

    fun start(){
        while (isStarted) {
            val userNumbers = printMain()
            val checkedNumbers = checkNumbers(userNumbers)
            makeResult(checkedNumbers)?.let {
                println(it)
            }
        }

    }

    private fun setComputerNumber() {
        computerNumbers = RandomValue().createRandomNumber()
    }

    private fun printMain(): ArrayList<ResultType>{
        print("숫자를 입력해주세요 : ")
        return inputNumber()
    }

    private fun inputNumber(): ArrayList<ResultType>{
        var numbers = Console.readLine()
        return numbers.toInt().split()
    }

    private fun checkNumbers(userNumbers: ArrayList<ResultType>): MutableList<ResultType>{
        val checkedStrike = StrikeMatcher().match(computerNumbers, userNumbers)
        return BallMatcher().match(computerNumbers, ArrayList(checkedStrike))
    }

    private fun calculateStrikeAndBallCount(checkedNumbers: MutableList<ResultType>): Pair<Int, Int> {
        var strikeCnt = 0
        var ballCnt = 0
        checkedNumbers.forEach {
            if(it is Strike) strikeCnt++
            if(it is Ball) ballCnt++
        }
        return Pair(strikeCnt, ballCnt)
    }

    private fun collectAnswer(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 끝")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        var answer = Console.readLine()
        if(answer == "1") setComputerNumber()
        if(answer == "2") isStarted = false
    }

    private fun makeResult(checkedNumbers: MutableList<ResultType>): String? {
        val (strikeCnt, ballCnt) = calculateStrikeAndBallCount(checkedNumbers)
        if(strikeCnt == 3){
            collectAnswer()
            return null
        }
        if(strikeCnt > 0 && ballCnt > 0) return "$strikeCnt 스트라이크 $ballCnt 볼"
        if(strikeCnt > 0) return "$strikeCnt 스트라이크"
        if(ballCnt > 0) return "$ballCnt 볼"
        return "낫싱"
    }
}