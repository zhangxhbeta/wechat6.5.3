package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.h.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public final class a implements b {
    private final String TAG = "MicroMsg.NotificationObserver";
    private final int hIp = 50;
    public boolean hIq = false;
    private ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ a hIr;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            final String string = message.getData().getString("com.tencent.mm.notification.observer");
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hIt;

                public final void run() {
                    final int td = i.td();
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 hIv;

                        public final void run() {
                            boolean tM;
                            ak.oH().dA(td);
                            ak.yW();
                            u LX = c.wH().LX(string);
                            if (LX != null) {
                                tM = LX.tM();
                            } else {
                                tM = false;
                            }
                            if (!tM) {
                                ak.oH().k(string, i.dC(string));
                            }
                            v.d("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[]{Integer.valueOf(td), Integer.valueOf(i.dC(string)), Boolean.valueOf(tM)});
                            e.a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 hIw;

                                {
                                    this.hIw = r1;
                                }

                                public final void run() {
                                    ak.oH().k(td, string);
                                    if (this.hIw.hIv.hIt.hIr.hIq) {
                                        this.hIw.hIv.hIt.hIr.hIq = false;
                                        ak.oH().aq(false);
                                    }
                                }
                            }, "NotificationObserver");
                        }
                    });
                }
            }, 500);
        }
    };

    public final void a(int i, j jVar, Object obj) {
        v.i("MicroMsg.NotificationObserver", "event: %d", new Object[]{Integer.valueOf(i)});
        if (!(obj instanceof String) || be.kS((String) obj)) {
            v.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        int i2;
        if (ak.yN()) {
            i2 = 0;
        } else {
            ak.yW();
            i2 = (int) c.wH().LV((String) obj).chr;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
    }
}
