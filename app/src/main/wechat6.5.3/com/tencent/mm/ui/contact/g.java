package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;

public final class g {
    static final List<String> cC(List<String> list) {
        List<String> arrayList = new ArrayList();
        ak.yW();
        Cursor b = c.wK().b(m.crA, (List) list, true, null);
        if (b.moveToFirst()) {
            int i = 0;
            do {
                af abVar = new ab();
                abVar.b(b);
                if (Cd(abVar.field_username)) {
                    arrayList.add(abVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    private static final boolean Cd(String str) {
        for (Object equals : m.crG) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (m.dE(str) || m.eD(str)) {
            return false;
        }
        return true;
    }
}
