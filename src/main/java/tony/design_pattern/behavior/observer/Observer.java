package tony.design_pattern.behavior.observer;

public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        subject.addObserver(this);
    }

    public abstract void update();
}
