package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private Context context;
    private ServiceConnection gfD = new ServiceConnection(this) {
        final /* synthetic */ d neE;

        {
            this.neE = r1;
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.neE.neD = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.neE.neD = a.W(iBinder);
            for (Runnable run : (Runnable[]) this.neE.neC.toArray(new Runnable[this.neE.neC.size()])) {
                run.run();
            }
            this.neE.neC.clear();
        }
    };
    List<Runnable> neC = new LinkedList();
    c neD;

    public d(Context context) {
        this.context = context;
    }

    public final void z(Runnable runnable) {
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            return;
        }
        this.neC.add(runnable);
        this.context.bindService(new Intent(this.context, RemoteService.class), this.gfD, 1);
    }

    public final boolean isConnected() {
        return this.neD != null && this.neD.asBinder().isBinderAlive();
    }

    public final void release() {
        if (this.neD != null && this.gfD != null) {
            this.context.unbindService(this.gfD);
            this.neD = null;
        }
    }

    final void a(b bVar, String str, Bundle bundle) {
        if (isConnected()) {
            try {
                this.neD.a(bVar.getClass().getName(), str, bundle, bVar);
            } catch (Throwable e) {
                v.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[]{be.e(e)});
            }
        }
    }
}
