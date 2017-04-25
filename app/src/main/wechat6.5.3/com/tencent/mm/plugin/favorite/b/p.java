package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.pb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p {

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ String aSc;
        final /* synthetic */ pw fKP;
        final /* synthetic */ Runnable ftq;
        final /* synthetic */ Context val$context;

        public AnonymousClass3(pw pwVar, Context context, String str, Runnable runnable) {
            this.fKP = pwVar;
            this.val$context = context;
            this.aSc = str;
            this.ftq = runnable;
        }

        public final void run() {
            if (this.fKP.aKG == 15) {
                p.a(this.val$context, this.aSc, this.fKP);
            } else {
                p.b(this.val$context, this.aSc, this.fKP);
            }
            ad.o(this.ftq);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    public static class a {
        public String bdZ;
        public String desc;
        public String fKQ;
        public String title;

        private static boolean sR(String str) {
            return new File(str).exists();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.plugin.favorite.b.p.a a(android.content.Context r11, com.tencent.mm.plugin.favorite.b.i r12) {
            /*
            r0 = r12.field_type;
            r1 = 18;
            if (r0 != r1) goto L_0x01ba;
        L_0x0006:
            r3 = new com.tencent.mm.plugin.favorite.b.p$a;
            r3.<init>();
            r4 = new android.util.SparseIntArray;
            r4.<init>();
            r0 = r12.field_type;
            r1 = 18;
            if (r0 != r1) goto L_0x001c;
        L_0x0016:
            r0 = r12.field_favProto;
            r0 = r0.title;
            r3.title = r0;
        L_0x001c:
            r1 = 0;
            r0 = 0;
            r5 = new java.util.LinkedList;
            r5.<init>();
            r2 = r12.field_favProto;
            r2 = r2.mtR;
            r6 = r2.iterator();
            r2 = r1;
            r1 = r0;
        L_0x002d:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x016b;
        L_0x0033:
            r0 = r6.next();
            r0 = (com.tencent.mm.protocal.c.pw) r0;
            r7 = r12.field_type;
            r8 = 18;
            if (r7 != r8) goto L_0x0052;
        L_0x003f:
            r7 = r0.msh;
            r7 = com.tencent.mm.sdk.platformtools.be.kS(r7);
            if (r7 != 0) goto L_0x0052;
        L_0x0047:
            r7 = r0.msh;
            r8 = ".htm";
            r7 = r7.equals(r8);
            if (r7 != 0) goto L_0x002d;
        L_0x0052:
            r7 = r0.aKG;
            r7 = r4.get(r7);
            r8 = r0.aKG;
            r7 = r7 + 1;
            r4.put(r8, r7);
            r7 = r0.aKG;
            switch(r7) {
                case 1: goto L_0x00aa;
                case 2: goto L_0x00cc;
                case 3: goto L_0x0067;
                case 4: goto L_0x0064;
                case 5: goto L_0x0064;
                case 6: goto L_0x00eb;
                case 7: goto L_0x0064;
                case 8: goto L_0x013a;
                default: goto L_0x0064;
            };
        L_0x0064:
            r0 = r2;
        L_0x0065:
            r2 = r0;
            goto L_0x002d;
        L_0x0067:
            r7 = r5.size();
            r8 = 4;
            if (r7 >= r8) goto L_0x0064;
        L_0x006e:
            r0 = r0.duration;
            r8 = (long) r0;
            r0 = com.tencent.mm.plugin.favorite.b.v.au(r8);
            r0 = (int) r0;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = 2131231177; // 0x7f0801c9 float:1.8078428E38 double:1.052968108E-314;
            r8 = r11.getString(r8);
            r7 = r7.append(r8);
            r8 = 2131232930; // 0x7f0808a2 float:1.8081983E38 double:1.052968974E-314;
            r9 = 1;
            r9 = new java.lang.Object[r9];
            r10 = 0;
            r0 = java.lang.Integer.valueOf(r0);
            r9[r10] = r0;
            r0 = r11.getString(r8, r9);
            r0 = r7.append(r0);
            r7 = "\n";
            r0 = r0.append(r7);
            r0 = r0.toString();
            r5.add(r0);
            goto L_0x002d;
        L_0x00aa:
            r7 = r5.size();
            r8 = 4;
            if (r7 >= r8) goto L_0x0064;
        L_0x00b1:
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r0 = r0.desc;
            r0 = r7.append(r0);
            r7 = "\n";
            r0 = r0.append(r7);
            r0 = r0.toString();
            r5.add(r0);
            goto L_0x002d;
        L_0x00cc:
            r5.size();
            if (r1 != 0) goto L_0x0064;
        L_0x00d1:
            r1 = com.tencent.mm.plugin.favorite.b.v.g(r0);
            r7 = sR(r1);
            if (r7 == 0) goto L_0x00e1;
        L_0x00db:
            r3.bdZ = r1;
            r0 = 1;
            r1 = r0;
            goto L_0x002d;
        L_0x00e1:
            r0 = com.tencent.mm.plugin.favorite.b.v.f(r0);
            r3.bdZ = r0;
            r0 = 1;
            r1 = r0;
            goto L_0x002d;
        L_0x00eb:
            r7 = r5.size();
            r8 = 4;
            if (r7 >= r8) goto L_0x0131;
        L_0x00f2:
            r0 = r0.msM;
            r0 = r0.mta;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = 2131231086; // 0x7f08016e float:1.8078243E38 double:1.052968063E-314;
            r8 = r11.getString(r8);
            r7 = r7.append(r8);
            r8 = r0.bkV;
            r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
            if (r8 != 0) goto L_0x011d;
        L_0x010e:
            r8 = r0.bkV;
            r9 = 2131233537; // 0x7f080b01 float:1.8083214E38 double:1.052969274E-314;
            r9 = r11.getString(r9);
            r8 = r8.equals(r9);
            if (r8 == 0) goto L_0x0137;
        L_0x011d:
            r0 = r0.label;
        L_0x011f:
            r0 = r7.append(r0);
            r7 = "\n";
            r0 = r0.append(r7);
            r0 = r0.toString();
            r5.add(r0);
        L_0x0131:
            if (r2 != 0) goto L_0x0064;
        L_0x0133:
            r0 = 1;
            r2 = r0;
            goto L_0x002d;
        L_0x0137:
            r0 = r0.bkV;
            goto L_0x011f;
        L_0x013a:
            r7 = r5.size();
            r8 = 4;
            if (r7 >= r8) goto L_0x0165;
        L_0x0141:
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = 2131231063; // 0x7f080157 float:1.8078196E38 double:1.0529680516E-314;
            r8 = r11.getString(r8);
            r7 = r7.append(r8);
            r0 = r0.title;
            r0 = r7.append(r0);
            r7 = "\n";
            r0 = r0.append(r7);
            r0 = r0.toString();
            r5.add(r0);
        L_0x0165:
            if (r2 != 0) goto L_0x0064;
        L_0x0167:
            r2 = 1;
            r0 = r2;
            goto L_0x0065;
        L_0x016b:
            r0 = "";
            r1 = "";
            r3.desc = r1;
            r2 = r5.iterator();
            r1 = r0;
        L_0x0178:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x0197;
        L_0x017e:
            r0 = r2.next();
            r0 = (java.lang.String) r0;
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r1 = r4.append(r1);
            r0 = r1.append(r0);
            r0 = r0.toString();
            r1 = r0;
            goto L_0x0178;
        L_0x0197:
            r0 = r1.trim();
            r1 = r5.size();
            r2 = 4;
            if (r1 < r2) goto L_0x01b6;
        L_0x01a2:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r0 = r1.append(r0);
            r1 = "...";
            r0 = r0.append(r1);
            r0 = r0.toString();
        L_0x01b6:
            r3.desc = r0;
            r0 = r3;
        L_0x01b9:
            return r0;
        L_0x01ba:
            r2 = new com.tencent.mm.plugin.favorite.b.p$a;
            r2.<init>();
            r3 = new android.util.SparseIntArray;
            r3.<init>();
            r0 = r12.field_type;
            r1 = 14;
            if (r0 != r1) goto L_0x01d0;
        L_0x01ca:
            r0 = r12.field_favProto;
            r0 = r0.title;
            r2.title = r0;
        L_0x01d0:
            r0 = 0;
            r4 = new java.util.LinkedList;
            r4.<init>();
            r1 = r12.field_favProto;
            r1 = r1.mtR;
            r5 = r1.iterator();
            r1 = r0;
        L_0x01df:
            r0 = r5.hasNext();
            if (r0 == 0) goto L_0x056a;
        L_0x01e5:
            r0 = r5.next();
            r0 = (com.tencent.mm.protocal.c.pw) r0;
            r6 = r0.aKG;
            r6 = r3.get(r6);
            r7 = r0.aKG;
            r6 = r6 + 1;
            r3.put(r7, r6);
            r6 = r0.aKG;
            switch(r6) {
                case 1: goto L_0x0250;
                case 2: goto L_0x027f;
                case 3: goto L_0x0200;
                case 4: goto L_0x0370;
                case 5: goto L_0x02c3;
                case 6: goto L_0x03b4;
                case 7: goto L_0x0410;
                case 8: goto L_0x0453;
                case 9: goto L_0x01fd;
                case 10: goto L_0x0491;
                case 11: goto L_0x0491;
                case 12: goto L_0x01fd;
                case 13: goto L_0x01fd;
                case 14: goto L_0x04de;
                case 15: goto L_0x032c;
                case 16: goto L_0x0521;
                default: goto L_0x01fd;
            };
        L_0x01fd:
            r0 = r1;
        L_0x01fe:
            r1 = r0;
            goto L_0x01df;
        L_0x0200:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x01fd;
        L_0x0207:
            r6 = r0.duration;
            r6 = (long) r6;
            r6 = com.tencent.mm.plugin.favorite.b.v.au(r6);
            r6 = (int) r6;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r0 = r0.msO;
            r0 = r7.append(r0);
            r7 = ":";
            r0 = r0.append(r7);
            r7 = 2131231177; // 0x7f0801c9 float:1.8078428E38 double:1.052968108E-314;
            r7 = r11.getString(r7);
            r0 = r0.append(r7);
            r7 = 2131232930; // 0x7f0808a2 float:1.8081983E38 double:1.052968974E-314;
            r8 = 1;
            r8 = new java.lang.Object[r8];
            r9 = 0;
            r6 = java.lang.Integer.valueOf(r6);
            r8[r9] = r6;
            r6 = r11.getString(r7, r8);
            r0 = r0.append(r6);
            r6 = "\n";
            r0 = r0.append(r6);
            r0 = r0.toString();
            r4.add(r0);
            goto L_0x01df;
        L_0x0250:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x01fd;
        L_0x0257:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r0 = r0.desc;
            r0 = r6.append(r0);
            r6 = "\n";
            r0 = r0.append(r6);
            r0 = r0.toString();
            r4.add(r0);
            goto L_0x01df;
        L_0x027f:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x02b1;
        L_0x0286:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231122; // 0x7f080192 float:1.8078316E38 double:1.0529680807E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x02b1:
            if (r1 != 0) goto L_0x01fd;
        L_0x02b3:
            r0 = com.tencent.mm.plugin.favorite.b.v.g(r0);
            r6 = sR(r0);
            if (r6 == 0) goto L_0x05c0;
        L_0x02bd:
            r2.bdZ = r0;
            r0 = 1;
        L_0x02c0:
            r1 = r0;
            goto L_0x01df;
        L_0x02c3:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x02fb;
        L_0x02ca:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231171; // 0x7f0801c3 float:1.8078415E38 double:1.052968105E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = r0.title;
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x02fb:
            if (r1 != 0) goto L_0x01fd;
        L_0x02fd:
            r1 = com.tencent.mm.plugin.favorite.b.v.g(r0);
            r6 = sR(r1);
            if (r6 == 0) goto L_0x030d;
        L_0x0307:
            r2.bdZ = r1;
        L_0x0309:
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x030d:
            r1 = r0.msM;
            r1 = r1.mtc;
            if (r1 != 0) goto L_0x0329;
        L_0x0313:
            r1 = "";
        L_0x0316:
            r6 = com.tencent.mm.sdk.platformtools.be.kS(r1);
            if (r6 == 0) goto L_0x0325;
        L_0x031c:
            r0 = r0.aZh;
            r1 = "";
            r1 = com.tencent.mm.sdk.platformtools.be.ah(r0, r1);
        L_0x0325:
            a(r2, r1);
            goto L_0x0309;
        L_0x0329:
            r1 = r1.bea;
            goto L_0x0316;
        L_0x032c:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x035e;
        L_0x0333:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231156; // 0x7f0801b4 float:1.8078385E38 double:1.0529680975E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x035e:
            if (r1 != 0) goto L_0x01fd;
        L_0x0360:
            r0 = com.tencent.mm.plugin.favorite.b.v.g(r0);
            r6 = sR(r0);
            if (r6 == 0) goto L_0x05bd;
        L_0x036a:
            r2.bdZ = r0;
            r0 = 1;
        L_0x036d:
            r1 = r0;
            goto L_0x01df;
        L_0x0370:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x03a2;
        L_0x0377:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231176; // 0x7f0801c8 float:1.8078426E38 double:1.0529681074E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x03a2:
            if (r1 != 0) goto L_0x01fd;
        L_0x03a4:
            r0 = com.tencent.mm.plugin.favorite.b.v.g(r0);
            r6 = sR(r0);
            if (r6 == 0) goto L_0x05ba;
        L_0x03ae:
            r2.bdZ = r0;
            r0 = 1;
        L_0x03b1:
            r1 = r0;
            goto L_0x01df;
        L_0x03b4:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x0407;
        L_0x03bb:
            r6 = r0.msM;
            r6 = r6.mta;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r0 = r0.msO;
            r0 = r7.append(r0);
            r7 = ":";
            r0 = r0.append(r7);
            r7 = 2131231086; // 0x7f08016e float:1.8078243E38 double:1.052968063E-314;
            r7 = r11.getString(r7);
            r7 = r0.append(r7);
            r0 = r6.bkV;
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 != 0) goto L_0x03f3;
        L_0x03e4:
            r0 = r6.bkV;
            r8 = 2131233537; // 0x7f080b01 float:1.8083214E38 double:1.052969274E-314;
            r8 = r11.getString(r8);
            r0 = r0.equals(r8);
            if (r0 == 0) goto L_0x040d;
        L_0x03f3:
            r0 = r6.label;
        L_0x03f5:
            r0 = r7.append(r0);
            r6 = "\n";
            r0 = r0.append(r6);
            r0 = r0.toString();
            r4.add(r0);
        L_0x0407:
            if (r1 != 0) goto L_0x01fd;
        L_0x0409:
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x040d:
            r0 = r6.bkV;
            goto L_0x03f5;
        L_0x0410:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x0448;
        L_0x0417:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231095; // 0x7f080177 float:1.8078261E38 double:1.0529680674E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = r0.title;
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x0448:
            if (r1 != 0) goto L_0x01fd;
        L_0x044a:
            r0 = r0.aZh;
            a(r2, r0);
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x0453:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x048b;
        L_0x045a:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231063; // 0x7f080157 float:1.8078196E38 double:1.0529680516E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r0 = r0.title;
            r0 = r6.append(r0);
            r6 = "\n";
            r0 = r0.append(r6);
            r0 = r0.toString();
            r4.add(r0);
        L_0x048b:
            if (r1 != 0) goto L_0x01fd;
        L_0x048d:
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x0491:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x04cd;
        L_0x0498:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231126; // 0x7f080196 float:1.8078324E38 double:1.0529680827E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = r0.msM;
            r7 = r7.mte;
            r7 = r7.title;
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x04cd:
            if (r1 != 0) goto L_0x01fd;
        L_0x04cf:
            r0 = r0.msM;
            r0 = r0.mte;
            if (r0 == 0) goto L_0x04da;
        L_0x04d5:
            r0 = r0.bea;
            a(r2, r0);
        L_0x04da:
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x04de:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x0510;
        L_0x04e5:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131230904; // 0x7f0800b8 float:1.8077874E38 double:1.052967973E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x0510:
            if (r1 != 0) goto L_0x01fd;
        L_0x0512:
            r0 = r0.msM;
            r0 = r0.mtg;
            if (r0 == 0) goto L_0x051d;
        L_0x0518:
            r0 = r0.bea;
            a(r2, r0);
        L_0x051d:
            r0 = 1;
            r1 = r0;
            goto L_0x01df;
        L_0x0521:
            r6 = r4.size();
            r7 = 4;
            if (r6 >= r7) goto L_0x0553;
        L_0x0528:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = r0.msO;
            r6 = r6.append(r7);
            r7 = ":";
            r6 = r6.append(r7);
            r7 = 2131231068; // 0x7f08015c float:1.8078207E38 double:1.052968054E-314;
            r7 = r11.getString(r7);
            r6 = r6.append(r7);
            r7 = "\n";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r4.add(r6);
        L_0x0553:
            if (r1 != 0) goto L_0x01fd;
        L_0x0555:
            com.tencent.mm.model.ak.yW();
            r1 = com.tencent.mm.model.c.wJ();
            r0 = r0.desc;
            r0 = r1.MU(r0);
            r0 = r0.lct;
            r2.fKQ = r0;
            r1 = 1;
            r0 = r1;
            goto L_0x01fe;
        L_0x056a:
            r0 = "";
            r1 = "";
            r2.desc = r1;
            r3 = r4.iterator();
            r1 = r0;
        L_0x0577:
            r0 = r3.hasNext();
            if (r0 == 0) goto L_0x0596;
        L_0x057d:
            r0 = r3.next();
            r0 = (java.lang.String) r0;
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r1 = r5.append(r1);
            r0 = r1.append(r0);
            r0 = r0.toString();
            r1 = r0;
            goto L_0x0577;
        L_0x0596:
            r0 = r1.trim();
            r1 = r4.size();
            r3 = 4;
            if (r1 < r3) goto L_0x05b5;
        L_0x05a1:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r0 = r1.append(r0);
            r1 = "...";
            r0 = r0.append(r1);
            r0 = r0.toString();
        L_0x05b5:
            r2.desc = r0;
            r0 = r2;
            goto L_0x01b9;
        L_0x05ba:
            r0 = r1;
            goto L_0x03b1;
        L_0x05bd:
            r0 = r1;
            goto L_0x036d;
        L_0x05c0:
            r0 = r1;
            goto L_0x02c0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.b.p.a.a(android.content.Context, com.tencent.mm.plugin.favorite.b.i):com.tencent.mm.plugin.favorite.b.p$a");
        }

        private static void a(a aVar, String str) {
            String str2 = v.alQ() + g.m(be.ah(str, "").getBytes());
            if (sR(str2)) {
                aVar.bdZ = str2;
            }
        }
    }

    static class AnonymousClass2 implements com.tencent.mm.plugin.favorite.b.ae.a {
        final /* synthetic */ i fKO;
        final /* synthetic */ Runnable ftq;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(i iVar, Context context, Runnable runnable) {
            this.fKO = iVar;
            this.val$context = context;
            this.ftq = runnable;
        }

        public final void a(SparseArray<String> sparseArray) {
            String str = (String) sparseArray.get(this.fKO.field_id);
            v.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", new Object[]{Integer.valueOf(this.fKO.field_id), str});
            if (!be.kS(str)) {
                if (4 == this.fKO.field_type) {
                    pw n = v.n(this.fKO);
                    String ah = be.ah(n.title, this.val$context.getString(2131232752));
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", str);
                    intent.putExtra("Ksnsupload_title", ah);
                    intent.putExtra("Ksnsupload_imgbuf", e.d(v.g(n), 0, -1));
                    c.drp.m(intent, this.val$context);
                    str = "fav_" + k.xF() + "_" + this.fKO.field_id;
                    String fz = o.fz(str);
                    o.yx().n(fz, true).l("prePublishId", str);
                    intent.putExtra("reportSessionId", fz);
                    com.tencent.mm.plugin.report.service.g.iuh.h(10651, new Object[]{Integer.valueOf(this.fKO.field_type), Integer.valueOf(0)});
                } else {
                    v.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", new Object[]{Integer.valueOf(this.fKO.field_type), Integer.valueOf(this.fKO.field_id)});
                }
            }
            if (this.ftq != null) {
                ad.o(this.ftq);
            }
        }
    }

    static /* synthetic */ void a(Context context, String str, pw pwVar) {
        File file = new File(v.f(pwVar));
        if (file.exists()) {
            String b = b(pwVar);
            v.d("MicroMsg.FavSendLogic", "send fav short Video::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), b});
            ayk com_tencent_mm_protocal_c_ayk = null;
            pz pzVar = pwVar.msS;
            if (pzVar != null) {
                com_tencent_mm_protocal_c_ayk = new ayk();
                com_tencent_mm_protocal_c_ayk.cql = pzVar.cql;
                com_tencent_mm_protocal_c_ayk.cqi = pzVar.cqi;
                com_tencent_mm_protocal_c_ayk.mtD = pzVar.mtD;
                com_tencent_mm_protocal_c_ayk.cqg = pzVar.cqg;
                com_tencent_mm_protocal_c_ayk.cqj = pzVar.cqj;
                com_tencent_mm_protocal_c_ayk.cqm = pzVar.cqm;
                com_tencent_mm_protocal_c_ayk.cqn = pzVar.cqn;
                com_tencent_mm_protocal_c_ayk.cqk = pzVar.cqk;
            }
            if (com_tencent_mm_protocal_c_ayk != null) {
                com.tencent.mm.pluginsdk.j.a.bmt().a(context, str, file.getAbsolutePath(), b, 62, pwVar.duration, com_tencent_mm_protocal_c_ayk, false, false, pwVar.bnY);
                return;
            }
            com.tencent.mm.pluginsdk.j.a.bmt().a(context, str, file.getAbsolutePath(), b, 62, pwVar.duration, pwVar.bnY);
            return;
        }
        v.w("MicroMsg.FavSendLogic", "sendShortVideo, error! data not existed");
    }

    static /* synthetic */ void a(String str, i iVar, pw pwVar) {
        String f = v.f(pwVar);
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(f);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = pwVar.title;
        if (be.kS(wXMediaMessage.title)) {
            wXMediaMessage.title = iVar.field_favProto.title;
        }
        wXMediaMessage.description = pwVar.desc;
        wXMediaMessage.thumbData = be.readFromFile(v.g(pwVar));
        l.a(wXMediaMessage, "", "", str, 3, null);
    }

    static /* synthetic */ void b(Context context, String str, pw pwVar) {
        ayk com_tencent_mm_protocal_c_ayk = null;
        File file = new File(v.f(pwVar));
        if (file.exists()) {
            File file2 = new File(v.g(pwVar));
            String absolutePath = file2.exists() ? file2.getAbsolutePath() : v.alQ() + g.m(be.ah(pwVar.aZh, "").getBytes());
            v.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), absolutePath});
            pz pzVar = pwVar.msS;
            if (pzVar != null) {
                com_tencent_mm_protocal_c_ayk = new ayk();
                com_tencent_mm_protocal_c_ayk.cql = pzVar.cql;
                com_tencent_mm_protocal_c_ayk.cqi = pzVar.cqi;
                com_tencent_mm_protocal_c_ayk.mtD = pzVar.mtD;
                com_tencent_mm_protocal_c_ayk.cqg = pzVar.cqg;
                com_tencent_mm_protocal_c_ayk.cqj = pzVar.cqj;
                com_tencent_mm_protocal_c_ayk.cqm = pzVar.cqm;
                com_tencent_mm_protocal_c_ayk.cqn = pzVar.cqn;
            }
            if (com_tencent_mm_protocal_c_ayk != null) {
                com.tencent.mm.pluginsdk.j.a.bmt().a(context, str, file.getAbsolutePath(), absolutePath, 1, pwVar.duration, com_tencent_mm_protocal_c_ayk, false, false, pwVar.bnY);
                return;
            } else {
                com.tencent.mm.pluginsdk.j.a.bmt().a(context, str, file.getAbsolutePath(), absolutePath, 1, pwVar.duration, pwVar.bnY);
                return;
            }
        }
        String str2 = pwVar.mrZ;
        if (!be.kS(str2)) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            String ah = be.ah(pwVar.title, context.getResources().getString(2131232752));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = ah;
            wXMediaMessage.description = pwVar.desc;
            wXMediaMessage.thumbData = be.readFromFile(v.g(pwVar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = be.readFromFile(v.alQ() + g.m(be.ah(pwVar.aZh, "").getBytes()));
            }
            com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
            aVar.coe = 3;
            pz pzVar2 = pwVar.msS;
            if (pzVar2 != null) {
                aVar.cql = pzVar2.cql;
                aVar.cqi = pzVar2.cqi;
                aVar.cqh = pzVar2.mtD;
                aVar.cqg = pzVar2.cqg;
                aVar.cqj = pzVar2.cqj;
                aVar.cqm = pzVar2.cqm;
                aVar.cqn = pzVar2.cqn;
            }
            l.a(aVar, wXMediaMessage, str, null, null);
        }
    }

    public static void a(Context context, String str, String str2, i iVar, Runnable runnable) {
        List linkedList = new LinkedList();
        linkedList.add(iVar);
        a(context, str, str2, linkedList, runnable);
    }

    public static void a(Context context, String str, String str2, List<i> list, Runnable runnable) {
        if (context == null) {
            v.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            ad.o(runnable);
        } else if (be.kS(str)) {
            v.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            ad.o(runnable);
        } else if (list.isEmpty()) {
            v.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            ad.o(runnable);
        } else {
            final String str3 = str;
            final List<i> list2 = list;
            final Context context2 = context;
            final String str4 = str2;
            final Runnable runnable2 = runnable;
            ak.vA().x(new Runnable() {
                public final void run() {
                    for (String str : be.g(str3.split(","))) {
                        for (i iVar : list2) {
                            if (iVar != null) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(10925, new Object[]{Integer.valueOf(iVar.field_type), Integer.valueOf(iVar.field_id)});
                                byte[] readFromFile;
                                Context context;
                                qe qeVar;
                                kb kbVar;
                                byte[] readFromFile2;
                                switch (iVar.field_type) {
                                    case 1:
                                        com.tencent.mm.pluginsdk.j.a.bmt().x(str, iVar.field_favProto.desc, m.fp(str));
                                        break;
                                    case 2:
                                        Iterator it = iVar.field_favProto.mtR.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.pluginsdk.j.a.bmt().a(context2, str, v.f((pw) it.next()), 0, "", "");
                                        }
                                        break;
                                    case 4:
                                        p.b(context2, str, v.n(iVar));
                                        break;
                                    case 5:
                                        if (iVar != null) {
                                            pw n = v.n(iVar);
                                            qp qpVar = iVar.field_favProto.mtc;
                                            qg qgVar = iVar.field_favProto.mtP;
                                            com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                                            if (qpVar != null) {
                                                aVar.title = qpVar.title;
                                            }
                                            if (be.kS(aVar.title) && n != null) {
                                                aVar.title = n.title;
                                            }
                                            if (qpVar != null) {
                                                aVar.description = qpVar.desc;
                                            }
                                            if (be.kS(aVar.description) && n != null) {
                                                aVar.description = n.desc;
                                            }
                                            if (iVar.field_favProto.mtc != null) {
                                                aVar.url = iVar.field_favProto.mtc.mur;
                                            }
                                            if (qgVar != null && be.kS(aVar.url)) {
                                                aVar.url = qgVar.cZp;
                                            }
                                            if (!(n == null || be.kS(n.canvasPageXml))) {
                                                aVar.canvasPageXml = n.canvasPageXml;
                                            }
                                            aVar.bXP = "view";
                                            aVar.type = 5;
                                            aVar.bnY = n.bnY;
                                            readFromFile = be.readFromFile(v.g(n));
                                            if (readFromFile == null) {
                                                String str2 = qpVar == null ? null : qpVar.bea;
                                                if (be.kS(str2)) {
                                                    str2 = be.ah(n.aZh, "");
                                                }
                                                readFromFile = be.readFromFile(v.alQ() + g.m(str2.getBytes()));
                                            }
                                            String str3 = "fav_" + k.xF() + "_" + iVar.field_id;
                                            String fz = o.fz(str3);
                                            b n2 = o.yx().n(fz, true);
                                            n2.l("prePublishId", str3);
                                            n2.l("preUsername", iVar.field_fromUser);
                                            n2.l("sendAppMsgScene", Integer.valueOf(1));
                                            n2.l("adExtStr", n.bnY);
                                            com.tencent.mm.pluginsdk.j.a.bmt().a(str, readFromFile, com.tencent.mm.q.a.a.b(aVar), fz);
                                            break;
                                        }
                                        v.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                        break;
                                    case 6:
                                        qc qcVar = iVar.field_favProto.mta;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("<msg>");
                                        stringBuilder.append("<location ");
                                        stringBuilder.append("x=\"").append(qcVar.lat).append("\" ");
                                        stringBuilder.append("y=\"").append(qcVar.lng).append("\" ");
                                        stringBuilder.append("scale=\"").append(qcVar.bhu).append("\" ");
                                        stringBuilder.append("label=\"").append(be.ah(qcVar.label, "")).append("\" ");
                                        stringBuilder.append("maptype=\"0\" ");
                                        stringBuilder.append("poiname=\"").append(be.ah(qcVar.bkV, "")).append("\" ");
                                        stringBuilder.append("/>");
                                        stringBuilder.append("</msg>");
                                        com.tencent.mm.pluginsdk.j.a.bmt().x(str, stringBuilder.toString(), 48);
                                        break;
                                    case 7:
                                        Context context2 = context2;
                                        pw n3 = v.n(iVar);
                                        WXMusicObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = n3.mrZ;
                                        wXMusicObject.musicDataUrl = n3.msb;
                                        wXMusicObject.musicLowBandUrl = n3.msd;
                                        wXMusicObject.musicLowBandDataUrl = n3.msd;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = n3.title;
                                        wXMediaMessage.description = n3.desc;
                                        readFromFile = be.readFromFile(v.g(n3));
                                        if (readFromFile == null) {
                                            readFromFile = be.readFromFile(v.alQ() + g.m(be.ah(n3.aZh, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile;
                                        String str4 = iVar.field_favProto.mtP.appId;
                                        l.a(wXMediaMessage, str4, com.tencent.mm.model.ab.a.csc.n(context2, str4), str, 3, null);
                                        break;
                                    case 8:
                                        p.a(str, iVar, v.n(iVar));
                                        break;
                                    case 10:
                                        context = context2;
                                        qeVar = iVar.field_favProto.mte;
                                        kbVar = new kb();
                                        kbVar.bkO.opType = 0;
                                        kbVar.bkO.bkQ = qeVar.info;
                                        kbVar.bkO.context = context;
                                        com.tencent.mm.sdk.c.a.nhr.z(kbVar);
                                        if (!kbVar.bkP.aYN) {
                                            break;
                                        }
                                        readFromFile2 = be.readFromFile(v.alQ() + g.m(be.ah(qeVar.bea, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = be.readFromFile(kbVar.bkP.bdZ);
                                        }
                                        com.tencent.mm.pluginsdk.j.a.bmt().a(str, readFromFile2, kbVar.bkP.bkR, null);
                                        break;
                                    case 11:
                                        context = context2;
                                        qeVar = iVar.field_favProto.mte;
                                        kbVar = new kb();
                                        kbVar.bkO.opType = 1;
                                        kbVar.bkO.bkQ = qeVar.info;
                                        kbVar.bkO.context = context;
                                        com.tencent.mm.sdk.c.a.nhr.z(kbVar);
                                        if (!kbVar.bkP.aYN) {
                                            break;
                                        }
                                        readFromFile2 = be.readFromFile(v.alQ() + g.m(be.ah(qeVar.bea, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = be.readFromFile(kbVar.bkP.bdZ);
                                        }
                                        com.tencent.mm.pluginsdk.j.a.bmt().a(str, readFromFile2, kbVar.bkP.bkR, null);
                                        break;
                                    case an.CTRL_INDEX /*14*/:
                                    case 18:
                                        v.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[]{Integer.valueOf(iVar.field_id)});
                                        if (iVar.field_id <= 0) {
                                            break;
                                        }
                                        a a = a.a(context2, iVar);
                                        qf qfVar = new qf();
                                        try {
                                            v.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            qfVar.az(iVar.field_favProto.toByteArray());
                                        } catch (Throwable e) {
                                            v.a("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                            v.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[]{e.getMessage()});
                                        }
                                        kw kwVar = new kw();
                                        kwVar.bmf.type = 2;
                                        kwVar.bmf.toUser = str;
                                        kwVar.bmf.bmi = qfVar;
                                        kwVar.bmf.title = a.title;
                                        kwVar.bmf.desc = a.desc;
                                        kwVar.bmf.bdZ = a.bdZ;
                                        kwVar.bmf.bmn = a.fKQ;
                                        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                                        break;
                                    case am.CTRL_INDEX /*15*/:
                                        context = context2;
                                        qj qjVar = iVar.field_favProto.mtg;
                                        pb pbVar = new pb();
                                        pbVar.bqo.opType = 0;
                                        pbVar.bqo.bqq = qjVar.info;
                                        pbVar.bqo.context = context;
                                        com.tencent.mm.sdk.c.a.nhr.z(pbVar);
                                        v.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[]{Boolean.valueOf(pbVar.bqp.aYN), qjVar.bea});
                                        if (!pbVar.bqp.aYN) {
                                            break;
                                        }
                                        readFromFile2 = be.readFromFile(v.alQ() + g.m(be.ah(qjVar.bea, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = be.readFromFile(pbVar.bqp.bdZ);
                                        }
                                        com.tencent.mm.pluginsdk.j.a.bmt().a(str, readFromFile2, pbVar.bqp.bkR, null);
                                        break;
                                    case 16:
                                        p.a(context2, str, v.n(iVar));
                                        break;
                                    case 17:
                                        com.tencent.mm.pluginsdk.j.a.bmt().x(str, v.n(iVar).desc, 42);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            v.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[]{Integer.valueOf(list2.size())});
                        }
                        if (!be.kS(str4)) {
                            com.tencent.mm.pluginsdk.j.a.bmt().x(str, str4, m.fp(str));
                        }
                    }
                    ad.o(runnable2);
                }

                public final String toString() {
                    return super.toString() + "|sendFavMsg";
                }
            });
        }
    }

    public static void a(Context context, final String str, final i iVar, final pw pwVar, final Runnable runnable) {
        if (context == null) {
            v.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
        } else if (be.kS(str)) {
            v.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
        } else {
            if (iVar == null) {
                v.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (pwVar == null) {
                v.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
            } else {
                ak.vA().x(new Runnable() {
                    public final void run() {
                        p.a(str, iVar, pwVar);
                        ad.o(runnable);
                    }

                    public final String toString() {
                        return super.toString() + "|sendFavFile";
                    }
                });
            }
        }
    }

    public static String b(pw pwVar) {
        File file = new File(v.g(pwVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return v.alQ() + g.m(be.ah(pwVar.aZh, "").getBytes());
    }
}
