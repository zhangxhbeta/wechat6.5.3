package com.tencent.mm.l;

import android.content.Context;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static int tX() {
        long availableBlocks;
        long blockCount;
        long blockSize;
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getFreeBlocks());
            } catch (Exception e) {
                blockSize = availableBlocks;
                v.e("MicroMsg.DbChecker", "get db spare space error");
                availableBlocks = blockSize;
                blockCount = 0;
                blockSize = 0;
                v.i("MicroMsg.DbChecker", "checkRomSparespace available:%d all:%d freeSize :%d", Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(blockSize));
                if (availableBlocks >= 5242880) {
                    return 2;
                }
                if (availableBlocks < 10485760) {
                    return 1;
                }
                return 0;
            }
        } catch (Exception e2) {
            blockSize = 0;
            v.e("MicroMsg.DbChecker", "get db spare space error");
            availableBlocks = blockSize;
            blockCount = 0;
            blockSize = 0;
            v.i("MicroMsg.DbChecker", "checkRomSparespace available:%d all:%d freeSize :%d", Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(blockSize));
            if (availableBlocks >= 5242880) {
                return 2;
            }
            if (availableBlocks < 10485760) {
                return 1;
            }
            return 0;
        }
        v.i("MicroMsg.DbChecker", "checkRomSparespace available:%d all:%d freeSize :%d", Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(blockSize));
        if (blockCount != 0 && ((double) availableBlocks) / ((double) blockCount) < 0.10000000149011612d) {
            if (availableBlocks >= 5242880) {
                return 2;
            }
            if (availableBlocks < 10485760) {
                return 1;
            }
        }
        return 0;
    }

    public static void b(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("db_check_tip_time", j).commit();
    }
}
