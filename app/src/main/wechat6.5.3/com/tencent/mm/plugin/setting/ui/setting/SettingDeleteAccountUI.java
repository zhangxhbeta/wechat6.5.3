package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    protected final int getLayoutId() {
        return 2130904348;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234932);
        NI();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountUI iKt;

            {
                this.iKt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKt.axg();
                this.iKt.finish();
                return true;
            }
        });
        ((TextView) findViewById(2131759067)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountUI iKt;

            {
                this.iKt = r1;
            }

            public final void onClick(View view) {
            }
        });
    }
}
