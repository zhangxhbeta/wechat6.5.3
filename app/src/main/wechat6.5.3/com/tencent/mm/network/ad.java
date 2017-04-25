package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class ad {
    private static ad dmN = null;
    private HashMap<Integer, a> dmO = new HashMap();

    public interface a {
        int MF();
    }

    public static synchronized ad ME() {
        ad adVar;
        synchronized (ad.class) {
            if (dmN == null) {
                dmN = new ad();
            }
            adVar = dmN;
        }
        return adVar;
    }

    public final synchronized int h(int i, byte[] bArr) {
        int i2;
        a aVar = (a) this.dmO.get(Integer.valueOf(i));
        String str = "MicroMsg.PostPushEventHandler";
        String str2 = "postEvent event:%s cb:%s data:%s [%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = aVar;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[3] = new af();
        v.i(str, str2, objArr);
        if (aVar == null) {
            String str3 = "MicroMsg.PostPushEventHandler";
            str = "postEvent cb == null  event:%s cb:%s data:%s [%s]";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = aVar;
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[3] = new af();
            v.e(str3, str, objArr2);
            i2 = -3;
        } else {
            i2 = aVar.MF();
        }
        return i2;
    }
}
