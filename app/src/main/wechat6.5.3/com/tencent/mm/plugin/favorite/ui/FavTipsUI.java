package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h.a;

public class FavTipsUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.Op(getString(2131232676));
        aVar.Oq(getString(2131232674) + "\n\n" + getString(2131232675));
        aVar.wp(2131232673).a(new OnClickListener(this) {
            final /* synthetic */ FavTipsUI fOL;

            {
                this.fOL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.fOL.finish();
            }
        });
        aVar.c(new OnCancelListener(this) {
            final /* synthetic */ FavTipsUI fOL;

            {
                this.fOL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.fOL.finish();
            }
        });
        aVar.RX().show();
    }
}
