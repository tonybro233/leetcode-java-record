package tony.design_pattern.structure.proxy._static;

import tony.design_pattern.structure.proxy.Subject;

public class SubjectProxy implements Subject {

    private Subject delegate;

    public SubjectProxy(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void dealTask(String taskName) {
        long stime = System.currentTimeMillis();
        delegate.dealTask(taskName);
        long ftime = System.currentTimeMillis();
        System.out.println("Using time: "+(ftime - stime)+"ms");
    }

    @Override
    public void abortTask(String taskName) {
        long stime = System.currentTimeMillis();
        delegate.abortTask(taskName);
        long ftime = System.currentTimeMillis();
        System.out.println("Using time: "+(ftime - stime)+"ms");
    }
}
