package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.g;
import com.tencent.smtt.sdk.i;
import com.tencent.smtt.sdk.q;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.p;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

public final class b {
    public static byte[] pyA;

    static {
        pyA = null;
        try {
            pyA = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    private static JSONObject a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (q.fz(context)) {
                jSONObject.put("HOST_COREVERSION", q.bNv());
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = g.pvU;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", i.fb(context).bNb());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (thirdAppInfoNew.sAppName.equals("com.tencent.mobileqq")) {
                    j.bNZ();
                    jSONObject.put("TID", j.Qq(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    public static void a(final Context context, String str, String str2, String str3, int i, boolean z, long j) {
        String str4;
        String str5 = SQLiteDatabase.KeyEmpty;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            str4 = str5;
        } catch (Throwable th) {
            return;
        }
        final ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
        thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
        p.ge(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        thirdAppInfoNew.sGuid = str;
        if (z) {
            thirdAppInfoNew.sQua2 = str2;
        } else {
            thirdAppInfoNew.sQua2 = o.gb(context);
        }
        thirdAppInfoNew.sLc = str3;
        str5 = c.fV(context);
        String V = c.V(context);
        String fU = c.fU(context);
        Object fW = c.fW(context);
        if (!(V == null || SQLiteDatabase.KeyEmpty.equals(V))) {
            thirdAppInfoNew.sImei = V;
        }
        if (!(fU == null || SQLiteDatabase.KeyEmpty.equals(fU))) {
            thirdAppInfoNew.sImsi = fU;
        }
        if (!TextUtils.isEmpty(fW)) {
            thirdAppInfoNew.sAndroidID = fW;
        }
        if (!(str5 == null || SQLiteDatabase.KeyEmpty.equals(str5))) {
            thirdAppInfoNew.sMac = str5;
        }
        thirdAppInfoNew.iPv = (long) i;
        thirdAppInfoNew.iCoreType = z ? 1 : 0;
        thirdAppInfoNew.sAppVersionName = str4;
        thirdAppInfoNew.sAppSignature = fO(context);
        if (!z) {
            thirdAppInfoNew.sWifiConnectedTime = j;
            thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
        }
        new Thread("HttpUtils") {
            public final void run() {
                if (VERSION.SDK_INT >= 8) {
                    if (b.pyA == null) {
                        try {
                            b.pyA = "65dRa93L".getBytes("utf-8");
                        } catch (UnsupportedEncodingException e) {
                            b.pyA = null;
                            TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                        }
                    }
                    if (b.pyA == null) {
                        TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                        return;
                    }
                    String string = i.fb(context).pwc.getString("tbs_deskey_token", SQLiteDatabase.KeyEmpty);
                    String str = SQLiteDatabase.KeyEmpty;
                    String str2 = SQLiteDatabase.KeyEmpty;
                    if (TextUtils.isEmpty(string)) {
                        String str3 = str2;
                        str2 = str;
                        str = str3;
                    } else {
                        str2 = string.substring(0, string.indexOf("&"));
                        str = string.substring(string.indexOf("&") + 1, string.length());
                    }
                    boolean z = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
                    try {
                        JSONObject b;
                        p bOf = p.bOf();
                        if (z) {
                            StringBuilder append = new StringBuilder().append(bOf.pzw);
                            com.tencent.smtt.utils.i.bNW();
                            str2 = append.append(com.tencent.smtt.utils.i.bNX()).toString();
                        } else {
                            str2 = bOf.pzx + str2;
                        }
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(20000);
                        if (VERSION.SDK_INT > 13) {
                            httpURLConnection.setRequestProperty("Connection", "close");
                        }
                        try {
                            b = b.a(thirdAppInfoNew, context);
                        } catch (Exception e2) {
                            b = null;
                        }
                        if (b == null) {
                            TbsLog.e("sdkreport", "post -- jsonData is null!");
                            return;
                        }
                        try {
                            byte[] bytes = b.toString().getBytes("utf-8");
                            byte[] by = z ? com.tencent.smtt.utils.i.bNW().by(bytes) : com.tencent.smtt.utils.i.f(bytes, str);
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(by.length));
                            try {
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(by);
                                outputStream.flush();
                                if (httpURLConnection.getResponseCode() != 200) {
                                    TbsLog.e("sdkreport", "Post failed -- not 200");
                                }
                            } catch (Throwable th) {
                                TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            }
                        } catch (Throwable th2) {
                        }
                    } catch (IOException e3) {
                        TbsLog.e("sdkreport", "Post failed -- IOException:" + e3);
                    } catch (AssertionError e4) {
                        TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e4);
                    } catch (NoClassDefFoundError e5) {
                        TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
                    }
                }
            }
        }.start();
    }

    private static String fO(Context context) {
        String str = null;
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
                    if (toByteArray != null && toByteArray.length > 0) {
                        for (int i = 0; i < toByteArray.length; i++) {
                            String toUpperCase = Integer.toHexString(toByteArray[i] & WebView.NORMAL_MODE_ALPHA).toUpperCase();
                            if (i > 0) {
                                stringBuilder.append(":");
                            }
                            if (toUpperCase.length() < 2) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toUpperCase);
                        }
                        str = stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
