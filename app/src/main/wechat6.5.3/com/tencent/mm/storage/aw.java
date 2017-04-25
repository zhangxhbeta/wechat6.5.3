package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class aw extends f<av> {
    public static final String[] cic = new String[]{f.a(av.chq, "OpenMsgListener")};
    public d cie;

    public final /* synthetic */ boolean a(c cVar) {
        av avVar = (av) cVar;
        if (avVar == null || be.kS(avVar.field_appId)) {
            v.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            return false;
        }
        v.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", avVar.field_appId, Boolean.valueOf(this.cie.replace("OpenMsgListener", av.chq.nmc, avVar.py()) > 0));
        return this.cie.replace("OpenMsgListener", av.chq.nmc, avVar.py()) > 0;
    }

    public aw(d dVar) {
        super(dVar, av.chq, "OpenMsgListener", null);
        this.cie = dVar;
        dVar.dF("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        dVar.dF("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    }

    public final av Nl(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor query = this.cie.query("OpenMsgListener", null, "appId=?", new String[]{be.lZ(str)}, null, null, null);
        if (query.getCount() <= 0) {
            v.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        av avVar = new av();
        avVar.b(query);
        query.close();
        return avVar;
    }

    public final Cursor bxb() {
        return rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
    }
}
