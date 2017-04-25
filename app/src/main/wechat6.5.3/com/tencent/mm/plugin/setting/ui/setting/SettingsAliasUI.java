package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.setting.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;

public class SettingsAliasUI extends MMActivity implements e {
    private String bLc;
    private ImageView dtX;
    private ProgressDialog dwR = null;
    private TextView euh;
    private TextView fST;
    private e iKG = null;
    private EditText iLO;
    private b iLP;
    private boolean iLQ = false;
    private TextView iLR;

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        if (settingsAliasUI.bLc.equals(k.xF())) {
            g.f(settingsAliasUI.nDR.nEl, 2131233885, 2131233883);
        } else if (be.Ky(settingsAliasUI.bLc)) {
            ActionBarActivity actionBarActivity = settingsAliasUI.nDR.nEl;
            settingsAliasUI.getString(2131233883);
            settingsAliasUI.dwR = g.a(actionBarActivity, settingsAliasUI.getString(2131233882), true, new OnCancelListener(settingsAliasUI) {
                final /* synthetic */ SettingsAliasUI iLS;

                {
                    this.iLS = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.iLS.iLP != null) {
                        ak.vy().c(this.iLS.iLP);
                    }
                }
            });
            if (settingsAliasUI.iLP != null) {
                ak.vy().c(settingsAliasUI.iLP);
            }
            settingsAliasUI.iLP = new b(settingsAliasUI.bLc);
            ak.vy().a(settingsAliasUI.iLP, 0);
        } else {
            g.f(settingsAliasUI.nDR.nEl, 2131235772, 2131234379);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLQ = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        NI();
        ak.vy().a(177, this);
    }

    protected final int getLayoutId() {
        return 2130904354;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        if (this.iLP != null) {
            ak.vy().c(this.iLP);
        }
        ak.vy().b(177, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131233883);
        this.dtX = (ImageView) findViewById(2131755508);
        this.euh = (TextView) findViewById(2131756539);
        this.iLR = (TextView) findViewById(2131758815);
        this.fST = (TextView) findViewById(2131759077);
        this.iLO = (EditText) findViewById(2131759076);
        String xF = k.xF();
        if (!u.LL(xF)) {
            this.iLO.setText(k.xF());
            this.iLR.setText(getString(2131230899, new Object[]{xF}));
        }
        this.iLO.setSelection(this.iLO.getText().length());
        this.iLO.setFocusable(true);
        this.iLO.setFocusableInTouchMode(true);
        this.iLO.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SettingsAliasUI iLS;

            {
                this.iLS = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SettingsAliasUI settingsAliasUI = this.iLS;
                a aVar = new a();
                if (charSequence.length() < 6 || charSequence.length() > 20) {
                    aVar.biS = settingsAliasUI.getString(2131235772);
                    aVar.baF = false;
                } else if (be.i(charSequence.charAt(0))) {
                    int length = charSequence.length() - 1;
                    while (length > 0) {
                        char charAt = charSequence.charAt(length);
                        if (be.i(charAt) || charAt == '-' || charAt == '_' || be.j(charAt)) {
                            length--;
                        } else if (Character.isSpace(charAt)) {
                            aVar.biS = settingsAliasUI.getString(2131235769);
                            aVar.baF = false;
                        } else if (be.d(charAt)) {
                            aVar.biS = settingsAliasUI.getString(2131235767);
                            aVar.baF = false;
                        } else {
                            aVar.biS = settingsAliasUI.getString(2131235772);
                            aVar.baF = false;
                        }
                    }
                    aVar.biS = settingsAliasUI.getString(2131233886);
                    aVar.baF = true;
                } else {
                    aVar.biS = settingsAliasUI.getString(2131235770);
                    aVar.baF = false;
                }
                if (aVar.baF) {
                    this.iLS.iT(true);
                    this.iLS.fST.setTextColor(this.iLS.getResources().getColorStateList(2131689792));
                } else {
                    this.iLS.iT(false);
                    this.iLS.fST.setTextColor(this.iLS.getResources().getColorStateList(2131689997));
                }
                this.iLS.fST.setText(aVar.biS);
                this.iLS.iLR.setText(this.iLS.getString(2131230899, new Object[]{charSequence}));
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.euh.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, be.ma(k.xH()), this.euh.getTextSize()));
        a.b.m(this.dtX, xF);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasUI iLS;

            {
                this.iLS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLS.axg();
                this.iLS.finish();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasUI iLS;

            {
                this.iLS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLS.bLc = this.iLS.iLO.getText().toString().trim();
                if (k.xF().equalsIgnoreCase(this.iLS.bLc)) {
                    this.iLS.axg();
                    this.iLS.finish();
                } else {
                    g.a(this.iLS.nDR.nEl, this.iLS.getString(2131233884, new Object[]{this.iLS.bLc}), this.iLS.getString(2131231983), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 iLT;

                        {
                            this.iLT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SettingsAliasUI.e(this.iLT.iLS);
                        }
                    }, null);
                }
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
        iT(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.v.k r9) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        if (r6 != 0) goto L_0x0042;
    L_0x0004:
        if (r7 != 0) goto L_0x0042;
    L_0x0006:
        r2 = r5.iLQ;
        if (r2 == 0) goto L_0x0014;
    L_0x000a:
        r2 = com.tencent.mm.plugin.report.service.g.iuh;
        r3 = 10358; // 0x2876 float:1.4515E-41 double:5.1175E-320;
        r4 = "1";
        r2.Y(r3, r4);
    L_0x0014:
        r5.axg();
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.vf();
        r3 = 42;
        r4 = r5.bLc;
        r2.set(r3, r4);
        r2 = com.tencent.mm.model.ak.vy();
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = new com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$5;
        r4.<init>(r5);
        r5.iKG = r4;
        r2.a(r3, r4);
        r2 = new com.tencent.mm.modelsimple.t;
        r2.<init>(r0);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r2, r1);
    L_0x0041:
        return;
    L_0x0042:
        r2 = r5.dwR;
        if (r2 == 0) goto L_0x004e;
    L_0x0046:
        r2 = r5.dwR;
        r2.dismiss();
        r2 = 0;
        r5.dwR = r2;
    L_0x004e:
        r2 = com.tencent.mm.plugin.setting.a.drq;
        r3 = r5.nDR;
        r3 = r3.nEl;
        r2 = r2.a(r3, r6, r7, r8);
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        if (r0 == 0) goto L_0x0041;
    L_0x005c:
        goto L_0x0041;
    L_0x005d:
        switch(r6) {
            case 4: goto L_0x0062;
            default: goto L_0x0060;
        };
    L_0x0060:
        r0 = r1;
        goto L_0x005a;
    L_0x0062:
        r2 = -7;
        if (r7 == r2) goto L_0x0069;
    L_0x0065:
        r2 = -10;
        if (r7 != r2) goto L_0x0060;
    L_0x0069:
        r1 = r5.nDR;
        r1 = r1.nEl;
        r2 = 2131234377; // 0x7f080e49 float:1.8084918E38 double:1.052969689E-314;
        r3 = 2131233887; // 0x7f080c5f float:1.8083924E38 double:1.052969447E-314;
        com.tencent.mm.ui.base.g.f(r1, r2, r3);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }
}
