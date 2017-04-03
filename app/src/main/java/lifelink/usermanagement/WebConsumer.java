package lifelink.usermanagement;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lifelink.usermanagement.user.UserContent;

public class WebConsumer {
    public static String requestContent(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        String result = null;
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = null;
        InputStream instream = null;

        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                instream = entity.getContent();
                result = convertStreamToString(instream);
            }

        } catch (Exception e) {
            e.getMessage();
            // manage exceptions
        } finally {
            if (instream != null) {
                try {
                    instream.close();
                } catch (Exception exc) {

                }
            }
        }

        return result;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }

        return sb.toString();
    }

    public static ArrayList<UserContent.User> serializeJSONRequest(String res) {
        ArrayList<UserContent.User> users = new ArrayList<>();

        try {
            JSONArray items = new JSONArray(res);

            for (int i = 0; i < items.length(); i++) {
                JSONObject userObject = items.getJSONObject(i);
                UserContent.User user = new UserContent.User(
                        userObject.getString("id"),
                        userObject.getString("name"),
                        userObject.getString("username"),
                        userObject.getString("email"),
                        userObject.getJSONObject("address").getString("street"),
                        userObject.getJSONObject("address").getString("suite"),
                        userObject.getJSONObject("address").getString("city"),
                        userObject.getJSONObject("address").getString("zipcode"),
                        userObject.getJSONObject("address").getJSONObject("geo").getString("lat"),
                        userObject.getJSONObject("address").getJSONObject("geo").getString("lng"),
                        userObject.getString("phone"),
                        userObject.getString("website"),
                        userObject.getJSONObject("company").getString("name"),
                        userObject.getJSONObject("company").getString("catchPhrase"),
                        userObject.getJSONObject("company").getString("bs")
                );
                users.add(user);
            }
        } catch (JSONException e) {
            e.getMessage();
            // manage exceptions
        }
        return users;
    }
}
