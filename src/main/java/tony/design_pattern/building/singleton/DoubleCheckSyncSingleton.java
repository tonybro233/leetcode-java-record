package tony.design_pattern.building.singleton;

public class DoubleCheckSyncSingleton {

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
