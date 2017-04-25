package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.bf.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;

public final class h {
    private static WeakReference<TextPaint> cap;
    private static int caq = 0;
    private static int car = 0;
    public String can = SQLiteDatabase.KeyEmpty;
    public String cao = SQLiteDatabase.KeyEmpty;
    public String mTitle = SQLiteDatabase.KeyEmpty;

    public static String a(Context context, String str, String str2, int i) {
        return e.HP(b.buL().Lk(a(0, str2, str, i, context)));
    }

    public static String f(Context context, String str, String str2) {
        String fL;
        if (m.dE(str)) {
            fL = aw.fL(str2);
            if (fL != null) {
                fL = l.er(fL.trim());
            } else {
                fL = l.er(str);
            }
        } else {
            fL = l.er(str);
        }
        if (str.contains("@bottle")) {
            return context.getResources().getQuantityString(2131361812, 1, new Object[]{Integer.valueOf(1)});
        }
        if (be.kS(fL) && m.dE(str)) {
            fL = context.getString(2131231879);
        }
        return b.buL().Lk(fL);
    }

    public static String b(u uVar) {
        Context context = aa.getContext();
        if (uVar == null) {
            return context.getString(2131231544);
        }
        String city;
        if (RegionCodeDecoder.Nn(uVar.getCountryCode())) {
            city = uVar.getCity();
            if (!be.kS(city)) {
                return city;
            }
            city = l.eu(uVar.getProvince());
            if (!be.kS(city)) {
                return city;
            }
            RegionCodeDecoder.bxc();
            return RegionCodeDecoder.getLocName(uVar.getCountryCode());
        }
        city = l.eu(uVar.getProvince());
        return be.kS(city) ? context.getString(2131231544) : city;
    }

