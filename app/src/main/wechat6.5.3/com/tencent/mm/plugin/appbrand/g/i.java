package com.tencent.mm.plugin.appbrand.g;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public enum i {
    ;

    private static HashMap<String, String> nP(String str) {
        Object scheme;
        Exception e;
        HashMap<String, String> hashMap;
        Object obj = "";
        String str2 = "";
        Object obj2 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            scheme = parse.getScheme();
            try {
                obj2 = String.valueOf(parse.getPort());
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
                hashMap = new HashMap();
                hashMap.put("host", obj);
                hashMap.put("scheme", scheme);
                hashMap.put("port", obj2);
                return hashMap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            scheme = str2;
            e = exception;
            v.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
            hashMap = new HashMap();
            hashMap.put("host", obj);
            hashMap.put("scheme", scheme);
            hashMap.put("port", obj2);
            return hashMap;
        }
        hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", scheme);
        hashMap.put("port", obj2);
        return hashMap;
    }

    private static Map<String, String> f(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandNetworkUtil", "get header error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static Map<String, String> g(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandNetworkUtil", "get form error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static boolean b(ArrayList<String> arrayList, String str) {
        if (be.kS(str)) {
            return false;
        }
        v.i("MicroMsg.AppBrandNetworkUtil", "url " + str);
        v.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
        HashMap nP = nP(str);
        String str2 = (String) nP.get("host");
        String str3 = (String) nP.get("scheme");
        String str4 = (String) nP.get("port");
        if (be.kS(str2) || be.kS(str3)) {
            return false;
        }
        v.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s", new Object[]{str2, str3, str4});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            v.i("MicroMsg.AppBrandNetworkUtil", "configUrl " + str5);
            HashMap nP2 = nP(str5);
            v.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[]{(String) nP2.get("host"), (String) nP2.get("scheme"), (String) nP2.get("port")});
            if (str2.equalsIgnoreCase((String) nP2.get("host")) && str3.equalsIgnoreCase(r4) && str4.equalsIgnoreCase(r5)) {
                v.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> a(JSONObject jSONObject, AppBrandSysConfig appBrandSysConfig) {
        String str;
        Map<String, String> f = f(jSONObject);
        if (appBrandSysConfig.dDD != null) {
            HttpSetting httpSetting = appBrandSysConfig.dDD.dDf;
            if (httpSetting != null) {
                Map<String, String> map;
                ArrayList arrayList;
                if (httpSetting.mode == 1) {
                    if (httpSetting.dDg != null) {
                        arrayList = httpSetting.dDg;
                        if (arrayList == null || arrayList.isEmpty()) {
                            v.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                if (str != null) {
                                    if (((String) f.remove(str.toLowerCase())) != null) {
                                        v.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[]{str.toLowerCase(), (String) f.remove(str.toLowerCase())});
                                    }
                                }
                            }
                        }
                        map = f;
                    }
                } else if (httpSetting.mode == 2 && httpSetting.dDh != null) {
                    arrayList = httpSetting.dDh;
                    if (arrayList == null) {
                        v.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
                        map = f;
                    } else {
                        Map<String, String> hashMap = new HashMap();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            str = (String) it2.next();
                            if (str != null) {
                                String toLowerCase = str.toLowerCase();
                                str = (String) f.get(toLowerCase);
                                if (str != null) {
                                    v.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[]{toLowerCase, str});
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        map = hashMap;
                    }
                }
                f = map;
            }
        }
        f.remove("referer");
        String str2 = "referer";
        str = "";
        if (!(appBrandSysConfig.dDD == null || appBrandSysConfig.dDD.dDf == null)) {
            str = appBrandSysConfig.dDD.dDf.dDm;
        }
        if (be.kS(str)) {
            str = "servicewechat.com";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.appId);
        stringBuilder.append("/");
        stringBuilder.append(a.mr(appBrandSysConfig.appId).dDB.dBs);
        stringBuilder.append("/");
        f.put(str2, stringBuilder.toString());
        return f;
    }

    public static int a(AppBrandSysConfig appBrandSysConfig, com.tencent.mm.plugin.appbrand.config.a aVar, int i) {
        int i2;
        int i3;
        int i4;
        switch (i) {
            case 0:
                i2 = aVar.dCv.bfw;
                if (appBrandSysConfig.dDD == null || appBrandSysConfig.dDD.dDf == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.dDD.dDf.dDi;
                }
                v.i("MicroMsg.AppBrandNetworkUtil", "request apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 1:
                i2 = aVar.dCv.dCF;
                if (appBrandSysConfig.dDD == null || appBrandSysConfig.dDD.dDf == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.dDD.dDf.dDi;
                }
                v.i("MicroMsg.AppBrandNetworkUtil", "socket apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 2:
                i2 = aVar.dCv.dCG;
                if (appBrandSysConfig.dDD == null || appBrandSysConfig.dDD.dDf == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.dDD.dDf.dDj;
                }
                v.i("MicroMsg.AppBrandNetworkUtil", "upload apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 3:
                i2 = aVar.dCv.dCH;
                if (appBrandSysConfig.dDD == null || appBrandSysConfig.dDD.dDf == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.dDD.dDf.dDk;
                }
                v.i("MicroMsg.AppBrandNetworkUtil", "download apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        if (i3 > 0 && i2 <= 0) {
            return i3;
        }
        if (i3 <= 0 && i2 > 0) {
            return i2;
        }
        if (i3 <= 0 || i2 <= 0) {
            return 0;
        }
        return Math.min(i3, i2);
    }

    public static boolean hg(int i) {
        return i == 302 || i == 301;
    }

    public static String b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return "";
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (headerField == null || headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    public static boolean d(AppBrandSysConfig appBrandSysConfig) {
        return (appBrandSysConfig.dDB.dBr == 1 && appBrandSysConfig.dDp) ? false : true;
    }
}
