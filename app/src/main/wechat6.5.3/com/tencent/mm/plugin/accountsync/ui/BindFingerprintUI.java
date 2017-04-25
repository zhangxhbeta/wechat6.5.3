package com.tencent.mm.plugin.accountsync.ui;

import android.os.Bundle;
import android.os.CancellationSignal;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.pluginsdk.l.b;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.security.Signature;

public class BindFingerprintUI extends MMActivity implements e {
    private String cZU;
    private CancellationSignal cZZ;
    private p dwE;

    protected final int getLayoutId() {
        return 2130903164;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.BindFingerprintUI", "oncreate bindfingerprintui");
        ak.vy().a(247, this);
        NI();
        c bol = com.tencent.mm.pluginsdk.l.e.bol();
        String str = bol.bgr;
        String str2 = bol.bgs;
        if (be.kS(str) || be.kS(str2)) {
            v.a("MicroMsg.BindFingerprintUI", null, "cpuId is null, uid is null", new Object[0]);
            Oe();
            return;
        }
        ak.vy().a(new com.tencent.mm.ap.c(str, str2), 0);
    }

    protected final void NI() {
        super.NI();
        this.dwE = g.a(this, getString(2131231196), false, null);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.BindFingerprintUI", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() == 247 && i == 0 && i2 == 0) {
            this.cZU = ((com.tencent.mm.ap.c) kVar).cZU;
            v.i("MicroMsg.BindFingerprintUI", "get ticket successfully ticket: %s", new Object[]{this.cZU});
            AnonymousClass1 anonymousClass1 = new d(this) {
                final /* synthetic */ BindFingerprintUI dwF;

                {
                    this.dwF = r1;
                }

                public final void h(int i, String str, String str2) {
                    v.i("MicroMsg.BindFingerprintUI", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                    if (i == 0) {
                        this.dwF.Oe();
                    }
                }
            };
            AnonymousClass2 anonymousClass2 = new b(this) {
                final /* synthetic */ BindFingerprintUI dwF;

                {
                    this.dwF = r1;
                }

                public final void s(int i, String str) {
                    v.a("MicroMsg.BindFingerprintUI", null, "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                }

                public final void t(int i, String str) {
                    v.a("MicroMsg.BindFingerprintUI", null, "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                }

                public final void a(String str, Signature signature) {
                    v.i("MicroMsg.BindFingerprintUI", "onAuthenticationSucceeded");
                }

                public final void kq(String str) {
                    v.a("MicroMsg.BindFingerprintUI", null, "onAuthenticationFailed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(11), str});
                }
            };
            this.cZZ = new CancellationSignal();
            f.a(aa.getContext(), this.cZU, "SoteLoginAuthKeyName", anonymousClass1, anonymousClass2, this.cZZ);
        }
    }

    protected void onPause() {
        if (com.tencent.mm.compatible.util.d.dY(16) && this.cZZ != null) {
            this.cZZ.cancel();
            this.cZZ = null;
        }
        super.onPause();
    }

    private void Oe() {
        if (this.dwE != null && this.dwE.isShowing()) {
            this.dwE.dismiss();
            this.dwE = null;
        }
    }
}
