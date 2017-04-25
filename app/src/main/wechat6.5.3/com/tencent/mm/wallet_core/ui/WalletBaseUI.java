package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.b.g;
import com.tencent.mm.wallet_core.b.m;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class WalletBaseUI extends MMActivity implements c {
    private static g pjJ = null;
    public View hcJ;
    public a hcV;
    public MyKeyboardWindow mKeyboard;
    private OnMenuItemClickListener ovm;
    private b pjG = null;
    public f pjH = null;
    private d pjI = null;
    private OnMenuItemClickListener pjK;
    public boolean pjL = false;
    public Bundle uA = new Bundle();

    public abstract boolean d(int i, int i2, String str, k kVar);

    public final String bLx() {
        if (this.uA == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fTG;
        }
        return "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ak.uz()) {
            v.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            com.tencent.mm.ui.base.g.a(this, getString(2131235972), "", false, new OnClickListener(this) {
                final /* synthetic */ WalletBaseUI pjM;

                {
                    this.pjM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.b(this.pjM, null, -10000);
                }
            });
        }
        this.pjH = new f(this, this);
        this.pjH.gQ(385);
        this.pjH.gQ(1518);
        v.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        b ae = a.ae(this);
        if (ae != null) {
            this.pjH.mProcessName = ae.anS();
        }
        v.d("MicroMsg.WalletBaseUI", "proc " + ae);
        this.uA = a.ad(this);
        if (this.uA == null) {
            this.uA = new Bundle();
        }
        this.pjH.uA = this.uA;
        if (ayM() && !a.ac(this)) {
            v.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String string = getString(2131236646);
            if (!be.kS(string)) {
                NY(string);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBaseUI pjM;

            {
                this.pjM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.pjM.beY()) {
                    this.pjM.axg();
                    this.pjM.showDialog(BaseReportManager.MAX_READ_COUNT);
                } else {
                    this.pjM.finish();
                }
                return true;
            }
        });
        this.pjI = bLD();
        if (this.pjI != null && this.pjI.o(new Object[0])) {
            super.oa(4);
        } else if (getLayoutId() <= 0) {
            super.oa(4);
        } else if (ayJ()) {
            super.oa(4);
        } else {
            super.oa(0);
        }
    }

    public final int bLy() {
        return this.nDR.dtW.getVisibility();
    }

    public final void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.ovm = onMenuItemClickListener;
        super.b(onMenuItemClickListener);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.pjK = onMenuItemClickListener;
        super.a(i, str, onMenuItemClickListener);
    }

    public void onResume() {
        super.onResume();
        if (m.bLe()) {
            k bVar;
            if (com.tencent.mm.model.k.xT()) {
                bVar = new com.tencent.mm.wallet_core.d.a.b();
            } else {
                bVar = new com.tencent.mm.wallet_core.e.a.k();
            }
            this.pjH.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.pjH.gR(385);
        this.pjH.gR(1518);
    }

    public void b(int i, int i2, String str, k kVar, boolean z) {
        v.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(m.bLf());
        if (kVar instanceof g) {
            g gVar = (g) kVar;
            pjJ = gVar;
            if (this.uA != null) {
                if (gVar.kNL > 0) {
                    this.uA.putInt("key_is_gen_cert", gVar.kNL);
                }
                if (gVar.kNN > 0) {
                    this.uA.putInt("key_is_hint_crt", gVar.kNN);
                }
                if (gVar.kNP > 0) {
                    this.uA.putInt("key_is_ignore_cert", gVar.kNP);
                }
                if (!be.kS(gVar.kNM)) {
                    this.uA.putString("key_crt_token", gVar.kNM);
                }
                if (!be.kS(gVar.kNO)) {
                    this.uA.putString("key_crt_wording", gVar.kNO);
                }
            }
        }
        g(i, i2, str, kVar);
        f.a(this, i, i2, str, kVar, z);
    }

    public void nU(int i) {
    }

    public boolean g(int i, int i2, String str, k kVar) {
        return true;
    }

    public boolean ayM() {
        return true;
    }

    public boolean ayL() {
        return false;
    }

    public boolean ayJ() {
        if (getLayoutId() > 0 && !this.pjH.axG()) {
            return false;
        }
        return true;
    }

    public boolean beY() {
        return false;
    }

    public final void bLz() {
        PayInfo payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !be.kS(payInfo.gjT)) {
            this.pjH.a(new com.tencent.mm.wallet_core.b.d(payInfo.gjT, payInfo.fTG), true, true);
            payInfo.gjT = null;
        }
    }

    public boolean NS() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hcJ != null && this.hcJ.isShown()) {
                NP();
                return true;
            } else if (beY()) {
                axg();
                showDialog(BaseReportManager.MAX_READ_COUNT);
                return true;
            } else if (this.ovm != null && NS()) {
                this.ovm.onMenuItemClick(null);
                return true;
            } else if (this.pjK != null) {
                this.pjK.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean bkj() {
        if (this.ovm != null) {
            this.ovm.onMenuItemClick(null);
            return true;
        } else if (this.pjK == null) {
            return super.bkj();
        } else {
            this.pjK.onMenuItemClick(null);
            return true;
        }
    }

    public Dialog onCreateDialog(int i) {
        v.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + i);
        switch (i) {
            case BaseReportManager.MAX_READ_COUNT /*1000*/:
                int d;
                b ae = a.ae(this);
                if (ae != null) {
                    d = ae.d((MMActivity) this, 1);
                } else {
                    d = -1;
                }
                if (d != -1) {
                    return com.tencent.mm.ui.base.g.a(this, true, getString(d), "", getString(2131231183), getString(2131231104), new OnClickListener(this) {
                        final /* synthetic */ WalletBaseUI pjM;

                        {
                            this.pjM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.pjM.bLz();
                            b ae = a.ae(this.pjM);
                            if (ae == null) {
                                this.pjM.finish();
                            } else if (!ae.i(this.pjM, this.pjM.uA)) {
                                ae.d(this.pjM, this.pjM.uA);
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletBaseUI pjM;

                        {
                            this.pjM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            View findFocus = this.pjM.nDR.dtW == null ? null : this.pjM.nDR.dtW.findFocus();
                            if (findFocus != null && (findFocus instanceof EditText)) {
                                this.pjM.aJs();
                            }
                        }
                    });
                }
                if (ae != null) {
                    ae.d((Activity) this, this.uA);
                } else {
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void d(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    @TargetApi(14)
    public void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
        this.hcJ = findViewById(2131756016);
        View findViewById = findViewById(2131756018);
        final EditText editText = (EditText) view.findViewById(2131755077);
        if (this.mKeyboard != null && editText != null && this.hcJ != null) {
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ WalletBaseUI pjM;

                public final void onFocusChange(final View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ac().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 pjN;

                            {
                                this.pjN = r1;
                            }

                            public final void run() {
                                this.pjN.pjM.NP();
                                ((InputMethodManager) this.pjN.pjM.nDR.nEl.getSystemService("input_method")).showSoftInput(editText, 0);
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) this.pjM.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 pjN;

                        public final void run() {
                            if (!this.pjN.pjM.hcJ.isShown() && view.isShown() && (z4 || this.pjN.pjM.pjL)) {
                                this.pjN.pjM.pjL = true;
                                this.pjN.pjM.bLB();
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((com.tencent.mm.model.k.xT() || walletFormView.pko == 100) && (!com.tencent.mm.model.k.xT() || walletFormView.pko == 0)) {
                                    this.pjN.pjM.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
                                    this.pjN.pjM.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                this.pjN.pjM.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            this.pjN.pjM.yA(i2);
                            this.pjN.pjM.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) this.pjN.pjM.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletBaseUI pjM;

                public final void onClick(View view) {
                    if (!this.pjM.hcJ.isShown() && !z) {
                        this.pjM.bLB();
                        this.pjM.yA(i);
                    } else if (z) {
                        this.pjM.NP();
                        ((InputMethodManager) this.pjM.nDR.nEl.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletBaseUI pjM;

                {
                    this.pjM = r1;
                }

                public final void onClick(View view) {
                    this.pjM.NP();
                }
            });
        }
    }

    public final boolean ku(boolean z) {
        if (pjJ == null || (!pjJ.axX() && !z)) {
            return false;
        }
        this.pjH.a(pjJ, true);
        return true;
    }

    public static void bLA() {
        f.bLA();
    }

    public void NP() {
        if (this.hcJ.isShown()) {
            this.hcJ.setVisibility(8);
            if (this.hcV != null) {
                this.hcV.fd(false);
            }
        }
    }

    public final void bLB() {
        if (!this.hcJ.isShown()) {
            this.hcJ.setVisibility(0);
            if (this.hcV != null) {
                this.hcV.fd(true);
            }
        }
    }

    public final void yA(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final b bLC() {
        if (this.pjG == null) {
            this.pjG = a.ae(this);
        }
        return this.pjG;
    }

    public final d bLD() {
        if (this.pjI == null) {
            b bLC = bLC();
            if (bLC != null) {
                this.pjI = bLC.a(this, this.pjH);
            }
            if (this.pjI == null) {
                this.pjI = new d(this, this, this.pjH) {
                    final /* synthetic */ WalletBaseUI pjM;

                    public final boolean d(int i, int i2, String str, k kVar) {
                        return false;
                    }

                    public final boolean j(Object... objArr) {
                        return false;
                    }
                };
            }
        }
        return this.pjI;
    }

    public final CharSequence nK(int i) {
        if (this.pjI == null) {
            return null;
        }
        return this.pjI.nK(i);
    }

    public void beC() {
        bLC().a((Activity) this, 0, this.uA);
    }

    public final void gQ(int i) {
        this.pjH.gQ(i);
    }

    public final void gR(int i) {
        this.pjH.gR(i);
    }

    public final void b(k kVar, boolean z) {
        bLE();
        this.pjH.a(kVar, z, true);
    }

    public final void j(k kVar) {
        bLE();
        this.pjH.a(kVar, true, true);
    }

    public final void p(k kVar) {
        bLE();
        this.pjH.a(kVar, true);
    }

    public void bLE() {
        b bLC = bLC();
        if (bLC != null) {
            this.pjH.uA = bLC.fNM;
        }
    }

    public final void oa(int i) {
        super.oa(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                v.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                v.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
                setResult(0, getIntent());
            }
            finish();
        }
    }
}
