/**
 * 工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个
 * 当需要增加一个新的产品时，只需要增加一个具体的产品类和与之对应的具体工厂即可，无须修改原有系统。
 * 工厂模式一般来说还需要一个输出对象的基类或者基接口，用于统一描述工厂生产的对象
 *
 * 虽然工厂模式很好的符合了“开闭原则”，但是由于每新增一个新产品时就需要增加两个类，
 * 这样势必会导致系统的复杂度增加
 */
package tony.design_pattern.building.factory;