package exceptions;
public class UserError extends Exception{
    public UserError() {
        System.out.println("Os dados inseridos nao sao validos.");
    }
}
