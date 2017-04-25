package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.safedevice.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    protected final int getLayoutId() {
        return 2130904316;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        vD(2131234690);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindSafeDeviceUI iuD;

            {
                this.iuD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuD.finish();
                return true;
            }
        });
        ((ImageView) findViewById(2131759014)).setImageResource(2131165186);
        ((TextView) findViewById(2131759015)).setText(2131234696);
        ((TextView) findViewById(2131759018)).setText(2131234697);
        findViewById(2131759018).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindSafeDeviceUI iuD;

            {
                this.iuD = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("is_bind_for_safe_device", true);
                a.drp.b(this.iuD, intent);
            }
        });
    }
}
