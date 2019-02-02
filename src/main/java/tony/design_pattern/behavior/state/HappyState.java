package tony.design_pattern.behavior.state;

public class HappyState implements EmotionState {

    @Override
    public void working() {
        System.out.println("Feel so good, hardworking...");
    }
}
