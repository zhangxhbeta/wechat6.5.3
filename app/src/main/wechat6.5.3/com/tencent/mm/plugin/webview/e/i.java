package com.tencent.mm.plugin.webview.e;

import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {
    private final LinkedList<String> lhr = new LinkedList();

    public final void Ez(String str) {
        try {
            if (!be.kS(str)) {
                synchronized (this.lhr) {
                    String str2 = (String) this.lhr.peekLast();
                    String encode = URLEncoder.encode(str);
                    if (str2 == null || !str2.equals(encode)) {
                        this.lhr.addLast(encode);
                    }
                    if (this.lhr.size() > 10) {
                        this.lhr.removeFirst();
                    }
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[]{be.e(e)});
        }
    }

    public final String[] bjj() {
        String[] strArr;
        synchronized (this.lhr) {
            strArr = new String[this.lhr.size()];
            Iterator it = this.lhr.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                strArr[i] = (String) it.next();
                i = i2;
            }
        }
        return strArr;
    }

    public final void bjk() {
        if (b.bsI()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.lhr) {
                Iterator it = this.lhr.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(URLDecoder.decode((String) it.next())).append("\n");
                }
            }
            v.d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
        }
    }
}
