

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ValidatePassword {

    public static boolean passwordValidation(String pwd) {
        if(pwd==null){
            throw new IllegalArgumentException("Password can't be null");
        }

        int length = pwd.length();
        boolean upper = false;
        boolean lower = false;
        boolean digit=false;

        for(char ch: pwd.toCharArray()){
            if(Character.isUpperCase(ch)) upper=true;
            if(Character.isLowerCase(ch)) lower=true;
            if(Character.isDigit(ch)) digit=true;

            if(upper && lower && digit)
                break;
        }

        int resultMet=0;
        if(length>8) resultMet++;
        if(upper) resultMet++;
        if (lower) resultMet++;
        if(digit) resultMet++;

        if(length<=8){
            throw  new IllegalArgumentException("Password must be longer than 8 chars");
        }

        if(!upper){
            throw  new IllegalArgumentException("Password must contain at least 1 uppercase");
        }

        if(!lower){
            throw  new IllegalArgumentException("Password must contain at least 1 lowercase");
        }

        if(!digit){
            throw  new IllegalArgumentException("Password must contain at least 1 digit");
        }


        return true;

    }
    public static void main(String[] args) {


        try {
        boolean valid=  passwordValidation("Pwd123456");
        System.out.println("Password is valid");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}