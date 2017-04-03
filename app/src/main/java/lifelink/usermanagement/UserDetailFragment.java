package lifelink.usermanagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import lifelink.usermanagement.user.UserContent;

/**
 * A fragment representing a single User detail screen.
 * This fragment is either contained in a {@link UserListActivity}
 * in two-pane mode (on tablets) or a {@link UserDetailActivity}
 * on handsets.
 */
public class UserDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private UserContent.User mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = UserContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ListView details_list = (ListView) rootView.findViewById(R.id.user_detail_list);

            ArrayList<String> details = new ArrayList<>();
            details.add("Id: "+mItem.id );
            details.add("Name: "+mItem.name );
            details.add("Username: "+mItem.username );
            details.add("Email: "+mItem.email );
            details.add("Street: "+mItem.street );
            details.add("Suite: "+mItem.suite );
            details.add("City: "+mItem.city );
            details.add("Zipcode: "+mItem.zipcode );
            details.add("Lat: "+mItem.lat );
            details.add("Lng: "+mItem.lng );
            details.add("Phone: "+mItem.phone );
            details.add("Website: "+mItem.website );
            details.add("Company name: "+mItem.company_name );
            details.add("Company catch phrase: "+mItem.company_catchPhrase );
            details.add("Company bs: "+mItem.company_bs );

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, details);

            details_list.setAdapter(adapter);

        }

        return rootView;
    }
}
