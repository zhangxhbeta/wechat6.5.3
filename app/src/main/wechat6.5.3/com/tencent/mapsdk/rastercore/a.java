package com.tencent.mapsdk.rastercore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.rastercore.d.e;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static StringBuffer a = new StringBuffer(300);
    private static final String b = a.class.getSimpleName();
    private static boolean c = false;

    private static String a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        byte[] bArr3 = new byte[((bArr.length + bArr2.length) + 2)];
        bArr3[0] = (byte) bArr.length;
        bArr3[1] = (byte) bArr2.length;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2 + 2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ 37);
        }
        while (i < bArr2.length) {
            bArr3[(i + 2) + bArr.length] = (byte) (bArr2[i] ^ 54);
            i++;
        }
        return Base64.encodeToString(bArr3, 3);
    }

    public static void a() {
        if (!c) {
            new Thread() {
                public final void run() {
                    String charSequence;
                    DisplayMetrics displayMetrics;
                    int i;
                    int i2;
                    int i3;
                    StringBuffer stringBuffer;
                    HttpURLConnection httpURLConnection;
                    String headerField;
                    boolean z;
                    a.c = true;
                    com.tencent.mapsdk.rastercore.d.a aVar = a.a;
                    b.d = com.tencent.mapsdk.rastercore.d.a.b();
                    String str = "http://apikey.map.qq.com/mkey/index.php/mkey/check?";
                    try {
                        String encode = URLEncoder.encode(com.tencent.mapsdk.rastercore.f.a.a(e.a()), "UTF-8");
                        a.a.append("key=");
                        a.a.append(encode);
                    } catch (Exception e) {
                    }
                    a.a.append("&output=json");
                    a.a.append("&pf=and_2Dmap");
                    a.a.append("&ver=");
                    try {
                        a.a.append(URLEncoder.encode("1.2.4", "UTF-8"));
                    } catch (Exception e2) {
                    }
                    try {
                        a.a.append("&hm=");
                        a.a.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
                        a.a.append("&os=A");
                        a.a.append(VERSION.SDK_INT);
                        a.a.append("&pid=");
                        a.a.append(URLEncoder.encode(e.a().getPackageName(), "UTF-8"));
                        a.a.append("&nt=");
                        a.a.append(URLEncoder.encode(((ConnectivityManager) e.a().getSystemService("connectivity")).getActiveNetworkInfo().getTypeName()));
                    } catch (Exception e3) {
                    }
                    a.a.append("&suid=");
                    a.a.append(a.b());
                    try {
                        PackageManager packageManager = e.a().getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(e.a().getPackageName(), 0);
                        charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                        try {
                            encode = packageInfo.versionName;
                            if (TextUtils.isEmpty(encode)) {
                                encode = null;
                            }
                        } catch (Exception e4) {
                            encode = charSequence;
                            charSequence = encode;
                            encode = null;
                            if (charSequence != null) {
                                a.a.append("&ref=");
                                try {
                                    a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                                } catch (Exception e5) {
                                }
                            }
                            if (encode != null) {
                                a.a.append("&psv=");
                                try {
                                    a.a.append(URLEncoder.encode(encode, "UTF-8"));
                                } catch (Exception e6) {
                                }
                            }
                            displayMetrics = e.a().getResources().getDisplayMetrics();
                            i = displayMetrics.densityDpi;
                            i2 = displayMetrics.widthPixels;
                            i3 = displayMetrics.heightPixels;
                            a.a.append("&dpi=");
                            a.a.append(i);
                            a.a.append("&scrn=");
                            a.a.append(i2);
                            a.a.append("*");
                            a.a.append(i3);
                            stringBuffer = a.a;
                            while (i2 < 2) {
                                try {
                                    httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                                    if (httpURLConnection.getResponseCode() != 200) {
                                        headerField = httpURLConnection.getHeaderField("Content-Encoding");
                                        if (headerField == null) {
                                        }
                                        a.a(new String(com.tencent.mapsdk.rastercore.d.a.b(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                                        break;
                                    }
                                    continue;
                                } catch (Exception e7) {
                                }
                            }
                            a.c = false;
                        }
                    } catch (Exception e8) {
                        encode = null;
                        charSequence = encode;
                        encode = null;
                        if (charSequence != null) {
                            a.a.append("&ref=");
                            a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                        }
                        if (encode != null) {
                            a.a.append("&psv=");
                            a.a.append(URLEncoder.encode(encode, "UTF-8"));
                        }
                        displayMetrics = e.a().getResources().getDisplayMetrics();
                        i = displayMetrics.densityDpi;
                        i2 = displayMetrics.widthPixels;
                        i3 = displayMetrics.heightPixels;
                        a.a.append("&dpi=");
                        a.a.append(i);
                        a.a.append("&scrn=");
                        a.a.append(i2);
                        a.a.append("*");
                        a.a.append(i3);
                        stringBuffer = a.a;
                        for (i2 = 0; i2 < 2; i2++) {
                            httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            if (httpURLConnection.getResponseCode() != 200) {
                                headerField = httpURLConnection.getHeaderField("Content-Encoding");
                                if (headerField == null) {
                                }
                                if (z) {
                                }
                                a.a(new String(com.tencent.mapsdk.rastercore.d.a.b(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                                break;
                            }
                            continue;
                        }
                        a.c = false;
                    }
                    if (charSequence != null) {
                        a.a.append("&ref=");
                        a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                    }
                    if (encode != null) {
                        a.a.append("&psv=");
                        a.a.append(URLEncoder.encode(encode, "UTF-8"));
                    }
                    try {
                        displayMetrics = e.a().getResources().getDisplayMetrics();
                        i = displayMetrics.densityDpi;
                        i2 = displayMetrics.widthPixels;
                        i3 = displayMetrics.heightPixels;
                        a.a.append("&dpi=");
                        a.a.append(i);
                        a.a.append("&scrn=");
                        a.a.append(i2);
                        a.a.append("*");
                        a.a.append(i3);
                    } catch (Exception e9) {
                    }
                    stringBuffer = a.a;
                    for (i2 = 0; i2 < 2; i2++) {
                        httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() != 200) {
                            headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            z = headerField == null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                            if (z) {
                            }
                            a.a(new String(com.tencent.mapsdk.rastercore.d.a.b(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                            break;
                        }
                        continue;
                    }
                    a.c = false;
                }
            }.start();
        }
    }

    static /* synthetic */ void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getJSONObject("info").getInt("error") != -1) {
                try {
                    jSONObject.getJSONObject("detail").getJSONObject("cfg").getJSONObject("raster_base_map_world");
                    e.d(true);
                } catch (JSONException e) {
                    e.d(false);
                }
                jSONObject = jSONObject.getJSONObject("detail").getJSONObject("cfg");
                int i = b.c;
                int i2 = jSONObject.getJSONObject("satellite_map").getInt("ver");
                if (i2 != b.d) {
                    b.d = i2;
                    com.tencent.mapsdk.rastercore.d.a aVar = a.a;
                    com.tencent.mapsdk.rastercore.d.a.a(i2);
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(b.d);
                }
                new StringBuilder("auth:").append(e.r()).append(";sateVersion:").append(b.d);
            } else if (jSONObject.getJSONObject("info").getString("msg").equals("KEY_NOT_EXISTS")) {
                e.c(false);
            }
        } catch (Exception e2) {
            new StringBuilder("checkJsonResult gets error:").append(e2.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public static String b() {
        String str = "";
        Context a = e.a();
        if (VERSION.SDK_INT < 23 || (a != null && a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            str = ((TelephonyManager) a.getSystemService("phone")).getDeviceId();
        }
        if (TextUtils.isEmpty(str)) {
            str = "noIMEI";
        }
        String d = d();
        if (d == null) {
            d = "noMac";
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = d.getBytes();
        new StringBuilder().append(str).append("::::").append(d);
        a(bytes, bytes2);
        return a(bytes, bytes2);
    }

    private static String d() {
        try {
            WifiInfo connectionInfo = ((WifiManager) e.a().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                bssid = bssid.replace(":", "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return null;
                }
            }
            bssid = null;
            return bssid;
        } catch (Exception e) {
            return null;
        }
    }
}
