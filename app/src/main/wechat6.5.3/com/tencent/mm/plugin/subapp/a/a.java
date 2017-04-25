package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.aaf;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileOutputStream;

public final class a extends k implements j {
    final b cif;
    private e cii;
    private ah cxS = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a kfn;

        {
            this.kfn = r1;
        }

        public final boolean oU() {
            if (this.kfn.kfm < 0) {
                return false;
            }
            bdd com_tencent_mm_protocal_c_bdd;
            aaf com_tencent_mm_protocal_c_aaf = (aaf) this.kfn.cif.czl.czs;
            try {
                com_tencent_mm_protocal_c_bdd = (bdd) com_tencent_mm_protocal_c_aaf.mBL.get(this.kfn.kfm);
            } catch (Exception e) {
                v.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.kfn.kfm + " not Found");
                com_tencent_mm_protocal_c_bdd = null;
            }
            if (!(com_tencent_mm_protocal_c_bdd == null || com_tencent_mm_protocal_c_bdd.mZg == null || com_tencent_mm_protocal_c_bdd.mZf == null)) {
                v.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + com_tencent_mm_protocal_c_aaf.efl + " idx:" + this.kfn.kfm + " id:" + Integer.toHexString(com_tencent_mm_protocal_c_bdd.aRI) + " size:" + com_tencent_mm_protocal_c_bdd.mZf.mQu + " hdsize:" + com_tencent_mm_protocal_c_bdd.mZg.mQu);
                a.a(com_tencent_mm_protocal_c_bdd.aRI, true, com_tencent_mm_protocal_c_bdd.mZg.mQw.toByteArray());
                a.a(com_tencent_mm_protocal_c_bdd.aRI, false, com_tencent_mm_protocal_c_bdd.mZf.mQw.toByteArray());
            }
            a aVar = this.kfn;
            aVar.kfm--;
            return true;
        }
    }, true);
    int kfm = 0;

    public a() {
        int i = 0;
        ak.yW();
        int f = be.f((Integer) c.vf().get(66052, null));
        if (com.tencent.mm.model.ab.a.csb.eK(f)) {
            ak.yW();
            i = be.f((Integer) c.vf().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(f)).append(" inver:");
        ak.yW();
        v.d("MicroMsg.NetSceneGetVUserInfo", append.append(be.f((Integer) c.vf().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aae();
        aVar.czo = new aaf();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.czm = 167;
        aVar.czp = 60;
        aVar.czq = 1000000060;
        this.cif = aVar.Bv();
        ((aae) this.cif.czk.czs).efl = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 167;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 0;
        if (i2 == 0 && i3 == 0) {
            aaf com_tencent_mm_protocal_c_aaf = (aaf) ((b) pVar).czl.czs;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(com_tencent_mm_protocal_c_aaf.efl).append(" old version:");
            ak.yW();
            v.d("MicroMsg.NetSceneGetVUserInfo", append.append(be.f((Integer) c.vf().get(66053, null))).append(" Count:").append(com_tencent_mm_protocal_c_aaf.mBL.size()).toString());
            ak.yW();
            c.vf().set(66053, Integer.valueOf(com_tencent_mm_protocal_c_aaf.efl));
            if (com_tencent_mm_protocal_c_aaf.mBL.size() <= 0) {
                this.cii.a(i2, i3, str, this);
                return;
            }
            int i5 = 0;
            while (i4 < com_tencent_mm_protocal_c_aaf.mBL.size()) {
                i5 |= ((bdd) com_tencent_mm_protocal_c_aaf.mBL.get(i4)).aRI;
                i4++;
            }
            ak.yW();
            c.vf().set(66052, Integer.valueOf(i5));
            this.cii.a(i2, i3, str, this);
            this.kfm = com_tencent_mm_protocal_c_aaf.mBL.size() - 1;
            this.cxS.ea(50);
            return;
        }
        v.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    static boolean a(int i, boolean z, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.model.ab.a.csb.u(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.NetSceneGetVUserInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            v.a("MicroMsg.NetSceneGetVUserInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
