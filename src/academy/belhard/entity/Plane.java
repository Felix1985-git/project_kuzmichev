package academy.belhard.entity;

public class Plane {
    private int id;
    private String brand;
    private String model;
    private Integer capacity;
    private String taleNumber;

    public Plane(int id, String brand, String model, int capacity, String taleNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.taleNumber = taleNumber;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getTaleNumber() {
        return taleNumber;
    }

    @Override
    public String toString() {
        return "Planes{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", capacity='" + capacity + '\'' +
                ", taleNumber='" + taleNumber + '\'' +
                '}';
    }
}
