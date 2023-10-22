package a10_02_DefiningClasses_Ex.p07Google;

public class Parents {

    private String parentName;
    private String parentBDay;

    public Parents(String parentName, String parentBDay) {
        this.parentName = parentName;
        this.parentBDay = parentBDay;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBDay() {
        return parentBDay;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentBDay(String parentBDay) {
        this.parentBDay = parentBDay;
    }
}
