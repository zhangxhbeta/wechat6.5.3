package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class q {
    private static q ju;
    b jv;
    b jw;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Callback(this) {
        final /* synthetic */ q jx;

        {
            this.jx = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    q qVar = this.jx;
                    b bVar = (b) message.obj;
                    synchronized (qVar.mLock) {
                        if (qVar.jv == bVar || qVar.jw == bVar) {
                            qVar.a(bVar);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final Object mLock = new Object();

    interface a {
    }

    private static class b {
        int duration;
        final WeakReference<a> jy;

        final boolean f(a aVar) {
            return aVar != null && this.jy.get() == aVar;
        }
    }

    static q aq() {
        if (ju == null) {
            ju = new q();
        }
        return ju;
    }

    private q() {
    }

    public final void a(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                this.mHandler.removeCallbacksAndMessages(this.jv);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                b(this.jv);
            }
        }
    }

    public final boolean c(a aVar) {
        boolean z;
        synchronized (this.mLock) {
            z = d(aVar) || e(aVar);
        }
        return z;
    }

    final boolean a(b bVar) {
        if (((a) bVar.jy.get()) == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(bVar);
        return true;
    }

    final boolean d(a aVar) {
        return this.jv != null && this.jv.f(aVar);
    }

    final boolean e(a aVar) {
        return this.jw != null && this.jw.f(aVar);
    }

    final void b(b bVar) {
        if (bVar.duration != -2) {
            int i = 2750;
            if (bVar.duration > 0) {
                i = bVar.duration;
            } else if (bVar.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(bVar);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, bVar), (long) i);
        }
    }
}
