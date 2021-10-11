package baseball;


import java.util.HashMap;

import java.util.HashSet;

import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {

        boolean hasGameStop = false;
        boolean gamePlay = true;



        while (gamePlay) {



            if (hasGameStop) {
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String regame = readLine();
                //검증
                // 게임 초기화
                switch (regame){
                    case "1":
                        hasGameStop = false;

                        break;
                    default:
                        gamePlay = false;
                }
            }

            String[] strings = makeTargetNum1();
            for (String str : strings) {
                System.out.println("키 : " + str);
            }


            while (!hasGameStop && gamePlay) {
                int strike = 0;
                int boll = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String s = readLine();
                // 숫자가 세자리 인지 검증

                String[] inputString = s.split("");

                // gameLogicCheck

                for (int i = 0; i < inputString.length; i++) {
                    for (int j = 0; j < strings.length; j++) {
                        if (inputString[i].equals(strings[j])  && i == j) {
                            strike++;
                        } else if (inputString[i].equals(strings[j]) && i != j) {
                            boll++;
                        } else ;

                    }
                }
                System.out.println(strike + " : 스트라이크 " );
                System.out.println(boll + ": boll " );

                System.out.println(s);
                if (strike == 3) {
                    hasGameStop = true;
                }
            }
        }

    }


    private static String[] makeTargetNum1() {
        String[] ret;

        while (true) {
            boolean checkZero = false;
            String randomNum = Integer.toString(pickNumberInRange(111,999));
            System.out.println(randomNum);
            if (randomNum.contains("0")) {
                checkZero = true;
            }
            HashSet<String> hs = new HashSet<>();

            String[] split = randomNum.split("");

            for (int i = 0; i < split.length; i++) {
                hs.add(split[i]);
            }

            if (hs.size() >= 3 && checkZero == false) {
                ret = split;
                break;
            }
        }

        return ret;
    }
}
