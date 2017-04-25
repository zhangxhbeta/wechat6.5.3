package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.protocal.c.aac;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends a<aac, aad> {
    public String appName;
    public boolean fwA;
    private final WeakReference<b<j>> fwB;
    public String fwh;
    public String fwi;
    public boolean fwq;
    public String fwr;
    public String fws;
    public com.tencent.mm.plugin.exdevice.f.b.a.a fwt;
    public ArrayList<d> fwu;
    public ArrayList<c> fwv;
    public ArrayList<e> fww;
    public ArrayList<String> fwx;
    public String fwy;
    public String fwz;

    protected final /* bridge */ /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
        aac com_tencent_mm_protocal_c_aac = (aac) aVar;
        com_tencent_mm_protocal_c_aac.fDn = this.appName;
        com_tencent_mm_protocal_c_aac.coI = this.fwr;
        com_tencent_mm_protocal_c_aac.mBD = this.fwq;
        com_tencent_mm_protocal_c_aac.mBE = this.fws;
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new aac();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new aad();
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        this.fwB = new WeakReference(bVar);
        this.fwy = str;
        this.fwr = str;
        this.appName = be.ma(str2);
        this.fwq = z;
        this.fws = str3;
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            aad com_tencent_mm_protocal_c_aad = (aad) Ud();
            String str5 = "";
            this.fwv = new ArrayList();
            if (com_tencent_mm_protocal_c_aad.mbS != null) {
                it = com_tencent_mm_protocal_c_aad.mbS.iterator();
                while (it.hasNext()) {
                    qs qsVar = (qs) it.next();
                    ak.yW();
                    if (com.tencent.mm.model.c.wH().LT(qsVar.username)) {
                        str2 = com_tencent_mm_protocal_c_aad.coI;
                        str3 = this.appName;
                        if (be.kS(str2) || qsVar == null) {
                            v.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = qsVar.username;
                            cVar.field_step = qsVar.eWn;
                            cVar.field_appusername = str3;
                            c cVar2 = cVar;
                        }
                        if (obj != null) {
                            this.fwv.add(obj);
                        }
                    } else {
                        ak.vy().a(new h(qsVar.username, null), 0);
                    }
                }
            }
            this.fwu = new ArrayList();
            if (com_tencent_mm_protocal_c_aad.mBF != null) {
                it = com_tencent_mm_protocal_c_aad.mBF.iterator();
                while (it.hasNext()) {
                    d dVar;
                    bjn com_tencent_mm_protocal_c_bjn = (bjn) it.next();
                    str2 = com_tencent_mm_protocal_c_aad.coI;
                    str3 = this.appName;
                    if (be.kS(str2) || com_tencent_mm_protocal_c_bjn == null) {
                        v.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = com_tencent_mm_protocal_c_bjn.ndX;
                        dVar.field_ranknum = com_tencent_mm_protocal_c_bjn.ndW;
                        dVar.field_score = com_tencent_mm_protocal_c_bjn.score;
                        dVar.field_selfLikeState = com_tencent_mm_protocal_c_bjn.ndY;
                        dVar.field_username = com_tencent_mm_protocal_c_bjn.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.fwu.add(dVar);
                        str5 = str4;
                    }
                }
            }
            this.fww = new ArrayList();
            if (com_tencent_mm_protocal_c_aad.mBG != null) {
                it = com_tencent_mm_protocal_c_aad.mBG.iterator();
                while (it.hasNext()) {
                    bjo com_tencent_mm_protocal_c_bjo = (bjo) it.next();
                    str2 = com_tencent_mm_protocal_c_aad.coI;
                    str3 = this.appName;
                    if (be.kS(str2) || com_tencent_mm_protocal_c_bjo == null) {
                        v.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = com_tencent_mm_protocal_c_bjo.eWB;
                        eVar.field_username = com_tencent_mm_protocal_c_bjo.username;
                        e eVar2 = eVar;
                    }
                    if (obj != null) {
                        this.fww.add(obj);
                    }
                }
            }
            this.fwx = new ArrayList();
            if (com_tencent_mm_protocal_c_aad.mBz != null) {
                Iterator it2 = com_tencent_mm_protocal_c_aad.mBz.iterator();
                while (it2.hasNext()) {
                    this.fwx.add((String) it2.next());
                }
            }
            if (!be.kS(this.fws)) {
                str5 = this.fws;
            }
            String str6 = com_tencent_mm_protocal_c_aad.mBH;
            String str7 = com_tencent_mm_protocal_c_aad.mBI;
            if (be.kS(str5)) {
                v.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.fwt = aVar;
            this.fwy = com_tencent_mm_protocal_c_aad.coI;
            this.fwi = com_tencent_mm_protocal_c_aad.mBB;
            this.fwh = com_tencent_mm_protocal_c_aad.mBA;
            this.fwz = com_tencent_mm_protocal_c_aad.mBJ;
            this.fwA = com_tencent_mm_protocal_c_aad.fwA;
            v.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.fwr == null || !this.fwr.equals(this.fwy)) {
                f fVar = ac.ajy().fwI;
                if (fVar != null) {
                    fVar.sj(this.fwy);
                }
            }
            ac.ajs().ao(this.fwv);
            com.tencent.mm.plugin.exdevice.f.b.b.d ajr = ac.ajr();
            if (be.kS(this.fwy)) {
                v.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = ajr.cie.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.fwy});
                v.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[]{str4, Integer.valueOf(delete)});
            }
            ac.ajr().b(this.fwy, this.fwu);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.fwA);
            objArr[1] = Integer.valueOf(this.fwv != null ? this.fwv.size() : 0);
            objArr[2] = Integer.valueOf(this.fwu != null ? this.fwu.size() : 0);
            objArr[3] = Integer.valueOf(this.fww != null ? this.fww.size() : 0);
            v.i(str4, str5, objArr);
            ac.ajv().a(this.fwy, this.appName, this.fww);
            if (this.fwt != null) {
                ac.aju().a(this.fwt, true);
            }
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.fwB.get();
        if (bVar != null) {
            bVar.c(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }
}
