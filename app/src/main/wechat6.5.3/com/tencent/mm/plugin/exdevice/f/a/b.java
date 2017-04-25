package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.io.IOException;

public final class b {

    static class a implements Runnable {
        private File fvX;
        private String url;

        a(String str, File file) {
            this.url = str;
            this.fvX = file;
        }

        public final void run() {
            byte[] KO = be.KO(this.url);
            if (KO != null) {
                FileOp.l(this.fvX.getAbsolutePath(), KO);
            }
        }

        public final String toString() {
            return super.toString() + "|DownloadRunnable";
        }
    }

    public static String sg(String str) {
        if (be.kS(str) || "#".equals(str)) {
            return "";
        }
        File file = new File(d.ajD(), z.Kg(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            v.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[]{e.toString()});
        }
        ak.vA().x(new a(str, file));
        return "";
    }
}
