package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.c.c;
import com.tencent.mm.e.a.q;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;

public final class b implements e {
    private c fcG = new c(this) {
        final /* synthetic */ b fcH;

        {
            this.fcH = r1;
        }

        public final void a(boolean z, Object... objArr) {
            boolean g;
            Throwable e;
            int aQ;
            if (objArr == null || objArr.length < 2) {
                v.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
                return;
            }
            nu nuVar;
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (objArr[0] instanceof nu) {
                nuVar = (nu) objArr[0];
            } else {
                nuVar = null;
            }
            if (nuVar == null) {
                v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
            } else if (z) {
                File file;
                byte[] c;
                ak.yW();
                String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", nuVar.mpC);
                String str = A + "_encrypt";
                if (booleanValue) {
                    if (com.tencent.mm.a.e.aQ(str) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String str2;
                        String str3;
                        Object[] objArr2;
                        try {
                            g = a.g(Base64.encodeToString(be.KG(nuVar.mpF), 0), str, A);
                            if (g) {
                                try {
                                    com.tencent.mm.plugin.emoji.b.aT(7);
                                } catch (Exception e2) {
                                    e = e2;
                                    v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{be.e(e)});
                                    com.tencent.mm.plugin.emoji.b.aT(8);
                                    v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    if (g) {
                                        str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                        str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                        objArr2 = new Object[5];
                                        objArr2[0] = nuVar.mpC;
                                        objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str));
                                        objArr2[2] = g.aX(str) != null ? "" : g.aX(str);
                                        objArr2[3] = nuVar.mpF;
                                        objArr2[4] = nuVar.mpE;
                                        v.i(str2, str3, objArr2);
                                        com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 1, "", 1, "");
                                        com.tencent.mm.loader.stub.b.deleteFile(str);
                                        r2 = this.fcH;
                                        b.aq(nuVar.mpC, 2);
                                        return;
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    file = new File(A);
                                    aQ = com.tencent.mm.a.e.aQ(A);
                                    c = com.tencent.mm.a.e.c(A, 0, 10);
                                    if (aQ > 0) {
                                    }
                                    v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s", new Object[]{nuVar.mpC, nuVar.glb});
                                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 1, 1, "", 1, "");
                                    com.tencent.mm.plugin.emoji.b.aT(3);
                                    r2 = this.fcH;
                                    b.aq(nuVar.mpC, 2);
                                    return;
                                }
                                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (g) {
                                    str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = nuVar.mpC;
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str));
                                    if (g.aX(str) != null) {
                                    }
                                    objArr2[2] = g.aX(str) != null ? "" : g.aX(str);
                                    objArr2[3] = nuVar.mpF;
                                    objArr2[4] = nuVar.mpE;
                                    v.i(str2, str3, objArr2);
                                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 1, "", 1, "");
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    r2 = this.fcH;
                                    b.aq(nuVar.mpC, 2);
                                    return;
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str);
                            } else {
                                com.tencent.mm.plugin.emoji.b.aT(8);
                                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (g) {
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                } else {
                                    str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = nuVar.mpC;
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str));
                                    if (g.aX(str) != null) {
                                    }
                                    objArr2[2] = g.aX(str) != null ? "" : g.aX(str);
                                    objArr2[3] = nuVar.mpF;
                                    objArr2[4] = nuVar.mpE;
                                    v.i(str2, str3, objArr2);
                                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 1, "", 1, "");
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    r2 = this.fcH;
                                    b.aq(nuVar.mpC, 2);
                                    return;
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            g = false;
                            e = th;
                            v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{be.e(e)});
                            com.tencent.mm.plugin.emoji.b.aT(8);
                            v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (g) {
                                com.tencent.mm.loader.stub.b.deleteFile(str);
                                file = new File(A);
                                aQ = com.tencent.mm.a.e.aQ(A);
                                c = com.tencent.mm.a.e.c(A, 0, 10);
                                if (aQ > 0) {
                                }
                                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s", new Object[]{nuVar.mpC, nuVar.glb});
                                com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 1, 1, "", 1, "");
                                com.tencent.mm.plugin.emoji.b.aT(3);
                                r2 = this.fcH;
                                b.aq(nuVar.mpC, 2);
                                return;
                            }
                            str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                            str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                            objArr2 = new Object[5];
                            objArr2[0] = nuVar.mpC;
                            objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str));
                            if (g.aX(str) != null) {
                            }
                            objArr2[2] = g.aX(str) != null ? "" : g.aX(str);
                            objArr2[3] = nuVar.mpF;
                            objArr2[4] = nuVar.mpE;
                            v.i(str2, str3, objArr2);
                            com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 1, "", 1, "");
                            com.tencent.mm.loader.stub.b.deleteFile(str);
                            r2 = this.fcH;
                            b.aq(nuVar.mpC, 2);
                            return;
                        }
                    }
                    v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{nuVar.mpC});
                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 1, 1, "", 1, "");
                    r2 = this.fcH;
                    b.aq(nuVar.mpC, 2);
                    return;
                }
                file = new File(A);
                aQ = com.tencent.mm.a.e.aQ(A);
                c = com.tencent.mm.a.e.c(A, 0, 10);
                if (aQ > 0 || c == null) {
                    v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s", new Object[]{nuVar.mpC, nuVar.glb});
                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 1, 1, "", 1, "");
                    com.tencent.mm.plugin.emoji.b.aT(3);
                    r2 = this.fcH;
                    b.aq(nuVar.mpC, 2);
                    return;
                }
                String g2 = g.g(file);
                if (be.kS(g2) || !g2.equalsIgnoreCase(nuVar.mpC)) {
                    v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[]{g2, nuVar.mpC, nuVar.glb});
                    file.delete();
                    r2 = this.fcH;
                    b.aq(nuVar.mpC, 2);
                    if (booleanValue) {
                        com.tencent.mm.plugin.emoji.b.aT(5);
                        com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 1, "", 1, "");
                        return;
                    }
                    com.tencent.mm.plugin.emoji.b.aT(5);
                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 0, 1, "", 1, "");
                    return;
                }
                if (booleanValue) {
                    com.tencent.mm.plugin.emoji.b.aT(4);
                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 3, 0, 0, "", 0, "");
                } else {
                    com.tencent.mm.plugin.emoji.b.aT(4);
                    com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 0, 0, "", 1, "");
                }
                int i = com.tencent.mm.storage.a.c.nwX;
                if (o.be(c)) {
                    i = com.tencent.mm.storage.a.c.nwW;
                } else {
                    i = com.tencent.mm.storage.a.c.nwX;
                }
                com.tencent.mm.storage.a.c NF = g.afx().fch.NF(g2);
                if (NF == null) {
                    NF = new com.tencent.mm.storage.a.c();
                    NF.field_md5 = g2;
                    NF.field_catalog = com.tencent.mm.storage.a.c.nwM;
                    NF.field_size = com.tencent.mm.a.e.aQ(A);
                }
                NF.field_type = i;
                NF.field_state = com.tencent.mm.storage.a.c.nxa;
                g.afx().fch.r(NF);
                b.aq(nuVar.mpC, 1);
                EmojiLogic.a(aa.getContext(), null, NF.EB(), NF.iay, NF);
            } else {
                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", new Object[]{nuVar.mpC});
                com.tencent.mm.plugin.emoji.b.a(nuVar.mpC, 2, 1, 1, "", 1, "");
                com.tencent.mm.plugin.emoji.b.aT(3);
                r2 = this.fcH;
                b.aq(nuVar.mpC, 2);
            }
        }
    };

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 221:
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.e.e eVar = (com.tencent.mm.plugin.emoji.e.e) kVar;
                if (eVar.fdR == com.tencent.mm.plugin.emoji.e.e.fdP) {
                    ex exVar = eVar.cif == null ? null : (ex) eVar.cif.czk.czs;
                    if (!(exVar == null || exVar.mfL == null || exVar.mfL.size() <= 0)) {
                        str2 = (String) exVar.mfL.get(0);
                    }
                    if (i == 0 && i2 == 0) {
                        ey eyVar = eVar.cif == null ? null : (ey) eVar.cif.czl.czs;
                        if (eyVar == null || eyVar.mfM == null || eyVar.mfM.size() <= 0) {
                            aq(str2, 2);
                            v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            return;
                        }
                        nu nuVar = (nu) eyVar.mfM.get(0);
                        ak.yW();
                        String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), "", nuVar.mpC);
                        com.tencent.mm.ae.a.a afq;
                        String str3;
                        String str4;
                        if (!be.kS(nuVar.mpE) && !be.kS(nuVar.mpF)) {
                            afq = g.afq();
                            str3 = nuVar.mpE;
                            str4 = nuVar.mpE;
                            afq.a(str3, com.tencent.mm.plugin.emoji.d.g.f(A + "_encrypt", nuVar, Boolean.valueOf(true)), this.fcG);
                            com.tencent.mm.plugin.emoji.b.aT(6);
                            return;
                        } else if (be.kS(nuVar.glb)) {
                            v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            aq(str2, 2);
                            return;
                        } else {
                            afq = g.afq();
                            str3 = nuVar.glb;
                            str4 = nuVar.glb;
                            afq.a(str3, com.tencent.mm.plugin.emoji.d.g.c(A, nuVar, Boolean.valueOf(false)), this.fcG);
                            com.tencent.mm.plugin.emoji.b.aT(1);
                            return;
                        }
                    }
                    aq(str2, 2);
                    return;
                }
                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                return;
            default:
                v.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                return;
        }
    }

    public static void aq(String str, int i) {
        q qVar = new q();
        qVar.aWZ.aXa = str;
        qVar.aWZ.status = i;
        qVar.aWZ.aXb = 0;
        com.tencent.mm.sdk.c.a.nhr.z(qVar);
        v.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
    }
}
