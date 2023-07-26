package web.model;

public class Car {
    private String name;
    private String model;
    private String year;

    public Car(String name, String model, String year) {
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                        ", model='" + model + '\'' +
                        ", year='" + year;
    }
}
