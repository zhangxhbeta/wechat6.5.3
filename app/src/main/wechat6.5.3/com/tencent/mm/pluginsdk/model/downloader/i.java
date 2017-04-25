package com.tencent.mm.pluginsdk.model.downloader;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;

public abstract class i implements m {
    protected a lCa;

    public i(a aVar) {
        this.lCa = aVar;
    }

    public static String lb(String str) {
        return z.Kg(str + System.currentTimeMillis());
    }

    public static void GV(String str) {
        if (!be.kS(str)) {
            if (new File(str).exists()) {
                v.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(new File(str).delete()));
            }
        }
    }
}
