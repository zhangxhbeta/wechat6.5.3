package com.tencent.mm.plugin.backup.backuppcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupConnErrorUI extends MMWizardActivity {
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
        }
    }

    protected final void NI() {
        vD(2131231310);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupConnErrorUI edm;

            {
                this.edm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.edm.bAv();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        b.UL().ebw = null;
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
