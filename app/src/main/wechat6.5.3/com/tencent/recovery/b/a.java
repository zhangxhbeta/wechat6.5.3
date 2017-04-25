package com.tencent.recovery.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.recovery.b;

public final class a extends Handler {
    public a() {
        super(Looper.getMainLooper());
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                b.bMu();
                return;
            case 2:
                b.yH(11);
                return;
            case 3:
                b.yH(11);
                return;
            default:
                return;
        }
    }
}
