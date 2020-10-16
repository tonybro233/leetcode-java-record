import java.lang.invoke.*;
import java.lang.reflect.Field;

public class InvokeDynamicTest {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                // 实现调用GrandFather.thinking()

                // 安全限制导致抛出异常
                // MethodType mt = MethodType.methodType(void.class);
                // MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class,
                //         "thinking", mt, Father.class);
                // mh.invoke(this);

                MethodType mt = MethodType.methodType(void.class);
                Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);
                MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null))
                        .findSpecial(GrandFather.class, "thinking", mt, Father.class);
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        (new InvokeDynamicTest().new Son()).thinking();
    }
}

