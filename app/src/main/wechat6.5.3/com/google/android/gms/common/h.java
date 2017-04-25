package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h implements ServiceConnection {
    boolean aqT = false;
    private final BlockingQueue<IBinder> aqU = new LinkedBlockingQueue();

    public final IBinder kt() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.aqT) {
            throw new IllegalStateException();
        } else {
            this.aqT = true;
            return (IBinder) this.aqU.take();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aqU.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
