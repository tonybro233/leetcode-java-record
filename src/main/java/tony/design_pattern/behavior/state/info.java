/**
 * 核心思想就是：当对象的状态改变时，同时改变其行为，对象看起来好像被修改了一样。
 * 在状态模式中我们可以减少大块的if…else语句，状态转换逻辑与状态对象合成一体，
 * 但是减少if…else语句的代价就是会换来大量的类，所以状态模式势必会增加系统中类或者对象的个数。
 * 状态模式对“开闭原则”的支持并不太好，对于可以切换状态的状态模式，
 * 增加新的状态类需要修改那些负责状态转换的源代码
 */
package tony.design_pattern.behavior.state;