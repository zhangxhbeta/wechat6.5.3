package com.tencent.mm.plugin.emoji.g.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mm.ae.a.d.b;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.o;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.g.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends e {
    private String fdK;
    private String feg;
    private f ffi;
    private String ffj;
    private String ffk;
    private String ffl;
    private String ffm;
    private String ffn;
    private c ffo;
    private com.tencent.mm.plugin.emoji.c.a ffp;
    private com.tencent.mm.ae.a.b.a ffq;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (be.kS(str)) {
            v.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.ffj = str;
        this.ffk = str2;
        this.ffl = str3;
        this.feg = str4;
        this.ffm = str5;
        this.ffn = str6;
        this.fdK = str7;
        this.ffo = g.afx().fch.NF(this.ffj);
        if (this.ffo == null) {
            this.ffo = new c();
            this.ffo.field_md5 = this.ffj;
            this.ffo.field_cdnUrl = this.ffk;
            this.ffo.field_thumbUrl = this.ffl;
            this.ffo.field_designerID = this.feg;
            this.ffo.field_encrypturl = this.ffm;
            this.ffo.field_aeskey = this.ffn;
            this.ffo.field_groupId = this.fdK;
        }
        if (be.kS(this.ffk)) {
            this.ffk = this.ffo.field_cdnUrl;
        } else {
            this.ffo.field_cdnUrl = this.ffk;
        }
        if (be.kS(this.ffm)) {
            this.ffm = this.ffo.field_encrypturl;
            this.ffn = this.ffo.field_aeskey;
        } else {
            this.ffo.field_encrypturl = this.ffm;
            this.ffo.field_aeskey = this.ffn;
        }
        if (!be.kS(this.feg)) {
            this.ffo.field_designerID = this.feg;
        }
        if (!be.kS(this.fdK)) {
            this.ffo.field_groupId = this.fdK;
        }
        if (!be.kS(this.ffl)) {
            this.ffo.field_thumbUrl = this.ffl;
        }
        this.ffp = new com.tencent.mm.plugin.emoji.c.a();
        this.ffq = new com.tencent.mm.ae.a.b.a();
    }

    public final void run() {
        String str;
        if (this.ffi != null) {
            this.ffi.rG(this.ffj);
        } else {
            v.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        v.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[]{this.ffo.EB(), this.ffo.field_cdnUrl, this.ffo.field_thumbUrl, this.ffo.field_designerID, this.ffo.field_encrypturl, this.ffo.field_groupId});
        if (be.kS(this.ffk) && be.kS(this.ffm)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ffj);
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.e(linkedList), 0);
            aga();
        } else {
            boolean z;
            String str2 = this.ffk;
            if (be.kS(this.ffm) || be.kS(this.ffn)) {
                str = str2;
                z = false;
            } else {
                str = this.ffm;
                z = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b ji = this.ffp.ji(str);
            if (ji == null || be.bl(ji.data)) {
                v.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                aga();
            } else {
                v.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                byte[] bArr = ji.data;
                if (z) {
                    try {
                        byte[] bArr2 = ji.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(be.KG(this.ffn), 0).getBytes(), 0);
                        Key secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Throwable e) {
                        v.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[]{be.e(e)});
                    }
                }
                Bitmap decodeByteArray = d.decodeByteArray(bArr, 10, 10);
                boolean a = this.ffq.a(str, bArr, com.tencent.mm.plugin.emoji.d.g.c(this.ffo.dR(this.fdK, this.ffj), new Object[0]));
                File file = new File(this.ffo.dR(this.ffo.field_groupId, this.ffo.EB()));
                if (decodeByteArray != null && a && file.exists()) {
                    str = com.tencent.mm.a.g.g(file);
                    if (be.kS(str) || !str.equalsIgnoreCase(this.ffo.EB())) {
                        if (file.exists()) {
                            file.delete();
                        }
                        aga();
                        if (z) {
                            com.tencent.mm.plugin.emoji.b.aT(8);
                            com.tencent.mm.plugin.emoji.b.a(this.ffj, 3, 0, 1, this.fdK, 1, this.feg);
                        } else {
                            com.tencent.mm.plugin.emoji.b.aT(5);
                            com.tencent.mm.plugin.emoji.b.a(this.ffj, 2, 0, 1, this.fdK, 1, this.feg);
                        }
                    } else {
                        this.ffo.field_size = bArr.length;
                        this.ffo.field_state = c.nxa;
                        this.ffo.field_temp = 0;
                        this.ffo.field_catalog = c.nwR;
                        this.ffo.field_type = EmojiLogic.ae(bArr);
                        int bxS = g.afx().fch.bxS();
                        this.ffo.field_idx = bxS < o.afk() ? o.afk() : bxS + 1;
                        g.afx().fch.r(this.ffo);
                        com.tencent.mm.storage.a.b bVar = g.afx().fci;
                        if (!com.tencent.mm.storage.a.b.bxt()) {
                            g.afx().fci.bxu();
                        }
                        bz bzVar = new bz();
                        bzVar.aZx.aZy = this.ffj;
                        bzVar.aZx.aYt = 0;
                        bzVar.aZx.aZz = true;
                        com.tencent.mm.sdk.c.a.nhr.z(bzVar);
                        if (z) {
                            com.tencent.mm.plugin.emoji.b.aT(7);
                            com.tencent.mm.plugin.emoji.b.aT(4);
                            com.tencent.mm.plugin.emoji.b.a(this.ffj, 3, 0, 0, this.fdK, 0, this.feg);
                        } else {
                            com.tencent.mm.plugin.emoji.b.aT(2);
                            com.tencent.mm.plugin.emoji.b.aT(4);
                            com.tencent.mm.plugin.emoji.b.a(this.ffj, 2, 0, 0, this.fdK, 1, this.feg);
                        }
                        com.tencent.mm.plugin.emoji.d.f.aeV().c(this.ffo, true);
                    }
                } else {
                    aga();
                    if (z) {
                        com.tencent.mm.plugin.emoji.b.aT(8);
                        com.tencent.mm.plugin.emoji.b.a(this.ffj, 3, 0, 1, this.fdK, 1, this.feg);
                    } else {
                        com.tencent.mm.plugin.emoji.b.aT(3);
                        com.tencent.mm.plugin.emoji.b.a(this.ffj, 2, 1, 1, this.fdK, 1, this.feg);
                    }
                }
            }
        }
        if (!be.kS(this.ffo.field_thumbUrl)) {
            b ji2 = this.ffp.ji(this.ffo.field_thumbUrl);
            if (ji2 != null) {
                com.tencent.mm.ae.a.b.a aVar = this.ffq;
                str = this.ffo.field_thumbUrl;
                byte[] bArr3 = ji2.data;
                String str3 = this.ffo.field_thumbUrl;
                aVar.a(str, bArr3, com.tencent.mm.plugin.emoji.d.g.c(this.ffo.dR(this.fdK, this.ffj) + "_cover", new Object[0]));
            }
        }
    }

    private void aga() {
        v.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        bz bzVar = new bz();
        bzVar.aZx.aZy = this.ffj;
        bzVar.aZx.aYt = 0;
        bzVar.aZx.aZz = false;
        com.tencent.mm.sdk.c.a.nhr.z(bzVar);
        if (this.ffo != null) {
            v.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[]{this.ffo.EB()});
            this.ffo.field_state = c.nxb;
            this.ffo.field_catalog = c.nwM;
            g.afx().fch.r(this.ffo);
        }
    }

    public final String getKey() {
        return this.ffj;
    }

    public final void a(f fVar) {
        this.ffi = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(be.kS(this.ffj) || be.kS(aVar.ffj) || !this.ffj.equals(aVar.ffj))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
