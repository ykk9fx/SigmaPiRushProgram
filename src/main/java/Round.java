public class Round {
    private String name;
    private String phonenumber;
    private String dorm;
    private Photo photo;


    public Round(){}
    public Round(String fn, String ln, String number, String dorm, Photo photo) throws Exception {
        NameValidator nv = new NameValidator();
        PhoneNumberValidator pnv = new PhoneNumberValidator();
        DormValidator dv = new DormValidator();
        this.name = nv.validate(fn, ln);
        this.phonenumber = pnv.validate(number);
        this.dorm = dv.validate(dorm);
        this.photo = photo;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String fn, String ln) throws Exception {
        NameValidator nv = new NameValidator();
        this.name = nv.validate(fn, ln);
    }

    public String getPhoneNumber(){
        return this.phonenumber;
    }

    public void setPhonenumber(String number) throws Exception {
        PhoneNumberValidator pnv = new PhoneNumberValidator();
        this.phonenumber = pnv.validate(number);
    }

    public String getDorm(){
        return this.dorm;
    }

    public void setDorm(String str) throws Exception {
        DormValidator dv = new DormValidator();
        this.dorm = dv.validate(str);
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void setPhoto(Photo ph){
        this.photo = ph;
    }
}
