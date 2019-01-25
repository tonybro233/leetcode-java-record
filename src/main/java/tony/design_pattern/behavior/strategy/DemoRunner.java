package tony.design_pattern.behavior.strategy;

public class DemoRunner {

    public static void main(String[] args){
        CalculateExecutor executor = new CalculateExecutor(new CalculateAdd());
        System.out.println("10 + 5 = " + executor.doExecute(10, 5));

        executor = new CalculateExecutor(new CalculateMinus());
        System.out.println("10 - 5 = " + executor.doExecute(10, 5));
    }
}
