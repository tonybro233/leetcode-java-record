package tony.design_pattern.behavior.responsibility_chain;

public interface HandlerChain {

    void doHandler(Object object);

    void reset();
}
