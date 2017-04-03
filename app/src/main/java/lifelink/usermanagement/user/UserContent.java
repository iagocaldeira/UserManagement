package lifelink.usermanagement.user;

import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lifelink.usermanagement.WebConsumer;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 */
public class UserContent {

    /**
     * An array of (User) users.
     */
    public static List<User> users = new ArrayList<User>();

    /**
     * A map of (User) users, by ID.
     */
    public static Map<String, User> ITEM_MAP = new HashMap<String, User>();

    private static void addItem(User user) {
        users.add(user);
        ITEM_MAP.put(user.id, user);
    }

    private static String makeDetails(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append("Detalhes: ");
        builder.append("\nId: ").append(user.id);
        builder.append("\nName: ").append(user.name);
        builder.append("\nUsername: ").append(user.username);
        builder.append("\nEmail: ").append(user.email);
        builder.append("\nStreet: ").append(user.street);
        builder.append("\nSuite: ").append(user.suite);
        builder.append("\nCity: ").append(user.city);
        builder.append("\nZipcode: ").append(user.zipcode);
        builder.append("\nLat: ").append(user.lat);
        builder.append("\nLng: ").append(user.lng);
        builder.append("\nPhone: ").append(user.phone);
        builder.append("\nWebsite: ").append(user.website);
        builder.append("\nCompany name: ").append(user.company_name);
        builder.append("\nCompany catch phrase: ").append(user.company_catchPhrase);
        builder.append("\nCompany bs: ").append(user.company_bs);
        return builder.toString();
    }

    /**
     * A User data representation.
     */
    public static class User {
        public String id;
        public String name;
        public String username;
        public String email;
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public String lat;
        public String lng;
        public String phone;
        public String website;
        public String company_name;
        public String company_catchPhrase;
        public String company_bs;

        @Override
        public String toString() {
            return name + '\n' + email;
        }

        public User(String id, String name, String username, String email, String street, String suite, String city, String zipcode, String lat, String lng, String phone, String website, String company_name, String company_catchPhrase, String company_bs) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.lat = lat;
            this.lng = lng;
            this.phone = phone;
            this.website = website;
            this.company_name = company_name;
            this.company_catchPhrase = company_catchPhrase;
            this.company_bs = company_bs;

            addItem(this);
        }


    }
}
