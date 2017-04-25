package com.tencent.mm.pluginsdk.model.downloader;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class FileDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        long j = -1;
        if (context != null && intent != null) {
            String action = intent.getAction();
            v.i("MicroMsg.FileDownloadReceiver", action);
            if (be.kS(action)) {
                v.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
            } else if (!action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            } else {
                if (!ak.uz() || ak.uG()) {
                    v.i("MicroMsg.FileDownloadReceiver", "not login");
                    return;
                }
                try {
                    j = intent.getLongExtra("extra_download_id", -1);
                } catch (Throwable e) {
                    v.e("MicroMsg.FileDownloadReceiver", "%s", be.e(e));
                }
                if (j < 0) {
                    v.e("MicroMsg.FileDownloadReceiver", "get download id failed");
                    return;
                }
                try {
                    ((DownloadManager) context.getSystemService("download")).openDownloadedFile(j).close();
                    d.bnK();
                    if (d.dJ(j)) {
                        d.bnK();
                        d.bnK().dM(d.dL(j));
                        return;
                    }
                    al alVar;
                    am wL = c.wL();
                    if (wL == null) {
                        alVar = null;
                    } else if (j < 1) {
                        v.e("MicroMsg.FileDownloadInfoStorage", "Invalie sys download id");
                        alVar = null;
                    } else {
                        Cursor rawQuery = wL.rawQuery("select * from FileDownloadInfo where sysDownloadId=" + j + " order by downloadId desc limit 1", new String[0]);
                        if (rawQuery == null) {
                            alVar = null;
                        } else {
                            if (rawQuery.moveToFirst()) {
                                alVar = new al();
                                alVar.b(rawQuery);
                            } else {
                                alVar = null;
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                    if (alVar == null) {
                        v.e("MicroMsg.FileDownloadReceiver", "SysId: %d not found in db, ignoring");
                    } else if (alVar.field_autoInstall) {
                        Intent intent2 = new Intent();
                        intent2.setClass(context, FileDownloadService.class);
                        intent2.putExtra(FileDownloadService.EXTRA_ID, alVar.field_downloadId);
                        intent2.putExtra(FileDownloadService.lCp, 1);
                        ComponentName startService = context.startService(intent2);
                        v.d("MicroMsg.FileDownloadReceiver", "start download service: " + startService.getClassName() + ", " + startService.getPackageName());
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.FileDownloadReceiver", "File not existed (caused by removing task or something)");
                }
            }
        }
    }
}
