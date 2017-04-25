package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mmdb.database.SQLiteDatabase;

public class SimpleLoginUI extends MMWizardActivity implements e {
    private String bpX = SQLiteDatabase.KeyEmpty;
    private ProgressDialog dwR = null;
    private EditText fAv;
    private String ivc;
    private SecurityImage nFq = null;
    private EditText nJR;
    private MMFormInputView nJS;
    private MMFormInputView nJT;
    private Button nJU;
    private f nJh = new f();
    private String nJi;
    private String nJj;

    protected final int getLayoutId() {
        return 2130903871;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", 4);
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        vD(2131230720);
        if (a.drq != null) {
            a.drq.oz();
        }
        NI();
        ak.vy().a(701, (e) this);
    }

    public void onDestroy() {
        ak.vy().b(701, (e) this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.ivc = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.ivc = extras.getString("auth_ticket");
        }
        if (!be.kS(this.ivc)) {
            this.nJR.setText(be.ma(f.bAR()));
            this.fAv.setText(be.ma(f.bAS()));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ SimpleLoginUI nMH;

                {
                    this.nMH = r1;
                }

                public final void run() {
                    this.nMH.apN();
                }
            }, 500);
        }
    }

    protected final void NI() {
        this.nJS = (MMFormInputView) findViewById(2131757719);
        this.nJT = (MMFormInputView) findViewById(2131757720);
        this.nJR = this.nJS.idd;
        this.nJR.requestFocus();
        this.fAv = this.nJT.idd;
        this.nJU = (Button) findViewById(2131757721);
        findViewById(2131757722).setVisibility(8);
        View findViewById = findViewById(2131757723);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        vD(2131233569);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SimpleLoginUI nMH;

            {
                this.nMH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nMH.aKM();
                return true;
            }
        });
        this.ivc = getIntent().getStringExtra("auth_ticket");
        if (!be.kS(this.ivc)) {
            this.nJR.setText(be.ma(f.bAR()));
            this.fAv.setText(be.ma(f.bAS()));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ SimpleLoginUI nMH;

                {
                    this.nMH = r1;
                }

                public final void run() {
                    this.nMH.apN();
                }
            }, 500);
        }
        if (f.nhZ) {
            a.drq.d(this);
        }
        this.nJU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SimpleLoginUI nMH;

            {
                this.nMH = r1;
            }

            public final void onClick(View view) {
                this.nMH.apN();
            }
        });
    }

    private void aKM() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        bAv();
        if (booleanExtra) {
            exit(1);
        }
    }

    private void apN() {
        this.nJh.cYN = this.nJR.getText().toString().trim();
        this.nJh.nJH = this.fAv.getText().toString();
        if (this.nJh.cYN.equals(SQLiteDatabase.KeyEmpty)) {
            g.f(this, 2131235782, 2131233557);
        } else if (this.nJh.nJH.equals(SQLiteDatabase.KeyEmpty)) {
            g.f(this, 2131235780, 2131233557);
        } else {
            axg();
            final k sVar = new s(this.nJh.cYN, this.nJh.nJH, this.ivc, 0);
            ak.vy().a(sVar, 0);
            getString(2131231164);
            this.dwR = g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ SimpleLoginUI nMH;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    protected void onPause() {
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        super.onPause();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.v.k r13) {
        /*
        r9 = this;
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd: errType = ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " errMsg = ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "Scene Type ";
        r1.<init>(r2);
        r2 = r13.getType();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = r9.dwR;
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r9.dwR;
        r0.dismiss();
        r0 = 0;
        r9.dwR = r0;
    L_0x0052:
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Jh();
        r9.bpX = r0;
        r1 = 0;
        r0 = r13.getType();
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r2) goto L_0x02ea;
    L_0x0064:
        r2 = r9.nJh;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Ji();
        r2.nJM = r0;
        r2 = r9.nJh;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Fw();
        r2.nJJ = r0;
        r2 = r9.nJh;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Fv();
        r2.nJL = r0;
        r2 = r9.nJh;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Jj();
        r2.nJK = r0;
        r0 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r11 != r0) goto L_0x00af;
    L_0x0094:
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Fj();
        r9.ivc = r0;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Jk();
        r9.nJi = r0;
        r0 = r13;
        r0 = (com.tencent.mm.modelsimple.s) r0;
        r0 = r0.Jn();
        r9.nJj = r0;
    L_0x00af:
        r0 = 4;
        if (r10 != r0) goto L_0x02ea;
    L_0x00b2:
        r0 = -16;
        if (r11 == r0) goto L_0x00ba;
    L_0x00b6:
        r0 = -17;
        if (r11 != r0) goto L_0x02ea;
    L_0x00ba:
        r0 = 1;
        r1 = com.tencent.mm.model.ak.vy();
        r2 = new com.tencent.mm.model.ay;
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$2;
        r3.<init>(r9);
        r2.<init>(r3);
        r3 = 0;
        r1.a(r2, r3);
    L_0x00cd:
        if (r0 != 0) goto L_0x00d3;
    L_0x00cf:
        if (r10 != 0) goto L_0x0155;
    L_0x00d1:
        if (r11 != 0) goto L_0x0155;
    L_0x00d3:
        com.tencent.mm.model.ak.unhold();
        com.tencent.mm.modelsimple.d.aX(r9);
        r0 = r9.nJh;
        r0 = r0.cYN;
        com.tencent.mm.platformtools.l.lX(r0);
        r0 = r9.nDR;
        r0 = r0.nEl;
        r1 = new com.tencent.mm.ui.account.SimpleLoginUI$3;
        r1.<init>(r9);
        r2 = new com.tencent.mm.plugin.accountsync.a.b;
        r2.<init>(r0, r1);
        r0 = com.tencent.mm.plugin.a.a.drq;
        r0 = r0.a(r2);
        r2.aZJ = r0;
        r0 = r2.aZJ;
        if (r0 != 0) goto L_0x0104;
    L_0x00fa:
        r0 = r2.dwh;
        if (r0 == 0) goto L_0x0103;
    L_0x00fe:
        r0 = r2.dwh;
        r0.Ob();
    L_0x0103:
        return;
    L_0x0104:
        r0 = r2.aZJ;
        r0 = r0.getType();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        if (r0 != r1) goto L_0x0141;
    L_0x010e:
        r0 = com.tencent.mm.model.ak.vy();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r0.a(r1, r2);
    L_0x0117:
        r0 = com.tencent.mm.model.ak.vy();
        r1 = r2.aZJ;
        r3 = 0;
        r0.a(r1, r3);
        r0 = r2.context;
        r1 = r2.context;
        r3 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r1.getString(r3);
        r1 = r2.context;
        r3 = 2131231085; // 0x7f08016d float:1.8078241E38 double:1.0529680624E-314;
        r1 = r1.getString(r3);
        r3 = 1;
        r4 = new com.tencent.mm.plugin.accountsync.a.b$1;
        r4.<init>(r2);
        r0 = com.tencent.mm.ui.base.g.a(r0, r1, r3, r4);
        r2.dwg = r0;
        goto L_0x0103;
    L_0x0141:
        r0 = r2.aZJ;
        r0 = r0.getType();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        if (r0 != r1) goto L_0x0117;
    L_0x014b:
        r0 = com.tencent.mm.model.ak.vy();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r0.a(r1, r2);
        goto L_0x0117;
    L_0x0155:
        r0 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        if (r11 != r0) goto L_0x0163;
    L_0x0159:
        r13 = (com.tencent.mm.modelsimple.s) r13;
        r0 = r13.Jg();
        com.tencent.mm.platformtools.l.a(r9, r0, r11);
        goto L_0x0103;
    L_0x0163:
        r0 = com.tencent.mm.plugin.a.a.drq;
        r1 = r9.nDR;
        r1 = r1.nEl;
        r0 = r0.a(r1, r10, r11, r12);
        if (r0 == 0) goto L_0x01a2;
    L_0x016f:
        r0 = 1;
    L_0x0170:
        if (r0 != 0) goto L_0x0103;
    L_0x0172:
        r0 = com.tencent.mm.f.a.dm(r12);
        if (r0 == 0) goto L_0x0180;
    L_0x0178:
        r1 = 0;
        r2 = 0;
        r0 = r0.a(r9, r1, r2);
        if (r0 != 0) goto L_0x0103;
    L_0x0180:
        r0 = 2131232858; // 0x7f08085a float:1.8081837E38 double:1.0529689384E-314;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r10);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r0 = r9.getString(r0, r1);
        r1 = 0;
        r0 = android.widget.Toast.makeText(r9, r0, r1);
        r0.show();
        goto L_0x0103;
    L_0x01a2:
        r0 = 4;
        if (r10 != r0) goto L_0x01a8;
    L_0x01a5:
        switch(r11) {
            case -311: goto L_0x01ee;
            case -310: goto L_0x01ee;
            case -205: goto L_0x0289;
            case -140: goto L_0x02d4;
            case -106: goto L_0x02e4;
            case -100: goto L_0x026b;
            case -75: goto L_0x01e5;
            case -72: goto L_0x01d6;
            case -30: goto L_0x01c0;
            case -9: goto L_0x01cb;
            case -6: goto L_0x01ee;
            case -4: goto L_0x01c0;
            case -3: goto L_0x01c0;
            case -1: goto L_0x01aa;
            default: goto L_0x01a8;
        };
    L_0x01a8:
        r0 = 0;
        goto L_0x0170;
    L_0x01aa:
        r0 = com.tencent.mm.model.ak.vy();
        r0 = r0.BJ();
        r1 = 5;
        if (r0 != r1) goto L_0x01c0;
    L_0x01b5:
        r0 = 2131234021; // 0x7f080ce5 float:1.8084196E38 double:1.052969513E-314;
        r1 = 2131234020; // 0x7f080ce4 float:1.8084194E38 double:1.0529695125E-314;
        com.tencent.mm.ui.base.g.f(r9, r0, r1);
        r0 = 1;
        goto L_0x0170;
    L_0x01c0:
        r0 = 2131232483; // 0x7f0806e3 float:1.8081077E38 double:1.052968753E-314;
        r1 = 2131233557; // 0x7f080b15 float:1.8083255E38 double:1.052969284E-314;
        com.tencent.mm.ui.base.g.f(r9, r0, r1);
        r0 = 1;
        goto L_0x0170;
    L_0x01cb:
        r0 = 2131233556; // 0x7f080b14 float:1.8083253E38 double:1.0529692833E-314;
        r1 = 2131233557; // 0x7f080b15 float:1.8083255E38 double:1.052969284E-314;
        com.tencent.mm.ui.base.g.f(r9, r0, r1);
        r0 = 1;
        goto L_0x0170;
    L_0x01d6:
        r0 = r9.nDR;
        r0 = r0.nEl;
        r1 = 2131234451; // 0x7f080e93 float:1.8085068E38 double:1.0529697255E-314;
        r2 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        com.tencent.mm.ui.base.g.f(r0, r1, r2);
        r0 = 1;
        goto L_0x0170;
    L_0x01e5:
        r0 = r9.nDR;
        r0 = r0.nEl;
        com.tencent.mm.platformtools.l.bl(r0);
        r0 = 1;
        goto L_0x0170;
    L_0x01ee:
        r0 = r9.nFq;
        if (r0 != 0) goto L_0x021c;
    L_0x01f2:
        r0 = r9.nDR;
        r0 = r0.nEl;
        r1 = r9.nJh;
        r1 = r1.nJM;
        r2 = r9.nJh;
        r2 = r2.nJL;
        r3 = r9.nJh;
        r3 = r3.nJJ;
        r4 = r9.nJh;
        r4 = r4.nJK;
        r5 = new com.tencent.mm.ui.account.SimpleLoginUI$8;
        r5.<init>(r9);
        r6 = 0;
        r7 = new com.tencent.mm.ui.account.SimpleLoginUI$9;
        r7.<init>(r9);
        r8 = r9.nJh;
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r9.nFq = r0;
    L_0x0219:
        r0 = 1;
        goto L_0x0170;
    L_0x021c:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r9.nJh;
        r2 = r2.nJJ;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r9.nJh;
        r2 = r2.nJL;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.sm();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = r9.nFq;
        r1 = r9.nJh;
        r1 = r1.nJM;
        r2 = r9.nJh;
        r2 = r2.nJL;
        r3 = r9.nJh;
        r3 = r3.nJJ;
        r4 = r9.nJh;
        r4 = r4.nJK;
        r0.a(r1, r2, r3, r4);
        goto L_0x0219;
    L_0x026b:
        com.tencent.mm.model.ak.hold();
        r0 = com.tencent.mm.model.ak.uA();
        r1 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r1 = r9.getString(r1);
        r2 = new com.tencent.mm.ui.account.SimpleLoginUI$10;
        r2.<init>(r9);
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$11;
        r3.<init>(r9);
        com.tencent.mm.ui.base.g.a(r9, r0, r1, r2, r3);
        r0 = 1;
        goto L_0x0170;
    L_0x0289:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r9.ivc;
        r4 = com.tencent.mm.sdk.platformtools.be.KW(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r9.nJj;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r9.nJh;
        com.tencent.mm.ui.account.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r9.ivc;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r9.nJi;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r9.nJj;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r2 = 3;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.plugin.a.a.drp;
        r1.f(r9, r0);
        r0 = 1;
        goto L_0x0170;
    L_0x02d4:
        r0 = r9.bpX;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02e1;
    L_0x02dc:
        r0 = r9.bpX;
        com.tencent.mm.platformtools.l.j(r9, r12, r0);
    L_0x02e1:
        r0 = 1;
        goto L_0x0170;
    L_0x02e4:
        com.tencent.mm.platformtools.l.D(r9, r12);
        r0 = 1;
        goto L_0x0170;
    L_0x02ea:
        r0 = r1;
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.SimpleLoginUI.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        v.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(be.kS(stringExtra));
            if (!be.kS(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            v.d(str2, str3, objArr2);
            if (intExtra == -217) {
                apN();
            }
        }
    }
}
