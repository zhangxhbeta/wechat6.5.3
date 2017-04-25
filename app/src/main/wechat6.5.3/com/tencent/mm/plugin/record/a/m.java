package com.tencent.mm.plugin.record.a;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class m {
    private static final f<Integer, c> cqx = new f(32);

    public static String b(String str, String str2, List<pw> list, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(be.KJ(str)).append("</title>");
        stringBuilder.append("<desc>").append(be.KJ(str2)).append("</desc>");
        stringBuilder.append(n.ap(list));
        stringBuilder.append("<favusername>").append(be.KJ(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        aVar.description = str2;
        if (be.kS(((pw) list.get(0)).msh) || !((pw) list.get(0)).msh.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.bXP = "view";
        aVar.coC = stringBuilder.toString();
        return a.b(aVar);
    }

    public static a a(String str, String str2, List<pw> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(be.KJ(str)).append("</title>");
        stringBuilder.append("<desc>").append(be.KJ(str2)).append("</desc>");
        stringBuilder.append(n.ap(list));
        stringBuilder.append("<favusername>").append(be.KJ(k.xF())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        aVar.description = str2;
        if (be.kS(((pw) list.get(0)).msh) || !((pw) list.get(0)).msh.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.bXP = "view";
        aVar.coC = stringBuilder.toString();
        return aVar;
    }

    public static int a(Context context, String str, String str2, List<at> list, bp bpVar, d dVar) {
        if (be.kS(str)) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (list == null || list.isEmpty()) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else {
            if (bpVar == null || dVar == null) {
                bpVar = new bp();
                if (!e.a(context, bpVar, str2, list, true)) {
                    return -1;
                }
                dVar = a(context, bpVar, str2);
            }
            a a = a(dVar.title, dVar.desc, bpVar.aZd.aZf.mtR);
            at atVar = new at();
            byte[] bArr = null;
            if (!be.kS(dVar.bdZ)) {
                bArr = be.readFromFile(dVar.bdZ);
            } else if (dVar.bmj == 0 && !be.kS(dVar.fKQ)) {
                bArr = com.tencent.mm.sdk.platformtools.d.E(b.a(dVar.fKQ, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 32768) {
                    a2 = n.GH().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = n.GH().f(8, bArr);
                }
                v.d("MicroMsg.RecordMsgLogic", g.sm() + " thumbData MsgInfo path:" + a2);
                if (!be.kS(a2)) {
                    atVar.cI(a2);
                }
            }
            atVar.setContent(a.b(a));
            atVar.dh(1);
            atVar.cH(str);
            atVar.z(aw.fN(str));
            atVar.di(1);
            atVar.setType(49);
            if (com.tencent.mm.modelbiz.e.hC(str)) {
                atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
            }
            ak.yW();
            long R = com.tencent.mm.model.c.wJ().R(atVar);
            v.d("MicroMsg.RecordMsgLogic", g.sm() + " msginfo insert id: " + R);
            if (R < 0) {
                v.e("MicroMsg.RecordMsgLogic", g.sm() + "insert msg failed :" + R);
                return 0 - g.sk();
            }
            v.i("MicroMsg.RecordMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
            atVar.x(R);
            com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
            aVar.field_xml = atVar.field_content;
            aVar.field_title = a.title;
            aVar.field_type = a.type;
            aVar.field_description = a.description;
            aVar.field_msgId = R;
            am.bnC().b(aVar);
            Iterator it = bpVar.aZd.aZf.mtR.iterator();
            boolean z = false;
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                String obj = pwVar.toString();
                pwVar.IJ(com.tencent.mm.a.g.m((obj + pwVar.aKG + System.currentTimeMillis()).getBytes()));
                if (z || com.tencent.mm.a.e.aR(pwVar.msq) || com.tencent.mm.a.e.aR(pwVar.mss) || !be.kS(pwVar.mrS) || !be.kS(pwVar.coj)) {
                    z = true;
                }
            }
            v.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                k kVar = new k();
                kVar.field_msgId = R;
                kVar.field_title = a.title;
                kVar.field_desc = a.description;
                kVar.field_toUser = str;
                kVar.field_dataProto = bpVar.aZd.aZf;
                kVar.field_type = 2;
                kVar.field_localId = new Random().nextInt(2147483645) + 1;
                v.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[]{Boolean.valueOf(s.aJD().b(kVar)), Long.valueOf(R), Integer.valueOf(kVar.field_localId)});
                s.aJF().a(kVar);
            } else {
                v.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[]{Long.valueOf(R)});
                am.bnE();
                al.a.dC(R);
            }
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.b.a.d a(android.content.Context r13, com.tencent.mm.e.a.bp r14, java.lang.String r15) {
        /*
        r12 = 3;
        r11 = 2;
        r1 = 0;
        r10 = 5;
        r2 = 1;
        r3 = new com.tencent.mm.protocal.b.a.d;
        r3.<init>();
        r4 = new android.util.SparseIntArray;
        r4.<init>();
        r0 = com.tencent.mm.modelbiz.e.hC(r15);
        if (r0 == 0) goto L_0x0062;
    L_0x0015:
        r0 = r14.aZd;
        r0 = r0.aZf;
        r0 = r0.title;
        r3.title = r0;
    L_0x001d:
        r0 = "MicroMsg.RecordMsgLogic";
        r5 = "msgInfo title %s";
        r6 = new java.lang.Object[r2];
        r7 = r3.title;
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.v.d(r0, r5, r6);
        r5 = new java.util.LinkedList;
        r5.<init>();
        r0 = r14.aZd;
        r0 = r0.aZf;
        if (r0 == 0) goto L_0x012e;
    L_0x0037:
        r0 = r14.aZd;
        r0 = r0.aZf;
        r0 = r0.mtR;
    L_0x003d:
        r6 = r0.iterator();
    L_0x0041:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0438;
    L_0x0047:
        r0 = r6.next();
        r0 = (com.tencent.mm.protocal.c.pw) r0;
        r7 = r0.aKG;
        r7 = r4.get(r7);
        r8 = r0.aKG;
        r7 = r7 + 1;
        r4.put(r8, r7);
        r7 = r0.aKG;
        switch(r7) {
            case 1: goto L_0x0168;
            case 2: goto L_0x0196;
            case 3: goto L_0x0135;
            case 4: goto L_0x0250;
            case 5: goto L_0x01d2;
            case 6: goto L_0x028c;
            case 7: goto L_0x02eb;
            case 8: goto L_0x032d;
            case 9: goto L_0x005f;
            case 10: goto L_0x036f;
            case 11: goto L_0x036f;
            case 12: goto L_0x005f;
            case 13: goto L_0x005f;
            case 14: goto L_0x03b5;
            case 15: goto L_0x0214;
            case 16: goto L_0x03f1;
            default: goto L_0x005f;
        };
    L_0x005f:
        r0 = r1;
    L_0x0060:
        r1 = r0;
        goto L_0x0041;
    L_0x0062:
        r0 = com.tencent.mm.model.m.dE(r15);
        if (r0 == 0) goto L_0x0100;
    L_0x0068:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.wO();
        r5 = com.tencent.mm.model.i.ej(r15);
        r5 = com.tencent.mm.model.i.b(r5, r12);
        r6 = 2131231758; // 0x7f08040e float:1.8079606E38 double:1.052968395E-314;
        r6 = r13.getString(r6);
        r5 = r5.split(r6);
        r0 = r0.er(r15);
        r6 = com.tencent.mm.model.l.er(r15);
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x00ed;
    L_0x0091:
        r0 = r5.length;
        if (r0 <= r11) goto L_0x00ed;
    L_0x0094:
        r0 = com.tencent.mm.model.i.el(r15);
        if (r0 != r12) goto L_0x00c0;
    L_0x009a:
        r0 = 2131232716; // 0x7f0807cc float:1.808155E38 double:1.0529688683E-314;
        r6 = new java.lang.Object[r12];
        r7 = r5[r1];
        r6[r1] = r7;
        r7 = r5[r2];
        r6[r2] = r7;
        r7 = r5[r11];
        r5 = r5[r11];
        r8 = "...";
        r5 = r5.lastIndexOf(r8);
        r5 = r7.substring(r1, r5);
        r6[r11] = r5;
        r0 = r13.getString(r0, r6);
        r3.title = r0;
        goto L_0x001d;
    L_0x00c0:
        r6 = 2131232714; // 0x7f0807ca float:1.8081545E38 double:1.0529688673E-314;
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = r5[r1];
        r7[r1] = r8;
        r8 = r5[r2];
        r7[r2] = r8;
        r8 = r5[r11];
        r5 = r5[r11];
        r9 = "...";
        r5 = r5.lastIndexOf(r9);
        r5 = r8.substring(r1, r5);
        r7[r11] = r5;
        r0 = java.lang.Integer.valueOf(r0);
        r7[r12] = r0;
        r0 = r13.getString(r6, r7);
        r3.title = r0;
        goto L_0x001d;
    L_0x00ed:
        r0 = 2131232710; // 0x7f0807c6 float:1.8081537E38 double:1.0529688653E-314;
        r5 = new java.lang.Object[r2];
        r6 = com.tencent.mm.model.l.er(r15);
        r5[r1] = r6;
        r0 = r13.getString(r0, r5);
        r3.title = r0;
        goto L_0x001d;
    L_0x0100:
        r0 = com.tencent.mm.model.k.xH();
        r5 = com.tencent.mm.model.l.eq(r15);
        r6 = r0.equals(r5);
        if (r6 == 0) goto L_0x011d;
    L_0x010e:
        r5 = 2131232710; // 0x7f0807c6 float:1.8081537E38 double:1.0529688653E-314;
        r6 = new java.lang.Object[r2];
        r6[r1] = r0;
        r0 = r13.getString(r5, r6);
        r3.title = r0;
        goto L_0x001d;
    L_0x011d:
        r6 = 2131232709; // 0x7f0807c5 float:1.8081535E38 double:1.052968865E-314;
        r7 = new java.lang.Object[r11];
        r7[r1] = r0;
        r7[r2] = r5;
        r0 = r13.getString(r6, r7);
        r3.title = r0;
        goto L_0x001d;
    L_0x012e:
        r0 = new java.util.LinkedList;
        r0.<init>();
        goto L_0x003d;
    L_0x0135:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x005f;
    L_0x013b:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r0.msO;
        r0 = r7.append(r0);
        r7 = ":";
        r0 = r0.append(r7);
        r7 = 2131231177; // 0x7f0801c9 float:1.8078428E38 double:1.052968108E-314;
        r7 = r13.getString(r7);
        r0 = r0.append(r7);
        r7 = "\n";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r5.add(r0);
        goto L_0x0041;
    L_0x0168:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x005f;
    L_0x016e:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r0 = r0.desc;
        r0 = r7.append(r0);
        r7 = "\n";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r5.add(r0);
        goto L_0x0041;
    L_0x0196:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x01c7;
    L_0x019c:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231122; // 0x7f080192 float:1.8078316E38 double:1.0529680807E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x01c7:
        if (r1 != 0) goto L_0x005f;
    L_0x01c9:
        r1 = 2130837647; // 0x7f02008f float:1.7280254E38 double:1.0527736782E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x01d2:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0209;
    L_0x01d8:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231171; // 0x7f0801c3 float:1.8078415E38 double:1.052968105E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = r0.title;
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0209:
        if (r1 != 0) goto L_0x005f;
    L_0x020b:
        r1 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x0214:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0245;
    L_0x021a:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0245:
        if (r1 != 0) goto L_0x005f;
    L_0x0247:
        r1 = 2131165244; // 0x7f07003c float:1.79447E38 double:1.0529355327E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x0250:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0281;
    L_0x0256:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0281:
        if (r1 != 0) goto L_0x005f;
    L_0x0283:
        r1 = 2131165244; // 0x7f07003c float:1.79447E38 double:1.0529355327E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x028c:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x02de;
    L_0x0292:
        r7 = r0.msM;
        r7 = r7.mta;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r0.msO;
        r0 = r8.append(r0);
        r8 = ":";
        r0 = r0.append(r8);
        r8 = 2131231086; // 0x7f08016e float:1.8078243E38 double:1.052968063E-314;
        r8 = r13.getString(r8);
        r8 = r0.append(r8);
        r0 = r7.bkV;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02ca;
    L_0x02bb:
        r0 = r7.bkV;
        r9 = 2131233537; // 0x7f080b01 float:1.8083214E38 double:1.052969274E-314;
        r9 = r13.getString(r9);
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x02e8;
    L_0x02ca:
        r0 = r7.label;
    L_0x02cc:
        r0 = r8.append(r0);
        r7 = "\n";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r5.add(r0);
    L_0x02de:
        if (r1 != 0) goto L_0x005f;
    L_0x02e0:
        r0 = 2131165231; // 0x7f07002f float:1.7944673E38 double:1.0529355262E-314;
        r3.bmj = r0;
        r1 = r2;
        goto L_0x0041;
    L_0x02e8:
        r0 = r7.bkV;
        goto L_0x02cc;
    L_0x02eb:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0322;
    L_0x02f1:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231095; // 0x7f080177 float:1.8078261E38 double:1.0529680674E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = r0.title;
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0322:
        if (r1 != 0) goto L_0x005f;
    L_0x0324:
        r1 = 2131165232; // 0x7f070030 float:1.7944675E38 double:1.0529355267E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x032d:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0364;
    L_0x0333:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231063; // 0x7f080157 float:1.8078196E38 double:1.0529680516E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = r0.title;
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0364:
        if (r1 != 0) goto L_0x005f;
    L_0x0366:
        r1 = 2131165241; // 0x7f070039 float:1.7944694E38 double:1.052935531E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x036f:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x03aa;
    L_0x0375:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231126; // 0x7f080196 float:1.8078324E38 double:1.0529680827E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = r0.msM;
        r8 = r8.mte;
        r8 = r8.title;
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x03aa:
        if (r1 != 0) goto L_0x005f;
    L_0x03ac:
        r1 = 2131165241; // 0x7f070039 float:1.7944694E38 double:1.052935531E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x03b5:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x03e6;
    L_0x03bb:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131230904; // 0x7f0800b8 float:1.8077874E38 double:1.052967973E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x03e6:
        if (r1 != 0) goto L_0x005f;
    L_0x03e8:
        r1 = 2131165241; // 0x7f070039 float:1.7944694E38 double:1.052935531E-314;
        a(r3, r0, r1);
        r1 = r2;
        goto L_0x0041;
    L_0x03f1:
        r7 = r5.size();
        if (r7 >= r10) goto L_0x0422;
    L_0x03f7:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r0.msO;
        r7 = r7.append(r8);
        r8 = ":";
        r7 = r7.append(r8);
        r8 = 2131231068; // 0x7f08015c float:1.8078207E38 double:1.052968054E-314;
        r8 = r13.getString(r8);
        r7 = r7.append(r8);
        r8 = "\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5.add(r7);
    L_0x0422:
        if (r1 != 0) goto L_0x005f;
    L_0x0424:
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.wJ();
        r0 = r0.desc;
        r0 = r1.MU(r0);
        r0 = r0.lct;
        r3.fKQ = r0;
        r0 = r2;
        goto L_0x0060;
    L_0x0438:
        r0 = "";
        r1 = "";
        r3.desc = r1;
        r2 = r5.iterator();
        r1 = r0;
    L_0x0445:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0464;
    L_0x044b:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r0;
        goto L_0x0445;
    L_0x0464:
        r0 = r1.trim();
        r1 = r5.size();
        if (r1 < r10) goto L_0x0482;
    L_0x046e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r1 = "...";
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x0482:
        r3.desc = r0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.a.m.a(android.content.Context, com.tencent.mm.e.a.bp, java.lang.String):com.tencent.mm.protocal.b.a.d");
    }

    private static void a(d dVar, pw pwVar, int i) {
        String str = pwVar.mss;
        if (com.tencent.mm.a.e.aR(str)) {
            dVar.bdZ = str;
        } else {
            dVar.bmj = i;
        }
    }

    public static int a(String str, String str2, at atVar) {
        if (be.kS(str)) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (atVar == null || be.kS(atVar.field_content)) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else if (1 == atVar.field_status) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            return -1;
        } else {
            for (String str3 : be.g(str.split(","))) {
                v.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[]{str3, Long.valueOf(atVar.field_msgId), Integer.valueOf(atVar.field_status)});
                String fM = aw.fM(atVar.field_content);
                a dV = a.dV(fM);
                if (dV == null) {
                    v.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    return -1;
                }
                c yy = yy(dV.coC);
                if (yy == null) {
                    v.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    return -1;
                }
                at atVar2 = new at();
                if (!be.kS(atVar.field_imgPath)) {
                    String f = n.GH().f(8, be.readFromFile(n.GH().w(atVar.field_imgPath, true)));
                    v.d("MicroMsg.RecordMsgLogic", g.sm() + " thumbData from msg MsgInfo path:" + f);
                    if (!be.kS(f)) {
                        atVar2.cI(f);
                    }
                }
                atVar2.setContent(fM);
                atVar2.dh(1);
                atVar2.cH(str3);
                atVar2.z(aw.fN(str3));
                atVar2.di(1);
                atVar2.setType(49);
                ak.yW();
                long R = com.tencent.mm.model.c.wJ().R(atVar2);
                v.d("MicroMsg.RecordMsgLogic", g.sm() + " msginfo insert id: " + R);
                if (R < 0) {
                    v.e("MicroMsg.RecordMsgLogic", g.sm() + "insert msg failed :" + R);
                    return 0 - g.sk();
                }
                Object obj;
                v.i("MicroMsg.RecordMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
                atVar2.x(R);
                pq pqVar = new pq();
                pqVar.bqU.bqV = atVar.field_msgId;
                pqVar.bqU.bqW = R;
                com.tencent.mm.sdk.c.a.nhr.z(pqVar);
                com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
                aVar.field_xml = atVar2.field_content;
                aVar.field_title = dV.title;
                aVar.field_type = dV.type;
                aVar.field_description = dV.description;
                aVar.field_msgId = R;
                am.bnC().b(aVar);
                Iterator it = yy.cqE.iterator();
                while (it.hasNext()) {
                    pw pwVar = (pw) it.next();
                    if (be.kS(pwVar.mrS)) {
                        if (!be.kS(pwVar.coj)) {
                        }
                    }
                    obj = 1;
                }
                obj = null;
                if (obj != null) {
                    k kVar = new k();
                    qf qfVar = new qf();
                    qfVar.mtR.addAll(yy.cqE);
                    kVar.field_msgId = R;
                    kVar.field_oriMsgId = atVar.field_msgId;
                    kVar.field_toUser = str3;
                    kVar.field_title = dV.title;
                    kVar.field_desc = dV.description;
                    kVar.field_dataProto = qfVar;
                    kVar.field_type = 0;
                    kVar.field_favFrom = yy.lYv;
                    kVar.field_localId = new Random().nextInt(2147483645) + 1;
                    s.aJD().b(kVar);
                    s.aJF().a(kVar);
                } else {
                    v.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    am.bnE();
                    al.a.dC(R);
                }
                if (!be.kS(str2)) {
                    j.a.bmt().x(str3, str2, com.tencent.mm.model.m.fp(str3));
                }
            }
            return 0;
        }
    }

    public static int a(String str, qf qfVar, String str2, String str3, String str4, int i, String str5) {
        if (be.kS(str)) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (qfVar == null || qfVar.mtR.isEmpty()) {
            v.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            return -1;
        } else {
            a a = a(str2, str3, qfVar.mtR);
            at atVar = new at();
            byte[] bArr = null;
            if (!be.kS(str4)) {
                bArr = be.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.d.E(com.tencent.mm.sdk.platformtools.d.uU(i));
            } else if (!be.kS(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.d.E(b.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 32768) {
                    a2 = n.GH().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = n.GH().f(8, bArr);
                }
                v.d("MicroMsg.RecordMsgLogic", g.sm() + " thumbData MsgInfo path:" + a2);
                if (!be.kS(a2)) {
                    atVar.cI(a2);
                }
            }
            atVar.setContent(a.b(a));
            atVar.dh(1);
            atVar.cH(str);
            atVar.z(aw.fN(str));
            atVar.di(1);
            atVar.setType(49);
            if (com.tencent.mm.modelbiz.e.hC(str)) {
                atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
            }
            ak.yW();
            long R = com.tencent.mm.model.c.wJ().R(atVar);
            v.d("MicroMsg.RecordMsgLogic", g.sm() + " msginfo insert id: " + R);
            if (R < 0) {
                v.e("MicroMsg.RecordMsgLogic", g.sm() + "insert msg failed :" + R);
                return 0 - g.sk();
            }
            Object obj;
            v.i("MicroMsg.RecordMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
            atVar.x(R);
            com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
            aVar.field_xml = atVar.field_content;
            aVar.field_title = a.title;
            aVar.field_type = a.type;
            aVar.field_description = a.description;
            aVar.field_msgId = R;
            am.bnC().b(aVar);
            Iterator it = qfVar.mtR.iterator();
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                if (be.kS(pwVar.mrS)) {
                    if (!be.kS(pwVar.coj)) {
                    }
                }
                obj = 1;
            }
            obj = null;
            if (obj != null) {
                k kVar = new k();
                kVar.field_msgId = R;
                kVar.field_title = a.title;
                kVar.field_desc = a.description;
                kVar.field_toUser = str;
                kVar.field_dataProto = qfVar;
                kVar.field_type = 1;
                kVar.field_localId = new Random().nextInt(2147483645) + 1;
                s.aJD().b(kVar);
                s.aJF().a(kVar);
            } else {
                v.d("MicroMsg.RecordMsgLogic", "do not trans cdn, directly send msg");
                am.bnE();
                al.a.dC(R);
            }
            return 0;
        }
    }

    private static File ct(long j) {
        r2 = new Object[2];
        ak.yW();
        r2[0] = com.tencent.mm.model.c.xf();
        r2[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static void cu(long j) {
        boolean e = com.tencent.mm.a.e.e(ct(j));
        v.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[]{r0.getAbsolutePath(), Boolean.valueOf(e)});
    }

    public static String c(pw pwVar, long j) {
        if (pwVar == null) {
            return "";
        }
        String str = pwVar.luu;
        if (be.kS(str) || !ak.uz()) {
            return "";
        }
        File ct = ct(j);
        if (pwVar.msh != null && pwVar.msh.trim().length() > 0) {
            str = str + "." + pwVar.msh;
        }
        return new File(ct, str).getAbsolutePath();
    }

    public static boolean d(pw pwVar, long j) {
        return new File(c(pwVar, j)).exists();
    }

    public static boolean e(pw pwVar, long j) {
        return new File(f(pwVar, j)).exists();
    }

    public static String f(pw pwVar, long j) {
        if (pwVar == null || be.kS(pwVar.luu)) {
            return "";
        }
        return new File(ct(j), sX(pwVar.luu)).getAbsolutePath();
    }

    public static String sX(String str) {
        return str + "_t";
    }

    public static String c(String str, long j, boolean z) {
        if (z) {
            return str + "@record_download@" + j;
        }
        return str + "@record_upload@" + j;
    }

    public static c yy(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.RecordMsgLogic", "xml is null");
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) cqx.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            v.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            return cVar;
        }
        Map q;
        if (str.trim().startsWith("<recordinfo>")) {
            q = bf.q(str, "recordinfo");
        } else {
            q = bf.q("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (q == null) {
            v.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[]{str});
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) q.get(".recordinfo.title");
        cVar2.desc = (String) q.get(".recordinfo.desc");
        cVar2.lYv = (String) q.get(".recordinfo.favusername");
        try {
            n.a(q, cVar2);
        } catch (Throwable e) {
            v.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
            cVar2.cqE.clear();
        }
        cqx.put(Integer.valueOf(hashCode), cVar2);
        return cVar2;
    }

    public static int oM(int i) {
        if (2 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FILE;
    }

    public static boolean a(pw pwVar, long j, boolean z) {
        if (pwVar == null) {
            v.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            return false;
        }
        String c = c(pwVar.luu, j, true);
        g yx = s.aJE().yx(c);
        if (yx == null) {
            yx = new g();
            yx.field_cdnKey = pwVar.mrU;
            yx.field_cdnUrl = pwVar.mrS;
            yx.field_dataId = pwVar.luu;
            yx.field_mediaId = c;
            yx.field_totalLen = (int) pwVar.msn;
            yx.field_localId = new Random().nextInt(2147483645) + 1;
            yx.field_path = c(pwVar, j);
            yx.field_type = 1;
            yx.field_fileType = oM(pwVar.aKG);
            yx.field_isThumb = false;
            boolean a = s.aJE().a(yx);
            v.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(yx.field_localId), Boolean.valueOf(a)});
        }
        v.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[]{yx});
        if (4 == yx.field_status) {
            v.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(yx.field_errCode)});
            return false;
        }
        if (3 == yx.field_status) {
            v.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(yx.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            yx.field_status = 1;
            s.aJE().b(yx, "localId");
        }
        s.aJG().run();
        return true;
    }

    public static boolean g(pw pwVar, long j) {
        if (pwVar == null) {
            v.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            return true;
        }
        g yx = s.aJE().yx(c(pwVar.luu, j, true));
        if (yx == null) {
            v.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            return false;
        } else if (4 == yx.field_status) {
            v.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[]{Integer.valueOf(yx.field_errCode)});
            return true;
        } else {
            v.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[]{Integer.valueOf(yx.field_status)});
            return false;
        }
    }

    public static boolean b(pw pwVar, long j, boolean z) {
        if (pwVar == null) {
            v.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            return false;
        }
        String sX = sX(pwVar.luu);
        String c = c(sX, j, true);
        g yx = s.aJE().yx(c);
        if (yx == null) {
            yx = new g();
            yx.field_cdnKey = pwVar.mrO;
            yx.field_cdnUrl = pwVar.coj;
            yx.field_dataId = sX;
            yx.field_mediaId = c;
            yx.field_totalLen = (int) pwVar.msy;
            yx.field_localId = new Random().nextInt(2147483645) + 1;
            yx.field_path = f(pwVar, j);
            yx.field_type = 1;
            yx.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            yx.field_isThumb = true;
            boolean a = s.aJE().a(yx);
            v.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(yx.field_localId), Boolean.valueOf(a)});
        }
        v.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[]{yx});
        if (4 == yx.field_status) {
            v.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(yx.field_errCode)});
            return false;
        }
        if (3 == yx.field_status) {
            v.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(yx.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            yx.field_status = 1;
            s.aJE().b(yx, "localId");
        }
        s.aJG().run();
        return true;
    }

    public static String et(String str) {
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null) {
            v.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String tU = LX.tU();
        if (!com.tencent.mm.model.m.dE(tU)) {
            return tU;
        }
        List ej = i.ej(str);
        String xF = k.xF();
        if (ej == null || ej.isEmpty()) {
            v.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            return tU;
        }
        ej.remove(xF);
        ej.add(0, xF);
        return i.b(ej, 3);
    }

    public static boolean h(pw pwVar, long j) {
        return o.JZ(c(pwVar, j));
    }
}
