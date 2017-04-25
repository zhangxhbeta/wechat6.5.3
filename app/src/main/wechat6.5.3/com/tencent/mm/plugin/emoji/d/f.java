package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.a.e;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;

public class f {
    public static f fbb;
    boolean aHp = false;
    private String apU;

    public static f aeV() {
        if (fbb == null) {
            synchronized (f.class) {
                fbb = new f();
            }
        }
        return fbb;
    }

    public final String aeW() {
        if (be.kS(this.apU)) {
            this.apU = g.afx().fch.getKey();
        }
        return this.apU;
    }

    public final boolean aeX() {
        if (be.kS(aeW())) {
            return false;
        }
        return true;
    }

    public final boolean c(c cVar, boolean z) {
        if (cVar == null) {
            v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            return false;
        } else if (aeX()) {
            String dR = cVar.dR(cVar.field_groupId, cVar.EB());
            if (e.aR(dR)) {
                boolean z2 = false;
                byte[] c = e.c(dR, 0, 10);
                if (c != null) {
                    try {
                        if (c.length >= 10) {
                            z2 = o.bf(c);
                        }
                    } catch (Throwable th) {
                        v.a("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || r2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int aQ = e.aQ(dR);
                    if (aQ > 1024) {
                        i = 1024;
                    } else {
                        i = aQ;
                    }
                    Object c2 = e.c(dR, 0, aQ);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(e.c(dR, 0, i), aeW().getBytes(), true, false);
                    if (be.bl(aesCryptEcb) || be.bl(c2)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, c2, 0, i);
                        i = e.b(dR, c2, c2.length);
                    }
                    if (i == 0) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 6, 1, false);
                        cVar.field_reserved4 |= c.nxh;
                        cVar.field_size = aQ;
                        g.afx().fch.s(cVar);
                        v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c2.length), Long.valueOf(r8)});
                        return true;
                    }
                    v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    com.tencent.mm.plugin.report.service.g.iuh.a(252, 3, 1, false);
                    return false;
                }
                v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                return true;
            }
            v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[]{dR});
            cVar.field_reserved4 = 0;
            g.afx().fch.s(cVar);
            return false;
        } else {
            v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            return false;
        }
    }

    public final byte[] a(c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return null;
        }
        String dR = cVar.dR(cVar.field_groupId, cVar.EB());
        Object c = e.c(dR, 0, e.aQ(dR));
        if (e.aQ(dR) <= 0 || c == null || c.length < 10) {
            v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[]{dR});
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(c, 0, obj, 0, 10);
        if ((cVar.field_reserved4 & c.nxh) != c.nxh || o.bf(obj)) {
            return c;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int aQ = e.aQ(dR);
        if (aQ > 1024) {
            aQ = 1024;
        }
        byte[] c2 = e.c(dR, 0, aQ);
        Object obj2 = null;
        if (!be.kS(aeW())) {
            obj2 = AesEcb.aesCryptEcb(c2, aeW().getBytes(), false, false);
        }
        if (be.bl(obj2) || be.bl(c)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(252, 2, 1, false);
            v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[]{dR});
            return c;
        }
        System.arraycopy(obj2, 0, c, 0, aQ);
        com.tencent.mm.plugin.report.service.g.iuh.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        com.tencent.mm.plugin.report.service.g.iuh.a(252, 5, 1, false);
        v.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c.length), Long.valueOf(r8)});
        return c;
    }

    public final boolean b(c cVar) {
        int i = 1024;
        if (cVar == null) {
            v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String dR = cVar.dR(cVar.field_groupId, cVar.EB());
        int aQ = e.aQ(dR);
        if (aQ <= 1024) {
            i = aQ;
        }
        Object c = e.c(dR, 0, i);
        if (e.aQ(dR) > 0 && c != null && c.length >= 10) {
            Object obj = new byte[10];
            System.arraycopy(c, 0, obj, 0, 10);
            if (o.bf(obj)) {
                z = true;
            } else if ((cVar.field_reserved4 & c.nxh) == c.nxh) {
                byte[] bArr = null;
                if (!be.kS(aeW())) {
                    bArr = AesEcb.aesCryptEcb(c, aeW().getBytes(), false, false);
                }
                if (!be.bl(bArr) && o.bf(bArr)) {
                    z = true;
                }
            }
            v.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
            return z;
        }
        z = false;
        v.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
        return z;
    }
}
