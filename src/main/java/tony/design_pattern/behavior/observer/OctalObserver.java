package tony.design_pattern.behavior.observer;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("- Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
