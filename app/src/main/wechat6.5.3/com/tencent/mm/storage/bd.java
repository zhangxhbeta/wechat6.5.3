package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class bd extends f<bc> {
    public static final String[] cic = new String[]{f.a(bc.chq, "UserOpenIdInApp")};
    public d cie;

    public bd(d dVar) {
        super(dVar, bc.chq, "UserOpenIdInApp", null);
        this.cie = dVar;
        dVar.dF("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        dVar.dF("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    }

    public final bc Ny(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor query = this.cie.query("UserOpenIdInApp", null, "openId=?", new String[]{be.lZ(str)}, null, null, null);
        if (query.getCount() <= 0) {
            v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        bc bcVar = new bc();
        bcVar.b(query);
        query.close();
        return bcVar;
    }

    public final boolean a(bc bcVar) {
        if (bcVar == null || be.kS(bcVar.field_appId) || be.kS(bcVar.field_openId) || be.kS(bcVar.field_username)) {
            v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.cie.replace("UserOpenIdInApp", bc.chq.nmc, bcVar.py()) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", bcVar.field_appId, bcVar.field_username, Boolean.valueOf(z));
        return z;
    }
}
