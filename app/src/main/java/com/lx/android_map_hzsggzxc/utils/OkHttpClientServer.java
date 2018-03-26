package com.lx.android_map_hzsggzxc.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by lixian on 2016/6/1.
 */
public class OkHttpClientServer {
    public static OkHttpClient mOkHttpClient =null;
    public static OkHttpClient getOkHttpClient(Context ct) {
        if (mOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10 * 1000, TimeUnit.MILLISECONDS).readTimeout(10 * 1000, TimeUnit.MILLISECONDS);
            OkHttpUtils.init(ct);
            mOkHttpClient = builder.build();
        }
        return mOkHttpClient;
    }



    public static boolean isOpenNetwork(Context ct) {
        ConnectivityManager connManager = (ConnectivityManager) ct.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
