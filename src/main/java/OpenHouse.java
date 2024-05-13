
import javax.persistence.*;
@Entity
@Table(name = "OPENHOUSE")
public class OpenHouse {
    @Column(name = "NAME", nullable = false)
    private String name;

    @Id
    @Column(name = "PHONENUMBER", nullable = false, unique = true)
    private String phonenumber;

    @Id
    @Column(name = "DORM", nullable = false)
    private String dorm;

    @Id
    @Column(name = "Question")
    private String question;

    @Embedded
    private Photo photo;
}
