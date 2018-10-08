package app.comp.entity.data;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "krp")
public class Krp implements Serializable {


    private Long id;
    private String value;
    private int number;
    private String type;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "number", nullable = false, unique = true)
    @NotEmpty(message = "{validation.company.name.NotEmpty.message}")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Krp)) return false;

        Krp krp = (Krp) o;

        if (getNumber() != krp.getNumber()) return false;
        if (!getId().equals(krp.getId())) return false;
        if (!getValue().equals(krp.getValue())) return false;
        return getType() != null ? getType().equals(krp.getType()) : krp.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getNumber();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Krp{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                '}';
    }
}
