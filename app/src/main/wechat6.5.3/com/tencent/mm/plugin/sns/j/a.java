package com.tencent.mm.plugin.sns.j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.an;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(bp bpVar, k kVar) {
        if (kVar == null) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            bpVar.aZd.aZk = 2131232653;
            return false;
        }
        qf qfVar = new qf();
        qg qgVar = new qg();
        azr aUp = kVar.aUp();
        aib com_tencent_mm_protocal_c_aib = (aib) aUp.mWq.mom.get(0);
        if (kVar.qC(32) && aUp.mWq.mol == 15) {
            aUp.mWv.cqm = kVar.aUo().jpt;
            aUp.mWv.cqn = aUp.gID;
        }
        String cE = i.cE(kVar.field_snsId);
        cE = String.format("%s#%s", new Object[]{cE, com_tencent_mm_protocal_c_aib.gID});
        qgVar.Jn(kVar.field_userName);
        qgVar.Jo(com.tencent.mm.model.k.xF());
        qgVar.uN(2);
        qgVar.dV(be.Ni());
        qgVar.Js(kVar.aUq());
        qgVar.Jp(cE);
        qfVar.a(qgVar);
        pw pwVar = new pw();
        pwVar.IO(cE);
        String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
        String i = i.i(com_tencent_mm_protocal_c_aib);
        String c = i.c(com_tencent_mm_protocal_c_aib);
        if (be.kS(an.a(kVar.aUL(), com_tencent_mm_protocal_c_aib))) {
            v.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            bpVar.aZd.aZk = 2131232666;
            return false;
        } else if (FileOp.aR(cA + i)) {
            int i2;
            int i3;
            if (!FileOp.aR(cA + c)) {
                int i4 = 320;
                i2 = 240;
                if (com_tencent_mm_protocal_c_aib.mHS != null && com_tencent_mm_protocal_c_aib.mHS.lHK > 0.0f && com_tencent_mm_protocal_c_aib.mHS.mID > 0.0f) {
                    i4 = (int) com_tencent_mm_protocal_c_aib.mHS.mID;
                    i2 = (int) com_tencent_mm_protocal_c_aib.mHS.lHK;
                }
                Bitmap F = d.F(cA + i, i4, i2);
                if (F == null) {
                    v.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + FileOp.aR(cA + c));
                    bpVar.aZd.aZk = 2131232666;
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(F, 60, CompressFormat.JPEG, cA + c, true);
                } catch (Throwable e) {
                    v.a("MicroMsg.Sns.GetFavDataSource", e, "save bmp error %s", new Object[]{e.getMessage()});
                    v.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + FileOp.aR(cA + c));
                    bpVar.aZd.aZk = 2131232666;
                    return false;
                }
            }
            pwVar.IK(cA + i);
            pwVar.IL(cA + c);
            pwVar.Iw(be.kS(com_tencent_mm_protocal_c_aib.mIa) ? aUp.mWn : com_tencent_mm_protocal_c_aib.mIa);
            pwVar.IV(aUp.jYp);
            if (!be.kS(aUp.jYp)) {
                Map q = bf.q(aUp.jYp, "adxml");
                if (q.size() > 0) {
                    pwVar.Iw(be.ah((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    pwVar.Ix(be.ah((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            if (kVar.qC(32)) {
                b aUm = kVar.aUm();
                pz pzVar = new pz();
                pzVar.cqi = be.kS(com_tencent_mm_protocal_c_aib.mIa) ? aUp.mWn : com_tencent_mm_protocal_c_aib.mIa;
                pzVar.mtD = com_tencent_mm_protocal_c_aib.jZD;
                pzVar.cqg = com_tencent_mm_protocal_c_aib.mHW;
                pzVar.cqm = aUp.mWv.cqm;
                pzVar.cqn = aUp.mWv.cqn;
                if (be.kS(pzVar.cqn)) {
                    pzVar.cqn = aUp.gID;
                }
                pzVar.cql = be.kS(com_tencent_mm_protocal_c_aib.mHZ) ? com_tencent_mm_protocal_c_aib.mHP : com_tencent_mm_protocal_c_aib.mHZ;
                if (aUm != null && aUm.juw == 0) {
                    pzVar.cqk = aUm.juy;
                    pzVar.cqj = aUm.jux;
                }
                pwVar.a(pzVar);
                i2 = 15;
                i3 = 16;
            } else {
                i3 = 4;
                i2 = 4;
            }
            pwVar.uG(i2);
            com.tencent.mm.plugin.sight.base.a zD = d.zD(pwVar.msq);
            if (zD != null) {
                pwVar.uF(zD.aOM());
            } else {
                pwVar.uF(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(pwVar);
            qfVar.ah(linkedList);
            bpVar.aZd.aZf = qfVar;
            bpVar.aZd.type = i3;
            a(pwVar, kVar);
            v.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            return true;
        } else {
            v.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + FileOp.aR(cA + i) + " thumb:" + FileOp.aR(cA + c));
            bpVar.aZd.aZk = 2131232666;
            return false;
        }
    }

    public static boolean a(bp bpVar, k kVar, aib com_tencent_mm_protocal_c_aib) {
        if (bpVar == null || com_tencent_mm_protocal_c_aib == null || kVar == null || kVar.jBI == 0) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
            if (bpVar == null) {
                return false;
            }
            bpVar.aZd.aZk = 2131232653;
            return false;
        } else if (ad.aSn()) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            bpVar.aZd.aZk = 2131232667;
            return false;
        } else {
            String format = String.format("%s#%s", new Object[]{i.cE(kVar.field_snsId), com_tencent_mm_protocal_c_aib.gID});
            qf qfVar = new qf();
            qg qgVar = new qg();
            v.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[]{kVar.field_userName});
            qgVar.Jn(kVar.field_userName);
            qgVar.Jo(com.tencent.mm.model.k.xF());
            qgVar.uN(2);
            qgVar.dV(((long) kVar.field_createTime) * 1000);
            qgVar.Js(kVar.aUq());
            qgVar.Jp(format);
            pw pwVar = new pw();
            pwVar.IO(format);
            pwVar.ID(com_tencent_mm_protocal_c_aib.glb);
            pwVar.IE(com_tencent_mm_protocal_c_aib.mHT);
            pwVar.IC(kVar.aUp().mWq.glb);
            format = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib);
            if (FileOp.aR(format)) {
                pwVar.IL(format);
            } else {
                pwVar.ip(true);
                pwVar.IF(com_tencent_mm_protocal_c_aib.mHP);
                qp qpVar = new qp();
                qpVar.JD(com_tencent_mm_protocal_c_aib.mHP);
                qfVar.b(qpVar);
            }
            pwVar.uG(7);
            pwVar.Iw(com_tencent_mm_protocal_c_aib.aXz);
            pwVar.Ix(com_tencent_mm_protocal_c_aib.gkC);
            pwVar.io(true);
            qfVar.mtR.add(pwVar);
            qfVar.a(qgVar);
            bpVar.aZd.aZf = qfVar;
            bpVar.aZd.type = 7;
            a(pwVar, kVar);
            return true;
        }
    }

    public static boolean a(bp bpVar, String str, String str2) {
        if (bpVar == null || !s.BM(str2) || str == null) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (bpVar != null) {
                bpVar.aZd.aZk = 2131232653;
            }
            return false;
        } else if (ad.aSn()) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            bpVar.aZd.aZk = 2131232667;
            return false;
        } else {
            k Bq = f.Bq(str2);
            if (Bq == null) {
                v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                bpVar.aZd.aZk = 2131232654;
                return false;
            }
            qp qpVar;
            String str3 = "0";
            aib a = ah.a(Bq, 0);
            if (a != null) {
                str3 = a.gID;
            }
            String cE = i.cE(Bq.field_snsId);
            str3 = String.format("%s#%s", new Object[]{cE, str3});
            qf qfVar = new qf();
            qg qgVar = new qg();
            v.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[]{Bq.field_userName});
            qgVar.Jn(Bq.field_userName);
            qgVar.Jo(com.tencent.mm.model.k.xF());
            qgVar.uN(2);
            qgVar.dV(((long) Bq.field_createTime) * 1000);
            qgVar.Js(Bq.aUq());
            qgVar.Jp(str3);
            qgVar.Ju(str);
            pw pwVar = new pw();
            pwVar.IO(str3);
            if (a != null) {
                str3 = al.cA(ad.xh(), a.gID) + i.c(a);
                if (FileOp.aR(str3)) {
                    pwVar.IL(str3);
                } else {
                    pwVar.ip(true);
                    pwVar.IF(a.mHP);
                    qpVar = new qp();
                    qpVar.JD(a.mHP);
                    qfVar.b(qpVar);
                }
            } else {
                pwVar.ip(true);
            }
            pwVar.uG(5);
            azr aUp = Bq.aUp();
            pwVar.Iw(aUp.mWq.aXz);
            pwVar.Ix(aUp.mWq.gkC);
            pwVar.IV(aUp.jYp);
            if (!be.kS(aUp.jYp)) {
                Map q = bf.q(aUp.jYp, "adxml");
                if (q.size() > 0) {
                    pwVar.Iw(be.ah((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    pwVar.Ix(be.ah((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            a(pwVar, aUp);
            pwVar.io(true);
            qfVar.mtR.add(pwVar);
            qpVar = new qp();
            qpVar.uP(aUp.cog);
            qfVar.b(qpVar);
            qfVar.a(qgVar);
            bpVar.aZd.aZf = qfVar;
            bpVar.aZd.desc = aUp.mWq.aXz;
            bpVar.aZd.type = 5;
            return true;
        }
    }

    public static boolean a(bp bpVar, String str, CharSequence charSequence) {
        if (s.BN(str) || charSequence == null) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            bpVar.aZd.aZk = 2131232653;
            return false;
        } else if (ad.aSn()) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            bpVar.aZd.aZk = 2131232667;
            return false;
        } else {
            k Bq = ad.aSE().Bq(str);
            if (Bq == null) {
                v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                bpVar.aZd.aZk = 2131232654;
                return false;
            } else if (0 == Bq.field_snsId) {
                v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                bpVar.aZd.aZk = 2131232652;
                return false;
            } else {
                String cE = i.cE(Bq.field_snsId);
                cE = String.format("%s#0", new Object[]{cE});
                qf qfVar = new qf();
                qg qgVar = new qg();
                v.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[]{Bq.field_userName});
                qgVar.Jn(Bq.field_userName);
                qgVar.Jo(com.tencent.mm.model.k.xF());
                qgVar.uN(2);
                qgVar.dV(((long) Bq.field_createTime) * 1000);
                qgVar.Js(Bq.aUq());
                qgVar.Jp(cE);
                qfVar.a(qgVar);
                bpVar.aZd.aZf = qfVar;
                bpVar.aZd.desc = charSequence.toString();
                bpVar.aZd.type = 1;
                return true;
            }
        }
    }

    public static boolean a(bp bpVar, k kVar, String str) {
        if (bpVar == null || be.kS(str)) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            if (bpVar != null) {
                bpVar.aZd.aZk = 2131232653;
            }
            return false;
        } else if (kVar == null) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            bpVar.aZd.aZk = 2131232654;
            return false;
        } else {
            aib com_tencent_mm_protocal_c_aib;
            azr aUp = kVar.aUp();
            if (aUp.mWq == null || aUp.mWq.mom.size() == 0) {
                com_tencent_mm_protocal_c_aib = null;
            } else {
                Iterator it = aUp.mWq.mom.iterator();
                while (it.hasNext()) {
                    aib com_tencent_mm_protocal_c_aib2 = (aib) it.next();
                    if (com_tencent_mm_protocal_c_aib2.gID.equals(str)) {
                        com_tencent_mm_protocal_c_aib = com_tencent_mm_protocal_c_aib2;
                        break;
                    }
                }
                com_tencent_mm_protocal_c_aib = null;
            }
            if (com_tencent_mm_protocal_c_aib == null) {
                v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                bpVar.aZd.aZk = 2131232654;
                return false;
            }
            String cE = i.cE(kVar.field_snsId);
            cE = String.format("%s#%s", new Object[]{cE, str});
            qf qfVar = new qf();
            qg qgVar = new qg();
            pw pwVar = new pw();
            v.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[]{kVar.field_userName});
            qgVar.Jn(kVar.field_userName);
            qgVar.Jo(com.tencent.mm.model.k.xF());
            qgVar.uN(2);
            qgVar.dV(((long) kVar.field_createTime) * 1000);
            qgVar.Js(kVar.aUq());
            qgVar.Jp(cE);
            pwVar.IO(cE);
            pwVar.IK(al.cA(ad.xh(), str) + i.k(com_tencent_mm_protocal_c_aib));
            if (kVar.aUp() != null) {
                pwVar.IV(kVar.aUp().jYp);
                if (!be.kS(kVar.aUp().jYp)) {
                    Map q = bf.q(kVar.aUp().jYp, "adxml");
                    if (q.size() > 0) {
                        pwVar.Iw(be.ah((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        pwVar.Ix(be.ah((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(pwVar, kVar);
            cE = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib);
            if (FileOp.aR(pwVar.msq) || !kVar.field_userName.endsWith(ad.aSk())) {
                if (FileOp.aR(cE)) {
                    pwVar.IL(cE);
                } else {
                    pwVar.ip(true);
                    pwVar.IF(com_tencent_mm_protocal_c_aib.mHP);
                    qp qpVar = new qp();
                    qpVar.JD(com_tencent_mm_protocal_c_aib.mHP);
                    qfVar.b(qpVar);
                }
                pwVar.uG(2);
                qfVar.mtR.add(pwVar);
                qfVar.a(qgVar);
                bpVar.aZd.aZf = qfVar;
                bpVar.aZd.type = 2;
                return true;
            }
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            bpVar.aZd.aZk = 2131232654;
            return false;
        }
    }

    public static boolean b(bp bpVar, String str, String str2) {
        if (str2 == null || be.kS(str)) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
            bpVar.aZd.aZk = 2131232653;
            return false;
        } else if (ad.aSn()) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            bpVar.aZd.aZk = 2131232667;
            return false;
        } else {
            k Bq = ad.aSE().Bq(str);
            if (Bq != null) {
                return a(bpVar, Bq, str2);
            }
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            bpVar.aZd.aZk = 2131232654;
            return false;
        }
    }

    private static void a(pw pwVar, azr com_tencent_mm_protocal_c_azr) {
        if (pwVar != null && com_tencent_mm_protocal_c_azr != null && !be.kS(com_tencent_mm_protocal_c_azr.jGu)) {
            pwVar.IU(com_tencent_mm_protocal_c_azr.jGu);
        }
    }

    private static void a(pw pwVar, k kVar) {
        if (kVar != null) {
            a(pwVar, kVar.aUp());
        }
    }
}
