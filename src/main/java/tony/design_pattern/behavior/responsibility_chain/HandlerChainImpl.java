package tony.design_pattern.behavior.responsibility_chain;

public class HandlerChainImpl implements HandlerChain {

    private Handler[] handlers;
    private int cursor;

    public HandlerChainImpl(Handler[] handlers){
        this.handlers = handlers;
        cursor = 0;
    }

    @Override
    public void doHandler(Object object) {
        if (cursor < handlers.length){
            handlers[cursor++].handle(object,this);
        } else{
            System.out.println("Sorry, can't handle that");
        }
    }

    @Override
    public void reset() {
        this.cursor = 0;
    }
}
