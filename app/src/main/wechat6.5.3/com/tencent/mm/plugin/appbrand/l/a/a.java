package com.tencent.mm.plugin.appbrand.l.a;

import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.appbrand.l.c;
import com.tencent.mm.plugin.appbrand.l.e.d;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.l.a, Runnable {
    private com.tencent.mm.plugin.appbrand.l.b.a dTE;
    protected URI dTN = null;
    public c dTO = null;
    private Socket dTP = null;
    private InputStream dTQ;
    OutputStream dTR;
    private Proxy dTS = Proxy.NO_PROXY;
    private Thread dTT;
    private Map<String, String> dTU;
    private CountDownLatch dTV = new CountDownLatch(1);
    private CountDownLatch dTW = new CountDownLatch(1);
    private int dTX = 0;

    private class a implements Runnable {
        final /* synthetic */ a dTY;

        private a(a aVar) {
            this.dTY = aVar;
        }

        public final void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.dTY.dTO.dTy.take();
                    this.dTY.dTR.write(byteBuffer.array(), 0, byteBuffer.limit());
                    this.dTY.dTR.flush();
                } catch (IOException e) {
                    this.dTY.dTO.Ss();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public abstract void QT();

    public abstract void c(Exception exception);

    public abstract void nQ(String str);

    public abstract void z(int i, String str);

    public a(URI uri, com.tencent.mm.plugin.appbrand.l.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.dTN = uri;
            this.dTE = aVar;
            this.dTU = map;
            this.dTX = i;
            this.dTO = new c(this, aVar);
        }
    }

    public final void connect() {
        if (this.dTT != null) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.dTT = new Thread(this);
        this.dTT.start();
    }

    public final void close() {
        if (this.dTT != null) {
            this.dTO.c(BaseReportManager.MAX_READ_COUNT, "", false);
        }
    }

    public void run() {
        try {
            if (this.dTP == null) {
                this.dTP = new Socket(this.dTS);
            } else if (this.dTP.isClosed()) {
                throw new IOException();
            }
            if (!this.dTP.isBound()) {
                this.dTP.connect(new InetSocketAddress(this.dTN.getHost(), getPort()), this.dTX);
            }
            this.dTQ = this.dTP.getInputStream();
            this.dTR = this.dTP.getOutputStream();
            Sv();
            this.dTT = new Thread(new a());
            this.dTT.start();
            byte[] bArr = new byte[c.dTu];
            while (true) {
                try {
                    if (!(this.dTO.dTB == com.tencent.mm.plugin.appbrand.l.a.a.dTp)) {
                        int read = this.dTQ.read(bArr);
                        if (read != -1) {
                            this.dTO.c(ByteBuffer.wrap(bArr, 0, read));
                        }
                    }
                    break;
                } catch (IOException e) {
                    this.dTO.Ss();
                    return;
                } catch (Exception e2) {
                    c(e2);
                    this.dTO.d(1006, e2.getMessage(), false);
                    return;
                }
            }
            this.dTO.Ss();
        } catch (Exception e22) {
            z(-1, "");
            this.dTO.d(-1, e22.getMessage(), false);
        }
    }

    private int getPort() {
        int port = this.dTN.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.dTN.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void Sv() {
        String path = this.dTN.getPath();
        String query = this.dTN.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        query = this.dTN.getHost() + (port != 80 ? ":" + port : "");
        com.tencent.mm.plugin.appbrand.l.e.b dVar = new d();
        dVar.oA(path);
        dVar.put("Host", query);
        if (this.dTU != null) {
            for (Entry entry : this.dTU.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.dTO;
        cVar.dTI = cVar.dTE.a(dVar);
        cVar.dTM = dVar.SD();
        if (cVar.dTM != null) {
            com.tencent.mm.plugin.appbrand.l.b.a aVar = cVar.dTE;
            f fVar = cVar.dTI;
            int i = cVar.dTF;
            cVar.W(com.tencent.mm.plugin.appbrand.l.b.a.c(fVar));
        }
    }

    public final void ox(String str) {
        nQ(str);
    }

    public final void g(ByteBuffer byteBuffer) {
        b(byteBuffer);
    }

    public final void d(com.tencent.mm.plugin.appbrand.l.d.d dVar) {
        c(dVar);
    }

    public final void St() {
        this.dTV.countDown();
        QT();
    }

    public final void B(int i, String str) {
        this.dTV.countDown();
        this.dTW.countDown();
        if (this.dTT != null) {
            this.dTT.interrupt();
        }
        try {
            if (this.dTP != null) {
                this.dTP.close();
            }
        } catch (Exception e) {
            c(e);
        }
        z(i, str);
    }

    public final void d(Exception exception) {
        c(exception);
    }

    public final InetSocketAddress Su() {
        if (this.dTP != null) {
            return (InetSocketAddress) this.dTP.getLocalSocketAddress();
        }
        return null;
    }

    public void b(ByteBuffer byteBuffer) {
    }

    public void c(com.tencent.mm.plugin.appbrand.l.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.dTP != null) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.dTP = socket;
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.l.d.d dVar) {
        this.dTO.a(dVar);
    }

    public final InetSocketAddress Sq() {
        return this.dTO.Sq();
    }
}
