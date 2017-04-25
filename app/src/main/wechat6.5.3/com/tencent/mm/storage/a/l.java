package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class l extends f<k> implements a {
    public static final String[] cic = new String[]{f.a(k.chq, "EmotionDetailInfo")};
    public d cie;

    public l(d dVar) {
        super(dVar, k.chq, "EmotionDetailInfo", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final k NK(String str) {
        k kVar = null;
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content", "lan"};
            String[] strArr2 = new String[]{str};
            Cursor query = this.cie.query("EmotionDetailInfo", strArr, "productID=?", strArr2, null, null, null);
            if (query != null && query.moveToFirst()) {
                kVar = new k();
                kVar.field_content = query.getBlob(0);
                kVar.field_lan = query.getString(1);
                kVar.field_productID = str;
            }
            if (query != null) {
                query.close();
            }
        }
        return kVar;
    }
}
