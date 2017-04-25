package com.tencent.mm.plugin.appbrand.l.b;

import com.tencent.mm.plugin.appbrand.l.b.a.b;
import com.tencent.mm.plugin.appbrand.l.d.c;
import com.tencent.mm.plugin.appbrand.l.d.e;
import com.tencent.mm.plugin.appbrand.l.e.a;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.plugin.appbrand.l.e.h;
import com.tencent.mm.plugin.appbrand.l.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d extends a {
    private final Random dUm = new Random();
    protected boolean dUp = false;
    protected List<com.tencent.mm.plugin.appbrand.l.d.d> dUq = new LinkedList();
    protected ByteBuffer dUr;

    public b a(a aVar, h hVar) {
        return (aVar.oC("WebSocket-Origin").equals(hVar.oC("Origin")) && a.b((f) hVar)) ? b.MATCHED : b.NOT_MATCHED;
    }

    public b a(a aVar) {
        if (aVar.oD("Origin") && a.b((f) aVar)) {
            return b.MATCHED;
        }
        return b.NOT_MATCHED;
    }

    public ByteBuffer b(com.tencent.mm.plugin.appbrand.l.d.d dVar) {
        if (dVar.SC() != com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT) {
            v.e("MicroMsg.AppBrandNetWork.Draft_75", "only text frames supported");
        }
        ByteBuffer Sz = dVar.Sz();
        ByteBuffer allocate = ByteBuffer.allocate(Sz.remaining() + 2);
        allocate.put((byte) 0);
        Sz.mark();
        allocate.put(Sz);
        Sz.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
    }

    public final List<com.tencent.mm.plugin.appbrand.l.d.d> a(ByteBuffer byteBuffer, boolean z) {
        v.e("MicroMsg.AppBrandNetWork.Draft_75", "not yet implemented");
        return null;
    }

    public final List<com.tencent.mm.plugin.appbrand.l.d.d> M(String str, boolean z) {
        c eVar = new e();
        try {
            eVar.m(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.l.f.b.oE(str)));
        } catch (com.tencent.mm.plugin.appbrand.l.c.b e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_75", "createFrames NotSendableException" + e.toString());
        }
        eVar.bC(true);
        eVar.a(com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT);
        eVar.bD(z);
        return Collections.singletonList(eVar);
    }

    public com.tencent.mm.plugin.appbrand.l.e.b a(com.tencent.mm.plugin.appbrand.l.e.b bVar) {
        bVar.put("Upgrade", "WebSocket");
        bVar.put("Connection", "Upgrade");
        if (!bVar.oD("Origin")) {
            bVar.put("Origin", "random" + this.dUm.nextInt());
        }
        return bVar;
    }

    public com.tencent.mm.plugin.appbrand.l.e.c a(a aVar, i iVar) {
        iVar.oB("Web Socket Protocol Handshake");
        iVar.put("Upgrade", "WebSocket");
        iVar.put("Connection", aVar.oC("Connection"));
        iVar.put("WebSocket-Origin", aVar.oC("Origin"));
        iVar.put("WebSocket-Location", "ws://" + aVar.oC("Host") + aVar.SD());
        return iVar;
    }

    protected final List<com.tencent.mm.plugin.appbrand.l.d.d> l(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == (byte) 0) {
                if (this.dUp) {
                    throw new com.tencent.mm.plugin.appbrand.l.c.c("unexpected START_OF_FRAME");
                }
                this.dUp = true;
            } else if (b == (byte) -1) {
                if (this.dUp) {
                    if (this.dUr != null) {
                        this.dUr.flip();
                        e eVar = new e();
                        eVar.m(this.dUr);
                        eVar.bC(true);
                        eVar.a(com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT);
                        this.dUq.add(eVar);
                        this.dUr = null;
                        byteBuffer.mark();
                    }
                    this.dUp = false;
                } else {
                    throw new com.tencent.mm.plugin.appbrand.l.c.c("unexpected END_OF_FRAME");
                }
            } else if (!this.dUp) {
                return null;
            } else {
                if (this.dUr == null) {
                    this.dUr = ByteBuffer.allocate(dUa);
                } else if (!this.dUr.hasRemaining()) {
                    ByteBuffer byteBuffer2 = this.dUr;
                    byteBuffer2.flip();
                    ByteBuffer allocate = ByteBuffer.allocate(a.hv(byteBuffer2.capacity() * 2));
                    allocate.put(byteBuffer2);
                    this.dUr = allocate;
                }
                this.dUr.put(b);
            }
        }
        List<com.tencent.mm.plugin.appbrand.l.d.d> list = this.dUq;
        this.dUq = new LinkedList();
        return list;
    }

    public List<com.tencent.mm.plugin.appbrand.l.d.d> i(ByteBuffer byteBuffer) {
        List<com.tencent.mm.plugin.appbrand.l.d.d> l = l(byteBuffer);
        if (l != null) {
            return l;
        }
        throw new com.tencent.mm.plugin.appbrand.l.c.b();
    }

    public final void reset() {
        this.dUp = false;
        this.dUr = null;
    }

    public int Sw() {
        return a.a.dUd;
    }

    public a Sx() {
        return new d();
    }
}
