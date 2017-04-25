package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends f<d> {
    public static final String[] cic = new String[]{f.a(d.chq, "shakeitem1")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((d) cVar, false);
    }

    public e(d dVar) {
        super(dVar, d.chq, "shakeitem1", null);
        this.cie = dVar;
        v.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        dVar.dF("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        dVar.dF("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    }

    public final Cursor aND() {
        return rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[]{"4"});
    }

    public final d aNE() {
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.b(rawQuery);
        }
        rawQuery.close();
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == null) {
            return false;
        }
        if (!(z || be.kS(dVar.field_username))) {
            zp(dVar.field_username);
        }
        dVar.bkU = -1;
        return super.b(dVar);
    }

    public final int pl(int i) {
        int delete = this.cie.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        Ls();
        v.i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        return delete;
    }

    public final int zp(String str) {
        int delete = this.cie.delete("shakeitem1", "(username=?)", new String[]{str});
        if (delete > 0) {
            Ls();
        }
        v.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        return delete;
    }

    public final boolean pm(int i) {
        boolean dF;
        if (i == 0) {
            dF = this.cie.dF("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            dF = this.cie.dF("shakeitem1", "delete from shakeitem1 where type = " + i);
        }
        Ls();
        return dF;
    }

    public final boolean aNF() {
        boolean dF = this.cie.dF("shakeitem1", "delete from shakeitem1");
        Ls();
        return dF;
    }

    public final void aNG() {
        v.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.bkU = 1024;
        if (-1 != this.cie.update("shakeitem1", dVar.py(), "insertBatch!=?", new String[]{"0"})) {
            Ls();
        }
    }
}
