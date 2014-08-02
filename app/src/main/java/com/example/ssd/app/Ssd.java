package com.example.ssd.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0_o on 2014/5/31.
 */
public class Ssd {

    public static void main(String[] args){
        Player p = new Player();
        p.play();


    }
}

//产生要猜的四位数数字
class TargetNum{
    String num;
    ChkNumberNoRepead c;

    public String targetNum(){
        c = new ChkNumberNoRepead();

        while (true){
            num = (Integer.toString((int)(Math.random()*10000)));

            if (c.chk(num)) {
                break;
            }
        }

        return num;
    }

}

//确认四位数字不重复且为四位数
class ChkNumberNoRepead{
    boolean result;
    Pattern p;

    public boolean chk(String num){
        p = Pattern.compile("[0-9]{4}");

        if (p.matcher(num).matches()) {
            result = true;
        }else {
            result = false;
        }

        if (result) {


            /*
            for (int i = 0; i < 4; i++) {
                for (int j = i; j < 4; j++) {
                    if (num.charAt(i) == num.charAt(j)) {
                        result = false;
                    }
                }
            }
            */
            /*
            Map map = new HashMap<String, Boolean>();
            for (int i = 0; i < 4; i++) {
                map.put(num.charAt(i), true);
            }
            if (map.size() != 4) {
                result = false;
            }
            */

            Set set = new HashSet();
            for (int i = 0; i < 4; i++) {
                set.add(num.charAt(i));
            }
            if (set.size() != 4){
                result = false;
            }
        }

        return result;
    }
}

class Player{
    String number;
    String name;
    Scanner s_name;
    Scanner s_number;
    ChkNumberNoRepead chkNoRepead;
    TargetNum chkNum;
    Compare compare;

    public void play(){

        System.out.print("请输入姓名: ");
        s_name = new Scanner(System.in);
        name = s_name.next();

        chkNoRepead = new ChkNumberNoRepead();
        chkNum = new TargetNum();
        chkNum.targetNum();
        compare = new Compare();
        boolean run;

        while (true) {
            s_number = new Scanner(System.in);
            System.out.print("请输入四位数字: ");
            number = s_number.next();
            System.out.println("目标:" + chkNum.num);

            //判断四位数字不重复
            if (chkNoRepead.chk(number)){
                System.out.println(name +"输入:" + number);
                run = true;
            }else{
                System.out.println("请输入四位数字且不重复");
                run = false;
            }

            //比较数字
            if (number.equals(chkNum.num)){
                System.out.println("恭喜" + name + "答对了");
                break;
            }else {
                if (run){
                    String result = compare.compare(number, chkNum.num);
                    System.out.println("比较情况: " + result);
                }
            }
        }

    }



    private String fourNumber(int num){
        String result;

        if (num < 10) {
            result = "000" + num;
        }else if (num >= 10 && num < 100){
            result = "00" + num;
        }else if (num >=100 && num < 1000){
            result = "0" + num;
        }else {
            result = Integer.toString(num);
        }

        return result;
    }

}

//比较2个数字,并取得几A几B
class Compare{

    public String compare(String num1, String num2){
        String result;
        int A = 0;
        int B = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char a = num1.charAt(i);
                char b = num2.charAt(j);
                if (i == j && a == b) {
                    A++;
                } else if (i != j && a == b) {
                    B++;
                }
            }
        }
        result = A + "A" + B +"B";
        return result;
    }
}