package com.tencent.mm.plugin.game.c;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public LinkedList<String> ghk = new LinkedList();
    public LinkedList<f> ghl = new LinkedList();

    public final void init(Context context) {
        if (this.ghl == null) {
            this.ghl = new LinkedList();
        } else {
            this.ghl.clear();
        }
        if (this.ghk == null) {
            this.ghk = new LinkedList();
        } else {
            this.ghk.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bR(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        ard();
        long currentTimeMillis3 = System.currentTimeMillis();
        v.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis)});
    }

    private void bR(Context context) {
        Cursor bnr = am.bnB().bnr();
        LinkedList linkedList = new LinkedList();
        if (bnr == null) {
            v.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            return;
        }
        if (bnr.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.b(bnr);
                if (g.a(context, fVar) && !this.ghk.contains(fVar.field_appId)) {
                    v.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[]{fVar.field_appName, fVar.field_appId});
                    this.ghl.add(fVar);
                    this.ghk.add(fVar.field_appId);
                } else if (e.a(fVar) && !this.ghk.contains(fVar.field_appId)) {
                    linkedList.add(fVar);
                    v.i("MicroMsg.GameAppCacheService", "get download success task by yyb, appname:[%s]", new Object[]{fVar.field_appName});
                }
            } while (bnr.moveToNext());
        }
        bnr.close();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            this.ghl.add(fVar2);
            this.ghk.add(fVar2.field_appId);
        }
    }

    private void ard() {
        List<String> arrayList = new ArrayList();
        Cursor rawQuery = ak.yW().wL().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                al alVar = new al();
                alVar.b(rawQuery);
                if (!be.kS(alVar.field_appId) && alVar.field_appId.startsWith("wx") && alVar.field_status == 3 && !alVar.field_autoDownload && e.aR(alVar.field_filePath) && !arrayList.contains(alVar.field_appId)) {
                    arrayList.add(alVar.field_appId);
                }
            }
            rawQuery.close();
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (!(be.kS(str) || this.ghk.contains(str))) {
                    f aC = g.aC(str, false);
                    if (!(aC == null || this.ghl.contains(aC))) {
                        this.ghl.add(aC);
                        this.ghk.add(str);
                    }
                }
            }
        }
    }
}
