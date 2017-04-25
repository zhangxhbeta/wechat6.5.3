package com.tencent.mm.plugin.backup.moveui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class BakMoveErrUI extends MMActivity {
    private Button elT;
    private TextView elU;
    private TextView elV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final void NI() {
        this.elU = (TextView) findViewById(2131755529);
        this.elV = (TextView) findViewById(2131755530);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveErrUI elW;

            {
                this.elW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.elW.finish();
                return true;
            }
        });
        this.elT = (Button) findViewById(2131755514);
        this.elT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveErrUI elW;

            {
                this.elW = r1;
            }

            public final void onClick(View view) {
                this.elW.finish();
            }
        });
        if (getIntent().getBooleanExtra("battery_not_enough", false)) {
            v.i("MicroMsg.BakMoveErrUI", "GET_BATTERY_ERR");
            this.elU.setText(2131231322);
            this.elV.setText(2131231323);
            g.iuh.h(11787, Integer.valueOf(4));
            g.iuh.a(103, 3, 1, false);
        } else if (getIntent().getBooleanExtra("getConnectInfoErr", false)) {
            v.i("MicroMsg.BakMoveErrUI", "GET_CONNECTINFO_ERR");
            this.elU.setText(2131231324);
            this.elV.setText(2131231325);
            g.iuh.h(11787, Integer.valueOf(1));
            g.iuh.a(103, 0, 1, false);
        } else if (getIntent().getBooleanExtra("wifiNameDifferentErr", false)) {
            v.i("MicroMsg.BakMoveErrUI", "WIFINAME_DIFFERENT_ERR");
            this.elU.setText(2131231332);
            this.elV.setText(getString(2131231333, new Object[]{getIntent().getStringExtra("WifiName")}));
            g.iuh.h(11787, Integer.valueOf(2));
            g.iuh.a(103, 1, 1, false);
        } else if (getIntent().getBooleanExtra("complexWIFIErr", false)) {
            v.i("MicroMsg.BakMoveErrUI", "COMPLEX_WIFI_ERR");
            this.elU.setText(2131231330);
            this.elV.setText(2131231331);
            this.elT.setText(2131231321);
            this.elT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BakMoveErrUI elW;

                {
                    this.elW = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.elW.getString(2131231334));
                    intent.putExtra("rawUrl", this.elW.getString(2131231363));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    c.b(this.elW, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            g.iuh.h(11787, Integer.valueOf(3));
            g.iuh.a(103, 2, 1, false);
        } else if (getIntent().getIntExtra("err_type", 0) == 10012) {
            this.elU.setText(2131231328);
            String[] split = getIntent().getStringExtra("err_info").split(",");
            try {
                long j;
                long j2 = (be.getLong(split[0], 0) / 1024) / 1024;
                if (j2 == 0) {
                    j = 1;
                } else {
                    j = j2;
                }
                j2 = (be.getLong(split[1], 0) / 1024) / 1024;
                if (j2 == 0) {
                    j2 = 1;
                }
                this.elV.setText(getString(2131231329, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
                v.i("MicroMsg.BakMoveErrUI", "GET_CONNECTINFO_ERR, size:%d, need:%d", Long.valueOf(j), Long.valueOf(j2));
            } catch (Exception e) {
                this.elV.setVisibility(8);
            }
            g.iuh.h(11787, Integer.valueOf(5));
            g.iuh.a(103, 4, 1, false);
        } else {
            v.i("MicroMsg.BakMoveErrUI", "DISCONNECT");
            this.elU.setText(2131231326);
            this.elV.setText(2131231327);
        }
    }

    protected final int getLayoutId() {
        return 2130903153;
    }
}
