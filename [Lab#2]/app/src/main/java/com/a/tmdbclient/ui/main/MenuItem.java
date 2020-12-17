package com.a.tmdbclient.ui.main;

class MenuItem {

    private String mMenuName;
    private boolean mHasChildren, mIsGroup;
    private int mResId;

    MenuItem(String menuName, boolean isGroup, boolean hasChildren) {
        mMenuName = menuName;
        mIsGroup = isGroup;
        mHasChildren = hasChildren;
    }

    MenuItem(String menuName, boolean isGroup, int resId) {
        mMenuName = menuName;
        mIsGroup = isGroup;
        mResId = resId;
    }

    String getMenuName() {
        return mMenuName;
    }

    boolean hasChildren() {
        return mHasChildren;
    }

    int getResId() {
        return mResId;
    }
}