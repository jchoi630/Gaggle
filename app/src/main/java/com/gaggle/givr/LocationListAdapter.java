package com.gaggle.givr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationListAdapter extends ArrayAdapter<Location> {
    private ArrayList<Location> list;
    Context mContext;

    private static class ViewHolder {
        TextView name;
        TextView address;
    }

    public LocationListAdapter(ArrayList<Location> list, Context context) {
        super(context, R.layout.location_item, list);
        this.list = list;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Location loc = getItem(position);
        String addressString = loc.getStreetAddress() + ", "
                + loc.getCity() + ", "
                + loc.getState();

        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.location_item, parent, false);

            vh.name = (TextView) convertView.findViewById(R.id.nameText);
            vh.address = (TextView) convertView.findViewById(R.id.addressText);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.name.setText(loc.getName());
        vh.address.setText(addressString);
        return convertView;
    }
}