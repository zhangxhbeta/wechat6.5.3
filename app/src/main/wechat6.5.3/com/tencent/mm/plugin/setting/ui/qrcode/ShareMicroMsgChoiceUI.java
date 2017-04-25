package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f dxf;

    protected final boolean On() {
        return false;
    }

    public final int getLayoutId() {
        return 2130904382;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final int Oo() {
        return 2131099736;
    }

    protected final void NI() {
        vD(2131234914);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareMicroMsgChoiceUI iJs;

            {
                this.iJs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJs.axg();
                this.iJs.finish();
                return true;
            }
        });
        ((IconPreference) this.dxf.Ow("share_micromsg_to_sina")).drawable = a.a(this, 2130839150);
        ak.yW();
        c.wN().Nr("@t.qq.com");
        ak.yW();
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("share_micromsg_qzone");
        if ((be.f((Integer) c.vf().get(9, null)) != 0 ? 1 : null) == null) {
            this.dxf.b(iconPreference);
        } else {
            iconPreference.drawable = a.a(this, 2130839090);
        }
        iconPreference = (IconPreference) this.dxf.Ow("share_micromsg_to_fuckbook");
        if (k.yf()) {
            iconPreference.drawable = a.a(this, 2130839149);
        } else {
            this.dxf.b(iconPreference);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            ak.yW();
            if (be.f((Integer) c.vf().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                g.f(this, 2131234893, 2131231164);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        return false;
    }
}
