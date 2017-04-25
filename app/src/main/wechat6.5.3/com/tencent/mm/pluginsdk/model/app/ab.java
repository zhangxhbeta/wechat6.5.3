package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.protocal.c.si;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ab extends k implements j {
    private static final String[] lAP = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private final int cYK = 3;
    private b cif;
    private e cii;

    public ab(String str) {
        this.appId = str;
        a aVar = new a();
        aVar.czn = new sh();
        aVar.czo = new si();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.czm = 231;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.appId == null || this.appId.length() == 0) {
            v.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            return -1;
        }
        sh shVar = (sh) this.cif.czk.czs;
        shVar.gkz = this.appId;
        shVar.mrf = this.cYK;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            v.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            am.bnB();
            c bns = i.bns();
            bns.field_appId = this.appId;
            am.bnB().a(bns);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            si siVar = (si) ((b) pVar).czl.czs;
            String str2 = siVar.mwi.maX;
            aky com_tencent_mm_protocal_c_aky = siVar.mwi;
            if (com_tencent_mm_protocal_c_aky == null) {
                v.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = com_tencent_mm_protocal_c_aky.gkz;
                fVar.field_appName = com_tencent_mm_protocal_c_aky.hNZ;
                fVar.field_appDiscription = com_tencent_mm_protocal_c_aky.mLM;
                fVar.field_appIconUrl = com_tencent_mm_protocal_c_aky.maV;
                fVar.field_appStoreUrl = com_tencent_mm_protocal_c_aky.mLN;
                fVar.field_appVersion = com_tencent_mm_protocal_c_aky.mht;
                fVar.field_appWatermarkUrl = com_tencent_mm_protocal_c_aky.mLO;
                fVar.field_packageName = com_tencent_mm_protocal_c_aky.maX;
                fVar.field_signature = p.GE(com_tencent_mm_protocal_c_aky.mhs);
                fVar.field_appName_en = com_tencent_mm_protocal_c_aky.mLP;
                fVar.field_appName_tw = com_tencent_mm_protocal_c_aky.mLR;
                fVar.field_appDiscription_en = com_tencent_mm_protocal_c_aky.mLQ;
                fVar.field_appDiscription_tw = com_tencent_mm_protocal_c_aky.mLS;
                fVar.field_appInfoFlag = com_tencent_mm_protocal_c_aky.gkH;
                v.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
            }
            if (fVar == null) {
                v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.cii.a(3, -1, str, this);
                return;
            }
            fVar.field_appType = siVar.mdQ;
            aky com_tencent_mm_protocal_c_aky2 = siVar.mwi;
            String str3 = com_tencent_mm_protocal_c_aky2.maX;
            String str4 = com_tencent_mm_protocal_c_aky2.mhs;
            Object obj = (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) ? 1 : null;
            if (obj != null || fVar.bnk()) {
                v.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + str2);
                com.tencent.mm.pluginsdk.ui.tools.b.HT(this.appId);
            }
            if (fVar.field_appId == null) {
                v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.cii.a(3, -1, str, this);
            } else if (fVar.field_appId.equals(this.appId)) {
                i bnB = am.bnB();
                n Gz = bnB.Gz(this.appId);
                if (Gz == null || Gz.field_appId == null || Gz.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : lAP) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (bnB.m(fVar)) {
                        am.bnz().bz(this.appId, 1);
                        am.bnz().bz(this.appId, 2);
                        am.bnz().bz(this.appId, 3);
                        am.bnz().bz(this.appId, 4);
                        am.bnz().bz(this.appId, 5);
                    } else {
                        v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.cii.a(3, -1, str, this);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : Gz.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : lAP) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (Gz == null) {
                    v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (Gz.bnl()) {
                        if (!be.kS(Gz.field_appIconUrl)) {
                            fVar.field_appIconUrl = Gz.field_appIconUrl;
                        }
                        if (!be.kS(Gz.field_appName)) {
                            fVar.field_appName = Gz.field_appName;
                        }
                        if (!be.kS(Gz.field_appName_en)) {
                            fVar.field_appName_en = Gz.field_appName_en;
                        }
                        if (!be.kS(Gz.field_appName_tw)) {
                            fVar.field_appName_tw = Gz.field_appName_tw;
                        }
                        if (!be.kS(Gz.field_appName_hk)) {
                            fVar.field_appName_hk = Gz.field_appName_hk;
                        }
                    }
                    if (be.kS(fVar.field_appId) || be.kS(Gz.field_appId)) {
                        v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(Gz.field_appId)) {
                        fVar.field_openId = Gz.field_openId;
                        fVar.field_authFlag = Gz.field_authFlag;
                        fVar.bC(Gz.bxm);
                        fVar.bD(Gz.bxn);
                        fVar.bE(Gz.bxo);
                    } else {
                        v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (bnB.a(fVar, new String[0])) {
                    if (Gz == null || Gz.field_appIconUrl == null || Gz.field_appIconUrl.length() == 0) {
                        obj = 1;
                    } else {
                        if (!be.kS(fVar.bxG)) {
                            if (be.kS(Gz.bxG)) {
                                obj = 1;
                            } else if (!Gz.bxG.equals(Gz.bxG)) {
                                obj = 1;
                            }
                        }
                        if (!be.kS(fVar.bxH)) {
                            if (be.kS(Gz.bxH)) {
                                obj = 1;
                            } else if (!Gz.bxH.equals(Gz.bxH)) {
                                obj = 1;
                            }
                        }
                        obj = (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !Gz.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null;
                    }
                    if (obj != null) {
                        am.bnz().bz(this.appId, 1);
                        am.bnz().bz(this.appId, 2);
                        am.bnz().bz(this.appId, 3);
                        am.bnz().bz(this.appId, 4);
                        am.bnz().bz(this.appId, 5);
                    }
                } else {
                    v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.cii.a(3, -1, str, this);
                    return;
                }
                if (be.kS(fVar.field_openId)) {
                    v.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    am.bnF().Ez(fVar.field_appId);
                }
                this.cii.a(i2, i3, str, this);
            } else {
                v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.cii.a(3, -1, str, this);
            }
        } else {
            v.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 231;
    }

    protected final int a(p pVar) {
        return b.czU;
    }
}
