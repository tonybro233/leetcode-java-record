package tony.design_pattern.behavior.responsibility_chain;

public class IntegerHandler implements Handler {

    @Override
    public void handle(Object object, HandlerChain chain) {
        if (null == object || null == chain){
            System.out.println("Null, boy");
            return;
        }
        Class<?> clazz = object.getClass();
        if (Integer.class.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz)){
            Integer i = (Integer) object;
            System.out.println("An int, value:"+i);
        } else {
            chain.doHandler(object);
        }
    }
}
