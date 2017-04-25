package com.tencent.mm.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class t {
    private int dll;
    public HttpURLConnection dmc;
    private Map<String, List<String>> dmd = null;
    private URL url;

    public t(URL url, int i) {
        this.url = url;
        this.dll = i;
        this.dmc = (HttpURLConnection) this.url.openConnection();
        if (1 == this.dll) {
            this.dmc.setInstanceFollowRedirects(false);
        }
    }

    public final int getResponseCode() {
        int responseCode;
        while (true) {
            if (1 == this.dll && this.dmd == null) {
                this.dmd = this.dmc.getRequestProperties();
            }
            responseCode = this.dmc.getResponseCode();
            if (1 != this.dll || 302 != responseCode) {
                break;
            }
            String headerField = this.dmc.getHeaderField("Location");
            if (headerField == null) {
                break;
            }
            this.url = new URL(this.url, headerField);
            this.dmc = (HttpURLConnection) this.url.openConnection();
            this.dmc.setInstanceFollowRedirects(false);
            if (this.dmd != null) {
                for (String str : this.dmd.keySet()) {
                    if (!(str.equals("Host") || str.equals("X-Online-Host"))) {
                        List list = (List) this.dmd.get(str);
                        for (int i = 0; i < list.size(); i++) {
                            this.dmc.setRequestProperty(str, (String) list.get(i));
                        }
                    }
                }
            }
            this.dmc.setRequestProperty("Host", this.url.getHost());
            this.dmc.setRequestProperty("X-Online-Host", this.url.getHost());
        }
        return responseCode;
    }

    public final void setRequestMethod(String str) {
        this.dmc.setRequestMethod(str);
    }

    public final void connect() {
        if (1 == this.dll && this.dmd == null) {
            this.dmd = this.dmc.getRequestProperties();
        }
        this.dmc.connect();
    }

    public final Map<String, List<String>> getHeaderFields() {
        if (1 == this.dll && this.dmd == null) {
            this.dmd = this.dmc.getRequestProperties();
        }
        return this.dmc.getHeaderFields();
    }

    public final String getHeaderField(String str) {
        if (1 == this.dll && this.dmd == null) {
            this.dmd = this.dmc.getRequestProperties();
        }
        return this.dmc.getHeaderField(str);
    }

    public final InputStream getInputStream() {
        if (1 == this.dll) {
            if (this.dmd == null) {
                this.dmd = this.dmc.getRequestProperties();
            }
            getResponseCode();
        }
        return this.dmc.getInputStream();
    }

    public final OutputStream getOutputStream() {
        if (1 == this.dll) {
            if (this.dmd == null) {
                this.dmd = this.dmc.getRequestProperties();
            }
            getResponseCode();
        }
        return this.dmc.getOutputStream();
    }

    public final void Mj() {
        this.dmc.setDoInput(true);
    }

    public final void Mk() {
        this.dmc.setDoOutput(true);
    }

    public final void setRequestProperty(String str, String str2) {
        this.dmc.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.dmc.setUseCaches(z);
    }

    public final void setConnectTimeout(int i) {
        this.dmc.setConnectTimeout(i);
    }

    public final void setReadTimeout(int i) {
        this.dmc.setReadTimeout(i);
    }

    public final void lM(String str) {
        this.dmc.setRequestProperty("Referer", str);
    }

    public final String toString() {
        return this.dmc.toString();
    }
}
