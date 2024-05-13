public class NameValidator {
    public NameValidator(){}

    public String validate(String fn, String ln) throws Exception {
        if(fn.equals(null) || ln.equals(null)){
            throw new Exception("Invalid Name");
        }
        else{
            fn = fn.toLowerCase();
            fn = fn.substring(0,1).toUpperCase() + fn.substring(1);
            ln = ln.toLowerCase();
            ln = ln.substring(0,1).toUpperCase() + ln.substring(1);
            return fn + " " + ln;
        }
    }
}
