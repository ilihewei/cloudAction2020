package com.lihewei.observer;

public class Test {
    public static void main(String[] args) {
        Subject subject=new Subject ();
        new BinaryObserver (subject);
        new HexObserver (subject);
        new OctalObserver (subject);

        System.out.println ("Firest state change: 15");
        subject.setState (15);
        System.out.println ("Second state change: 10");
    }
}
