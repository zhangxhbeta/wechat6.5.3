package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;

public class f {
    private static f pKM = null;
    List<String> a = null;
    volatile int b = 2;
    public volatile String c = "";
    int f = 0;
    volatile HttpHost pKK = null;
    private com.tencent.wxop.stat.b.f pKL = null;
    Context pKN = null;
    b pKO = null;

    private f(Context context) {
        this.pKN = context.getApplicationContext();
        this.pKL = new com.tencent.wxop.stat.b.f();
        ai.a(context);
        this.pKO = l.bQC();
        l();
        this.a = new ArrayList(10);
        this.a.add("117.135.169.101");
        this.a.add("140.207.54.125");
        this.a.add("180.153.8.53");
        this.a.add("120.198.203.175");
        this.a.add("14.17.43.18");
        this.a.add("163.177.71.186");
        this.a.add("111.30.131.31");
        this.a.add("123.126.121.167");
        this.a.add("123.151.152.111");
        this.a.add("113.142.45.79");
        this.a.add("123.138.162.90");
        this.a.add("103.7.30.94");
        g();
    }

    static boolean b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    public static f gQ(Context context) {
        if (pKM == null) {
            synchronized (f.class) {
                if (pKM == null) {
                    pKM = new f(context);
                }
            }
        }
        return pKM;
    }

    private String j() {
        try {
            String str = "pingma.qq.com";
            if (!b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.pKO.i(e);
        }
        return "";
    }

    private void l() {
        this.b = 0;
        this.pKK = null;
        this.c = null;
    }

    public final boolean e() {
        return this.b == 1;
    }

    public final boolean f() {
        return this.b != 0;
    }

    final void g() {
        if (r.hr(this.pKN)) {
            if (b.g) {
                String j = j();
                if (b.bPW()) {
                    this.pKO.bw("remoteIp ip is " + j);
                }
                if (l.c(j)) {
                    String str;
                    if (this.a.contains(j)) {
                        str = j;
                    } else {
                        str = (String) this.a.get(this.f);
                        if (b.bPW()) {
                            this.pKO.bx(j + " not in ip list, change to:" + str);
                        }
                    }
                    b.QY("http://" + str + ":80/mstat/report");
                }
            }
            this.c = l.hb(this.pKN);
            if (b.bPW()) {
                this.pKO.bw("NETWORK name:" + this.c);
            }
            if (l.c(this.c)) {
                if ("WIFI".equalsIgnoreCase(this.c)) {
                    this.b = 1;
                } else {
                    this.b = 2;
                }
                this.pKK = l.gU(this.pKN);
            }
            if (d.a()) {
                d.gM(this.pKN);
                return;
            }
            return;
        }
        if (b.bPW()) {
            this.pKO.bw("NETWORK TYPE: network is close.");
        }
        l();
    }
}
