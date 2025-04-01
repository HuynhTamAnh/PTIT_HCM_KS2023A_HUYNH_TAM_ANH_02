package ra.validate;

public class ValidateString {
    private String regex;
    private int minLength;
    private int maxLength;

    public ValidateString(int minLength, int maxLength, String regex) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.regex = regex;
    }

    public boolean isValid( String value) {
        return value.length() >= minLength && value.length() <= maxLength;
    }
    public String getErrorMessage(){
        return "The string must be between " + minLength + " and " + maxLength + " characters long.";
    }
    public boolean matches(String value){
        return value.matches(regex);
    }
}