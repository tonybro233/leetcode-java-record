package tony.design_pattern.behavior.state;

public class SadState implements EmotionState {
    @Override
    public void working() {
        System.out.println("Why I'm so poor? Damn, go to work...");
    }
}
