package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI extends MMActivity {
    protected final int getLayoutId() {
        return 2130904350;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234932);
        NI();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountInputPassUI iKs;

            {
                this.iKs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKs.axg();
                this.iKs.finish();
                return true;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountInputPassUI iKs;

            {
                this.iKs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKs.axg();
                this.iKs.startActivity(new Intent(this.iKs, SettingDeleteAccountUI.class));
                return true;
            }
        });
    }
}
