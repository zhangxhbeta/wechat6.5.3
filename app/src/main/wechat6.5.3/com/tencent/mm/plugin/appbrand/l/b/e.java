package com.tencent.mm.plugin.appbrand.l.b;

import com.tencent.mm.plugin.appbrand.l.b.a.b;
import com.tencent.mm.plugin.appbrand.l.c.d;
import com.tencent.mm.plugin.appbrand.l.e.a;
import com.tencent.mm.plugin.appbrand.l.e.c;
import com.tencent.mm.plugin.appbrand.l.e.f;
import com.tencent.mm.plugin.appbrand.l.e.h;
import com.tencent.mm.plugin.appbrand.l.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e extends d {
    private static final byte[] dUt = new byte[]{(byte) -1, (byte) 0};
    private final Random dUm = new Random();
    private boolean dUs = false;

    private static byte[] b(String str, String str2, byte[] bArr) {
        byte[] oz = oz(str);
        byte[] oz2 = oz(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{oz[0], oz[1], oz[2], oz[3], oz2[0], oz2[1], oz2[2], oz2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_76", e.toString());
            return new byte[0];
        }
    }

    private static String Il() {
        Random random = new Random();
        long nextInt = (long) (random.nextInt(12) + 1);
        String l = Long.toString(((long) (random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1)) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i = 0; i < nextInt2; i++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = abs;
        }
        String str = l;
        for (int i2 = 0; ((long) i2) < nextInt; i2++) {
            str = Math.abs(random.nextInt(str.length() - 1) + 1);
        }
        return str;
    }

    private static byte[] oz(String str) {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = (long) (str.split(" ").length - 1);
            if (length == 0) {
                throw new d("invalid Sec-WebSocket-Key (/key2/)");
            }
            parseLong = new Long(parseLong / length).longValue();
            return new byte[]{(byte) ((int) (parseLong >> 24)), (byte) ((int) ((parseLong << 8) >> 24)), (byte) ((int) ((parseLong << 16) >> 24)), (byte) ((int) ((parseLong << 24) >> 24))};
        } catch (NumberFormatException e) {
            throw new d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    public final b a(a aVar, h hVar) {
        if (this.dUs) {
            return b.NOT_MATCHED;
        }
        try {
            if (!hVar.oC("Sec-WebSocket-Origin").equals(aVar.oC("Origin")) || !a.b((f) hVar)) {
                return b.NOT_MATCHED;
            }
            byte[] SG = hVar.SG();
            if (SG == null || SG.length == 0) {
                throw new com.tencent.mm.plugin.appbrand.l.c.a();
            } else if (Arrays.equals(SG, b(aVar.oC("Sec-WebSocket-Key1"), aVar.oC("Sec-WebSocket-Key2"), aVar.SG()))) {
                return b.MATCHED;
            } else {
                return b.NOT_MATCHED;
            }
        } catch (d e) {
            v.e("MicroMsg.AppBrandNetWork.Draft_76", "bad handshakerequest exception" + e.toString());
            return b.NOT_MATCHED;
        }
    }

    public final b a(a aVar) {
        if (aVar.oC("Upgrade").equals("WebSocket") && aVar.oC("Connection").contains("Upgrade") && aVar.oC("Sec-WebSocket-Key1").length() > 0 && !aVar.oC("Sec-WebSocket-Key2").isEmpty() && aVar.oD("Origin")) {
            return b.MATCHED;
        }
        return b.NOT_MATCHED;
    }

    public final com.tencent.mm.plugin.appbrand.l.e.b a(com.tencent.mm.plugin.appbrand.l.e.b bVar) {
        bVar.put("Upgrade", "WebSocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Key1", Il());
        bVar.put("Sec-WebSocket-Key2", Il());
        if (!bVar.oD("Origin")) {
            bVar.put("Origin", "random" + this.dUm.nextInt());
        }
        byte[] bArr = new byte[8];
        this.dUm.nextBytes(bArr);
        bVar.K(bArr);
        return bVar;
    }

    public final c a(a aVar, i iVar) {
        iVar.oB("WebSocket Protocol Handshake");
        iVar.put("Upgrade", "WebSocket");
        iVar.put("Connection", aVar.oC("Connection"));
        iVar.put("Sec-WebSocket-Origin", aVar.oC("Origin"));
        iVar.put("Sec-WebSocket-Location", "ws://" + aVar.oC("Host") + aVar.SD());
        String oC = aVar.oC("Sec-WebSocket-Key1");
        String oC2 = aVar.oC("Sec-WebSocket-Key2");
        byte[] SG = aVar.SG();
        if (oC == null || oC2 == null || SG == null || SG.length != 8) {
            throw new d("Bad keys");
        }
        iVar.K(b(oC, oC2, SG));
        return iVar;
    }

    public final f j(ByteBuffer byteBuffer) {
        f a = a.a(byteBuffer, this.dTF);
        if ((a.oD("Sec-WebSocket-Key1") || this.dTF == com.tencent.mm.plugin.appbrand.l.a.b.dTr) && !a.oD("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[(this.dTF == com.tencent.mm.plugin.appbrand.l.a.b.dTs ? 8 : 16)];
            try {
                byteBuffer.get(bArr);
                a.K(bArr);
            } catch (BufferUnderflowException e) {
                throw new com.tencent.mm.plugin.appbrand.l.c.a(byteBuffer.capacity() + 16);
            }
        }
        return a;
    }

    public final List<com.tencent.mm.plugin.appbrand.l.d.d> i(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        List<com.tencent.mm.plugin.appbrand.l.d.d> l = super.l(byteBuffer);
        if (l == null) {
            byteBuffer.reset();
            l = this.dUq;
            this.dUp = true;
            if (this.dUr == null) {
                this.dUr = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.dUr.remaining()) {
                    throw new com.tencent.mm.plugin.appbrand.l.c.c();
                }
                this.dUr.put(byteBuffer);
                if (this.dUr.hasRemaining()) {
                    this.dUq = new LinkedList();
                } else if (Arrays.equals(this.dUr.array(), dUt)) {
                    l.add(new com.tencent.mm.plugin.appbrand.l.d.b((byte) 0));
                } else {
                    throw new com.tencent.mm.plugin.appbrand.l.c.c();
                }
            }
            throw new com.tencent.mm.plugin.appbrand.l.c.c();
        }
        return l;
    }

    public final ByteBuffer b(com.tencent.mm.plugin.appbrand.l.d.d dVar) {
        if (dVar.SC() == com.tencent.mm.plugin.appbrand.l.d.d.a.CLOSING) {
            return ByteBuffer.wrap(dUt);
        }
        return super.b(dVar);
    }

    public final int Sw() {
        return a.a.dUe;
    }

    public final a Sx() {
        return new e();
    }
}
