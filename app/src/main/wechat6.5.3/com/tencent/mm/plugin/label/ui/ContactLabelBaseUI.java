package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog eZg;

    protected int getLayoutId() {
        return 0;
    }

    public final void vz(String str) {
        getString(2131231164);
        this.eZg = g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ ContactLabelBaseUI gPV;

            {
                this.gPV = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().cancel(636);
            }
        });
    }

    public final void avM() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }

    public final void rI(String str) {
        g.a(this, str, "", new OnClickListener(this) {
            final /* synthetic */ ContactLabelBaseUI gPV;

            {
                this.gPV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
