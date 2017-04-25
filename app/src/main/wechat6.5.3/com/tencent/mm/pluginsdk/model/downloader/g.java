package com.tencent.mm.pluginsdk.model.downloader;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    public static String GU(String str) {
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    v.i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        v.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", exception.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return SQLiteDatabase.KeyEmpty;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return SQLiteDatabase.KeyEmpty;
        } catch (Exception e2) {
            exception = e2;
            v.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", exception.getMessage());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static al b(e eVar) {
        al alVar = new al();
        alVar.field_downloadUrl = eVar.lCg;
        alVar.field_downloadUrlHashCode = eVar.lCg.hashCode();
        alVar.field_fileName = eVar.mFileName;
        alVar.field_fileType = eVar.lCi;
        alVar.field_md5 = eVar.lCh;
        alVar.field_appId = eVar.dzg;
        alVar.field_autoInstall = eVar.lCj;
        alVar.field_showNotification = eVar.lCk;
        alVar.field_packageName = eVar.gpe;
        alVar.field_autoDownload = eVar.lCm;
        return alVar;
    }
}
