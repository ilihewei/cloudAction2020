package com.lihewei.observer;

public class HexObserver extends Observer {

    HexObserver(Subject subject){
        this.subject=subject;
        this.subject.attach (this);
    }

    @Override
    public void update() {
        System.out.println ("Hex String"+Integer.toHexString (subject.getState ()).toUpperCase ());
    }
}
