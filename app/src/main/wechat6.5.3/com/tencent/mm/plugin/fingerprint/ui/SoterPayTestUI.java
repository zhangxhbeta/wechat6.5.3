package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.fingerprint.b.a;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SoterPayTestUI extends MMActivity implements e {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(2131757048).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI fUI;

            {
                this.fUI = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
                ak.vy().a(1586, this.fUI);
                ak.vy().a(new a(), 0);
            }
        });
        findViewById(2131757049).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI fUI;

            {
                this.fUI = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
                f.a(aa.getContext(), new d(this) {
                    final /* synthetic */ AnonymousClass2 fUJ;

                    {
                        this.fUJ = r1;
                    }

                    public final void h(int i, String str, String str2) {
                    }
                });
            }
        });
        findViewById(2131757050).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI fUI;

            {
                this.fUI = r1;
            }

            public final void onClick(View view) {
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903647;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        s.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        ak.vy().b(kVar.getType(), this);
    }
}
