package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "ABTestItem")};
    private com.tencent.mm.sdk.h.d cie;

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "ABTestItem", null);
        this.cie = dVar;
    }

    public final c Ls(String str) {
        c cVar = new c();
        cVar.field_layerId = str;
        boolean b = super.b(cVar, new String[0]);
        v.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(b));
        return cVar;
    }

    public final Map<String, c> Lt(String str) {
        Cursor cursor;
        if (be.kS(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return new HashMap(0);
        }
        Map<String, c> hashMap = new HashMap();
        do {
            c cVar = new c();
            cVar.b(cursor);
            hashMap.put(cVar.field_layerId, cVar);
        } while (cursor.moveToNext());
        cursor.close();
        return hashMap;
    }

    public final void bQ(List<c> list) {
        Object obj = null;
        c cVar = new c();
        cVar.field_prioritylevel = 1;
        a(cVar, false, "prioritylevel");
        for (c cVar2 : list) {
            boolean z;
            Object obj2;
            if (cVar2 == null || be.kS(cVar2.field_layerId)) {
                v.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.b(cVar3, new String[0])) {
                    v.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false)));
                    z = r2;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    v.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    v.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(super.b(cVar2, false, new String[0])), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            Lf("event_updated");
        }
    }

    public final String buY() {
        Cursor Kp = Kp();
        if (Kp == null) {
            return "null cursor!!";
        }
        if (!Kp.moveToFirst()) {
            return "cursor empty!!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        c cVar = new c();
        do {
            stringBuilder.append("============\n");
            cVar.b(Kp);
            stringBuilder.append("layerId = ").append(cVar.field_layerId).append("\n");
            stringBuilder.append("sequence = ").append(cVar.field_sequence).append("\n");
            stringBuilder.append("priorityLV = ").append(cVar.field_prioritylevel).append("\n");
            stringBuilder.append("expId = ").append(cVar.field_expId).append("\n");
        } while (Kp.moveToNext());
        Kp.close();
        return stringBuilder.toString();
    }

    public final LinkedList<pb> buW() {
        LinkedList<pb> linkedList = new LinkedList();
        Cursor Kp = Kp();
        if (Kp != null && Kp.moveToFirst()) {
            c cVar = new c();
            do {
                cVar.b(Kp);
                pb pbVar = new pb();
                try {
                    pbVar.moX = be.getInt(cVar.field_expId, 0);
                } catch (Exception e) {
                    v.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                pbVar.priority = cVar.field_prioritylevel;
                linkedList.add(pbVar);
            } while (Kp.moveToNext());
            Kp.close();
        }
        return linkedList;
    }
}
