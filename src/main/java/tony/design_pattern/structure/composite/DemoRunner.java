package tony.design_pattern.structure.composite;

public class DemoRunner {

    public static void main(String[] args){
        Component root = new Composite("D盘");
        Component favoriteDir = new Composite("收藏夹");
        Component picDir = new Composite("图片");
        picDir.add(new Leaf("美女1.png"));
        picDir.add(new Leaf("美女2.png"));
        Component workDir = new Composite("工作");
        workDir.add(new Leaf("需求文档.doc"));
        Component learningDir = new Composite("学习");
        learningDir.add(new Leaf("Java笔记.md"));
        learningDir.add(new Leaf("数据库笔记.doc"));
        root.add(favoriteDir);
        root.add(workDir);
        root.add(learningDir);
        root.add(picDir);
        root.add(new Leaf("log.txt"));
        // Component leaf = new Leaf("test");
        // leaf.addChild(new Leaf("log.txt"));
        // 编译通过,运行报错 root.printStruct("");
        root.operation("");
    }
}
