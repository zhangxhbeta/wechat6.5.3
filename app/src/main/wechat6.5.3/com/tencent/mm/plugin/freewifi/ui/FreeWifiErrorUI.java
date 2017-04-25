package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView gbm;
    private TextView gbn;
    private TextView gbo;
    private TextView gbp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232984);
        this.gbm = (ImageView) findViewById(2131757081);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.gbm.setImageResource(2130838249);
        }
        this.gbn = (TextView) findViewById(2131757082);
        this.gbo = (TextView) findViewById(2131757083);
        this.gbp = (TextView) findViewById(2131757084);
        CharSequence stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        CharSequence stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        CharSequence stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.ty(stringExtra)) {
            this.gbn.setText(stringExtra);
        }
        if (!m.ty(stringExtra2)) {
            this.gbo.setText(stringExtra2);
        }
        if (!m.ty(stringExtra3)) {
            this.gbp.setText(stringExtra3);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiErrorUI gbq;

            {
                this.gbq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gbq.finish();
                return true;
            }
        });
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903659;
    }
}
