package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int duq = a.fromDPToPix(aa.getContext(), 300);
    private c cll = new c();
    protected View dup;

    static /* synthetic */ void a(BaseAAPresenterActivity baseAAPresenterActivity, EditText editText) {
        if (baseAAPresenterActivity.dup != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            int height = r1 - (iArr[1] + editText.getHeight());
            v.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + editText.getHeight()), Integer.valueOf(baseAAPresenterActivity.getWindow().getDecorView().getHeight() - baseAAPresenterActivity.cU().cV().getHeight()), Integer.valueOf(height), Integer.valueOf(duq)});
            if (height > 0 && height < duq) {
                v.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf((duq - height) + a.fromDPToPix(baseAAPresenterActivity, 5))});
                baseAAPresenterActivity.dup.scrollBy(0, r0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cll.B(getIntent(), this);
        this.pjL = true;
    }

    public void onResume() {
        super.onResume();
        this.cll.yw(2);
    }

    public void onPause() {
        super.onPause();
        this.cll.yw(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.cll.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T i(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.cll.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T j(Class<? extends com.tencent.mm.vending.app.a> cls) {
        c cVar = this.cll;
        if (!isFinishing() && (VERSION.SDK_INT < 17 || !isDestroyed())) {
            return cVar.x(cls);
        }
        com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{this});
        return null;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
        this.hcJ = findViewById(2131756016);
        View findViewById = findViewById(2131756018);
        final EditText editText = (EditText) view.findViewById(2131755077);
        if (this.mKeyboard != null && editText != null && this.hcJ != null) {
            this.hcJ.setVisibility(8);
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ BaseAAPresenterActivity duw;

                public final void onFocusChange(final View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ac().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 dux;

                            {
                                this.dux = r1;
                            }

                            public final void run() {
                                this.dux.duw.NP();
                                ((InputMethodManager) this.dux.duw.nDR.nEl.getSystemService("input_method")).showSoftInput(editText, 0);
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) this.duw.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 dux;

                        public final void run() {
                            if (!this.dux.duw.hcJ.isShown() && view.isShown()) {
                                if (z4) {
                                    this.dux.duw.bLB();
                                } else if (!this.dux.duw.pjL) {
                                    this.dux.duw.bLB();
                                }
                                this.dux.duw.pjL = false;
                                BaseAAPresenterActivity.a(this.dux.duw, editText);
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((com.tencent.mm.model.k.xT() || walletFormView.pko == 100) && (!com.tencent.mm.model.k.xT() || walletFormView.pko == 0)) {
                                    this.dux.duw.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
                                    this.dux.duw.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                this.dux.duw.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            this.dux.duw.yA(i2);
                            this.dux.duw.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) this.dux.duw.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseAAPresenterActivity duw;

                public final void onClick(View view) {
                    if (!this.duw.hcJ.isShown() && !z) {
                        this.duw.bLB();
                        BaseAAPresenterActivity.a(this.duw, editText);
                        this.duw.yA(i);
                    } else if (z) {
                        this.duw.NP();
                        ((InputMethodManager) this.duw.nDR.nEl.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseAAPresenterActivity duw;

                {
                    this.duw = r1;
                }

                public final void onClick(View view) {
                    this.duw.NP();
                }
            });
        }
    }

    protected final void NP() {
        super.NP();
        if (this.dup != null) {
            this.dup.scrollTo(0, 0);
        }
    }
}
