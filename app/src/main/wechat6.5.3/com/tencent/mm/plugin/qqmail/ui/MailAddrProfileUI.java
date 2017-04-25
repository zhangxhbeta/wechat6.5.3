package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f dxf;
    private String gRG;
    private boolean ifl;
    private String name;

    public final int Oo() {
        return 2131099699;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.gRG = getIntent().getStringExtra("addr");
        this.ifl = getIntent().getBooleanExtra("can_compose", false);
        NI();
    }

    protected final void NI() {
        vD(2131233310);
        this.dxf = this.ocZ;
        ((KeyValuePreference) this.dxf.Ow("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.dxf.Ow("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference Ow = this.dxf.Ow("mail_compose_btn");
        if (!this.ifl) {
            this.dxf.b(Ow);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrProfileUI ifm;

            {
                this.ifm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ifm.axg();
                this.ifm.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.gRG});
            startActivity(intent);
            finish();
        }
        return false;
    }
}
