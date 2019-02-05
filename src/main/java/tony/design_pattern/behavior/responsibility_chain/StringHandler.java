package tony.design_pattern.behavior.responsibility_chain;

public class StringHandler implements Handler {
    @Override
    public void handle(Object object, HandlerChain chain) {
        if (null == object || null == chain){
            System.out.println("Null, boy");
            return;
        }
        if (object instanceof String ){
            System.out.println("A string, value:"+object);
        } else {
            chain.doHandler(object);
        }
    }
}
