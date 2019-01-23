package tony.design_pattern.structure.proxy.dynamic;

import tony.design_pattern.structure.proxy.Subject;

import java.lang.reflect.Proxy;

public class SubjectDynamicProxyFactory {

    public static Subject getInstance(Subject real){
        Object proxy = Proxy.newProxyInstance(real.getClass().getClassLoader(),
                real.getClass().getInterfaces(),
                new SubjectDynamicProxy(real));
        return (Subject) proxy;
    }
}
