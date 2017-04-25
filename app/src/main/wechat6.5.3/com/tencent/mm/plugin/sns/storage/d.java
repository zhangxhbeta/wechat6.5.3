package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends f<c> {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] cic = new String[]{f.a(c.chq, "adsnsinfo")};
    private static final String jBL = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    public com.tencent.mm.sdk.h.d cie;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (c) cVar);
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "adsnsinfo", btd);
        this.cie = dVar;
    }

    public final c cV(long j) {
        c cVar = new c();
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        }
        rawQuery.close();
        return null;
    }

    public final c qB(int i) {
        c cVar = new c();
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=" + i, null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        }
        rawQuery.close();
        return null;
    }

    public final boolean a(long j, c cVar) {
        if (cW(j)) {
            return b(j, cVar);
        }
        int i;
        v.d("MicroMsg.AdSnsInfoStorage", "added PcId " + j);
        v.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (cVar == null) {
            i = -1;
        } else {
            i = (int) this.cie.insert("AdSnsInfo", "", cVar.py());
            v.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result" + i);
        }
        return i != -1;
    }

    public final boolean b(long j, c cVar) {
        ContentValues py = cVar.py();
        py.remove("rowid");
        if (this.cie.update("AdSnsInfo", py, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean cW(long j) {
        Cursor rawQuery = this.cie.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final boolean delete(long j) {
        int delete = this.cie.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        v.i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
