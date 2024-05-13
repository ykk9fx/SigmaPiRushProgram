public class DormValidator {
    public DormValidator(){}

    public String validate(String str) throws Exception {
        if(str.equals(null)){
            throw new Exception("Dorm can't be null");
        }
        else{
            return str;
        }
    }
}
