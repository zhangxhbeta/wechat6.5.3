package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.b.j;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String fTP;
    public EditHintPasswdView kTr;
    private boolean kTs = false;
    private boolean kTt = false;
    private boolean kTu = false;
    private String kTv;

    protected final int getLayoutId() {
        return 2130904634;
    }

    public void onCreate(Bundle bundle) {
        String charSequence;
        WalletCheckPwdUI walletCheckPwdUI;
        int i;
        super.onCreate(bundle);
        CharSequence nK = nK(1);
        if (!be.D(nK)) {
            charSequence = nK.toString();
            walletCheckPwdUI = this;
        } else if (k.xT()) {
            charSequence = getString(2131236147);
            walletCheckPwdUI = this;
        } else {
            charSequence = getString(2131236146);
            walletCheckPwdUI = this;
        }
        walletCheckPwdUI.Fd(charSequence);
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            b ae = com.tencent.mm.wallet_core.a.ae(this);
            if (ae != null) {
                int i2 = ae.fNM.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(ae.anS());
                this.kTu = z;
                i = i2;
            } else {
                i = -1;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            this.kTt = true;
            v.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            Bundle bundle2 = null;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            com.tencent.mm.v.k aVar;
            if (this.kTu) {
                b ae2 = com.tencent.mm.wallet_core.a.ae(this);
                if (ae2 != null) {
                    bundle2 = ae2.fNM;
                }
                if (bundle2 == null) {
                    v.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString("url");
                if (this.kTu) {
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 5);
                } else {
                    v.i("Micromsg.WalletCheckPwdUI", "appId is null? " + be.kS(string));
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 10);
                }
                p(aVar);
            } else if (getIntent() == null) {
                v.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString("url");
                if (this.kTu) {
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 5);
                } else {
                    v.i("Micromsg.WalletCheckPwdUI", "appId is null? " + be.kS(string));
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 10);
                }
                p(aVar);
            }
            NI();
        } else {
            oa(0);
            if (!this.uA.getBoolean("key_is_expired_bankcard", false)) {
                NI();
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCheckPwdUI kTw;

            {
                this.kTw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                b bLC = this.kTw.bLC();
                v.i("Micromsg.WalletCheckPwdUI", "onbackbtn click");
                if (bLC != null) {
                    if (bLC instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
                        bLC.d(this.kTw, 0);
                    } else if (this.kTw.kTu) {
                        bLC.fNM.putInt("key_process_result_code", 0);
                        bLC.d(this.kTw, bLC.fNM);
                    }
                }
                this.kTw.finish();
                return false;
            }
        });
    }

    public void onResume() {
        if (this.kTr != null) {
            this.kTr.aJx();
        }
        gQ(580);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        gR(580);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        TextView textView = (TextView) findViewById(2131759758);
        CharSequence nK = nK(0);
        if (be.D(nK)) {
            textView.setText(2131236145);
        } else {
            textView.setText(nK);
            if (nK instanceof SpannableString) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        this.kTr = (EditHintPasswdView) findViewById(2131758506);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kTr);
        this.kTr.pkg = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletCheckPwdUI kTw;

            {
                this.kTw = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    this.kTw.fTP = this.kTw.kTr.getText();
                    b ae = com.tencent.mm.wallet_core.a.ae(this.kTw);
                    Object obj = null;
                    if (ae != null) {
                        obj = ae.anS();
                    }
                    if (!this.kTw.kTt || "UnbindProcess".equals(r0)) {
                        if (!this.kTw.bLD().j(this.kTw.fTP, this.kTw.bLx())) {
                            this.kTw.j(new i(this.kTw.fTP, 1, this.kTw.bLx()));
                            return;
                        }
                        return;
                    }
                    this.kTw.j(new j(this.kTw.fTP, this.kTw.kTv));
                }
            }
        };
        d(this.kTr, 0, false);
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof i) {
                Bundle bundle = this.uA;
                bundle.putString("key_pwd1", this.kTr.getText());
                com.tencent.mm.wallet_core.a.k(this, bundle);
                if (this.kTr != null) {
                    this.kTr.aJx();
                }
                finish();
            } else if (kVar instanceof l) {
                g.bf(this, getString(2131236149));
                b ae = com.tencent.mm.wallet_core.a.ae(this);
                if (ae != null) {
                    ae.fNM.putInt("key_process_result_code", -1);
                }
                com.tencent.mm.wallet_core.a.k(this, ae.fNM);
                if (this.kTr != null) {
                    this.kTr.aJx();
                }
                finish();
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                this.kTv = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).axY();
                setResult(-1);
                oa(0);
            } else if (kVar instanceof j) {
                j jVar = (j) kVar;
                if (jVar.bfB()) {
                    v.i("Micromsg.WalletCheckPwdUI", "need free sms");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_pwd1", this.fTP);
                    bundle2.putString("key_jsapi_token", this.kTv);
                    bundle2.putString("key_relation_key", jVar.kLq);
                    bundle2.putString("key_mobile", jVar.kLp);
                    com.tencent.mm.wallet_core.a.a((Activity) this, j.class, bundle2, new b.a(this) {
                        final /* synthetic */ WalletCheckPwdUI kTw;

                        {
                            this.kTw = r1;
                        }

                        public final Intent e(int i, Bundle bundle) {
                            Intent intent = new Intent();
                            intent.putExtra("token", bundle.getString("key_jsapi_token"));
                            intent.putExtra("key_process_result_code", i);
                            intent.setClass(this.kTw.nDR.nEl, WalletCheckPwdUI.class);
                            intent.addFlags(536870912);
                            intent.putExtra("key_process_is_stay", false);
                            return intent;
                        }
                    });
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", ((j) kVar).kLn);
                    setResult(-1, intent);
                    finish();
                }
            }
            return true;
        }
        if (this.kTr != null) {
            this.kTr.aJx();
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        }
        v.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
        b ae2 = com.tencent.mm.wallet_core.a.ae(this);
        if (ae2 == null || !ae2.anS().equals("UnbindProcess")) {
            setResult(0);
            finish();
        } else {
            setResult(1);
            ae2.fNM.putInt("key_process_result_code", 1);
            com.tencent.mm.wallet_core.a.k(this, ae2.fNM);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.hcJ == null || !this.hcJ.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.hcJ.setVisibility(8);
        return true;
    }

    public boolean beY() {
        if (this.uA.getInt("key_pay_flag", 0) != 0) {
            return true;
        }
        return false;
    }

    public final void nU(int i) {
        if (this.kTs) {
            finish();
        } else if (this.kTr != null) {
            this.kTr.aJx();
        }
    }

    public final boolean ayJ() {
        return this.kTs;
    }

    public int NO() {
        return 1;
    }
}
