package clones;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;

/**
 * Created by Meyttt on 16.09.2017.
 */
public class Original implements Cloneable {
    String name;
    Date createDate;
    String owner;

    public Original(String name, Date createDate, String owner) {
        this.name = name;
        this.createDate = createDate;
        this.owner = owner;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Original original = new Original("Original1", new Date(),"Meyttt");
        Original clone = (Original) original.clone();
        System.out.println(original);
        System.out.println(clone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Original original = new Original(this.getName(),this.getCreateDate(),this.getOwner());
        return original;
    }

    @Override
    public String toString() {
        return this.getName()+" was created " +this.getCreateDate()+" and has owner "+this.getOwner();
    }
}
