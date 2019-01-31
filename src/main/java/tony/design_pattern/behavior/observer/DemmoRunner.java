package tony.design_pattern.behavior.observer;

public class DemmoRunner {

    public static void main(String[] args){
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        subject.setState(9);
    }
}
