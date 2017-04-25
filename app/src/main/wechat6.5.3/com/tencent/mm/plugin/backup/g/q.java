package com.tencent.mm.plugin.backup.g;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Map;

public final class q implements l {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.dx r16, boolean r17, com.tencent.mm.storage.at r18, java.lang.String r19, java.util.LinkedList<com.tencent.mm.plugin.backup.f.g> r20) {
        /*
        r15 = this;
        r0 = r18;
        r2 = r0.field_content;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x01e0;
    L_0x000a:
        r2 = 0;
        r10 = r2;
    L_0x000c:
        r0 = r18;
        r2 = r0.field_isSend;
        r3 = 1;
        if (r2 != r3) goto L_0x002b;
    L_0x0013:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r0 = r18;
        r4 = r0.field_msgId;
        r2 = r2.ai(r4);
        r4 = r2.cLu;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 != 0) goto L_0x02eb;
    L_0x002b:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r0 = r18;
        r4 = r0.field_msgSvrId;
        r2 = r2.ah(r4);
        r11 = r2;
    L_0x003c:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r0 = r18;
        r3 = r0.field_imgPath;
        r4 = 1;
        r2 = r2.w(r3, r4);
        r14 = 0;
        r12 = 0;
        r3 = com.tencent.mm.a.e.aR(r2);
        if (r3 == 0) goto L_0x01ec;
    L_0x0055:
        r5 = 1;
        r7 = "_thumb";
        r8 = 0;
        r9 = 0;
        r3 = r16;
        r4 = r20;
        r6 = r17;
        r2 = com.tencent.mm.plugin.backup.g.g.a(r2, r3, r4, r5, r6, r7, r8, r9);
        r13 = r10 + r2;
        r0 = r18;
        r2 = r0.field_isSend;
        r3 = 1;
        if (r2 != r3) goto L_0x01ee;
    L_0x006e:
        r2 = "";
        r3 = com.tencent.mm.plugin.backup.g.b.Vd();
        r3 = r3.GH();
        r4 = r11.cLv;
        r5 = "";
        r6 = "";
        r14 = r3.l(r4, r5, r6);
        r3 = r11.Gp();
        if (r3 == 0) goto L_0x02e7;
    L_0x008b:
        r3 = com.tencent.mm.plugin.backup.g.b.Vd();
        r3 = r3.GH();
        r4 = r11.cLE;
        r3 = r3.fC(r4);
        if (r3 == 0) goto L_0x02e7;
    L_0x009b:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r3 = r3.cLv;
        r4 = "";
        r5 = "";
        r2 = r2.l(r3, r4, r5);
        r3 = "MicroMsg.MMBakItemImg";
        r4 = new java.lang.StringBuilder;
        r5 = "hd bigImgPath ";
        r4.<init>(r5);
        r4 = r4.append(r2);
        r5 = " ";
        r4 = r4.append(r5);
        r5 = com.tencent.mm.a.e.aQ(r2);
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r4);
        r10 = com.tencent.mm.a.e.aQ(r2);
        r3 = com.tencent.mm.a.e.aR(r2);
        if (r3 == 0) goto L_0x02e3;
    L_0x00de:
        r5 = 3;
        r7 = "_hd";
        r8 = 0;
        r9 = 0;
        r3 = r16;
        r4 = r20;
        r6 = r17;
        r3 = com.tencent.mm.plugin.backup.g.g.a(r2, r3, r4, r5, r6, r7, r8, r9);
        r3 = r3 + r13;
        r9 = r10;
        r10 = r3;
    L_0x00f1:
        r11 = com.tencent.mm.a.e.aQ(r14);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r14);
        if (r3 != 0) goto L_0x0135;
    L_0x00fb:
        r2 = r14.equals(r2);
        if (r2 != 0) goto L_0x0135;
    L_0x0101:
        r2 = "MicroMsg.MMBakItemImg";
        r3 = new java.lang.StringBuilder;
        r4 = "bigImgPath ";
        r3.<init>(r4);
        r3 = r3.append(r14);
        r4 = " ";
        r3 = r3.append(r4);
        r4 = com.tencent.mm.a.e.aQ(r14);
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r5 = 2;
        r7 = 0;
        r8 = 0;
        r2 = r14;
        r3 = r16;
        r4 = r20;
        r6 = r17;
        r2 = com.tencent.mm.plugin.backup.g.g.a(r2, r3, r4, r5, r6, r7, r8);
        r10 = r10 + r2;
    L_0x0135:
        r12 = r9;
        r2 = r11;
        r13 = r10;
    L_0x0138:
        r4 = new com.tencent.mm.protocal.c.arf;
        r4.<init>();
        r0 = r18;
        r3 = r0.field_content;
        r3 = com.tencent.mm.plugin.backup.g.g.pe(r3);
        if (r3 != 0) goto L_0x02cd;
    L_0x0147:
        r0 = r18;
        r3 = r0.field_talker;
        r5 = com.tencent.mm.plugin.backup.i.a.dE(r3);
        r3 = "";
        if (r5 == 0) goto L_0x016e;
    L_0x0154:
        r0 = r16;
        r3 = r0.mbU;
        r3 = r3.mQy;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r3 = r5.append(r3);
        r5 = ":";
        r3 = r3.append(r5);
        r3 = r3.toString();
    L_0x016e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r3 = r5.append(r3);
        r5 = "<msg><img length=\"";
        r3 = r3.append(r5);
        r2 = r3.append(r2);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        if (r12 <= 0) goto L_0x01ae;
    L_0x018f:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = " hdlength=\"";
        r2 = r2.append(r3);
        r2 = r2.append(r12);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
    L_0x01ae:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = " /><commenturl></commenturl></msg>";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = "MicroMsg.MMBakItemImg";
        r5 = new java.lang.StringBuilder;
        r6 = "icontent ";
        r5.<init>(r6);
        r5 = r5.append(r2);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r5);
        r4.JF(r2);
    L_0x01db:
        r0 = r16;
        r0.mbW = r4;
    L_0x01df:
        return r13;
    L_0x01e0:
        r0 = r18;
        r2 = r0.field_content;
        r2 = r2.getBytes();
        r2 = r2.length;
        r10 = r2;
        goto L_0x000c;
    L_0x01ec:
        r13 = -1;
        goto L_0x01df;
    L_0x01ee:
        r2 = r11.Go();
        if (r2 == 0) goto L_0x02e0;
    L_0x01f4:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r3 = r11.cLv;
        r4 = "";
        r5 = "";
        r10 = r2.l(r3, r4, r5);
        r2 = "";
        r3 = r11.Gp();
        if (r3 == 0) goto L_0x027d;
    L_0x0211:
        r3 = r11.Gp();
        if (r3 == 0) goto L_0x02ca;
    L_0x0217:
        r3 = com.tencent.mm.plugin.backup.g.b.Vd();
        r3 = r3.GH();
        r4 = r11.cLE;
        r3 = r3.fC(r4);
        if (r3 == 0) goto L_0x02ca;
    L_0x0227:
        if (r3 == 0) goto L_0x027d;
    L_0x0229:
        r4 = r3.equals(r11);
        if (r4 != 0) goto L_0x027d;
    L_0x022f:
        r2 = com.tencent.mm.plugin.backup.g.b.Vd();
        r2 = r2.GH();
        r3 = r3.cLv;
        r4 = "";
        r5 = "";
        r2 = r2.l(r3, r4, r5);
        r3 = "MicroMsg.MMBakItemImg";
        r4 = new java.lang.StringBuilder;
        r5 = "hdPath ";
        r4.<init>(r5);
        r4 = r4.append(r2);
        r5 = " ";
        r4 = r4.append(r5);
        r5 = com.tencent.mm.a.e.aQ(r2);
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r4);
        r5 = 3;
        r7 = "_hd";
        r8 = 0;
        r9 = 0;
        r3 = r16;
        r4 = r20;
        r6 = r17;
        r3 = com.tencent.mm.plugin.backup.g.g.a(r2, r3, r4, r5, r6, r7, r8, r9);
        r13 = r13 + r3;
        r12 = com.tencent.mm.a.e.aQ(r2);
    L_0x027d:
        r3 = com.tencent.mm.a.e.aR(r10);
        if (r3 == 0) goto L_0x02e0;
    L_0x0283:
        r9 = com.tencent.mm.a.e.aQ(r10);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r10);
        if (r3 != 0) goto L_0x02dd;
    L_0x028d:
        r2 = r10.equals(r2);
        if (r2 != 0) goto L_0x02dd;
    L_0x0293:
        r2 = "MicroMsg.MMBakItemImg";
        r3 = new java.lang.StringBuilder;
        r4 = "path ";
        r3.<init>(r4);
        r3 = r3.append(r10);
        r4 = " ";
        r3 = r3.append(r4);
        r4 = com.tencent.mm.a.e.aQ(r10);
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r5 = 2;
        r7 = 0;
        r8 = 0;
        r2 = r10;
        r3 = r16;
        r4 = r20;
        r6 = r17;
        r2 = com.tencent.mm.plugin.backup.g.g.a(r2, r3, r4, r5, r6, r7, r8);
        r13 = r13 + r2;
        r2 = r9;
        goto L_0x0138;
    L_0x02ca:
        r3 = r11;
        goto L_0x0227;
    L_0x02cd:
        r0 = r18;
        r2 = r0.field_content;
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.be.ah(r2, r3);
        r4.JF(r2);
        goto L_0x01db;
    L_0x02dd:
        r2 = r9;
        goto L_0x0138;
    L_0x02e0:
        r2 = r14;
        goto L_0x0138;
    L_0x02e3:
        r9 = r10;
        r10 = r13;
        goto L_0x00f1;
    L_0x02e7:
        r9 = r12;
        r10 = r13;
        goto L_0x00f1;
    L_0x02eb:
        r11 = r2;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.q.a(com.tencent.mm.protocal.c.dx, boolean, com.tencent.mm.storage.at, java.lang.String, java.util.LinkedList):int");
    }

    public final int a(String str, dx dxVar, at atVar) {
        if (dxVar.mbW == null) {
            v.d("MicroMsg.MMBakItemImg", "bakitem.getContent() is null");
            return 0;
        }
        int i;
        String str2;
        d ah;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(be.ah(dxVar.mbW.mQy, SQLiteDatabase.KeyEmpty));
        v.d("MicroMsg.MMBakItemImg", "msg" + dxVar.mcb + " " + str5);
        String str6 = "MicroMsg.MMBakItemImg";
        String str7 = "bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (dxVar.meT == null) {
            i = 0;
        } else {
            i = dxVar.meT.mQu;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(dxVar.meV);
        if (dxVar.meS == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        } else {
            str2 = dxVar.meS.toString();
        }
        objArr[2] = str2;
        if (dxVar.meR == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        } else {
            str2 = dxVar.meR.toString();
        }
        objArr[3] = str2;
        v.d(str6, str7, objArr);
        d dVar = null;
        atVar.setContent(str5);
        f GH = b.Vd().GH();
        if (atVar.field_isSend == 1) {
            if (atVar.field_msgId != 0) {
                dVar = GH.ai(atVar.field_msgId);
            }
            if (dVar == null || dVar.cLu == 0) {
                ah = GH.ah(atVar.field_msgSvrId);
            } else {
                ah = dVar;
            }
        } else {
            ah = GH.ah(atVar.field_msgSvrId);
        }
        Map q = bf.q(str5, "msg");
        if (q == null || Integer.valueOf(be.ah((String) q.get(".msg.img.$hdlength"), "0")).intValue() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String ah2 = be.ah(g.a(dxVar, 3), SQLiteDatabase.KeyEmpty);
        if (dxVar.meV == 3) {
            e.a(b.Vj() + "mmbakMeida/" + g.pd(ah2), ah2, dxVar.meT.mQw.lVU);
        }
        str2 = be.ah(g.a(dxVar, 2), SQLiteDatabase.KeyEmpty);
        if (dxVar.meV == 2) {
            e.a(b.Vj() + "mmbakMeida/" + g.pd(str2), str2, dxVar.meT.mQw.lVU);
        }
        v.d("MicroMsg.MMBakItemImg", "hdName %s, imgName:%s", ah2, str2);
        if (be.kS(str2)) {
            str3 = ah2;
        } else {
            str3 = str2;
        }
        byte[] d = g.d(dxVar, 1);
        if (d == null) {
            v.i("MicroMsg.MMBakItemImg", "getThumbBuf is null and read from mediapath");
            str2 = g.pc(str3);
            String m = g.m((System.currentTimeMillis() + " ").getBytes());
            str6 = b.Vj() + "mmbakMeida/" + g.pd(m);
            str4 = str6 + m;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int JT = com.tencent.mm.sdk.platformtools.d.JT(str4);
            if (JT > 0) {
                if (!com.tencent.mm.sdk.platformtools.d.a(str2, CompressFormat.JPEG, str4, JT)) {
                    v.e("MicroMsg.MMBakItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                v.d("MicroMsg.MMBakItemImg", "insert: thumbName = " + m);
            } else {
                v.e("MicroMsg.MMBakItemImg", "createThumbNail failed");
                return -1;
            }
            d = e.d(str4, 0, -1);
        } else {
            v.i("MicroMsg.MMBakItemImg", "getThumbBuf len:%d", Integer.valueOf(d.length));
        }
        if (d == null) {
            v.e("MicroMsg.MMBakItemImg", "img buf is null");
            return -1;
        }
        String l = GH.l(ah2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        String l2 = GH.l(str3, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        long j = 0;
        if (ah.cLu == 0) {
            if (obj != null) {
                f fVar = GH;
                str4 = ah2;
                j = fVar.a(d, dxVar.mcb, true, str4, g.c(dxVar, 3), SQLiteDatabase.KeyEmpty, new PString(), new PInt(), new PInt());
                if (!g.b(dxVar, 3, l)) {
                    v.e("MicroMsg.MMBakItemImg", "writeItem MMBAK_HD_IMG failed:%s", l);
                }
            }
            long j2 = j;
            int c = g.c(dxVar, 2);
            if (c <= 0) {
                c = g.c(dxVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = GH.a(d, dxVar.mcb, false, str3, c, SQLiteDatabase.KeyEmpty, pString, pInt, pInt2);
            if (!g.b(dxVar, 2, l2)) {
                v.e("MicroMsg.MMBakItemImg", "writeItem MMBAK_IMG failed:%s", l);
            }
            if (a <= 0) {
                return -1;
            }
            atVar.cI(pString.value);
            atVar.dt(pInt.value);
            atVar.du(pInt2.value);
            if (j2 > 0) {
                d b = b.Vd().GH().b(Long.valueOf(a));
                b.fy((int) j2);
                b.Vd().GH().a(Long.valueOf(a), b);
            }
        } else {
            str2 = ah.cLx;
            if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                atVar.cI("THUMBNAIL://" + ah.cLu);
            } else {
                atVar.cI(str2);
            }
        }
        a.e(atVar);
        return 0;
    }
}
