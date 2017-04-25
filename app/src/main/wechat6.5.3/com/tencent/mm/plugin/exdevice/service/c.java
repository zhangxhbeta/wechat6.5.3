package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a fxm;
    public volatile boolean fxn;
    private List<Runnable> fxo = new LinkedList();

    public static abstract class a {
        public int bbf;

        public abstract void onServiceConnected();

        public a(int i) {
            this.bbf = i;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List arrayList;
        v.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(com.tencent.mm.plugin.exdevice.service.h.a.G(iBinder));
        u.a(xVar);
        if (!aa.btr()) {
            com.tencent.mm.compatible.d.r.a aVar = r.rZ().ceO;
            if (aVar instanceof com.tencent.mm.plugin.exdevice.a) {
                ((com.tencent.mm.plugin.exdevice.a) aVar).a(xVar);
            }
        }
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.aip());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.aiJ());
        if (!xVar.a(ac.ajC())) {
            v.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.fxm != null) {
            this.fxm.onServiceConnected();
        }
        this.fxn = true;
        synchronized (this.fxo) {
            arrayList = new ArrayList(this.fxo);
            this.fxo.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Runnable runnable = (Runnable) arrayList.get(i);
            if (runnable != null) {
                runnable.run();
            }
        }
        arrayList.clear();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        v.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.fxn = false;
        u.a(null);
        if (!aa.btr()) {
            com.tencent.mm.compatible.d.r.a aVar = r.rZ().ceO;
            if (aVar instanceof com.tencent.mm.plugin.exdevice.a) {
                ((com.tencent.mm.plugin.exdevice.a) aVar).a(null);
            }
        }
        if (!ak.uN() || ak.uG()) {
            v.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
        } else {
            bD(aa.getContext());
        }
    }

    public final void bD(Context context) {
        if (!d.bE(context)) {
            v.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
        } else if (context.bindService(new Intent(context, ExDeviceService.class), this, 1)) {
            v.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
        } else {
            v.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
        }
    }

    public final boolean m(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (this.fxn) {
            runnable.run();
        } else {
            synchronized (this.fxo) {
                this.fxo.add(runnable);
            }
        }
        return true;
    }
}
