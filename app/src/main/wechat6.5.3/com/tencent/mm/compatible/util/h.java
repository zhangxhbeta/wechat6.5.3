package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.be;
import java.io.File;

public final class h {
    public static File getExternalStorageDirectory() {
        if (be.kS(p.ceJ.cdX)) {
            return Environment.getExternalStorageDirectory();
        }
        return new File(p.ceJ.cdX);
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        if (be.kS(p.ceJ.cdY)) {
            return Environment.getExternalStoragePublicDirectory(str);
        }
        return new File(p.ceJ.cdY);
    }

    public static File getDataDirectory() {
        if (be.kS(p.ceJ.cdZ)) {
            return Environment.getDataDirectory();
        }
        return new File(p.ceJ.cdZ);
    }

    public static String getExternalStorageState() {
        if (be.kS(p.ceJ.ceb)) {
            return Environment.getExternalStorageState();
        }
        return p.ceJ.ceb;
    }

    public static boolean sj() {
        try {
            return getExternalStorageState().equals("mounted") && new File(getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e) {
            return false;
        }
    }
}
