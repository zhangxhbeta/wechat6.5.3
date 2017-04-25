package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends k implements j {
    private e cii;
    private int cyu = 0;
    private RandomAccessFile diw = null;
    private int etj = 0;
    private String filePath = null;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new xn();
        aVar.czo = new xo();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.czm = 141;
        aVar.czp = 29;
        aVar.czq = 1000000029;
        p Bv = aVar.Bv();
        xn xnVar = (xn) Bv.czk.czs;
        xnVar.URL = this.url;
        xnVar.mfb = this.etj;
        v.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.etj + " totallen:" + this.cyu);
        return a(eVar, Bv, this);
    }

    protected final int a(p pVar) {
        String str = ((xn) ((b) pVar).czk.czs).URL;
        Object obj = str == null ? null : str.indexOf("weixin://") != 0 ? null : 1;
        if (obj == null) {
            v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            return b.czV;
        } else if (this.etj < 0 || this.cyu < 0) {
            v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.etj + " total:" + this.cyu);
            return b.czV;
        } else {
            if (this.etj == 0) {
                if (this.cyu != 0) {
                    v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.etj + " total:" + this.cyu);
                    return b.czV;
                }
            } else if (this.etj >= this.cyu) {
                v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.etj + " total:" + this.cyu);
                return b.czV;
            }
            return b.czU;
        }
    }

    protected final int ul() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            xo xoVar = (xo) ((b) pVar).czl.czs;
            v.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.etj + " Resp[ totallen:" + xoVar.mif + " bufSize:" + xoVar.mfg.mQu + " ]");
            if (xoVar.mif > 0) {
                this.cyu = xoVar.mif;
            }
            if (c(this.url, xoVar.mfg.mQw.lVU, this.etj)) {
                this.etj = xoVar.mfg.mQu + this.etj;
                if (this.cyu <= this.etj) {
                    v.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.cyu);
                    this.cii.a(i2, i3, str, this);
                    return;
                } else if (a(this.czE, this.cii) < 0) {
                    this.cii.a(i2, i3, str, this);
                    return;
                } else {
                    return;
                }
            }
            this.cii.a(3, -1, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    private boolean c(String str, byte[] bArr, int i) {
        if (i == 0) {
            if (this.diw == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.m.a.a.Hm(str);
                if (this.filePath == null) {
                    v.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    return false;
                }
                try {
                    this.diw = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    v.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    return false;
                }
            }
            v.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            return false;
        }
        try {
            this.diw.seek((long) i);
            this.diw.write(bArr, 0, bArr.length);
            return true;
        } catch (IOException e2) {
            v.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            return false;
        }
    }

    public final int getType() {
        return 141;
    }
}
