public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // advantage of using setter: you can customize/isolate setting rules
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }


    }

    public String getModel() {
        return model;
    }
}
