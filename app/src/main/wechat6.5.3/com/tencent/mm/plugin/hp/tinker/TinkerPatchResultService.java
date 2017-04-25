package com.tencent.mm.plugin.hp.tinker;

import android.os.Looper;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class TinkerPatchResultService extends DefaultTinkerResultService {
    public final void a(a aVar) {
        int i = 1;
        if (aVar == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[]{aVar.toString()});
        new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
            final /* synthetic */ TinkerPatchResultService gEc;

            {
                this.gEc = r1;
            }

            public final void run() {
                com.tencent.tinker.lib.e.a.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
                b.gi(this.gEc.getApplicationContext());
            }
        }, 30000);
        if (aVar.bbq) {
            ApplicationLike tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
            if (com.tencent.tinker.lib.d.b.b(tinkerApplicationLike)) {
                String c = com.tencent.tinker.lib.d.b.c(tinkerApplicationLike);
                if (!(ShareTinkerInternals.kS(c) || aVar.pFE == null || !aVar.pFE.equals(c))) {
                    i = 0;
                }
            }
            if (i != 0) {
                m mVar = new m(aa.getContext(), new m.a(this) {
                    final /* synthetic */ TinkerPatchResultService gEc;

                    {
                        this.gEc = r1;
                    }

                    public final void bc(boolean z) {
                        if (!z) {
                            com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchResultService", "app is background now, i can kill quietly", new Object[0]);
                            v.btb();
                            BaseEvent.onDestroy();
                            int myPid = Process.myPid();
                            com.tencent.recovery.b.yH(13);
                            Process.killProcess(myPid);
                        }
                    }
                });
            } else {
                com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }
}
