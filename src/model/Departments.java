package model;
import javax.persistence.*;// 10) Dependency hell

@Entity
@Table(name="departments")
@NamedQuery(name = "Departments.getAll", query = "SELECT p FROM Departments p")
public class Departments {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name="dep_name")
    private String Depname;
    private String WorkerName;


    @Override
    /*public String toString() {
        return "Departments{" +
                "id=" + id +
                ", Depname='" + Depname + '\'' +
                '}';
    }*/

    public String toString() {// 7) Hard code 8) Reinventing the square wheel
        StringBuilder stringBuilder = new StringBuilder("Departments " + id + " Depname: ");

        for (char c : Depname.toCharArray()) {
            stringBuilder.append((char) (c + 3));
        }

        return stringBuilder.toString();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepname() {
        return Depname;
    }

    public void setDepname(String depname) {
        Depname = depname;
    }

    public Departments(){}

}