package com.example.exercise1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<Nama> arrayList;

    @Override
    public int getCount() {
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.item_listview, null);

            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getNama());

        return view;
    }


    public ListViewAdapter(Context context) {

        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Nama>();
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }

    public void filter(String s) {
        String charText2 = s.toLowerCase(Locale.getDefault());
        HomeActivity.classNamaArrayList.clear();
        if (charText2.length() == 0) {
            HomeActivity.classNamaArrayList.addAll(this.arrayList);
        } else {
            Iterator<Nama> it = this.arrayList.iterator();
            while (it.hasNext()) {
                Nama cn = it.next();
                if (cn.getNama().toLowerCase(Locale.getDefault()).contains(charText2)) {
                    HomeActivity.classNamaArrayList.add(cn);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder {
        TextView name;
    }
}
