package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.e.a.ok;
import com.tencent.mm.sdk.c.c;

public final class a extends c<ok> {
    public a() {
        this.nhz = ok.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b r19) {
        /*
        r18 = this;
        r19 = (com.tencent.mm.e.a.ok) r19;
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.userName;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0020;
    L_0x000e:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "invalid username or appId";
        r2.bpJ = r3;
        r2 = 1;
    L_0x001f:
        return r2;
    L_0x0020:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.scene;
        r3 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        if (r2 != r3) goto L_0x01ca;
    L_0x002a:
        r2 = new com.tencent.mm.v.b$a;
        r2.<init>();
        r3 = new com.tencent.mm.protocal.c.bgt;
        r3.<init>();
        r2.czn = r3;
        r3 = new com.tencent.mm.protocal.c.bgu;
        r3.<init>();
        r2.czo = r3;
        r3 = "/cgi-bin/mmux-bin/weappsearchadclick";
        r2.uri = r3;
        r3 = 1873; // 0x751 float:2.625E-42 double:9.254E-321;
        r2.czm = r3;
        r3 = r2.Bv();
        r2 = r3.czk;
        r2 = r2.czs;
        r2 = (com.tencent.mm.protocal.c.bgt) r2;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpE;
        r2.ncd = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpF;
        r2.nce = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpB;
        r2.mzu = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpC;
        r2.mPN = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.position;
        r2.ncf = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.userName;
        r2.hOq = r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r19;
        r5 = r0.bpu;
        r5 = r5.bpy;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2.ncg = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpG;
        r2.nch = r4;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpH;
        r2.nci = r4;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r5 = "20StatSessionId";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.ncd;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "21KeywordId";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.nce;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "22SearchId";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.mzu;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "23DocId";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.mPN;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "24Pos";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.ncf;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "25AppUserName";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.hOq;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "26AppVersion";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.ncg;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "27AdBuffer";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r2.nch;
        r6 = r6.append(r7);
        r7 = ",";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r4.n(r5, r6);
        r5 = "28AdClickBuffer";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = r2.nci;
        r2 = r6.append(r2);
        r6 = ",";
        r2 = r2.append(r6);
        r2 = r2.toString();
        r4.n(r5, r2);
        r2 = "MicroMsg.AppBrandLaunchFromOuterEventListener";
        r5 = new java.lang.StringBuilder;
        r6 = "doClickReportScene oreh";
        r5.<init>(r6);
        r6 = r4.JH();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.i(r2, r5);
        r2 = new com.tencent.mm.plugin.appbrand.launching.a$1;
        r0 = r18;
        r2.<init>(r0, r4);
        com.tencent.mm.v.u.a(r3, r2);
    L_0x01ca:
        r7 = new com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
        r7.<init>();
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.scene;
        r7.scene = r2;
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.aWP;
        r7.aWP = r2;
        r2 = r7.scene;
        r3 = 1026; // 0x402 float:1.438E-42 double:5.07E-321;
        if (r2 != r3) goto L_0x01eb;
    L_0x01e5:
        r2 = com.tencent.mm.plugin.appbrand.f.a.QN();
        r7.aWP = r2;
    L_0x01eb:
        r2 = 1;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.launchMode;
        if (r2 != r3) goto L_0x02e9;
    L_0x01f4:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0217;
    L_0x0200:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.context;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.userName;
        r4 = "";
        r5 = 0;
        r6 = -1;
        com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic.a(r2, r3, r4, r5, r6, r7);
    L_0x0214:
        r2 = 1;
        goto L_0x001f;
    L_0x0217:
        r3 = com.tencent.mm.plugin.appbrand.a.a.dzP;
        if (r3 != 0) goto L_0x021e;
    L_0x021b:
        r2 = 0;
        goto L_0x001f;
    L_0x021e:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r4 = 0;
        r2 = r3.Q(r2, r4);
        if (r2 == 0) goto L_0x023b;
    L_0x022b:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r4 == 0) goto L_0x025d;
    L_0x0237:
        r2 = 1;
    L_0x0238:
        r4 = 1;
        if (r2 != r4) goto L_0x02e6;
    L_0x023b:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r4 = 2;
        r2 = r3.Q(r2, r4);
        if (r2 == 0) goto L_0x02d6;
    L_0x0248:
        r5 = 2;
    L_0x0249:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.context;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.userName;
        r4 = "";
        r6 = -1;
        com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic.a(r2, r3, r4, r5, r6, r7);
        goto L_0x0214;
    L_0x025d:
        r8 = r3.dBf;
        r9 = "AppBrandWxaPkgManifestRecord";
        r4 = 2;
        r10 = new java.lang.String[r4];
        r4 = 0;
        r5 = "versionState";
        r10[r4] = r5;
        r4 = 1;
        r5 = "version";
        r10[r4] = r5;
        r4 = java.util.Locale.US;
        r5 = "%s=? and %s=? order by %s desc";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r11 = 0;
        r12 = "appId";
        r6[r11] = r12;
        r11 = 1;
        r12 = "debugType";
        r6[r11] = r12;
        r11 = 2;
        r12 = "version";
        r6[r11] = r12;
        r11 = java.lang.String.format(r4, r5, r6);
        r4 = 2;
        r12 = new java.lang.String[r4];
        r4 = 0;
        r12[r4] = r2;
        r2 = 1;
        r4 = "0";
        r12[r2] = r4;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r4 = r8.query(r9, r10, r11, r12, r13, r14, r15);
        if (r4 != 0) goto L_0x02a6;
    L_0x02a4:
        r2 = 1;
        goto L_0x0238;
    L_0x02a6:
        r2 = 1;
        r5 = r4.moveToFirst();
        if (r5 == 0) goto L_0x02d1;
    L_0x02ad:
        r2 = 0;
        r2 = r4.getInt(r2);
        r5 = 1;
        r5 = r4.getInt(r5);
        r6 = "MicroMsg.AppBrandWxaPkgStorage";
        r8 = "getAppVersionState, state = %d, version = %d";
        r9 = 2;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r2);
        r9[r10] = r11;
        r10 = 1;
        r5 = java.lang.Integer.valueOf(r5);
        r9[r10] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r6, r8, r9);
    L_0x02d1:
        r4.close();
        goto L_0x0238;
    L_0x02d6:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r4 = 1;
        r2 = r3.Q(r2, r4);
        if (r2 == 0) goto L_0x02e6;
    L_0x02e3:
        r5 = 1;
        goto L_0x0249;
    L_0x02e6:
        r5 = 0;
        goto L_0x0249;
    L_0x02e9:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.bpx;
        switch(r2) {
            case 0: goto L_0x0305;
            case 1: goto L_0x033a;
            case 2: goto L_0x0305;
            default: goto L_0x02f2;
        };
    L_0x02f2:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "invalid openType";
        r2.bpJ = r3;
        r2 = 1;
        goto L_0x001f;
    L_0x0305:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.bpy;
        if (r2 > 0) goto L_0x0333;
    L_0x030d:
        r6 = -1;
    L_0x030e:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.context;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.userName;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpw;
        r0 = r19;
        r5 = r0.bpu;
        r5 = r5.bpx;
        com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic.a(r2, r3, r4, r5, r6, r7);
    L_0x0329:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 1;
        r2.bpI = r3;
        r2 = 1;
        goto L_0x001f;
    L_0x0333:
        r0 = r19;
        r2 = r0.bpu;
        r6 = r2.bpy;
        goto L_0x030e;
    L_0x033a:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.bpA;
        if (r2 == 0) goto L_0x044d;
    L_0x0342:
        r0 = r19;
        r2 = r0.bpu;
        r3 = com.tencent.mm.plugin.appbrand.a.a.OO();
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.userName;
        r3 = r3.nd(r4);
        r2.appId = r3;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r2 != 0) goto L_0x03ea;
    L_0x035c:
        r2 = com.tencent.mm.plugin.appbrand.a.a.dzP;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.appId;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpx;
        r8 = r2.dBf;
        r9 = "AppBrandWxaPkgManifestRecord";
        r2 = 1;
        r10 = new java.lang.String[r2];
        r2 = 0;
        r5 = "pkgPath";
        r10[r2] = r5;
        r2 = java.util.Locale.US;
        r5 = "%s=? and %s=?";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r11 = 0;
        r12 = "appId";
        r6[r11] = r12;
        r11 = 1;
        r12 = "debugType";
        r6[r11] = r12;
        r11 = java.lang.String.format(r2, r5, r6);
        r2 = 2;
        r12 = new java.lang.String[r2];
        r2 = 0;
        r12[r2] = r3;
        r2 = 1;
        r3 = java.lang.String.valueOf(r4);
        r12[r2] = r3;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r3 = r8.query(r9, r10, r11, r12, r13, r14, r15);
        if (r3 != 0) goto L_0x03d9;
    L_0x03a6:
        r2 = 0;
    L_0x03a7:
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r3 != 0) goto L_0x03ea;
    L_0x03ad:
        r2 = com.tencent.mm.a.e.aR(r2);
        if (r2 == 0) goto L_0x03ea;
    L_0x03b3:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 1;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.context;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.userName;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpw;
        r0 = r19;
        r5 = r0.bpu;
        r5 = r5.bpx;
        r6 = 0;
        com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic.a(r2, r3, r4, r5, r6, r7);
        r2 = 1;
        goto L_0x001f;
    L_0x03d9:
        r2 = r3.moveToFirst();
        if (r2 == 0) goto L_0x03e8;
    L_0x03df:
        r2 = 0;
        r2 = r3.getString(r2);
    L_0x03e4:
        r3.close();
        goto L_0x03a7;
    L_0x03e8:
        r2 = 0;
        goto L_0x03e4;
    L_0x03ea:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "local pkg not exists";
        r2.bpJ = r3;
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.dAl;
        if (r2 == 0) goto L_0x0436;
    L_0x0402:
        r2 = 0;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.bpx;
        r4 = 1;
        if (r3 != r4) goto L_0x0439;
    L_0x040c:
        r2 = 2131230920; // 0x7f0800c8 float:1.8077906E38 double:1.052967981E-314;
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r2 = com.tencent.mm.plugin.appbrand.k.a.d(r2, r3);
    L_0x0416:
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.context;
        r4 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r5 = 0;
        r5 = new java.lang.Object[r5];
        r4 = com.tencent.mm.plugin.appbrand.k.a.d(r4, r5);
        r5 = 2131231107; // 0x7f080183 float:1.8078286E38 double:1.0529680733E-314;
        r6 = 0;
        r6 = new java.lang.Object[r6];
        r5 = com.tencent.mm.plugin.appbrand.k.a.d(r5, r6);
        r6 = "";
        com.tencent.mm.plugin.appbrand.ipc.a.a(r3, r2, r4, r5, r6);
    L_0x0436:
        r2 = 1;
        goto L_0x001f;
    L_0x0439:
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.bpx;
        r4 = 2;
        if (r3 != r4) goto L_0x0416;
    L_0x0442:
        r2 = 2131236731; // 0x7f08177b float:1.8089692E38 double:1.052970852E-314;
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r2 = com.tencent.mm.plugin.appbrand.k.a.d(r2, r3);
        goto L_0x0416;
    L_0x044d:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x046c;
    L_0x0459:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "invalid username or appId";
        r2.bpJ = r3;
        r2 = 1;
        goto L_0x001f;
    L_0x046c:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.beq;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x0484;
    L_0x0478:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.bpz;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0497;
    L_0x0484:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "invalid downloadURL or checkSumMd5";
        r2.bpJ = r3;
        r2 = 1;
        goto L_0x001f;
    L_0x0497:
        r9 = com.tencent.mm.plugin.appbrand.a.a.dzP;
        r0 = r19;
        r2 = r0.bpu;
        r10 = r2.appId;
        r0 = r19;
        r2 = r0.bpu;
        r11 = r2.bpx;
        r0 = r19;
        r2 = r0.bpu;
        r12 = r2.beq;
        r0 = r19;
        r2 = r0.bpu;
        r13 = r2.bpz;
        r14 = 0;
        r16 = 0;
        r2 = r9.a(r10, r11, r12, r13, r14, r16);
        if (r2 != 0) goto L_0x04e2;
    L_0x04bb:
        r2 = com.tencent.mm.plugin.appbrand.a.a.dzP;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.appId;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpx;
        r2 = r2.Q(r3, r4);
        if (r2 != 0) goto L_0x04f1;
    L_0x04cf:
        r0 = r19;
        r2 = r0.bpv;
        r3 = 0;
        r2.bpI = r3;
        r0 = r19;
        r2 = r0.bpv;
        r3 = "install app failed";
        r2.bpJ = r3;
        r2 = 1;
        goto L_0x001f;
    L_0x04e2:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.appId;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.bpx;
        com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager.ab(r2, r3);
    L_0x04f1:
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.beq;
        r7.aWP = r2;
        r0 = r19;
        r2 = r0.bpu;
        r2 = r2.context;
        r0 = r19;
        r3 = r0.bpu;
        r3 = r3.userName;
        r0 = r19;
        r4 = r0.bpu;
        r4 = r4.bpw;
        r0 = r19;
        r5 = r0.bpu;
        r5 = r5.bpx;
        r6 = -1;
        com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic.a(r2, r3, r4, r5, r6, r7);
        goto L_0x0329;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.a.a(com.tencent.mm.sdk.c.b):boolean");
    }
}
