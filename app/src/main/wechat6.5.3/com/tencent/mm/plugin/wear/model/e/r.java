package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

public final class r {
    private static AtomicInteger lcp = new AtomicInteger();

    public static void a(int i, byte[] bArr, boolean z) {
        if (z) {
            bArr = a.bhH().laR.aP(bArr);
        }
        int incrementAndGet = lcp.incrementAndGet();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(incrementAndGet);
            dataOutputStream.writeInt(i);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
            a.bhH().laR.aN(byteArrayOutputStream.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.Wear.WearPushServerLogic", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(0), Integer.valueOf(incrementAndGet), Integer.valueOf(i)});
        }
    }
}
