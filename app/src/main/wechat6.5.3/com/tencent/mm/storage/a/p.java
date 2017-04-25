package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class p extends f<o> implements a {
    public static final String[] cic = new String[]{f.a(o.chq, "EmotionRewardTipInfo")};
    private d cie;

    public p(d dVar) {
        this(dVar, o.chq, "EmotionRewardTipInfo");
    }

    private p(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final o bxU() {
        Cursor rawQuery;
        Throwable e;
        try {
            rawQuery = this.cie.rawQuery("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0]);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        o oVar = new o();
                        oVar.b(rawQuery);
                        if (rawQuery == null) {
                            return oVar;
                        }
                        rawQuery.close();
                        return oVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{be.e(e)});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw e;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{be.e(e)});
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw e;
        }
        return null;
    }

    public final boolean bW(String str, int i) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            return false;
        }
        v.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[]{Boolean.valueOf(this.cie.dF("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'"))});
        return this.cie.dF("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(o oVar) {
        if (oVar == null) {
            v.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            return false;
        }
        long replace = this.cie.replace("EmotionRewardTipInfo", "prodcutID", oVar.py());
        if (replace > 0) {
            v.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            v.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            return true;
        }
        return false;
    }
}
