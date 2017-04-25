package com.tencent.mm.plugin.recovery.a;

import com.tencent.mm.BuildConfig;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.ky;
import com.tencent.mm.model.ag;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.d;
import java.io.File;
import java.util.HashMap;

public final class b implements ag {
    private c<ky> iqY = new c<ky>(this) {
        final /* synthetic */ b iqZ;

        {
            this.iqZ = r2;
            this.nhz = ky.class.getName().hashCode();
        }

        private static boolean a(ky kyVar) {
            switch (kyVar.bmu.action) {
                case 1:
                    com.tencent.mm.bc.b.JG(BuildConfig.APPLICATION_ID);
                    break;
                case 2:
                    b.aJW();
                    break;
            }
            return false;
        }
    };

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        e.a(new Runnable(this) {
            final /* synthetic */ b iqZ;

            {
                this.iqZ = r1;
            }

            public final void run() {
                b.aJW();
            }
        }, "reportRecoveryHandleThread");
        a.nhr.d(this.iqY);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        a.nhr.f(this.iqY);
    }

    public static void aJW() {
        if (!d.bm(aa.getContext(), WXRecoveryHandleService.class.getName())) {
            String str = aa.getContext().getCacheDir() + "/recovery/recovery.log";
            File file = new File(str);
            String str2 = null;
            if (file.exists() && file.length() > 0) {
                try {
                    str2 = FileOp.aV(str);
                    file.delete();
                } catch (Throwable e) {
                    v.a("RECOVERY", e, "", new Object[0]);
                }
            }
            if (be.kS(str2)) {
                v.i("MicroMsg.Recovery.SubCoreRecovery", "not found recovery log");
                return;
            }
            String[] split = str2.split("​​");
            if (split != null) {
                for (String i : split) {
                    v.i("MicroMsg.Recovery.SubCoreRecovery", i);
                }
            }
        }
    }
}
