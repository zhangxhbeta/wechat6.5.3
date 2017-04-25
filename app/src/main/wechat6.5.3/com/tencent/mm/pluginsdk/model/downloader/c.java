package com.tencent.mm.pluginsdk.model.downloader;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;

public final class c {
    public static al dG(long j) {
        am wL = wL();
        if (wL == null) {
            return null;
        }
        return wL.ei(j);
    }

    public static al GJ(String str) {
        am wL = wL();
        if (wL == null) {
            return null;
        }
        return wL.GJ(str);
    }

    public static long a(al alVar) {
        if (alVar == null) {
            return -1;
        }
        am wL = wL();
        if (wL == null) {
            return -1;
        }
        v.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + alVar.field_downloadId + ", ret=" + wL.b(alVar));
        return alVar.field_downloadId;
    }

    public static long b(al alVar) {
        if (alVar == null) {
            return -1;
        }
        am wL = wL();
        if (wL == null) {
            return -1;
        }
        boolean a = wL.a((com.tencent.mm.sdk.h.c) alVar, new String[0]);
        v.i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(alVar.field_downloadId), Boolean.valueOf(a), Integer.valueOf(alVar.field_status));
        return alVar.field_downloadId;
    }

    public static boolean w(long j, int i) {
        am wL = wL();
        if (wL == null) {
            return false;
        }
        return wL.dF("FileDownloadInfo", "update FileDownloadInfo set status = " + i + " where downloadId = " + j);
    }

    public static boolean e(long j, long j2, long j3) {
        am wL = wL();
        if (wL == null) {
            return false;
        }
        return wL.dF("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j2 + ",totalSize= " + j3 + " where downloadId = " + j);
    }

    public static boolean GK(String str) {
        am wL = wL();
        if (wL == null) {
            return false;
        }
        if (be.kS(str)) {
            v.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            return false;
        }
        return wL.dF("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
    }

    public static boolean GL(String str) {
        am wL = wL();
        if (wL == null) {
            return false;
        }
        if (be.kS(str)) {
            v.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            return false;
        }
        return wL.dF("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
    }

    public static al GM(String str) {
        al alVar = null;
        am wL = wL();
        if (wL != null) {
            if (be.kS(str)) {
                v.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            } else {
                Cursor rawQuery = wL.rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        alVar = new al();
                        alVar.b(rawQuery);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
        }
        return alVar;
    }

    public static boolean dH(long j) {
        am wL = wL();
        if (wL == null) {
            return false;
        }
        com.tencent.mm.sdk.h.c alVar = new al();
        alVar.field_downloadId = j;
        return wL.c(alVar, new String[0]);
    }

    public static am wL() {
        if (!ak.uz() || ak.uG()) {
            v.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
            return null;
        }
        com.tencent.mm.model.c yW = ak.yW();
        if (yW != null) {
            return yW.wL();
        }
        return null;
    }
}
