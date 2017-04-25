package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class t {
    public boolean jCu = false;

    public static boolean b(g gVar, g gVar2) {
        try {
            if (be.kS(gVar.getKey())) {
                gVar2.dF("", "ATTACH DATABASE '" + gVar.getPath() + "' AS old ");
            } else {
                gVar2.dF("", "ATTACH DATABASE '" + gVar.getPath() + "' AS old KEY '" + gVar.getKey() + "'");
            }
            v.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + gVar.getKey());
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[]{e.getMessage()});
            v.a("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            return false;
        }
    }

    public static int a(g gVar, g gVar2, String str) {
        String str2 = null;
        Cursor rawQuery = gVar.rawQuery(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 1) {
                rawQuery.moveToFirst();
                str2 = rawQuery.getString(0);
            }
            rawQuery.close();
        }
        if (str2 == null) {
            v.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            return -1;
        }
        v.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[]{str2});
        v.i("MicroMsg.TrimSnsDb", "create result " + gVar2.dF("", str2));
        return 1;
    }

    public static void BO(String str) {
        List<FileEntry> A = FileOp.A(str, false);
        if (A != null) {
            for (FileEntry fileEntry : A) {
                if (fileEntry.name.startsWith("SnsMicroMsg.dberr")) {
                    v.i("MicroMsg.TrimSnsDb", "find error %s", new Object[]{str + fileEntry.name});
                    FileOp.deleteFile(str + fileEntry.name);
                }
            }
        }
    }
}
