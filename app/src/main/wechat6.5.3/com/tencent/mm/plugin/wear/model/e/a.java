package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class a {
    public abstract List<Integer> bhU();

    protected abstract byte[] l(int i, byte[] bArr);

    public final void b(int i, int i2, int i3, byte[] bArr) {
        if (sA(i3) && bArr != null) {
            bArr = com.tencent.mm.plugin.wear.model.a.bhH().laR.aO(bArr);
            if (bArr == null) {
                v.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] l = l(i3, bArr);
        if (sC(i3)) {
            if (sz(i3)) {
                l = com.tencent.mm.plugin.wear.model.a.bhH().laR.aP(l);
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                if (l == null || l.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(l.length);
                    dataOutputStream.write(l);
                }
                l = byteArrayOutputStream.toByteArray();
                v.i("MicroMsg.Wear.BaseHttpServer", "send data findId=%d length=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(l.length)});
                if (sB(i3)) {
                    e.a(new Runnable(this) {
                        final /* synthetic */ a lbY;

                        public final void run() {
                            com.tencent.mm.plugin.wear.model.a.bhH().laR.aN(l);
                        }
                    }, "WearSendResponseTask");
                } else {
                    com.tencent.mm.plugin.wear.model.a.bhH().laR.aN(l);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    protected boolean sz(int i) {
        return false;
    }

    protected boolean sA(int i) {
        return false;
    }

    public boolean sB(int i) {
        return false;
    }

    public boolean sC(int i) {
        return true;
    }
}
