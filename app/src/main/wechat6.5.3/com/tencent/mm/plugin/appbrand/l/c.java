package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.appbrand.l.b.a;
import com.tencent.mm.plugin.appbrand.l.b.b;
import com.tencent.mm.plugin.appbrand.l.b.e;
import com.tencent.mm.plugin.appbrand.l.d.d;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.plugin.appbrand.l.e.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int dTu = 16384;
    public static final List<a> dTv;
    private volatile boolean dTA = false;
    public int dTB = a.a.dTl;
    public final d dTC;
    private List<a> dTD;
    public a dTE = null;
    public int dTF;
    private d.a dTG = null;
    private ByteBuffer dTH = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.l.e.a dTI = null;
    private String dTJ = null;
    private Integer dTK = null;
    private Boolean dTL = null;
    public String dTM = null;
    public SelectionKey dTw;
    public ByteChannel dTx;
    public final BlockingQueue<ByteBuffer> dTy;
    public final BlockingQueue<ByteBuffer> dTz;

    static {
        List arrayList = new ArrayList(4);
        dTv = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.l.b.c());
        dTv.add(new b());
        dTv.add(new e());
        dTv.add(new com.tencent.mm.plugin.appbrand.l.b.d());
    }

    public c(d dVar, a aVar) {
        if (dVar == null || (aVar == null && this.dTF == a.b.dTs)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.dTy = new LinkedBlockingQueue();
        this.dTz = new LinkedBlockingQueue();
        this.dTC = dVar;
        this.dTF = a.b.dTr;
        if (aVar != null) {
            this.dTE = aVar.Sx();
        }
    }

    public final void c(ByteBuffer byteBuffer) {
        if (DEBUG) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.dTB != a.a.dTl) {
            e(byteBuffer);
        } else if (!d(byteBuffer)) {
        } else {
            if (byteBuffer.hasRemaining()) {
                e(byteBuffer);
            } else if (this.dTH.hasRemaining()) {
                e(this.dTH);
            }
        }
    }

    private boolean d(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        if (this.dTH.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.dTH.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.dTH.capacity() + byteBuffer.remaining());
                this.dTH.flip();
                allocate.put(this.dTH);
                this.dTH = allocate;
            }
            this.dTH.put(byteBuffer);
            this.dTH.flip();
            byteBuffer2 = this.dTH;
        }
        byteBuffer2.mark();
        try {
            if (this.dTE == null) {
                a.b bVar;
                byteBuffer2.mark();
                if (byteBuffer2.limit() > a.dUb.length) {
                    bVar = a.b.NOT_MATCHED;
                } else if (byteBuffer2.limit() < a.dUb.length) {
                    throw new com.tencent.mm.plugin.appbrand.l.c.a(a.dUb.length);
                } else {
                    i = 0;
                    while (byteBuffer2.hasRemaining()) {
                        if (a.dUb[i] != byteBuffer2.get()) {
                            byteBuffer2.reset();
                            bVar = a.b.NOT_MATCHED;
                            break;
                        }
                        i++;
                    }
                    bVar = a.b.MATCHED;
                }
                if (bVar == a.b.MATCHED) {
                    try {
                        f(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.l.f.b.oE(this.dTC.a(this))));
                        c(-3, "", false);
                    } catch (com.tencent.mm.plugin.appbrand.l.c.b e) {
                        v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "remote peer closed connection before flashpolicy could be transmitted: " + e.toString());
                        c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                    }
                    return false;
                }
            }
            try {
                f j;
                if (this.dTF != a.b.dTs) {
                    if (this.dTF == a.b.dTr) {
                        this.dTE.hw(this.dTF);
                        j = this.dTE.j(byteBuffer2);
                        if (j instanceof h) {
                            j = (h) j;
                            if (this.dTE.a(this.dTI, (h) j) == a.b.MATCHED) {
                                a(j);
                                return true;
                            }
                            c(1002, "draft refuses handshake" + j.SE(), false);
                        } else {
                            e(1002, "wrong http function", false);
                            return false;
                        }
                    }
                    return false;
                } else if (this.dTE == null) {
                    for (a Sx : this.dTD) {
                        a Sx2 = Sx.Sx();
                        try {
                            Sx2.hw(this.dTF);
                            byteBuffer2.reset();
                            j = Sx2.j(byteBuffer2);
                            if (j instanceof com.tencent.mm.plugin.appbrand.l.e.a) {
                                j = (com.tencent.mm.plugin.appbrand.l.e.a) j;
                                if (Sx2.a((com.tencent.mm.plugin.appbrand.l.e.a) j) == a.b.MATCHED) {
                                    this.dTM = j.SD();
                                    try {
                                        W(a.c(Sx2.a((com.tencent.mm.plugin.appbrand.l.e.a) j, this.dTC.Sr())));
                                        this.dTE = Sx2;
                                        a(j);
                                        return true;
                                    } catch (com.tencent.mm.plugin.appbrand.l.c.b e2) {
                                        e(e2.dUv, e2.getMessage(), false);
                                        return false;
                                    } catch (Exception e3) {
                                        this.dTC.d(e3);
                                        e(-1, e3.getMessage(), false);
                                        return false;
                                    }
                                }
                                continue;
                            } else {
                                e(1002, "wrong http function", false);
                                return false;
                            }
                        } catch (com.tencent.mm.plugin.appbrand.l.c.d e4) {
                            v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e4.toString());
                        }
                    }
                    if (this.dTE == null) {
                        c(1002, "no draft matches", false);
                    }
                    return false;
                } else {
                    j = this.dTE.j(byteBuffer2);
                    if (j instanceof com.tencent.mm.plugin.appbrand.l.e.a) {
                        j = (com.tencent.mm.plugin.appbrand.l.e.a) j;
                        if (this.dTE.a((com.tencent.mm.plugin.appbrand.l.e.a) j) == a.b.MATCHED) {
                            a(j);
                            return true;
                        }
                        c(1002, "the handshake did finaly not match", false);
                        return false;
                    }
                    e(1002, "wrong http function", false);
                    return false;
                }
            } catch (com.tencent.mm.plugin.appbrand.l.c.b e22) {
                v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e22.toString());
                a(e22);
            }
        } catch (com.tencent.mm.plugin.appbrand.l.c.a e5) {
            v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e5.toString());
            if (this.dTH.capacity() == 0) {
                byteBuffer2.reset();
                i = e5.dUu;
                if (i == 0) {
                    i = byteBuffer2.capacity() + 16;
                }
                this.dTH = ByteBuffer.allocate(i);
                this.dTH.put(byteBuffer);
            } else {
                this.dTH.position(this.dTH.limit());
                this.dTH.limit(this.dTH.capacity());
            }
        }
    }

    private void e(ByteBuffer byteBuffer) {
        try {
            for (d dVar : this.dTE.i(byteBuffer)) {
                if (DEBUG) {
                    v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
                }
                d.a SC = dVar.SC();
                boolean SA = dVar.SA();
                if (SC == d.a.CLOSING) {
                    int Sy;
                    String message;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.l.d.a) {
                        com.tencent.mm.plugin.appbrand.l.d.a aVar = (com.tencent.mm.plugin.appbrand.l.d.a) dVar;
                        Sy = aVar.Sy();
                        message = aVar.getMessage();
                    } else {
                        message = str;
                        Sy = 1005;
                    }
                    if (this.dTB == a.a.dTo) {
                        d(Sy, message, true);
                    } else if (this.dTE.Sw() == a.a.dUf) {
                        c(Sy, message, true);
                    } else {
                        e(Sy, message, false);
                    }
                } else if (SC == d.a.PING) {
                    this.dTC.a(this, dVar);
                } else if (SC == d.a.PONG) {
                    continue;
                } else if (!SA || SC == d.a.CONTINUOUS) {
                    if (SC != d.a.CONTINUOUS) {
                        if (this.dTG != null) {
                            throw new com.tencent.mm.plugin.appbrand.l.c.b("Previous continuous frame sequence not completed.");
                        }
                        this.dTG = SC;
                    } else if (SA) {
                        if (this.dTG == null) {
                            throw new com.tencent.mm.plugin.appbrand.l.c.b("Continuous frame sequence was not started.");
                        }
                        this.dTG = null;
                    } else if (this.dTG == null) {
                        throw new com.tencent.mm.plugin.appbrand.l.c.b("Continuous frame sequence was not started.");
                    }
                    try {
                        this.dTC.d(dVar);
                    } catch (Exception e) {
                        this.dTC.d(e);
                    }
                } else if (this.dTG != null) {
                    throw new com.tencent.mm.plugin.appbrand.l.c.b("Continuous frame sequence not completed.");
                } else if (SC == d.a.TEXT) {
                    try {
                        this.dTC.ox(com.tencent.mm.plugin.appbrand.l.f.b.n(dVar.Sz()));
                    } catch (Exception e2) {
                        this.dTC.d(e2);
                    }
                } else if (SC == d.a.BINARY) {
                    try {
                        this.dTC.g(dVar.Sz());
                    } catch (Exception e22) {
                        this.dTC.d(e22);
                    }
                } else {
                    throw new com.tencent.mm.plugin.appbrand.l.c.b("non control or continious frame expected");
                }
            }
        } catch (com.tencent.mm.plugin.appbrand.l.c.b e3) {
            v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e3.toString());
            this.dTC.d((Exception) e3);
            a(e3);
        }
    }

    public void c(int i, String str, boolean z) {
        if (this.dTB != a.a.dTo && this.dTB != a.a.dTp) {
            if (this.dTB == a.a.dTn) {
                if (i == 1006) {
                    this.dTB = a.a.dTo;
                    e(i, str, false);
                    return;
                }
                if (this.dTE.Sw() != a.a.dUd) {
                    try {
                        a(new com.tencent.mm.plugin.appbrand.l.d.b(i, str));
                    } catch (Exception e) {
                        v.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                        this.dTC.d(e);
                        e(1006, "generated frame is invalid", false);
                    }
                }
                e(i, str, z);
            } else if (i == -3) {
                e(-3, str, true);
            } else {
                e(-1, str, false);
            }
            if (i == 1002) {
                e(i, str, z);
            }
            this.dTB = a.a.dTo;
            this.dTH = null;
        }
    }

    public synchronized void d(int i, String str, boolean z) {
        if (this.dTB != a.a.dTp) {
            if (this.dTw != null) {
                this.dTw.cancel();
            }
            if (this.dTx != null) {
                try {
                    this.dTx.close();
                } catch (Exception e) {
                    this.dTC.d(e);
                }
            }
            try {
                this.dTC.B(i, str);
            } catch (Exception e2) {
                this.dTC.d(e2);
            }
            if (this.dTE != null) {
                this.dTE.reset();
            }
            this.dTI = null;
            this.dTB = a.a.dTp;
            this.dTy.clear();
        }
    }

    private void hu(int i) {
        d(i, "", true);
    }

    private synchronized void e(int i, String str, boolean z) {
        if (!this.dTA) {
            this.dTK = Integer.valueOf(i);
            this.dTJ = str;
            this.dTL = Boolean.valueOf(z);
            this.dTA = true;
            if (this.dTE != null) {
                this.dTE.reset();
            }
            this.dTI = null;
        }
    }

    public final void Ss() {
        if (this.dTB == a.a.dTl) {
            hu(-1);
        } else if (this.dTA) {
            d(this.dTK.intValue(), this.dTJ, this.dTL.booleanValue());
        } else if (this.dTE.Sw() == a.a.dUd) {
            hu(BaseReportManager.MAX_READ_COUNT);
        } else if (this.dTE.Sw() != a.a.dUe || this.dTF == a.b.dTs) {
            hu(1006);
        } else {
            hu(BaseReportManager.MAX_READ_COUNT);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.l.c.b bVar) {
        c(bVar.dUv, bVar.getMessage(), false);
    }

    public final void d(Collection<d> collection) {
        if (isOpen()) {
            for (d a : collection) {
                a(a);
            }
            return;
        }
        throw new com.tencent.mm.plugin.appbrand.l.c.f();
    }

    public final void a(d dVar) {
        if (DEBUG) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        f(this.dTE.b(dVar));
    }

    private void f(ByteBuffer byteBuffer) {
        if (DEBUG) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.dTy.add(byteBuffer);
    }

    public final void W(List<ByteBuffer> list) {
        for (ByteBuffer f : list) {
            f(f);
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.dTE.getClass().getSimpleName());
        }
        this.dTB = a.a.dTn;
        try {
            this.dTC.St();
        } catch (Exception e) {
            this.dTC.d(e);
        }
    }

    public final boolean isOpen() {
        return this.dTB == a.a.dTn;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return super.toString();
    }

    public final InetSocketAddress Sq() {
        return this.dTC.Su();
    }
}
