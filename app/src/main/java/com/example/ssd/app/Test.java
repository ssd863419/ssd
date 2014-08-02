package com.example.ssd.app;

import java.util.Scanner;

/**
 * Created by 0_o on 2014/6/11.
 */
public class Test {
    public static void main(String[] args){

        new StartGame().start();

    }
}

class Init{
    private int a;
    private int b;

    public void setInit(int num){
        this.a = num;
        this.b = num;

    }

    public void init(){

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                //第一列先显示数字
                if (i == 0) {
                    //10以下的数字加空格, 为了整齐
                    if (j <10) {
                        System.out.print(j + " ");
                    }else {
                        System.out.print(j);
                    }
                }else {
                    //每列先显示数字, 再显示+
                    if (j == 0 && i < 10) {
                        System.out.print(i + " ");
                    }else if(j == 0 && i >= 10){
                        System.out.print(i);
                    }else {
                        System.out.print("+ ");
                    }
                }
            }
            System.out.println();
        }
    }
}

class PPlayer{
    private String name;

    public void setPlayerName(String name){
            this.name = name;
    }

    public String getPlayerName(){
        return name;
    }

    public void pplayer(){
        Scanner scanner = new Scanner(System.in);
        setPlayerName(scanner.next());


    }
}

class StartGame{
    Scanner scanner;
    PPlayer pp;
    Init init;

    public void start(){
        scanner = new Scanner(System.in);
        pp = new PPlayer();
        init = new Init();

        System.out.print("请输入姓名: ");
        pp.setPlayerName(scanner.next());

        System.out.print("请输入格数: ");
        init.setInit(scanner.nextInt());

        while (true){
            System.out.println("玩家: " + pp.getPlayerName());
            init.init();
            break;
        }

    }

}