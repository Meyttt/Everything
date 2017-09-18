package clones;

import java.util.Date;

/**
 * Created by Meyttt on 16.09.2017.
 */
public class Fake {
    String name;
    Date createDate;
    String owner;

    public Fake(String name, Date createDate, String owner) {
        this.name = name;
        this.createDate = createDate;
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Fake " +this.getName()+" was created "+this.getCreateDate()+ " and has owner "+this.getOwner();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fake fake = new Fake("Fake1", new Date(),"Meyttt");
        Fake fakeClone= (Fake) fake.clone();
    }

}
