package com.tencent.mm.pluginsdk.model.downloader;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public class FileDownloadService extends IntentService {
    public static final String EXTRA_ID = (lCo + "id");
    public static final String EXTRA_PACKAGE_NAME = (lCo + "package_name");
    private static final String lCo = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String lCp = (lCo + "action_type");
    public static final String lCq = (lCo + "file_path");
    public static final String lCr = (lCo + "md5");

    public FileDownloadService() {
        super("FileDownloadService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            v.i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intent.getIntExtra(lCp, 0)));
            switch (intent.getIntExtra(lCp, 0)) {
                case 1:
                    long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                    if (longExtra < 0) {
                        v.e("MicroMsg.FileDownloadService", "Invalid id");
                        return;
                    } else if (!ak.uz() || ak.uG()) {
                        v.d("MicroMsg.FileDownloadService", "no user login");
                        return;
                    } else {
                        al dG = c.dG(longExtra);
                        if (dG == null) {
                            return;
                        }
                        if (be.kS(dG.field_md5)) {
                            v.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                            dG.field_status = 3;
                            c.b(dG);
                            d.bnK().dM(longExtra);
                            return;
                        } else if (dn(dG.field_filePath, dG.field_md5)) {
                            dG.field_status = 3;
                            c.b(dG);
                            d.bnK().dM(longExtra);
                            return;
                        } else {
                            b.deleteFile(dG.field_filePath);
                            dG.field_status = 4;
                            c.b(dG);
                            d bnK = d.bnK();
                            al dG2 = c.dG(longExtra);
                            if (dG2 != null) {
                                Context context = aa.getContext();
                                if (dG2.field_showNotification && be.kS(dG2.field_fileName)) {
                                    String str = dG2.field_downloadUrl;
                                    d.a(context.getString(2131232767), SQLiteDatabase.KeyEmpty, null);
                                } else if (dG2.field_showNotification && !be.kS(dG2.field_fileName)) {
                                    String str2 = dG2.field_downloadUrl;
                                    d.a(dG2.field_fileName, context.getString(2131232767), null);
                                }
                                bnK.lCa.v(longExtra, b.lBQ);
                                return;
                            }
                            return;
                        }
                    }
                case 3:
                    String stringExtra = intent.getStringExtra(lCq);
                    String stringExtra2 = intent.getStringExtra(lCr);
                    if (be.kS(stringExtra) || !e.aR(stringExtra)) {
                        v.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                        return;
                    } else if (be.kS(stringExtra2) || dn(stringExtra, stringExtra2)) {
                        Uri fromFile = Uri.fromFile(new File(stringExtra));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private static boolean dn(String str, String str2) {
        File file = new File(str);
        v.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(file.exists()));
        long currentTimeMillis = System.currentTimeMillis();
        String g = g.g(file);
        v.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        v.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", str2, g);
        if (be.kS(str2)) {
            return file.exists();
        }
        if (!be.kS(g)) {
            return str2.equalsIgnoreCase(g);
        }
        v.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
        return file.exists();
    }
}
