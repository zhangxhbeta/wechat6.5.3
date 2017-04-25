package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232577);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceExpireUI fBG;

            {
                this.fBG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fBG.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903550;
    }
}
