package tony.design_pattern.behavior.state;

public class WorkingMan {
    private EmotionState state;

    public void setState(EmotionState state) {
        this.state = state;
    }

    public void work(){
        if (null == state){
            System.out.println("Give me an Emotion");
        } else {
            this.state.working();
        }
    }
}
