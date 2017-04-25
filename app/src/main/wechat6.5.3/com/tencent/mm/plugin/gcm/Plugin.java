package com.tencent.mm.plugin.gcm;

import com.tencent.mm.e.a.an;
import com.tencent.mm.e.a.fw;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver;
import com.tencent.mm.plugin.gcm.modelgcm.a;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements c {
    com.tencent.mm.sdk.c.c gAv = new com.tencent.mm.sdk.c.c<an>(this) {
        final /* synthetic */ Plugin gAx;

        {
            this.gAx = r2;
            this.nhz = an.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a asP = a.asP();
            if (asP == null) {
                return false;
            }
            asP.asQ();
            return true;
        }
    };
    com.tencent.mm.sdk.c.c gAw = new com.tencent.mm.sdk.c.c<fw>(this) {
        final /* synthetic */ Plugin gAx;

        {
            this.gAx = r2;
            this.nhz = fw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a asP = a.asP();
            if (asP == null) {
                return false;
            }
            v.i("GcmRegister", "GCM onLogout. isRegToSvr:" + asP.asV());
            GcmBroadcastReceiver.asO();
            if (asP.asV()) {
                asP.asU();
            }
            return true;
        }
    };

    public Plugin() {
        com.tencent.mm.sdk.c.a.nhr.e(this.gAv);
        com.tencent.mm.sdk.c.a.nhr.e(this.gAw);
    }

    public i createApplication() {
        return new com.tencent.mm.plugin.gcm.a.a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new com.tencent.mm.plugin.gcm.modelgcm.b();
    }
}
