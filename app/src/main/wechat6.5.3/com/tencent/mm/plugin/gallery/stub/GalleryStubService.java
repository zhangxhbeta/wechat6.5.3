package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.h.b;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class GalleryStubService extends Service {
    private a geF = new a(this) {
        final /* synthetic */ GalleryStubService geG;

        {
            this.geG = r1;
        }

        public final void Q(int i, String str) {
            g.iuh.Y(i, str);
        }

        public final void a(String str, String str2, boolean z, int i, boolean z2) {
            if (com.tencent.mm.sdk.c.a.nhr != null) {
                hh hhVar = new hh();
                hhVar.bgY.bgZ = Boolean.valueOf(z);
                hhVar.bgY.imagePath = str;
                hhVar.bgY.bha = i;
                hhVar.bgY.toUser = str2;
                hhVar.bgY.bhb = Boolean.valueOf(z2);
                com.tencent.mm.sdk.c.a.nhr.z(hhVar);
            }
        }

        public final void oo() {
            f.oS(19);
        }

        public final int aqN() {
            return be.getInt(j.sU().getValue("InputLimitVideoSize"), 20971520);
        }

        public final int sJ() {
            return b.sJ();
        }

        public final int sI() {
            return b.sI();
        }
    };

    public IBinder onBind(Intent intent) {
        v.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[]{intent});
        return this.geF;
    }
}
