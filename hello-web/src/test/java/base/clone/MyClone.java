package base.clone;

import java.util.List;

public class MyClone implements Cloneable {

    private Long id;

    private String name;

    private List<Long> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getChildren() {
        return children;
    }

    public void setChildren(List<Long> children) {
        this.children = children;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
