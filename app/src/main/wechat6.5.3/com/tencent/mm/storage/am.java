package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class am extends f<al> {
    public static final String[] cic = new String[]{f.a(al.chq, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    public am(d dVar) {
        super(dVar, al.chq, "FileDownloadInfo", null);
    }

    public final al GJ(String str) {
        al alVar = null;
        if (be.kS(str)) {
            v.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
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
        return alVar;
    }

    public final al ei(long j) {
        al alVar = null;
        if (j < 0) {
            v.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=" + j, new String[0]);
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
        return alVar;
    }

    public final boolean bvW() {
        return dF("FileDownloadInfo", "delete from FileDownloadInfo");
    }
}
