package ct;

import android.content.Context;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class av {
    private static int a = 5;
    private static int b = 15;
    private static List c;

    public static void a(String str, HashMap hashMap) {
        Context context = p.a;
        au a = i.a(str);
        a(hashMap);
        a.a((Map) hashMap);
        if (c == null) {
            c = new ArrayList();
        }
        c.add(a);
        if (ar.b(p.a)) {
            Context context2 = p.a;
            a = i.a("rqd_applaunched");
            Map hashMap2 = new HashMap();
            a((HashMap) hashMap2);
            if (ar.b(p.a)) {
                hashMap2.put("A21", "Y");
            } else {
                hashMap2.put("A21", "N");
            }
            a.a(hashMap2);
            c.add(a);
        }
        if (c.size() >= a) {
            a(c);
        }
    }

    private static void a(HashMap hashMap) {
        as k = as.k();
        if (k != null) {
            hashMap.put("A1", p.e);
            hashMap.put("A2", k.d());
            hashMap.put("A4", k.f());
            hashMap.put("A6", k.g());
            hashMap.put("A7", k.h());
            hashMap.put("A23", p.f);
            String str = "A33";
            StringBuilder stringBuilder = new StringBuilder();
            Context context = p.a;
            String str2 = "null";
            if (at.a(context) != null) {
                str2 = at.f(context);
                if (str2 == null) {
                    str2 = "null";
                }
            }
            hashMap.put(str, stringBuilder.append(str2).toString());
            hashMap.put("A10", k.j());
            hashMap.put("A9", k.i());
            hashMap.put("A19", bc.b);
            hashMap.put("A20", bc.c);
        }
    }

    private static void a(List list) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Collection<au> arrayList = new ArrayList();
            arrayList.addAll(list);
            for (au a : arrayList) {
                stringBuilder.append(i.a(a));
            }
            byte[] a2 = new aq("ABC1234567890DEF".getBytes()).a(i.a(stringBuilder.toString().getBytes()));
            if (a2.length > 0) {
                URL url = new URL("http://zxcv.3g.qq.com/sdk/beacon.jsp?type=real&size=" + a2.length);
                Proxy g = bc.g();
                HttpURLConnection httpURLConnection = g != null ? (HttpURLConnection) url.openConnection(g) : (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(true);
                if (a2 != null) {
                    httpURLConnection.setRequestMethod("POST");
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(a2);
                    dataOutputStream.close();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    c.removeAll(arrayList);
                }
            }
            if (c.size() >= b) {
                c.clear();
            }
        } catch (Exception e) {
        } catch (OutOfMemoryError e2) {
            c.clear();
        }
    }
}
