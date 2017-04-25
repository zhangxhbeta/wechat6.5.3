package com.tencent.mm.u;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.io.OutputStream;

final class k extends com.tencent.mm.v.k implements j {
    private e cii;
    private int cyJ;
    private OutputStream cyK = null;
    private String cyL;
    private String cyn;
    private int cyr;
    private String cyt;
    private String username;

    public k(String str) {
        this.username = str;
        if (u.ew(str)) {
            this.username = u.LM(str);
        }
        v.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.cyr = 480;
        this.cyJ = 480;
        this.cyt = "jpg";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.cii = eVar2;
        if (this.username == null || this.username.length() == 0) {
            v.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            v.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            return -1;
        } else {
            g Bp = n.Bp();
            n.AX();
            this.cyn = d.s(this.username, true);
            if (FileOp.aR(this.cyn)) {
                v.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                return 0;
            }
            f fVar;
            this.cyL = this.cyn + ".tmp";
            f gP = Bp.gP(this.username);
            if (gP == null) {
                FileOp.deleteFile(this.cyL);
                gP = new f();
                gP.username = this.username;
                gP.cyt = this.cyt;
                gP.cyr = this.cyr;
                gP.cys = this.cyJ;
                gP.bkU = -1;
                Bp.cuX.insert("hdheadimginfo", "username", gP.py());
                fVar = gP;
            } else {
                String str = this.cyL;
                if (gP != null && str != null && str.length() != 0 && gP.Bc().equals(this.cyt) && gP.cyr == this.cyr && gP.cys == this.cyJ && FileOp.jP(str) == ((long) gP.cyv)) {
                    z = true;
                }
                if (!z) {
                    FileOp.deleteFile(this.cyL);
                    gP.reset();
                    gP.username = this.username;
                    gP.cyt = this.cyt;
                    gP.cyr = this.cyr;
                    gP.cys = this.cyJ;
                    Bp.a(this.username, gP);
                }
                fVar = gP;
            }
            a aVar = new a();
            aVar.czn = new wg();
            aVar.czo = new wh();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.czm = 158;
            aVar.czp = 47;
            aVar.czq = 1000000047;
            p Bv = aVar.Bv();
            wg wgVar = (wg) Bv.czk.czs;
            if (!u.ew(this.username)) {
                wgVar.gln = this.username;
                wgVar.myM = 1;
            } else if (this.username.equals(com.tencent.mm.model.k.xF() + "@bottle")) {
                wgVar.gln = com.tencent.mm.model.k.xF();
                wgVar.myM = 2;
            } else {
                wgVar.gln = this.username;
                wgVar.myM = 2;
            }
            v.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + wgVar.gln + " outType:" + wgVar.myM);
            wgVar.myJ = this.cyr;
            wgVar.myK = this.cyJ;
            wgVar.myL = this.cyt;
            wgVar.mdz = fVar.cyu;
            wgVar.mdA = fVar.cyv;
            return a(eVar, Bv, this);
        }
    }

    protected final int a(p pVar) {
        if (this.username == null || this.username.length() == 0) {
            return b.czV;
        }
        return b.czU;
    }

    protected final int ul() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        wh whVar = (wh) ((b) pVar).czl.czs;
        v.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            v.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
            Bh();
        } else if (i2 == 4 || i2 == 5) {
            this.cii.a(i2, i3, str, this);
            v.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + i2);
            Bh();
        } else {
            Object obj;
            int i4 = pVar.ze().lWU;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                v.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + i4);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                v.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.cii.a(i2, i3, str, this);
                Bh();
                return;
            }
            i4 = -1;
            if (!(whVar.mfg == null || whVar.mfg.mQw == null)) {
                i4 = z(whVar.mfg.mQw.lVU);
            }
            if (i4 < 0) {
                v.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.cii.a(i2, i3, str, this);
                Bh();
                return;
            }
            Object obj2;
            g Bp = n.Bp();
            f gP = Bp.gP(this.username);
            gP.cyv = i4 + whVar.mdA;
            gP.cyu = whVar.mdz;
            Bp.a(this.username, gP);
            if (gP.cyv >= gP.cyu) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                v.d("MicroMsg.NetSceneGetHDHeadImg", "doScene again");
                a(this.czE, this.cii);
                return;
            }
            FileOp.ab(this.cyL, this.cyn);
            P(this.cyn, this.username);
            Bh();
            this.cii.a(i2, i3, str, this);
        }
    }

    public static void P(String str, String str2) {
        n.AX().O(str, str2);
    }

    protected final void cancel() {
        super.cancel();
        Bh();
    }

    public final int getType() {
        return 158;
    }

    private int z(byte[] bArr) {
        try {
            if (this.cyK == null) {
                this.cyK = FileOp.gt(this.cyL);
            }
            this.cyK.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", be.e(e));
            return -1;
        }
    }

    private void Bh() {
        try {
            if (this.cyK != null) {
                this.cyK.flush();
                this.cyK.close();
                this.cyK = null;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", be.e(e));
        }
    }
}
