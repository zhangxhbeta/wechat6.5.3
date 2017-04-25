package ct;

import ct.b.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public final class ba {
    private static ba a = new ba();
    private int b = 20000;
    private Socket c;
    private int d = -1;
    private bb e;
    private s f;
    private OutputStream g;
    private InputStream h;
    private int i = -1;
    private int j = -1;
    private long k = -1;
    private int l = -1;
    private int m = -1;

    public static synchronized ba a() {
        ba baVar;
        synchronized (ba.class) {
            baVar = a;
        }
        return baVar;
    }

    private synchronized void a(int i) {
        a(i, null);
    }

    private synchronized void a(int i, String str) {
        if (!(i == this.d || this.e == null)) {
            this.e.b = i;
            if (str != null) {
                this.e.c = str;
            }
        }
    }

    private synchronized void b() {
        int i = 0;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                int read;
                new StringBuilder("doReadData: try read data...sk:").append(this.c);
                bd.b();
                byte[] bArr = new byte[4];
                while (i < 4) {
                    bd.a();
                    read = this.h.read(bArr, i, 4 - i);
                    if (read <= 0) {
                        if (read == -1) {
                            break;
                        }
                    } else {
                        this.l = (int) (System.currentTimeMillis() - this.k);
                        i += read;
                        if (i == 4) {
                            break;
                        }
                    }
                }
                if (i == 4) {
                    read = be.a(bArr);
                    if (read <= 4 || read > 524288) {
                        a(-6, "packSizeFail:" + read);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, 4);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        while (i < read) {
                            int i2 = read - i;
                            bd.a();
                            i2 = this.h.read(bArr2, i, i2);
                            bd.a();
                            if (i2 > 0) {
                                i += i2;
                            } else if (i2 == -1) {
                                break;
                            }
                        }
                        if (i != read) {
                            new StringBuilder("read fail. readLen:").append(i).append(",packSize:").append(read);
                            bd.c();
                            a(-6, "readLen != packSize,rspBuff:" + be.b(bArr2));
                        } else {
                            this.m = (int) (System.currentTimeMillis() - currentTimeMillis2);
                            bd.b();
                            bi biVar = new bi();
                            try {
                                biVar.a(bArr2);
                                if (this.e != null) {
                                    this.e.a = biVar;
                                    this.e.b = 0;
                                    this.m = (int) (System.currentTimeMillis() - currentTimeMillis);
                                    this.e.f = this.l;
                                    this.e.d = this.j;
                                    this.e.g = this.m;
                                }
                            } catch (Exception e) {
                                a(-8, be.a(e));
                            }
                        }
                    }
                } else {
                    a(-6, "readLen fail:" + i);
                }
            } catch (Exception e2) {
                a(-7, be.a(e2));
            }
        }
    }

    private synchronized boolean b(bb bbVar) {
        boolean z;
        int i = 0;
        z = false;
        while (!z) {
            if (bbVar != null) {
                if (System.currentTimeMillis() - bbVar.i < ((long) bbVar.j)) {
                    Object obj = null;
                    if (obj != null || i >= 5) {
                        break;
                    }
                    i++;
                    if (c()) {
                        e();
                    } else {
                        try {
                            new StringBuilder("doSendData try send task:").append(bbVar.k()).append(",sk:").append(this.c);
                            bd.b();
                            byte[] l = bbVar.l();
                            this.g.write(l, 0, l.length);
                            this.g.flush();
                            this.k = System.currentTimeMillis();
                            new StringBuilder("doSendData: sent data len:").append(l.length);
                            bd.a();
                            z = true;
                        } catch (Exception e) {
                            bbVar.b = -5;
                            bbVar.c = be.a(e);
                            if (!z) {
                                try {
                                    a(bbVar.b);
                                    this.g.close();
                                    this.c.close();
                                    e();
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Throwable th) {
                            if (!z) {
                                try {
                                    a(bbVar.b);
                                    this.g.close();
                                    this.c.close();
                                    e();
                                } catch (Exception e3) {
                                }
                            }
                        }
                    }
                }
            }
            int i2 = 1;
            i++;
            if (c()) {
                e();
            } else {
                new StringBuilder("doSendData try send task:").append(bbVar.k()).append(",sk:").append(this.c);
                bd.b();
                byte[] l2 = bbVar.l();
                this.g.write(l2, 0, l2.length);
                this.g.flush();
                this.k = System.currentTimeMillis();
                new StringBuilder("doSendData: sent data len:").append(l2.length);
                bd.a();
                z = true;
            }
        }
        return z;
    }

    private synchronized boolean c() {
        boolean z;
        z = false;
        if (!(this.c == null || !this.c.isConnected() || this.c.isClosed() || this.g == null)) {
            z = true;
        }
        return z;
    }

    private synchronized void d() {
        if (this.h != null) {
            try {
                this.h.close();
                this.h = null;
            } catch (Exception e) {
                this.c = null;
            } catch (Exception e2) {
                this.g = null;
            } catch (Exception e3) {
                this.h = null;
            } catch (Throwable th) {
                this.h = null;
            }
        }
        if (this.g != null) {
            this.g.close();
            this.g = null;
        }
        if (this.c != null) {
            this.c.close();
            this.c = null;
        }
        ay.a();
    }

    private synchronized void e() {
        bd.c();
        az azVar = new az();
        if (this.e.j > 0) {
            azVar.c = this.e.j;
        } else {
            azVar.c = a.b().b.a;
        }
        int i = a.b().b.d;
        if (i > 0 && i < 4) {
            azVar.a = i;
            azVar.b = i;
        }
        String str = "dispatcher.3g.qq.com";
        int[] iArr = c.a;
        azVar.f = str;
        az.a(iArr);
        t.a a = u.a().a(str);
        if (a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.c);
            azVar.d = arrayList;
        }
        if (a.b().a.b > 0) {
            System.currentTimeMillis();
            a.b();
        }
        azVar.e = a.b().a.c();
        this.j = 0;
        azVar.a();
        this.i = azVar.j;
        this.j = azVar.k;
        this.e.e = this.i;
        this.e.d = this.j;
        if (azVar.h == 0) {
            this.c = azVar.g;
            this.f = azVar.l;
            this.e.h = this.f;
            new StringBuilder("Connect ok. sk:").append(this.c).append(",accessIP:").append(this.f);
            bd.c();
            if (this.c != null && this.c.isConnected() && !this.c.isClosed()) {
                try {
                    this.c.setSoTimeout(this.b);
                    this.c.setReceiveBufferSize(524288);
                    this.g = this.c.getOutputStream();
                    this.h = this.c.getInputStream();
                    new StringBuilder("reConnect socket succ. sk:").append(this.c);
                    bd.b();
                } catch (Exception e) {
                    new StringBuilder("reConnect socket fail. sk:").append(this.c);
                    bd.d();
                    a(-3, be.a(e));
                    d();
                }
            } else if (this.c == null) {
                a(-3, "sk is null");
            } else {
                a(-3, "connect:" + this.c.isConnected() + "close:" + this.c.isClosed());
            }
        } else if (!bc.e()) {
            a(-4);
        } else if (i.b("info.3g.qq.com")) {
            a(-3, "ret:" + azVar.h + ",failInfo:" + azVar.i);
        } else {
            a(-16);
        }
    }

    public final void a(bb bbVar) {
        if (bbVar != null) {
            try {
                this.e = bbVar;
                this.e.i = System.currentTimeMillis();
                this.e.j = 22000;
                e();
                if (c()) {
                    b(bbVar);
                    b();
                    d();
                }
            } catch (Exception e) {
            }
        }
    }
}
