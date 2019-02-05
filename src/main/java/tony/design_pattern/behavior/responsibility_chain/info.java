/**
 * 责任链模式为请求创建了一个处理链，发送者将请求发给链的第一个接收者，
 * 并且沿着这条链传递，直到有一个对象来处理它或者直到最后也没有对象处理。
 * 在职责链模式中，每一个对象都有可能来处理请求，从而实现了请求的发送者和接收者之间的解耦。
 *
 * 典型的应用为servlet中filter的使用以及spring的Interceptor
 */
package tony.design_pattern.behavior.responsibility_chain;
