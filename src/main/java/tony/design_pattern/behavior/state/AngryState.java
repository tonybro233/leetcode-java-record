package tony.design_pattern.behavior.state;

public class AngryState implements EmotionState {
    @Override
    public void working() {
        System.out.println("What the fuck is this? I'm done, go fuck yourself !!!");
    }
}
