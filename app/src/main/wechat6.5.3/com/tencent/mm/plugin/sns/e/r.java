package com.tencent.mm.plugin.sns.e;

import android.os.Message;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.protocal.c.awu;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class r extends k implements j {
    private static List<ae> jks = new LinkedList();
    private static c jku;
    private static boolean jkv = true;
    private String bYE = "";
    b cif;
    e cii;
    private a jkt = new a(this);

    class a {
        LinkedList<kz> fLW;
        ac fLX = new ac(this) {
            final /* synthetic */ a jkA;

            {
                this.jkA = r1;
            }

            public final void handleMessage(Message message) {
                if (this.jkA.fLW == null || this.jkA.fLW.isEmpty()) {
                    r rVar = this.jkA.jky;
                    awu com_tencent_mm_protocal_c_awu = (awu) rVar.cif.czl.czs;
                    awt com_tencent_mm_protocal_c_awt = (awt) rVar.cif.czk.czs;
                    byte[] i = com.tencent.mm.protocal.ae.i(com_tencent_mm_protocal_c_awt.mkF.mQw.toByteArray(), com_tencent_mm_protocal_c_awu.mkF.mQw.toByteArray());
                    if (i != null && i.length > 0) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(8195, be.bn(i));
                    }
                    com_tencent_mm_protocal_c_awt.mkF.ba(i);
                    if ((com_tencent_mm_protocal_c_awu.miR & com_tencent_mm_protocal_c_awt.mkE) == 0) {
                        rVar.cii.a(0, 0, "", rVar);
                        return;
                    } else {
                        rVar.a(rVar.czE, rVar.cii);
                        return;
                    }
                }
                final kz kzVar = (kz) this.jkA.fLW.getFirst();
                v.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + kzVar.bkM);
                this.jkA.fLW.removeFirst();
                switch (kzVar.bkM) {
                    case 45:
                        ad.aSo().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jkC;

                            public final void run() {
                                if (!this.jkC.jkA.jky.a(kzVar, this.jkC.jkA.fLX)) {
                                    this.jkC.jkA.fLX.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                        ad.aSo().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jkC;

                            public final void run() {
                                if (!this.jkC.jkA.jky.b(kzVar, this.jkC.jkA.fLX)) {
                                    this.jkC.jkA.fLX.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        };
        final /* synthetic */ r jky;

        a(r rVar) {
            this.jky = rVar;
        }
    }

    public r() {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new awt();
        aVar.czo = new awu();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.czm = 214;
        aVar.czp = 102;
        aVar.czq = 1000000102;
        this.cif = aVar.Bv();
        ((awt) this.cif.czk.czs).mkE = 256;
        this.bYE = com.tencent.mm.model.k.xF();
        if (jkv) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("ad_1100007").toString();
            v.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + stringBuilder2);
            byte[] c = FileOp.c(stringBuilder2, 0, -1);
            if (c != null) {
                try {
                    jku = (c) new c().az(c);
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (jku == null) {
                        v.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        v.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + jku.jqp.size());
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
            jkv = false;
        }
    }

    protected final int ul() {
        return 10;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        ak.yW();
        byte[] KG = be.KG(be.ma((String) com.tencent.mm.model.c.vf().get(8195, null)));
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(KG);
        ((awt) this.cif.czk.czs).mkF = com_tencent_mm_protocal_c_are;
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public static void cJ(long j) {
        if (jku == null) {
            jku = new c();
        }
        jku.jqp.add(Long.valueOf(j));
    }

    public static void cK(long j) {
        if (jku != null) {
            jku.jqp.remove(Long.valueOf(j));
        }
    }

    public static boolean cL(long j) {
        if (jku != null && jku.jqp.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public static void aRZ() {
        if (jku != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("ad_1100007").toString();
            v.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = jku.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                v.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + jku.jqp.size());
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public final boolean Bz() {
        return true;
    }

    public final int getType() {
        return 214;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awu com_tencent_mm_protocal_c_awu = (awu) ((b) pVar).czl.czs;
            LinkedList linkedList = com_tencent_mm_protocal_c_awu.mkI.eeu;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(com_tencent_mm_protocal_c_awu.mkF == null || com_tencent_mm_protocal_c_awu.mkF.mQw == null)) {
                    byte[] i4 = com.tencent.mm.protocal.ae.i(((awt) ((b) pVar).czk.czs).mkF.mQw.toByteArray(), com_tencent_mm_protocal_c_awu.mkF.mQw.toByteArray());
                    if (i4 != null && i4.length > 0) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(8195, be.bn(i4));
                    }
                }
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.jkt;
            aVar.fLW = linkedList;
            aVar.fLX.sendEmptyMessage(0);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final boolean a(kz kzVar, final ac acVar) {
        try {
            final awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(kzVar.mnB.mQw.toByteArray());
            String str = new String(com_tencent_mm_protocal_c_awa.mTg.mQw.toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            v.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + com_tencent_mm_protocal_c_awa.mjq + " " + i.cE(com_tencent_mm_protocal_c_awa.mjq) + " isPhoto " + z);
            if (z) {
                String cE = i.cE(com_tencent_mm_protocal_c_awa.mjq);
                com.tencent.mm.plugin.sns.storage.i Bu = ad.aSG().Bu(com_tencent_mm_protocal_c_awa.mdw);
                if (be.kS(Bu.field_newerIds)) {
                    ad.aSG().cM(com_tencent_mm_protocal_c_awa.mdw, cE);
                } else {
                    String[] split = Bu.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (cE.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = cE;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    v.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + com_tencent_mm_protocal_c_awa.mjq + " S: " + cE + " list " + Bu.field_newerIds + " newer " + str2);
                    if (z) {
                        ad.aSG().cM(com_tencent_mm_protocal_c_awa.mdw, str2);
                    }
                }
            }
            if (ad.aSE().cW(com_tencent_mm_protocal_c_awa.mjq)) {
                v.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                return false;
            }
            ad.aqz().post(new Runnable(this) {
                final /* synthetic */ r jky;

                public final void run() {
                    if (!com_tencent_mm_protocal_c_awa.mdw.equals(this.jky.bYE)) {
                        if (ak.uz()) {
                            ak.yW();
                            String str = (String) com.tencent.mm.model.c.vf().get(68377, null);
                            ak.yW();
                            if (!(be.a((Integer) com.tencent.mm.model.c.vf().get(68400, null), 0) == com_tencent_mm_protocal_c_awa.hNS && (be.kS(str) || str.equals(com_tencent_mm_protocal_c_awa.mdw)))) {
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(68377, com_tencent_mm_protocal_c_awa.mdw);
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(68400, Integer.valueOf(com_tencent_mm_protocal_c_awa.hNS));
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(68418, i.cE(com_tencent_mm_protocal_c_awa.mjq));
                            }
                            for (ae yJ : r.jks) {
                                yJ.yJ();
                            }
                        } else {
                            v.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            return;
                        }
                    }
                    acVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean b(kz kzVar, final ac acVar) {
        try {
            avn com_tencent_mm_protocal_c_avn = (avn) new avn().az(kzVar.mnB.mQw.toByteArray());
            long j = com_tencent_mm_protocal_c_avn.mjq;
            long j2 = com_tencent_mm_protocal_c_avn.mSS;
            final avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
            String str = com_tencent_mm_protocal_c_avn.mbN;
            if (str == null) {
                str = "";
            }
            v.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + com_tencent_mm_protocal_c_avm.efm + " " + j + " " + str);
            g d;
            boolean a;
            h aSH;
            String str2;
            switch (com_tencent_mm_protocal_c_avm.efm) {
                case 9:
                    d = ad.aSH().d(j, (long) com_tencent_mm_protocal_c_avm.mSN, com_tencent_mm_protocal_c_avm.efm);
                    if (d != null) {
                        d.aUs();
                        a = ad.aSH().a(d.nmb, d);
                        ah.b(j, com_tencent_mm_protocal_c_avn);
                        v.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + a);
                        break;
                    }
                    break;
                case 10:
                    d = ad.aSH().d(j, com_tencent_mm_protocal_c_avm.mSQ, com_tencent_mm_protocal_c_avm.efm);
                    if (d != null) {
                        d.aUs();
                        a = ad.aSH().a(d.nmb, d);
                        ah.b(j, com_tencent_mm_protocal_c_avn);
                        v.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + a);
                        break;
                    }
                    break;
                case 11:
                    aSH = ad.aSH();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j;
                    v.i("MicroMsg.SnsCommentStorage", "set sns del " + str2);
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + aSH.cuX.dF("SnsComment", str2));
                    break;
                case 12:
                    aSH = ad.aSH();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j + " and talker = " + be.lZ(com_tencent_mm_protocal_c_avm.mOk);
                    v.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + str2);
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + aSH.cuX.dF("SnsComment", str2));
                    break;
                case as.CTRL_INDEX /*13*/:
                    b(com_tencent_mm_protocal_c_avn, com_tencent_mm_protocal_c_avm, j, j2, str);
                    break;
                case an.CTRL_INDEX /*14*/:
                    c(com_tencent_mm_protocal_c_avn, com_tencent_mm_protocal_c_avm, j, j2, str);
                    break;
                default:
                    a(com_tencent_mm_protocal_c_avn, com_tencent_mm_protocal_c_avm, j, j2, str);
                    break;
            }
            ad.aqz().post(new Runnable(this) {
                final /* synthetic */ r jky;

                public final void run() {
                    for (ae aeVar : r.jks) {
                        v.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                        aeVar.yI();
                    }
                    acVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean cM(long j) {
        try {
            return a.a(j, null, be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyLimit"), 0), be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyLikeTimeLimit"), 0), be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return true;
        }
    }

    private static boolean a(avn com_tencent_mm_protocal_c_avn, avm com_tencent_mm_protocal_c_avm, long j, long j2, String str) {
        try {
            int i = be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyLimit"), 0);
            int i2 = be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i3 = be.getInt(com.tencent.mm.h.j.sU().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i > 0 || i2 > 0 || i3 > 0) && (com_tencent_mm_protocal_c_avm.efm == 8 || com_tencent_mm_protocal_c_avm.efm == 7)) {
                boolean a = a.a(j, com_tencent_mm_protocal_c_avn, i, i2, i3, true);
                if (cL(j)) {
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "user open notify off");
                }
                if (!a) {
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_avm.mSQ + " " + com_tencent_mm_protocal_c_avm.mSN + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
                    if (a.a(j, com_tencent_mm_protocal_c_avn)) {
                        return false;
                    }
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID  " + com_tencent_mm_protocal_c_avn.mST.mSQ);
                    return false;
                }
            }
            v.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_avm.mSQ + " " + com_tencent_mm_protocal_c_avm.mSN + " actionLimit: " + i);
            if (ad.aSH().a(j, com_tencent_mm_protocal_c_avm.mOk, com_tencent_mm_protocal_c_avm.hNS, str)) {
                return false;
            }
            avm com_tencent_mm_protocal_c_avm2 = com_tencent_mm_protocal_c_avn.mSU;
            g gVar = new g();
            gVar.field_snsID = j;
            gVar.field_parentID = j2;
            gVar.field_createTime = com_tencent_mm_protocal_c_avm.hNS;
            gVar.field_talker = com_tencent_mm_protocal_c_avm.mOk;
            gVar.field_type = com_tencent_mm_protocal_c_avm.efm;
            gVar.field_curActionBuf = com_tencent_mm_protocal_c_avm.toByteArray();
            gVar.field_refActionBuf = com_tencent_mm_protocal_c_avm2.toByteArray();
            gVar.field_clientId = str;
            if (com_tencent_mm_protocal_c_avm.efm == 8 || com_tencent_mm_protocal_c_avm.efm == 7) {
                gVar.field_commentSvrID = com_tencent_mm_protocal_c_avm.mSQ;
                if (!a.a(j, com_tencent_mm_protocal_c_avn)) {
                    v.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + gVar.field_snsID + " " + gVar.field_commentSvrID);
                    return false;
                }
            }
            gVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_avm.mSN;
            if (!ah.a(j, com_tencent_mm_protocal_c_avn)) {
                return false;
            }
            ad.aSH().b(gVar);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean b(avn com_tencent_mm_protocal_c_avn, avm com_tencent_mm_protocal_c_avm, long j, long j2, String str) {
        try {
            v.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_avm.mSQ + " " + com_tencent_mm_protocal_c_avm.mSN);
            if (o.aRi()) {
                if (ad.aSH().a(j, com_tencent_mm_protocal_c_avm.mOk, com_tencent_mm_protocal_c_avm.hNS, str)) {
                    return false;
                }
                avm com_tencent_mm_protocal_c_avm2 = com_tencent_mm_protocal_c_avn.mSU;
                g gVar = new g();
                gVar.field_snsID = j;
                gVar.field_parentID = j2;
                gVar.field_createTime = com_tencent_mm_protocal_c_avm.hNS;
                gVar.field_talker = com_tencent_mm_protocal_c_avm.mOk;
                gVar.field_type = com_tencent_mm_protocal_c_avm.efm;
                gVar.field_curActionBuf = com_tencent_mm_protocal_c_avm.toByteArray();
                gVar.field_refActionBuf = com_tencent_mm_protocal_c_avm2.toByteArray();
                gVar.field_clientId = str;
                gVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_avm.mSN;
                v.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
                ah.c(j, com_tencent_mm_protocal_c_avn);
                yK();
                ad.aSH().b(gVar);
                return true;
            }
            v.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            return false;
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean c(avn com_tencent_mm_protocal_c_avn, avm com_tencent_mm_protocal_c_avm, long j, long j2, String str) {
        try {
            v.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_avm.mSQ + " " + com_tencent_mm_protocal_c_avm.mSN);
            if (ad.aSH().a(j, com_tencent_mm_protocal_c_avm.mOk, com_tencent_mm_protocal_c_avm.hNS, str)) {
                return false;
            }
            avm com_tencent_mm_protocal_c_avm2 = com_tencent_mm_protocal_c_avn.mSU;
            g gVar = new g();
            gVar.field_snsID = j;
            gVar.field_parentID = j2;
            gVar.field_createTime = com_tencent_mm_protocal_c_avm.hNS;
            gVar.field_talker = com_tencent_mm_protocal_c_avm.mOk;
            gVar.field_type = com_tencent_mm_protocal_c_avm.efm;
            gVar.field_curActionBuf = com_tencent_mm_protocal_c_avm.toByteArray();
            gVar.field_refActionBuf = com_tencent_mm_protocal_c_avm2.toByteArray();
            gVar.field_clientId = str;
            gVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_avm.mSN;
            acc com_tencent_mm_protocal_c_acc = new acc();
            v.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_avm.mSR);
            com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avm.mSR));
            v.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + com_tencent_mm_protocal_c_acc.bst);
            ad.aSH().b(gVar);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            v.a("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static void aSa() {
        for (ae aeVar : jks) {
            if (aeVar != null) {
                aeVar.yL();
            }
        }
    }

    private static void yK() {
        for (ae aeVar : jks) {
            if (aeVar != null) {
                aeVar.yK();
            }
        }
    }

    public static void a(ae aeVar) {
        if (!jks.contains(aeVar)) {
            jks.add(aeVar);
        }
    }

    public static void b(ae aeVar) {
        jks.remove(aeVar);
    }
}
