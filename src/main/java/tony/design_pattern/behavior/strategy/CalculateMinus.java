package tony.design_pattern.behavior.strategy;

public class CalculateMinus implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
