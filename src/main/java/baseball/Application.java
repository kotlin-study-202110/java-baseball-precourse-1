package baseball;


import java.util.HashMap;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {

//        HashMap<String,Integer> answer = makeTargetNum();
        HashSet hashSet = makeTargetNum1();
//        System.out.println(answer.keySet());

//        for (Entry<String,Integer> elem : answer.entrySet()) {
//            System.out.println("키 : " + elem.getKey() + "값 : " + elem.getValue());
//        }
         for (Object elem : hashSet) {
            System.out.println("키 : " + elem);
        }


        System.out.print("숫자를 입력해주세요 : ");
        String s = readLine();
        System.out.println(s);

    }

    private static HashMap<String,Integer> makeTargetNum() {
        HashMap<String, Integer> result;

        while (true) {
            boolean checkZero = false;
            String randomNum = Integer.toString(pickNumberInRange(111,999));
            System.out.println(randomNum);
            if(randomNum.contains("0")){
                checkZero= true;
            }
            HashMap<String, Integer> hm = new HashMap<>();

            String[] split = randomNum.split("");

            for (int i = 0; i < split.length; i++) {
                hm.put(split[i],i + 1);
            }

            if (hm.size() >= 3 && checkZero == false) {
                result = hm;
                break;
            }
        }
        return result;
    }
    private static HashSet<String> makeTargetNum1() {
        HashSet<String> ret = new HashSet<>();

        while (true) {
            boolean checkZero = false;
            String randomNum = Integer.toString(pickNumberInRange(111,999));
            System.out.println(randomNum);
            if(randomNum.contains("0")){
                checkZero= true;
            }
            HashSet<String> hs = new HashSet<>();

            String[] split = randomNum.split("");

            for (int i = 0; i < split.length; i++) {
                hs.add(split[i]);
            }

            if (hs.size() >= 3 && checkZero == false) {
                ret= hs;
                break;
            }
        }

        return ret;
    }
}
