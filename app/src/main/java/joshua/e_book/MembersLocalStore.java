package joshua.e_book;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by OLUWASONA on 21/11/2016.
 */
public class MembersLocalStore {
    public static final String SP_NAME = "memberDetails";
    SharedPreferences membersLocalDatabase;

    public MembersLocalStore(Context context) {
        membersLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeMembersData (Members  members){
        SharedPreferences.Editor spEditor = membersLocalDatabase.edit();
        spEditor.putString("Name", members.Username);
        spEditor.putString("EmailAddress", members.EmailAddress);
        spEditor.putString("Password", members.Password);
        spEditor.commit();
    }

    public Members getLoggedInMembers() {
        String Username = membersLocalDatabase.getString("Username", "");
        String EmailAddress = membersLocalDatabase.getString("EmailAddress", "");
        String Password = membersLocalDatabase.getString("Password", "");


        Members storedMembers = new Members(Username, EmailAddress, Password);
        return storedMembers;
    }

    public void setMembersLoggedIn (boolean LoggedIn) {
        SharedPreferences.Editor spEditor = membersLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", LoggedIn);
        spEditor.commit();
    }

    public boolean getMembersLoggedIn() {
        if (membersLocalDatabase.getBoolean("LoggedIn", false) == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void clearMemberData() {
        SharedPreferences.Editor spEditor = membersLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
