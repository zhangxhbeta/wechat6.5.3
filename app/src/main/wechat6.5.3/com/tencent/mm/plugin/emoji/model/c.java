package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.emoji.d.f;
import com.tencent.mm.plugin.emoji.d.k;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.o;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    private com.tencent.mm.ae.a.c.c fcG = new com.tencent.mm.ae.a.c.c(this) {
        final /* synthetic */ c fcP;

        {
            this.fcP = r1;
        }

        public final void a(boolean z, Object... objArr) {
            boolean g;
            Throwable e;
            File file;
            String str;
            Object[] objArr2;
            String str2;
            Object[] objArr3;
            if (objArr == null || objArr.length < 4) {
                v.w("MicroMsg.emoji.EmojiService", "extra obj error");
                return;
            }
            ai aiVar;
            com.tencent.mm.storage.a.c cVar;
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            if (objArr[0] instanceof ai) {
                aiVar = (ai) objArr[0];
            } else {
                aiVar = null;
            }
            if (objArr[1] instanceof com.tencent.mm.storage.a.c) {
                cVar = (com.tencent.mm.storage.a.c) objArr[1];
            } else {
                cVar = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (aiVar == null || cVar == null) {
                v.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                return;
            }
            this.fcP.fcO.remove(aiVar.aZy);
            if (cVar.field_state == com.tencent.mm.storage.a.c.nxc) {
                v.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                cVar.field_state = com.tencent.mm.storage.a.c.nxa;
                com.tencent.mm.pluginsdk.j.a.bmr().d(cVar);
            }
            if (z) {
                String g2;
                String dR = cVar.dR(cVar.field_groupId, cVar.EB());
                if (booleanValue) {
                    String str3 = dR + "_encrypt";
                    if (com.tencent.mm.a.e.aQ(str3) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            g = com.tencent.mm.a.a.g(Base64.encodeToString(be.KG(aiVar.aeskey), 0), str3, dR);
                            if (g) {
                                try {
                                    com.tencent.mm.plugin.emoji.b.aT(7);
                                } catch (Exception e2) {
                                    e = e2;
                                    v.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{be.e(e)});
                                    com.tencent.mm.plugin.emoji.b.aT(8);
                                    v.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dR});
                                    if (g) {
                                        com.tencent.mm.loader.stub.b.deleteFile(str3);
                                        file = new File(dR);
                                        if (com.tencent.mm.a.e.aQ(dR) > 0) {
                                            g2 = g.g(file);
                                            if (!be.kS(g2)) {
                                            }
                                            dR = "MicroMsg.emoji.EmojiService";
                                            str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                                            objArr2 = new Object[3];
                                            objArr2[0] = g2;
                                            objArr2[1] = cVar == null ? "" : cVar.EB();
                                            objArr2[2] = cVar == null ? "" : cVar.field_cdnUrl;
                                            v.i(dR, str, objArr2);
                                            file.delete();
                                            c.afm();
                                            if (booleanValue) {
                                                com.tencent.mm.plugin.emoji.b.aT(5);
                                                com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                                return;
                                            }
                                            com.tencent.mm.plugin.emoji.b.aT(5);
                                            com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                            return;
                                        }
                                        str2 = "MicroMsg.emoji.EmojiService";
                                        dR = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                                        objArr3 = new Object[2];
                                        objArr3[0] = cVar == null ? "" : cVar.EB();
                                        if (cVar == null) {
                                            g2 = "";
                                        } else {
                                            g2 = cVar.field_cdnUrl;
                                        }
                                        objArr3[1] = g2;
                                        v.i(str2, dR, objArr3);
                                        com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 1, 1, aiVar.aZD, 1, aiVar.nvm);
                                        com.tencent.mm.plugin.emoji.b.aT(3);
                                        c.afm();
                                        return;
                                    }
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    dR = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    objArr3[0] = cVar != null ? cVar.EB() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str3));
                                    objArr3[2] = g.aX(str3) != null ? g.aX(str3) : "";
                                    objArr3[3] = cVar != null ? cVar.field_aeskey : "";
                                    objArr3[4] = cVar != null ? cVar.field_encrypturl : "";
                                    objArr3[5] = aiVar != null ? aiVar.nvk : "";
                                    v.i(str2, dR, objArr3);
                                    com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    c.afm();
                                    return;
                                }
                                v.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dR});
                                if (g) {
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    dR = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (cVar != null) {
                                    }
                                    objArr3[0] = cVar != null ? cVar.EB() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str3));
                                    if (g.aX(str3) != null) {
                                    }
                                    objArr3[2] = g.aX(str3) != null ? g.aX(str3) : "";
                                    if (cVar != null) {
                                    }
                                    objArr3[3] = cVar != null ? cVar.field_aeskey : "";
                                    if (cVar != null) {
                                    }
                                    objArr3[4] = cVar != null ? cVar.field_encrypturl : "";
                                    if (aiVar != null) {
                                    }
                                    objArr3[5] = aiVar != null ? aiVar.nvk : "";
                                    v.i(str2, dR, objArr3);
                                    com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    c.afm();
                                    return;
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str3);
                            } else {
                                com.tencent.mm.plugin.emoji.b.aT(8);
                                v.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dR});
                                if (g) {
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                } else {
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    dR = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (cVar != null) {
                                    }
                                    objArr3[0] = cVar != null ? cVar.EB() : "";
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str3));
                                    if (g.aX(str3) != null) {
                                    }
                                    objArr3[2] = g.aX(str3) != null ? g.aX(str3) : "";
                                    if (cVar != null) {
                                    }
                                    objArr3[3] = cVar != null ? cVar.field_aeskey : "";
                                    if (cVar != null) {
                                    }
                                    objArr3[4] = cVar != null ? cVar.field_encrypturl : "";
                                    if (aiVar != null) {
                                    }
                                    objArr3[5] = aiVar != null ? aiVar.nvk : "";
                                    v.i(str2, dR, objArr3);
                                    com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    c.afm();
                                    return;
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            g = false;
                            e = th;
                            v.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{be.e(e)});
                            com.tencent.mm.plugin.emoji.b.aT(8);
                            v.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dR});
                            if (g) {
                                str2 = "MicroMsg.emoji.EmojiService";
                                dR = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                objArr3 = new Object[6];
                                if (cVar != null) {
                                }
                                objArr3[0] = cVar != null ? cVar.EB() : "";
                                objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aQ(str3));
                                if (g.aX(str3) != null) {
                                }
                                objArr3[2] = g.aX(str3) != null ? g.aX(str3) : "";
                                if (cVar != null) {
                                }
                                objArr3[3] = cVar != null ? cVar.field_aeskey : "";
                                if (cVar != null) {
                                }
                                objArr3[4] = cVar != null ? cVar.field_encrypturl : "";
                                if (aiVar != null) {
                                }
                                objArr3[5] = aiVar != null ? aiVar.nvk : "";
                                v.i(str2, dR, objArr3);
                                com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                com.tencent.mm.loader.stub.b.deleteFile(str3);
                                c.afm();
                                return;
                            }
                            com.tencent.mm.loader.stub.b.deleteFile(str3);
                            file = new File(dR);
                            if (com.tencent.mm.a.e.aQ(dR) > 0) {
                                str2 = "MicroMsg.emoji.EmojiService";
                                dR = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                                objArr3 = new Object[2];
                                if (cVar == null) {
                                }
                                objArr3[0] = cVar == null ? "" : cVar.EB();
                                if (cVar == null) {
                                    g2 = cVar.field_cdnUrl;
                                } else {
                                    g2 = "";
                                }
                                objArr3[1] = g2;
                                v.i(str2, dR, objArr3);
                                com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 1, 1, aiVar.aZD, 1, aiVar.nvm);
                                com.tencent.mm.plugin.emoji.b.aT(3);
                                c.afm();
                                return;
                            }
                            g2 = g.g(file);
                            if (be.kS(g2)) {
                            }
                            dR = "MicroMsg.emoji.EmojiService";
                            str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                            objArr2 = new Object[3];
                            objArr2[0] = g2;
                            if (cVar == null) {
                            }
                            objArr2[1] = cVar == null ? "" : cVar.EB();
                            if (cVar == null) {
                            }
                            objArr2[2] = cVar == null ? "" : cVar.field_cdnUrl;
                            v.i(dR, str, objArr2);
                            file.delete();
                            c.afm();
                            if (booleanValue) {
                                com.tencent.mm.plugin.emoji.b.aT(5);
                                com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                                return;
                            }
                            com.tencent.mm.plugin.emoji.b.aT(5);
                            com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                            return;
                        }
                    }
                    v.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{cVar.EB()});
                    com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 1, 1, aiVar.aZD, 1, aiVar.nvm);
                    c.afm();
                    return;
                }
                file = new File(dR);
                if (com.tencent.mm.a.e.aQ(dR) > 0) {
                    g2 = g.g(file);
                    if (be.kS(g2) || !g2.equalsIgnoreCase(cVar.EB())) {
                        dR = "MicroMsg.emoji.EmojiService";
                        str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                        objArr2 = new Object[3];
                        objArr2[0] = g2;
                        if (cVar == null) {
                        }
                        objArr2[1] = cVar == null ? "" : cVar.EB();
                        if (cVar == null) {
                        }
                        objArr2[2] = cVar == null ? "" : cVar.field_cdnUrl;
                        v.i(dR, str, objArr2);
                        file.delete();
                        c.afm();
                        if (booleanValue) {
                            com.tencent.mm.plugin.emoji.b.aT(5);
                            com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                            return;
                        }
                        com.tencent.mm.plugin.emoji.b.aT(5);
                        com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 0, 1, aiVar.aZD, 1, aiVar.nvm);
                        return;
                    }
                    if (booleanValue) {
                        com.tencent.mm.plugin.emoji.b.aT(4);
                        com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 3, 0, 0, aiVar.aZD, 0, aiVar.nvm);
                    } else {
                        com.tencent.mm.plugin.emoji.b.aT(4);
                        com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 0, 0, aiVar.aZD, 1, aiVar.nvm);
                    }
                    f.aeV().c(cVar, true);
                    if (this.fcP.fcN != null) {
                        this.fcP.fcN.i(cVar);
                    }
                    c.afm();
                    return;
                }
                str2 = "MicroMsg.emoji.EmojiService";
                dR = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                objArr3 = new Object[2];
                if (cVar == null) {
                }
                objArr3[0] = cVar == null ? "" : cVar.EB();
                if (cVar == null) {
                    g2 = "";
                } else {
                    g2 = cVar.field_cdnUrl;
                }
                objArr3[1] = g2;
                v.i(str2, dR, objArr3);
                com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 1, 1, aiVar.aZD, 1, aiVar.nvm);
                com.tencent.mm.plugin.emoji.b.aT(3);
                c.afm();
                return;
            }
            v.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", new Object[]{cVar.EB()});
            com.tencent.mm.plugin.emoji.b.a(aiVar.aZy, 2, 1, 1, aiVar.aZD, 1, aiVar.nvm);
            com.tencent.mm.plugin.emoji.b.aT(3);
            c.afm();
        }
    };
    public HashMap<Long, String> fcJ = new HashMap();
    private boolean fcK = false;
    List<b> fcL = new LinkedList();
    private ou fcM;
    public a fcN;
    List fcO = Collections.synchronizedList(new ArrayList());

    public interface a {
        void i(com.tencent.mm.storage.a.c cVar);
    }

    private class b {
        com.tencent.mm.storage.a.c aYc;
        long bao;
        String bcB;
        String bde;
        final /* synthetic */ c fcP;

        public b(c cVar, long j, String str, com.tencent.mm.storage.a.c cVar2, String str2) {
            this.fcP = cVar;
            this.bao = j;
            this.bcB = str;
            this.aYc = cVar2;
            this.bde = str2;
        }
    }

    public c() {
        ak.vy().a(175, this);
    }

    public final void a(String str, com.tencent.mm.storage.a.c cVar, at atVar) {
        if (!be.kS(str) && cVar != null) {
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (cVar == null || be.kS(cVar.field_groupId)) {
                g.afy().afh();
            } else {
                boolean z2;
                k afy = g.afy();
                String str2 = cVar.field_groupId;
                if (be.kS(str2)) {
                    v.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
                    z2 = false;
                } else if (afy.fbL || com.tencent.mm.model.k.xO()) {
                    o oVar;
                    if (afy.fbP == null || !afy.fbP.containsKey(str2)) {
                        oVar = new o();
                        oVar.field_prodcutID = str2;
                    } else {
                        oVar = (o) afy.fbP.get(str2);
                    }
                    if (System.currentTimeMillis() - oVar.field_showTipsTime < afy.fbM) {
                        v.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                        afy.afh();
                        z2 = false;
                    } else {
                        String str3;
                        String str4;
                        Object[] objArr;
                        String str5;
                        Object[] objArr2;
                        int i;
                        String str6;
                        int i2;
                        Object[] objArr3;
                        if (oVar == null || System.currentTimeMillis() - oVar.field_setFlagTime <= 86400000) {
                            str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str4 = "no need to get reward today. continu count:%d total count:%d";
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(afy.fbO == null ? 0 : afy.fbO.field_continuCount);
                            objArr[1] = Integer.valueOf(afy.fbO == null ? 0 : afy.fbO.field_totalCount);
                            v.d(str3, str4, objArr);
                        } else if (afy.fbO != null && str2.equalsIgnoreCase(afy.fbO.field_prodcutID) && afy.fbO.field_continuCount >= afy.fbN - 1 && afy.fbO.field_continuCount <= (afy.fbN + 5) - 1) {
                            ak.vy().a(new n(str2, n.feq), 0);
                        } else if (oVar != null && oVar.field_totalCount >= afy.exY - 1 && oVar.field_totalCount <= (afy.exY + 5) - 1) {
                            ak.vy().a(new n(str2, n.feq), 0);
                        }
                        if (afy.fbO == null || !str2.equalsIgnoreCase(afy.fbO.field_prodcutID) || afy.fbO.field_continuCount < afy.fbN) {
                            if (oVar != null && oVar.field_totalCount >= afy.exY) {
                                if ((oVar.field_flag & n.fer) != n.fer || (oVar.field_flag & n.fes) == n.fes) {
                                    str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                                    objArr2 = new Object[4];
                                    objArr2[0] = Boolean.valueOf(false);
                                    objArr2[1] = str2;
                                    objArr2[2] = Integer.valueOf(afy.fbO == null ? 0 : afy.fbO.field_totalCount);
                                    i = 3;
                                    if (afy.fbO == null) {
                                        str6 = str5;
                                        objArr = objArr2;
                                        Object[] objArr4 = objArr2;
                                        i2 = 3;
                                        i = 0;
                                        str2 = str4;
                                        objArr3 = objArr4;
                                        objArr3[i2] = Integer.valueOf(i);
                                        v.i(str6, str2, objArr);
                                    } else {
                                        str2 = str5;
                                        str5 = str4;
                                        objArr3 = objArr2;
                                    }
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d";
                                    objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(true);
                                    objArr[1] = str2;
                                    objArr[2] = Integer.valueOf(afy.fbO == null ? 0 : afy.fbO.field_totalCount);
                                    v.i(str3, str4, objArr);
                                    afy.a(oVar, true);
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                                    objArr3 = new Object[2];
                                    objArr3[0] = Integer.valueOf(0);
                                    objArr3[1] = afy.fbO == null ? "" : afy.fbO.field_prodcutID;
                                    gVar.h(12953, objArr3);
                                    z2 = true;
                                }
                            }
                            afy.a(oVar, false);
                            z2 = false;
                        } else if ((afy.fbO.field_flag & n.fer) != n.fer || (afy.fbO.field_flag & n.fes) == n.fes) {
                            objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(false);
                            objArr2[1] = str2;
                            objArr2[2] = Integer.valueOf(afy.fbO.field_continuCount);
                            i = 3;
                            str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str5 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
                            objArr3 = objArr2;
                        } else {
                            v.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[]{Boolean.valueOf(true), str2, Integer.valueOf(afy.fbO.field_continuCount)});
                            afy.a(oVar, true);
                            com.tencent.mm.plugin.report.service.g.iuh.h(12953, new Object[]{Integer.valueOf(0), afy.fbO.field_prodcutID});
                            z2 = true;
                        }
                        str6 = str2;
                        str2 = str5;
                        objArr = objArr3;
                        objArr3 = objArr2;
                        i2 = i;
                        i = afy.fbO.field_flag;
                        objArr3[i2] = Integer.valueOf(i);
                        v.i(str6, str2, objArr);
                        afy.a(oVar, false);
                        z2 = false;
                    }
                } else {
                    v.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[]{Boolean.valueOf(afy.fbL), Boolean.valueOf(com.tencent.mm.model.k.xO())});
                    z2 = false;
                }
                v.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[]{Boolean.valueOf(z2)});
                z = z2;
            }
            if (atVar == null) {
                at atVar2 = new at();
                if (cVar.field_type == com.tencent.mm.storage.a.c.nwW || cVar.field_type == com.tencent.mm.storage.a.c.nwX) {
                    atVar2.setType(1048625);
                } else {
                    atVar2.setType(47);
                }
                atVar2.cH(str);
                atVar2.di(1);
                String xF = com.tencent.mm.model.k.xF();
                boolean z3 = (cVar.bnk() || cVar.bxH()) ? false : true;
                atVar2.setContent(ag.a(xF, currentTimeMillis, z3, cVar.EB(), z, ""));
                atVar2.cI(cVar.EB());
                atVar2.z(aw.fN(atVar2.field_talker));
                ak.yW();
                j = currentTimeMillis;
                currentTimeMillis = com.tencent.mm.model.c.wJ().R(atVar2);
            } else {
                long j2 = atVar.field_msgId;
                ag Mv = ag.Mv(atVar.field_content);
                if (Mv.time != 0) {
                    j = Mv.time;
                    currentTimeMillis = j2;
                } else {
                    return;
                }
            }
            v.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + currentTimeMillis);
            this.fcL.add(new b(this, currentTimeMillis, str, cVar, String.valueOf(j)));
            if (!this.fcK || this.fcL.size() == 1) {
                this.fcK = true;
                ak.vy().a(new q(String.valueOf(j), str, cVar, currentTimeMillis), 0);
            }
            String str7 = cVar.field_md5;
            rB(cVar.field_groupId);
        }
    }

    public final void rB(final String str) {
        ad.o(new Runnable(this) {
            final /* synthetic */ c fcP;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r12 = this;
                r0 = 1;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.g.afx();
                r2 = r2.fcj;
                r3 = r2;
                r4 = android.text.TextUtils.isEmpty(r3);
                if (r4 != 0) goto L_0x0070;
            L_0x0010:
                r4 = new java.lang.StringBuilder;
                r4.<init>();
                r5 = com.tencent.mm.storage.a.a.nwJ;
                r4 = r4.append(r5);
                r4 = r4.toString();
                r4 = r3.equals(r4);
                if (r4 != 0) goto L_0x0070;
            L_0x0025:
                r4 = r2.nxi;
                r5 = new java.lang.StringBuilder;
                r6 = "274544";
                r5.<init>(r6);
                r5 = r5.append(r3);
                r5 = r5.toString();
                r6 = 0;
                r4 = r4.getLong(r5, r6);
                r6 = java.lang.System.currentTimeMillis();
                r8 = r6 - r4;
                r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
                r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
                if (r8 < 0) goto L_0x0061;
            L_0x004a:
                if (r0 == 0) goto L_0x0060;
            L_0x004c:
                com.tencent.mm.plugin.emoji.model.g.aft();
                r0 = r2;
                r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
                if (r2 == 0) goto L_0x0072;
            L_0x0057:
                r0 = "MicroMsg.emoji.EmojiMgrImpl";
                r1 = "doSceneGetEmotionDesc get emotion desc faild.";
                com.tencent.mm.sdk.platformtools.v.w(r0, r1);
            L_0x0060:
                return;
            L_0x0061:
                r2 = r2.NE(r3);
                if (r2 != 0) goto L_0x0070;
            L_0x0067:
                r2 = r6 - r4;
                r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                if (r2 >= 0) goto L_0x004a;
            L_0x0070:
                r0 = r1;
                goto L_0x004a;
            L_0x0072:
                r2 = new com.tencent.mm.plugin.emoji.e.j;
                r2.<init>(r0);
                r0 = com.tencent.mm.model.ak.vy();
                r0.a(r2, r1);
                goto L_0x0060;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.c.1.run():void");
            }
        });
    }

    public final boolean h(com.tencent.mm.storage.a.c cVar) {
        ai aiVar;
        String str = null;
        if (cVar == null) {
            v.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            aiVar = null;
        } else {
            aiVar = new ai();
            aiVar.aZy = cVar.field_md5;
            aiVar.nvg = cVar.field_type;
            aiVar.nvh = cVar.field_size;
            aiVar.aZD = cVar.field_groupId;
            aiVar.nvm = cVar.field_designerID;
            aiVar.bea = cVar.field_thumbUrl;
            aiVar.nvn = cVar.field_encrypturl;
            aiVar.aeskey = cVar.field_aeskey;
            aiVar.width = cVar.field_width;
            aiVar.height = cVar.field_height;
            aiVar.nvl = cVar.field_cdnUrl;
        }
        if (aiVar == null) {
            v.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            aiVar.nvo = false;
            a(aiVar, null, true);
            if (cVar != null) {
                str = cVar.field_groupId;
            }
            rB(str);
        }
        return true;
    }

    public final void a(ai aiVar, com.tencent.mm.v.d.a aVar, boolean z) {
        com.tencent.mm.storage.a.c cVar;
        if (aiVar == null) {
            v.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
        }
        if (!(aVar == null || aVar.czu == null || aVar.czu.mcb != aiVar.bmL)) {
            aiVar.bNn = aw.c(aVar);
            aiVar.cQM = aVar.czu.mcc;
            aiVar.dhH = (long) aVar.czu.hNS;
        }
        com.tencent.mm.storage.a.c NF = g.afx().fch.NF(aiVar.aZy);
        if (NF != null) {
            Object obj = null;
            if (!(be.kS(aiVar.aZD) || aiVar.aZD.equals(NF.field_groupId))) {
                NF.field_groupId = aiVar.aZD;
                obj = 1;
            }
            if (!(be.kS(aiVar.nvm) || aiVar.nvm.equals(NF.field_designerID))) {
                NF.field_designerID = aiVar.nvm;
                obj = 1;
            }
            if (!(be.kS(aiVar.bea) || aiVar.bea.equals(NF.field_thumbUrl))) {
                NF.field_thumbUrl = aiVar.bea;
                obj = 1;
            }
            if (!(be.kS(aiVar.nvn) || aiVar.nvn.equals(NF.field_encrypturl))) {
                NF.field_encrypturl = aiVar.nvn;
                obj = 1;
            }
            if (!(be.kS(aiVar.aeskey) || aiVar.aeskey.equals(NF.field_aeskey))) {
                NF.field_aeskey = aiVar.aeskey;
                obj = 1;
            }
            if (!(be.kS(aiVar.nvl) || aiVar.nvl.equals(NF.field_cdnUrl))) {
                NF.field_cdnUrl = aiVar.nvl;
                obj = 1;
            }
            if (aiVar.width > 0 && aiVar.width != NF.field_width) {
                NF.field_width = aiVar.width;
                obj = 1;
            }
            if (aiVar.height > 0 && aiVar.height != NF.field_height) {
                NF.field_height = aiVar.height;
                obj = 1;
            }
            if (obj != null) {
                g.afx().fch.r(NF);
                v.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", new Object[]{NF.field_designerID, NF.field_thumbUrl});
            }
            cVar = NF;
        } else {
            v.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
            com.tencent.mm.storage.a.c cVar2 = new com.tencent.mm.storage.a.c();
            cVar2.field_md5 = aiVar.aZy;
            cVar2.field_svrid = aiVar.id;
            cVar2.field_catalog = com.tencent.mm.storage.a.c.nwM;
            cVar2.field_type = aiVar.nvg;
            cVar2.field_size = aiVar.nvh;
            cVar2.field_groupId = aiVar.aZD;
            cVar2.field_designerID = aiVar.nvm;
            cVar2.field_thumbUrl = aiVar.bea;
            cVar2.field_cdnUrl = aiVar.nvl;
            cVar2.field_temp = 1;
            cVar2.field_encrypturl = aiVar.nvn;
            cVar2.field_aeskey = aiVar.aeskey;
            cVar2.field_designerID = aiVar.nvm;
            cVar2.field_thumbUrl = aiVar.bea;
            cVar2.field_state = com.tencent.mm.storage.a.c.nxc;
            g.afx().fch.p(cVar2);
            cVar = cVar2;
        }
        long j = 0;
        if (aiVar.nvo) {
            cVar.bxE();
            if (aiVar.bmL != 0) {
                ak.yW();
                at S = com.tencent.mm.model.c.wJ().S(aiVar.bdo, aiVar.bmL);
                if (S.field_msgSvrId == aiVar.bmL) {
                    j = S.field_msgId;
                }
            }
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(aiVar.bdo);
            if (LX == null || ((int) LX.chr) == 0) {
                LX = new u(aiVar.bdo);
                LX.setType(2);
                ak.yW();
                com.tencent.mm.model.c.wH().N(LX);
            }
            at atVar = new at();
            atVar.setType(47);
            atVar.cH(aiVar.bdo);
            atVar.di(com.tencent.mm.model.k.eo(aiVar.dhC) ? 1 : 0);
            atVar.cI(cVar.EB());
            atVar.y(aiVar.bmL);
            String str = aiVar.dhC;
            boolean z2 = (cVar.bnk() || cVar.bxH()) ? false : true;
            atVar.setContent(ag.a(str, 0, z2, cVar.EB(), false, aiVar.nvk));
            atVar.z(aw.h(atVar.field_talker, aiVar.dhH));
            atVar.dh(3);
            if (!be.kS(aiVar.bNo)) {
                atVar.cN(aiVar.bNo);
            }
            if (aVar == null) {
                int i = aiVar.bNn;
                if (i != 0) {
                    atVar.dr(i);
                    if (atVar.field_msgId == 0 && atVar.field_isSend == 0 && (i & 2) != 0) {
                        atVar.z(aw.a(atVar.field_talker, aiVar.dhH, true, atVar.field_msgSeq));
                    }
                }
                if (aiVar.cQM != 0) {
                    atVar.B((long) aiVar.cQM);
                }
                v.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(aiVar.cQM)});
            } else {
                aw.a(atVar, aVar);
            }
            if (this.fcJ != null && this.fcJ.containsKey(Long.valueOf(atVar.field_msgSvrId))) {
                v.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
                atVar.setContent((String) this.fcJ.get(Long.valueOf(atVar.field_msgSvrId)));
                atVar.setType(10000);
                this.fcJ.remove(Long.valueOf(atVar.field_msgSvrId));
            }
            long e = aw.e(atVar);
            if (!com.tencent.mm.model.k.eo(aiVar.dhC)) {
                ak.yW();
                ((ac) ak.oH()).a(com.tencent.mm.model.c.wJ().ek(e));
            }
            j = e;
        }
        if (!cVar.bxE()) {
            if (!z) {
                v.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[]{Boolean.valueOf(z)});
                this.fcO.remove(aiVar.aZy);
                afm();
            } else if (this.fcO == null || !this.fcO.contains(aiVar.aZy)) {
                this.fcO.add(aiVar.aZy);
                String dR = cVar.dR(cVar.field_groupId, cVar.EB());
                if (!be.kS(aiVar.nvn) && !be.kS(aiVar.aeskey)) {
                    g.afq().a(aiVar.nvn, com.tencent.mm.plugin.emoji.d.g.f(dR + "_encrypt", aiVar, cVar, Boolean.valueOf(true), Long.valueOf(j)), this.fcG);
                    com.tencent.mm.plugin.emoji.b.aT(6);
                } else if (be.kS(aiVar.nvl)) {
                    this.fcO.remove(aiVar.aZy);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(aiVar.aZy);
                    ak.vy().a(new com.tencent.mm.plugin.emoji.e.e(linkedList), 0);
                    v.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", new Object[]{aiVar.aZy});
                    com.tencent.mm.plugin.emoji.b.aT(9);
                } else {
                    g.afq().a(aiVar.nvl, com.tencent.mm.plugin.emoji.d.g.c(dR, aiVar, cVar, Boolean.valueOf(false), Long.valueOf(j)), this.fcG);
                    com.tencent.mm.plugin.emoji.b.aT(1);
                }
            } else {
                v.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", new Object[]{aiVar.aZy});
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        int i3 = 2;
        v.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof q)) {
            return;
        }
        if (this.fcL.size() <= 0) {
            this.fcK = false;
            return;
        }
        b bVar;
        b bVar2 = (b) this.fcL.remove(0);
        if (!(i == 0 && i2 == 0)) {
            i3 = 5;
        }
        ak.yW();
        at ek = com.tencent.mm.model.c.wJ().ek(bVar2.bao);
        ek.dh(i3);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(bVar2.bao, ek);
        if (this.fcL.size() > 0) {
            bVar = (b) this.fcL.get(0);
            ak.vy().a(new q(bVar.bde, bVar.bcB, bVar.aYc, bVar.bao), 0);
        } else {
            this.fcK = false;
            bVar = bVar2;
        }
        if (this.fcM == null) {
            this.fcM = new ou();
        }
        this.fcM.bqe.aZD = bVar.aYc.field_groupId;
        com.tencent.mm.sdk.c.a.nhr.z(this.fcM);
    }

    static void afm() {
        ak.yW();
        com.tencent.mm.model.c.wJ().Ls();
    }
}
