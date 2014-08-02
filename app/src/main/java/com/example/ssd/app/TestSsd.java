package com.example.ssd.app;

/**
 * Created by 0_o on 2014/5/31.
 */

interface surfacing {
    double area(); // 計算面積的方法
}

class Shape { // 代表圖形原點的類別
    protected double x,y; // 座標

    public Shape(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "圖形原點：(" + x + ", " + y + ")";
    }
}

class Square extends Shape implements  surfacing {
    protected  double l;
    public Square(double x, double y, double l) {
        super(x, y);
        this.l = l;
    }
    public double area() {
        return l * l;
    }

    public String toString() {
        return "zf形原點：(" + x + ", " + y + "), 变长 " + l + "面积 " + (l * l);
    }
}

class Circle extends Shape {
    private double r; // 圓形半徑
    final static double PI = 3.14159;

    public Circle(double x,double y,double r) {
        super(x,y); // 呼叫父類別建構方法
        this.r = r;
    }

    public double area() {// 計算圓面積
        return PI*r*r;
    }

    public String toString() {
        return "圓心：(" + x + ", " + y + ")、半徑：" + r + "、面積：" + area();
    }
}

public class TestSsd {
    public static void main(String[] argv) {
        Circle c = new Circle(5,8,7);
        c.area();
        System.out.println(c.toString());

        Square s = new Square(5,8,7);
        s.area();
        System.out.println(s.toString());
    }
}







