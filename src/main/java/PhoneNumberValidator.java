
public class PhoneNumberValidator {
    public PhoneNumberValidator(){}

    public String validate(String str) throws Exception {
        if(!(isNumeric(str)) || str.length() != 10){
            throw new Exception("Invalid Phone Number");
        }
        else{
            String pt1 = "(" + str.substring(0,3) + ")";
            String pt2 = " " + str.substring(3,6) + "-" + str.substring(6);
            return pt1 + pt2;
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
