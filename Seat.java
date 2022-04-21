public class Seat {
    private String location;
    private boolean isEmpty;

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isIsEmpty() {
        return this.isEmpty;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Seat(String location, boolean isEmpty) {
        this.location = location;
        this.isEmpty = isEmpty;
    }

}
