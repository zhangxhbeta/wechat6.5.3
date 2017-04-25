package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorage {
    private static String Config_Version = "";
    private static final long GET_CONFIG_INTERVAL = 600000;
    private static long LastGetConfigTime = 0;
    private static final String PREFERENCE = "_httpproxy_preferences";
    public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
    public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
    private static String TAG = "TV_Httpproxy";
    private static final String TVHttpProxy_Version = "V1.0.186.0010";
    private static final String TVHttpProxy_Version_Code = "101860010";
    private static final String TVHttpProxy_channel_id = "186";
    private static final int[] connectTimeOut = new int[]{5000, 5000, 10000};
    private static String guid = "123";
    private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
    private static final String ipflag = "1";
    private static final String otype = "json";
    private static final String platform = "aphone";
    private static final int[] readTimeOut = new int[]{10000, 10000, 15000};
    private static final int[] retryTimes = new int[]{3, 2};
    private static String sharedPreferencesName = null;
    private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
    private Thread thread = null;

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return context.getSharedPreferences(str, i);
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        if (sharedPreferencesName == null) {
            sharedPreferencesName = context.getPackageName() + PREFERENCE;
        }
        return getSharedPreferences(context, sharedPreferencesName, 0);
    }

    public static String getDownProxyConfig(Context context) {
        if (context == null) {
            return "";
        }
        Config_Version = getConfigVersionFromSharedPreference(context);
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG, "");
    }

    public static void setDownProxyConfig(Context context, String str) {
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG, str).commit();
    }

    public static String getHttpProxyVersion() {
        return TVHttpProxy_Version;
    }

    public static String getHttpProxyVersionCode() {
        return TVHttpProxy_Version_Code;
    }

    public static String getConfigVersion() {
        return Config_Version;
    }

    private static String getConfigVersionFromSharedPreference(Context context) {
        if (context == null) {
            return "";
        }
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG_VERSION, "");
    }

    private static void setConfigVersionToSharedPreference(Context context, String str) {
        if (context != null && str != null) {
            getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG_VERSION, str).commit();
        }
    }

    public void synGetServerConfig(final Context context) {
        if (context == null) {
            HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
            return;
        }
        try {
            this.thread = new Thread(new Runnable() {
                public void run() {
                    ConfigStorage.this.synGetConfig(context);
                }
            });
            if (this.thread == null) {
                HttpproxyFacade.print(6, TAG, "thread create failed");
            } else {
                this.thread.start();
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    public void stopGetServerConfig() {
        try {
            if (this.thread != null) {
                this.thread.interrupt();
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    private boolean needGetConfig() {
        if (LastGetConfigTime == 0) {
            LastGetConfigTime = System.currentTimeMillis();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - LastGetConfigTime <= GET_CONFIG_INTERVAL && currentTimeMillis >= LastGetConfigTime) {
            return false;
        }
        LastGetConfigTime = System.currentTimeMillis();
        return true;
    }

    private void synGetConfig(Context context) {
        if (needGetConfig()) {
            int i = -1;
            try {
                JSONObject jSONObject = new JSONObject(fetchTextFromUrl(makeGetServerConfigUrl(context), context));
                if (jSONObject.has("httpproxy_config")) {
                    i = 0;
                    HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + jSONObject.getString("httpproxy_config"));
                    setDownProxyConfig(context, jSONObject.getString("httpproxy_config"));
                }
                if (jSONObject.has("config_ver")) {
                    setConfigVersionToSharedPreference(context, jSONObject.getString("config_ver"));
                }
            } catch (Throwable th) {
                HttpproxyFacade.print(6, TAG, "get config exception");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_code", i);
                jSONObject2.put("report_type", 90);
                HttpproxyFacade.jsonReport(jSONObject2.toString());
                return;
            } catch (JSONException e) {
                return;
            }
        }
        HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
    }

    private String makeGetServerConfigUrl(Context context) {
        return String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", new Object[]{url, platform, TVHttpProxy_Version, TVHttpProxy_channel_id, otype, ipflag, guid});
    }

    private SSLContext getHttpsSSLContext(Context context) {
        InputStream open;
        Throwable th;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            open = context.getAssets().open(httpsCrtFileName);
            try {
                Certificate generateCertificate = instance.generateCertificate(open);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load(null, null);
                instance2.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                SSLContext instance4 = SSLContext.getInstance("TLS");
                instance4.init(null, instance3.getTrustManagers(), null);
                if (open == null) {
                    return instance4;
                }
                try {
                    open.close();
                    return instance4;
                } catch (IOException e) {
                    return instance4;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    HttpproxyFacade.print(6, TAG, "getHttpsSSLContext unknow exception:" + Log.getStackTraceString(th));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    private String fetchTextFromUrl(String str, Context context) {
        Throwable th;
        SSLContext httpsSSLContext = getHttpsSSLContext(context);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        if (httpsSSLContext == null) {
            return "";
        }
        int i = 0;
        while (i < 2) {
            String str2;
            if (i == 1) {
                String bkDomain = getBkDomain(str);
                HttpproxyFacade.print(4, TAG, "请求备份域名:" + bkDomain);
                str2 = bkDomain;
            } else {
                str2 = str;
            }
            BufferedReader bufferedReader2 = bufferedReader;
            InputStream inputStream2 = inputStream;
            int i2 = 0;
            while (i2 < retryTimes[i]) {
                BufferedReader bufferedReader3;
                try {
                    String readLine;
                    HttpproxyFacade.print(4, TAG, " 第" + (i2 + 1) + " 次CGI请求:" + str2);
                    long currentTimeMillis = System.currentTimeMillis();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str2).openConnection();
                    httpsURLConnection.setConnectTimeout(connectTimeOut[i2]);
                    httpsURLConnection.setReadTimeout(readTimeOut[i2]);
                    httpsURLConnection.setSSLSocketFactory(httpsSSLContext.getSocketFactory());
                    inputStream2 = httpsURLConnection.getInputStream();
                    StringBuilder stringBuilder = new StringBuilder();
                    bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream2, ProtocolPackage.ServerEncoding));
                    while (true) {
                        try {
                            readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        } catch (IOException e) {
                        } catch (Throwable th2) {
                        }
                    }
                    readLine = stringBuilder.toString();
                    HttpproxyFacade.print(4, TAG, "【connect】连接时间：" + (System.currentTimeMillis() - currentTimeMillis) + "返回数据：" + readLine);
                    if (TextUtils.isEmpty(readLine) || readLine.trim().isEmpty()) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        try {
                            bufferedReader3.close();
                        } catch (IOException e3) {
                        }
                        i2++;
                        bufferedReader2 = bufferedReader3;
                    } else {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                        try {
                            bufferedReader3.close();
                        } catch (IOException e5) {
                        }
                        return readLine;
                    }
                } catch (IOException e6) {
                    bufferedReader3 = bufferedReader2;
                    try {
                        HttpproxyFacade.print(6, TAG, "IO Exception" + System.err);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e8) {
                            }
                        }
                        i2++;
                        bufferedReader2 = bufferedReader3;
                    } catch (Throwable th3) {
                        bufferedReader2 = bufferedReader3;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            i++;
            inputStream = inputStream2;
            bufferedReader = bufferedReader2;
        }
        return "";
        throw th;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e9) {
            }
        }
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (IOException e10) {
            }
        }
        throw th;
        if (bufferedReader2 != null) {
            bufferedReader2.close();
        }
        throw th;
    }

    private String getBkDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
