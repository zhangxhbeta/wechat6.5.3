package com.tencent.mm.ui.e.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class e {
    private static String d(Bundle bundle, String str) {
        if (bundle == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            if (bundle.getByteArray(str2) == null) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + bundle.getString(str2));
                stringBuilder.append("\r\n--" + str + "\r\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String W(Bundle bundle) {
        if (bundle == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append('&');
            }
            stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        return stringBuilder.toString();
    }

    public static Bundle Pq(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    public static Bundle Pr(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle Pq = Pq(url.getQuery());
            Pq.putAll(Pq(url.getRef()));
            return Pq;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String d(String str, String str2, Bundle bundle) {
        String str3 = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
        String str4 = "\r\n";
        if (str2.equals("GET")) {
            str = str + "?" + W(bundle);
        }
        v.d("Facebook-Util", str2 + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str5 : bundle.keySet()) {
                if (bundle.getByteArray(str5) != null) {
                    bundle2.putByteArray(str5, bundle.getByteArray(str5));
                }
            }
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str3);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--" + str3 + str4).getBytes());
            bufferedOutputStream.write(d(bundle, str3).getBytes());
            bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
            if (!bundle2.isEmpty()) {
                for (String str52 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str52 + "\"" + str4).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + str4 + str4).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str52));
                    bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            return m(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return m(httpURLConnection.getErrorStream());
        }
    }

    private static String m(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static void B(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }
}
