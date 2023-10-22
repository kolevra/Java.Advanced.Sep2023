package a10_02_DefiningClasses_Ex.p07Google;

public class Children {

    private String childName;
    private String childBDay;

    public Children(String childName, String childBDay) {
        this.childName = childName;
        this.childBDay = childBDay;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBDay() {
        return childBDay;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public void setChildBDay(String childBDay) {
        this.childBDay = childBDay;
    }
}
