package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI extends MMActivity {
    private p ePC = null;
    private c ePD = new c<jp>(this) {
        final /* synthetic */ EditSignatureUI iJF;

        {
            this.iJF = r2;
            this.nhz = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            String str = jpVar.bka.bkb;
            String str2 = jpVar.bka.bkc;
            int i = jpVar.bka.ret;
            if (i != 0 && this.iJF.iJC != null) {
                g.A(this.iJF, str2, str);
                if (this.iJF.iJD != null) {
                    ak.yW();
                    com.tencent.mm.model.c.wG().c(this.iJF.iJD);
                }
            } else if (i == 0 && this.iJF.ePy) {
                str = this.iJF.iJC.getText().toString().trim();
                ak.yW();
                com.tencent.mm.model.c.vf().set(12291, str);
                this.iJF.finish();
            }
            if (this.iJF.ePC != null) {
                this.iJF.ePC.dismiss();
            }
            return true;
        }
    };
    private boolean ePy = false;
    private MMEditText iJC;
    private j.b iJD;
    final bf iJE = bf.zO();
    private TextView iJt;

    private class a implements TextWatcher {
        final /* synthetic */ EditSignatureUI iJF;
        private int iJG;

        private a(EditSignatureUI editSignatureUI) {
            this.iJF = editSignatureUI;
            this.iJG = 60;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.iJF.iT(true);
        }

        public final void afterTextChanged(Editable editable) {
            this.iJG = h.aw(60, editable.toString());
            if (this.iJG < 0) {
                this.iJG = 0;
            }
            if (this.iJF.iJt != null) {
                this.iJF.iJt.setText(this.iJG);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903472;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.c.a.nhr.e(this.ePD);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.ePD);
    }

    protected final void NI() {
        vD(2131235143);
        this.iJC = (MMEditText) findViewById(2131755329);
        this.iJt = (TextView) findViewById(2131756526);
        ak.yW();
        this.iJC.setText(e.a(this, be.ma((String) com.tencent.mm.model.c.vf().get(12291, null)), this.iJC.getTextSize()));
        this.iJC.setSelection(this.iJC.getText().length());
        this.iJt.setText(h.aw(60, this.iJC.getEditableText().toString()));
        com.tencent.mm.ui.tools.a.c.b(this.iJC).dw(0, 60).a(null);
        this.iJC.addTextChangedListener(new a());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EditSignatureUI iJF;

            {
                this.iJF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJF.axg();
                this.iJF.finish();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ EditSignatureUI iJF;

            {
                this.iJF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.iJF.iJC.getText().toString().trim();
                String sL = com.tencent.mm.h.b.sL();
                if (be.kS(sL) || !trim.matches(".*[" + sL + "].*")) {
                    EditSignatureUI editSignatureUI = this.iJF;
                    ActionBarActivity actionBarActivity = this.iJF.nDR.nEl;
                    this.iJF.getString(2131231164);
                    editSignatureUI.ePC = g.a(actionBarActivity, this.iJF.getString(2131232013), false, null);
                    this.iJF.iJD = k.o(18, trim);
                    this.iJF.ePy = true;
                    this.iJF.axg();
                    return true;
                }
                g.A(this.iJF.nDR.nEl, this.iJF.getString(2131233303, new Object[]{sL}), this.iJF.getString(2131231164));
                return false;
            }
        }, com.tencent.mm.ui.k.b.nET);
        iT(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
