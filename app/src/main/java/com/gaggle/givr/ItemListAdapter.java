package com.gaggle.givr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Item> {
    private ArrayList<Item> list;
    Context mContext;

    private static class ViewHolder {
        TextView name;
    }

    public ItemListAdapter(ArrayList<Item> list, Context context) {
        super(context, R.layout.activity_manage_item_page, list);
        this.list = list;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item i = getItem(position);

        ItemListAdapter.ViewHolder vh;
        if (convertView == null) {
            vh = new ItemListAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_manage_item_page, parent, false);

            vh.name = (TextView) convertView.findViewById(R.id.nameText);
            convertView.setTag(vh);
        } else {
            vh = (ItemListAdapter.ViewHolder) convertView.getTag();
        }

        vh.name.setText(i.getName());
        return convertView;
    }
}

}