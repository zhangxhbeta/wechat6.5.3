package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;

public final class d {
    private static final String fvZ = (e.cgp + "uploaded_photos/");
    private static final String fwa = (e.cgp + "temp/");

    public static String sh(String str) {
        String str2;
        if (be.kS(str)) {
            str2 = "";
        } else {
            str2 = new File(ajD(), z.Kg(str) + "_t").getAbsolutePath();
        }
        com.tencent.mm.sdk.platformtools.d.b(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        return str2;
    }

    public static File ajD() {
        File file = new File(fvZ);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }
}
