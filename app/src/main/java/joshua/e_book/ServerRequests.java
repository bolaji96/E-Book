package joshua.e_book;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by OLUWASONA on 21/11/2016.
 */
public class ServerRequests {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://kayodeoluwasona.bugs3.com/";

    public ServerRequests(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(true);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeMembersDataInBackground(Members members, GetMembersCallBack memberCallBack) {
        progressDialog.show();
        new StoreMembersDataAsyncTask(members, memberCallBack).execute();
    }

    public void fetchMembersDataInBackground(Members members, GetMembersCallBack callBack) {
        progressDialog.show();
        new fetchMembersDataAsyncTask (members, callBack).execute();
    }

    public class StoreMembersDataAsyncTask extends AsyncTask<Void, Void, Void> {
        Members members;
        GetMembersCallBack membersCallBack;

        public StoreMembersDataAsyncTask(Members members, GetMembersCallBack membersCallBack) {
            this.members = members;
            this.membersCallBack = membersCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {

            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("Name", members.Username));
            dataToSend.add(new BasicNameValuePair("EmailAddress", members.EmailAddress));
            dataToSend.add(new BasicNameValuePair("Password", members.Password));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "public_html/register.php");

            try{
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            membersCallBack.done(null);
            super.onPostExecute(aVoid);
        }
    }

    public class fetchMembersDataAsyncTask extends AsyncTask<Void, Void, Members> {
        Members members;
        GetMembersCallBack membersCallBack;

            public fetchMembersDataAsyncTask(Members members, GetMembersCallBack membersCallBack) {
            this.members = members;
            this.membersCallBack = membersCallBack;
        }

        @Override
        protected Members doInBackground(Void... params) {

            ArrayList<NameValuePair> dataToSend = new ArrayList<>(2);
            dataToSend.add(new BasicNameValuePair("Name", members.Username));
            dataToSend.add(new BasicNameValuePair("Password", members.Password));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "public_html/FetchMembersData.php");
            Members returnedMembers = null;
            try {

                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);
                JSONObject jObject = new JSONObject(result);

                if (jObject.length() == 0) {
                    returnedMembers = null;
                } else {
                    String EmailAddress = jObject.getString("EmailAddress");

                    returnedMembers = new Members(members.Username, members.Password, EmailAddress);
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return returnedMembers;
        }

        @Override
        protected void onPostExecute(Members returnedMembers) {
            progressDialog.dismiss();
            membersCallBack.done(returnedMembers);
            super.onPostExecute(returnedMembers);
        }

    }
}
