import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ValidatePassword {

    public static void passwordValidation(String pwd) throws Exception{
        if(pwd==null){
            throw new Exception("Password can't be null");
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Boolean> checkLength = ()-> pwd.length()>8;
        Callable<Boolean> checkLower = ()->pwd.chars().anyMatch(Character::isLowerCase);
        Callable<Boolean> checkUpper = ()->pwd.chars().anyMatch(Character::isUpperCase);
        Callable<Boolean> checkNumber = ()->pwd.chars().anyMatch(Character::isDigit);

        Future<Boolean> length = executorService.submit(checkLength);
        Future<Boolean> lower = executorService.submit(checkLower);
        Future<Boolean> upper = executorService.submit(checkUpper);
        Future<Boolean> number = executorService.submit(checkNumber);

        int pass=0;
        if(length.get())pass++;
        if(lower.get())pass++;
        if (upper.get())pass++;
        if (number.get())pass++;

        executorService.shutdown();

        if(!lower.get()){
            throw new Exception("At least 1 lower case is required");
        }

        if(pass<3){
            throw  new Exception("Atleast 3 conditions should satisfy");
        }

        System.out.println("Valid Password");





    }
    public static void main(String[] args) {

        try {
            passwordValidation("Pwd2765757");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}