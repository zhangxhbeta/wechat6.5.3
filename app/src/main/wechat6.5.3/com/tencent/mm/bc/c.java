package com.tencent.mm.bc;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.bc.f.a;
import com.tencent.mm.bc.f.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public final class c {
    public static HashMap<String, Integer> ndZ;

    public static void brO() {
        a aVar = new a();
        aVar.JJ(aa.getContext().getSharedPreferences(aa.getProcessName() + "_recovery_statics", 0).getString("KeyGeneralObj", SQLiteDatabase.KeyEmpty));
        ArrayList arrayList = new ArrayList();
        int intValue = ((Integer) ndZ.get(aa.getProcessName())).intValue();
        if (aVar.emv > 0) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 0);
            iDKey.SetValue(aVar.emv);
            arrayList.add(iDKey);
        }
        if (aVar.nee > 0) {
            iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 1);
            iDKey.SetValue(aVar.nee);
            arrayList.add(iDKey);
        }
        if (aVar.nef > 0) {
            iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 2);
            iDKey.SetValue(aVar.nef);
            arrayList.add(iDKey);
        }
        if (aVar.neg > 0) {
            iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 3);
            iDKey.SetValue(aVar.neg);
            arrayList.add(iDKey);
        }
        if (aVar.neh > 0) {
            iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 4);
            iDKey.SetValue(aVar.neh);
            arrayList.add(iDKey);
        }
        if (aVar.nei > 0) {
            iDKey = new IDKey();
            iDKey.SetID(424);
            iDKey.SetKey(intValue + 5);
            iDKey.SetValue(aVar.nei);
            arrayList.add(iDKey);
        }
        if (arrayList.size() > 0) {
            g gVar = g.iuh;
            g.d(arrayList, true);
        }
        v.i("MicroMsg.Recovery.RecoveryReportLogic", "report recovery generalObj %s [%s]", aa.getProcessName(), aVar.toString());
        b bVar = new b();
        bVar.JJ(aa.getContext().getSharedPreferences(aa.getProcessName() + "_recovery_statics", 0).getString("KeyStatusObj", SQLiteDatabase.KeyEmpty));
        arrayList = new ArrayList();
        intValue = ((Integer) ndZ.get(aa.getProcessName())).intValue();
        if (bVar.nej > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 0);
            iDKey.SetValue(bVar.nej);
            arrayList.add(iDKey);
        }
        if (bVar.nek > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 1);
            iDKey.SetValue(bVar.nek);
            arrayList.add(iDKey);
        }
        if (bVar.nel > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 2);
            iDKey.SetValue(bVar.nel);
            arrayList.add(iDKey);
        }
        if (bVar.nem > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 3);
            iDKey.SetValue(bVar.nem);
            arrayList.add(iDKey);
        }
        if (bVar.nen > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 4);
            iDKey.SetValue(bVar.nen);
            arrayList.add(iDKey);
        }
        if (bVar.neo > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 5);
            iDKey.SetValue(bVar.neo);
            arrayList.add(iDKey);
        }
        if (bVar.nep > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 6);
            iDKey.SetValue(bVar.nep);
            arrayList.add(iDKey);
        }
        if (bVar.neq > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 7);
            iDKey.SetValue(bVar.neq);
            arrayList.add(iDKey);
        }
        if (bVar.ner > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 8);
            iDKey.SetValue(bVar.ner);
            arrayList.add(iDKey);
        }
        if (bVar.nes > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 9);
            iDKey.SetValue(bVar.nes);
            arrayList.add(iDKey);
        }
        if (bVar.neu > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 10);
            iDKey.SetValue(bVar.neu);
            arrayList.add(iDKey);
        }
        if (bVar.nev > 0) {
            iDKey = new IDKey();
            iDKey.SetID(442);
            iDKey.SetKey(intValue + 11);
            iDKey.SetValue(bVar.nev);
            arrayList.add(iDKey);
        }
        if (arrayList.size() > 0) {
            gVar = g.iuh;
            g.d(arrayList, true);
        }
        v.i("MicroMsg.Recovery.RecoveryReportLogic", "report recovery statusObj %s [%s]", aa.getProcessName(), bVar.toString());
        Editor edit = aa.getContext().getSharedPreferences(aa.getProcessName() + "_recovery_statics", 0).edit();
        edit.remove("KeyGeneralObj");
        edit.remove("KeyStatusObj");
        edit.commit();
    }

    static {
        HashMap hashMap = new HashMap();
        ndZ = hashMap;
        hashMap.put(aa.getPackageName(), Integer.valueOf(0));
        ndZ.put(aa.getPackageName() + ":push", Integer.valueOf(20));
        ndZ.put(aa.getPackageName() + ":tools", Integer.valueOf(40));
        ndZ.put(aa.getPackageName() + ":exdevice", Integer.valueOf(60));
        ndZ.put(aa.getPackageName() + ":sandbox", Integer.valueOf(80));
    }
}
