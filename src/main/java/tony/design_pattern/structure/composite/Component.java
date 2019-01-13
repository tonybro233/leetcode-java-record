package tony.design_pattern.structure.composite;

public abstract class Component {

    private String name;

    public Component(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void add(Component c); //增加成员

    public abstract void remove(Component c); //删除成员

    public abstract Component getChild(int i); //获取成员

    public abstract void operation(String pre);  //业务方法

}
