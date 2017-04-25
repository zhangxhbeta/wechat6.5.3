package com.tencent.mm.plugin.f.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.vending.b.b;

public final class a implements i {
    private static final a hkJ = new a();

    private static final class a extends com.tencent.mm.av.a<com.tencent.mm.plugin.f.a.a.a> implements com.tencent.mm.plugin.f.a.a.a {
        private a() {
        }

        public final void a(u uVar, u uVar2, ais com_tencent_mm_protocal_c_ais, byte[] bArr, boolean z, boolean z2) {
            final u uVar3 = uVar;
            final u uVar4 = uVar2;
            final ais com_tencent_mm_protocal_c_ais2 = com_tencent_mm_protocal_c_ais;
            final byte[] bArr2 = bArr;
            final boolean z3 = z;
            final boolean z4 = z2;
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.f.a.a.a>(this) {
                final /* synthetic */ a hkQ;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.f.a.a.a) obj).a(uVar3, uVar4, com_tencent_mm_protocal_c_ais2, bArr2, z3, z4);
                }
            });
        }

        public final void b(u uVar, u uVar2, ais com_tencent_mm_protocal_c_ais, byte[] bArr, boolean z, boolean z2) {
            final u uVar3 = uVar;
            final u uVar4 = uVar2;
            final ais com_tencent_mm_protocal_c_ais2 = com_tencent_mm_protocal_c_ais;
            final byte[] bArr2 = bArr;
            final boolean z3 = z;
            final boolean z4 = z2;
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.f.a.a.a>(this) {
                final /* synthetic */ a hkQ;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.f.a.a.a) obj).b(uVar3, uVar4, com_tencent_mm_protocal_c_ais2, bArr2, z3, z4);
                }
            });
        }

        public final void a(final mi miVar) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.f.a.a.a>(this) {
                final /* synthetic */ a hkQ;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.f.a.a.a) obj).a(miVar);
                }
            });
        }
    }

    public static b a(com.tencent.mm.plugin.f.a.a.a aVar) {
        return hkJ.ay(aVar);
    }

    public final void a(kz kzVar, byte[] bArr, boolean z, j jVar) {
        switch (kzVar.bkM) {
            case 2:
            case 17:
                ais com_tencent_mm_protocal_c_ais = (ais) new ais().az(bArr);
                if (!z) {
                    bArr = null;
                }
                a(com_tencent_mm_protocal_c_ais, bArr, false, z);
                return;
            case 4:
                mi miVar = (mi) new mi().az(bArr);
                String a = m.a(miVar.moM);
                v.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a);
                ((d) g.f(d.class)).wK().Mf(a);
                com.tencent.mm.model.m.eF(a);
                hkJ.a(miVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.c.ais r10, byte[] r11, boolean r12, boolean r13) {
        /*
        if (r10 != 0) goto L_0x000c;
    L_0x0002:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "unable to parse mod contact";
        com.tencent.mm.sdk.platformtools.v.f(r0, r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r10.moM;
        r3 = com.tencent.mm.platformtools.m.a(r0);
        r0 = r10.mJd;
        r7 = com.tencent.mm.sdk.platformtools.be.ma(r0);
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r0 == 0) goto L_0x0037;
    L_0x001e:
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r0 == 0) goto L_0x0037;
    L_0x0024:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "processModContact user is null user:%s enuser:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r3 = 1;
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        goto L_0x000b;
    L_0x0037:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "username %s mobileHash %s mobileFullHash %s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = r10.moM;
        r2[r4] = r5;
        r4 = 1;
        r5 = r10.mJg;
        r2[r4] = r5;
        r4 = 2;
        r5 = r10.mJh;
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wH();
        r1 = r0.LX(r3);
        if (r1 == 0) goto L_0x007c;
    L_0x0064:
        r0 = r1.field_encryptUsername;
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x006c:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "cat's replace user with stranger  user:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
        goto L_0x000b;
    L_0x007c:
        r0 = 0;
        if (r1 == 0) goto L_0x0361;
    L_0x007f:
        r2 = r1.bvs();
        if (r2 == 0) goto L_0x0361;
    L_0x0085:
        if (r1 != 0) goto L_0x008c;
    L_0x0087:
        r1 = new com.tencent.mm.storage.u;
        r1.<init>(r3);
    L_0x008c:
        r1.setUsername(r3);
        r0 = r10.cHh;
        r1.bP(r0);
        r0 = r10.mnV;
        r4 = r10.mnW;
        r0 = r0 & r4;
        r1.setType(r0);
        if (r12 == 0) goto L_0x00ce;
    L_0x009e:
        if (r2 == 0) goto L_0x00ce;
    L_0x00a0:
        r4 = r2.chr;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00ce;
    L_0x00a5:
        r0 = "MicroMsg.ContactSyncExtension";
        r4 = "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r3;
        r6 = 1;
        r8 = r2.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r6] = r8;
        r6 = 2;
        r8 = r1.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r6] = r8;
        com.tencent.mm.sdk.platformtools.v.w(r0, r4, r5);
        r0 = r1.field_type;
        r4 = r2.field_type;
        r0 = r0 | r4;
        r1.setType(r0);
    L_0x00ce:
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r0 != 0) goto L_0x02ce;
    L_0x00d4:
        r1.bY(r7);
    L_0x00d7:
        if (r2 != 0) goto L_0x02dc;
    L_0x00d9:
        r4 = 0;
    L_0x00db:
        r1.chr = r4;
        r0 = r10.mEj;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bS(r0);
        r0 = r10.moC;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bT(r0);
        r0 = r10.moD;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bU(r0);
        r0 = r10.cHc;
        r1.cV(r0);
        r0 = r10.mob;
        r1.cY(r0);
        r0 = r10.mIX;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bR(r0);
        r0 = r10.mof;
        r1.cZ(r0);
        r0 = r10.cHg;
        r1.da(r0);
        r0 = r10.cHl;
        r4 = r10.cHd;
        r5 = r10.cHe;
        r0 = com.tencent.mm.storage.RegionCodeDecoder.Y(r0, r4, r5);
        r1.cl(r0);
        r0 = r10.cHf;
        r1.cf(r0);
        r0 = r10.mFu;
        r1.cR(r0);
        r0 = r10.mFv;
        r1.ck(r0);
        r0 = r10.mcP;
        r1.setSource(r0);
        r0 = r10.mFy;
        r1.cQ(r0);
        r0 = r10.mFx;
        r1.bV(r0);
        r0 = r10.mFw;
        r0 = com.tencent.mm.model.m.ft(r0);
        if (r0 == 0) goto L_0x014d;
    L_0x0148:
        r0 = r10.mFw;
        r1.cj(r0);
    L_0x014d:
        r0 = r1.bvp();
        if (r0 == 0) goto L_0x015b;
    L_0x0153:
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r0 = (int) r4;
        r1.dc(r0);
    L_0x015b:
        r0 = r10.mIO;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bQ(r0);
        r0 = r10.mIQ;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bW(r0);
        r0 = r10.mIP;
        r0 = com.tencent.mm.platformtools.m.a(r0);
        r1.bX(r0);
        r0 = r10.moP;
        r1.bZ(r0);
        r0 = r10.mdJ;
        r1.cm(r0);
        r0 = r10.mJn;
        r1.cn(r0);
        r0 = com.tencent.mm.sdk.platformtools.be.bl(r11);
        if (r0 != 0) goto L_0x0320;
    L_0x018b:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wH();
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r4 == 0) goto L_0x02e2;
    L_0x019d:
        r0 = "MicroMsg.ContactStorage";
        r4 = "getCmdbuf failed user is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r4);
    L_0x01a6:
        r0 = r10.mJm;
        r1.cT(r0);
        r0 = r10.mJi;
        if (r0 == 0) goto L_0x01d0;
    L_0x01af:
        r0 = r10.mJi;
        r0 = r0.mck;
        if (r0 == 0) goto L_0x01d0;
    L_0x01b5:
        r0 = r10.mJi;
        r0 = r0.mck;
        r0 = r0.mgp;
        r1.co(r0);
        r0 = r10.mJi;
        r0 = r0.mck;
        r0 = r0.mgq;
        r1.cp(r0);
        r0 = r10.mJi;
        r0 = r0.mck;
        r0 = r0.mgr;
        r1.cq(r0);
    L_0x01d0:
        if (r2 == 0) goto L_0x01df;
    L_0x01d2:
        r0 = r2.field_type;
        r0 = com.tencent.mm.i.a.ei(r0);
        if (r0 != 0) goto L_0x01df;
    L_0x01da:
        r0 = r1.field_type;
        com.tencent.mm.i.a.ei(r0);
    L_0x01df:
        r0 = com.tencent.mm.model.m.fn(r3);
        if (r0 == 0) goto L_0x01e8;
    L_0x01e5:
        r1.tw();
    L_0x01e8:
        r0 = r1.bvm();
        if (r0 == 0) goto L_0x01f1;
    L_0x01ee:
        r1.tz();
    L_0x01f1:
        r0 = r10.bCy;
        r1.cr(r0);
        r0 = "MicroMsg.ContactSyncExtension";
        r4 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b";
        r5 = 17;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r3;
        r3 = 1;
        r5[r3] = r7;
        r3 = 2;
        r8 = r1.chr;
        r6 = (int) r8;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 3;
        r6 = r1.field_nickname;
        r5[r3] = r6;
        r3 = 4;
        r6 = r1.pF();
        r5[r3] = r6;
        r3 = 5;
        r6 = r1.field_deleteFlag;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 6;
        r6 = r1.field_type;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 7;
        r6 = r10.mnV;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 8;
        r6 = r10.mnW;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 9;
        r6 = r1.bCe;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 10;
        r6 = r1.bCh;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 11;
        r6 = r10.cHl;
        r5[r3] = r6;
        r3 = 12;
        r6 = r10.cHd;
        r5[r3] = r6;
        r3 = 13;
        r6 = r10.cHe;
        r5[r3] = r6;
        r3 = 14;
        r6 = r1.bbT;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        r3 = 15;
        r6 = r1.field_contactLabelIds;
        r5[r3] = r6;
        r3 = 16;
        r6 = java.lang.Boolean.valueOf(r12);
        r5[r3] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r0, r4, r5);
        r0 = hkJ;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r6 = r13;
        r0.a(r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r0 != 0) goto L_0x0331;
    L_0x0291:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wH();
        r0.b(r7, r1);
    L_0x02a0:
        r0 = hkJ;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r6 = r13;
        r0.b(r1, r2, r3, r4, r5, r6);
        r0 = r1.field_type;
        r0 = r0 & 2048;
        if (r0 == 0) goto L_0x0342;
    L_0x02af:
        if (r2 == 0) goto L_0x02bb;
    L_0x02b1:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x02bb:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wK();
        r1 = r1.field_username;
        r0.Ml(r1);
        goto L_0x000b;
    L_0x02ce:
        if (r2 == 0) goto L_0x00d7;
    L_0x02d0:
        r4 = r2.chr;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00d7;
    L_0x02d5:
        r0 = r2.field_encryptUsername;
        r1.bY(r0);
        goto L_0x00d7;
    L_0x02dc:
        r4 = r2.chr;
        r0 = (int) r4;
        r4 = (long) r0;
        goto L_0x00db;
    L_0x02e2:
        r4 = new com.tencent.mm.storage.v;
        r4.<init>();
        r4.field_cmdbuf = r11;
        r4.field_username = r3;
        r0 = r0.cie;
        r5 = "ContactCmdBuf";
        r6 = "username";
        r4 = r4.py();
        r4 = r0.replace(r5, r6, r4);
        r4 = (int) r4;
        r5 = "MicroMsg.ContactStorage";
        r6 = "setCmdbuf user:%s buf:%d result:%d";
        r0 = 3;
        r8 = new java.lang.Object[r0];
        r0 = 0;
        r8[r0] = r3;
        r9 = 1;
        if (r11 != 0) goto L_0x031e;
    L_0x030b:
        r0 = -1;
    L_0x030c:
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        r0 = 2;
        r4 = java.lang.Integer.valueOf(r4);
        r8[r0] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r5, r6, r8);
        goto L_0x01a6;
    L_0x031e:
        r0 = r11.length;
        goto L_0x030c;
    L_0x0320:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wH();
        r0.Mb(r3);
        goto L_0x01a6;
    L_0x0331:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wH();
        r0.M(r1);
        goto L_0x02a0;
    L_0x0342:
        if (r2 == 0) goto L_0x034e;
    L_0x0344:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x034e:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.wK();
        r1 = r1.field_username;
        r0.Mm(r1);
        goto L_0x000b;
    L_0x0361:
        r2 = r1;
        r1 = r0;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.f.a.a.a(com.tencent.mm.protocal.c.ais, byte[], boolean, boolean):void");
    }
}
