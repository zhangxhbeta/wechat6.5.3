package com.tencent.mm.plugin.appbrand.l.b;

import com.tencent.mm.plugin.appbrand.l.d.c;
import com.tencent.mm.plugin.appbrand.l.d.d;
import com.tencent.mm.plugin.appbrand.l.d.e;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.plugin.appbrand.l.e.h;
import com.tencent.mm.plugin.appbrand.l.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class b extends a {
    private ByteBuffer dUk;
    private d dUl = null;
    private final Random dUm = new Random();

    private class a extends Throwable {
        int dUn;
        final /* synthetic */ b dUo;

        public a(b bVar, int i) {
            this.dUo = bVar;
            this.dUn = i;
        }
    }

    public static int d(f fVar) {
        int i = -1;
        String oC = fVar.oC("Sec-WebSocket-Version");
        if (oC.length() > 0) {
            try {
                i = new Integer(oC.trim()).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final com.tencent.mm.plugin.appbrand.l.b.a.b a(com.tencent.mm.plugin.appbrand.l.e.a aVar, h hVar) {
        if (!aVar.oD("Sec-WebSocket-Key") || !hVar.oD("Sec-WebSocket-Accept")) {
            return com.tencent.mm.plugin.appbrand.l.b.a.b.NOT_MATCHED;
        }
        if (oy(aVar.oC("Sec-WebSocket-Key")).equals(hVar.oC("Sec-WebSocket-Accept"))) {
            return com.tencent.mm.plugin.appbrand.l.b.a.b.MATCHED;
        }
        return com.tencent.mm.plugin.appbrand.l.b.a.b.NOT_MATCHED;
    }

    public com.tencent.mm.plugin.appbrand.l.b.a.b a(com.tencent.mm.plugin.appbrand.l.e.a aVar) {
        int d = d(aVar);
        if (d == 7 || d == 8) {
            return a.b((f) aVar) ? com.tencent.mm.plugin.appbrand.l.b.a.b.MATCHED : com.tencent.mm.plugin.appbrand.l.b.a.b.NOT_MATCHED;
        } else {
            return com.tencent.mm.plugin.appbrand.l.b.a.b.NOT_MATCHED;
        }
    }

    public final ByteBuffer b(d dVar) {
        int i;
        int i2;
        int i3 = -128;
        int i4 = 0;
        ByteBuffer Sz = dVar.Sz();
        int i5 = this.dTF == com.tencent.mm.plugin.appbrand.l.a.b.dTr ? 1 : 0;
        int i6 = Sz.remaining() <= 125 ? 1 : Sz.remaining() <= 65535 ? 2 : 8;
        if (i6 > 1) {
            i = i6 + 1;
        } else {
            i = i6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i5 != 0 ? 4 : 0) + (i + 1)) + Sz.remaining());
        com.tencent.mm.plugin.appbrand.l.d.d.a SC = dVar.SC();
        if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.CONTINUOUS) {
            i = 0;
        } else if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT) {
            i = 1;
        } else if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.BINARY) {
            i = 2;
        } else if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING) {
            i = 8;
        } else if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.PING) {
            i = 9;
        } else if (SC == com.tencent.mm.plugin.appbrand.l.d.d.a.PONG) {
            i = 10;
        } else {
            v.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + SC.toString());
            i = 8;
        }
        if (dVar.SA()) {
            i2 = -128;
        } else {
            i2 = 0;
        }
        allocate.put((byte) (i | ((byte) i2)));
        byte[] f = f((long) Sz.remaining(), i6);
        if (i6 == 1) {
            byte b = f[0];
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (b | i3));
        } else if (i6 == 2) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 126));
            allocate.put(f);
        } else if (i6 == 8) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 127));
            allocate.put(f);
        } else {
            v.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i5 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.dUm.nextInt());
            allocate.put(allocate2.array());
            while (Sz.hasRemaining()) {
                allocate.put((byte) (Sz.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(Sz);
        }
        allocate.flip();
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        c eVar = new e();
        try {
            eVar.m(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.l.c.b e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.bC(true);
        eVar.a(com.tencent.mm.plugin.appbrand.l.d.d.a.BINARY);
        eVar.bD(z);
        return Collections.singletonList(eVar);
    }

    public final List<d> M(String str, boolean z) {
        c eVar = new e();
        try {
            eVar.m(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.l.f.b.oE(str)));
        } catch (com.tencent.mm.plugin.appbrand.l.c.b e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.bC(true);
        eVar.a(com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT);
        eVar.bD(z);
        return Collections.singletonList(eVar);
    }

    private static String oy(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return com.tencent.mm.plugin.appbrand.l.f.a.L(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            return "";
        }
    }

    public com.tencent.mm.plugin.appbrand.l.e.b a(com.tencent.mm.plugin.appbrand.l.e.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.dUm.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.l.f.a.L(bArr));
        return bVar;
    }

    public final com.tencent.mm.plugin.appbrand.l.e.c a(com.tencent.mm.plugin.appbrand.l.e.a aVar, i iVar) {
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.oC("Connection"));
        iVar.oB("Switching Protocols");
        String oC = aVar.oC("Sec-WebSocket-Key");
        if (oC == null) {
            throw new com.tencent.mm.plugin.appbrand.l.c.d("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", oy(oC));
        return iVar;
    }

    private static byte[] f(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> i(ByteBuffer byteBuffer) {
        while (true) {
            List<d> linkedList = new LinkedList();
            if (this.dUk == null) {
                break;
            }
            try {
                break;
            } catch (a e) {
                this.dUk.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a.hv(e.dUn));
                this.dUk.rewind();
                allocate.put(this.dUk);
                this.dUk = allocate;
            }
        }
        byteBuffer.mark();
        int remaining = byteBuffer.remaining();
        int remaining2 = this.dUk.remaining();
        if (remaining2 > remaining) {
            this.dUk.put(byteBuffer.array(), byteBuffer.position(), remaining);
            byteBuffer.position(remaining + byteBuffer.position());
            return Collections.emptyList();
        }
        this.dUk.put(byteBuffer.array(), byteBuffer.position(), remaining2);
        byteBuffer.position(byteBuffer.position() + remaining2);
        linkedList.add(k((ByteBuffer) this.dUk.duplicate().position(0)));
        this.dUk = null;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(k(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.dUk = ByteBuffer.allocate(a.hv(e2.dUn));
                this.dUk.put(byteBuffer);
            }
        }
        return linkedList;
    }

    private d k(ByteBuffer byteBuffer) {
        int i = 10;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(this, 2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new com.tencent.mm.plugin.appbrand.l.c.c("bad rsv " + b2);
        }
        int i3;
        com.tencent.mm.plugin.appbrand.l.d.d.a aVar;
        b2 = byteBuffer.get();
        if ((b2 & -128) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        b2 = (byte) (b2 & 127);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.CONTINUOUS;
                break;
            case (byte) 1:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT;
                break;
            case (byte) 2:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.BINARY;
                break;
            case (byte) 8:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING;
                break;
            case (byte) 9:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.PING;
                break;
            case (byte) 10:
                aVar = com.tencent.mm.plugin.appbrand.l.d.d.a.PONG;
                break;
            default:
                throw new com.tencent.mm.plugin.appbrand.l.c.c("unknow optcode " + ((short) b));
        }
        if (z || !(aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING)) {
            int intValue;
            int i4;
            byte b3;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                i = 2;
                b3 = b2;
            } else if (aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING) {
                throw new com.tencent.mm.plugin.appbrand.l.c.c("more than 125 octets");
            } else if (b2 == (byte) 126) {
                if (remaining < 4) {
                    throw new a(this, 4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new a(this, 10);
            } else {
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    v.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b3 = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            if (i3 != 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 = (i4 + i) + intValue;
            if (remaining < i4) {
                throw new a(this, i4);
            }
            d bVar;
            ByteBuffer allocate = ByteBuffer.allocate(a.hv(intValue));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < intValue) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING) {
                bVar = new com.tencent.mm.plugin.appbrand.l.d.b();
            } else {
                bVar = new e();
                bVar.bC(z);
                bVar.a(aVar);
            }
            allocate.flip();
            bVar.m(allocate);
            return bVar;
        }
        throw new com.tencent.mm.plugin.appbrand.l.c.c("control frames may no be fragmented");
    }

    public final void reset() {
        this.dUk = null;
    }

    public a Sx() {
        return new b();
    }

    public final int Sw() {
        return com.tencent.mm.plugin.appbrand.l.b.a.a.dUf;
    }
}
