package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.Map;

public final class c extends k implements j {
    protected static int cQR = 7;
    private String biS;
    private int cQS;
    private com.tencent.mm.compatible.util.g.a cQT;
    private StringBuilder cQU;
    private long cQV;
    private boolean cQW;
    private e cii;
    private ah cxS;
    private int errCode;
    private int errType;

    public static class a implements p {
        private final com.tencent.mm.protocal.x.a cQZ;
        private final b cRa;
        private final boolean cRb;
        int uin;

        public a() {
            this.cQZ = new com.tencent.mm.protocal.x.a();
            this.cRa = new b();
            this.cRb = false;
        }

        public a(b bVar) {
            this.cQZ = new com.tencent.mm.protocal.x.a();
            this.cRa = bVar;
            this.cRb = true;
        }

        public final d ze() {
            return this.cRa;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        public final com.tencent.mm.protocal.l.c Bx() {
            this.cQZ.lWP = com.tencent.mm.compatible.d.p.rK();
            this.cQZ.lWO = com.tencent.mm.protocal.d.cmW;
            this.cQZ.lWN = com.tencent.mm.protocal.d.lWh;
            this.cQZ.cW(this.uin);
            return this.cQZ;
        }

        public final boolean By() {
            return false;
        }

        public final int Bu() {
            return 0;
        }
    }

