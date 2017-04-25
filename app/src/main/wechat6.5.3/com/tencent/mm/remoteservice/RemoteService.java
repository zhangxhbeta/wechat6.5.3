package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Constructor;

public class RemoteService extends Service {
    private a neA = new a(this) {
        final /* synthetic */ RemoteService neB;

        {
            this.neB = r1;
        }

        public final void a(String str, String str2, Bundle bundle, b bVar) {
            try {
                a aVar;
                Class loadClass = this.neB.getClassLoader().loadClass(str);
                Constructor[] constructors = loadClass.getConstructors();
                if (constructors.length > 0) {
                    Object[] objArr = new Object[constructors[0].getParameterTypes().length];
                    objArr[0] = null;
                    aVar = (a) constructors[0].newInstance(objArr);
                } else {
                    aVar = (a) loadClass.newInstance();
                }
                aVar.nex = bVar;
                aVar.new = this.neB;
                aVar.onCallback(str2, bundle, false);
            } catch (Throwable e) {
                v.e("MicroMsg.RemoveService", "exception:%s", new Object[]{be.e(e)});
            }
        }
    };

    public IBinder onBind(Intent intent) {
        new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
        return this.neA;
    }

    public void onRebind(Intent intent) {
        new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
        super.onDestroy();
    }
}
