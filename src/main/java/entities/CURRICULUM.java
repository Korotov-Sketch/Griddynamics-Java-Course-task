package entities;

public class CURRICULUM {

    private String description;

    public CURRICULUM(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCURRICULUM() {
        return (getDescription());
    }
}
