package com.tencent.mm.u;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.bcb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends k implements j {
    private String bhr;
    private e cii;
    private String cyM;
    private String cyN;
    private String cyO = com.tencent.mm.model.k.xF();
    private int cyu;
    private int cyv;
    private int cyw;

    private static int Q(String str, String str2) {
        Options JS = d.JS(str);
        if (JS.outHeight >= 640 || JS.outWidth >= 640) {
            v.d("MicroMsg.NetSceneUploadHDHeadImg", "src w:%d h:%d samp:%d", Integer.valueOf(JS.outWidth), Integer.valueOf(JS.outHeight), Integer.valueOf(Math.max(JS.outWidth / 640, JS.outHeight / 640)));
            JS = new Options();
            JS.inPreferredConfig = Config.ARGB_8888;
            JS.inSampleSize = r2;
            Bitmap decodeFile = d.decodeFile(str, JS);
            if (decodeFile == null) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(r2));
                return 0 - g.sk();
            }
            v.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, 640, 640, true);
            if (decodeFile != createScaledBitmap) {
                v.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                decodeFile.recycle();
            }
            if (createScaledBitmap == null) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                return 0 - g.sk();
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.gt(str2);
                createScaledBitmap.compress(CompressFormat.JPEG, 40, outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                v.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                return 0;
            } catch (Throwable e2) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", be.e(e2));
                v.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                int sk = 0 - g.sk();
                if (outputStream == null) {
                    return sk;
                }
                try {
                    outputStream.close();
                    return sk;
                } catch (IOException e3) {
                    return sk;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            FileOp.p(str, str2);
            v.v("MicroMsg.NetSceneUploadHDHeadImg", "outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(JS.outHeight), Integer.valueOf(JS.outWidth));
            return 0;
        }
    }

    public l(int i, String str) {
        if (i == 2) {
            this.cyO = u.LM(this.cyO);
        }
        n.AX();
        this.cyM = d.s(this.cyO, true);
        String str2 = this.cyM + ".tmp";
        if (Q(str, str2) == 0) {
            this.bhr = str2;
            this.cyw = i;
            n.AX();
            this.cyN = com.tencent.mm.a.g.m(FileOp.c(d.s(this.cyO, true), 0, -1));
            this.cyu = 0;
            this.cyv = 0;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.bhr == null || this.bhr.length() == 0) {
            v.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            return -1;
        } else if (FileOp.aR(this.bhr)) {
            if (this.cyu == 0) {
                this.cyu = (int) FileOp.jP(this.bhr);
            }
            byte[] c = FileOp.c(this.bhr, this.cyv, Math.min(this.cyu - this.cyv, 8192));
            if (c == null) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                return -1;
            }
            v.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(c.length), Integer.valueOf(this.cyu));
            a aVar = new a();
            aVar.czn = new bca();
            aVar.czo = new bcb();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.czm = 157;
            aVar.czp = 46;
            aVar.czq = 1000000046;
            p Bv = aVar.Bv();
            bca com_tencent_mm_protocal_c_bca = (bca) Bv.czk.czs;
            com_tencent_mm_protocal_c_bca.mdz = this.cyu;
            com_tencent_mm_protocal_c_bca.mdA = this.cyv;
            com_tencent_mm_protocal_c_bca.myM = this.cyw;
            com_tencent_mm_protocal_c_bca.mfg = new are().ba(c);
            com_tencent_mm_protocal_c_bca.mXH = this.cyN;
            return a(eVar, Bv, this);
        } else {
            v.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.bhr);
            return -1;
        }
    }

    protected final int a(p pVar) {
        if (this.bhr == null || this.bhr.length() == 0) {
            return b.czV;
        }
        return b.czU;
    }

    protected final int ul() {
        return 200;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 0;
        bcb com_tencent_mm_protocal_c_bcb = (bcb) ((b) pVar).czl.czs;
        v.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            v.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 4 || i2 == 5) {
            this.cii.a(i2, i3, str, this);
            v.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + i2);
        } else {
            if (pVar.ze().lWU == -4) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(pVar.ze().lWU));
                i4 = 1;
            }
            if (i4 != 0) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.cii.a(i2, i3, str, this);
                return;
            }
            this.cyv = com_tencent_mm_protocal_c_bcb.mdA;
            if (this.cyv < this.cyu) {
                if (a(this.czE, this.cii) < 0) {
                    v.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                }
                v.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                return;
            }
            try {
                FileOp.ab(this.bhr, this.cyM);
                ak.yW();
                c.vf().set(12297, com_tencent_mm_protocal_c_bcb.mXI);
                n.AX().d(this.cyO, d.JV(this.cyM));
                String xF = com.tencent.mm.model.k.xF();
                if (!be.kS(xF)) {
                    h hVar = new h();
                    hVar.username = xF;
                    hVar.aP(true);
                    hVar.bkU = 32;
                    hVar.bBY = 3;
                    hVar.bkU = 34;
                    n.Bo().a(hVar);
                }
                this.cii.a(i2, i3, str, this);
            } catch (Exception e) {
                v.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            }
        }
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 157;
    }
}
