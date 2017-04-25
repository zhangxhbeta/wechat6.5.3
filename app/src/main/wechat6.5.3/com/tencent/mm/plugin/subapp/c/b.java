package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class b extends k implements j {
    String aST;
    int aYJ = 0;
    private com.tencent.mm.v.b cif;
    e cii;
    ah cxS = new ah(new a(this) {
        final /* synthetic */ b kfs;

        {
            this.kfs = r1;
        }

        public final boolean oU() {
            g Ct = h.Ct(this.kfs.aST);
            if (Ct == null || !Ct.LD()) {
                v.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.kfs.aST);
                this.kfs.aYJ = g.sk() + 10000;
                this.kfs.cii.a(3, -1, "doScene failed", this.kfs);
                return false;
            }
            if (!(3 == Ct.field_status || 8 == Ct.field_status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - Ct.field_lastmodifytime > 30) {
                    v.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.kfs.aST);
                    this.kfs.aYJ = g.sk() + 10000;
                    this.kfs.cii.a(3, -1, "doScene failed", this.kfs);
                    return false;
                } else if (currentTimeMillis - this.kfs.diG < 2000) {
                    v.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.kfs.aST + " but last send time:" + (currentTimeMillis - this.kfs.diG));
                    return true;
                } else {
                    c.a rn = h.Cu(this.kfs.aST).rn(Ct.field_offset);
                    v.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.kfs.aST + " readByte:" + rn.aUT + " stat:" + Ct.field_status);
                    if (rn.aUT < 2000) {
                        return true;
                    }
                }
            }
            if (this.kfs.a(this.kfs.czE, this.kfs.cii) != -1) {
                return false;
            }
            this.kfs.aYJ = g.sk() + 10000;
            this.kfs.cii.a(3, -1, "doScene failed", this.kfs);
            return false;
        }
    }, true);
    private boolean diB = false;
    long diG;
    private int dik = 0;
    private int endFlag = 0;

    public b(String str) {
        boolean z = true;
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + str);
        this.aST = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        this.diB = false;
        if (this.aST == null) {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        g Ct = h.Ct(this.aST);
        if (Ct == null || !Ct.LD()) {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.aST);
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        boolean z;
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.aST + " netTimes:" + Ct.field_nettimes);
        String str = this.aST;
        if (str == null) {
            z = false;
        } else {
            g Ct2 = h.Ct(str);
            if (Ct2 == null) {
                z = false;
            } else if (Ct2.field_nettimes >= 80) {
                z = false;
            } else {
                Ct2.field_nettimes++;
                Ct2.bkU = 16384;
                z = h.a(Ct2);
            }
        }
        if (z) {
            c.a aVar;
            int i;
            int i2;
            c.a aVar2 = new c.a();
            if (Ct.field_status == 8) {
                v.v("MicroMsg.NetSceneUploadVoiceRemind", this.aST + " cancelFlag = 1");
                this.endFlag = 1;
                h.lG(Ct.field_filename);
                aVar = aVar2;
                i = 1;
            } else {
                if (Ct.field_status == 3) {
                    this.diB = true;
                }
                c Cu = h.Cu(this.aST);
                if (Cu == null) {
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
                aVar2 = Cu.rn(Ct.field_offset);
                v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.aST + "] read ret:" + aVar2.ret + " readlen:" + aVar2.aUT + " newOff:" + aVar2.dik + " netOff:" + Ct.field_offset + " line:" + g.sk());
                if (aVar2.ret < 0) {
                    v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.aST + "] read ret:" + aVar2.ret + " readlen:" + aVar2.aUT + " newOff:" + aVar2.dik + " netOff:" + Ct.field_offset);
                    h.lh(this.aST);
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
                this.dik = aVar2.dik;
                if (this.dik < Ct.field_offset || this.dik >= 469000) {
                    v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.aST + "] newOff:" + this.dik + " OldtOff:" + Ct.field_offset);
                    h.lh(this.aST);
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (aVar2.aUT != 0 || this.diB) {
                    if (this.diB) {
                        if (Ct.field_totallen <= 0) {
                            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.aST + "] read totalLen:" + Ct.field_totallen);
                            h.lh(this.aST);
                            this.aYJ = g.sk() + 10000;
                            return -1;
                        } else if (Ct.field_totallen > this.dik && aVar2.aUT < 6000) {
                            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.aST + "] readlen:" + aVar2.aUT + " newOff:" + aVar2.dik + " netOff:" + Ct.field_offset + " totalLen:" + Ct.field_totallen);
                            h.lh(this.aST);
                            this.aYJ = g.sk() + 10000;
                            return -1;
                        } else if (Ct.field_totallen <= this.dik) {
                            this.endFlag = 1;
                        }
                    }
                    aVar = aVar2;
                    i = 0;
                } else {
                    v.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.aST + " No Data temperature , will be retry");
                    h.lh(this.aST);
                    this.aYJ = g.sk() + 10000;
                    return -1;
                }
            }
            int i3 = Ct.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.dik - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + Ct.field_msgid);
            com.tencent.mm.v.b.a aVar3 = new com.tencent.mm.v.b.a();
            aVar3.czn = new bct();
            aVar3.czo = new bcu();
            aVar3.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            aVar3.czm = 329;
            aVar3.czp = 157;
            aVar3.czq = 1000000157;
            this.cif = aVar3.Bv();
            bct com_tencent_mm_protocal_c_bct = (bct) this.cif.czk.czs;
            com_tencent_mm_protocal_c_bct.gon = com.tencent.mm.model.k.xF();
            com_tencent_mm_protocal_c_bct.gom = Ct.field_user;
            com_tencent_mm_protocal_c_bct.mfb = Ct.field_offset;
            com_tencent_mm_protocal_c_bct.mcN = Ct.field_clientid;
            com_tencent_mm_protocal_c_bct.mpw = i2;
            com_tencent_mm_protocal_c_bct.mfh = this.endFlag;
            com_tencent_mm_protocal_c_bct.mcb = Ct.field_msgid;
            com_tencent_mm_protocal_c_bct.mfd = i;
            com_tencent_mm_protocal_c_bct.mYB = (int) (Ct.field_createtime / 1000);
            com_tencent_mm_protocal_c_bct.mHH = 1;
            if (i != 1) {
                com_tencent_mm_protocal_c_bct.mfg = new are().z(aVar.buf, aVar.aUT);
                com_tencent_mm_protocal_c_bct.mff = aVar.aUT;
            } else {
                com_tencent_mm_protocal_c_bct.mfg = new are().c(com.tencent.mm.ba.b.aT(new byte[1]));
                com_tencent_mm_protocal_c_bct.mff = 1;
            }
            v.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + Ct.field_msgid);
            v.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + com_tencent_mm_protocal_c_bct.mcb + " user:" + com_tencent_mm_protocal_c_bct.gom + " offset:" + com_tencent_mm_protocal_c_bct.mfb + " dataLen:" + com_tencent_mm_protocal_c_bct.mfg.mQu + " endFlag:" + com_tencent_mm_protocal_c_bct.mfh);
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + Ct.field_msgid + " file:" + this.aST + " readBytes:" + aVar.aUT + " neTTTOff:" + Ct.field_offset + " neWWWOff:" + this.dik + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + Ct.field_status);
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + com_tencent_mm_protocal_c_bct.toString());
            this.diG = System.currentTimeMillis();
            return a(eVar, this.cif, this);
        }
        v.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.aST);
        h.lh(this.aST);
        this.aYJ = g.sk() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        bct com_tencent_mm_protocal_c_bct = (bct) ((com.tencent.mm.v.b) pVar).czk.czs;
        v.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + com_tencent_mm_protocal_c_bct.mfb + " dataLen:" + com_tencent_mm_protocal_c_bct.mfg.mQu + " endFlag:" + com_tencent_mm_protocal_c_bct.mfh);
        return b.czU;
    }

    protected final int ul() {
        return 240;
    }

    protected final void a(a aVar) {
        h.lh(this.aST);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.aST + " errtype:" + i2 + " errCode:" + i3);
        bct com_tencent_mm_protocal_c_bct = (bct) ((com.tencent.mm.v.b) pVar).czk.czs;
        bcu com_tencent_mm_protocal_c_bcu = (bcu) ((com.tencent.mm.v.b) pVar).czl.czs;
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + com_tencent_mm_protocal_c_bcu.toString());
        if (i2 == 4 && i3 == -22) {
            g Ct = h.Ct(this.aST);
            if (Ct != null) {
                if (Ct.field_status == 3) {
                    ak.yW();
                    at ek = c.wJ().ek((long) Ct.field_msglocalid);
                    ek.setContent(f.b(Ct.field_human, (long) Ct.field_voicelenght, false));
                    ek.dh(2);
                    ak.yW();
                    c.wJ().a((long) Ct.field_msglocalid, ek);
                }
                Ct.field_status = 97;
                Ct.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Ct.bkU = 320;
                h.a(Ct);
            }
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            h.lh(this.aST);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_bcu.mcb + " toUser:" + com_tencent_mm_protocal_c_bct.gom);
            String str2 = this.aST;
            int i5 = this.dik;
            long j = com_tencent_mm_protocal_c_bcu.mcb;
            String str3 = com_tencent_mm_protocal_c_bcu.mcN;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                v.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                g Ct2 = h.Ct(str2);
                if (Ct2 == null) {
                    i4 = -1;
                } else {
                    Ct2.field_offset = i5;
                    Ct2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Ct2.bkU = 264;
                    if (be.kS(Ct2.field_clientid) && str3 != null) {
                        Ct2.field_clientid = str3;
                        Ct2.bkU |= 512;
                    }
                    if (Ct2.field_msgid == 0 && j != 0) {
                        Ct2.field_msgid = j;
                        Ct2.bkU |= 4;
                    }
                    i4 = 0;
                    v.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + Ct2.field_totallen + "  newOffset " + i5 + "  " + Ct2.field_status);
                    if (Ct2.field_totallen <= i5 && Ct2.field_status == 3 && i6 == 1) {
                        Ct2.field_status = 99;
                        Ct2.bkU |= 64;
                        ak.yW();
                        at ek2 = c.wJ().ek((long) Ct2.field_msglocalid);
                        ek2.cH(Ct2.field_user);
                        ek2.y(Ct2.field_msgid);
                        ek2.dh(2);
                        ek2.setContent(f.b(Ct2.field_human, (long) Ct2.field_voicelenght, false));
                        ak.yW();
                        c.wJ().a((long) Ct2.field_msglocalid, ek2);
                        v.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + Ct2.field_totallen + " status:" + Ct2.field_status + " netTimes:" + Ct2.field_nettimes);
                        i4 = 1;
                        h.lD(str2);
                    }
                    if (!h.a(Ct2)) {
                        i4 = -4;
                    }
                }
            }
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.aST + " MsgSvrId:" + com_tencent_mm_protocal_c_bcu.mcb + " clientId:" + com_tencent_mm_protocal_c_bcu.mcN + " neWWOff:" + this.dik + " neTTTT:" + com_tencent_mm_protocal_c_bcu.mff);
            if (i4 < 0) {
                h.lh(this.aST);
                v.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.aST + "UpdateAfterSend Ret:" + i4);
                this.cii.a(i2, i3, str, this);
            } else if (i4 == 1) {
                v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.aST);
                this.cii.a(i2, i3, str, this);
            } else {
                long j2 = this.diB ? 0 : 500;
                v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.aST + " delay:" + j2);
                this.cxS.ea(j2);
            }
        } else {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.aST + " errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 329;
    }
}
