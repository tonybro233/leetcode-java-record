package tony.design_pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state = 0;

    public void setState(int state){
        if (state != this.state){
            this.state = state;
            System.out.println("Now my state is "+state);
            notifyObservers();
        }
    }

    public int getState(){
        return this.state;
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
