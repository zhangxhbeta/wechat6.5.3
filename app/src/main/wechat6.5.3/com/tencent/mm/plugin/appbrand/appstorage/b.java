package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private d dBY;

    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED
    }

    public b(d dVar) {
        super(dVar, a.chq, "AppBrandKVData", null);
        this.dBY = dVar;
    }

    public final Object[] at(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return new Object[]{a.MISSING_PARAMS};
        }
        a aVar = new a();
        aVar.field_key = t(str, str2, "__");
        if (super.b(aVar, new String[0])) {
            return new Object[]{a.NONE, aVar.field_data, aVar.field_dataType};
        }
        return new Object[]{a.NO_SUCH_KEY};
    }

    public final a d(String str, String str2, String str3, String str4) {
        Object obj = null;
        if (be.kS(str) || be.kS(str2)) {
            return a.MISSING_PARAMS;
        }
        String t = t(str, str2, "__");
        int length = (str3 == null ? 0 : str3.length()) + (str2 == null ? 0 : str2.length());
        int mR = length - mR(t);
        if (mQ(str) + mR >= g.nb(str)) {
            obj = 1;
        }
        if (obj != null) {
            return a.QUOTA_REACHED;
        }
        a aVar = new a();
        aVar.field_key = t;
        aVar.field_data = str3;
        aVar.field_dataType = str4;
        aVar.field_size = length;
        if (!super.a(aVar)) {
            return a.UNKNOWN;
        }
        T(str, mR);
        return a.NONE;
    }

    public final a au(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return a.MISSING_PARAMS;
        }
        String t = t(str, str2, "__");
        T(str, -mR(t));
        a aVar = new a();
        aVar.field_key = t;
        super.c(aVar, new String[0]);
        return a.NONE;
    }

    public final void clear(String str) {
        super.dF("AppBrandKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandKVData", "key", str}));
    }

    public final Object[] mP(String str) {
        Cursor query = this.dBY.query("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{(str + "__").replace("_", "\\_") + "%", "\\"}, null, null, null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(query.getString(0).replace(r8, ""));
        }
        query.close();
        int ceil = (int) Math.ceil(((double) mQ(str)) / 1000.0d);
        int ceil2 = (int) Math.ceil(((double) g.nb(str)) / 1000.0d);
        return new Object[]{arrayList, Integer.valueOf(ceil), Integer.valueOf(ceil2)};
    }

    private int mQ(String str) {
        a aVar = new a();
        aVar.field_key = t(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        if (super.b(aVar, new String[0])) {
            return be.getInt(aVar.field_data, 0);
        }
        return 0;
    }

    private int T(String str, int i) {
        int max = Math.max(0, mQ(str) + i);
        a aVar = new a();
        aVar.field_key = t(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        aVar.field_data = String.valueOf(max);
        super.a(aVar);
        return max;
    }

    private int mR(String str) {
        Cursor query = this.dBY.query("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null);
        if (query.moveToFirst()) {
            int i = query.getInt(0);
            query.close();
            return i;
        }
        query.close();
        return 0;
    }

    private static String t(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
