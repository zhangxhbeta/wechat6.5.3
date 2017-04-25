package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.w;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Map;

public class RegByEmailUI extends MMActivity implements e {
    private static String[] nKl;
    private String bCc;
    private ProgressDialog dwR = null;
    private String ivg;
    private CheckBox lPH;
    private String nJH;
    private MMAutoCompleteTextView nKh;
    private EditText nKi;
    private String nKj;
    private Map<String, String> nKk;

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        if (be.kS(regByEmailUI.nKh.getText().toString().trim()) || be.kS(regByEmailUI.nKi.getText().toString().trim()) || !regByEmailUI.lPH.isChecked()) {
            regByEmailUI.iT(false);
        } else {
            regByEmailUI.iT(true);
        }
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        regByEmailUI.bCc = regByEmailUI.nKh.getText().toString().trim();
        regByEmailUI.nJH = regByEmailUI.nKi.getText().toString();
        if (be.kS(regByEmailUI.bCc)) {
            g.f(regByEmailUI, 2131234389, 2131234385);
        } else if (!be.Kx(regByEmailUI.bCc)) {
            g.f(regByEmailUI, 2131234388, 2131234385);
        } else if (be.kS(regByEmailUI.nJH)) {
            g.f(regByEmailUI, 2131234390, 2131234385);
        } else if (be.Kz(regByEmailUI.nJH)) {
            regByEmailUI.axg();
            final k wVar = new w(regByEmailUI.bCc, regByEmailUI.nJH);
            ak.vy().a(wVar, 0);
            regByEmailUI.getString(2131231164);
            regByEmailUI.dwR = g.a((Context) regByEmailUI, regByEmailUI.getString(2131231182), true, new OnCancelListener(regByEmailUI) {
                final /* synthetic */ RegByEmailUI nKm;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(wVar);
                }
            });
        } else {
            g.f(regByEmailUI, 2131235781, 2131234385);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(2131234398);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        a.drq.oz();
        this.nKj = com.tencent.mm.modelsimple.d.be(this);
        v.i("MicroMsg.RegByEmailUI", "get google account:[%s]", this.nKj);
        this.nKk = com.tencent.mm.plugin.accountsync.b.a.dwt.bp(this);
        if (!(this.nKk == null || this.nKk.isEmpty())) {
            nKl = new String[this.nKk.size()];
            this.nKk.keySet().toArray(nKl);
        }
        this.ivg = b.Oa();
        NI();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(481, (e) this);
        b.b(true, ak.uR() + "," + getClass().getName() + ",R500_100," + ak.dR("R500_100") + ",1");
        b.mh("R500_100");
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(481, (e) this);
        b.b(false, ak.uR() + "," + getClass().getName() + ",R500_100," + ak.dR("R500_100") + ",2");
    }

    protected final int getLayoutId() {
        return 2130904265;
    }

    protected final void NI() {
        this.nKh = (MMAutoCompleteTextView) findViewById(2131758852);
        this.nKi = (EditText) findViewById(2131758853);
        this.lPH = (CheckBox) findViewById(2131758285);
        if (!be.kS(this.nKj)) {
            this.nKi.postDelayed(new Runnable(this) {
                final /* synthetic */ RegByEmailUI nKm;

                {
                    this.nKm = r1;
                }

                public final void run() {
                    this.nKm.nKi.requestFocus();
                }
            }, 500);
            this.nKh.setText(this.nKj);
        }
        if (nKl != null) {
            ListAdapter cVar = new c(this, nKl, "@");
            MMAutoCompleteTextView mMAutoCompleteTextView = this.nKh;
            String str = "@";
            if (!be.kS(str)) {
                mMAutoCompleteTextView.nUo = new a(mMAutoCompleteTextView, str);
                mMAutoCompleteTextView.addTextChangedListener(mMAutoCompleteTextView.nUo);
            }
            this.nKh.setDropDownAnchor(2131758851);
            this.nKh.setDropDownVerticalOffset(this.nKh.getPaddingBottom());
            this.nKh.setAdapter(cVar);
        }
        findViewById(2131758286).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final void onClick(View view) {
                be.E(this.nKm, this.nKm.getString(2131235735));
            }
        });
        this.lPH.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegByEmailUI.b(this.nKm);
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByEmailUI.c(this.nKm);
                return true;
            }
        });
        iT(false);
        this.nKh.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final void afterTextChanged(Editable editable) {
                RegByEmailUI.b(this.nKm);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nKi.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final void afterTextChanged(Editable editable) {
                RegByEmailUI.b(this.nKm);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nKi.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i != 6 && i != 5) || !this.nKm.lPH.isChecked()) {
                    return false;
                }
                RegByEmailUI.c(this.nKm);
                return true;
            }
        });
        this.nKi.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0 || !this.nKm.lPH.isChecked()) {
                    return false;
                }
                RegByEmailUI.c(this.nKm);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKm.goBack();
                return true;
            }
        });
    }

    private void goBack() {
        g.a((Context) this, 2131234382, 2131234385, 2131231107, 2131231010, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RegByEmailUI nKm;

            {
                this.nKm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                b.mi(this.nKm.ivg);
                this.nKm.axg();
                this.nKm.finish();
            }
        }, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() != 481) {
            v.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
        } else if (i == 0 && i2 == 0) {
            b.mi("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.bCc);
            intent.putExtra("password", this.nJH);
            if (!(this.nKk == null || this.nKk.isEmpty())) {
                String[] split = this.bCc.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.nKk.get(split[1]));
                }
            }
            startActivity(intent);
        } else {
            int i3;
            if (!a.drq.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        g.f(this, 2131234388, 2131234385);
                        i3 = 1;
                        break;
                    case -75:
                        g.f(this, 2131230895, 2131234378);
                        i3 = 1;
                        break;
                    case -34:
                        Toast.makeText(this, 2131234383, 0).show();
                        i3 = 1;
                        break;
                    case -7:
                        b.mj(ak.uR() + "," + getClass().getName() + ",R20_email_duplicate_confirm," + ak.dR("R20_email_duplicate_confirm") + ",3");
                        g.a((Context) this, 2131234399, 2131234385, 2131234401, 2131234400, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByEmailUI nKm;

                            {
                                this.nKm = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.nKm.finish();
                                b.mi("L2_signup");
                                Intent intent = new Intent(this.nKm, LoginHistoryUI.class);
                                intent.putExtra("email_address", this.nKm.bCc);
                                this.nKm.startActivity(intent);
                            }
                        }, null);
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
            }
            i3 = 1;
            if (i3 == 0) {
                if (!be.kS(str)) {
                    Map q = bf.q(str, "e");
                    if (q != null && q.size() > 0) {
                        String str2 = (String) q.get(".e.Content");
                        if (!be.kS(str2)) {
                            g.A(this, str2, getString(2131234385));
                            return;
                        }
                    }
                }
                Toast.makeText(this, getString(2131234396, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
