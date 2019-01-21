package tony.design_pattern.structure.facade;

public class DemoRuner {

    public static void main(String[] args){
        // Computer is a facade, we just have to start it or stop it,
        // don't have to consider the inner system.
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
