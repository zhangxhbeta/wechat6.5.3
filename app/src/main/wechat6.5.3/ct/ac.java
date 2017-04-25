package ct;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ac {
    private ab a;
    private ad b;
    private ae c;
    private List d;
    private int e = 0;
    private int f = 0;
    private s g;
    private String h;
    private s i;
    private int j;
    private int k;
    private boolean l = false;
    private z m;
    private boolean n;
    private String o;
    private ag p;
    private aa q;
    private long r;
    private boolean s = false;

    public enum a {
        CONNECTEXC,
        READDATAEXC,
        UNKNOWEXC;

        static {
            CONNECTEXC = new a("CONNECTEXC", 0);
            READDATAEXC = new a("READDATAEXC", 1);
            UNKNOWEXC = new a("UNKNOWEXC", 2);
            a[] aVarArr = new a[]{CONNECTEXC, READDATAEXC, UNKNOWEXC};
        }
    }

    public ac(z zVar) {
        Object obj = new Object();
        this.a = af.a();
        this.m = zVar;
        this.m.l = System.currentTimeMillis();
    }

    private int a(a aVar, Exception exception) {
        this.p.p = exception.getClass().getSimpleName();
        this.p.q = aVar + "##" + this.q.a + "##" + be.a(exception);
        if (!this.p.q.contains("Permission")) {
            return bc.e() ? i.b("info.3g.qq.com") ? exception instanceof EOFException ? -31 : exception instanceof IOException ? -30 : exception instanceof SocketException ? -12 : exception instanceof IllegalStateException ? -22 : exception instanceof SSLPeerUnverifiedException ? -23 : -3 : -17 : -4;
        } else {
            this.q.a = -18;
            return 0;
        }
    }

    private void a(aa aaVar) {
        int i = 0;
        try {
            int i2 = aaVar.a;
            this.p.t = aaVar.e;
            this.p.o = aaVar.f;
            switch (i2) {
                case 200:
                    InputStream inputStream = aaVar.d;
                    this.p.m = true;
                    if (this.m.h) {
                        int i3 = this.m.m;
                        try {
                            Object obj = new byte[i3];
                            while (i < i3) {
                                int read = inputStream.read(obj, i, i3 - i);
                                if (read != -1) {
                                    i += read;
                                } else {
                                    if (i < i3) {
                                        this.q.a = -1;
                                        this.p.q = "Response data too long,size:" + i;
                                    } else {
                                        try {
                                            this.q.c = new byte[i];
                                            System.arraycopy(obj, 0, this.q.c, 0, i);
                                            this.q.a = 0;
                                            this.p.D = System.currentTimeMillis();
                                        } catch (OutOfMemoryError e) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e2) {
                                            }
                                            this.q.a = -8;
                                            this.p.q = "OutOfMemory buffSize:" + i3;
                                            this.l = true;
                                            return;
                                        }
                                    }
                                    inputStream.close();
                                }
                            }
                            if (i < i3) {
                                this.q.c = new byte[i];
                                System.arraycopy(obj, 0, this.q.c, 0, i);
                                this.q.a = 0;
                                this.p.D = System.currentTimeMillis();
                            } else {
                                this.q.a = -1;
                                this.p.q = "Response data too long,size:" + i;
                            }
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                            }
                        } catch (OutOfMemoryError e4) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                            }
                            this.q.a = -8;
                            this.p.q = "OutOfMemory buffSize:" + i3;
                            this.p.o = (long) i3;
                            this.l = true;
                            return;
                        }
                    }
                    bd.b();
                    this.q.d = inputStream;
                    this.q.a = 0;
                    if (this.q.a == 0) {
                        this.p.r = 0;
                        this.l = true;
                        return;
                    }
                    return;
                case 204:
                case 408:
                case 502:
                case 503:
                case 504:
                    this.q.a = i2;
                    return;
                case 301:
                case 302:
                case 303:
                    this.q.a = -21;
                    this.s = true;
                    StringBuilder stringBuilder = new StringBuilder();
                    ag agVar = this.p;
                    agVar.k = stringBuilder.append(agVar.k).append(";").append(this.q.b).toString();
                    this.p.j = true;
                    if (TextUtils.isEmpty(this.h)) {
                        this.h = null;
                        this.q.a = -6;
                        return;
                    } else if (!this.m.p) {
                        bd.b();
                        this.q.b = this.h;
                        this.q.a = -7;
                        this.l = true;
                        return;
                    } else {
                        return;
                    }
                default:
                    this.q.a = i2;
                    return;
            }
        } catch (Exception e6) {
            a(a.READDATAEXC, e6);
        }
        a(a.READDATAEXC, e6);
    }

    private void a(Map map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.m.b());
        hashMap.putAll(map);
        URL url = new URL(this.o);
        Proxy g = bc.g();
        HttpURLConnection httpURLConnection = (g == null || this.e <= 1) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(g);
        httpURLConnection.setConnectTimeout(this.c.b * 1000);
        httpURLConnection.setReadTimeout(this.c.a * 1000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        for (String str : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(str, (String) hashMap.get(str));
        }
        httpURLConnection.setDoOutput(true);
        byte[] bArr = this.m.j;
        if (bArr != null) {
            try {
                this.p.A = System.currentTimeMillis();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.getOutputStream().write(bArr);
                httpURLConnection.getOutputStream().flush();
                httpURLConnection.getOutputStream().close();
                this.p.B = System.currentTimeMillis();
            } catch (Exception e) {
            }
        }
        try {
            if (VERSION.SDK != null && VERSION.SDK_INT < 8) {
                System.setProperty("http.keepAlive", "false");
            }
        } catch (Exception e2) {
        }
        this.p.z = System.currentTimeMillis();
        int responseCode = httpURLConnection.getResponseCode();
        this.p.C = System.currentTimeMillis();
        if (responseCode == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        InputStream inputStream;
        this.q.a = httpURLConnection.getResponseCode();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e3) {
            inputStream = httpURLConnection.getErrorStream();
        }
        this.q.d = inputStream;
        httpURLConnection.getContentEncoding();
        this.q.f = (long) httpURLConnection.getContentLength();
        this.q.e = httpURLConnection.getContentType();
        this.h = httpURLConnection.getHeaderField("Location");
        this.q.b = httpURLConnection.getHeaderField("Location");
        for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                this.q.g.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        a(this.q);
    }

    public final aa a() {
        this.b = new ad(this.m);
        this.c = new ae(bc.c());
        this.d = this.b.c;
        this.i = this.b.a;
        this.j = this.d.size() - 1;
        this.k = this.d.size();
        while (this.e <= this.m.o && !this.l) {
            if (!this.s) {
                this.p = new ag();
                this.p.x = this.m.k;
                this.p.y = this.m.l;
                this.p.l = this.e;
                this.p.f = this.m.q + "-" + this.e;
            }
            if (this.e > 0) {
                this.p.F = System.currentTimeMillis();
            }
            this.r = System.currentTimeMillis();
            this.q = new aa();
            try {
                this.g = (s) this.d.get(this.e % this.k);
                if (System.currentTimeMillis() - this.m.l > ((long) this.m.n)) {
                    this.g = (s) this.d.get(this.d.size() - 1);
                    this.n = true;
                    this.c.b = 10;
                    this.c.a = 10;
                    this.l = true;
                }
                if (TextUtils.isEmpty(this.h)) {
                    String str;
                    s sVar = this.g;
                    if (this.m.a) {
                        str = this.m.d;
                    } else {
                        str = !this.m.a ? sVar.b != -1 ? "http://" + sVar.a + ":" + sVar.b : "http://" + sVar.a : sVar.b != -1 ? "https://" + sVar.a + ":443" : "https://" + sVar.a;
                        String str2 = this.m.g;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2.startsWith("/") ? str + str2 : str + "/" + str2;
                        }
                    }
                    this.o = str;
                    this.p.b = this.o;
                } else {
                    this.o = this.h;
                    this.h = null;
                }
                if (this.e % this.k < this.j) {
                    this.m.a("Host", this.m.f);
                    this.m.a("x-tx-host", this.m.f);
                }
                this.m.a("Halley-sdk", " sdk:" + p.g + "key:" + this.m.q + "-" + this.e);
                if (bc.d && this.e > 1) {
                    this.m.a("X-Online-Host", this.m.f);
                }
                a(this.m.b());
            } catch (Exception e) {
                bd.d();
                this.q.a = a(a.UNKNOWEXC, e);
            } finally {
                if (TextUtils.isEmpty(this.h)) {
                    this.f = 0;
                    this.e++;
                } else {
                    this.f++;
                    if (this.f > 6) {
                        this.e++;
                        this.f = 0;
                        this.q.a = -5;
                    }
                }
                System.currentTimeMillis();
            }
            System.currentTimeMillis();
            this.p.E = System.currentTimeMillis();
            try {
                this.p.g = this.b.b;
                this.p.i = this.i;
                this.p.m = false;
                this.p.h = this.g;
                this.p.a = this.m.c;
                this.p.e = this.m.a;
                this.p.d = this.m.o;
                if (this.e == this.m.o) {
                    this.p.m = true;
                }
                this.p.s = this.n;
                this.p.n = this.q.a;
                this.p.k = this.h;
                if (this.m.j != null) {
                    this.p.c = (long) this.m.j.length;
                } else {
                    this.p.c = 0;
                }
                if (this.p.m && this.p.n != 0) {
                    this.p.r = 1;
                }
                this.p.w = this.m.i;
                this.p.G = this.p.y - this.p.x;
                this.p.H = this.p.z - this.p.y;
                this.p.I = this.p.B - this.p.A;
                this.p.J = this.p.C - this.p.z;
                this.p.K = this.p.D - this.p.C;
                this.p.L = this.p.E - this.p.y;
                new StringBuilder("taskKey:").append(this.p.f).append(";\ncreateWaitTime:").append(this.p.G).append(";\npreTime:").append(this.p.H).append(";\ndnsTime:0;\nconnectTime:").append(this.p.I).append(";\nreqResTime:").append(this.p.J).append(";\nwaitTime:0;\nreadDataTime:").append(this.p.K).append(";\ntotalTime:").append(this.p.L).append(";\ncostTimeReq:0");
                bd.a();
                if (this.q.a != -21) {
                    this.a.a(this.p);
                }
            } catch (OutOfMemoryError e2) {
            }
        }
        return this.q;
    }
}
