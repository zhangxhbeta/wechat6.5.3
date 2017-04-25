package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class n extends f<m> implements a {
    public static final String[] cic = new String[]{f.a(m.chq, "EmotionRewardInfo")};
    public d cie;

    public n(d dVar) {
        super(dVar, m.chq, "EmotionRewardInfo", null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final vv NL(String str) {
        vv vvVar = null;
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content"};
            String[] strArr2 = new String[]{str};
            Cursor query = this.cie.query("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null);
            if (query != null && query.moveToFirst()) {
                try {
                    vv vvVar2 = new vv();
                    vvVar2.az(query.getBlob(0));
                    vvVar = vvVar2;
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[]{be.e(e)});
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return vvVar;
    }
}
