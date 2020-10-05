package com.lihewei.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihewei
 */
public class Subject {

    private List<Observer> observers=new ArrayList<> ();
    private  int state;

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
        System.out.println ("size=====>"+observers.size ());
    }

    public int getState() {
        return state;
    }


    public  void attach(Observer observer){
        observers.add (observer);
    }

    public void notifyAllObservers(){
        for (Observer observer:observers) {
            observer.update();
        }
    }


}
