package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.protocal.c.pv;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public final class aa extends k implements j {
    private final b cif;
    private e cii = null;
    private int fLK = 0;
    private int fLO = 0;
    public i fLP;
    private boolean fLQ = true;
    private boolean fLR = false;

    public aa(i iVar) {
        a aVar = new a();
        aVar.czn = new jv();
        aVar.czo = new jw();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.czm = 404;
        aVar.czp = 197;
        aVar.czq = 1000000197;
        this.cif = aVar.Bv();
        this.fLP = iVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        List list = this.fLP.field_favProto.mtR;
        int size = list.size();
        if (size == 0) {
            v.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.fLO = -100;
            return -100;
        }
        int i = 0;
        jv jvVar = (jv) this.cif.czk.czs;
        jvVar.eeu.clear();
        int i2 = this.fLK;
        while (i2 < size) {
            pw pwVar = (pw) list.get(i2);
            if (!pwVar.msE) {
                ju juVar = new ju();
                juVar.mml = (int) pwVar.msn;
                juVar.mmj = pwVar.msj;
                juVar.mmk = pwVar.msl;
                juVar.mmi = String.valueOf(i2);
                juVar.mmn = pwVar.msA;
                juVar.mmm = this.fLP.field_sourceType;
                juVar.mmo = 0;
                jvVar.eeu.add(juVar);
                i++;
                v.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{juVar.mmi, juVar.mmn, Integer.valueOf(juVar.mmm), Integer.valueOf(juVar.mml), juVar.mmj, juVar.mmk});
            }
            if (!pwVar.msG) {
                juVar = new ju();
                juVar.mml = (int) pwVar.msy;
                juVar.mmj = pwVar.msu;
                juVar.mmk = pwVar.msw;
                juVar.mmn = pwVar.msA;
                juVar.mmm = this.fLP.field_sourceType;
                juVar.mmi = i2 + "t";
                juVar.mmo = 1;
                jvVar.eeu.add(juVar);
                i++;
                v.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{juVar.mmi, juVar.mmn, Integer.valueOf(juVar.mmm), Integer.valueOf(juVar.mml), juVar.mmj, juVar.mmk});
            }
            if (i >= 19) {
                break;
            }
            i2++;
        }
        v.i("MicroMsg.NetSceneCheckCDN", "doScene: begIndex %d, usedCount %d, dataSize %d, nextBegIndex %d", new Object[]{Integer.valueOf(this.fLK), Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(i2 + 1)});
        this.fLK = i2 + 1;
        jvVar.eet = i;
        if (i != 0) {
            return a(eVar, this.cif, this);
        }
        v.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
        this.fLO = -101;
        return -101;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fLO), Integer.valueOf(this.fLK), str});
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.fLO == -100) {
                v.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                h.alu().r(9, this.fLP.field_localId);
                h.alk().run();
                this.cii.a(i2, i3, str, this);
                return;
            } else if (i2 == 3 && this.fLO == -101) {
                i3 = 0;
            } else {
                this.cii.a(i2, i3, str, this);
                return;
            }
        }
        if (this.fLO != -101 && i2 == 0 && i3 == 0) {
            List list = ((jw) ((b) pVar).czl.czs).eeu;
            List list2 = this.fLP.field_favProto.mtR;
            for (int i4 = 0; i4 < list.size(); i4++) {
                pw pwVar;
                pv pvVar = (pv) list.get(i4);
                String str2 = pvVar.mmi;
                v.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[]{Integer.valueOf(pvVar.eeO), str2});
                if (pvVar.eeO == 1) {
                    if (str2.endsWith("t")) {
                        pwVar = (pw) list2.get(be.getInt(str2.substring(0, str2.length() - 1), 0));
                        v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{pvVar.mrI, pvVar.mjT, pvVar.mmi, pvVar.mmj, Integer.valueOf(pvVar.mml), pvVar.mmk});
                        pwVar.Iz(pvVar.mjT);
                        pwVar.Iy(pvVar.mrI);
                        if (pvVar.mml > 0) {
                            pwVar.dR((long) pvVar.mml);
                        }
                    } else {
                        pwVar = (pw) list2.get(be.getInt(str2, 0));
                        v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{pvVar.mrI, pvVar.mjT, pvVar.mmi, pvVar.mmj, Integer.valueOf(pvVar.mml), pvVar.mmk});
                        pwVar.IB(pvVar.mjT);
                        pwVar.IA(pvVar.mrI);
                        if (!be.kS(pvVar.mrJ)) {
                            pwVar.IP(pvVar.mrJ);
                        }
                        if (be.kS(pwVar.msj)) {
                            v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                            pwVar.IH(pvVar.mmj);
                            pwVar.dQ((long) pvVar.mml);
                            pwVar.II(pvVar.mmk);
                            v.a(pwVar, this.fLP, 1, false);
                        }
                        if (!(be.kS(pvVar.mmj) || pvVar.mmj.equals(pwVar.msj))) {
                            v.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[]{pvVar.mmj, pwVar.msj});
                            pwVar.IH(pvVar.mmj);
                        }
                        if (!(be.kS(pvVar.mmk) || pvVar.mmk.equals(pwVar.msl))) {
                            v.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[]{pvVar.mmk, pwVar.msl});
                            pwVar.II(pvVar.mmk);
                        }
                        if (pvVar.mml > 0 && ((long) pvVar.mml) != pwVar.msn) {
                            v.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(pvVar.mml), Long.valueOf(pwVar.msn)});
                            pwVar.dQ((long) pvVar.mml);
                        }
                    }
                }
                if (pvVar.eeO == 3 || pvVar.eeO == -2 || pvVar.eeO == -1) {
                    if (str2.endsWith("t")) {
                        pwVar = (pw) list2.get(be.getInt(str2.substring(0, str2.length() - 1), 0));
                        if (be.kS(pwVar.msu)) {
                            v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[]{pwVar.msu});
                        } else {
                            this.fLQ = false;
                            v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s", new Object[]{pwVar.msu});
                            v.a(pwVar, this.fLP, 0);
                        }
                    } else {
                        pwVar = (pw) list2.get(be.getInt(str2, 0));
                        if (be.kS(pwVar.msj)) {
                            v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[]{pwVar.msj});
                        } else {
                            this.fLQ = false;
                            v.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s", new Object[]{pwVar.msj});
                            v.a(pwVar, this.fLP, 0, false);
                        }
                    }
                }
                if (pvVar.eeO == 2) {
                    this.fLR = true;
                    if (str2.endsWith("t")) {
                        v.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                    } else {
                        v.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[]{Integer.valueOf(pvVar.mrK), pvVar.mrI, pvVar.mjT});
                        pwVar = (pw) list2.get(be.getInt(str2, 0));
                        pwVar.uH(pvVar.mrK);
                        pwVar.IB(pvVar.mjT);
                        pwVar.IA(pvVar.mrI);
                        if (!be.kS(pvVar.mrJ)) {
                            pwVar.IP(pvVar.mrJ);
                        }
                        if (!(be.kS(pvVar.mmj) || pvVar.mmj.equals(pwVar.msj))) {
                            v.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[]{pvVar.mmj, pwVar.msj});
                            pwVar.IH(pvVar.mmj);
                        }
                        if (!(be.kS(pvVar.mmk) || pvVar.mmk.equals(pwVar.msl))) {
                            v.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[]{pvVar.mmk, pwVar.msl});
                            pwVar.II(pvVar.mmk);
                        }
                        if (pvVar.mml > 0 && ((long) pvVar.mml) != pwVar.msn) {
                            v.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(pvVar.mml), Long.valueOf(pwVar.msn)});
                            pwVar.dQ((long) pvVar.mml);
                        }
                    }
                }
            }
            v.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd: nextBegIndex %d, resultCount %d, dataSize %d", new Object[]{Integer.valueOf(this.fLK), Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
            if (this.fLK < list2.size()) {
                v.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                int a = a(this.czE, this.cii);
                if (!(a == -100 || a == -101)) {
                    return;
                }
            }
        }
        if (this.fLR) {
            v.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.fLP.field_itemStatus = 12;
            h.alu().a(this.fLP, "localId");
            h.alk().run();
            this.cii.a(i2, i3, str, this);
            return;
        }
        if (this.fLQ) {
            v.v("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.fLP.field_type == 18 && this.fLP.field_id > 0) {
                this.fLP.field_itemStatus = 17;
                h.alu().a(this.fLP, "localId");
                h.alm().run();
            } else if (!ami()) {
                this.fLP.field_itemStatus = 9;
                h.alu().a(this.fLP, "localId");
                h.alk().run();
            } else {
                return;
            }
        }
        if (this.fLP.field_type == 18 && this.fLP.field_id > 0) {
            this.fLP.field_itemStatus = 15;
        } else if (!ami()) {
            this.fLP.field_itemStatus = 4;
        } else {
            return;
        }
        h.alu().a(this.fLP, "localId");
        h.alo().run();
        this.cii.a(i2, i3, str, this);
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 10;
    }

    public final int getType() {
        return 404;
    }

    private boolean ami() {
        if (this.fLP.field_type == 18) {
            i bB = h.alu().bB(this.fLP.field_localId);
            if (bB != null && bB.field_id < 0 && bB.field_favProto.version >= 2) {
                bB.field_favProto.uM(1);
                h.alu().a(bB, "localId");
                this.fLP = bB;
                ak.vy().a(new aa(this.fLP), 0);
                return true;
            }
        }
        return false;
    }
}
