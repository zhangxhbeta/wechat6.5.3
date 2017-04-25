package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.mm.e.b.n;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public class f extends n {
    protected static a chq;
    public static String lAm = "wxce6f23b478a3a2a2";
    public static String lAn = "wx7302cee7c7d6d7d6";
    public static String lAo = "wx6fa7e3bab7e15415";
    public static String lAp = "wx3cc22b542de028d4";

    static {
        a aVar = new a();
        aVar.ddU = new Field[26];
        aVar.bXK = new String[27];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appId";
        aVar.nmd.put("appId", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "appId";
        aVar.bXK[1] = "appName";
        aVar.nmd.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "appDiscription";
        aVar.nmd.put("appDiscription", "TEXT");
        stringBuilder.append(" appDiscription TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "appIconUrl";
        aVar.nmd.put("appIconUrl", "TEXT");
        stringBuilder.append(" appIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "appStoreUrl";
        aVar.nmd.put("appStoreUrl", "TEXT");
        stringBuilder.append(" appStoreUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "appVersion";
        aVar.nmd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "appWatermarkUrl";
        aVar.nmd.put("appWatermarkUrl", "TEXT");
        stringBuilder.append(" appWatermarkUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "packageName";
        aVar.nmd.put("packageName", "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "status";
        aVar.nmd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "signature";
        aVar.nmd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "modifyTime";
        aVar.nmd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "appName_en";
        aVar.nmd.put("appName_en", "TEXT");
        stringBuilder.append(" appName_en TEXT");
        stringBuilder.append(", ");
        aVar.bXK[12] = "appName_tw";
        aVar.nmd.put("appName_tw", "TEXT");
        stringBuilder.append(" appName_tw TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "appName_hk";
        aVar.nmd.put("appName_hk", "TEXT");
        stringBuilder.append(" appName_hk TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "appDiscription_en";
        aVar.nmd.put("appDiscription_en", "TEXT");
        stringBuilder.append(" appDiscription_en TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "appDiscription_tw";
        aVar.nmd.put("appDiscription_tw", "TEXT");
        stringBuilder.append(" appDiscription_tw TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "appType";
        aVar.nmd.put("appType", "TEXT");
        stringBuilder.append(" appType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "openId";
        aVar.nmd.put("openId", "TEXT");
        stringBuilder.append(" openId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[18] = "authFlag";
        aVar.nmd.put("authFlag", "INTEGER");
        stringBuilder.append(" authFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[19] = "appInfoFlag";
        aVar.nmd.put("appInfoFlag", "INTEGER default '-1' ");
        stringBuilder.append(" appInfoFlag INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[20] = "lvbuff";
        aVar.nmd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.bXK[21] = "serviceAppType";
        aVar.nmd.put("serviceAppType", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[22] = "serviceAppInfoFlag";
        aVar.nmd.put("serviceAppInfoFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[23] = "serviceShowFlag";
        aVar.nmd.put("serviceShowFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceShowFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[24] = "appSupportContentType";
        aVar.nmd.put("appSupportContentType", "LONG default '0' ");
        stringBuilder.append(" appSupportContentType LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[25] = "svrAppSupportContentType";
        aVar.nmd.put("svrAppSupportContentType", "LONG default '0' ");
        stringBuilder.append(" svrAppSupportContentType LONG default '0' ");
        aVar.bXK[26] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public f() {
        this.field_appId = SQLiteDatabase.KeyEmpty;
        this.field_appName = SQLiteDatabase.KeyEmpty;
        this.field_appDiscription = SQLiteDatabase.KeyEmpty;
        this.field_appIconUrl = SQLiteDatabase.KeyEmpty;
        this.field_appStoreUrl = SQLiteDatabase.KeyEmpty;
        this.field_appVersion = 0;
        this.field_appWatermarkUrl = SQLiteDatabase.KeyEmpty;
        this.field_packageName = SQLiteDatabase.KeyEmpty;
        this.field_status = 4;
        this.field_signature = SQLiteDatabase.KeyEmpty;
        this.field_modifyTime = 0;
        this.field_appName_en = SQLiteDatabase.KeyEmpty;
        this.field_appName_tw = SQLiteDatabase.KeyEmpty;
        this.field_appName_hk = SQLiteDatabase.KeyEmpty;
        this.field_appDiscription_en = SQLiteDatabase.KeyEmpty;
        this.field_appDiscription_tw = SQLiteDatabase.KeyEmpty;
        this.field_appInfoFlag = 0;
        this.field_appType = SQLiteDatabase.KeyEmpty;
        this.field_openId = SQLiteDatabase.KeyEmpty;
        this.field_authFlag = 0;
        this.field_appInfoFlag = 0;
        bD(SQLiteDatabase.KeyEmpty);
        bC(SQLiteDatabase.KeyEmpty);
        bE(SQLiteDatabase.KeyEmpty);
        bI(SQLiteDatabase.KeyEmpty);
        bJ(SQLiteDatabase.KeyEmpty);
        bK(SQLiteDatabase.KeyEmpty);
    }

    public final boolean bnk() {
        if (be.kS(this.field_appType)) {
            return false;
        }
        String[] split = this.field_appType.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String equals : split) {
            if (equals.equals("1")) {
                return true;
            }
        }
        return false;
    }

    public final boolean bnl() {
        if (this.field_serviceAppType == 0) {
            return false;
        }
        return true;
    }

    public final boolean bnm() {
        if ((this.field_serviceAppInfoFlag & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean bnn() {
        if (lAn.equals(this.field_appId)) {
            return true;
        }
        return false;
    }

    public final ContentValues py() {
        if (!be.kS(this.field_appType) && (this.field_appType.startsWith("1") || this.field_appType.startsWith("6"))) {
            this.field_appType = "," + this.field_appType;
        }
        return super.py();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return ((f) obj).field_appId.equals(this.field_appId);
        }
        return false;
    }

    public int hashCode() {
        if (be.kS(this.field_appId)) {
            return super.hashCode();
        }
        return this.field_appId.hashCode();
    }
}
