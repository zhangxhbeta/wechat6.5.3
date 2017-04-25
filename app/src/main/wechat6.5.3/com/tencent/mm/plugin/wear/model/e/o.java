package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.e.a.qy;
import com.tencent.mm.sdk.c.a;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11027:
                rJ(1);
                break;
            case 11028:
                rJ(2);
                break;
        }
        return null;
    }

    private static void rJ(int i) {
        qy qyVar = new qy();
        qyVar.bsD.aYt = i;
        a.nhr.z(qyVar);
    }
}
