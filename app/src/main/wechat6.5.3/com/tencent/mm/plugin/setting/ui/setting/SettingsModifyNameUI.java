package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI extends MMActivity implements a {
    private p ePC = null;
    private c ePD = new c<jp>(this) {
        final /* synthetic */ SettingsModifyNameUI iMv;

        {
            this.iMv = r2;
            this.nhz = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            String str = jpVar.bka.bkb;
            String str2 = jpVar.bka.bkc;
            int i = jpVar.bka.ret;
            if (i != 0 && str2 != null) {
                g.A(this.iMv, str2, str);
                if (this.iMv.iJD != null) {
                    ak.yW();
                    com.tencent.mm.model.c.wG().c(this.iMv.iJD);
                }
            } else if (i == 0 && this.iMv.ePy) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(4, this.iMv.eQH.getText().toString());
                this.iMv.finish();
            }
            if (this.iMv.ePC != null) {
                this.iMv.ePC.dismiss();
            }
            return true;
        }
    };
    private boolean ePy = false;
    private MMEditText eQH;
    private j.b iJD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.c.a.nhr.e(this.ePD);
        NI();
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.ePD);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904359;
    }

    protected final void NI() {
        vD(2131235060);
        this.eQH = (MMEditText) findViewById(2131759089);
        MMEditText mMEditText = this.eQH;
        ak.yW();
        mMEditText.setText(e.a(this, (String) com.tencent.mm.model.c.vf().get(4, null), this.eQH.getTextSize()));
        this.eQH.setSelection(this.eQH.getText().length());
        this.eQH.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SettingsModifyNameUI iMv;

            {
                this.iMv = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.iMv.iT(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c dw = com.tencent.mm.ui.tools.a.c.b(this.eQH).dw(1, 32);
        dw.oWy = false;
        dw.a(null);
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyNameUI iMv;

            {
                this.iMv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String obj = this.iMv.eQH.getText().toString();
                String sL = com.tencent.mm.h.b.sL();
                if (be.kS(sL) || !obj.matches(".*[" + sL + "].*")) {
                    com.tencent.mm.ui.tools.a.c.b(this.iMv.eQH).dw(1, 32).a(this.iMv);
                    return true;
                }
                g.A(this.iMv.nDR.nEl, this.iMv.getString(2131233303, new Object[]{sL}), this.iMv.getString(2131231164));
                return false;
            }
        }, k.b.nET);
        iT(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyNameUI iMv;

            {
                this.iMv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMv.axg();
                this.iMv.finish();
                return true;
            }
        });
    }

    public final void qK(String str) {
        v.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + str);
        this.ePy = true;
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.ePC = g.a(actionBarActivity, getString(2131232013), false, null);
        this.iJD = com.tencent.mm.model.k.o(2, str);
    }

    public final void adq() {
        g.f(this, 2131235061, 2131235064);
    }

    public final void adr() {
        g.f(this, 2131235062, 2131235064);
    }
}
