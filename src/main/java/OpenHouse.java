
import javax.persistence.*;
@Entity
@Table(name = "OPENHOUSE")
public class OpenHouse extends Round {
    @Column(name = "NAME", nullable = false)
    private String name;

    @Id
    @Column(name = "PHONENUMBER", nullable = false, unique = true)
    private String phonenumber;

    @Id
    @Column(name = "DORM", nullable = false)
    private String dorm;

    @Embedded
    private Photo photo;

    public OpenHouse(){}

    public OpenHouse(String fn, String ln, String number, String dorm, Photo photo) throws Exception {
        super(fn,ln,number,dorm,photo);
    }

    public FirstRound push(){
        return new FirstRound(this.name, this.phonenumber, this.dorm, this.photo);
    }
}
