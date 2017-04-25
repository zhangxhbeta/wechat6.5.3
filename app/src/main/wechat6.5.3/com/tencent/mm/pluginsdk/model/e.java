package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.h.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.q.a.a;
import com.tencent.mm.q.c;
import com.tencent.mm.q.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class e {
    private static final SimpleDateFormat liK = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean a(Context context, bp bpVar, String str, List<at> list, boolean z) {
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            bpVar.aZd.aZk = 2131232653;
            return false;
        }
        boolean hC = com.tencent.mm.modelbiz.e.hC(str);
        at atVar;
        if (list.size() == 1) {
            atVar = (at) list.get(0);
            if (!atVar.bvZ() && !atVar.bwa()) {
                return d.a(bpVar, atVar);
            }
            c dZ = a.dZ(atVar.field_content);
            if (dZ.cqE != null && dZ.cqE.size() == 1) {
                return d.a(bpVar, atVar);
            }
            bpVar.aZd.aZf = new qf();
            bpVar.aZd.aZg = new qo();
            bpVar.aZd.aZf.a(Go(str));
            bpVar.aZd.type = 14;
            return a(context, bpVar, atVar, z);
        }
        bpVar.aZd.aZf = new qf();
        bpVar.aZd.aZg = new qo();
        if (context != null) {
            if (hC) {
                if (com.tencent.mm.modelbiz.a.e.hT(com.tencent.mm.modelbiz.a.e.ac(((at) list.get(0)).field_bizChatId))) {
                    bpVar.aZd.aZf.Jl(context.getString(2131232710, new Object[]{com.tencent.mm.modelbiz.a.e.hV(r0)}));
                } else {
                    j hX = com.tencent.mm.modelbiz.a.e.hX(str);
                    bpVar.aZd.aZf.Jl(context.getString(2131232709, new Object[]{hX.field_userName, com.tencent.mm.modelbiz.a.e.hU(r0)}));
                }
            } else if (m.dE(str)) {
                p wO = ak.yW().wO();
                String[] split = i.b(i.ej(str), 3).split(context.getString(2131231758));
                if (!wO.er(str).equals(l.er(str)) || split == null || split.length <= 2) {
                    bpVar.aZd.aZf.Jl(context.getString(2131232710, new Object[]{l.er(str)}));
                } else {
                    if (i.el(str) == 3) {
                        bpVar.aZd.aZf.Jl(context.getString(2131232716, new Object[]{split[0], split[1], split[2].substring(0, split[2].lastIndexOf("..."))}));
                    } else {
                        bpVar.aZd.aZf.Jl(context.getString(2131232714, new Object[]{split[0], split[1], split[2].substring(0, split[2].lastIndexOf("...")), Integer.valueOf(r0)}));
                    }
                }
            } else {
                if (k.xH().equals(l.eq(str))) {
                    bpVar.aZd.aZf.Jl(context.getString(2131232710, new Object[]{r0}));
                } else {
                    bpVar.aZd.aZf.Jl(context.getString(2131232709, new Object[]{k.xH(), l.eq(str)}));
                }
            }
            v.d("MicroMsg.GetFavRecordDataSource", "title %s", bpVar.aZd.aZf.title);
        }
        bpVar.aZd.aZf.a(Go(str));
        int i = 0;
        boolean z2 = true;
        for (at atVar2 : list) {
            if (a(context, bpVar, atVar2, z)) {
                i = 1;
            } else {
                z2 = false;
            }
        }
        if (i != 0) {
            bpVar.aZd.aZk = 0;
        }
        bpVar.aZd.type = 14;
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r12, com.tencent.mm.e.a.bp r13, com.tencent.mm.storage.at r14, boolean r15) {
        /*
        r6 = 3;
        r7 = 2131232661; // 0x7f080795 float:1.8081438E38 double:1.052968841E-314;
        r9 = 2;
        r1 = 0;
        r2 = 1;
        if (r13 == 0) goto L_0x000b;
    L_0x0009:
        if (r14 != 0) goto L_0x001f;
    L_0x000b:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "fill favorite event fail, event or msg is null";
        com.tencent.mm.sdk.platformtools.v.w(r0, r2);
        if (r13 == 0) goto L_0x001d;
    L_0x0016:
        r0 = r13.aZd;
        r2 = 2131232653; // 0x7f08078d float:1.8081421E38 double:1.052968837E-314;
        r0.aZk = r2;
    L_0x001d:
        r2 = r1;
    L_0x001e:
        return r2;
    L_0x001f:
        r3 = com.tencent.mm.storage.at.O(r14);
        r0 = r3.bwm();
        if (r0 == 0) goto L_0x009e;
    L_0x0029:
        r0 = new com.tencent.mm.protocal.c.px;
        r0.<init>();
        r1 = J(r3);
        r0.c(r1);
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r4 = K(r3);
        r1.IO(r4);
        r1.uG(r2);
        r4 = r3.bwy();
        if (r4 != 0) goto L_0x007e;
    L_0x004a:
        r3 = r3.field_content;
        r1.Ix(r3);
    L_0x004f:
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.muc;
        r1 = r1 + 1;
        r0.muc = r1;
        goto L_0x001e;
    L_0x007e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r3.field_content;
        r4 = r4.append(r5);
        r5 = "\n\n";
        r4 = r4.append(r5);
        r3 = r3.field_transContent;
        r3 = r4.append(r3);
        r3 = r3.toString();
        r1.Ix(r3);
        goto L_0x004f;
    L_0x009e:
        r0 = r3.bwb();
        if (r0 == 0) goto L_0x0152;
    L_0x00a4:
        r4 = new com.tencent.mm.protocal.c.px;
        r4.<init>();
        r0 = J(r3);
        r4.c(r0);
        r5 = new com.tencent.mm.protocal.c.pw;
        r5.<init>();
        r0 = K(r3);
        r5.IO(r0);
        r5.uG(r6);
        if (r15 == 0) goto L_0x00f3;
    L_0x00c1:
        r5.ip(r2);
        r5.io(r2);
    L_0x00c7:
        r5.a(r4);
        r0 = r4.msY;
        r0 = a(r0);
        r5.IR(r0);
        r0 = r4.msY;
        r0 = b(r0);
        r5.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r5);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mue;
        r1 = r1 + 1;
        r0.mue = r1;
        r0 = r2;
    L_0x00f0:
        r2 = r0;
        goto L_0x001e;
    L_0x00f3:
        r0 = r3.field_talker;
        r0 = com.tencent.mm.model.m.eY(r0);
        if (r0 == 0) goto L_0x012e;
    L_0x00fb:
        r0 = r3.field_imgPath;
        com.tencent.mm.model.ak.yW();
        r6 = com.tencent.mm.model.c.wV();
        r7 = "recbiz_";
        r8 = ".rec";
        r0 = com.tencent.mm.sdk.platformtools.h.b(r6, r7, r0, r8, r9);
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r6 == 0) goto L_0x0125;
    L_0x0114:
        r0 = 0;
    L_0x0115:
        r5.IK(r0);
    L_0x0118:
        r5.ip(r2);
        r0 = r3.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.lC(r0);
        if (r0 != 0) goto L_0x0138;
    L_0x0123:
        r0 = r1;
        goto L_0x00f0;
    L_0x0125:
        r6 = new java.io.File;
        r6.<init>(r0);
        r6.exists();
        goto L_0x0115;
    L_0x012e:
        r0 = r3.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.iU(r0);
        r5.IK(r0);
        goto L_0x0118;
    L_0x0138:
        r0 = r0.getFormat();
        r0 = com.tencent.mm.pluginsdk.model.d.tu(r0);
        r5.IG(r0);
        r0 = new com.tencent.mm.modelvoice.n;
        r1 = r3.field_content;
        r0.<init>(r1);
        r0 = r0.time;
        r0 = (int) r0;
        r5.uF(r0);
        goto L_0x00c7;
    L_0x0152:
        r0 = r3.bwl();
        if (r0 == 0) goto L_0x015e;
    L_0x0158:
        r2 = b(r13, r3);
        goto L_0x001e;
    L_0x015e:
        r0 = r3.bwj();
        if (r0 == 0) goto L_0x02da;
    L_0x0164:
        r0 = 0;
        r4 = r3.field_msgId;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0179;
    L_0x016d:
        r0 = com.tencent.mm.ae.n.GH();
        r4 = r3.field_msgId;
        r4 = (int) r4;
        r4 = (long) r4;
        r0 = r0.ai(r4);
    L_0x0179:
        if (r0 == 0) goto L_0x0183;
    L_0x017b:
        r4 = r0.cLu;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x0195;
    L_0x0183:
        r4 = r3.field_msgSvrId;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0195;
    L_0x018b:
        r0 = com.tencent.mm.ae.n.GH();
        r4 = r3.field_msgSvrId;
        r0 = r0.ah(r4);
    L_0x0195:
        if (r0 != 0) goto L_0x01aa;
    L_0x0197:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "getImgDataPath: try get imgInfo fail";
        com.tencent.mm.sdk.platformtools.v.w(r0, r2);
        r0 = r13.aZd;
        r2 = 2131232659; // 0x7f080793 float:1.8081434E38 double:1.05296884E-314;
        r0.aZk = r2;
    L_0x01a7:
        r2 = r1;
        goto L_0x001e;
    L_0x01aa:
        r4 = new com.tencent.mm.protocal.c.px;
        r4.<init>();
        r5 = J(r3);
        r4.c(r5);
        r5 = new com.tencent.mm.protocal.c.pw;
        r5.<init>();
        r6 = K(r3);
        r5.IO(r6);
        r5.uG(r9);
        r6 = com.tencent.mm.ae.n.GH();
        r7 = com.tencent.mm.ae.e.c(r0);
        r8 = "";
        r9 = "";
        r6 = r6.l(r7, r8, r9);
        r5.IK(r6);
        r6 = r0.Gp();
        if (r6 == 0) goto L_0x0213;
    L_0x01e0:
        r6 = com.tencent.mm.ae.n.GH();
        r7 = r0.cLE;
        r6 = r6.fC(r7);
        r7 = r6.cyu;
        r6 = r6.offset;
        if (r7 <= r6) goto L_0x0213;
    L_0x01f0:
        r6 = com.tencent.mm.ae.n.GH();
        r7 = new java.lang.StringBuilder;
        r8 = "SERVERID://";
        r7.<init>(r8);
        r8 = r3.field_msgSvrId;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = "";
        r9 = "";
        r6 = r6.l(r7, r8, r9);
        r5.IK(r6);
    L_0x0213:
        r6 = com.tencent.mm.ae.n.GH();
        r7 = r3.field_imgPath;
        r6 = r6.w(r7, r2);
        r5.IL(r6);
        r5.a(r4);
        r6 = r4.msY;
        r6 = a(r6);
        r5.IR(r6);
        r4 = r4.msY;
        r4 = b(r4);
        r5.IS(r4);
        if (r15 == 0) goto L_0x028c;
    L_0x0237:
        r4 = r0.Gp();
        if (r4 == 0) goto L_0x024b;
    L_0x023d:
        r4 = r0.cyu;
        if (r4 != 0) goto L_0x024b;
    L_0x0241:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r0.cLE;
        r0 = r4.fC(r0);
    L_0x024b:
        r3 = r3.field_isSend;
        if (r3 != r2) goto L_0x02a4;
    L_0x024f:
        r3 = r0.Gp();
        if (r3 == 0) goto L_0x02a2;
    L_0x0255:
        r3 = r2;
    L_0x0256:
        r4 = r0.cLF;
        r6 = "msg";
        r4 = com.tencent.mm.sdk.platformtools.bf.q(r4, r6);
        if (r4 == 0) goto L_0x02ca;
    L_0x0261:
        if (r3 != r2) goto L_0x028c;
    L_0x0263:
        r0 = ".msg.img.$cdnbigimgurl";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r5.IA(r0);
        r0 = ".msg.img.$length";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r1);
        r0 = (long) r0;
        r5.dQ(r0);
        r0 = ".msg.img.$aeskey";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r5.IB(r0);
    L_0x028c:
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r5);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mud;
        r1 = r1 + 1;
        r0.mud = r1;
        r1 = r2;
        goto L_0x01a7;
    L_0x02a2:
        r3 = r1;
        goto L_0x0256;
    L_0x02a4:
        r3 = r0.Gp();
        if (r3 != 0) goto L_0x02ac;
    L_0x02aa:
        r3 = r1;
        goto L_0x0256;
    L_0x02ac:
        r3 = com.tencent.mm.ae.e.a(r0);
        r4 = com.tencent.mm.ae.n.GH();
        r3 = r3.cLv;
        r6 = "";
        r7 = "";
        r3 = r4.l(r3, r6, r7);
        r3 = com.tencent.mm.a.e.aR(r3);
        if (r3 != 0) goto L_0x02c8;
    L_0x02c6:
        r3 = r1;
        goto L_0x0256;
    L_0x02c8:
        r3 = r2;
        goto L_0x0256;
    L_0x02ca:
        r3 = "MicroMsg.GetFavRecordDataSource";
        r4 = "parse cdnInfo failed. [%s]";
        r6 = new java.lang.Object[r2];
        r0 = r0.cLF;
        r6[r1] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r6);
        goto L_0x028c;
    L_0x02da:
        r0 = r3.bwn();
        if (r0 == 0) goto L_0x02e6;
    L_0x02e0:
        r2 = a(r13, r3, r15);
        goto L_0x001e;
    L_0x02e6:
        r0 = r3.bwo();
        if (r0 == 0) goto L_0x02f2;
    L_0x02ec:
        r2 = a(r13, r3, r15);
        goto L_0x001e;
    L_0x02f2:
        if (r15 == 0) goto L_0x0301;
    L_0x02f4:
        r0 = r3.field_type;
        r4 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        if (r0 != r4) goto L_0x0301;
    L_0x02fb:
        r2 = a(r12, r13, r3, r6);
        goto L_0x001e;
    L_0x0301:
        r0 = r3.bvZ();
        if (r0 != 0) goto L_0x030d;
    L_0x0307:
        r0 = r3.bwa();
        if (r0 == 0) goto L_0x0313;
    L_0x030d:
        r2 = c(r13, r3);
        goto L_0x001e;
    L_0x0313:
        if (r15 == 0) goto L_0x0327;
    L_0x0315:
        r0 = r3.bwp();
        if (r0 != 0) goto L_0x0321;
    L_0x031b:
        r0 = r3.bwq();
        if (r0 == 0) goto L_0x0327;
    L_0x0321:
        r2 = a(r12, r13, r3, r2);
        goto L_0x001e;
    L_0x0327:
        if (r15 == 0) goto L_0x0336;
    L_0x0329:
        r0 = r3.field_type;
        r4 = 419430449; // 0x19000031 float:6.6174836E-24 double:2.072261757E-315;
        if (r0 != r4) goto L_0x0336;
    L_0x0330:
        r2 = a(r12, r13, r3, r9);
        goto L_0x001e;
    L_0x0336:
        r0 = r3.bwk();
        if (r0 == 0) goto L_0x038e;
    L_0x033c:
        r0 = new com.tencent.mm.protocal.c.px;
        r0.<init>();
        r1 = J(r3);
        r0.c(r1);
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r4 = K(r3);
        r1.IO(r4);
        r4 = 16;
        r1.uG(r4);
        r3 = r3.field_content;
        r1.Ix(r3);
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.muq;
        r1 = r1 + 1;
        r0.muq = r1;
        goto L_0x001e;
    L_0x038e:
        r0 = r3.bvY();
        if (r0 == 0) goto L_0x084b;
    L_0x0394:
        r0 = r3.bwq();
        if (r0 == 0) goto L_0x03a1;
    L_0x039a:
        r0 = r13.aZd;
        r0.aZk = r7;
        r2 = r1;
        goto L_0x001e;
    L_0x03a1:
        r0 = new com.tencent.mm.protocal.c.px;
        r0.<init>();
        r4 = J(r3);
        r0.c(r4);
        r4 = r3.field_content;
        if (r4 != 0) goto L_0x03bb;
    L_0x03b1:
        r0 = r13.aZd;
        r2 = 2131232662; // 0x7f080796 float:1.808144E38 double:1.0529688416E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x03bb:
        r4 = com.tencent.mm.q.a.a.dV(r4);
        if (r4 != 0) goto L_0x03cb;
    L_0x03c1:
        r0 = r13.aZd;
        r2 = 2131232662; // 0x7f080796 float:1.808144E38 double:1.0529688416E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x03cb:
        r5 = r0.msY;
        r6 = r4.appId;
        r5.Jb(r6);
        r5 = r0.msY;
        r6 = r4.bnR;
        r5.Jd(r6);
        r5 = r4.appId;
        r5 = com.tencent.mm.pluginsdk.model.app.g.aC(r5, r2);
        if (r5 == 0) goto L_0x03ff;
    L_0x03e1:
        r5 = r5.bnk();
        if (r5 == 0) goto L_0x03ff;
    L_0x03e7:
        if (r15 == 0) goto L_0x03ff;
    L_0x03e9:
        r1 = 2131231071; // 0x7f08015f float:1.8078213E38 double:1.0529680555E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x03ff:
        r5 = r4.type;
        switch(r5) {
            case 1: goto L_0x041c;
            case 2: goto L_0x0460;
            case 3: goto L_0x04da;
            case 4: goto L_0x0509;
            case 5: goto L_0x0538;
            case 6: goto L_0x05e4;
            case 7: goto L_0x06ae;
            case 8: goto L_0x0404;
            case 9: goto L_0x0404;
            case 10: goto L_0x06db;
            case 11: goto L_0x0404;
            case 12: goto L_0x0404;
            case 13: goto L_0x079a;
            case 14: goto L_0x0404;
            case 15: goto L_0x0404;
            case 16: goto L_0x082c;
            case 17: goto L_0x0404;
            case 18: goto L_0x0404;
            case 19: goto L_0x07fc;
            case 20: goto L_0x073d;
            case 21: goto L_0x0404;
            case 22: goto L_0x0404;
            case 23: goto L_0x0404;
            case 24: goto L_0x0814;
            default: goto L_0x0404;
        };
    L_0x0404:
        if (r15 == 0) goto L_0x0844;
    L_0x0406:
        r1 = 2131231158; // 0x7f0801b6 float:1.807839E38 double:1.0529680985E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x041c:
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r3 = K(r3);
        r1.IO(r3);
        r1.uG(r2);
        r3 = r4.title;
        r1.Ix(r3);
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.muc;
        r1 = r1 + 1;
        r0.muc = r1;
        goto L_0x001e;
    L_0x0460:
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r5 != 0) goto L_0x0473;
    L_0x0469:
        r0 = r13.aZd;
        r2 = 2131232665; // 0x7f080799 float:1.8081446E38 double:1.052968843E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x0473:
        r1 = com.tencent.mm.pluginsdk.model.app.am.Wf();
        r5 = r4.aXa;
        r1 = r1.Gu(r5);
        r5 = new com.tencent.mm.protocal.c.pw;
        r5.<init>();
        r6 = K(r3);
        r5.IO(r6);
        if (r1 == 0) goto L_0x0490;
    L_0x048b:
        r1 = r1.field_fileFullPath;
        r5.IK(r1);
    L_0x0490:
        r1 = com.tencent.mm.ae.n.GH();
        r3 = r3.field_imgPath;
        r1 = r1.w(r3, r2);
        r3 = com.tencent.mm.a.e.aR(r1);
        if (r3 == 0) goto L_0x04a3;
    L_0x04a0:
        r5.IL(r1);
    L_0x04a3:
        r5.uG(r9);
        r1 = r4.title;
        r5.Iw(r1);
        r1 = r4.description;
        r5.Ix(r1);
        r5.a(r0);
        r1 = r0.msY;
        r1 = a(r1);
        r5.IR(r1);
        r0 = r0.msY;
        r0 = b(r0);
        r5.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r5);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mud;
        r1 = r1 + 1;
        r0.mud = r1;
        goto L_0x001e;
    L_0x04da:
        r1 = 7;
        r1 = a(r3, r4, r1);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mui;
        r1 = r1 + 1;
        r0.mui = r1;
        goto L_0x001e;
    L_0x0509:
        r1 = 4;
        r1 = a(r3, r4, r1);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.muf;
        r1 = r1 + 1;
        r0.muf = r1;
        goto L_0x001e;
    L_0x0538:
        r5 = r4.url;
        if (r5 == 0) goto L_0x05c2;
    L_0x053c:
        r5 = r4.url;
        r6 = "";
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x05c2;
    L_0x0547:
        r1 = r0.msY;
        r5 = r4.url;
        r1.Jc(r5);
        r1 = 5;
        r1 = a(r3, r4, r1);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r3 = r0.msY;
        r3 = b(r3);
        r1.IS(r3);
        r3 = new com.tencent.mm.protocal.c.qp;
        r3.<init>();
        r5 = r4.title;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x057a;
    L_0x0575:
        r5 = r4.title;
        r3.JA(r5);
    L_0x057a:
        r5 = r4.description;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x0587;
    L_0x0582:
        r5 = r4.description;
        r3.JB(r5);
    L_0x0587:
        r5 = r4.thumburl;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x0594;
    L_0x058f:
        r5 = r4.thumburl;
        r3.JD(r5);
    L_0x0594:
        r5 = r4.canvasPageXml;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x05a1;
    L_0x059c:
        r4 = r4.canvasPageXml;
        r3.JE(r4);
    L_0x05a1:
        r4 = r3.aHr();
        if (r4 <= 0) goto L_0x05ad;
    L_0x05a7:
        r3.uO(r2);
        r0.a(r3);
    L_0x05ad:
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mug;
        r1 = r1 + 1;
        r0.mug = r1;
        goto L_0x001e;
    L_0x05c2:
        r4 = r13.aZd;
        r5 = 2131232657; // 0x7f080791 float:1.808143E38 double:1.052968839E-314;
        r4.aZk = r5;
        if (r15 == 0) goto L_0x05e1;
    L_0x05cb:
        r1 = 2131231158; // 0x7f0801b6 float:1.807839E38 double:1.0529680985E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x05e1:
        r2 = r1;
        goto L_0x001e;
    L_0x05e4:
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r5 != 0) goto L_0x05f7;
    L_0x05ed:
        r0 = r13.aZd;
        r2 = 2131232665; // 0x7f080799 float:1.8081446E38 double:1.052968843E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x05f7:
        r5 = r4.cof;
        if (r5 != 0) goto L_0x0603;
    L_0x05fb:
        r5 = r4.cob;
        r6 = com.tencent.mm.h.b.sK();
        if (r5 <= r6) goto L_0x060d;
    L_0x0603:
        r0 = r13.aZd;
        r2 = 2131232747; // 0x7f0807eb float:1.8081612E38 double:1.0529688836E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x060d:
        r5 = com.tencent.mm.pluginsdk.model.app.am.Wf();
        r6 = r4.aXa;
        r5 = r5.Gu(r6);
        r6 = new com.tencent.mm.protocal.c.pw;
        r6.<init>();
        if (r5 == 0) goto L_0x0641;
    L_0x061e:
        r7 = r5.field_fileFullPath;
        r6.IK(r7);
        r7 = new java.io.File;
        r5 = r5.field_fileFullPath;
        r7.<init>(r5);
        r8 = r7.length();
        r5 = com.tencent.mm.h.b.sK();
        r10 = (long) r5;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0641;
    L_0x0637:
        r0 = r13.aZd;
        r2 = 2131232747; // 0x7f0807eb float:1.8081612E38 double:1.0529688836E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x0641:
        r1 = K(r3);
        r6.IO(r1);
        r1 = 8;
        r6.uG(r1);
        r1 = r4.coc;
        r6.IG(r1);
        r1 = com.tencent.mm.ae.n.GH();
        r3 = r3.field_imgPath;
        r1 = r1.w(r3, r2);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r3 == 0) goto L_0x0665;
    L_0x0662:
        r6.ip(r2);
    L_0x0665:
        r3 = com.tencent.mm.a.e.aR(r1);
        if (r3 == 0) goto L_0x066e;
    L_0x066b:
        r6.IL(r1);
    L_0x066e:
        r1 = r4.title;
        r6.Iw(r1);
        r1 = r4.description;
        r6.Ix(r1);
        r6.a(r0);
        r1 = r0.msY;
        r1 = a(r1);
        r6.IR(r1);
        r0 = r0.msY;
        r0 = b(r0);
        r6.IS(r0);
        if (r15 == 0) goto L_0x0699;
    L_0x068f:
        r0 = r4.coi;
        r6.IA(r0);
        r0 = r4.cop;
        r6.IB(r0);
    L_0x0699:
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r6);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.muj;
        r1 = r1 + 1;
        r0.muj = r1;
        goto L_0x001e;
    L_0x06ae:
        r0 = r4.aXa;
        if (r0 == 0) goto L_0x06ba;
    L_0x06b2:
        r0 = r4.aXa;
        r0 = r0.length();
        if (r0 != 0) goto L_0x06c8;
    L_0x06ba:
        r0 = r13.aZd;
        r2 = 2131232654; // 0x7f08078e float:1.8081423E38 double:1.0529688376E-314;
        r0.aZk = r2;
    L_0x06c1:
        r0 = r13.aZd;
        r0.aZk = r7;
        r2 = r1;
        goto L_0x001e;
    L_0x06c8:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x06c1;
    L_0x06d1:
        r0 = r13.aZd;
        r2 = 2131232665; // 0x7f080799 float:1.8081446E38 double:1.052968843E-314;
        r0.aZk = r2;
        r2 = r1;
        goto L_0x001e;
    L_0x06db:
        r1 = new com.tencent.mm.protocal.c.qe;
        r1.<init>();
        r5 = r4.title;
        r1.Jg(r5);
        r5 = r4.description;
        r1.Jh(r5);
        r5 = r4.cox;
        r1.uK(r5);
        r5 = r4.coy;
        r1.Jj(r5);
        r4 = r4.thumburl;
        r1.Ji(r4);
        r0.a(r1);
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r3 = K(r3);
        r1.IO(r3);
        r3 = 10;
        r1.uG(r3);
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mul;
        r1 = r1 + 1;
        r0.mul = r1;
        goto L_0x001e;
    L_0x073d:
        r1 = new com.tencent.mm.protocal.c.qj;
        r1.<init>();
        r5 = r4.title;
        r1.Jw(r5);
        r5 = r4.description;
        r1.Jx(r5);
        r5 = r4.coB;
        r1.Jz(r5);
        r4 = r4.thumburl;
        r1.Jy(r4);
        r0.a(r1);
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r3 = K(r3);
        r1.IO(r3);
        r3 = 14;
        r1.uG(r3);
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mup;
        r1 = r1 + 1;
        r0.mup = r1;
        goto L_0x001e;
    L_0x079a:
        r1 = new com.tencent.mm.protocal.c.qe;
        r1.<init>();
        r5 = r4.title;
        r1.Jg(r5);
        r5 = r4.description;
        r1.Jh(r5);
        r5 = r4.coD;
        r1.uK(r5);
        r5 = r4.coE;
        r1.Jj(r5);
        r4 = r4.thumburl;
        r1.Ji(r4);
        r0.a(r1);
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r3 = K(r3);
        r1.IO(r3);
        r3 = 11;
        r1.uG(r3);
        r1.ip(r2);
        r1.io(r2);
        r1.a(r0);
        r3 = r0.msY;
        r3 = a(r3);
        r1.IR(r3);
        r0 = r0.msY;
        r0 = b(r0);
        r1.IS(r0);
        r0 = r13.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
        r0.add(r1);
        r0 = r13.aZd;
        r0 = r0.aZg;
        r1 = r0.mum;
        r1 = r1 + 1;
        r0.mum = r1;
        goto L_0x001e;
    L_0x07fc:
        if (r15 == 0) goto L_0x0814;
    L_0x07fe:
        r1 = 2131231138; // 0x7f0801a2 float:1.8078349E38 double:1.0529680886E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x0814:
        if (r15 == 0) goto L_0x082c;
    L_0x0816:
        r1 = 2131232757; // 0x7f0807f5 float:1.8081632E38 double:1.0529688885E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x082c:
        if (r15 == 0) goto L_0x0404;
    L_0x082e:
        r1 = 2131231128; // 0x7f080198 float:1.8078328E38 double:1.0529680837E-314;
        r1 = r12.getString(r1);
        r0 = a(r3, r1, r0);
        r1 = r13.aZd;
        r1 = r1.aZf;
        r1 = r1.mtR;
        r1.add(r0);
        goto L_0x001e;
    L_0x0844:
        r0 = r13.aZd;
        r0.aZk = r7;
        r2 = r1;
        goto L_0x001e;
    L_0x084b:
        r0 = r13.aZd;
        r0.aZk = r7;
        if (r15 == 0) goto L_0x0857;
    L_0x0851:
        r2 = a(r12, r13, r3, r6);
        goto L_0x001e;
    L_0x0857:
        r2 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.e.a(android.content.Context, com.tencent.mm.e.a.bp, com.tencent.mm.storage.at, boolean):boolean");
    }

    private static boolean a(Context context, bp bpVar, at atVar, int i) {
        px pxVar = new px();
        pxVar.c(J(atVar));
        String str = null;
        if (i == 1) {
            str = context.getString(2131231031);
        } else if (i == 2) {
            str = context.getString(2131231109);
        } else if (i == 3) {
            str = context.getString(2131231158);
        }
        bpVar.aZd.aZf.mtR.add(a(atVar, str, pxVar));
        return true;
    }

    private static qg Go(String str) {
        qg qgVar = new qg();
        qgVar.Jn(str);
        qgVar.uN(1);
        qgVar.dV(be.Ni());
        qgVar.Jp(SQLiteDatabase.KeyEmpty);
        return qgVar;
    }

    private static py J(at atVar) {
        py pyVar = new py();
        if (atVar.field_isSend == 1) {
            pyVar.IW(k.xF());
            pyVar.IX(atVar.field_talker);
            if (m.dE(atVar.field_talker)) {
                pyVar.IZ(pyVar.bhM);
            }
        } else {
            pyVar.IW(atVar.field_talker);
            pyVar.IX(k.xF());
            if (m.dE(atVar.field_talker)) {
                pyVar.IZ(atVar.field_content != null ? atVar.field_content.substring(0, Math.max(0, atVar.field_content.indexOf(58))) : SQLiteDatabase.KeyEmpty);
                if (!(be.kS(pyVar.mtu) || atVar.bwb())) {
                    atVar.setContent(atVar.field_content.substring(pyVar.mtu.length() + 1));
                    if (atVar.field_content.length() > 0 && '\n' == atVar.field_content.charAt(0)) {
                        atVar.setContent(atVar.field_content.substring(1));
                    }
                    if (atVar.bwu()) {
                        atVar.cK(atVar.field_transContent.substring(pyVar.mtu.length() + 1));
                        if (atVar.field_transContent.length() > 0 && '\n' == atVar.field_transContent.charAt(0)) {
                            atVar.cK(atVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        if (com.tencent.mm.modelbiz.e.hC(atVar.field_talker)) {
            String str = atVar.field_bizChatUserId;
            if (str == null) {
                str = aw.fP(atVar.bNo).userId;
            }
            pyVar.IZ(str);
        }
        pyVar.uI(1);
        pyVar.dS(atVar.field_createTime);
        pyVar.Ja(atVar.field_msgSvrId);
        if (atVar.field_msgSvrId > 0) {
            pyVar.IY(atVar.field_msgSvrId);
        }
        return pyVar;
    }

    private static String a(py pyVar) {
        String str = pyVar.mtu;
        if (be.kS(str)) {
            str = pyVar.bhM;
        }
        if (com.tencent.mm.modelbiz.a.e.hS(str)) {
            return com.tencent.mm.modelbiz.a.e.hU(str);
        }
        return l.eq(str);
    }

    private static String b(py pyVar) {
        return liK.format(new Date(pyVar.dhH));
    }

    private static String K(at atVar) {
        if (atVar.field_isSend != 1) {
            return String.valueOf(atVar.field_msgSvrId);
        }
        if (m.dE(atVar.field_talker) || atVar.field_talker.equals("filehelper")) {
            return String.format("%d", new Object[]{Long.valueOf(atVar.field_msgSvrId)});
        }
        return String.format("%s#%d", new Object[]{atVar.field_talker, Long.valueOf(atVar.field_msgSvrId)});
    }

    private static boolean b(bp bpVar, at atVar) {
        px pxVar = new px();
        pxVar.c(J(atVar));
        Map q = bf.q(atVar.field_content, "msg");
        if (q != null) {
            try {
                qc qcVar = new qc();
                qcVar.Je((String) q.get(".msg.location.$label"));
                qcVar.k(Double.parseDouble((String) q.get(".msg.location.$x")));
                qcVar.j(Double.parseDouble((String) q.get(".msg.location.$y")));
                qcVar.uJ(Integer.valueOf((String) q.get(".msg.location.$scale")).intValue());
                qcVar.Jf((String) q.get(".msg.location.$poiname"));
                pxVar.a(qcVar);
                pw pwVar = new pw();
                pwVar.IO(K(atVar));
                pwVar.uG(6);
                pwVar.ip(true);
                pwVar.io(true);
                pwVar.a(pxVar);
                pwVar.IR(a(pxVar.msY));
                pwVar.IS(b(pxVar.msY));
                bpVar.aZd.aZf.mtR.add(pwVar);
                qo qoVar = bpVar.aZd.aZg;
                qoVar.muh++;
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        bpVar.aZd.aZk = 2131232662;
        return false;
    }

    private static boolean a(bp bpVar, at atVar, boolean z) {
        px pxVar = new px();
        pxVar.c(J(atVar));
        pw pwVar = new pw();
        pwVar.IO(K(atVar));
        com.tencent.mm.as.k.KV();
        pwVar.IK(o.lc(atVar.field_imgPath));
        com.tencent.mm.as.k.KV();
        pwVar.IL(o.ld(atVar.field_imgPath));
        pwVar.IG(com.tencent.mm.a.e.aS(pwVar.msq));
        if (atVar.bwo()) {
            pwVar.uG(15);
        } else {
            pwVar.uG(4);
        }
        n lp = com.tencent.mm.as.p.lp(atVar.field_imgPath);
        v.i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(lp.cyu));
        if (lp.cyu > b.sK()) {
            bpVar.aZd.aZk = 2131232747;
            return false;
        } else if (atVar.bwo() && com.tencent.mm.as.p.lr(lp.getFileName())) {
            bpVar.aZd.aZk = 2131232652;
            return false;
        } else {
            pwVar.uF(lp.dhK);
            pwVar.a(pxVar);
            pwVar.IR(a(pxVar.msY));
            pwVar.IS(b(pxVar.msY));
            if (z) {
                Map q = bf.q(lp.Lg(), "msg");
                if (q != null) {
                    pwVar.IA((String) q.get(".msg.videomsg.$cdnvideourl"));
                    pwVar.IB((String) q.get(".msg.videomsg.$aeskey"));
                } else {
                    v.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
                }
            }
            bpVar.aZd.aZf.mtR.add(pwVar);
            qo qoVar = bpVar.aZd.aZg;
            qoVar.muf++;
            n lp2 = com.tencent.mm.as.p.lp(atVar.field_imgPath);
            pwVar.IU(lp2.bnY);
            ayk com_tencent_mm_protocal_c_ayk = lp2.dhT;
            if (!(com_tencent_mm_protocal_c_ayk == null || be.kS(com_tencent_mm_protocal_c_ayk.cqm))) {
                pz pzVar = new pz();
                pzVar.cqg = com_tencent_mm_protocal_c_ayk.cqg;
                pzVar.mtD = com_tencent_mm_protocal_c_ayk.mtD;
                pzVar.cqj = com_tencent_mm_protocal_c_ayk.cqj;
                pzVar.cqk = com_tencent_mm_protocal_c_ayk.cqk;
                pzVar.cqi = com_tencent_mm_protocal_c_ayk.cqi;
                pzVar.cql = com_tencent_mm_protocal_c_ayk.cql;
                pzVar.cqm = com_tencent_mm_protocal_c_ayk.cqm;
                pzVar.cqn = com_tencent_mm_protocal_c_ayk.cqn;
                pwVar.a(pzVar);
            }
            return true;
        }
    }

    private static pw a(at atVar, a aVar, int i) {
        pw pwVar = new pw();
        pwVar.IO(K(atVar));
        pwVar.ID(aVar.cos);
        pwVar.IE(aVar.cot);
        pwVar.IC(aVar.url);
        pwVar.io(true);
        File file = new File(be.ah(com.tencent.mm.ae.n.GH().w(atVar.field_imgPath, true), SQLiteDatabase.KeyEmpty));
        if (file.exists()) {
            pwVar.IL(file.getAbsolutePath());
        } else {
            pwVar.ip(true);
        }
        pwVar.Iw(aVar.title);
        pwVar.Ix(aVar.description);
        pwVar.uG(i);
        pwVar.IV(aVar.canvasPageXml);
        return pwVar;
    }

    private static pw a(at atVar, String str, px pxVar) {
        pw pwVar = new pw();
        pwVar.IO(K(atVar));
        pwVar.uG(1);
        pwVar.Ix(str);
        pwVar.ip(true);
        pwVar.io(true);
        pwVar.a(pxVar);
        pwVar.IR(a(pxVar.msY));
        pwVar.IS(b(pxVar.msY));
        return pwVar;
    }

    private static boolean c(bp bpVar, at atVar) {
        px pxVar = new px();
        pxVar.c(J(atVar));
        try {
            c dZ = a.dZ(atVar.field_content);
            List<d> list = dZ.cqE;
            pxVar.msY.Jd(dZ.bnR);
            if (list != null) {
                int i = 0;
                for (d dVar : list) {
                    pxVar.msY.Jc(dVar.url);
                    pw pwVar = new pw();
                    pwVar.Iw(dVar.title);
                    pwVar.Ix(dVar.cqK);
                    pwVar.IO(K(atVar));
                    if (be.kS(dVar.cqI)) {
                        pwVar.ip(true);
                    } else {
                        pwVar.IL(r.o(dVar.cqI, atVar.field_type, i == 0 ? "@T" : "@S"));
                    }
                    pwVar.io(true);
                    pwVar.uG(5);
                    pwVar.a(pxVar);
                    pwVar.IR(a(pxVar.msY));
                    pwVar.IS(b(pxVar.msY));
                    bpVar.aZd.aZf.mtR.add(pwVar);
                    qo qoVar = bpVar.aZd.aZg;
                    qoVar.mug++;
                    i++;
                }
                return true;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.GetFavRecordDataSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        bpVar.aZd.aZk = 2131232662;
        return false;
    }
}
