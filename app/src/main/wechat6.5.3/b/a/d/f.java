package b.a.d;

import b.a.b.a;
import b.a.b.b;
import b.a.g.d;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

class f {
    private String charset;
    private Map<String, String> dTU;
    private HttpURLConnection dmc;
    private j pPb;
    private e pPc;
    private e pPd;
    private String pPe = null;
    private byte[] pPf = null;
    private boolean pPg = false;
    private Long pPh = null;
    private Long pPi = null;
    private String url;

    public f(j jVar, String str) {
        this.pPb = jVar;
        this.url = str;
        this.pPc = new e();
        this.pPd = new e();
        this.dTU = new HashMap();
    }

    public g bRo() {
        try {
            String bRm = bRm();
            if (this.dmc == null) {
                System.setProperty("http.keepAlive", this.pPg ? "true" : "false");
                this.dmc = (HttpURLConnection) new URL(bRm).openConnection();
            }
            this.dmc.setRequestMethod(this.pPb.name());
            if (this.pPh != null) {
                this.dmc.setConnectTimeout(this.pPh.intValue());
            }
            if (this.pPi != null) {
                this.dmc.setReadTimeout(this.pPi.intValue());
            }
            d(this.dmc);
            if (this.pPb.equals(j.PUT) || this.pPb.equals(j.POST)) {
                HttpURLConnection httpURLConnection = this.dmc;
                byte[] bRs = bRs();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bRs.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(bRs);
            }
            return new g(this.dmc);
        } catch (Exception e) {
            throw new a(e);
        }
    }

    public String bRm() {
        e eVar = this.pPc;
        String str = this.url;
        d.c(str, "Cannot append to null URL");
        String bRr = eVar.bRr();
        if (bRr.equals("")) {
            return str;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(bRr).toString();
    }

    private void d(HttpURLConnection httpURLConnection) {
        for (String str : this.dTU.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.dTU.get(str));
        }
    }

    public void addHeader(String str, String str2) {
        this.dTU.put(str, str2);
    }

    public void er(String str, String str2) {
        this.pPc.pPa.add(new d(str, str2));
    }

    public e bRk() {
        try {
            e eVar = new e();
            eVar.Re(new URL(this.url).getQuery());
            eVar.a(this.pPc);
            return eVar;
        } catch (Exception e) {
            throw new b("Malformed URL", e);
        }
    }

    public e bRp() {
        return this.pPd;
    }

    public String getUrl() {
        return this.url;
    }

    public String bRq() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    private byte[] bRs() {
        if (this.pPf != null) {
            return this.pPf;
        }
        try {
            return (this.pPe != null ? this.pPe : this.pPd.bRr()).getBytes(bRn());
        } catch (Exception e) {
            throw new b("Unsupported Charset: " + bRn(), e);
        }
    }

    public j bRl() {
        return this.pPb;
    }

    public String bRn() {
        return this.charset == null ? Charset.defaultCharset().name() : this.charset;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{bRl(), getUrl()});
    }
}
