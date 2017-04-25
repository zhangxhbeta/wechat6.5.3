package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.gmtrace.Constants;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class ai {
    static b pLF = l.bQC();
    private static ai pMe = null;
    static Context pMf = null;
    long g = 0;
    DefaultHttpClient pMb = null;
    f pMc = null;
    StringBuilder pMd = new StringBuilder(Downloads.RECV_BUFFER_SIZE);

    private ai(Context context) {
        try {
            pMf = context.getApplicationContext();
            this.g = System.currentTimeMillis() / 1000;
            this.pMc = new f();
            if (b.bPW()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, Constants.THREAD_BITSET_SIZE);
            HttpConnectionParams.setSoTimeout(basicHttpParams, Constants.THREAD_BITSET_SIZE);
            this.pMb = new DefaultHttpClient(basicHttpParams);
            this.pMb.setKeepAliveStrategy(new aj(this));
        } catch (Throwable th2) {
            pLF.i(th2);
        }
    }

    static Context a() {
        return pMf;
    }

    static void a(Context context) {
        pMf = context.getApplicationContext();
    }

    static ai hu(Context context) {
        if (pMe == null) {
            synchronized (ai.class) {
                if (pMe == null) {
                    pMe = new ai(context);
                }
            }
        }
        return pMe;
    }

    final void a(com.tencent.wxop.stat.a.b bVar, ah ahVar) {
        a(Arrays.asList(new String[]{bVar.g()}), ahVar);
    }

    final void a(List<?> list, ah ahVar) {
        if (this.pMc != null) {
            this.pMc.a(new ak(this, list, ahVar));
        }
    }
}
