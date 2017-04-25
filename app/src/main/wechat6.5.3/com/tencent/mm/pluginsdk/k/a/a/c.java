package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.be;

final class c extends l {
    private final boolean aYu;
    final String aZy;
    final long fileSize;
    final long lCW;
    volatile byte[] lDt;
    volatile boolean ldv;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.GZ(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        this.aZy = str2;
        this.lCW = j;
        this.aYu = z;
        this.fileSize = j2;
    }

    public final boolean bnS() {
        return true;
    }

    public final String OZ() {
        return i.GZ(this.lCO);
    }

    public final String Pa() {
        return "CheckResUpdate";
    }

    static c b(r rVar) {
        return new c(rVar.field_urlKey, be.getInt(rVar.field_fileVersion, 0), rVar.field_md5, be.ma(rVar.field_groupId2).equals("NewXml"), rVar.field_reportId, rVar.field_url, rVar.field_maxRetryTimes, rVar.field_fileSize, rVar.field_networkType, rVar.field_priority);
    }
}
