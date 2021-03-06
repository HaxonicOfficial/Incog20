package com.example.deepakyadav.incog20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deepakyadav.incog20.DataModel.SessionHandler;
import com.example.deepakyadav.incog20.DataModel.WebViewTabs;

import java.util.ArrayList;

public class SessionAdapter extends BaseAdapter{

    ArrayList<SessionHandler> data;
    Context context;
    private static LayoutInflater inflater=null;

    public SessionAdapter(MainActivity mainActivity, ArrayList<SessionHandler> data) {
        this.data = data;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView title,url;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.session_list, null);
        holder.title = rowView.findViewById(R.id.session_title);
        holder.url = rowView.findViewById(R.id.session_url);
//        holder.favicon = rowView.findViewById(R.id.list_favicon);
        holder.title.setText(data.get(position).getTitle());
        holder.url.setText(data.get(position).getUrl());
//        holder.favicon.setImageBitmap(data.get(position).getFavicon());

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewTabs.openSessionFromList(data.get(position).getUrl());
            }
        });

        return rowView;
    }

}
