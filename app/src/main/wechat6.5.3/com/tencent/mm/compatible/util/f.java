package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class f {
    public static boolean dW(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean dX(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean sj() {
        boolean z = false;
        if (e.cni.equalsIgnoreCase(h.getExternalStorageDirectory().getAbsolutePath())) {
            try {
                if (h.getExternalStorageState().equals("mounted") && new File(h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                v.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + e.cni);
                return z;
            }
        }
        try {
            return new File(e.cni).canWrite();
        } catch (Exception e2) {
            v.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + e.cni);
            return z;
        }
    }

    public static boolean G(long j) {
        StatFs statFs;
        long blockCount;
        long j2;
        Exception e;
        if (sj()) {
            try {
                statFs = new StatFs(e.cni);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        j2 = blockCount;
                        blockCount = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        v.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        j2 = blockCount;
                        blockCount = 0;
                        return statFs != null ? false : false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    blockCount = 0;
                    v.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    j2 = blockCount;
                    blockCount = 0;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                blockCount = 0;
                v.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                j2 = blockCount;
                blockCount = 0;
                if (statFs != null) {
                }
            }
            if (statFs != null || r8 <= 0 || r8 - r4 < 0) {
                return false;
            }
            if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) >= j) {
                return true;
            }
            v.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
            return false;
        }
        v.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        return false;
    }
}
