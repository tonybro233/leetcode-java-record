package tony.design_pattern.behavior.strategy;

public class CalculateExecutor {

    CalculateStrategy strategy;

    public CalculateExecutor(CalculateStrategy strategy){
        this.strategy = strategy;
    }

    public int doExecute(int i, int j){
        return strategy.doOperation(i, j);
    }
}
