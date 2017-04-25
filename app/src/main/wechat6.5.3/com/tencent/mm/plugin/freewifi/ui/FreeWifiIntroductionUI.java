package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private int bbT;
    private Button gaV;
    private Button gbX;
    private Button gbY;
    private CheckBox gbZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.gbX = (Button) findViewById(2131757098);
        this.gbZ = (CheckBox) findViewById(2131757096);
        this.gaV = (Button) findViewById(2131757099);
        this.gbY = (Button) findViewById(2131757097);
        this.bbT = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.bbT == 3) {
            vD(2131233842);
            ((TextView) findViewById(2131757095)).setText(2131233840);
            ((TextView) findViewById(2131757094)).setText(2131233839);
            this.gaV.setVisibility(8);
        } else {
            vD(2131232984);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI gca;

            {
                this.gca = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gca.finish();
                return false;
            }
        });
        this.gbX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI gca;

            {
                this.gca = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                c.vf().set(303104, Integer.valueOf(1));
                Intent intent = this.gca.getIntent();
                intent.setClass(this.gca, FreeWifiEntryUI.class);
                this.gca.startActivity(intent);
                this.gca.finish();
            }
        });
        this.gbZ.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI gca;

            {
                this.gca = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.gca.gbX.setEnabled(true);
                } else {
                    this.gca.gbX.setEnabled(false);
                }
            }
        });
        this.gbY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI gca;

            {
                this.gca = r1;
            }

            public final void onClick(View view) {
                String string;
                if (this.gca.bbT == 3) {
                    string = this.gca.getString(2131233841);
                } else {
                    string = this.gca.getString(2131232981);
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gca, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.gaV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI gca;

            {
                this.gca = r1;
            }

            public final void onClick(View view) {
                String string = this.gca.getString(2131232961);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gca, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903661;
    }
}
