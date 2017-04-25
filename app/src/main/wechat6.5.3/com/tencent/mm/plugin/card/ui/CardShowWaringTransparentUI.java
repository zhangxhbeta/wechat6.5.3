package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(7)
public class CardShowWaringTransparentUI extends MMActivity {
    protected final int getLayoutId() {
        return 2130903260;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a(this, getString(2131231714, new Object[]{getIntent().getStringExtra("KEY_BRAND_NAME")}), getString(2131231715), getString(2131230747), new OnClickListener(this) {
            final /* synthetic */ CardShowWaringTransparentUI eLN;

            {
                this.eLN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.eLN.finish();
            }
        });
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }
}
