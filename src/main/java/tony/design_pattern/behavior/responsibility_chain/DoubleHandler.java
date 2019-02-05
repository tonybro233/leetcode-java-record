package tony.design_pattern.behavior.responsibility_chain;

public class DoubleHandler implements Handler {
    @Override
    public void handle(Object object, HandlerChain chain) {
        if (null == object || null == chain){
            System.out.println("Null, boy");
            return;
        }
        Class<?> clazz = object.getClass();
        if (Double.class.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz)){
            Double i = (Double) object;
            System.out.println("A double, value:"+i);
        } else {
            chain.doHandler(object);
        }
    }
}
