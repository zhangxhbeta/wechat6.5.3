package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;

public class SettingsAliasResultUI extends MMActivity {
    private String bLc;
    private TextView dtZ;
    private boolean ems;
    private TextView iLK;
    private Button iLL;
    private ImageView iLM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        this.bLc = (String) c.vf().get(42, null);
        this.ems = Boolean.valueOf(getIntent().getBooleanExtra("has_pwd", true)).booleanValue();
        NI();
    }

    protected final int getLayoutId() {
        return 2130904355;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131233883);
        this.dtZ = (TextView) findViewById(2131755458);
        this.iLK = (TextView) findViewById(2131755339);
        this.iLL = (Button) findViewById(2131759079);
        this.iLM = (ImageView) findViewById(2131759078);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasResultUI iLN;

            {
                this.iLN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLN.finish();
                return true;
            }
        });
        this.iLK.setText(this.bLc);
        if (this.ems) {
            this.iLL.setVisibility(8);
            this.dtZ.setText(getString(2131233889));
        } else {
            this.iLL.setVisibility(0);
            this.dtZ.setText(getString(2131233888));
        }
        this.iLL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsAliasResultUI iLN;

            {
                this.iLN = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.iLN.nDR.nEl, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", this.iLN.getString(2131234435));
                this.iLN.startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}
