package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements c {
    public b pjG = null;
    public f pjH = null;
    public d pjI = null;

    public abstract boolean f(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjH = new f(this, this);
        this.pjH.gQ(385);
        this.pjH.gQ(1518);
        if (getLayoutId() > 0) {
            e.i(this);
        }
    }

    public final f bLG() {
        if (this.pjH == null) {
            this.pjH = new f(this, this);
        }
        return this.pjH;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!f(i, i2, str, kVar) && i2 != 0) {
            if (be.kS(str)) {
                str = getString(2131236155);
            }
            g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletPreferenceUI pjX;

                {
                    this.pjX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pjX.finish();
                }
            });
        }
    }

    public void onDestroy() {
        this.pjH.gR(385);
        this.pjH.gR(1518);
        this.pjH = null;
        super.onDestroy();
    }
}
