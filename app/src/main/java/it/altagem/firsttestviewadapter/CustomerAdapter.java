package it.altagem.firsttestviewadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomerAdapter extends ArrayAdapter<User> {
    private Context mContext;
    private List<User> mUsers;

    public CustomerAdapter(@NonNull Context pContext, @LayoutRes int pResource, @NonNull List<User> pUsers) {
        super(pContext, pResource, pUsers);
        mContext = pContext;
        mUsers = pUsers;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public User getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mUsers.indexOf(getItem(position));
    }

    public View getView(final int position, View convert, ViewGroup parent) {
        HolderLogin holder = null;
        User user = getItem(position);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (null == convert) {
            convert = inflater.inflate(R.layout.item_list, null);
            holder = new HolderLogin();
            holder.txId = (TextView) convert.findViewById(R.id.tv_id);
            holder.tvName = (TextView) convert.findViewById(R.id.tv_name);
            convert.setTag(holder);
        } else
            holder = (HolderLogin) convert.getTag();

        holder.txId.setText(String.valueOf(user.id()));
        holder.tvName.setText(user.name());

        return convert;
    }

    private class HolderLogin {
        private TextView txId;
        private TextView tvName;
    }
}
