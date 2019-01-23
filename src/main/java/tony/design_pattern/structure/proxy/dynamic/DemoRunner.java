package tony.design_pattern.structure.proxy.dynamic;

import tony.design_pattern.structure.proxy.RealSubject;
import tony.design_pattern.structure.proxy.Subject;

public class DemoRunner {

    public static void main(String[] args){
        Subject subject = SubjectDynamicProxyFactory.getInstance(new RealSubject());
        subject.dealTask("Clean room");
        System.out.println();
        subject.abortTask("Read book");
    }
}
