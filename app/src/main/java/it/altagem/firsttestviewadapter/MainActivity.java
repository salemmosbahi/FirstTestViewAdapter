package it.altagem.firsttestviewadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewI {

    private ListView mListView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        mListView = findViewById(R.id.listView_users);
        loadDataPage();
    }

    @Override
    public void loadDataPage() {
        List<User> mUsers = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            mUsers.add(new User(i, "Stuart"));
        CustomerAdapter mAdapter = new CustomerAdapter(mContext, R.layout.item_list, mUsers);
        mListView.setAdapter(mAdapter);
    }
}
