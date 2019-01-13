package tony.design_pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private List<Component> childComponents = new ArrayList<Component>();

    public Composite(String name){
        super(name);
    }

    @Override
    public void add(Component c) {
        this.childComponents.add(c);
    }

    @Override
    public void remove(Component c) {
        this.childComponents.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return childComponents.get(i);
    }

    @Override
    public void operation(String pre) {
        System.out.println(pre + "My name: "+getName());
        if (childComponents.size() > 0) {
            // System.out.println(pre + "My children: ");
            pre += "  ";
            for (Component component : this.childComponents) {
                component.operation(pre);
            }
        }
    }
}
