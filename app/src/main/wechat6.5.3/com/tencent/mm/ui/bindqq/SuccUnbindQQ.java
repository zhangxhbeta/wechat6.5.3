package com.tencent.mm.ui.bindqq;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ extends MMWizardActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    protected final int getLayoutId() {
        return 2130904529;
    }

    protected final void NI() {
        vD(2131235707);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ SuccUnbindQQ ogO;

            {
                this.ogO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ogO.bAv();
                return true;
            }
        });
    }
}
