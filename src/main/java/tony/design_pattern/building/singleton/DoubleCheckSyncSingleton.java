package tony.design_pattern.building.singleton;

public class DoubleCheckSyncSingleton {

    // 注意下必须是volatile，否则线程可能看到对象处于无效或错误状态，详情了解JMM
    private static volatile DoubleCheckSyncSingleton instance = null;

    public static DoubleCheckSyncSingleton getInstance(){
        if (null == instance){
            synchronized (DoubleCheckSyncSingleton.class){
                if (null == instance){
                    instance = new DoubleCheckSyncSingleton();
                }
            }
        }
        return instance;
    }

    private DoubleCheckSyncSingleton(){}
}
