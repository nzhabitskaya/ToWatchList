package com.mobile.android.chameapps.towatchlist.tools;

public class Util {

    public static String getCurrentTime() {
        long tsLong = System.currentTimeMillis() / 1000;
        return Long.toString(tsLong);
    }
}
