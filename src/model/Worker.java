package model;
import javax.persistence.*;

@Entity
@Table(name="worker")
@NamedQuery(name = "Worker.getAll", query = "SELECT p FROM Worker p")
public class Worker {
    public long getIdWorker() {
        return idWorker;
    }

    public void setId(long idWorker) {
        this.idWorker = idWorker;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }


    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setAll(long idWorker, String firstname, String lastname){
        this.idWorker = idWorker;
        this.Firstname = firstname;
        this.Lastname = lastname;
    }

    @Id
    @Column(name = "id_worker")
    private long idWorker;
    @Column(name="firstname")
    private String Firstname;

    @Column(name = "lastname")
    private String Lastname;

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    @ManyToOne
    @JoinColumn(name="id_dep")
    private String departments;

    @Override
    public String toString() {
        return "Worker{" +
                "idWorker=" + idWorker +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", worker=" + departments +
                '}';
    }

    public Worker(){}

   /* public String toString() {
        return "Worker{" +
                "idWorker=" + idWorker +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                '}';
    }*/
}