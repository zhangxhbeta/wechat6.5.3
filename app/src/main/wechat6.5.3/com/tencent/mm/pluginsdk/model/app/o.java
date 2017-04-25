package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.e.b.p;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import java.util.ArrayList;
import java.util.List;

public final class o extends f<p> {
    public static final String[] cic = new String[]{f.a(n.chq, "AppSort")};
    public d cie;

    public o(d dVar) {
        super(dVar, n.chq, "AppSort", null);
        this.cie = dVar;
        dVar.dF("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        dVar.dF("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    }

    public final List<String> dB(long j) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            return null;
        }
        v.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean a(n nVar) {
        return super.b(nVar);
    }
}
