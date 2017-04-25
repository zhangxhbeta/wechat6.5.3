package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.luckymoney.c.af;
import com.tencent.mm.plugin.luckymoney.c.c;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.luckymoney.c.v;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private ah dIO = null;
    protected Dialog dxy = null;
    protected TextView eWN = null;
    private TextView eWQ;
    protected Button fpp = null;
    private ScrollView fzH;
    private c hat;
    protected LuckyMoneyNumInputView hcF = null;
    protected LuckyMoneyMoneyInputView hcG = null;
    protected LuckyMoneyTextInputView hcH = null;
    protected Button hcI = null;
    protected View hcJ;
    private View hcK;
    private View hcL;
    private ViewGroup hcM;
    private TextView hcN;
    private com.tencent.mm.plugin.luckymoney.ui.a hcO = new com.tencent.mm.plugin.luckymoney.ui.a();
    private int hcP;
    private String hcQ;
    private int hcR;
    private boolean hcS;
    private String hcT;
    private int hcU;
    private com.tencent.mm.wallet_core.ui.a hcV;
    protected MyKeyboardWindow mKeyboard;
    private int mType;

    class AnonymousClass10 implements OnFocusChangeListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ int duv;
        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

        AnonymousClass10(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.hcW = snsLuckyMoneyPrepareUI;
            this.duv = i;
            this.dut = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.dur) {
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 hcZ;

                    {
                        this.hcZ = r1;
                    }

                    public final void run() {
                        this.hcZ.hcW.NP();
                        ((InputMethodManager) this.hcZ.hcW.nDR.nEl.getSystemService("input_method")).showSoftInput(this.hcZ.dut, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) this.hcW.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass10 hcZ;

                public final void run() {
                    if (!this.hcZ.hcW.hcJ.isShown() && view.isShown()) {
                        SnsLuckyMoneyPrepareUI.k(this.hcZ.hcW);
                    }
                    this.hcZ.hcW.mKeyboard.setXMode(this.hcZ.duv);
                    this.hcZ.hcW.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) this.hcZ.hcW.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ int duv;
        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

        AnonymousClass12(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.hcW = snsLuckyMoneyPrepareUI;
            this.duv = i;
            this.dut = editText;
        }

        public final void onClick(View view) {
            if (!this.hcW.hcJ.isShown() && !this.dur) {
                SnsLuckyMoneyPrepareUI.k(this.hcW);
                this.hcW.mKeyboard.setXMode(this.duv);
            } else if (this.dur) {
                this.hcW.NP();
                ((InputMethodManager) this.hcW.nDR.nEl.getSystemService("input_method")).showSoftInput(this.dut, 0);
            }
        }
    }

    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ int duv;
        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

        AnonymousClass13(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.hcW = snsLuckyMoneyPrepareUI;
            this.duv = i;
            this.dut = editText;
        }

        public final void onClick(View view) {
            if (!this.hcW.hcJ.isShown() && !this.dur) {
                SnsLuckyMoneyPrepareUI.k(this.hcW);
                this.hcW.mKeyboard.setXMode(this.duv);
            } else if (this.dur) {
                this.hcW.NP();
                ((InputMethodManager) this.hcW.nDR.nEl.getSystemService("input_method")).showSoftInput(this.dut, 0);
            }
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        if (snsLuckyMoneyPrepareUI.hcJ != null && !snsLuckyMoneyPrepareUI.hcJ.isShown()) {
            snsLuckyMoneyPrepareUI.hcJ.setVisibility(0);
            snsLuckyMoneyPrepareUI.hcV.fd(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.hcP = getIntent().getIntExtra("key_way", 3);
        this.hcS = getIntent().getIntExtra("key_from", 0) == 1;
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        b(new v("v1.0", (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.a.a.axz();
        this.hat = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.hcS + ", config " + this.hat);
        NI();
        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(axS()), Integer.valueOf(1)});
    }

    protected final void NI() {
        q(getResources().getDrawable(2130838516));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

            {
                this.hcW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hcW.finish();
                return true;
            }
        });
        this.hcK = findViewById(2131757911);
        this.hcL = findViewById(2131757916);
        this.fpp = (Button) findViewById(2131757915);
        this.hcH = (LuckyMoneyTextInputView) findViewById(2131757907);
        this.hcH.wi(getString(2131233606));
        this.hcI = (Button) findViewById(2131757754);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
        this.hcJ = findViewById(2131756016);
        this.eWQ = (TextView) findViewById(2131757906);
        this.hcF = (LuckyMoneyNumInputView) findViewById(2131757752);
        this.hcG = (LuckyMoneyMoneyInputView) findViewById(2131757905);
        this.eWN = (TextView) findViewById(2131757908);
        this.hcM = (ViewGroup) findViewById(2131757910);
        this.fzH = (ScrollView) findViewById(2131757902);
        this.hcN = (TextView) findViewById(2131757903);
        if (this.mType == 1) {
            this.hcG.setTitle(getString(2131233673));
            this.hcG.ed(true);
        } else {
            this.hcG.setTitle(getString(2131233674));
            this.hcG.ed(false);
        }
        this.hcG.hfv = this;
        this.hcF.hfv = this;
        this.hcH.hfv = this;
        final EditText editText = (EditText) this.hcG.findViewById(2131757849);
        final EditText editText2 = (EditText) this.hcF.findViewById(2131757849);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.nDR.nEl.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.hcW.v(this.hcW.hcG, 2);
                this.hcW.v(this.hcW.hcF, 0);
                this.hcW.mKeyboard.setXMode(2);
                this.hcW.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(this.hcW);
            }
        });
        TextView textView = (TextView) this.hcG.findViewById(2131757850);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    this.hcW.v(this.hcW.hcG, 2);
                    this.hcW.v(this.hcW.hcF, 0);
                    this.hcW.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.k(this.hcW);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.nDR.nEl.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.hcW.v(this.hcW.hcG, 2);
                this.hcW.v(this.hcW.hcF, 0);
                this.hcW.mKeyboard.setXMode(0);
                this.hcW.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(this.hcW);
            }
        });
        if (this.hat != null) {
            if (this.mType == 1) {
                this.hcG.hfw = this.hat.haj;
            } else {
                this.hcG.hfw = this.hat.ham;
            }
            this.hcG.hfx = this.hat.hao;
        }
        if (!this.hcS || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.hcF.wh("");
        } else {
            this.hcF.wh("1");
        }
        this.hcF.mG(this.hat.hai);
        this.hcF.hgH = 1;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.hcF.ayu());
        this.hcG.ayp();
        if (this.hcS) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(2131233622);
                String string2 = getString(2131233619);
                String string3 = getString(2131233621);
                String string4 = getString(2131233620);
                final CharSequence spannableString = new SpannableString(string + string2);
                com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString.setSpan(gVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.g gVar2 = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString2.setSpan(gVar2, string3.length(), string3.length() + string4.length(), 33);
                gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                    public final void onClick(View view) {
                        int ayu = this.hcW.hcF.ayu();
                        double ayo = this.hcW.hcG.ayo();
                        this.hcW.mType = 0;
                        this.hcW.hcG.mType = this.hcW.mType;
                        this.hcW.hcG.ed(false);
                        this.hcW.hcG.setTitle(this.hcW.getString(2131233674));
                        if (ayo > 0.0d && ayu > 0) {
                            this.hcW.hcG.wg(e.m(ayo / ((double) ayu)));
                        }
                        this.hcW.hcG.hfw = this.hcW.hat.ham;
                        this.hcW.eWQ.setText(spannableString2);
                        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hcW.axS()), Integer.valueOf(3)});
                    }
                };
                gVar2.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                    public final void onClick(View view) {
                        int ayu = this.hcW.hcF.ayu();
                        double ayo = this.hcW.hcG.ayo();
                        this.hcW.mType = 1;
                        this.hcW.hcG.mType = this.hcW.mType;
                        this.hcW.hcG.setTitle(this.hcW.getString(2131233673));
                        this.hcW.hcG.ed(true);
                        if (ayo > 0.0d && ayu > 0) {
                            this.hcW.hcG.wg(e.m(ayo * ((double) ayu)));
                        }
                        this.hcW.hcG.hfw = this.hcW.hat.haj;
                        this.hcW.eWQ.setText(spannableString);
                        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hcW.axS()), Integer.valueOf(2)});
                    }
                };
                this.eWQ.setMovementMethod(LinkMovementMethod.getInstance());
                this.eWQ.setText(spannableString);
                this.eWQ.setVisibility(0);
            } else {
                this.hcF.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.eWQ.setText(this.hat.hak);
            this.eWQ.setVisibility(0);
        } else if (this.mType == 0) {
            this.eWQ.setText(this.hat.hal);
            this.eWQ.setVisibility(0);
        }
        this.hcI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

            {
                this.hcW = r1;
            }

            public final void onClick(View view) {
                g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hcW.axS()), Integer.valueOf(4)});
                if (this.hcW.hcG.ayn() != 0) {
                    s.makeText(this.hcW.nDR.nEl, 2131236020, 0).show();
                    return;
                }
                long n;
                k acVar;
                int ayu = this.hcW.hcF.ayu();
                double ayo = this.hcW.hcG.ayo();
                long j = 0;
                if (this.hcW.mType == 1) {
                    n = e.n(ayo);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(356354, Integer.valueOf(ayu));
                } else {
                    n = e.n(((double) ayu) * ayo);
                    j = e.n(ayo);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(356353, Integer.valueOf(ayu));
                }
                String input = this.hcW.hcH.getInput();
                if (be.kS(input)) {
                    input = this.hcW.getString(2131233606);
                }
                String stringExtra = this.hcW.getIntent().getStringExtra("key_username");
                if (!this.hcW.hcS || be.kS(stringExtra)) {
                    acVar = new com.tencent.mm.plugin.luckymoney.c.ac(ayu, n, j, this.hcW.mType, input, n.axJ(), null, null, com.tencent.mm.model.k.xF(), com.tencent.mm.model.k.xH(), this.hcW.hcP);
                } else {
                    acVar = new com.tencent.mm.plugin.luckymoney.c.ac(ayu, n, j, this.hcW.mType, input, n.axJ(), stringExtra, n.eq(stringExtra), com.tencent.mm.model.k.xF(), com.tencent.mm.model.k.xH(), this.hcW.hcP);
                }
                this.hcW.b(acVar, false);
                if (this.hcW.dxy != null) {
                    this.hcW.dxy.show();
                    return;
                }
                this.hcW.dxy = com.tencent.mm.wallet_core.ui.g.a(this.hcW.nDR.nEl, true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass16 hdc;

                    {
                        this.hdc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.hdc.hcW.dxy != null && this.hdc.hcW.dxy.isShowing()) {
                            this.hdc.hcW.dxy.hide();
                        }
                        if (this.hdc.hcW.nDR.dtW.getVisibility() == 8 || this.hdc.hcW.nDR.dtW.getVisibility() == 4) {
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                            this.hdc.hcW.finish();
                        }
                        this.hdc.hcW.hdT.axF();
                    }
                });
            }
        });
        this.eWN.setText(e.l(0.0d));
        this.hcO.a(this.hcF);
        this.hcO.a(this.hcG);
        this.hcO.a(this.hcH);
        this.hcO.f((TextView) findViewById(2131757917));
        if (this.hcS && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(2131757904);
            textView2.setText(getString(2131233634, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.dIO = new ah(new ah.a(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

            {
                this.hcW = r1;
            }

            public final boolean oU() {
                double d;
                if (this.hcW.hcG.ayn() == 3 || this.hcW.hcF.ayn() == 3) {
                    d = 0.0d;
                } else {
                    int ayu = this.hcW.hcF.ayu();
                    d = this.hcW.hcG.ayo();
                    if (this.hcW.mType == 0) {
                        d *= (double) ayu;
                    }
                }
                if (d == 0.0d || d > this.hcW.hat.haj || this.hcW.hcO.aym()) {
                    this.hcW.hcI.setClickable(false);
                    this.hcW.hcI.setEnabled(false);
                } else {
                    this.hcW.hcI.setClickable(true);
                    this.hcW.hcI.setEnabled(true);
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + this.hcW.hcO.aym());
                this.hcW.dIO.btC();
                return false;
            }
        }, false);
        if (this.fzH != null) {
            this.fzH.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                {
                    this.hcW = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.hcW.NP();
                        this.hcW.axg();
                    }
                    return false;
                }
            });
        }
        this.hcG.mType = this.mType;
        if (this.hcS && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.hcG.requestFocus();
        } else {
            this.hcF.requestFocus();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.hcO.clear();
        this.dIO.btC();
        if (this.dxy != null && this.dxy.isShowing()) {
            this.dxy.dismiss();
        }
    }

    protected final int getLayoutId() {
        return 2130903899;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hcK.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hcK.setVisibility(8);
        ayf();
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.c.ac) {
            if (this.dxy != null && this.dxy.isShowing()) {
                this.dxy.hide();
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.luckymoney.c.ac acVar = (com.tencent.mm.plugin.luckymoney.c.ac) kVar;
                this.hcR = acVar.haG;
                this.hcQ = acVar.haB;
                this.hcT = acVar.hcj;
                PayInfo payInfo = new PayInfo();
                payInfo.fTG = acVar.hci;
                payInfo.bkq = 37;
                payInfo.bkh = this.hcU;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.hcI.setEnabled(false);
                this.hcI.setClickable(false);
                this.dIO.ea(5000);
                com.tencent.mm.ui.base.g.bf(this, str);
                return true;
            } else {
                com.tencent.mm.ui.base.g.bf(this, str);
                return true;
            }
        }
        if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                if (this.hcS) {
                    com.tencent.mm.ui.base.g.bf(this, getString(2131233278));
                    finish();
                } else {
                    ayg();
                    this.hcL.postDelayed(new Runnable(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                        {
                            this.hcW = r1;
                        }

                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(this.hcW.nDR.nEl, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            this.hcW.nDR.nEl.startActivity(intent);
                            this.hcW.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, str, "", getString(2131233658), getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                    {
                        this.hcW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.hcW.nDR.nEl, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        this.hcW.startActivity(intent);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                    {
                        this.hcW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof v) {
            if (i == 0 && i2 == 0) {
                final v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.axz();
                this.hat = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.hat);
                if (this.mType == 1) {
                    this.hcG.hfw = this.hat.haj;
                } else {
                    this.hcG.hfw = this.hat.ham;
                }
                this.hcG.hfx = this.hat.hao;
                this.hcF.mG(this.hat.hai);
                if (vVar.hbV && this.hcS) {
                    TextView textView = (TextView) findViewById(2131757909);
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                        {
                            this.hcW = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hcW.axS()), Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.setClass(this.hcW.nDR.nEl, LuckyMoneyCanShareListUI.class);
                            this.hcW.startActivity(intent);
                        }
                    });
                    g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(axS()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (be.kS(vVar.hbX)) {
                    this.hcN.setVisibility(8);
                } else {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + vVar.hbX);
                    this.hcN.setText(vVar.hbX);
                    if (!be.kS(vVar.hbY)) {
                        this.hcN.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                            public final void onClick(View view) {
                                e.l(this.hcW.nDR.nEl, vVar.hbY, false);
                            }
                        });
                    }
                    this.hcN.setVisibility(0);
                }
                com.tencent.mm.plugin.luckymoney.ui.g.c cVar = new com.tencent.mm.plugin.luckymoney.ui.g.c();
                cVar.textColor = getResources().getColor(2131690102);
                com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.hcM, vVar.hca, cVar);
            }
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(axS()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.hcS && !be.kS(stringExtra)) {
                        com.tencent.mm.ui.base.g.bf(this, getString(2131233278));
                        Map q = bf.q(this.hcT, "msg");
                        if (q != null) {
                            str = (String) q.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.a.a.axz().axC().vY(str)) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!n.v(this.hcT, stringExtra, 1)) {
                                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    com.tencent.mm.plugin.luckymoney.a.a.axz().axC().vZ(str);
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        return;
                    }
                    ayg();
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                        {
                            this.hcW = r1;
                        }

                        public final void run() {
                            this.hcW.hcK.setVisibility(0);
                            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(800);
                            scaleAnimation.setStartOffset(200);
                            scaleAnimation.setInterpolator(new BounceInterpolator());
                            this.hcW.findViewById(2131757912).startAnimation(scaleAnimation);
                        }
                    }, 200);
                    this.fpp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                        {
                            this.hcW = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hcW.axS()), Integer.valueOf(6)});
                            n.a(this.hcW, this.hcW.mType, this.hcW.hcR);
                            this.hcW.hcK.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass8 hcY;

                                {
                                    this.hcY = r1;
                                }

                                public final void run() {
                                    this.hcY.hcW.hcK.setVisibility(8);
                                    this.hcY.hcW.ayf();
                                }
                            }, 100);
                        }
                    });
                    ((ImageView) findViewById(2131757914)).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                        {
                            this.hcW = r1;
                        }

                        public final void onClick(View view) {
                            this.hcW.hcK.setVisibility(8);
                            this.hcW.ayf();
                        }
                    });
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.nDR.nEl, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(axS()), Integer.valueOf(7), str});
                if (!be.kS(str)) {
                    j(new af(str.replaceAll(",", "|"), this.hcQ, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void v(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
        this.hcJ = findViewById(2131756016);
        View findViewById = findViewById(2131756018);
        EditText editText = (EditText) view.findViewById(2131757849);
        if (this.mKeyboard != null && editText != null && this.hcJ != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new AnonymousClass10(this, false, i, editText));
            editText.setOnClickListener(new AnonymousClass12(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(2131757850);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass13(this, false, i, editText));
            }
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI hcW;

                {
                    this.hcW = r1;
                }

                public final void onClick(View view) {
                    this.hcW.NP();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.hcJ == null || !this.hcJ.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        NP();
        return true;
    }

    protected final void NP() {
        if (this.hcJ != null && this.hcJ.isShown()) {
            this.hcJ.setVisibility(8);
            this.hcV.fd(false);
        }
    }

    public final void axR() {
        double d;
        double d2;
        com.tencent.mm.plugin.luckymoney.a.a.axz();
        this.hat = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
        if (this.hcG.ayn() == 3 || this.hcF.ayn() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int ayu = this.hcF.ayu();
            d2 = this.hcG.ayo();
            if (this.mType == 0) {
                d2 *= (double) ayu;
                d = this.hcG.ayo();
            } else {
                d = ayu > 0 ? this.hcG.ayo() / ((double) ayu) : 0.0d;
            }
        }
        if (this.hcO.ayl()) {
            this.hcI.setClickable(false);
            this.hcI.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.hat.haj && this.hat.haj > 0.0d) {
                this.hcO.wf(getString(2131233672, new Object[]{Math.round(this.hat.haj), be.ah(this.hat.has, "")}));
                z = true;
            } else if (d > 0.0d) {
                boolean z2;
                if (this.mType == 0) {
                    if (d > this.hat.ham && this.hat.ham > 0.0d) {
                        this.hcO.wf(getString(2131233643, new Object[]{Math.round(this.hat.ham), be.ah(this.hat.has, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d > this.hat.han && this.hat.han > 0.0d) {
                        this.hcO.wf(getString(2131233643, new Object[]{Math.round(this.hat.han), be.ah(this.hat.has, "")}));
                        this.hcF.onError();
                        this.hcG.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d < this.hat.hao) {
                            this.hcO.wf(getString(2131233644, new Object[]{e.m(this.hat.hao), be.ah(this.hat.has, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.hcO.wf(getString(2131233644, new Object[]{"0.01", be.ah(this.hat.has, "")}));
                        this.hcF.onError();
                        this.hcG.onError();
                        z = true;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            if (z) {
                this.hcI.setClickable(false);
                this.hcI.setEnabled(false);
            } else {
                this.hcI.setClickable(true);
                this.hcI.setEnabled(true);
            }
        }
        this.eWN.setText(e.l(d2));
    }

    private int axS() {
        if (!this.hcS) {
            return 3;
        }
        if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            return 2;
        }
        return 1;
    }
}
