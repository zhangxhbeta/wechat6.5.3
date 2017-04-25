package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.a.e;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

final class m implements Runnable {
    private Context a = null;
    private Map<String, Integer> b = null;
    private e pLh = null;

    public m(Context context) {
        this.a = context;
        this.pLh = null;
    }

    private static Map<String, Integer> bQu() {
        Map<String, Integer> hashMap = new HashMap();
        String QX = b.QX("__MTA_TEST_SPEED__");
        if (!(QX == null || QX.trim().length() == 0)) {
            for (String QX2 : QX2.split(";")) {
                String[] split = QX2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            d.pKH.i(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private static a cv(String str, int i) {
        Throwable th;
        a aVar = new a();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            aVar.c = str;
            aVar.d = i;
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            aVar.a = System.currentTimeMillis() - currentTimeMillis;
            aVar.e = inetSocketAddress.getAddress().getHostAddress();
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                d.pKH.i(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            d.pKH.i(th2);
            socket.close();
        } catch (Throwable th22) {
            d.pKH.i(th22);
        }
        aVar.b = i2;
        return aVar;
    }

    public final void run() {
        try {
            if (this.b == null) {
                this.b = bQu();
            }
            if (this.b == null || this.b.size() == 0) {
                d.pKH.bw("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    d.pKH.bx("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    d.pKH.bx("port is null for " + str);
                } else {
                    jSONArray.put(cv((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).nT());
                }
            }
            if (jSONArray.length() != 0) {
                b eVar = new e(this.a, d.a(this.a, false, this.pLh), this.pLh);
                eVar.n = jSONArray.toString();
                new n(eVar).a();
            }
        } catch (Throwable th) {
            d.pKH.i(th);
        }
    }
}
