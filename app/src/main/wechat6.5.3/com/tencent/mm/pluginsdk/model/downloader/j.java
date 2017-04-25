package com.tencent.mm.pluginsdk.model.downloader;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

final class j extends i {
    public j(a aVar) {
        super(aVar);
    }

    public final long a(e eVar) {
        if (be.kS(eVar.lCg)) {
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(eVar.lCg));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            aa.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            v.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            return -1;
        }
    }

    public final int dm(long j) {
        return 1;
    }

    public final f dn(long j) {
        f fVar = new f();
        fVar.id = j;
        fVar.status = -1;
        return fVar;
    }

    public final boolean do(long j) {
        return false;
    }

    public final boolean dp(long j) {
        return false;
    }
}
