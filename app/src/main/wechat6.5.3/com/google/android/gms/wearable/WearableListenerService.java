package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.k;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.m.c;
import java.util.List;

public abstract class WearableListenerService extends Service implements com.google.android.gms.wearable.a.a, com.google.android.gms.wearable.b.a, b, com.google.android.gms.wearable.j.a, m.b, c {
    private volatile int aEp = -1;
    private String aEq;
    private Handler aEr;
    private Object aEs = new Object();
    private boolean agC;
    private IBinder anH;

    private class a extends com.google.android.gms.wearable.internal.w.a {
        boolean aEt = false;
        final /* synthetic */ WearableListenerService aEu;

        a(WearableListenerService wearableListenerService) {
            this.aEu = wearableListenerService;
            this.aEt = wearableListenerService instanceof zzj;
        }

        public final void a(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onDataItemChanged: ").append(this.aEu.aEq).append(": ").append(dataHolder);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    dataHolder.close();
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                        e eVar = new e(dataHolder);
                        try {
                            this.aEw.aEu.a(eVar);
                        } finally {
                            eVar.release();
                        }
                    }
                });
            }
        }

        public final void a(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onEntityUpdate: ").append(amsEntityUpdateParcelable);
            }
            if (this.aEt) {
                WearableListenerService.b(this.aEu);
                final zzj com_google_android_gms_wearable_zzj = (zzj) this.aEu;
                synchronized (this.aEu.aEs) {
                    if (this.aEu.agC) {
                        return;
                    }
                    this.aEu.aEr.post(new Runnable(this) {
                        final /* synthetic */ a aEw;

                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onNotificationReceived: ").append(ancsNotificationParcelable);
            }
            if (this.aEt) {
                WearableListenerService.b(this.aEu);
                final zzj com_google_android_gms_wearable_zzj = (zzj) this.aEu;
                synchronized (this.aEu.aEs) {
                    if (this.aEu.agC) {
                        return;
                    }
                    this.aEu.aEr.post(new Runnable(this) {
                        final /* synthetic */ a aEw;

                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedCapabilityChanged: ").append(capabilityInfoParcelable);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                    }
                });
            }
        }

        public final void a(final ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onChannelEvent: ").append(channelEventParcelable);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                        channelEventParcelable.mB();
                    }
                });
            }
        }

        public final void a(final MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onMessageReceived: ").append(messageEventParcelable);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                        this.aEw.aEu.a(messageEventParcelable);
                    }
                });
            }
        }

        public final void a(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerConnected: ").append(this.aEu.aEq).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                        this.aEw.aEu.a(nodeParcelable);
                    }
                });
            }
        }

        public final void b(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerDisconnected: ").append(this.aEu.aEq).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                        this.aEw.aEu.b(nodeParcelable);
                    }
                });
            }
        }

        public final void m(final List<NodeParcelable> list) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedNodes: ").append(this.aEu.aEq).append(": ").append(list);
            }
            WearableListenerService.b(this.aEu);
            synchronized (this.aEu.aEs) {
                if (this.aEu.agC) {
                    return;
                }
                this.aEu.aEr.post(new Runnable(this) {
                    final /* synthetic */ a aEw;

                    public final void run() {
                    }
                });
            }
        }
    }

    static /* synthetic */ void b(WearableListenerService wearableListenerService) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == wearableListenerService.aEp) {
            return;
        }
        if (e.a(wearableListenerService, callingUid, "com.google.android.wearable.app.cn")) {
            if (k.kx().a(wearableListenerService.getPackageManager(), "com.google.android.wearable.app.cn")) {
                wearableListenerService.aEp = callingUid;
                return;
            }
            throw new SecurityException("Caller is not Android Wear.");
        } else if (e.l(wearableListenerService, callingUid)) {
            wearableListenerService.aEp = callingUid;
        } else {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public void a(e eVar) {
    }

    public void a(k kVar) {
    }

    public void a(l lVar) {
    }

    public void b(l lVar) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.anH : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onCreate: ").append(getPackageName());
        }
        this.aEq = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.aEr = new Handler(handlerThread.getLooper());
        this.anH = new a(this);
    }

    public void onDestroy() {
        synchronized (this.aEs) {
            this.agC = true;
            if (this.aEr == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.aEr.getLooper().quit();
        }
        super.onDestroy();
    }
}
