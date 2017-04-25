package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "ABTestInfo")};
    private d cie;

    public b(d dVar) {
        super(dVar, a.chq, "ABTestInfo", null);
        this.cie = dVar;
    }

    public final void bQ(List<a> list) {
        Object obj = null;
        c aVar = new a();
        aVar.field_prioritylevel = 1;
        a(aVar, false, "prioritylevel");
        for (c aVar2 : list) {
            boolean z;
            Object obj2;
            if (aVar2 == null || be.kS(aVar2.field_abtestkey)) {
                v.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.b(aVar3, new String[0])) {
                    v.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false)));
                    z = r2;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    v.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
                    z = false;
                } else {
                    v.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Boolean.valueOf(super.b(aVar2, false, new String[0])), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
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

    public final LinkedList<pb> buW() {
        LinkedList<pb> linkedList = new LinkedList();
        Cursor Kp = Kp();
        if (Kp != null) {
            if (Kp.moveToFirst()) {
                a aVar = new a();
                do {
                    aVar.b(Kp);
                    pb pbVar = new pb();
                    try {
                        pbVar.moX = be.getInt(aVar.field_expId, 0);
                    } catch (Exception e) {
                        v.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", aVar.field_expId);
                    }
                    pbVar.priority = aVar.field_prioritylevel;
                    linkedList.add(pbVar);
                } while (Kp.moveToNext());
                Kp.close();
            } else {
                Kp.close();
            }
        }
        return linkedList;
    }

    public final a Lp(String str) {
        c aVar = new a();
        aVar.field_abtestkey = str;
        boolean b = super.b(aVar, new String[0]);
        v.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(b));
        return aVar;
    }

    public final int Lq(String str) {
        return be.getInt(Lp(str).field_value, 0);
    }

    public final String Lr(String str) {
        a Lp = Lp(str);
        return Lp.field_expId == null ? SQLiteDatabase.KeyEmpty : Lp.field_expId;
    }
}
