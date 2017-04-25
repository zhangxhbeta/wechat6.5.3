package com.tencent.mm.plugin.search.a.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteStatement;
import java.util.List;

public final class b extends com.tencent.mm.modelsearch.b {
    private SQLiteStatement iGK;

    protected final void HY() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
        stringBuilder.append(com.tencent.mm.plugin.search.a.b.chq.nme);
        stringBuilder.append(");");
        this.cUY.execSQL(stringBuilder.toString());
        this.iGK = this.cUY.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
    }

    public final boolean bi(List<com.tencent.mm.plugin.search.a.b> list) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        this.cUY.execSQL("Delete from Feature");
        for (com.tencent.mm.plugin.search.a.b bVar : list) {
            try {
                this.iGK.bindLong(1, (long) bVar.field_featureId);
                this.iGK.bindString(2, bVar.field_title);
                this.iGK.bindString(3, bVar.field_titlePY);
                this.iGK.bindString(4, bVar.field_titleShortPY);
                this.iGK.bindString(5, bVar.field_tag);
                this.iGK.bindLong(6, (long) bVar.field_actionType);
                this.iGK.bindString(7, bVar.field_url);
                this.iGK.bindString(8, bVar.field_helpUrl);
                this.iGK.bindString(9, bVar.field_updateUrl);
                this.iGK.bindString(10, bVar.field_androidUrl);
                this.iGK.bindString(11, bVar.field_iconPath);
                long executeInsert = this.iGK.executeInsert();
                v.d("MicroMsg.FTS.FTSFeatureStorage", "insertFeatureItem rawId=%d", new Object[]{Long.valueOf(executeInsert)});
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.cUY.commit();
        }
        return true;
    }

    protected final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTSFeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    protected final boolean HX() {
        super.HX();
        this.iGK.close();
        return true;
    }
}
