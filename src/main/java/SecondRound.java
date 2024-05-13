import javax.persistence.*;
@Entity
@Table(name = "SECONDROUND")
public class SecondRound extends Round{
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

    @Column(name = "BROTHER TEXTING", nullable = false)
    private String brother;

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

    public SecondRound(String name, String number, String dorm, Photo photo){
        this.name = name;
        this.phonenumber = number;
        this.dorm = dorm;
        this.photo = photo;
    }

    public SecondRound() {}

    public String getBrother(){
        return this.brother;
    }

    public void setBrother(String str){
        this.brother = str;
    }

    public int getAttendance(){
        return this.attendance;
    }

    public void setAttendance(int i){
        this.attendance = i;
    }

    public String getQuestion1(){
        return this.question1;
    }

    public void setQuestion1(String str){
        this.question1 = str;
    }

    public String getQuestion2(){
        return this.question2;
    }

    public void setQuestion2(String str){
        this.question2 = str;
    }

    public String getQuestion3(){
        return this.question3;
    }

    public void setQuestion3(String str){
        this.question3 = str;
    }

    public String getNotes(){
        return this.notes;
    }

    public void setNotes(String str){
        this.notes += str + " ";
    }

    public void registerForEvent1(String str){
        this.attendance++;
        this.question1 = str;
    }

    public void registerForEvent2(String str){
        this.attendance++;
        this.question2 = str;
    }

    public void registerForEvent3(String str){
        this.attendance++;
        this.question3 = str;
    }

    public ThirdRound push(){
        return new ThirdRound(this.name, this.phonenumber, this.dorm, this.photo);
    }
}
    