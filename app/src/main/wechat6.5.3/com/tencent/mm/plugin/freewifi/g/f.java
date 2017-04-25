package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f extends com.tencent.mm.sdk.h.f<e> {
    public static final String[] cic = new String[]{com.tencent.mm.sdk.h.f.a(e.chq, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> gaM = new LinkedHashMap<String, Class>() {
        {
            put("id", String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
        }
    };

    public f(d dVar) {
        super(dVar, e.chq, "FreeWifiLog", null);
    }

    public final LinkedList<qv> apM() {
        Cursor rawQuery = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        LinkedList<qv> linkedList = new LinkedList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            qv qvVar = new qv();
            qvVar.id = rawQuery.getString(0);
            qvVar.fZE = rawQuery.getInt(1);
            qvVar.muG = rawQuery.getString(2);
            qvVar.muH = rawQuery.getLong(3);
            linkedList.add(qvVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, String str2, long j) {
        v.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)});
        if (m.ty(str)) {
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            e eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b(eVar);
                v.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + b);
                return b;
            }
            b = a(eVar, new String[0]);
            v.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + b);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e;
            b = m.f(b);
            v.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }
}
