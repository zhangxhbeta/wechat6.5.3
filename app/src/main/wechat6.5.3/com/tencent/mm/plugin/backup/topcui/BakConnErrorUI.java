package com.tencent.mm.plugin.backup.topcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakpcmodel.d;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int edl;

    protected final int getLayoutId() {
        return 2130903156;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.edl = getIntent().getIntExtra("cmd", -1);
            v.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.edl)});
            NI();
            b.UK().egj = d.egy;
        }
    }

    protected final void NI() {
        vD(2131231310);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakConnErrorUI emE;

            {
                this.emE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.emE.bAv();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        b.UK().egc = null;
        v.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.edl)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bAv();
        return true;
    }
}
