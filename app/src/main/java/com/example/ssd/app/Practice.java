package com.example.ssd.app;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;



/**
 * Created by 0_o on 2014/6/16.
 */
public class Practice {
    public static void main(String[] args) throws Exception{


    }
}

class T8{

    public void t8(){
        SsdUse s = new SsdUse();
        String str = Integer.toString(s.callNumber());

        System.out.println("这是" + str.length() + "位数");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + ",");
        }

    }
}

class T7{

    public void t7(){
        SsdUse s = new SsdUse();
        int number = s.callNumber();
        List list = new ArrayList();
        float sum = 0;

        for (int i = 2; i < number+3; i++) {
            list.add(s.get11235(Integer.toString(i)));
        }

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size()-1) {
                System.out.print(list.get(i+1) + "/" + list.get(i) + " + ");
            }else {
                System.out.print(" = ");
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size()-1) {
                sum += (float)((Integer)list.get(i+1) / (Integer)list.get(i));
            }
        }

        System.out.print(sum);

    }

}

class SsdUse{

    public int callNumber(){
        int number;

        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        return number;
    }

    public int get11235(String number){
        int result = 0;
        List list = new ArrayList();

        for (int i = 0; i < Integer.parseInt(number); i++) {

            if (i < 2) {
                result = 1;
            }else {
                result = (Integer)list.get(i - 1) + (Integer)list.get(i - 2);
            }
            list.add(i, result);
        }

        return result;
    }
}

class T6{

    public void t6(){
        int number = inputNumber();

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i + j  >= number) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }

            System.out.print("*");

            for (int j = 0; j < number; j++) {
                if (j < i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i <= j) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }

            System.out.print("*");

            for (int j = 0; j < number; j++) {
                if (i+j < number) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private int inputNumber(){
        int number=0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字: ");
        number = scanner.nextInt();

        return number;
    }
}


class T5{
    private String [] player1 = {"a", "b", "c"};
    private String [] player2 = {"x", "y", "z"};


    public void player(){
        List list = new ArrayList();

        for (int i = 0; i < player1.length; i++) {
            for (int j = 0; j < player2.length; j++) {
                if(noFace(player1[i], player2[j])){
                    list.add(player1[i] + player2[j]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    private boolean noFace(String a, String b){
        boolean result = true;

        if (a == "a" && b == "x") {
            result = false;
        }

        if (a == "c" && b == "x"){
            result = false;
        }

        if (a == "c" && b == "z"){
            result = false;
        }

        return result;
    }

}

class T4{


    private List<Integer> getNumber() {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList();

        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());

        }
        return list;
    }

    public void t4(){
        List <Integer>list = getNumber();
        int temp;
        /*
        for (int i = 0; i < list.size(); i++) {
            temp = 0;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) > temp) {
                    temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                    """""45555555
                }
            }
        }
        */
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                temp = list.get(j);
                if (list.get(i) > temp) {
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }

        for (int lis : list){
            System.out.println(lis);
        }
    }
}


class T3{
    private int a;
    private int b;
    private int c;
    private int temp;

    public int maxNumber(List<Integer> list){

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > temp) {
                temp = list.get(i);
            }
        }
        return temp;
    }

    public void t3(){
        List list = new ArrayList();
        list.add(15);
        list.add(1);
        list.add(22);
        list.add(333);
        list.add(23);

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class T2{

    private boolean t2(int num){
        boolean result = false;
        int num1 = num + 100;
        int num2 = num1 + 168;
        int n1 = (int)Math.sqrt(num1);
        int n2 = (int)Math.sqrt(num2);

        if (num1 == Math.pow(n1 , 2.0) && num2 == Math.pow(n2 , 2.0)) {
            result = true;
        }
        return result;
    }

    public int chkNumber(){
        int number = 0;

        for (int i = 1; i < 100000; i++) {
            if (t2(i)) {
                number = i;
                break;
            }
        }
        return number;
    }

}


class T1{

    //用list练习
    public void list1234(){
        List list = new ArrayList();
        List needNum = new ArrayList();
        int temp;
        int [] num = new int[3];

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    temp = i*100 + j*10 + k;
                    list.add(temp);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            num[0] = (Integer)list.get(i) / 100;
            num[1] = (Integer)list.get(i) % 100 / 10;
            num[2] = (Integer)list.get(i) % 10;

            if (num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) {
                needNum.add(list.get(i));
            }
        }

        for (int i = 0; i < needNum.size(); i++) {
            System.out.println(needNum.get(i));
        }
    }
}

