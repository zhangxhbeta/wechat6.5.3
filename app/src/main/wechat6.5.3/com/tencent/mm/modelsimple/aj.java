package com.tencent.mm.modelsimple;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;

public final class aj {
    private static boolean cZr = false;
    private static int cZs = 3;
    private static long cZt = 0;
    private static e cii = null;

    public static void run() {
        if (cZr) {
            v.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            return;
        }
        if (cZt == 0 || be.az(cZt) > 180000) {
            cZt = be.Nj();
            cZs = 3;
        }
        if (cZs <= 0) {
            v.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            return;
        }
        cZs--;
        final String str = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
        if (new File(str).exists()) {
            if (cii == null) {
                cii = new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        v.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            b.deleteFile(str);
                        }
                        aj.cZr = false;
                        ak.vy().b(157, aj.cii);
                    }
                };
            }
            ak.vy().a(157, cii);
            ak.vy().a(new l(1, str), 0);
            cZr = true;
            return;
        }
        v.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
    }
}
