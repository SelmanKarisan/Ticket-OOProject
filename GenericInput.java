public class GenericInput {
    private String properyName;
    private String message;
    private String type;
    private Object value;

    public GenericInput(String properyName, String message, String type, Object value) {
        this.properyName = properyName;
        this.message = message;
        this.type = type;
        this.value = value;
    }

    public String getProperyName() {
        return properyName;
    }

    public void setProperyName(String properyName) {
        this.properyName = properyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
