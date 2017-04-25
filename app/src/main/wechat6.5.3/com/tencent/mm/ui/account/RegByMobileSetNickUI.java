package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.e;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements e {
    private String bhT;
    private ProgressDialog dwR = null;
    private EditText nKY;
    private i nKZ = null;
    private boolean nLa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nLa = getIntent().getBooleanExtra("is_sync_addr", false);
        this.bhT = getIntent().getExtras().getString("bindmcontact_mobile");
        NI();
        ak.vy().a(126, this);
    }

    public void onDestroy() {
        if (this.nKZ != null) {
            i iVar = this.nKZ;
            s sVar = iVar.nKg;
            sVar.cancel();
            sVar.aSW.QI();
            sVar.reset();
            iVar.text = null;
        }
        ak.vy().b(126, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904270;
    }

    protected final void NI() {
        vD(2131234427);
        this.nKY = (EditText) findViewById(2131758864);
        this.nKY.addTextChangedListener(new c(this.nKY, null, 16));
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileSetNickUI nLb;

            {
                this.nLb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.nLb.nKY.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    g.f(this.nLb, 2131235771, 2131234430);
                } else {
                    this.nLb.axg();
                    final u uVar = new u("", this.nLb.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", this.nLb.bhT, this.nLb.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    ak.vy().a(uVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = this.nLb;
                    RegByMobileSetNickUI regByMobileSetNickUI2 = this.nLb;
                    this.nLb.getString(2131231164);
                    regByMobileSetNickUI.dwR = g.a(regByMobileSetNickUI2, this.nLb.getString(2131234461), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 nLd;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(uVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileSetNickUI nLb;

            {
                this.nLb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLb.axg();
                this.nLb.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.v.k r12) {
        /*
        r8 = this;
        r7 = 2131234378; // 0x7f080e4a float:1.808492E38 double:1.0529696894E-314;
        r2 = 2;
        r6 = 0;
        r3 = 0;
        r1 = 1;
        r0 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "onSceneEnd: errType = ";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r5 = " errCode = ";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r5 = " errMsg = ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r4);
        r0 = r8.dwR;
        if (r0 == 0) goto L_0x003e;
    L_0x0037:
        r0 = r8.dwR;
        r0.dismiss();
        r8.dwR = r6;
    L_0x003e:
        r0 = com.tencent.mm.sdk.platformtools.be.bm(r8);
        if (r0 != 0) goto L_0x0045;
    L_0x0044:
        return;
    L_0x0045:
        if (r9 != 0) goto L_0x0107;
    L_0x0047:
        if (r10 != 0) goto L_0x0107;
    L_0x0049:
        r0 = com.tencent.mm.model.k.xJ();
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile status = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r5 = " isSync = ";
        r4 = r4.append(r5);
        r5 = r8.nLa;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r4);
        r3 = r8.nLa;
        if (r3 == 0) goto L_0x00f5;
    L_0x0074:
        r3 = -131073; // 0xfffffffffffdffff float:NaN double:NaN;
        r0 = r0 & r3;
        com.tencent.mm.modelfriend.m.EV();
        r8.getApplicationContext();
        com.tencent.mm.modelfriend.a.Ew();
    L_0x0081:
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile update = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r4);
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.vf();
        r4 = 7;
        r0 = java.lang.Integer.valueOf(r0);
        r3.set(r4, r0);
        r0 = r8.nLa;
        if (r0 != 0) goto L_0x00f9;
    L_0x00aa:
        r0 = r1;
    L_0x00ab:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wG();
        r3 = new com.tencent.mm.ak.g;
        r4 = 17;
        r3.<init>(r4, r0);
        r2.b(r3);
        r0 = com.tencent.mm.plugin.a.a.drq;
        r0.ow();
        r0 = com.tencent.mm.model.ai.cse;
        r2 = "login_user_name";
        r3 = r8.bhT;
        r0.J(r2, r3);
        r0 = com.tencent.mm.plugin.a.a.drp;
        r0 = r0.ak(r8);
        r2 = "LauncherUI.enter_from_reg";
        r0.putExtra(r2, r1);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r0.addFlags(r2);
        r12 = (com.tencent.mm.modelsimple.u) r12;
        r2 = r12.cZi;
        if (r2 == 0) goto L_0x00fb;
    L_0x00e2:
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.ui.bindqq.BindQQUI.class;
        r2.<init>(r8, r3);
        r3 = "bindqq_regbymobile";
        r1 = r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r8, r1, r0);
        goto L_0x0044;
    L_0x00f5:
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 | r3;
        goto L_0x0081;
    L_0x00f9:
        r0 = r2;
        goto L_0x00ab;
    L_0x00fb:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.account.BindFacebookUI.class;
        r1.<init>(r8, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r8, r1, r0);
        goto L_0x0044;
    L_0x0107:
        r0 = r12.getType();
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r0 != r4) goto L_0x011a;
    L_0x010f:
        r0 = com.tencent.mm.f.a.dm(r11);
        if (r0 == 0) goto L_0x011a;
    L_0x0115:
        r0.a(r8, r6, r6);
        goto L_0x0044;
    L_0x011a:
        r0 = com.tencent.mm.plugin.a.a.drq;
        r4 = r8.nDR;
        r4 = r4.nEl;
        r0 = r0.a(r4, r9, r10, r11);
        if (r0 == 0) goto L_0x0147;
    L_0x0126:
        r0 = r1;
    L_0x0127:
        if (r0 != 0) goto L_0x0044;
    L_0x0129:
        r0 = 2131232915; // 0x7f080893 float:1.8081953E38 double:1.0529689666E-314;
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r9);
        r2[r3] = r4;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r1] = r4;
        r0 = r8.getString(r0, r2);
        r0 = android.widget.Toast.makeText(r8, r0, r3);
        r0.show();
        goto L_0x0044;
    L_0x0147:
        switch(r9) {
            case 4: goto L_0x014c;
            default: goto L_0x014a;
        };
    L_0x014a:
        r0 = r3;
        goto L_0x0127;
    L_0x014c:
        r0 = -7;
        if (r10 == r0) goto L_0x0153;
    L_0x014f:
        r0 = -10;
        if (r10 != r0) goto L_0x015b;
    L_0x0153:
        r0 = 2131234377; // 0x7f080e49 float:1.8084918E38 double:1.052969689E-314;
        com.tencent.mm.ui.base.g.f(r8, r0, r7);
        r0 = r1;
        goto L_0x0127;
    L_0x015b:
        r0 = -75;
        if (r10 != r0) goto L_0x014a;
    L_0x015f:
        r0 = 2131230895; // 0x7f0800af float:1.8077856E38 double:1.0529679686E-314;
        com.tencent.mm.ui.base.g.f(r8, r0, r7);
        r0 = r1;
        goto L_0x0127;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegByMobileSetNickUI.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }
}
