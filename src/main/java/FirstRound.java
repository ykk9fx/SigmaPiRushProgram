import javax.persistence.*;
@Entity
@Table(name = "FIRSTROUND")
public class FirstRound extends Round{
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

    @Column(name = "ATTENDANCE")
    private int attendance = 0;

    @Column(name = "QUESTION1")
    private String question1;

    @Column(name = "QUESTION2")
    private String question2;

    @Column(name = "QUESTION3")
    private String question3;

    @Column(name = "NOTES")
    private String notes;
}
