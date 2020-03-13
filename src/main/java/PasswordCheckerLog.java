import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordCheckerLog {

    private static final Logger logger = LogManager.getLogger(PasswordCheckerLog.class.getName());
    static ArrayList<Integer> elements = new ArrayList<>();
    

    public static void main(String[] args) throws Exception {

        System.out.println("(Note: Password must at least be 8 characters long, have an Uppercase,Lowercase, \n at least 1 digit and a special character");
        System.out.println("Please enter a password :  ");
        Scanner userInput = new Scanner(System.in);
        String password = userInput.nextLine();

        boolean status = passwordIsValid(password);
        if(passwordIsOk()){
            System.out.println("Password is ok");
        }
        if(status){
            System.out.println("Passsword Approved!");
        }
        try{
          logger.debug(PasswordCheckerLog.passwordIsOk());
          logger.error(PasswordCheckerLog.passwordIsValid(password));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


    public static boolean passwordIsValid(String password)
    {

        boolean status = false;

        if(password.isEmpty()){
            logger.error("Password should not be empty!");
            elements.add(1);

        }
        if(password.length()<8){
            logger.error("password should be at least be 8 characters long");
            elements.add(1);

        }
        if(!password.matches(".*[A-Z].*")){
            logger.error("password should have at least one uppercase letter");
            elements.add(1);

        }
        if(!password.matches(".*[a-z].*")){
            logger.error("password should have at least one lowercase letter");
            elements.add(1);
        }
        if(!password.matches(".*[0-9].*")){
            logger.error("password should have at least one digit");
            elements.add(1);
        }
        if(!password.matches("(.*[-~!@#$%^&*(){}_\"\"+]).*")){
            logger.error("password should have at least one Special character");
            elements.add(1);
        }
        if(!password.isEmpty() && password.length()>8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*") &&
                password.matches("(.*[-~!@#$%^&*()_+]).*")){
            status = true;
        }

        return status;

    }

    public  static  boolean passwordIsOk()
    throws Exception{

        boolean status = false;
        try {
            if(elements.size() > 0 && elements.size()< 4) {
                status = true;
            }

        }catch (Exception e){
            status = false;
        }

        return status;

    }



}