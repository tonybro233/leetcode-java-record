import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {

    /**
     * 运行时指定的泛型会被擦除
     * 作为元数据的泛型(例如如下示例)会保留下来可以通过反射获取
     */
    public static void main(String[] args) throws Exception {
        ParameterizedType type = (ParameterizedType) Bar.class.getGenericSuperclass();
        System.out.println("Bar definition, Bar extends Foo<String> => Can get :" +
                type.getActualTypeArguments()[0]);

        ParameterizedType fieldType = (ParameterizedType)
                Foo.class.getField("children").getGenericType();
        System.out.println("Foo's member: List<Bar> children => Can get :" +
                fieldType.getActualTypeArguments()[0]);

        ParameterizedType paramType = (ParameterizedType)
                Foo.class.getMethod("foo", List.class)
                        .getGenericParameterTypes()[0];
        System.out.println("Foo's method foo(List<String> f) => Can get :" +
                paramType.getActualTypeArguments()[0]);

        System.out.println("Foo definition Foo<E extends CharSequence> => Can get :" +
                Foo.class.getTypeParameters()[0].getBounds()[0]);

        ParameterizedType paramBoundType = (ParameterizedType)
                Foo.class.getMethod("bar", List.class)
                .getGenericParameterTypes()[0];

        WildcardType type1 = (WildcardType) paramBoundType.getActualTypeArguments()[0];
        System.out.println("Foo's method's parameter => Can get :" + type1.getUpperBounds()[0]);
    }

    class Foo<E extends CharSequence> {
        public List<Bar> children = new ArrayList<Bar>();
        public List<StringBuilder> foo(List<String> foo) {return null; }
        public void bar(List<? extends String> param) {}
    }

    class Bar extends Foo<String> {}
}
