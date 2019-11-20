package starter2;

import javax.management.RuntimeErrorException;

public class NoMailFoundException extends RuntimeErrorException {
    public NoMailFoundException(String s) {
        super(new Error(("You need to specify mails in your application")));

    }
}
