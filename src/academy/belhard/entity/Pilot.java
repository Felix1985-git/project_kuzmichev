package academy.belhard.entity;

public class Pilot {
    private int id;
    private String firstName;
    private String lastName;
    private Rang rang;
    private String code;

    public Pilot(int id, String firstName, String lastName, Rang rang, String code) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rang = rang;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Rang getRang() {
        return rang;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Pilots{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", rang='" + rang + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
