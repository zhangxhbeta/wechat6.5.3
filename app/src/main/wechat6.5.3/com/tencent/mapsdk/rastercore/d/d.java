package com.tencent.mapsdk.rastercore.d;

import android.os.Handler;
import android.os.Message;
import com.tencent.mapsdk.rastercore.d.a.AnonymousClass1;

final class d extends Handler {
    private /* synthetic */ AnonymousClass1 a;

    d(AnonymousClass1 anonymousClass1) {
        this.a = anonymousClass1;
    }

    public final void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1:
                    this.a.l.a(this.a.h);
                    return;
                default:
                    return;
            }
        }
    }
}
