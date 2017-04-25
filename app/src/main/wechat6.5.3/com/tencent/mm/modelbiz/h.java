package com.tencent.mm.modelbiz;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends f<f> {
    public static final String[] cic = new String[]{f.a(f.chq, "BizKF")};
    public d cie;

    public final /* synthetic */ boolean a(c cVar) {
        return b((f) cVar);
    }

    public h(d dVar) {
        super(dVar, f.chq, "BizKF", null);
        this.cie = dVar;
        dVar.dF("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        dVar.dF("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    }

    public final f hG(String str) {
        f fVar = null;
        if (str != null && str.length() > 0) {
            Cursor query = this.cie.query("BizKF", null, "openId=?", new String[]{str}, null, null, null);
            if (query.getCount() <= 0) {
                v.w("MicroMsg.BizKFStorage", "get null with openId:" + str);
                query.close();
            } else {
                if (query.moveToFirst()) {
                    fVar = new f();
                    fVar.b(query);
                }
                query.close();
            }
        }
        return fVar;
    }

    public static boolean a(f fVar) {
        if (fVar == null || System.currentTimeMillis() - fVar.field_updateTime < 86400000) {
            return false;
        }
        return true;
    }

    private boolean b(f fVar) {
        if (fVar == null || be.kS(fVar.field_openId) || be.kS(fVar.field_brandUsername)) {
            v.w("MicroMsg.BizKFStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.cie.replace("BizKF", f.chq.nmc, fVar.py()) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", fVar.field_openId, fVar.field_brandUsername, Boolean.valueOf(z));
        return z;
    }

    public final f hH(String str) {
        f fVar = null;
        if (!be.kS(str)) {
            Cursor query = this.cie.query("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null);
            if (query.getCount() <= 0) {
                v.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + str);
                query.close();
            } else {
                if (query.moveToFirst()) {
                    fVar = new f();
                    fVar.b(query);
                }
                query.close();
            }
        }
        return fVar;
    }

    public final int e(LinkedList<f> linkedList) {
        if (linkedList.size() <= 0) {
            v.e("MicroMsg.BizKFStorage", "null kfs");
            return 0;
        }
        long er;
        if (this.cie instanceof g) {
            er = ((g) this.cie).er(Thread.currentThread().getId());
        } else {
            er = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            f fVar = (f) it.next();
            if (fVar == null || !b(fVar)) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        if (this.cie instanceof g) {
            ak.yW();
            com.tencent.mm.model.c.wE().es(er);
        }
        v.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i));
        return i;
    }
}
