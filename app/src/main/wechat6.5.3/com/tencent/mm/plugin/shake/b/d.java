package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.e.b.cj;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class d extends cj {
    protected static a chq;
    public int bkU;
    private are iOg;
    public int scene;

    static {
        a aVar = new a();
        aVar.ddU = new Field[20];
        aVar.bXK = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "shakeItemID";
        aVar.nmd.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "shakeItemID";
        aVar.bXK[1] = "username";
        aVar.nmd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "nickname";
        aVar.nmd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "province";
        aVar.nmd.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "city";
        aVar.nmd.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "signature";
        aVar.nmd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "distance";
        aVar.nmd.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "sex";
        aVar.nmd.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "imgstatus";
        aVar.nmd.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "hasHDImg";
        aVar.nmd.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "insertBatch";
        aVar.nmd.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[11] = "reserved1";
        aVar.nmd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "reserved2";
        aVar.nmd.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[13] = "reserved3";
        aVar.nmd.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "reserved4";
        aVar.nmd.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[16] = "lvbuffer";
        aVar.nmd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.bXK[17] = "regionCode";
        aVar.nmd.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.bXK[18] = "snsFlag";
        aVar.nmd.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[19] = "sns_bgurl";
        aVar.nmd.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.bXK[20] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public d() {
        this.bkU = -1;
        this.field_insertBatch = 2;
    }

    public d(aud com_tencent_mm_protocal_c_aud) {
        this.bkU = -1;
        this.field_username = com_tencent_mm_protocal_c_aud.gln;
        this.field_nickname = com_tencent_mm_protocal_c_aud.efy;
        this.field_signature = com_tencent_mm_protocal_c_aud.cHf;
        this.field_distance = com_tencent_mm_protocal_c_aud.mFt;
        this.field_reserved4 = String.valueOf(com_tencent_mm_protocal_c_aud.mRK);
        this.field_sex = com_tencent_mm_protocal_c_aud.cHc;
        this.field_imgstatus = com_tencent_mm_protocal_c_aud.mbX;
        this.field_hasHDImg = com_tencent_mm_protocal_c_aud.mRI;
        this.field_reserved1 = com_tencent_mm_protocal_c_aud.mFu;
        this.field_reserved3 = com_tencent_mm_protocal_c_aud.mFv;
        this.field_insertBatch = 2;
        if (com_tencent_mm_protocal_c_aud.mFA != null) {
            this.field_snsFlag = com_tencent_mm_protocal_c_aud.mFA.cHn;
            this.field_sns_bgurl = com_tencent_mm_protocal_c_aud.mFA.cHo;
        }
        this.iOg = com_tencent_mm_protocal_c_aud.mRJ;
        this.field_province = com_tencent_mm_protocal_c_aud.cHd;
        this.field_city = com_tencent_mm_protocal_c_aud.cHe;
        this.field_regionCode = RegionCodeDecoder.Y(com_tencent_mm_protocal_c_aud.cHl, this.field_province, this.field_city);
    }

    public final String getProvince() {
        if (!be.kS(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    this.field_province = RegionCodeDecoder.bxc().No(split[0]);
                } else {
                    this.field_province = RegionCodeDecoder.bxc().dP(split[0], split[1]);
                }
            }
        }
        return this.field_province;
    }

    public final String getCity() {
        if (!be.kS(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    this.field_city = RegionCodeDecoder.bxc().Z(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    this.field_city = RegionCodeDecoder.bxc().dP(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        return this.field_city;
    }

    private int aNC() {
        try {
            return Integer.valueOf(this.field_reserved4).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.bkU & 128) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.bkU & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.bkU & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(aNC()));
        }
        if ((this.bkU & 32768) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if ((this.bkU & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.bkU & 131072) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.bkU & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.bkU & 524288) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        return contentValues;
    }
}
