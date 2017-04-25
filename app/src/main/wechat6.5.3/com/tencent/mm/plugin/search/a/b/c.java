package com.tencent.mm.plugin.search.a.b;

import android.database.Cursor;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.b;
import java.util.ArrayList;
import java.util.List;

public final class c extends b {
    protected final void HY() {
        this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_message ON %s(aux_index, timestamp);", new Object[]{HZ(), HZ()}));
    }

    protected final String getTableName() {
        return "Message";
    }

    public final String getName() {
        return "FTSMessageStorage";
    }

    public final int getType() {
        return 4;
    }

    public final int getPriority() {
        return 4;
    }

    public final void a(int[] iArr, long j, long j2) {
        List arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + FTSUtils.i(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{HZ()});
        Cursor rawQuery = this.cUY.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        N(arrayList);
    }
}