    public static String b(at atVar, PString pString, PString pString2, PInt pInt, boolean z) {
        return be.ma(a(atVar.field_imgPath, atVar.field_isSend, atVar.field_talker, e.HP(atVar.bwi() ? atVar.bwC() : atVar.field_content), atVar.field_type, aa.getContext(), pString, pString2, pInt, true, z));
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        return be.ma(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, android.content.Context r23, com.tencent.mm.pointers.PString r24, com.tencent.mm.pointers.PString r25, com.tencent.mm.pointers.PInt r26, boolean r27, boolean r28) {
        /*
        r5 = "context is null";
        if (r23 == 0) goto L_0x0033;
    L_0x0005:
        r4 = 1;
    L_0x0006:
        junit.framework.Assert.assertTrue(r5, r4);
        r5 = "username is null";
        if (r20 == 0) goto L_0x0035;
    L_0x000e:
        r4 = r20.length();
        if (r4 <= 0) goto L_0x0035;
    L_0x0014:
        r4 = 1;
    L_0x0015:
        junit.framework.Assert.assertTrue(r5, r4);
        if (r27 != 0) goto L_0x0055;
    L_0x001a:
        r4 = com.tencent.mm.model.m.eI(r20);
        if (r4 == 0) goto L_0x0037;
    L_0x0020:
        r4 = com.tencent.mm.model.k.xY();
        if (r4 != 0) goto L_0x0037;
    L_0x0026:
        r4 = 1;
    L_0x0027:
        if (r4 == 0) goto L_0x0055;
    L_0x0029:
        r4 = 2131235097; // 0x7f081119 float:1.8086378E38 double:1.0529700446E-314;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0032:
        return r4;
    L_0x0033:
        r4 = 0;
        goto L_0x0006;
    L_0x0035:
        r4 = 0;
        goto L_0x0015;
    L_0x0037:
        r4 = com.tencent.mm.model.m.eK(r20);
        if (r4 == 0) goto L_0x0045;
    L_0x003d:
        r4 = com.tencent.mm.model.k.xR();
        if (r4 != 0) goto L_0x0045;
    L_0x0043:
        r4 = 1;
        goto L_0x0027;
    L_0x0045:
        r4 = com.tencent.mm.model.m.eO(r20);
        if (r4 == 0) goto L_0x0053;
    L_0x004b:
        r4 = com.tencent.mm.model.k.yb();
        if (r4 != 0) goto L_0x0053;
    L_0x0051:
        r4 = 1;
        goto L_0x0027;
    L_0x0053:
        r4 = 0;
        goto L_0x0027;
    L_0x0055:
        r16 = 0;
        r15 = 0;
        r4 = com.tencent.mm.model.m.eO(r20);
        if (r4 == 0) goto L_0x00ce;
    L_0x005e:
        if (r27 == 0) goto L_0x0064;
    L_0x0060:
        r4 = "";
        goto L_0x0032;
    L_0x0064:
        r5 = com.tencent.mm.model.k.yb();
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.vf();
        r6 = 65793; // 0x10101 float:9.2196E-41 double:3.2506E-319;
        r7 = 0;
        r4 = r4.get(r6, r7);
        r4 = (java.lang.Long) r4;
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.a(r4, r6);
        if (r5 != 0) goto L_0x008b;
    L_0x0081:
        r4 = 2131235097; // 0x7f081119 float:1.8086378E38 double:1.0529700446E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0032;
    L_0x008b:
        r4 = 0;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x009b;
    L_0x0091:
        r4 = 2131232914; // 0x7f080892 float:1.808195E38 double:1.052968966E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0032;
    L_0x009b:
        r4 = com.tencent.mm.sdk.platformtools.be.ax(r6);
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r8;
        r8 = 1209600000; // 0x48190800 float:156704.0 double:5.97621805E-315;
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x00c9;
    L_0x00a9:
        r4 = 2131232913; // 0x7f080891 float:1.8081949E38 double:1.0529689656E-314;
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.ax(r6);
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r10;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = r6 / r10;
        r6 = java.lang.Long.valueOf(r6);
        r5[r8] = r6;
        r0 = r23;
        r4 = r0.getString(r4, r5);
        goto L_0x0032;
    L_0x00c9:
        r4 = "";
        goto L_0x0032;
    L_0x00ce:
        r14 = "";
        r6 = "";
        r5 = "";
        r4 = 0;
        if (r21 == 0) goto L_0x12ea;
    L_0x00da:
        if (r27 == 0) goto L_0x12ea;
    L_0x00dc:
        r4 = 1;
        r21 = dj(r21);
        r11 = r4;
    L_0x00e2:
        r0 = r21;
        r1 = r24;
        r1.value = r0;
        if (r19 != 0) goto L_0x12e4;
    L_0x00ea:
        r4 = com.tencent.mm.model.m.dE(r20);
        if (r4 == 0) goto L_0x12e4;
    L_0x00f0:
        r4 = com.tencent.mm.model.aw.fK(r21);
        if (r4 <= 0) goto L_0x12e4;
    L_0x00f6:
        r5 = 0;
        r0 = r21;
        r5 = r0.substring(r5, r4);
        r6 = r5.trim();
        r0 = r20;
        r5 = com.tencent.mm.model.l.D(r6, r0);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r21;
        r7 = r7.append(r0);
        r8 = " ";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r4 = r4 + 1;
        r4 = r7.substring(r4);
        r12 = r5;
        r13 = r6;
    L_0x0125:
        r5 = 0;
        r6 = com.tencent.mm.model.m.fc(r20);
        if (r6 != 0) goto L_0x0132;
    L_0x012c:
        r6 = com.tencent.mm.model.m.fm(r20);
        if (r6 == 0) goto L_0x0173;
    L_0x0132:
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x0151;
    L_0x013e:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
    L_0x0151:
        r17 = r5;
        r7 = r21;
    L_0x0155:
        switch(r22) {
            case -1879048191: goto L_0x0381;
            case -1879048190: goto L_0x0381;
            case -1879048189: goto L_0x0381;
            case -1879048188: goto L_0x03d5;
            case -1879048186: goto L_0x0978;
            case -1879048185: goto L_0x09e9;
            case -1879048183: goto L_0x09e9;
            case -1879048176: goto L_0x09e9;
            case 3: goto L_0x01b1;
            case 11: goto L_0x0252;
            case 13: goto L_0x0234;
            case 23: goto L_0x01b1;
            case 33: goto L_0x01b1;
            case 34: goto L_0x0268;
            case 35: goto L_0x04a7;
            case 36: goto L_0x0252;
            case 37: goto L_0x03e6;
            case 39: goto L_0x0234;
            case 40: goto L_0x0472;
            case 42: goto L_0x04dd;
            case 43: goto L_0x02ec;
            case 47: goto L_0x01f1;
            case 48: goto L_0x05a0;
            case 49: goto L_0x0a35;
            case 50: goto L_0x0392;
            case 52: goto L_0x03c4;
            case 53: goto L_0x0392;
            case 55: goto L_0x0fe3;
            case 57: goto L_0x0fe3;
            case 62: goto L_0x02ec;
            case 1048625: goto L_0x01f1;
            case 12299999: goto L_0x0370;
            case 16777265: goto L_0x0a35;
            case 268435505: goto L_0x0a35;
            case 285212721: goto L_0x0fb9;
            case 318767153: goto L_0x0fd2;
            case 335544369: goto L_0x05fe;
            case 369098801: goto L_0x07d7;
            case 402653233: goto L_0x0653;
            case 419430449: goto L_0x0697;
            case 436207665: goto L_0x0728;
            case 452984881: goto L_0x0838;
            case 469762097: goto L_0x0728;
            case 486539313: goto L_0x0fb9;
            case 503316529: goto L_0x0ff6;
            case 520093745: goto L_0x08dc;
            default: goto L_0x0158;
        };
    L_0x0158:
        r4 = r14;
        r5 = r15;
        r6 = r16;
    L_0x015c:
        r8 = com.tencent.mm.model.m.eJ(r20);
        if (r8 == 0) goto L_0x111b;
    L_0x0162:
        r5 = 1;
        r0 = r19;
        if (r5 != r0) goto L_0x104e;
    L_0x0167:
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r5 != 0) goto L_0x102d;
    L_0x016d:
        r0 = r24;
        r0.value = r4;
        goto L_0x0032;
    L_0x0173:
        com.tencent.mm.model.ak.yW();
        r6 = com.tencent.mm.model.c.wK();
        r0 = r20;
        r6 = r6.Mh(r0);
        if (r6 == 0) goto L_0x018a;
    L_0x0182:
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r6 = r6.el(r7);
        if (r6 != 0) goto L_0x018c;
    L_0x018a:
        if (r28 == 0) goto L_0x12de;
    L_0x018c:
        r5 = 1;
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x12de;
    L_0x0199:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
        r17 = r5;
        r7 = r21;
        goto L_0x0155;
    L_0x01b1:
        r4 = 2131231122; // 0x7f080192 float:1.8078316E38 double:1.0529680807E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x01e9;
    L_0x01c0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x01d4:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x01ed;
    L_0x01da:
        r5 = "%s: ";
    L_0x01dd:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x01e9:
        r4 = "";
        goto L_0x01d4;
    L_0x01ed:
        r5 = "";
        goto L_0x01dd;
    L_0x01f1:
        r5 = com.tencent.mm.storage.ag.Mv(r7);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r5.dhC;
        r4 = r4.append(r6);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.toString();
        if (r18 == 0) goto L_0x022a;
    L_0x020d:
        r6 = r18.length();
        r7 = 32;
        if (r6 != r7) goto L_0x022a;
    L_0x0215:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r5 = r5.dhC;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x022a:
        r6 = 2131231031; // 0x7f080137 float:1.8078132E38 double:1.052968036E-314;
        r0 = r23;
        r18 = r0.getString(r6);
        goto L_0x0215;
    L_0x0234:
        r4 = 2131231122; // 0x7f080192 float:1.8078316E38 double:1.0529680807E-314;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0252:
        r8 = 0;
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0268:
        r4 = com.tencent.mm.storage.u.LH(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x026e:
        r4 = com.tencent.mm.storage.u.LJ(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x0274:
        r4 = com.tencent.mm.model.m.eI(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x027a:
        r4 = com.tencent.mm.model.m.eK(r20);
        if (r4 == 0) goto L_0x029e;
    L_0x0280:
        r4 = 2131231177; // 0x7f0801c9 float:1.8078428E38 double:1.052968108E-314;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x029e:
        if (r7 == 0) goto L_0x02da;
    L_0x02a0:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x02da;
    L_0x02a6:
        r4 = com.tencent.mm.model.m.eJ(r20);
        if (r4 != 0) goto L_0x02da;
    L_0x02ac:
        r4 = com.tencent.mm.model.m.dE(r20);
        if (r4 == 0) goto L_0x02e8;
    L_0x02b2:
        r4 = new com.tencent.mm.modelvoice.n;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.dhC;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.dhC;
        r0 = r25;
        r0.value = r4;
    L_0x02da:
        r4 = 2131231177; // 0x7f0801c9 float:1.8078428E38 double:1.052968108E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x02e8:
        r7 = "";
        goto L_0x02da;
    L_0x02ec:
        r4 = com.tencent.mm.storage.u.LH(r20);
        if (r4 != 0) goto L_0x0304;
    L_0x02f2:
        r4 = com.tencent.mm.storage.u.LJ(r20);
        if (r4 != 0) goto L_0x0304;
    L_0x02f8:
        r4 = com.tencent.mm.model.m.eI(r20);
        if (r4 != 0) goto L_0x0304;
    L_0x02fe:
        r4 = com.tencent.mm.model.m.eK(r20);
        if (r4 == 0) goto L_0x0322;
    L_0x0304:
        r4 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0322:
        if (r7 == 0) goto L_0x035e;
    L_0x0324:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x035e;
    L_0x032a:
        r4 = com.tencent.mm.model.m.eJ(r20);
        if (r4 != 0) goto L_0x035e;
    L_0x0330:
        r4 = com.tencent.mm.model.m.dE(r20);
        if (r4 == 0) goto L_0x036c;
    L_0x0336:
        r4 = new com.tencent.mm.as.l;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.dhC;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.dhC;
        r0 = r25;
        r0.value = r4;
    L_0x035e:
        r4 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x036c:
        r7 = "";
        goto L_0x035e;
    L_0x0370:
        r7 = "";
        r4 = 2131231180; // 0x7f0801cc float:1.8078434E38 double:1.0529681094E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x0381:
        r7 = "";
        r4 = 2131231179; // 0x7f0801cb float:1.8078432E38 double:1.052968109E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x0392:
        r4 = com.tencent.mm.storage.at.nvC;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x03ab;
    L_0x039a:
        r7 = "";
        r4 = 2131231180; // 0x7f0801cc float:1.8078434E38 double:1.0529681094E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x03ab:
        r4 = com.tencent.mm.storage.at.nvB;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0158;
    L_0x03b3:
        r7 = "";
        r4 = 2131231181; // 0x7f0801cd float:1.8078436E38 double:1.05296811E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x03c4:
        r7 = "";
        r4 = 2131231180; // 0x7f0801cc float:1.8078434E38 double:1.0529681094E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x03d5:
        r7 = "";
        r4 = 2131231181; // 0x7f0801cd float:1.8078436E38 double:1.05296811E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x03e6:
        if (r7 == 0) goto L_0x0158;
    L_0x03e8:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x0158;
    L_0x03ee:
        r4 = com.tencent.mm.storage.at.d.MB(r7);
        r5 = r4.lct;
        if (r5 == 0) goto L_0x041a;
    L_0x03f6:
        r5 = r4.lct;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x041a;
    L_0x03fe:
        r5 = r4.scene;
        switch(r5) {
            case 18: goto L_0x0420;
            case 19: goto L_0x0403;
            case 20: goto L_0x0403;
            case 21: goto L_0x0403;
            case 22: goto L_0x043a;
            case 23: goto L_0x043a;
            case 24: goto L_0x043a;
            case 25: goto L_0x0454;
            case 26: goto L_0x043a;
            case 27: goto L_0x043a;
            case 28: goto L_0x043a;
            case 29: goto L_0x043a;
            default: goto L_0x0403;
        };
    L_0x0403:
        r5 = 2131232938; // 0x7f0808aa float:1.8082E38 double:1.052968978E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x041a:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x0420:
        r5 = 2131232919; // 0x7f080897 float:1.808196E38 double:1.0529689686E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x043a:
        r5 = 2131232929; // 0x7f0808a1 float:1.8081981E38 double:1.0529689735E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0454:
        r5 = 2131232859; // 0x7f08085b float:1.808184E38 double:1.052968939E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0472:
        if (r7 == 0) goto L_0x0158;
    L_0x0474:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x0158;
    L_0x047a:
        r4 = com.tencent.mm.storage.at.a.My(r7);
        r5 = r4.lct;
        if (r5 == 0) goto L_0x04a1;
    L_0x0482:
        r5 = r4.lct;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x04a1;
    L_0x048a:
        r5 = 2131232878; // 0x7f08086e float:1.8081878E38 double:1.0529689483E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x04a1:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x04a7:
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0158;
    L_0x04b1:
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.wJ();
        r4 = r4.MS(r7);
        r5 = 2131232912; // 0x7f080890 float:1.8081947E38 double:1.052968965E-314;
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r4.cYw;
        r6[r7] = r8;
        r7 = 1;
        r4 = r4.title;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x04dd:
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0158;
    L_0x04e7:
        r4 = com.tencent.mm.model.m.dE(r20);
        if (r4 == 0) goto L_0x04f7;
    L_0x04ed:
        r4 = com.tencent.mm.model.aw.fL(r7);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 == 0) goto L_0x04f9;
    L_0x04f7:
        r4 = r20;
    L_0x04f9:
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.wJ();
        r6 = r5.MU(r7);
        com.tencent.mm.model.ak.yW();
        r5 = com.tencent.mm.model.c.wH();
        r5 = r5.LX(r4);
        r5 = r5.tU();
        r7 = com.tencent.mm.model.m.dE(r5);
        if (r7 == 0) goto L_0x0521;
    L_0x0519:
        r5 = com.tencent.mm.model.i.em(r5);
        r5 = com.tencent.mm.model.i.t(r5);
    L_0x0521:
        r7 = 1;
        r0 = r19;
        if (r0 != r7) goto L_0x0563;
    L_0x0526:
        r7 = 2131232860; // 0x7f08085c float:1.8081841E38 double:1.0529689394E-314;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = 2131232860; // 0x7f08085c float:1.8081841E38 double:1.0529689394E-314;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x0563:
        r7 = 2131232861; // 0x7f08085d float:1.8081843E38 double:1.05296894E-314;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = 2131232861; // 0x7f08085d float:1.8081843E38 double:1.05296894E-314;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x05a0:
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0158;
    L_0x05aa:
        r4 = com.tencent.mm.model.m.dE(r20);
        if (r4 == 0) goto L_0x12da;
    L_0x05b0:
        r4 = com.tencent.mm.model.aw.fK(r7);
        r5 = -1;
        if (r4 == r5) goto L_0x12d6;
    L_0x05b7:
        r5 = 0;
        r4 = r7.substring(r5, r4);
        r4 = r4.trim();
    L_0x05c0:
        com.tencent.mm.model.aw.fM(r7);
        r5 = r4;
    L_0x05c4:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x05dd;
    L_0x05c9:
        r4 = 2131233523; // 0x7f080af3 float:1.8083186E38 double:1.052969267E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x05dd:
        r4 = 2131233523; // 0x7f080af3 float:1.8083186E38 double:1.052969267E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r6 = 2131233523; // 0x7f080af3 float:1.8083186E38 double:1.052969267E-314;
        r0 = r23;
        r6 = r0.getString(r6);
        r0 = r24;
        r0.value = r6;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x05fe:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r4 = com.tencent.mm.q.a.a.dV(r4);
        r5 = r4.cox;
        if (r5 == 0) goto L_0x0649;
    L_0x060a:
        r5 = r4.cox;
        r6 = 1;
        if (r5 != r6) goto L_0x062b;
    L_0x060f:
        r4 = 2131234785; // 0x7f080fe1 float:1.8085746E38 double:1.0529698905E-314;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0618:
        r7 = "";
        r0 = r25;
        r0.value = r13;
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x062b:
        r5 = r4.cox;
        r6 = 2;
        if (r5 != r6) goto L_0x063a;
    L_0x0630:
        r4 = 2131234787; // 0x7f080fe3 float:1.808575E38 double:1.0529698915E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0618;
    L_0x063a:
        r4 = r4.cox;
        r5 = 3;
        if (r4 != r5) goto L_0x0649;
    L_0x063f:
        r4 = 2131234786; // 0x7f080fe2 float:1.8085748E38 double:1.052969891E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0618;
    L_0x0649:
        r4 = 2131234788; // 0x7f080fe4 float:1.8085752E38 double:1.052969892E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0618;
    L_0x0653:
        r5 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.q.a.a.dV(r5);
        if (r5 == 0) goto L_0x068b;
    L_0x0663:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = 2131234797; // 0x7f080fed float:1.808577E38 double:1.0529698964E-314;
        r0 = r23;
        r6 = r0.getString(r6);
        r4 = r4.append(r6);
        r5 = r5.title;
        r5 = com.tencent.mm.sdk.platformtools.be.ma(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
    L_0x068b:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0697:
        r5 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.q.a.a.dV(r5);
        if (r5 == 0) goto L_0x06c0;
    L_0x06a7:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x06cc;
    L_0x06ac:
        r4 = 1;
    L_0x06ad:
        r6 = r5.cpe;
        switch(r6) {
            case 1: goto L_0x06ce;
            case 2: goto L_0x06b2;
            case 3: goto L_0x06ec;
            case 4: goto L_0x070a;
            default: goto L_0x06b2;
        };
    L_0x06b2:
        r4 = r5.title;
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r4);
        r0 = r24;
        r0.value = r4;
    L_0x06bc:
        r0 = r24;
        r4 = r0.value;
    L_0x06c0:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x06cc:
        r4 = 0;
        goto L_0x06ad;
    L_0x06ce:
        if (r4 == 0) goto L_0x06de;
    L_0x06d0:
        r4 = 2131231191; // 0x7f0801d7 float:1.8078456E38 double:1.052968115E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x06de:
        r4 = 2131231194; // 0x7f0801da float:1.8078462E38 double:1.0529681163E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x06ec:
        if (r4 == 0) goto L_0x06fc;
    L_0x06ee:
        r4 = 2131231192; // 0x7f0801d8 float:1.8078458E38 double:1.0529681153E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x06fc:
        r4 = 2131231189; // 0x7f0801d5 float:1.8078452E38 double:1.052968114E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x070a:
        if (r4 == 0) goto L_0x071a;
    L_0x070c:
        r4 = 2131231193; // 0x7f0801d9 float:1.807846E38 double:1.052968116E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x071a:
        r4 = 2131231190; // 0x7f0801d6 float:1.8078454E38 double:1.0529681143E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06bc;
    L_0x0728:
        r5 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.q.a.a.dV(r5);
        if (r5 == 0) goto L_0x0767;
    L_0x0738:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x077b;
    L_0x073d:
        r4 = 1;
    L_0x073e:
        if (r4 == 0) goto L_0x077d;
    L_0x0740:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.cpH;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.cpE;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x0763:
        r0 = r24;
        r4 = r0.value;
    L_0x0767:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x12ce;
    L_0x076d:
        if (r17 != 0) goto L_0x12ce;
    L_0x076f:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x077b:
        r4 = 0;
        goto L_0x073e;
    L_0x077d:
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r12);
        if (r4 != 0) goto L_0x07b3;
    L_0x0783:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.sdk.platformtools.be.ma(r12);
        r4 = r4.append(r6);
        r6 = ": [";
        r4 = r4.append(r6);
        r6 = r5.cpH;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.cpD;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0763;
    L_0x07b3:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.cpH;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.cpD;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0763;
    L_0x07d7:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r4 = com.tencent.mm.q.a.a.dV(r4);
        r4 = r4.cox;
        switch(r4) {
            case 10000: goto L_0x0820;
            case 20000: goto L_0x082a;
            default: goto L_0x07e4;
        };
    L_0x07e4:
        r4 = 2131231126; // 0x7f080196 float:1.8078324E38 double:1.0529680827E-314;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x07ed:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0834;
    L_0x07f3:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r6 = ": ";
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0807:
        r6 = com.tencent.mm.model.m.fc(r20);
        if (r6 != 0) goto L_0x0813;
    L_0x080d:
        if (r17 != 0) goto L_0x0813;
    L_0x080f:
        r0 = r25;
        r0.value = r13;
    L_0x0813:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015c;
    L_0x0820:
        r4 = 2131231127; // 0x7f080197 float:1.8078326E38 double:1.052968083E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x07ed;
    L_0x082a:
        r4 = 2131231129; // 0x7f080199 float:1.807833E38 double:1.052968084E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x07ed;
    L_0x0834:
        r5 = "";
        goto L_0x0807;
    L_0x0838:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r5 = com.tencent.mm.q.a.a.dV(r4);
        if (r5 != 0) goto L_0x0850;
    L_0x0842:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        r4 = "";
        goto L_0x0032;
    L_0x0850:
        r18 = "";
        r4 = 2131231658; // 0x7f0803aa float:1.8079403E38 double:1.0529683455E-314;
        r0 = r23;
        r6 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x08b4;
    L_0x0862:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
    L_0x0880:
        r7 = com.tencent.mm.model.m.fc(r20);
        if (r7 != 0) goto L_0x088c;
    L_0x0886:
        if (r17 != 0) goto L_0x088c;
    L_0x0888:
        r0 = r25;
        r0.value = r13;
    L_0x088c:
        r7 = r13.length();
        if (r7 <= 0) goto L_0x08c8;
    L_0x0892:
        r7 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r7.<init>(r8);
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x08a8:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x08b4:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x0880;
    L_0x08c8:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
        goto L_0x08a8;
    L_0x08dc:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r4 = com.tencent.mm.q.a.a.dV(r4);
        if (r4 != 0) goto L_0x08f4;
    L_0x08e6:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        r4 = "";
        goto L_0x0032;
    L_0x08f4:
        r18 = "";
        r5 = 2131231658; // 0x7f0803aa float:1.8079403E38 double:1.0529683455E-314;
        r0 = r23;
        r5 = r0.getString(r5);
        r6 = 1;
        r0 = r19;
        if (r0 != r6) goto L_0x0948;
    L_0x0905:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.cpu;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0946;
    L_0x091e:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x092e:
        r0 = r24;
        r0.value = r4;
    L_0x0932:
        r4 = com.tencent.mm.model.m.fc(r20);
        if (r4 != 0) goto L_0x12c6;
    L_0x0938:
        if (r17 != 0) goto L_0x12c6;
    L_0x093a:
        r0 = r25;
        r0.value = r13;
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015c;
    L_0x0946:
        r4 = r5;
        goto L_0x092e;
    L_0x0948:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.cpu;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0976;
    L_0x0961:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0971:
        r0 = r24;
        r0.value = r4;
        goto L_0x0932;
    L_0x0976:
        r4 = r5;
        goto L_0x0971;
    L_0x0978:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r5 = com.tencent.mm.q.a.a.dV(r4);
        if (r5 != 0) goto L_0x0990;
    L_0x0982:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        r4 = "";
        goto L_0x0032;
    L_0x0990:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x09e3;
    L_0x0999:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r6 = r5.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x09b3:
        r6 = com.tencent.mm.model.m.fc(r20);
        if (r6 != 0) goto L_0x09bf;
    L_0x09b9:
        if (r17 != 0) goto L_0x09bf;
    L_0x09bb:
        r0 = r25;
        r0.value = r13;
    L_0x09bf:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x09e6;
    L_0x09c5:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x09d7:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x09e3:
        r4 = r5.title;
        goto L_0x09b3;
    L_0x09e6:
        r5 = r5.title;
        goto L_0x09d7;
    L_0x09e9:
        r4 = 2131230904; // 0x7f0800b8 float:1.8077874E38 double:1.052967973E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a2d;
    L_0x09f8:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0a0c:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0a18;
    L_0x0a12:
        if (r17 != 0) goto L_0x0a18;
    L_0x0a14:
        r0 = r25;
        r0.value = r13;
    L_0x0a18:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0a31;
    L_0x0a1e:
        r5 = "%s: ";
    L_0x0a21:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0a2d:
        r4 = "";
        goto L_0x0a0c;
    L_0x0a31:
        r5 = "";
        goto L_0x0a21;
    L_0x0a35:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r4);
        r7 = com.tencent.mm.q.a.a.dV(r4);
        if (r7 != 0) goto L_0x0a4d;
    L_0x0a3f:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        r4 = "";
        goto L_0x0032;
    L_0x0a4d:
        r4 = r7.type;
        switch(r4) {
            case 1: goto L_0x0a5e;
            case 2: goto L_0x0ab7;
            case 3: goto L_0x0b03;
            case 4: goto L_0x0b4f;
            case 5: goto L_0x0c33;
            case 6: goto L_0x0b9b;
            case 7: goto L_0x0be7;
            case 8: goto L_0x0d0d;
            case 9: goto L_0x0a52;
            case 10: goto L_0x0a52;
            case 11: goto L_0x0a52;
            case 12: goto L_0x0a52;
            case 13: goto L_0x0a52;
            case 14: goto L_0x0a52;
            case 15: goto L_0x0d4f;
            case 16: goto L_0x0ec4;
            case 17: goto L_0x0dd3;
            case 18: goto L_0x0a52;
            case 19: goto L_0x0e2c;
            case 20: goto L_0x0a52;
            case 21: goto L_0x0a52;
            case 22: goto L_0x0a52;
            case 23: goto L_0x0a52;
            case 24: goto L_0x0e78;
            case 25: goto L_0x0d91;
            case 26: goto L_0x0d4f;
            case 27: goto L_0x0d4f;
            case 28: goto L_0x0a52;
            case 29: goto L_0x0a52;
            case 30: goto L_0x0a52;
            case 31: goto L_0x0a52;
            case 32: goto L_0x0a52;
            case 33: goto L_0x0c81;
            case 34: goto L_0x0f36;
            default: goto L_0x0a52;
        };
    L_0x0a52:
        r4 = "";
        r5 = "";
    L_0x0a58:
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015c;
    L_0x0a5e:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ab1;
    L_0x0a67:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r7.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0a81:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0a8d;
    L_0x0a87:
        if (r17 != 0) goto L_0x0a8d;
    L_0x0a89:
        r0 = r25;
        r0.value = r13;
    L_0x0a8d:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0ab4;
    L_0x0a93:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r7.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0aa5:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0ab1:
        r4 = r7.title;
        goto L_0x0a81;
    L_0x0ab4:
        r5 = r7.title;
        goto L_0x0aa5;
    L_0x0ab7:
        r4 = 2131231122; // 0x7f080192 float:1.8078316E38 double:1.0529680807E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0afb;
    L_0x0ac6:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ada:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0ae6;
    L_0x0ae0:
        if (r17 != 0) goto L_0x0ae6;
    L_0x0ae2:
        r0 = r25;
        r0.value = r13;
    L_0x0ae6:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0aff;
    L_0x0aec:
        r5 = "%s: ";
    L_0x0aef:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0afb:
        r4 = "";
        goto L_0x0ada;
    L_0x0aff:
        r5 = "";
        goto L_0x0aef;
    L_0x0b03:
        r4 = 2131231095; // 0x7f080177 float:1.8078261E38 double:1.0529680674E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b47;
    L_0x0b12:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b26:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0b32;
    L_0x0b2c:
        if (r17 != 0) goto L_0x0b32;
    L_0x0b2e:
        r0 = r25;
        r0.value = r13;
    L_0x0b32:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b4b;
    L_0x0b38:
        r5 = "%s: ";
    L_0x0b3b:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r7.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0b47:
        r4 = "";
        goto L_0x0b26;
    L_0x0b4b:
        r5 = "";
        goto L_0x0b3b;
    L_0x0b4f:
        r4 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b93;
    L_0x0b5e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b72:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0b7e;
    L_0x0b78:
        if (r17 != 0) goto L_0x0b7e;
    L_0x0b7a:
        r0 = r25;
        r0.value = r13;
    L_0x0b7e:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b97;
    L_0x0b84:
        r5 = "%s: ";
    L_0x0b87:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r7.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0b93:
        r4 = "";
        goto L_0x0b72;
    L_0x0b97:
        r5 = "";
        goto L_0x0b87;
    L_0x0b9b:
        r4 = 2131231063; // 0x7f080157 float:1.8078196E38 double:1.0529680516E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0bdf;
    L_0x0baa:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0bbe:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0bca;
    L_0x0bc4:
        if (r17 != 0) goto L_0x0bca;
    L_0x0bc6:
        r0 = r25;
        r0.value = r13;
    L_0x0bca:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0be3;
    L_0x0bd0:
        r5 = "%s: ";
    L_0x0bd3:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r7.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0bdf:
        r4 = "";
        goto L_0x0bbe;
    L_0x0be3:
        r5 = "";
        goto L_0x0bd3;
    L_0x0be7:
        r4 = 2131230904; // 0x7f0800b8 float:1.8077874E38 double:1.052967973E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c2b;
    L_0x0bf6:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c0a:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0c16;
    L_0x0c10:
        if (r17 != 0) goto L_0x0c16;
    L_0x0c12:
        r0 = r25;
        r0.value = r13;
    L_0x0c16:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c2f;
    L_0x0c1c:
        r5 = "%s: ";
    L_0x0c1f:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0c2b:
        r4 = "";
        goto L_0x0c0a;
    L_0x0c2f:
        r5 = "";
        goto L_0x0c1f;
    L_0x0c33:
        r4 = 2131231171; // 0x7f0801c3 float:1.8078415E38 double:1.052968105E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c79;
    L_0x0c42:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c56:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0c62;
    L_0x0c5c:
        if (r17 != 0) goto L_0x0c62;
    L_0x0c5e:
        r0 = r25;
        r0.value = r13;
    L_0x0c62:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c7d;
    L_0x0c68:
        r5 = "%s: ";
    L_0x0c6b:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r7.getTitle();
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0c79:
        r4 = "";
        goto L_0x0c56;
    L_0x0c7d:
        r5 = "";
        goto L_0x0c6b;
    L_0x0c81:
        r18 = "";
        r4 = 2131230923; // 0x7f0800cb float:1.8077912E38 double:1.0529679824E-314;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ce5;
    L_0x0c93:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r7.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0cb1:
        r6 = com.tencent.mm.model.m.fc(r20);
        if (r6 != 0) goto L_0x0cbd;
    L_0x0cb7:
        if (r17 != 0) goto L_0x0cbd;
    L_0x0cb9:
        r0 = r25;
        r0.value = r13;
    L_0x0cbd:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0cf9;
    L_0x0cc3:
        r6 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r6.<init>(r8);
        r5 = r6.append(r5);
        r6 = r7.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0cd9:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0ce5:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r7.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0cb1;
    L_0x0cf9:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = r7.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
        goto L_0x0cd9;
    L_0x0d0d:
        r4 = 2131231032; // 0x7f080138 float:1.8078134E38 double:1.0529680363E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d4b;
    L_0x0d1c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d30:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0d3c;
    L_0x0d36:
        if (r17 != 0) goto L_0x0d3c;
    L_0x0d38:
        r0 = r25;
        r0.value = r13;
    L_0x0d3c:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0d4b:
        r4 = "";
        goto L_0x0d30;
    L_0x0d4f:
        r4 = 2131231033; // 0x7f080139 float:1.8078136E38 double:1.052968037E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d8d;
    L_0x0d5e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d72:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0d7e;
    L_0x0d78:
        if (r17 != 0) goto L_0x0d7e;
    L_0x0d7a:
        r0 = r25;
        r0.value = r13;
    L_0x0d7e:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0d8d:
        r4 = "";
        goto L_0x0d72;
    L_0x0d91:
        r4 = 2131231022; // 0x7f08012e float:1.8078113E38 double:1.0529680313E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0dcf;
    L_0x0da0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0db4:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0dc0;
    L_0x0dba:
        if (r17 != 0) goto L_0x0dc0;
    L_0x0dbc:
        r0 = r25;
        r0.value = r13;
    L_0x0dc0:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0dcf:
        r4 = "";
        goto L_0x0db4;
    L_0x0dd3:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e26;
    L_0x0ddc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r7.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0df6:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0e02;
    L_0x0dfc:
        if (r17 != 0) goto L_0x0e02;
    L_0x0dfe:
        r0 = r25;
        r0.value = r13;
    L_0x0e02:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e29;
    L_0x0e08:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r7.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0e1a:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0e26:
        r4 = r7.title;
        goto L_0x0df6;
    L_0x0e29:
        r5 = r7.title;
        goto L_0x0e1a;
    L_0x0e2c:
        r4 = 2131231138; // 0x7f0801a2 float:1.8078349E38 double:1.0529680886E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e70;
    L_0x0e3b:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e4f:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0e5b;
    L_0x0e55:
        if (r17 != 0) goto L_0x0e5b;
    L_0x0e57:
        r0 = r25;
        r0.value = r13;
    L_0x0e5b:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e74;
    L_0x0e61:
        r5 = "%s: ";
    L_0x0e64:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0e70:
        r4 = "";
        goto L_0x0e4f;
    L_0x0e74:
        r5 = "";
        goto L_0x0e64;
    L_0x0e78:
        r4 = 2131232757; // 0x7f0807f5 float:1.8081632E38 double:1.0529688885E-314;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ebc;
    L_0x0e87:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e9b:
        r5 = com.tencent.mm.model.m.fc(r20);
        if (r5 != 0) goto L_0x0ea7;
    L_0x0ea1:
        if (r17 != 0) goto L_0x0ea7;
    L_0x0ea3:
        r0 = r25;
        r0.value = r13;
    L_0x0ea7:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0ec0;
    L_0x0ead:
        r5 = "%s: ";
    L_0x0eb0:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0ebc:
        r4 = "";
        goto L_0x0e9b;
    L_0x0ec0:
        r5 = "";
        goto L_0x0eb0;
    L_0x0ec4:
        r18 = "";
        r4 = 2131231658; // 0x7f0803aa float:1.8079403E38 double:1.0529683455E-314;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f22;
    L_0x0ed6:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r7.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0ef4:
        r6 = com.tencent.mm.model.m.fc(r20);
        if (r6 != 0) goto L_0x0f00;
    L_0x0efa:
        if (r17 != 0) goto L_0x0f00;
    L_0x0efc:
        r0 = r25;
        r0.value = r13;
    L_0x0f00:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0f16;
    L_0x0f06:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0f16:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x0f22:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r7.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0ef4;
    L_0x0f36:
        r6 = "";
        r4 = 2131231658; // 0x7f0803aa float:1.8079403E38 double:1.0529683455E-314;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0f89;
    L_0x0f47:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r7.cpu;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f87;
    L_0x0f60:
        r4 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r4.<init>(r7);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0f70:
        r0 = r24;
        r0.value = r4;
    L_0x0f74:
        r4 = com.tencent.mm.model.m.fc(r20);
        if (r4 != 0) goto L_0x12c3;
    L_0x0f7a:
        if (r17 != 0) goto L_0x12c3;
    L_0x0f7c:
        r0 = r25;
        r0.value = r13;
        r4 = r6;
        r7 = r5;
        r6 = r16;
        r5 = r15;
        goto L_0x015c;
    L_0x0f87:
        r4 = r5;
        goto L_0x0f70;
    L_0x0f89:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r7.cpu;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0fb7;
    L_0x0fa2:
        r4 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r4.<init>(r7);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0fb2:
        r0 = r24;
        r0.value = r4;
        goto L_0x0f74;
    L_0x0fb7:
        r4 = r5;
        goto L_0x0fb2;
    L_0x0fb9:
        if (r11 == 0) goto L_0x0fbf;
    L_0x0fbb:
        r7 = dk(r7);
    L_0x0fbf:
        r4 = com.tencent.mm.q.a.a.dY(r7);
        r4 = dj(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0fd2:
        r4 = com.tencent.mm.q.a.a.dX(r7);
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
        r5 = r15;
        r6 = r16;
        goto L_0x015c;
    L_0x0fe3:
        r4 = com.tencent.mm.x.a.a.ij(r7);
        r4 = com.tencent.mm.x.a.b(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x0ff6:
        r7 = "";
        r4 = com.tencent.mm.q.a.a.dV(r4);
        if (r4 == 0) goto L_0x0158;
    L_0x0fff:
        r4 = r4.content;	 Catch:{ Exception -> 0x1017 }
        r5 = "UTF-8";
        r7 = java.net.URLDecoder.decode(r4, r5);	 Catch:{ Exception -> 0x1017 }
        r4 = com.tencent.mm.pluginsdk.ui.d.e.HP(r7);	 Catch:{ Exception -> 0x1017 }
        r0 = r24;
        r0.value = r4;	 Catch:{ Exception -> 0x12bb }
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x1017:
        r4 = move-exception;
        r5 = r4;
        r4 = r7;
    L_0x101a:
        r6 = "MicroMsg.Notification.Wording";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r6, r5, r7, r8);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015c;
    L_0x102d:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r5 = r4.length;
        r6 = 1;
        if (r5 <= r6) goto L_0x1044;
    L_0x1038:
        r5 = 1;
        r5 = r4[r5];
        r0 = r24;
        r0.value = r5;
        r5 = 1;
        r4 = r4[r5];
        goto L_0x0032;
    L_0x1044:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0032;
    L_0x104e:
        r5 = 0;
        r6 = ":";
        r6 = r7.split(r6);
        if (r6 == 0) goto L_0x105b;
    L_0x1058:
        r8 = r6.length;
        if (r8 > 0) goto L_0x1065;
    L_0x105b:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0032;
    L_0x1065:
        r8 = 0;
        r6 = r6[r8];
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r8 != 0) goto L_0x1091;
    L_0x106e:
        com.tencent.mm.model.ak.yW();
        r8 = com.tencent.mm.model.c.wH();
        r6 = r8.LX(r6);
        if (r6 == 0) goto L_0x1085;
    L_0x107b:
        r8 = r6.getCity();
        if (r8 == 0) goto L_0x1085;
    L_0x1081:
        r5 = r6.getCity();
    L_0x1085:
        if (r5 == 0) goto L_0x108d;
    L_0x1087:
        r8 = r5.length();
        if (r8 > 0) goto L_0x1091;
    L_0x108d:
        r5 = r6.getProvince();
    L_0x1091:
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r6 != 0) goto L_0x10cd;
    L_0x1097:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0032;
    L_0x10cd:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r6 = r4.length;
        r7 = 1;
        if (r6 <= r7) goto L_0x1114;
    L_0x10d8:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r7 = 1;
        r7 = r4[r7];
        r6 = r6.append(r7);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r6 = 1;
        r4 = r4[r6];
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0032;
    L_0x1114:
        r0 = r24;
        r0.value = r5;
        r4 = r5;
        goto L_0x0032;
    L_0x111b:
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r8 == 0) goto L_0x1128;
    L_0x1121:
        r8 = "";
        r0 = r24;
        r0.value = r8;
    L_0x1128:
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r13);
        if (r8 != 0) goto L_0x11e0;
    L_0x112e:
        if (r12 == 0) goto L_0x113a;
    L_0x1130:
        r8 = r12.length();
        if (r8 <= 0) goto L_0x113a;
    L_0x1136:
        r7 = i(r7, r13, r12);
    L_0x113a:
        r0 = r25;
        r8 = r0.value;
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r8 == 0) goto L_0x1157;
    L_0x1144:
        r0 = r24;
        r8 = r0.value;
        r9 = "%s";
        r8 = i(r8, r13, r9);
        r0 = r24;
        r0.value = r8;
        r0 = r25;
        r0.value = r13;
    L_0x1157:
        r7 = com.tencent.mm.compatible.util.n.dw(r7);
        r0 = r24;
        r8 = r0.value;
        r8 = com.tencent.mm.compatible.util.n.dw(r8);
        r0 = r24;
        r0.value = r8;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r7 = r8.append(r7);
        r7 = r7.append(r4);
        r7 = r7.toString();
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r24;
        r9 = r0.value;
        r8 = r8.append(r9);
        r4 = r8.append(r4);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        if (r27 == 0) goto L_0x11be;
    L_0x1193:
        r0 = r24;
        r4 = r0.value;
        r4 = r4.length();
        r8 = 32;
        if (r4 != r8) goto L_0x11de;
    L_0x119f:
        r4 = 47;
        r0 = r22;
        if (r0 == r4) goto L_0x11ac;
    L_0x11a5:
        r4 = 1048625; // 0x100031 float:1.469437E-39 double:5.180896E-318;
        r0 = r22;
        if (r0 != r4) goto L_0x11de;
    L_0x11ac:
        r0 = r24;
        r0.value = r7;
        r4 = 1;
    L_0x11b1:
        if (r4 != 0) goto L_0x11be;
    L_0x11b3:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
    L_0x11be:
        if (r6 == 0) goto L_0x12c0;
    L_0x11c0:
        r4 = new java.lang.StringBuilder;
        r6 = " ";
        r4.<init>(r6);
        r5 = com.tencent.mm.sdk.platformtools.be.ma(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r4 = r7.concat(r4);
    L_0x11d8:
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r4);
        goto L_0x0032;
    L_0x11de:
        r4 = 0;
        goto L_0x11b1;
    L_0x11e0:
        r8 = com.tencent.mm.model.m.fc(r20);
        if (r8 != 0) goto L_0x11ee;
    L_0x11e6:
        if (r17 != 0) goto L_0x11ee;
    L_0x11e8:
        r8 = com.tencent.mm.model.m.fm(r20);
        if (r8 == 0) goto L_0x12a0;
    L_0x11ee:
        if (r4 == 0) goto L_0x11f7;
    L_0x11f0:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x11f7;
    L_0x11f6:
        r7 = r4;
    L_0x11f7:
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r4 == 0) goto L_0x1210;
    L_0x11fd:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = "";
        r0 = r25;
        r0.value = r4;
        r4 = "";
        goto L_0x0032;
    L_0x1210:
        if (r19 != 0) goto L_0x1258;
    L_0x1212:
        r4 = new java.lang.StringBuilder;
        r8 = "%s:";
        r4.<init>(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x1226:
        if (r27 == 0) goto L_0x127e;
    L_0x1228:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        r4 = r7;
    L_0x1234:
        if (r6 == 0) goto L_0x124c;
    L_0x1236:
        if (r5 == 0) goto L_0x124c;
    L_0x1238:
        r6 = new java.lang.StringBuilder;
        r7 = " ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
        r4 = r4.concat(r5);
    L_0x124c:
        if (r11 == 0) goto L_0x1252;
    L_0x124e:
        r4 = dk(r4);
    L_0x1252:
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r4);
        goto L_0x0032;
    L_0x1258:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = 2131231088; // 0x7f080170 float:1.8078247E38 double:1.052968064E-314;
        r0 = r23;
        r8 = r0.getString(r8);
        r4 = r4.append(r8);
        r8 = ":";
        r4 = r4.append(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x1226;
    L_0x127e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r25;
        r5 = r0.value;
        r5 = com.tencent.mm.model.l.er(r5);
        r4 = r4.append(r5);
        r5 = ":";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x0032;
    L_0x12a0:
        if (r4 == 0) goto L_0x12be;
    L_0x12a2:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x12be;
    L_0x12a8:
        r0 = r24;
        r0.value = r4;
    L_0x12ac:
        if (r27 == 0) goto L_0x1234;
    L_0x12ae:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        goto L_0x1234;
    L_0x12bb:
        r5 = move-exception;
        goto L_0x101a;
    L_0x12be:
        r4 = r7;
        goto L_0x12ac;
    L_0x12c0:
        r4 = r7;
        goto L_0x11d8;
    L_0x12c3:
        r4 = r6;
        goto L_0x0a58;
    L_0x12c6:
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015c;
    L_0x12ce:
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015c;
    L_0x12d6:
        r4 = r20;
        goto L_0x05c0;
    L_0x12da:
        r5 = r20;
        goto L_0x05c4;
    L_0x12de:
        r17 = r5;
        r7 = r21;
        goto L_0x0155;
    L_0x12e4:
        r4 = r21;
        r12 = r5;
        r13 = r6;
        goto L_0x0125;
    L_0x12ea:
        r11 = r4;
        goto L_0x00e2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(java.lang.String, int, java.lang.String, java.lang.String, int, android.content.Context, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PInt, boolean, boolean):java.lang.String");
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        int indexOf;
        int i2 = 2131232916;
        String str4 = SQLiteDatabase.KeyEmpty;
        if (m.eI(str) || m.eK(str)) {
            if (str2 != null) {
                indexOf = str2.indexOf(":");
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (u.LH(substring) || u.LJ(substring)) {
                        str4 = l.er(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (u.LH(str) || u.LJ(str)) {
            l.er(str);
            pString2.value = str;
            if (i == 1) {
                StringBuilder append = new StringBuilder().append(context.getString(2131232916, new Object[]{SQLiteDatabase.KeyEmpty}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = SQLiteDatabase.KeyEmpty;
                return pString.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = SQLiteDatabase.KeyEmpty;
            return pString.value;
        }
        if (be.ma(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            return pString.value;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 1) {
            indexOf = 2131232916;
        } else {
            indexOf = 2131232926;
        }
        pString.value = stringBuilder.append(context.getString(indexOf)).append(str3 == null ? str2 : str3).toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (i != 1) {
            i2 = 2131232926;
        }
        append = stringBuilder2.append(context.getString(i2, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        return append.append(str2).toString();
    }

    private static String dj(String str) {
        if (str != null) {
            return str.replaceAll("%", "%%");
        }
        return str;
    }

    private static String i(String str, String str2, String str3) {
        if (be.kS(str) || be.kS(str2) || be.kS(str3)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length()) : str;
    }

    private static String dk(String str) {
        if (str != null) {
            return str.replaceAll("%%", "%");
        }
        return str;
    }

    public static String dl(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str.length() >= 150 ? str.substring(0, 150) + "..." : str;
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        int i2 = 150;
        if (pString.value.length() != 32 || (i != 47 && i != 1048625)) {
            if (pString.value.length() >= 150) {
                String str = pString.value;
                String str2 = pString.value;
                while (i2 < str2.length()) {
                    if (str2.charAt(i2) != '%') {
                        break;
                    }
                    i2++;
                }
                i2 = str2.length();
                pString.value = str.substring(0, i2);
            }
            TextPaint textPaint = cap == null ? null : (TextPaint) cap.get();
            if (pString.value.replace("%%", SQLiteDatabase.KeyEmpty).contains("%s") || textPaint == null) {
                pInt.value = 0;
                return;
            }
            CharSequence format;
            try {
                format = String.format(pString.value, new Object[]{pString2.value});
            } catch (Exception e) {
                format = pString.value;
            }
            pString.value = TextUtils.ellipsize(format, textPaint, (float) (caq > 0 ? caq : BackwardSupportUtil.b.a(aa.getContext(), 200.0f)), TruncateAt.END).toString();
            pInt.value = 1;
        }
    }

    public static void dJ(int i) {
        caq = i;
    }

    public static void dK(int i) {
        car = i;
    }

    public static void a(TextPaint textPaint) {
        if (cap == null || cap.get() == null) {
            cap = new WeakReference(textPaint);
        }
    }

    public static String b(Context context, String str, boolean z) {
        return z ? b.buL().Lk(str) : context.getString(2131233300);
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        if (z) {
            String Lk = b.buL().Lk(str);
            if (i3 <= 1) {
                return Lk;
            }
            return context.getResources().getQuantityString(2131361813, i3, new Object[]{Integer.valueOf(i3)}) + Lk;
        }
        return context.getResources().getQuantityString(2131361814, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static String c(Context context, String str, boolean z) {
        if (z) {
            return b.buL().Lk(str);
        }
        return context.getString(2131234104);
    }
}
