package tony.design_pattern.behavior.responsibility_chain;

public interface Handler {

    void handle(Object object, HandlerChain chain);

}
