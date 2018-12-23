package tony.design_pattern.building.singleton;

public class SyncSingleton {

    private static SyncSingleton instance = null;

    public static synchronized SyncSingleton getInstance(){
        if (null == instance){
            instance = new SyncSingleton();
        }
        return instance;
    }

    private SyncSingleton(){}
}
