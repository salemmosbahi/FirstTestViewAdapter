package it.altagem.firsttestviewadapter;

import android.support.test.rule.ActivityTestRule;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class MainActivityTest extends AndroidTestCase {
    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity;
    private CustomerAdapter mAdapter;

    private User Stuart;
    private User Mark;
    private User Dave;

    @Before
    public void setUp() throws Exception {
        mActivity = mRule.getActivity();
        ArrayList<User> users = new ArrayList<User>();
        Stuart = new User(1, "Stuart");
        Mark = new User(2, "Mark");
        Dave = new User(3, "Dave");
        users.add(Stuart);
        users.add(Mark);
        users.add(Dave);
        mAdapter = new CustomerAdapter(getContext(), R.layout.item_list, users);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

    @Test public void initViewOfMainActivity() {
        View mView = mActivity.findViewById(R.id.listView_users);
        assertNotNull("ListView is null", mView);
    }

    @Test public void initViewOfItemList() {
        View txId = mActivity.findViewById(R.id.tv_id);
        View tvName = mActivity.findViewById(R.id.tv_name);
        assertNotNull("id TextView is null", txId);
        assertNotNull("name TextView is null", tvName);
    }

    @Test public void shouldGetView() {
        View view = mAdapter.getView(0, null, null);
        TextView txId = (TextView) view.findViewById(R.id.tv_id);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);

        assertNotNull("View is null. ", view);
        assertNotNull("id TextView is null. ", txId);
        assertNotNull("name TextView is null. ", tvName);

        assertEquals("id doesn't match.", Stuart.id(), txId.getText());
        assertEquals("name doesn't match.", Stuart.name(), tvName.getText());
    }

    @Test public void shouldGetItem() {
        assertEquals("Omar was expected.", Stuart.name(),
                ((User) mAdapter.getItem(0)).name());
    }

    @Test public void shouldGetItemId() {
        assertEquals("wrong ID.", 0, mAdapter.getItemId(0));
    }

    @Test public void shouldGetCount() {
        assertEquals("users amount incorrect.", 3, mAdapter.getCount());
    }
}