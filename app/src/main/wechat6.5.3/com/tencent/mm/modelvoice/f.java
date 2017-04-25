package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class f extends k implements j {
    public String aST;
    public int aYJ;
    private b cif;
    e cii;
    ah cxS;
    private boolean diB;
    private int diF;
    long diG;
    private int dik;
    private int endFlag;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        boolean z = true;
        this.aYJ = 0;
        this.dik = 0;
        this.diB = false;
        this.endFlag = 0;
        this.cxS = new ah(new a(this) {
            final /* synthetic */ f diH;

            {
                this.diH = r1;
            }

            public final boolean oU() {
                p lJ = m.Lz().lJ(this.diH.aST);
                if (lJ == null || !lJ.LD()) {
                    v.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.diH.aST);
                    this.diH.aYJ = g.sk() + 10000;
                    this.diH.cii.a(3, -1, "doScene failed", this.diH);
                    return false;
                }
                if (!(3 == lJ.status || 8 == lJ.status)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((currentTimeMillis / 1000) - lJ.dhI > 30) {
                        v.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.diH.aST);
                        this.diH.aYJ = g.sk() + 10000;
                        this.diH.cii.a(3, -1, "doScene failed", this.diH);
                        return false;
                    } else if (currentTimeMillis - this.diH.diG < 2000) {
                        v.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.diH.aST + " but last send time:" + (currentTimeMillis - this.diH.diG));
                        return true;
                    } else {
                        g aU = q.lC(this.diH.aST).aU(lJ.dgC, 6000);
                        v.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.diH.aST + " readByte:" + aU.aUT + " stat:" + lJ.status);
                        if (aU.aUT < 2000) {
                            return true;
                        }
                    }
                }
                if (this.diH.a(this.diH.czE, this.diH.cii) != -1) {
                    return false;
                }
                this.diH.aYJ = g.sk() + 10000;
                this.diH.cii.a(3, -1, "doScene failed", this.diH);
                return false;
            }
        }, true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        v.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + str);
        this.aST = str;
        this.diF = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = false;
        this.cii = eVar2;
        this.diB = false;
        if (this.aST == null) {
            v.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        p lJ = m.Lz().lJ(this.aST);
        if (lJ == null || !lJ.LD()) {
            v.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.aST);
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        v.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.aST + " netTimes:" + lJ.dhM);
        if (q.lB(this.aST)) {
            int i2;
            g gVar;
            int format;
            int i3;
            g gVar2 = new g();
            if (lJ.status == 8) {
                v.v("MicroMsg.NetSceneUploadVoice", this.aST + " cancelFlag = 1");
                this.endFlag = 0;
                q.lG(lJ.aST);
                i2 = 1;
                gVar = gVar2;
            } else {
                if (lJ.status == 3) {
                    this.diB = true;
                }
                b lC = q.lC(this.aST);
                if (lC == null) {
                    this.aYJ = g.sk() + 10000;
                    v.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", this.aST);
                    return -1;
                }
                format = lC.getFormat();
                v.d("MicroMsg.NetSceneUploadVoice", "format " + format);
                g aU = lC.aU(lJ.dgC, 6000);
                v.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.aST + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + lJ.dgC + " line:" + g.sk());
                if (aU.ret < 0) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 241, 1, false);
                    v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.aST + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + lJ.dgC);
                    q.lh(this.aST);
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
                this.dik = aU.dik;
                if (this.dik < lJ.dgC || this.dik >= 469000) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 240, 1, false);
                    v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.aST + "] newOff:" + this.dik + " OldtOff:" + lJ.dgC);
                    q.lh(this.aST);
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (aU.aUT != 0 || this.diB) {
                    if (this.diB) {
                        if (lJ.cyu <= 0) {
                            v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.aST + "] read totalLen:" + lJ.cyu);
                            q.lh(this.aST);
                            this.aYJ = g.sk() + 10000;
                            return -1;
                        } else if (lJ.cyu > this.dik && aU.aUT < 6000) {
                            v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.aST + "] readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + lJ.dgC + " totalLen:" + lJ.cyu);
                            q.lh(this.aST);
                            this.aYJ = g.sk() + 10000;
                            return -1;
                        } else if (lJ.cyu <= this.dik) {
                            this.endFlag = 1;
                        }
                    }
                    i2 = 0;
                    gVar = aU;
                    i = format;
                } else {
                    v.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.aST + " No Data temperature , will be retry");
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
            }
            format = lJ.djF;
            if (format == 0) {
                i3 = ((this.dik - 6) / 32) * 20;
            } else {
                i3 = format;
            }
            b.a aVar = new b.a();
            aVar.czn = new bct();
            aVar.czo = new bcu();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            aVar.czm = 127;
            aVar.czp = 19;
            aVar.czq = 1000000019;
            this.cif = aVar.Bv();
            bct com_tencent_mm_protocal_c_bct = (bct) this.cif.czk.czs;
            com_tencent_mm_protocal_c_bct.gon = com.tencent.mm.model.k.xF();
            com_tencent_mm_protocal_c_bct.gom = lJ.ble;
            com_tencent_mm_protocal_c_bct.mfb = lJ.dgC;
            com_tencent_mm_protocal_c_bct.mcN = lJ.clientId;
            com_tencent_mm_protocal_c_bct.mpw = i3;
            com_tencent_mm_protocal_c_bct.mfh = this.endFlag;
            com_tencent_mm_protocal_c_bct.mcb = lJ.bmL;
            com_tencent_mm_protocal_c_bct.mfd = i2;
            com_tencent_mm_protocal_c_bct.mYC = this.diF;
            com_tencent_mm_protocal_c_bct.mbZ = ax.zs();
            if (com.tencent.mm.modelbiz.e.hC(lJ.ble)) {
                ak.yW();
                com_tencent_mm_protocal_c_bct.mbZ = com.tencent.mm.modelbiz.a.e.hY(c.wJ().ek((long) lJ.dhL).bNo);
            }
            com_tencent_mm_protocal_c_bct.mHH = i;
            if (i2 != 1) {
                com_tencent_mm_protocal_c_bct.mfg = new are().z(gVar.buf, gVar.aUT);
                com_tencent_mm_protocal_c_bct.mff = gVar.aUT;
            } else {
                com_tencent_mm_protocal_c_bct.mfg = new are().c(com.tencent.mm.ba.b.aT(new byte[1]));
                com_tencent_mm_protocal_c_bct.mff = 1;
            }
            v.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i2 + " endFlag:" + this.endFlag + " svrId:" + lJ.bmL);
            v.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + com_tencent_mm_protocal_c_bct.mcb + " user:" + com_tencent_mm_protocal_c_bct.gom + " offset:" + com_tencent_mm_protocal_c_bct.mfb + " dataLen:" + com_tencent_mm_protocal_c_bct.mfg.mQu + " endFlag:" + com_tencent_mm_protocal_c_bct.mfh);
            v.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + lJ.bmL + " voiceFormat:" + i + " file:" + this.aST + " readBytes:" + gVar.aUT + " neTTTOff:" + lJ.dgC + " neWWWOff:" + this.dik + " endFlag:" + this.endFlag + " cancelFlag:" + i2 + " status:" + lJ.status + " voiceLen:" + i3);
            this.diG = System.currentTimeMillis();
            return a(eVar, this.cif, this);
        }
        v.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.aST);
        q.lh(this.aST);
        this.aYJ = g.sk() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        bct com_tencent_mm_protocal_c_bct = (bct) ((b) pVar).czk.czs;
        v.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + com_tencent_mm_protocal_c_bct.mcb + " offset:" + com_tencent_mm_protocal_c_bct.mfb + " dataLen:" + com_tencent_mm_protocal_c_bct.mfg.mQu + " endFlag:" + com_tencent_mm_protocal_c_bct.mfh);
        if ((com_tencent_mm_protocal_c_bct.mcb != 0 || com_tencent_mm_protocal_c_bct.mfb == 0) && ((com_tencent_mm_protocal_c_bct.mfg != null && com_tencent_mm_protocal_c_bct.mfg.mQu != 0) || com_tencent_mm_protocal_c_bct.mfh == 1 || com_tencent_mm_protocal_c_bct.mfd == 1)) {
            return b.czU;
        }
        return b.czV;
    }

    protected final int ul() {
        return 60;
    }

    public final boolean BA() {
        boolean BA = super.BA();
        if (BA) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 239, 1, false);
        }
        return BA;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.iuh.a(111, 238, 1, false);
        q.lh(this.aST);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.aST + " errtype:" + i2 + " errCode:" + i3);
        bct com_tencent_mm_protocal_c_bct = (bct) ((b) pVar).czk.czs;
        bcu com_tencent_mm_protocal_c_bcu = (bcu) ((b) pVar).czl.czs;
        p lJ;
        if (i2 == 4 && i3 == -22) {
            lJ = m.Lz().lJ(this.aST);
            if (lJ != null) {
                if (lJ.status == 3) {
                    ak.yW();
                    at ek = c.wJ().ek((long) lJ.dhL);
                    ek.setContent(n.b(lJ.dhC, (long) lJ.djF, false));
                    ek.dh(2);
                    ak.yW();
                    c.wJ().a((long) lJ.dhL, ek);
                }
                lJ.status = 97;
                lJ.dhI = System.currentTimeMillis() / 1000;
                lJ.bkU = 320;
                q.a(lJ);
            }
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            q.lh(this.aST);
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 237, 1, false);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_bcu.mcb + " toUser:" + com_tencent_mm_protocal_c_bct.gom);
            if (com_tencent_mm_protocal_c_bcu.mcb > 0 || u.ew(com_tencent_mm_protocal_c_bct.gom)) {
                int i4;
                v.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(com_tencent_mm_protocal_c_bcu.mcb), Integer.valueOf(q.dqk));
                if (10007 == q.dqj && q.dqk != 0) {
                    com_tencent_mm_protocal_c_bcu.mcb = (long) q.dqk;
                    q.dqk = 0;
                }
                String str2 = this.aST;
                int i5 = this.dik;
                long j = com_tencent_mm_protocal_c_bcu.mcb;
                String str3 = com_tencent_mm_protocal_c_bcu.mcN;
                int i6 = this.endFlag;
                int i7 = this.diF;
                if (str2 == null) {
                    i4 = -1;
                } else {
                    v.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                    p lJ2 = m.Lz().lJ(str2);
                    if (lJ2 == null) {
                        i4 = -1;
                    } else {
                        lJ2.dgC = i5;
                        lJ2.dhI = System.currentTimeMillis() / 1000;
                        lJ2.bkU = 264;
                        if (be.kS(lJ2.clientId) && str3 != null) {
                            lJ2.clientId = str3;
                            lJ2.bkU |= 512;
                        }
                        if (lJ2.bmL == 0 && j != 0) {
                            lJ2.bmL = j;
                            lJ2.bkU |= 4;
                        }
                        i4 = 0;
                        if (lJ2.cyu <= i5 && lJ2.status == 3 && i6 == 1) {
                            lJ2.status = 99;
                            lJ2.bkU |= 64;
                            ak.yW();
                            at ek2 = c.wJ().ek((long) lJ2.dhL);
                            ek2.cH(lJ2.ble);
                            ek2.y(lJ2.bmL);
                            ek2.dh(2);
                            ek2.setContent(n.b(lJ2.dhC, (long) lJ2.djF, false));
                            ek2.vg(i7);
                            ak.yW();
                            c.wJ().a((long) lJ2.dhL, ek2);
                            v.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str2 + " total:" + lJ2.cyu + " status:" + lJ2.status + " netTimes:" + lJ2.dhM + " msgId:" + ek2.field_msgId);
                            i4 = 1;
                            q.lD(str2);
                        }
                        if (!q.a(lJ2)) {
                            i4 = -4;
                        }
                    }
                }
                v.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + i4 + " file:" + this.aST + " MsgSvrId:" + com_tencent_mm_protocal_c_bcu.mcb + " clientId:" + com_tencent_mm_protocal_c_bcu.mcN + " neWWOff:" + this.dik + " neTTTT:" + com_tencent_mm_protocal_c_bcu.mff + " forwardflag:" + this.diF);
                if (i4 < 0) {
                    q.lh(this.aST);
                    v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.aST + "UpdateAfterSend Ret:" + i4);
                    this.cii.a(i2, i3, str, this);
                    return;
                } else if (i4 == 1) {
                    v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.aST);
                    lJ = m.Lz().lJ(this.aST);
                    ak.yW();
                    com.tencent.mm.modelstat.b.daJ.p(c.wJ().ek((long) lJ.dhL));
                    this.cii.a(i2, i3, str, this);
                    return;
                } else {
                    long j2 = this.diB ? 0 : 500;
                    v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.aST + " delay:" + j2);
                    this.cxS.ea(j2);
                    return;
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 235, 1, false);
            v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.aST + " getMsgId:" + com_tencent_mm_protocal_c_bcu.mcb + " netoff:" + com_tencent_mm_protocal_c_bcu.mfb);
            q.lh(this.aST);
            this.cii.a(i2, i3, str, this);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 236, 1, false);
            v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.aST + " errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 127;
    }
}
