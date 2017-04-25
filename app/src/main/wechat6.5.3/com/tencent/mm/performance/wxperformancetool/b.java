package com.tencent.mm.performance.wxperformancetool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.performance.d.a;
import java.util.Iterator;

public final class b extends HandlerThread {
    public static int dog = 2500;
    private c dof;
    public boolean doh = false;
    public Handler mHandler;

    class AnonymousClass1 extends Handler {
        final /* synthetic */ b doi;

        AnonymousClass1(b bVar, Looper looper) {
            this.doi = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    Iterator it = this.doi.dof.doj.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.MM()) {
                            aVar.ML();
                        }
                    }
                    if (!this.doi.doh) {
                        this.doi.mHandler.sendEmptyMessageDelayed(1, (long) b.dog);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public b(String str, c cVar) {
        super(str);
        this.dof = cVar;
    }
}
