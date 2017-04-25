package b.a.d;

import b.a.b.b;
import b.a.g.e;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    public int aJW;
    private Map<String, String> dTU;
    private String pPj;
    private InputStream pPk;

    g(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            this.aJW = httpURLConnection.getResponseCode();
            this.dTU = e(httpURLConnection);
            Object obj = (this.aJW < 200 || this.aJW >= 400) ? null : 1;
            this.pPk = obj != null ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (Exception e) {
            throw new b("The IP address of a host could not be determined.", e);
        }
    }

    private static Map<String, String> e(HttpURLConnection httpURLConnection) {
        Map<String, String> hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, (String) ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        return hashMap;
    }

    public final String getBody() {
        if (this.pPj != null) {
            return this.pPj;
        }
        this.pPj = e.r(this.pPk);
        return this.pPj;
    }
}
