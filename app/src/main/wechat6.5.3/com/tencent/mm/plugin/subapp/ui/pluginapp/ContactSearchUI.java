package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class ContactSearchUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private EditText khO;

    protected final int getLayoutId() {
        return 2130903427;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onResume() {
        ak.vy().a(106, this);
        super.onResume();
    }

    protected void onPause() {
        ak.vy().b(106, this);
        super.onPause();
    }

    protected final void NI() {
        vD(2131232217);
        this.khO = (EditText) findViewById(2131756533);
        this.khO.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContactSearchUI khP;

            {
                this.khP = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.khP.iT(editable.length() > 0);
            }
        });
        this.khO.setImeOptions(3);
        this.khO.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ContactSearchUI khP;

            {
                this.khP = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || be.kS(this.khP.khO.getText().toString().trim()))) {
                    this.khP.aZD();
                }
                return false;
            }
        });
        a(0, getString(2131231064), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchUI khP;

            {
                this.khP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khP.aZD();
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchUI khP;

            {
                this.khP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khP.axg();
                this.khP.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.khO.setText(getIntent().getStringExtra("userName"));
            aZD();
        }
    }

    private void aZD() {
        String trim = this.khO.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            g.f(this.nDR.nEl, 2131235778, 2131231164);
            return;
        }
        v.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final y yVar = new y(trim, 1);
        ak.vy().a(yVar, 0);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(actionBarActivity, getString(2131230873), true, new OnCancelListener(this) {
            final /* synthetic */ ContactSearchUI khP;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(yVar);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!b.drq.b(this.nDR.nEl, i, i2, str)) {
            if (i == 4 && i2 == -4) {
                g.f(this.nDR.nEl, 2131230867, 2131231164);
            } else if (i == 0 && i2 == 0) {
                ars Jx = ((y) kVar).Jx();
                if (Jx.mxP > 0) {
                    Intent intent = new Intent();
                    intent.setClass(this, ContactSearchResultUI.class);
                    try {
                        intent.putExtra("result", Jx.toByteArray());
                        startActivity(intent);
                        return;
                    } catch (Throwable e) {
                        v.a("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                        return;
                    }
                }
                String a = m.a(Jx.moM);
                Intent intent2 = new Intent();
                b.drq.a(intent2, Jx, Cx(this.khO.getText().toString().trim()));
                if (be.ma(a).length() > 0) {
                    if ((Jx.mFu & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(10298, a + "," + Cx(this.khO.getText().toString().trim()));
                    }
                    c.b(this, "profile", ".ui.ContactInfoUI", intent2);
                }
            } else {
                Toast.makeText(this, getString(2131232921), 0).show();
                v.w("MicroMsg.ContactSearchUI", getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
    }

    private static int Cx(String str) {
        if (be.Kw(str)) {
            return 1;
        }
        if (be.Kx(str)) {
            return 2;
        }
        return be.Ky(str) ? 3 : 3;
    }
}
