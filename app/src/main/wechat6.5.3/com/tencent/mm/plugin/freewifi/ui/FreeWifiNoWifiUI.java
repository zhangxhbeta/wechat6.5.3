package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiNoWifiUI gcv;

            {
                this.gcv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gcv.finish();
                return true;
            }
        });
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903664;
    }
}
