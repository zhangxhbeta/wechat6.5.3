package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    protected final int getLayoutId() {
        return 2130904349;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234932);
        NI();
    }

    protected final void NI() {
        final TextView textView = (TextView) findViewById(2131756365);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI iKp;

            {
                this.iKp = r1;
            }

            public final void onClick(View view) {
                this.iKp.startActivity(new Intent(this.iKp, SettingDeleteAccountInputPassUI.class));
            }
        });
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(2131759068);
        checkedTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI iKp;

            public final void onClick(View view) {
                textView.setEnabled(checkedTextView.isChecked());
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI iKp;

            {
                this.iKp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKp.axg();
                this.iKp.finish();
                return true;
            }
        });
    }
}
