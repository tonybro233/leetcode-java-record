package tony.design_pattern.building.singleton;

/**
 * 调用getInstance方法，才会装载SingletonFactory这个内部类，
 * 因此这种方法属于饿汉式按需加载
 */
public class InnerClassSingleton {

    private static class SingletonFactory {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonFactory.INSTANCE;
    }

    private InnerClassSingleton(){}
}
