package tony.design_pattern.structure.proxy._static;

import tony.design_pattern.structure.proxy.Subject;

public class SubjectProxyFactory {

    public static Subject getInstance(Subject real){
        return new SubjectProxy(real);
    }
}
