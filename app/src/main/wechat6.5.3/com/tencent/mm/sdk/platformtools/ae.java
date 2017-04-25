package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class ae extends Handler implements com.tencent.mm.sdk.platformtools.ai.a {
    private Looper niO = getLooper();
    private Callback niP;
    a niQ;
    private String toStringResult = null;

    public interface a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f);

        void onTaskAdded(Runnable runnable, ai aiVar);

        void onTaskRunEnd(Runnable runnable, ai aiVar);
    }

    ae(a aVar) {
        this.niQ = aVar;
    }

    ae(Looper looper, a aVar) {
        super(looper);
        this.niQ = aVar;
    }

    ae(Callback callback, a aVar) {
        super(callback);
        this.niP = callback;
        this.niQ = aVar;
    }

    ae(Looper looper, Callback callback, a aVar) {
        super(looper, callback);
        this.niP = callback;
        this.niQ = aVar;
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        ai aiVar = new ai(this.niO.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            aiVar.njj = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), aiVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (this.niQ != null) {
            this.niQ.onTaskAdded(callback, aiVar);
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
        if (!(sendMessageAtTime || this.niQ == null)) {
            this.niQ.onTaskRunEnd(callback, aiVar);
        }
        return sendMessageAtTime;
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.niP == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.niQ != null) {
                this.niQ.onLog(message, null, this.niO.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, -1.0f);
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
        if (this.niQ != null) {
            this.niQ.handleMessage(message);
        }
    }

    public final String toString() {
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.niQ + "}";
        }
        return this.toStringResult;
    }

    public final void a(Runnable runnable, ai aiVar) {
        if (this.niQ != null) {
            this.niQ.onTaskRunEnd(runnable, aiVar);
        }
    }

    public final void a(Runnable runnable, Thread thread, long j, long j2, float f) {
        if (this.niQ != null) {
            this.niQ.onLog(null, runnable, thread, j, j2, f);
        }
    }
}
