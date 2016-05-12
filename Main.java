package com.company;

public class Main {
    static void test(boolean expression) {
        if (!expression) {
            throw new AssertionError("err");
        }
    }
    
    public static void main(String[] args) {
        Point[] poly1 = new Point[] { new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10)};
        Region region1 = new Region(poly1);
        test(!region1.contains(new Point(20, 20)));
        test(region1.contains(new Point(5, 5)));
        test(!region1.contains(new Point(-1, 10)));

        Point[] poly2 = new Point[] { new Point(0, 0), new Point(5, 5), new Point(5, 0)};
        Region region2 = new Region(poly2);
        test(region2.contains(new Point(3, 3)));
        test(region2.contains(new Point(4.9, 1)));
        test(!region2.contains(new Point(8, 1)));
        test(region2.contains(new Point(5, 1)));
        test(region2.contains(new Point(5.0, 0)));
        test(region2.contains(new Point(2.5, 2.5)));
        test(region2.contains(new Point(2.4, 2.3)));
        test(!region2.contains(new Point(5.1, 5.1)));
        test(!region2.contains(new Point(5.0, 5.1)));

        Region region3 = new Region(new Point[] {
                new Point(0, 0), new Point(0, 3),new Point(1, 2), new Point(3,4), new Point(3,0)
        });
        test(region3.contains(new Point(0.5, 1)));
        test(!region3.contains(new Point(0.9, 2.3)));
        test(region3.contains(new Point(0.5, 2.5)));
        test(region3.contains(new Point(1, 2.0)));
        test(!region3.contains(new Point(1, 2.9)));
        test(region3.contains(new Point(2.9, 3.9)));
        test(region3.contains(new Point(3, 2.1233455)));
        test(!region3.contains(new Point(3.1, 4.1)));
        test(region3.contains(new Point(2.9000000000, 3.9000000000000)));
    }
}