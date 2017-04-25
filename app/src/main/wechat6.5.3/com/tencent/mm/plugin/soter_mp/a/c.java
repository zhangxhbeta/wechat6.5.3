package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.b;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class c {
    protected b kee = null;
    protected com.tencent.mm.plugin.soter_mp.b.c kef = null;
    protected WeakReference<Activity> keg = null;

    public abstract void cW();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, b bVar, com.tencent.mm.plugin.soter_mp.b.c cVar) {
        this.kee = bVar;
        this.kef = cVar;
        this.keg = weakReference;
    }

    protected static void aYV() {
        if (SoterAuthenticationUI.kem != null) {
            SoterAuthenticationUI.kem.obtainMessage(5).sendToTarget();
        } else {
            v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    protected final void aYW() {
        if (SoterAuthenticationUI.kem != null) {
            aYV();
            SoterAuthenticationUI.kem.obtainMessage(0, this.kef).sendToTarget();
            return;
        }
        v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void aYX() {
        if (SoterAuthenticationUI.kem != null) {
            aYV();
            SoterAuthenticationUI.kem.obtainMessage(1, this.kef).sendToTarget();
            return;
        }
        v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void aYY() {
        if (SoterAuthenticationUI.kem != null) {
            aYV();
            SoterAuthenticationUI.kem.obtainMessage(2, this.kef).sendToTarget();
            return;
        }
        v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected static void a(h hVar) {
        if (hVar == null) {
            v.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (SoterAuthenticationUI.kem != null) {
            aYV();
            SoterAuthenticationUI.kem.obtainMessage(6, hVar).sendToTarget();
        } else {
            v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
