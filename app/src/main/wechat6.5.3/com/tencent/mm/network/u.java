package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class u {
    public HttpsURLConnection dme;

    public u(String str) {
        this(new URL(str));
    }

    private u(URL url) {
        this.dme = null;
        try {
            this.dme = (HttpsURLConnection) url.openConnection();
        } catch (Throwable e) {
            v.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", be.e(e));
        } catch (Throwable e2) {
            v.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", be.e(e2));
        } catch (Throwable e22) {
            v.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e22.getMessage());
            v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", be.e(e22));
        }
    }
}
