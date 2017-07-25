package joshua.e_book;

/**
 * Created by OLUWASONA on 21/11/2016.
 */
public class Members {
    String Username, EmailAddress, Password;

    public Members(String Username, String EmailAddress, String Password) {
        this.Username = Username;
        this.EmailAddress = EmailAddress;
        this.Password = Password;
    }

    public Members(String Username, String Password) {
        this.Password = Password;
        this.Username = Username;
        this.EmailAddress = "";
    }

}
