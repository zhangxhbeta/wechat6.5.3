package com.tencent.mm.plugin.favorite;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.c.c;
import java.io.File;

public final class f extends c<ez> {
    public f() {
        this.nhz = ez.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b r19) {
        /*
        r18 = this;
        r19 = (com.tencent.mm.e.a.ez) r19;
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.type;
        switch(r2) {
            case 2: goto L_0x003c;
            case 3: goto L_0x000b;
            case 4: goto L_0x000d;
            case 5: goto L_0x000b;
            case 6: goto L_0x0083;
            case 7: goto L_0x009e;
            case 8: goto L_0x00b0;
            case 9: goto L_0x00c1;
            case 10: goto L_0x00e4;
            case 11: goto L_0x0100;
            case 12: goto L_0x0130;
            case 13: goto L_0x0141;
            case 14: goto L_0x016c;
            case 15: goto L_0x0185;
            case 16: goto L_0x0198;
            case 17: goto L_0x01ab;
            case 18: goto L_0x01bd;
            case 19: goto L_0x0263;
            case 20: goto L_0x02e4;
            case 21: goto L_0x033b;
            case 22: goto L_0x0357;
            case 23: goto L_0x0363;
            case 24: goto L_0x036f;
            case 25: goto L_0x0394;
            case 26: goto L_0x03a0;
            case 27: goto L_0x03f5;
            case 28: goto L_0x0431;
            case 29: goto L_0x000b;
            case 30: goto L_0x044b;
            case 31: goto L_0x0468;
            case 32: goto L_0x047d;
            case 33: goto L_0x04b4;
            case 34: goto L_0x04e3;
            case 35: goto L_0x0503;
            case 36: goto L_0x0508;
            default: goto L_0x000b;
        };
    L_0x000b:
        r2 = 0;
        return r2;
    L_0x000d:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x001d:
        r3 = r2.field_tagProto;
        r3 = r3.mub;
        if (r3 == 0) goto L_0x000b;
    L_0x0023:
        r0 = r19;
        r3 = r0.bdR;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r3.bdY = r4;
        r0 = r19;
        r3 = r0.bdR;
        r3 = r3.bdY;
        r2 = r2.field_tagProto;
        r2 = r2.mub;
        r3.addAll(r2);
        goto L_0x000b;
    L_0x003c:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.bdS;
        if (r2 == 0) goto L_0x000b;
    L_0x0044:
        r2 = new java.io.File;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdS;
        r3 = com.tencent.mm.plugin.favorite.b.v.f(r3);
        r2.<init>(r3);
        r3 = r2.exists();
        if (r3 == 0) goto L_0x0063;
    L_0x0059:
        r0 = r19;
        r3 = r0.bdR;
        r2 = r2.getAbsolutePath();
        r3.path = r2;
    L_0x0063:
        r2 = new java.io.File;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdS;
        r3 = com.tencent.mm.plugin.favorite.b.v.g(r3);
        r2.<init>(r3);
        r3 = r2.exists();
        if (r3 == 0) goto L_0x000b;
    L_0x0078:
        r0 = r19;
        r3 = r0.bdR;
        r2 = r2.getAbsolutePath();
        r3.bdZ = r2;
        goto L_0x000b;
    L_0x0083:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdT;
        r2.c(r3);
        r0 = r19;
        r2 = r0.bdR;
    L_0x0094:
        r3 = 0;
        r17 = r3;
        r3 = r2;
        r2 = r17;
    L_0x009a:
        r3.ret = r2;
        goto L_0x000b;
    L_0x009e:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdT;
        r2.d(r3);
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x00b0:
        r0 = r19;
        r2 = r0.bdR;
        r3 = com.tencent.mm.plugin.favorite.h.alu();
        r3 = r3.cie;
        r2.bec = r3;
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x00c1:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        r0 = r19;
        r3 = r0.bdR;
        r4 = r2.field_type;
        r5 = r2.field_favProto;
        r2 = r2.field_tagProto;
        r2 = com.tencent.mm.pluginsdk.model.c.a(r4, r5, r2);
        r3.beb = r2;
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x00e4:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.context;
        com.tencent.mm.plugin.favorite.ui.c.e.b(r3, r2);
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x0100:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.handler;
        r2 = com.tencent.mm.plugin.favorite.ui.c.e.a(r2, r3);
        r0 = r19;
        r3 = r0.bdR;
        r4 = 0;
        r4 = r2[r4];
        r3.bdZ = r4;
        r0 = r19;
        r3 = r0.bdR;
        r4 = 1;
        r2 = r2[r4];
        r3.bea = r2;
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x0130:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.aZa;
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.bdU;
        com.tencent.mm.plugin.favorite.b.v.a(r2, r4);
        goto L_0x000b;
    L_0x0141:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.context;
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.toUser;
        r0 = r19;
        r5 = r0.bdQ;
        r5 = r5.bdV;
        r0 = r19;
        r6 = r0.bdQ;
        r6 = r6.bdU;
        com.tencent.mm.plugin.favorite.b.p.a(r3, r4, r5, r2, r6);
        goto L_0x000b;
    L_0x016c:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.bdS;
        r2 = com.tencent.mm.plugin.favorite.b.v.c(r2);
        if (r2 == 0) goto L_0x017f;
    L_0x0178:
        r0 = r19;
        r3 = r0.bdR;
        r2 = 1;
        goto L_0x009a;
    L_0x017f:
        r0 = r19;
        r2 = r0.bdR;
        goto L_0x0094;
    L_0x0185:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        com.tencent.mm.plugin.favorite.b.v.l(r2);
        goto L_0x000b;
    L_0x0198:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        com.tencent.mm.plugin.favorite.b.v.m(r2);
        goto L_0x000b;
    L_0x01ab:
        r0 = r19;
        r3 = r0.bdR;
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.bdS;
        r2 = r2.msh;
        r2 = com.tencent.mm.plugin.favorite.b.v.sZ(r2);
        goto L_0x009a;
    L_0x01bd:
        r4 = new java.util.ArrayList;
        r4.<init>();
        r2 = 7;
        r2 = java.lang.Integer.valueOf(r2);
        r4.add(r2);
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = com.tencent.mm.plugin.favorite.b.v.a(r2, r3, r4, r5, r6, r7);
        r13 = new java.util.ArrayList;
        r13.<init>();
        r14 = r2.iterator();
    L_0x01dc:
        r2 = r14.hasNext();
        if (r2 == 0) goto L_0x025b;
    L_0x01e2:
        r2 = r14.next();
        r2 = (com.tencent.mm.plugin.favorite.b.i) r2;
        r3 = r2.field_favProto;
        r15 = r3.mtP;
        r3 = r2.field_type;
        r4 = 7;
        if (r3 != r4) goto L_0x0215;
    L_0x01f1:
        r9 = com.tencent.mm.plugin.favorite.b.v.n(r2);
        r11 = a(r9);
        r2 = 6;
        r3 = 0;
        r4 = r9.title;
        r5 = r9.desc;
        r6 = r9.mrZ;
        r7 = r9.msd;
        r8 = r9.msb;
        r9 = r9.luu;
        r10 = com.tencent.mm.plugin.favorite.b.v.alS();
        r12 = r15.appId;
        r2 = com.tencent.mm.ai.b.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        r13.add(r2);
        goto L_0x01dc;
    L_0x0215:
        r3 = r2.field_type;
        r4 = 14;
        if (r3 != r4) goto L_0x01dc;
    L_0x021b:
        r3 = r2.field_favProto;
        r3 = r3.mtR;
        if (r3 == 0) goto L_0x01dc;
    L_0x0221:
        r2 = r2.field_favProto;
        r2 = r2.mtR;
        r16 = r2.iterator();
    L_0x0229:
        r2 = r16.hasNext();
        if (r2 == 0) goto L_0x01dc;
    L_0x022f:
        r2 = r16.next();
        r9 = r2;
        r9 = (com.tencent.mm.protocal.c.pw) r9;
        r2 = r9.aKG;
        r3 = 7;
        if (r2 != r3) goto L_0x0229;
    L_0x023b:
        r11 = a(r9);
        r2 = 6;
        r3 = 0;
        r4 = r9.title;
        r5 = r9.desc;
        r6 = r9.mrZ;
        r7 = r9.msd;
        r8 = r9.msb;
        r9 = r9.luu;
        r10 = com.tencent.mm.plugin.favorite.b.v.alS();
        r12 = r15.appId;
        r2 = com.tencent.mm.ai.b.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        r13.add(r2);
        goto L_0x0229;
    L_0x025b:
        r0 = r19;
        r2 = r0.bdR;
        r2.bed = r13;
        goto L_0x000b;
    L_0x0263:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.aZa;
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0299;
    L_0x026f:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.title;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.aZf;
        r3 = r3.mtR;
        r2 = r2.length();
        if (r2 != 0) goto L_0x028e;
    L_0x0283:
        r2 = "MicroMsg.FavPostLogic";
        r3 = "postNote null";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
        goto L_0x000b;
    L_0x028e:
        r4 = -1;
        r2 = com.tencent.mm.plugin.favorite.b.l.a(r3, r4);
        com.tencent.mm.plugin.favorite.c.a.u(r2);
        goto L_0x000b;
    L_0x0299:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.aZf;
        r2 = r2.mtR;
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = com.tencent.mm.plugin.favorite.b.l.a(r2, r4);
        r3 = r2.field_favProto;
        r3 = r3.version;
        if (r3 == 0) goto L_0x02d8;
    L_0x02b1:
        r3 = r2.field_favProto;
        r4 = r2.field_favProto;
        r4 = r4.version;
        r4 = r4 + 1;
        r3.uM(r4);
    L_0x02bc:
        r3 = 1;
        r2.field_itemStatus = r3;
        r3 = com.tencent.mm.plugin.favorite.h.alu();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r3.a(r2, r4);
        r2 = com.tencent.mm.plugin.favorite.h.all();
        r2.run();
        goto L_0x000b;
    L_0x02d8:
        r3 = r2.field_favProto;
        r4 = r2.field_favProto;
        r4 = r4.version;
        r4 = r4 + 2;
        r3.uM(r4);
        goto L_0x02bc;
    L_0x02e4:
        r2 = com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amm();
        com.tencent.mm.plugin.favorite.b.af.fMi = r3;
        r3.a(r2);
        r2 = com.tencent.mm.plugin.favorite.b.af.fMi;
        r3 = 1;
        r2.fLv = r3;
        r2 = com.tencent.mm.plugin.favorite.b.af.fMi;
        r3 = com.tencent.mm.plugin.favorite.b.u.evt;
        if (r3 != 0) goto L_0x0307;
    L_0x02fc:
        r3 = new com.tencent.mm.sdk.platformtools.SensorController;
        r4 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r3.<init>(r4);
        com.tencent.mm.plugin.favorite.b.u.evt = r3;
    L_0x0307:
        r3 = r2.evx;
        if (r3 != 0) goto L_0x0316;
    L_0x030b:
        r3 = new com.tencent.mm.sdk.platformtools.av;
        r4 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r3.<init>(r4);
        r2.evx = r3;
    L_0x0316:
        r2 = com.tencent.mm.plugin.favorite.b.af.aml();
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.title;
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.bdW;
        r0 = r19;
        r5 = r0.bdQ;
        r5 = r5.bdX;
        r6 = "";
        r3 = com.tencent.mm.sdk.platformtools.be.ah(r3, r6);
        r2.path = r3;
        r2.bdW = r4;
        r2.duration = r5;
        goto L_0x000b;
    L_0x033b:
        r0 = r19;
        r2 = r0.bdR;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.context;
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.bdX;
        r3 = com.tencent.mm.plugin.favorite.b.s.s(r3, r4);
        r3 = r3.toString();
        r2.path = r3;
        goto L_0x000b;
    L_0x0357:
        com.tencent.mm.plugin.favorite.b.af.aml();
        r2 = com.tencent.mm.plugin.favorite.b.af.amn();
        r2.destroy();
        goto L_0x000b;
    L_0x0363:
        com.tencent.mm.plugin.favorite.b.af.aml();
        r2 = com.tencent.mm.plugin.favorite.b.af.amn();
        r2.alO();
        goto L_0x000b;
    L_0x036f:
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.path;
        r0 = r19;
        r5 = r0.bdQ;
        r5 = r5.bdW;
        r0 = r19;
        r6 = r0.bdQ;
        r6 = r6.bdX;
        r3 = r3.x(r4, r5, r6);
        r2.bee = r3;
        goto L_0x000b;
    L_0x0394:
        com.tencent.mm.plugin.favorite.b.af.aml();
        r2 = com.tencent.mm.plugin.favorite.b.af.amn();
        r2.XV();
        goto L_0x000b;
    L_0x03a0:
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r3 = r3.path;
        r2.path = r3;
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r3 = r3.alM();
        r2.bee = r3;
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r3 = r3.alN();
        r2.bef = r3;
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r3 = r3.oZ();
        r2.beg = r3;
        r0 = r19;
        r2 = r0.bdR;
        com.tencent.mm.plugin.favorite.b.af.aml();
        r3 = com.tencent.mm.plugin.favorite.b.af.amn();
        r4 = r3.oY();
        r2.beh = r4;
        goto L_0x000b;
    L_0x03f5:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.bdS;
        if (r2 == 0) goto L_0x000b;
    L_0x03fd:
        r2 = new java.io.File;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdS;
        r3 = com.tencent.mm.plugin.favorite.b.v.f(r3);
        r2.<init>(r3);
        r0 = r19;
        r3 = r0.bdR;
        r2 = r2.getAbsolutePath();
        r3.path = r2;
        r2 = new java.io.File;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdS;
        r3 = com.tencent.mm.plugin.favorite.b.v.g(r3);
        r2.<init>(r3);
        r0 = r19;
        r3 = r0.bdR;
        r2 = r2.getAbsolutePath();
        r3.bdZ = r2;
        goto L_0x000b;
    L_0x0431:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.bdS;
        r4 = 1;
        com.tencent.mm.plugin.favorite.b.v.a(r2, r3, r4);
        goto L_0x000b;
    L_0x044b:
        r2 = new com.tencent.mm.plugin.favorite.b.i;
        r2.<init>();
        r3 = 18;
        r2.field_type = r3;
        r0 = r19;
        r3 = r0.bdQ;
        r3 = r3.aZf;
        r2.field_favProto = r3;
        r0 = r19;
        r3 = r0.bdR;
        r2 = com.tencent.mm.plugin.favorite.b.i.b(r2);
        r3.path = r2;
        goto L_0x000b;
    L_0x0468:
        r0 = r19;
        r2 = r0.bdQ;
        r2 = r2.aZJ;
        r2 = (com.tencent.mm.plugin.favorite.b.ad) r2;
        r0 = r19;
        r3 = r0.bdR;
        r4 = r2.fMe;
        r3.path = r4;
        com.tencent.mm.plugin.favorite.b.v.a(r2);
        goto L_0x000b;
    L_0x047d:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r3 = r2.bB(r4);
        r2 = new com.tencent.mm.plugin.favorite.b.o;
        r2.<init>();
        r0 = r19;
        r4 = r0.bdR;
        r2 = r2.g(r3);
        if (r2 == 0) goto L_0x04b2;
    L_0x049a:
        r2 = 1;
    L_0x049b:
        r4.ret = r2;
        r0 = r19;
        r2 = r0.bdR;
        r4 = com.tencent.mm.plugin.favorite.b.o.h(r3);
        r2.beg = r4;
        if (r3 != 0) goto L_0x000b;
    L_0x04a9:
        r0 = r19;
        r2 = r0.bdR;
        r3 = 1;
        r2.beg = r3;
        goto L_0x000b;
    L_0x04b2:
        r2 = 0;
        goto L_0x049b;
    L_0x04b4:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x04c4:
        r3 = r2.field_favProto;
        r0 = r19;
        r4 = r0.bdQ;
        r4 = r4.aZf;
        r4 = r4.mtR;
        r3.ah(r4);
        r3 = com.tencent.mm.plugin.favorite.h.alu();
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "localId";
        r4[r5] = r6;
        r3.b(r2, r4);
        goto L_0x000b;
    L_0x04e3:
        r2 = com.tencent.mm.plugin.favorite.h.alu();
        r0 = r19;
        r3 = r0.bdQ;
        r4 = r3.aZa;
        r2 = r2.bB(r4);
        if (r2 == 0) goto L_0x000b;
    L_0x04f3:
        r3 = r2.field_type;
        r4 = 18;
        if (r3 != r4) goto L_0x000b;
    L_0x04f9:
        r0 = r19;
        r3 = r0.bdQ;
        r2 = r2.field_favProto;
        r3.aZf = r2;
        goto L_0x000b;
    L_0x0503:
        com.tencent.mm.plugin.favorite.b.v.amd();
        goto L_0x000b;
    L_0x0508:
        r0 = r19;
        r2 = r0.bdR;
        r3 = com.tencent.mm.plugin.favorite.b.v.alZ();
        if (r3 == 0) goto L_0x0094;
    L_0x0512:
        r3 = 1;
        r17 = r3;
        r3 = r2;
        r2 = r17;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.f.a(com.tencent.mm.sdk.c.b):boolean");
    }

    private static String a(pw pwVar) {
        File file = new File(v.g(pwVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        if (pwVar.aZh == null) {
            return "";
        }
        file = new File(v.alQ() + g.m(pwVar.aZh.getBytes()));
        return file.exists() ? file.getAbsolutePath() : "";
    }
}
