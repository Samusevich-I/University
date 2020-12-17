package com.a.tmdbclient.ui.main;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.a.tmdbclient.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuListViewAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<MenuItem> mHeaderList;
    private HashMap<MenuItem, List<MenuItem>> mChildList;

    MenuListViewAdapter(Context context) {
        mContext = context;
        mHeaderList = new ArrayList<>();
        mChildList = new HashMap<>();

        MenuItem moviesMenuItem = new MenuItem("Movies", true, true);
        MenuItem showsMenuItem = new MenuItem("TV Shows", true, true);
        MenuItem peoplesMenuItem = new MenuItem("People", true, true);
        MenuItem favorite = new MenuItem("Favorite", true, true);

        mHeaderList.add(moviesMenuItem);
        mHeaderList.add(showsMenuItem);
        mHeaderList.add(peoplesMenuItem);
        mHeaderList.add(favorite);

        List<MenuItem> childModelsList = new ArrayList<>();
        childModelsList.add(new MenuItem("Popular", false, R.id.nav_popular_movies));
        childModelsList.add(new MenuItem("Top Rated", false, R.id.nav_top_rated_movies));
        childModelsList.add(new MenuItem("Upcoming", false, R.id.nav_upcoming_movies));
        childModelsList.add(new MenuItem("Playing now", false, R.id.nav_now_playing_movies));
        mChildList.put(moviesMenuItem, childModelsList);

        childModelsList = new ArrayList<>();
        childModelsList.add(new MenuItem("Popular", false, R.id.nav_popular_shows));
        childModelsList.add(new MenuItem("Best", false, R.id.nav_top_rated_shows));
        childModelsList.add(new MenuItem("Upcoming", false, R.id.nav_upcoming_shows));
        childModelsList.add(new MenuItem("Airing Today", false, R.id.nav_now_playing_shows));
        mChildList.put(showsMenuItem, childModelsList);

        childModelsList = new ArrayList<>();
        childModelsList.add(new MenuItem("Popular", false, R.id.nav_people));
        mChildList.put(peoplesMenuItem, childModelsList);

        childModelsList = new ArrayList<>();
        childModelsList.add(new MenuItem("Movies", false, R.id.nav_fav_movies));
        mChildList.put(favorite, childModelsList);
    }

    @Override
    public MenuItem getChild(int groupPosition, int childPosition) {
        return mChildList.get(mHeaderList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = getChild(groupPosition, childPosition).getMenuName();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group_child, null);
        }

        TextView txtListChild = convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (mChildList.get(mHeaderList.get(groupPosition)) == null)
            return 0;
        else
            return mChildList.get(mHeaderList.get(groupPosition)).size();
    }

    @Override
    public MenuItem getGroup(int groupPosition) {
        return mHeaderList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return mHeaderList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).getMenuName();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group_header, null);
        }

        TextView groupHeaderTextView = convertView.findViewById(R.id.lblListHeader);
        groupHeaderTextView.setTypeface(null, Typeface.BOLD);
        groupHeaderTextView.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
