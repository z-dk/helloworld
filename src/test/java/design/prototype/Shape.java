package design.prototype;

/**
 * <b>类 名 称</b> :  Shape<br/>
 * <b>类 描 述</b> :  shape<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 15:55<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 15:55<br/>
 * <b>修改备注</b> :
 */
public abstract class Shape implements Cloneable{
    
    private String id;
    
    protected String type;
    
    abstract void draw();
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public Object clone(){
        Object clone = null;
        try {
            //先进行浅复制，之后再根据需要复制引用类型的对象
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
