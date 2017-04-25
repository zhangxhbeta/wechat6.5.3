package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class h {
    public static final Bitmap DL(String str) {
        Bitmap bg = b.box().bg(str);
        if (bg == null) {
            n.AX();
            v.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", d.s(str, false));
            return d.gL(d.s(str, false));
        }
        v.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        return bg;
    }

    public static String DM(String str) {
        ak.yW();
        ab LX = c.wH().LX(str);
        if (!m.dE(str)) {
            return l.a(LX, str);
        }
        String string = aa.getContext().getString(2131231879);
        String a = l.a(LX, str);
        if (LX.field_username.equals(a) || be.kS(a)) {
            return string;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.bhs H(com.tencent.mm.storage.at r9) {
        /*
        r8 = 3;
        r7 = 2;
        r6 = -1;
        r3 = 0;
        r2 = 1;
        r4 = new com.tencent.mm.protocal.c.bhs;
        r4.<init>();
        r0 = r9.field_msgId;
        r4.ncz = r0;
        r0 = r9.field_createTime;
        r4.ncE = r0;
        r4.gll = r2;
        r4.ncF = r2;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x004e;
    L_0x001a:
        r0 = com.tencent.mm.model.k.xF();
        r0 = DM(r0);
        r4.mGq = r0;
        r0 = com.tencent.mm.model.k.xF();
        r4.ncy = r0;
    L_0x002a:
        r0 = 0;
        r1 = r9.isSystem();
        if (r1 == 0) goto L_0x0088;
    L_0x0031:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234107; // 0x7f080d3b float:1.808437E38 double:1.0529695555E-314;
        r0 = r0.getString(r1);
        r4.gll = r8;
    L_0x003e:
        if (r0 != 0) goto L_0x004b;
    L_0x0040:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234106; // 0x7f080d3a float:1.8084368E38 double:1.052969555E-314;
        r0 = r0.getString(r1);
    L_0x004b:
        r4.hQP = r0;
        return r4;
    L_0x004e:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.model.m.dE(r0);
        if (r0 == 0) goto L_0x007b;
    L_0x0056:
        r1 = r9.field_talker;
        r0 = r9.field_content;
        r0 = com.tencent.mm.model.aw.fK(r0);
        if (r0 == r6) goto L_0x042c;
    L_0x0060:
        r5 = r9.field_content;
        r0 = r5.substring(r3, r0);
        r0 = r0.trim();
        if (r0 == 0) goto L_0x042c;
    L_0x006c:
        r5 = r0.length();
        if (r5 <= 0) goto L_0x042c;
    L_0x0072:
        r1 = DM(r0);
        r4.mGq = r1;
        r4.ncy = r0;
        goto L_0x002a;
    L_0x007b:
        r0 = r9.field_talker;
        r0 = DM(r0);
        r4.mGq = r0;
        r0 = r9.field_talker;
        r4.ncy = r0;
        goto L_0x002a;
    L_0x0088:
        r1 = r9.bwj();
        if (r1 == 0) goto L_0x009d;
    L_0x008e:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234087; // 0x7f080d27 float:1.808433E38 double:1.0529695456E-314;
        r0 = r0.getString(r1);
        r1 = 4;
        r4.gll = r1;
        goto L_0x003e;
    L_0x009d:
        r1 = r9.bwm();
        if (r1 == 0) goto L_0x00cd;
    L_0x00a3:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.model.m.dE(r0);
        if (r0 == 0) goto L_0x00c9;
    L_0x00ab:
        r0 = r9.field_isSend;
        if (r0 == r2) goto L_0x00c9;
    L_0x00af:
        r0 = r9.field_content;
        r0 = com.tencent.mm.model.aw.fK(r0);
        if (r0 == r6) goto L_0x00c5;
    L_0x00b7:
        r1 = r9.field_content;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = r0.trim();
        goto L_0x003e;
    L_0x00c5:
        r0 = r9.field_content;
        goto L_0x003e;
    L_0x00c9:
        r0 = r9.field_content;
        goto L_0x003e;
    L_0x00cd:
        r1 = r9.bwb();
        if (r1 == 0) goto L_0x0115;
    L_0x00d3:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234109; // 0x7f080d3d float:1.8084374E38 double:1.0529695565E-314;
        r0 = r0.getString(r1);
        r1 = 6;
        r4.gll = r1;
        r1 = com.tencent.mm.modelvoice.q.y(r9);
        r4.ncF = r1;
        r1 = new com.tencent.mm.modelvoice.n;
        r5 = r9.field_content;
        r1.<init>(r5);
        r6 = r1.time;
        r1 = com.tencent.mm.modelvoice.q.au(r6);
        r5 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r6 = 2131232930; // 0x7f0808a2 float:1.8081983E38 double:1.052968974E-314;
        r2 = new java.lang.Object[r2];
        r1 = (int) r1;
        r1 = java.lang.Integer.valueOf(r1);
        r2[r3] = r1;
        r1 = r5.getString(r6, r2);
        r2 = new com.tencent.mm.ba.b;
        r1 = r1.getBytes();
        r2.<init>(r1);
        r4.ncG = r2;
        goto L_0x003e;
    L_0x0115:
        r1 = r9.bwn();
        if (r1 == 0) goto L_0x0128;
    L_0x011b:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234108; // 0x7f080d3c float:1.8084372E38 double:1.052969556E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x0128:
        r1 = r9.bwo();
        if (r1 == 0) goto L_0x013b;
    L_0x012e:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234105; // 0x7f080d39 float:1.8084366E38 double:1.0529695545E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x013b:
        r1 = r9.bwc();
        if (r1 == 0) goto L_0x017d;
    L_0x0141:
        r1 = r9.field_content;
        r1 = com.tencent.mm.q.a.a.dV(r1);
        if (r1 == 0) goto L_0x003e;
    L_0x0149:
        r0 = r1.cpK;
        r5 = "wxpay://c2cbizmessagehandler/hongbao/receivehongbao";
        r0 = r0.startsWith(r5);
        if (r0 == 0) goto L_0x0163;
    L_0x0154:
        r0 = 5;
        r4.gll = r0;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x015f;
    L_0x015b:
        r0 = r1.cpE;
        goto L_0x003e;
    L_0x015f:
        r0 = r1.cpD;
        goto L_0x003e;
    L_0x0163:
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x017a;
    L_0x0167:
        r0 = r1.cpE;
    L_0x0169:
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234081; // 0x7f080d21 float:1.8084318E38 double:1.0529695427E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r0;
        r0 = r1.getString(r5, r2);
        goto L_0x003e;
    L_0x017a:
        r0 = r1.cpD;
        goto L_0x0169;
    L_0x017d:
        r1 = r9.bwd();
        if (r1 == 0) goto L_0x0193;
    L_0x0183:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234080; // 0x7f080d20 float:1.8084316E38 double:1.052969542E-314;
        r0 = r0.getString(r1);
        r1 = 5;
        r4.gll = r1;
        goto L_0x003e;
    L_0x0193:
        r1 = r9.bvY();
        if (r1 == 0) goto L_0x0301;
    L_0x0199:
        r1 = r9.field_content;
        r1 = com.tencent.mm.q.a.a.dV(r1);
        if (r1 == 0) goto L_0x003e;
    L_0x01a1:
        r5 = r1.type;
        switch(r5) {
            case 2: goto L_0x01a8;
            case 3: goto L_0x01d9;
            case 4: goto L_0x0215;
            case 5: goto L_0x01bb;
            case 6: goto L_0x01f7;
            case 7: goto L_0x01a6;
            case 8: goto L_0x02e7;
            case 9: goto L_0x01a6;
            case 10: goto L_0x026f;
            case 11: goto L_0x01a6;
            case 12: goto L_0x01a6;
            case 13: goto L_0x028d;
            case 14: goto L_0x01a6;
            case 15: goto L_0x0251;
            case 16: goto L_0x02c9;
            case 17: goto L_0x01a6;
            case 18: goto L_0x01a6;
            case 19: goto L_0x0233;
            case 20: goto L_0x02ab;
            default: goto L_0x01a6;
        };
    L_0x01a6:
        goto L_0x003e;
    L_0x01a8:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234087; // 0x7f080d27 float:1.808433E38 double:1.0529695456E-314;
        r0 = r0.getString(r1);
        r1 = new java.lang.Object[r3];
        r0 = java.lang.String.format(r0, r1);
        goto L_0x003e;
    L_0x01bb:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234072; // 0x7f080d18 float:1.80843E38 double:1.052969538E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x01d9:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234075; // 0x7f080d1b float:1.8084305E38 double:1.0529695397E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x01f7:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234071; // 0x7f080d17 float:1.8084297E38 double:1.0529695377E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x0215:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234079; // 0x7f080d1f float:1.8084314E38 double:1.0529695417E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x0233:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234077; // 0x7f080d1d float:1.808431E38 double:1.0529695407E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x0251:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234070; // 0x7f080d16 float:1.8084295E38 double:1.052969537E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x026f:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234076; // 0x7f080d1c float:1.8084308E38 double:1.05296954E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x028d:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234074; // 0x7f080d1a float:1.8084303E38 double:1.052969539E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x02ab:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234078; // 0x7f080d1e float:1.8084312E38 double:1.052969541E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x02c9:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234082; // 0x7f080d22 float:1.808432E38 double:1.052969543E-314;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003e;
    L_0x02e7:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234083; // 0x7f080d23 float:1.8084322E38 double:1.0529695437E-314;
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r6 = "";
        r1 = com.tencent.mm.sdk.platformtools.be.ah(r1, r6);
        r2[r3] = r1;
        r0 = r0.getString(r5, r2);
        goto L_0x003e;
    L_0x0301:
        r1 = r9.bwp();
        if (r1 == 0) goto L_0x037c;
    L_0x0307:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234084; // 0x7f080d24 float:1.8084324E38 double:1.052969544E-314;
        r0 = r0.getString(r1);
        r1 = com.tencent.mm.pluginsdk.j.a.bmr();
        if (r1 == 0) goto L_0x003e;
    L_0x0318:
        r0 = r9.field_imgPath;
        r3 = r1.rg(r0);
        r0 = r3.EB();
        r0 = r1.rk(r0);
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x0359;
    L_0x032c:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234084; // 0x7f080d24 float:1.8084324E38 double:1.052969544E-314;
        r0 = r0.getString(r1);
    L_0x0337:
        r1 = new com.tencent.mm.protocal.c.bhb;
        r1.<init>();
        r5 = r3.EB();
        r1.mpI = r5;
        r3 = r3.bxH();
        if (r3 == 0) goto L_0x0379;
    L_0x0348:
        r1.efm = r2;
    L_0x034a:
        r2 = new com.tencent.mm.ba.b;	 Catch:{ IOException -> 0x0429 }
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x0429 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x0429 }
        r4.ncG = r2;	 Catch:{ IOException -> 0x0429 }
    L_0x0355:
        r4.gll = r7;
        goto L_0x003e;
    L_0x0359:
        r0 = new java.lang.StringBuilder;
        r5 = "[";
        r0.<init>(r5);
        r5 = r3.EB();
        r1 = r1.rk(r5);
        r0 = r0.append(r1);
        r1 = "]";
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x0337;
    L_0x0379:
        r1.efm = r7;
        goto L_0x034a;
    L_0x037c:
        r1 = r9.bwl();
        if (r1 == 0) goto L_0x038f;
    L_0x0382:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234088; // 0x7f080d28 float:1.8084332E38 double:1.052969546E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x038f:
        r1 = r9.bwf();
        if (r1 != 0) goto L_0x03a4;
    L_0x0395:
        r1 = r9.bwg();
        if (r1 != 0) goto L_0x03a4;
    L_0x039b:
        r1 = r9.field_type;
        r5 = 64;
        if (r1 != r5) goto L_0x03d8;
    L_0x03a1:
        r1 = r2;
    L_0x03a2:
        if (r1 == 0) goto L_0x03e9;
    L_0x03a4:
        r0 = r9.field_content;
        r1 = com.tencent.mm.storage.at.nvB;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x03cb;
    L_0x03ae:
        r0 = r9.field_content;
        r1 = new com.tencent.mm.e.a.qi;
        r1.<init>();
        r5 = r1.brC;
        r5.bdn = r2;
        r5 = r1.brC;
        r5.content = r0;
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r0.z(r1);
        r0 = r1.brD;
        r0 = r0.type;
        if (r0 != r8) goto L_0x03da;
    L_0x03c8:
        r0 = r2;
    L_0x03c9:
        if (r0 == 0) goto L_0x03dc;
    L_0x03cb:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234111; // 0x7f080d3f float:1.8084379E38 double:1.0529695575E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x03d8:
        r1 = r3;
        goto L_0x03a2;
    L_0x03da:
        r0 = r3;
        goto L_0x03c9;
    L_0x03dc:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234110; // 0x7f080d3e float:1.8084376E38 double:1.052969557E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x03e9:
        r1 = r9.bwk();
        if (r1 == 0) goto L_0x0415;
    L_0x03ef:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r9.field_content;
        r0 = r0.MU(r1);
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r5 = 2131234082; // 0x7f080d22 float:1.808432E38 double:1.052969543E-314;
        r1 = r1.getString(r5);
        r2 = new java.lang.Object[r2];
        r0 = r0.getDisplayName();
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x003e;
    L_0x0415:
        r1 = r9.field_type;
        r2 = -1879048186; // 0xffffffff90000006 float:-2.5243567E-29 double:NaN;
        if (r1 != r2) goto L_0x003e;
    L_0x041c:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = 2131234073; // 0x7f080d19 float:1.8084301E38 double:1.0529695387E-314;
        r0 = r0.getString(r1);
        goto L_0x003e;
    L_0x0429:
        r1 = move-exception;
        goto L_0x0355;
    L_0x042c:
        r0 = r1;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.h.H(com.tencent.mm.storage.at):com.tencent.mm.protocal.c.bhs");
    }

    public static byte[] A(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean bhO() {
        boolean z;
        try {
            aa.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        v.i("MicroMsg.Wear.WearUtil", "isInstallChinaApp %b", Boolean.valueOf(z));
        return z;
    }

    public static boolean bhP() {
        boolean z;
        try {
            aa.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        v.i("MicroMsg.Wear.WearUtil", "isInstallGlobalApp %b", Boolean.valueOf(z));
        return z;
    }

    public static byte[] DN(String str) {
        return FileOp.c(new File(new File(a.cnf, "lib"), "lib" + str + ".so").getAbsolutePath(), 0, -1);
    }
}
