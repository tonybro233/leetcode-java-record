package tony.design_pattern.structure.proxy;

public class RealSubject implements Subject {
    @Override
    public void dealTask(String taskName) {
        System.out.println("Go dealing the task: "+taskName);
    }

    @Override
    public void abortTask(String taksName) {
        System.out.println("Abort the task: "+taksName);
    }
}
