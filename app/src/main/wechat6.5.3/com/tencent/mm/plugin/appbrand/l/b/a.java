package com.tencent.mm.plugin.appbrand.l.b;

import com.tencent.mm.plugin.appbrand.l.d.d;
import com.tencent.mm.plugin.appbrand.l.e.c;
import com.tencent.mm.plugin.appbrand.l.e.e;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.plugin.appbrand.l.e.h;
import com.tencent.mm.plugin.appbrand.l.e.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a {
    public static int dTZ = BaseReportManager.MAX_READ_COUNT;
    public static int dUa = 64;
    public static final byte[] dUb = com.tencent.mm.plugin.appbrand.l.f.b.oE("<policy-file-request/>\u0000");
    protected int dTF = 0;
    protected com.tencent.mm.plugin.appbrand.l.d.d.a dUc = null;

    public enum a {
        ;

        static {
            dUd = 1;
            dUe = 2;
            dUf = 3;
            dUg = new int[]{dUd, dUe, dUf};
        }
    }

    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public abstract List<d> M(String str, boolean z);

    public abstract int Sw();

    public abstract a Sx();

    public abstract b a(com.tencent.mm.plugin.appbrand.l.e.a aVar);

    public abstract b a(com.tencent.mm.plugin.appbrand.l.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.l.e.b a(com.tencent.mm.plugin.appbrand.l.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.l.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract ByteBuffer b(d dVar);

    public abstract List<d> i(ByteBuffer byteBuffer);

    public abstract void reset();

    private static String h(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        return byteBuffer2 == null ? null : com.tencent.mm.plugin.appbrand.l.f.b.q(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static c a(ByteBuffer byteBuffer, int i) {
        String h = h(byteBuffer);
        if (h == null) {
            throw new com.tencent.mm.plugin.appbrand.l.c.a(byteBuffer.capacity() + 128);
        }
        String[] split = h.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.l.c.d();
        }
        c eVar;
        if (i == com.tencent.mm.plugin.appbrand.l.a.b.dTr) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.oB(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.l.e.d();
            eVar.oA(split[1]);
        }
        while (true) {
            h = h(byteBuffer);
            if (h != null && h.length() > 0) {
                String[] split2 = h.split(":", 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.l.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (h == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.l.c.a();
            }
        }
        if (h == null) {
            return eVar;
        }
        throw new com.tencent.mm.plugin.appbrand.l.c.a();
    }

    protected static boolean b(f fVar) {
        return fVar.oC("Upgrade").equalsIgnoreCase("websocket") && fVar.oC("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public static com.tencent.mm.plugin.appbrand.l.a.b<List> c(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.l.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.l.e.a) fVar).SD());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).SE());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.l.e.a) fVar).SD());
            stringBuilder.append(" HTTP/1.1");
            v.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator SF = fVar.SF();
        while (SF.hasNext()) {
            String str = (String) SF.next();
            String oC = fVar.oC(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(oC);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] oF = com.tencent.mm.plugin.appbrand.l.f.b.oF(stringBuilder.toString());
        byte[] SG = fVar.SG();
        ByteBuffer allocate = ByteBuffer.allocate((SG == null ? 0 : SG.length) + oF.length);
        allocate.put(oF);
        if (SG != null) {
            allocate.put(SG);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f j(ByteBuffer byteBuffer) {
        return a(byteBuffer, this.dTF);
    }

    public static int hv(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.l.c.b("Negative count");
    }

    public final void hw(int i) {
        this.dTF = i;
    }
}