    public c() {
        this.errType = 0;
        this.errCode = 0;
        this.biS = SQLiteDatabase.KeyEmpty;
        this.cQS = 0;
        this.cQU = new StringBuilder();
        this.cQV = -1;
        this.cQW = false;
        v.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), be.bur());
        this.cQT = new com.tencent.mm.compatible.util.g.a();
        this.cQU.append("stack:" + be.bur() + " time:" + be.Nh());
    }

    public c(final b bVar, int i, long j) {
        this();
        this.cQS = i;
        this.cQV = j;
        v.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.cxS = new ah(z.MA(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ c cQY;

            public final boolean oU() {
                this.cQY.cQW = true;
                int i = 0;
                this.cQY.a(-1, 0, i, SQLiteDatabase.KeyEmpty, new a(bVar), null);
                return false;
            }
        }, false);
    }

    public final String getInfo() {
        return this.cQU.toString();
    }

    protected final int ul() {
        return 500;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final boolean BA() {
        return super.BA();
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.cii = eVar2;
        this.cQU.append(" lastd:" + this.czF + " dotime:" + be.Nh() + " net:" + ak.getNetType(aa.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(cQR);
        if (this.cxS != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (this.cxS != null) {
            c(eVar);
            this.cxS.ea(0);
            this.cxS = null;
            return -1;
        }
        p aVar = new a();
        aVar.uin = z.Mx().dlt.ww();
        ake com_tencent_mm_protocal_c_ake = ((com.tencent.mm.protocal.x.a) aVar.Bx()).lXs;
        com_tencent_mm_protocal_c_ake.mkE = cQR;
        com_tencent_mm_protocal_c_ake.mkF = m.H(be.KG(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", SQLiteDatabase.KeyEmpty)));
        com_tencent_mm_protocal_c_ake.maG = 1;
        com_tencent_mm_protocal_c_ake.mLf = new la();
        com_tencent_mm_protocal_c_ake.meq = com.tencent.mm.protocal.d.cmW;
        return a(eVar, aVar, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (pVar == null || pVar.getType() != 138) {
            int i4;
            String str2 = "MicroMsg.NetPushSync";
            String str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (pVar == null) {
                i4 = -2;
            } else {
                i4 = pVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            v.e(str2, str3, objArr);
            return;
        }
        Object obj;
        this.cQU.append(" endtime:" + be.Nh());
        v.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.cQW), Long.valueOf(this.cQT.sn()), this.cQU);
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] KG;
            int size;
            int i5;
            b bVar = (b) pVar.ze();
            if (obj == null) {
                byte[] a = m.a(((com.tencent.mm.protocal.x.a) pVar.Bx()).lXs.mkF);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = be.bk(a);
                v.d(str4, str5, objArr2);
                if (be.bl(a)) {
                    KG = be.KG(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", SQLiteDatabase.KeyEmpty));
                    v.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", Integer.valueOf(KG.length), be.bk(KG));
                } else {
                    KG = a;
                }
                a = m.a(bVar.lXt.mkF);
                KG = ae.i(KG, a);
                if (KG == null || KG.length <= 0) {
                    v.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    KG = a;
                }
                bVar.lXt.mkF = m.H(KG);
                size = (bVar.lXt.mkI == null || bVar.lXt.mkI.eeu == null) ? 0 : bVar.lXt.mkI.eeu.size();
                v.i("MicroMsg.NetPushSync", "newMsgSize:%d", Integer.valueOf(size));
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(KG == null ? -1 : KG.length);
                objArr2[2] = be.bk(KG);
                v.d(str4, str5, objArr2);
            }
            Iterator it = bVar.lXt.mkI.eeu.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                kz kzVar = (kz) it.next();
                if (kzVar.bkM == 5) {
                    KG = m.a(kzVar.mnB);
                    try {
                        bm bmVar = new bm();
                        bmVar.az(KG);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(bmVar.gll);
                        objArr3[1] = bmVar.mbU.mQy;
                        objArr3[2] = Long.valueOf(bmVar.mcb);
                        objArr3[3] = Integer.valueOf(bmVar.mca == null ? 0 : bmVar.mca.length());
                        objArr3[4] = Integer.valueOf(bmVar.mbW.mQy == null ? 0 : bmVar.mbW.mQy.length());
                        v.i(str3, str4, objArr3);
                        i5 = bmVar.gll;
                        str3 = bmVar.mbU.mQy;
                        str4 = bmVar.mbW.mQy;
                        if (i5 == 50) {
                            v.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else if (i5 == 9998 && str3.equalsIgnoreCase("weixin")) {
                            v.i("MicroMsg.NetPushSync", "hit ipxx");
                            obj = 1;
                        } else if (i5 == CdnLogic.MediaType_FAVORITE_VIDEO && str4.contains("revokemsg")) {
                            v.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = bmVar.mcb;
                            str5 = bmVar.mbU.mQy;
                            str2 = bmVar.mca;
                            int i6 = bmVar.gll;
                            if (be.kS(str2)) {
                                v.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = be.KK(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map q = bf.q(str2, "pushcontent");
                                if (q == null) {
                                    v.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) q.get(".pushcontent.$content");
                                    pString2.value = (String) q.get(".pushcontent.$nickname");
                                }
                                com.tencent.mm.plugin.zero.b bVar2 = (com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class);
                                if (bVar2.lxk != null) {
                                    bVar2.lxk.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.cnj + com.tencent.mm.a.g.m(("mm" + z.Mx().dlt.ww()).getBytes())) + "/avatar/", i6);
                                }
                            }
                            if ((bmVar.gll == CdnLogic.MediaType_FAVORITE_VIDEO ? 1 : null) != null) {
                                v.i("MicroMsg.NetPushSync", "need remove pushContent");
                                bmVar.mca = null;
                                kzVar.mnB = m.H(bmVar.toByteArray());
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.NetPushSync", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
            try {
                KG = bVar.lXt.toByteArray();
                size = z.Mx().dlt.ww();
                str4 = f.dy(size);
                int cU = f.cU(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + cU;
                byte[] c = com.tencent.mm.a.k.c(KG, com.tencent.mm.a.g.m((com.tencent.mm.compatible.d.p.rJ() + size).getBytes()).getBytes());
                v.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", Integer.valueOf(cU), Integer.valueOf(KG.length), Integer.valueOf(c.length), str6, f.v(KG), f.v(c), f.v(str3.getBytes()));
                if (be.bl(c)) {
                    v.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i5 = com.tencent.mm.a.e.b(str6, c, c.length);
                    boolean aR = com.tencent.mm.a.e.aR(str6);
                    if (i5 == 0 && aR) {
                        KG = String.valueOf(cU).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", KG, KG.length);
                    } else {
                        v.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", Integer.valueOf(i5), Boolean.valueOf(aR));
                    }
                }
            } catch (Throwable e2) {
                v.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", e2);
                v.a("MicroMsg.NetPushSync", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            v.d("MicroMsg.NetPushSync", "onRespHandled sync");
            aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", be.bn(m.a(bVar.lXt.mkF))).commit();
            v.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", Integer.valueOf(this.cQS));
            if (obj2 == null) {
                obj = ((bVar.lXt.miR & cQR) == 0 || super.BA()) ? null : 1;
                v.i("MicroMsg.NetPushSync", "continue flag=" + bVar.lXt.miR + ", selector=" + cQR + ", limit reach=" + super.BA());
                if (obj != null) {
                    a(this.czE, this.cii);
                    if (obj2 != null) {
                        CoreService.pV();
                        return;
                    }
                    return;
                }
            }
            if ((this.cQS & 1) > 0) {
                v.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new g(this.cQV, m.a(bVar.lXt.mkF), z.Mx().dlt.ww()).a(z.Mx(), new e(this) {
                    final /* synthetic */ c cQY;

                    {
                        this.cQY = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        v.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        kVar.czK = true;
                    }
                });
            }
            this.cii.a(this.errType, this.errCode, this.biS, this);
            if (obj2 != null) {
                CoreService.pV();
                return;
            }
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
