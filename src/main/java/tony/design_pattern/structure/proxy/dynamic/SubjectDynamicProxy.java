package tony.design_pattern.structure.proxy.dynamic;

import tony.design_pattern.structure.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectDynamicProxy implements InvocationHandler {

    private Subject subject;

    public SubjectDynamicProxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long stime = System.currentTimeMillis();
        Object result = method.invoke(subject, args);
        long ftime = System.currentTimeMillis();
        System.out.println("Using time: "+(ftime - stime)+"ms");
        return result;
    }
}
