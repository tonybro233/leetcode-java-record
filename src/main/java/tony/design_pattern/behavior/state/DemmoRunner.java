package tony.design_pattern.behavior.state;

public class DemmoRunner {

    public static void main(String[] args){
        WorkingMan man = new WorkingMan();
        man.work();
        man.setState(new HappyState());
        man.work();
        man.setState(new SadState());
        man.work();
        man.setState(new AngryState());
        man.work();
    }
}
