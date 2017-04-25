package com.tencent.mm.ui;

import com.tencent.mm.e.a.pg;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;

public final class v {
    public static void ar(int i, String str) {
        if (a.nhr != null) {
            b pgVar = new pg();
            pgVar.bqD.className = str;
            pgVar.bqD.bqE = i;
            a.nhr.z(pgVar);
        }
    }
}
