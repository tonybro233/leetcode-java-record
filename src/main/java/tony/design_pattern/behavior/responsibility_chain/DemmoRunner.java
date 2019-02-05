package tony.design_pattern.behavior.responsibility_chain;

import java.util.ArrayList;
import java.util.List;

public class DemmoRunner {

    public static void main(String[] args){
        List<Handler> handlers = new ArrayList<>();
        handlers.add(new StringHandler());
        handlers.add(new IntegerHandler());
        handlers.add(new DoubleHandler());
        Handler[] handlerArray = new Handler[handlers.size()];
        handlers.toArray(handlerArray);
        HandlerChainImpl chain = new HandlerChainImpl(handlerArray);

        chain.doHandler(10.1);
        chain.reset();
        System.out.println("--------------------");
        chain.doHandler(10);
        chain.reset();
        System.out.println("--------------------");
        chain.doHandler("hehe");
        chain.reset();
        System.out.println("--------------------");
        chain.doHandler(new Object());
        chain.reset();
    }
}
