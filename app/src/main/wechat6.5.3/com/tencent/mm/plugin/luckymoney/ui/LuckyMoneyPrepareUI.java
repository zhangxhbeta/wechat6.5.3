package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.tencent.mm.plugin.luckymoney.c.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.m;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private ah dIO = null;
    private Dialog dxy = null;
    private TextView eWN = null;
    private TextView eWQ;
    private Button fpp = null;
    private ScrollView fzH;
    private c hat;
    private LuckyMoneyNumInputView hcF = null;
    private LuckyMoneyMoneyInputView hcG = null;
    private LuckyMoneyTextInputView hcH = null;
    private Button hcI = null;
    protected View hcJ;
    private View hcK;
    private View hcL;
    private ViewGroup hcM;
    private TextView hcN;
    private a hcO = new a();
    private int hcP;
    private String hcQ;
    private int hcR;
    private boolean hcS;
    private String hcT;
    private int hcU;
    private int hgR = 1;
    private String hgS = e.PQ("CNY");
    private RealnameGuideHelper hgT;
    protected MyKeyboardWindow mKeyboard;
    private int mType;

    class AnonymousClass16 implements OnFocusChangeListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ int duv;
        final /* synthetic */ LuckyMoneyPrepareUI hgU;

        AnonymousClass16(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.hgU = luckyMoneyPrepareUI;
            this.duv = i;
            this.dut = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.dur) {
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass16 hgX;

                    {
                        this.hgX = r1;
                    }

                    public final void run() {
                        this.hgX.hgU.NP();
                        ((InputMethodManager) this.hgX.hgU.nDR.nEl.getSystemService("input_method")).showSoftInput(this.hgX.dut, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) this.hgU.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass16 hgX;

                public final void run() {
                    if (!this.hgX.hgU.hcJ.isShown() && view.isShown()) {
                        this.hgX.hgU.hcJ.setVisibility(0);
                    }
                    this.hgX.hgU.mKeyboard.setXMode(this.hgX.duv);
                    this.hgX.hgU.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) this.hgX.hgU.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    class AnonymousClass17 implements OnClickListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ int duv;
        final /* synthetic */ LuckyMoneyPrepareUI hgU;

        AnonymousClass17(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.hgU = luckyMoneyPrepareUI;
            this.duv = i;
            this.dut = editText;
        }

        public final void onClick(View view) {
            if (!this.hgU.hcJ.isShown() && !this.dur) {
                this.hgU.hcJ.setVisibility(0);
                this.hgU.mKeyboard.setInputEditText((EditText) view);
                this.hgU.mKeyboard.setXMode(this.duv);
            } else if (this.dur) {
                this.hgU.hcJ.setVisibility(8);
                ((InputMethodManager) this.hgU.nDR.nEl.getSystemService("input_method")).showSoftInput(this.dut, 0);
            }
        }
    }

    class AnonymousClass18 implements OnClickListener {
        final /* synthetic */ boolean dur = false;
        final /* synthetic */ EditText dut;
        final /* synthetic */ View duu;
        final /* synthetic */ int duv;
        final /* synthetic */ LuckyMoneyPrepareUI hgU;

        AnonymousClass18(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, EditText editText, View view, int i) {
            this.hgU = luckyMoneyPrepareUI;
            this.dut = editText;
            this.duu = view;
            this.duv = i;
        }

        public final void onClick(View view) {
            if (!this.hgU.hcJ.isShown() || this.dur) {
                if (!this.hgU.hcJ.isShown() && !this.dur) {
                    ((InputMethodManager) this.hgU.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass18 hgY;

                        {
                            this.hgY = r1;
                        }

                        public final void run() {
                            this.hgY.hgU.hcJ.setVisibility(0);
                            this.hgY.duu.requestFocus();
                            if (this.hgY.hgU.mKeyboard != null) {
                                this.hgY.hgU.mKeyboard.setInputEditText(this.hgY.dut);
                            }
                            this.hgY.hgU.mKeyboard.setXMode(this.hgY.duv);
                        }
                    }, 200);
                } else if (this.dur) {
                    this.hgU.hcJ.setVisibility(8);
                    ((InputMethodManager) this.hgU.nDR.nEl.getSystemService("input_method")).showSoftInput(this.dut, 0);
                }
            } else if (this.hgU.mKeyboard != null) {
                this.hgU.mKeyboard.setInputEditText(this.dut);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.hcP = getIntent().getIntExtra("key_way", 3);
        this.hcS = getIntent().getIntExtra("key_from", 0) == 1;
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        b(new v("v1.0", (byte) 0), true);
        com.tencent.mm.plugin.luckymoney.a.a.axz();
        this.hat = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.hcP + "mChannel:" + this.hcU);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.hcS + ", config " + this.hat);
        NI();
        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(axS()), Integer.valueOf(1)});
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            {
                this.hgU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hgU.finish();
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
            vD(2131233616);
            this.hcG.setTitle(getString(2131233673));
            this.hcG.ed(true);
        } else {
            vD(2131233633);
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
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.hgU.v(this.hgU.hcG, 2);
                this.hgU.v(this.hgU.hcF, 0);
                this.hgU.mKeyboard.setXMode(2);
                this.hgU.mKeyboard.setInputEditText((EditText) view);
                this.hgU.hcJ.setVisibility(0);
            }
        });
        TextView textView = (TextView) this.hcG.findViewById(2131757850);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI hgU;

                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    this.hgU.v(this.hgU.hcG, 2);
                    this.hgU.v(this.hgU.hcF, 0);
                    this.hgU.mKeyboard.setXMode(2);
                    this.hgU.mKeyboard.setInputEditText(editText);
                    this.hgU.hcJ.setVisibility(0);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.nDR.nEl.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.hgU.v(this.hgU.hcG, 2);
                this.hgU.v(this.hgU.hcF, 0);
                this.hgU.mKeyboard.setXMode(0);
                this.hgU.mKeyboard.setInputEditText((EditText) view);
                this.hgU.hcJ.setVisibility(0);
            }
        });
        ((MMEditText) this.hcH.findViewById(2131757939)).setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            public final void onFocusChange(View view, boolean z) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.hgU.v(this.hgU.hcG, 2);
                this.hgU.v(this.hgU.hcF, 0);
            }
        });
        if (this.hat != null) {
            if (this.mType == 1) {
                this.hcG.hfw = this.hat.haj;
            } else {
                this.hcG.hfw = this.hat.ham;
            }
            this.hcG.hfx = this.hat.hao;
            if (this.hat.haq != 1) {
                cb(this.hat.has, this.hat.har);
            }
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
            vD(2131233671);
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
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    public final void onClick(View view) {
                        int ayu = this.hgU.hcF.ayu();
                        double ayo = this.hgU.hcG.ayo();
                        this.hgU.mType = 0;
                        this.hgU.hcG.mType = this.hgU.mType;
                        this.hgU.hcG.ed(false);
                        this.hgU.hcG.setTitle(this.hgU.getString(2131233674));
                        if (ayo > 0.0d && ayu > 0) {
                            this.hgU.hcG.wg(e.m(ayo / ((double) ayu)));
                        }
                        this.hgU.hcG.hfw = this.hgU.hat.ham;
                        this.hgU.eWQ.setText(spannableString2);
                        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hgU.axS()), Integer.valueOf(3)});
                    }
                };
                gVar2.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    public final void onClick(View view) {
                        int ayu = this.hgU.hcF.ayu();
                        double ayo = this.hgU.hcG.ayo();
                        this.hgU.mType = 1;
                        this.hgU.hcG.mType = this.hgU.mType;
                        this.hgU.hcG.hfw = this.hgU.hat.haj;
                        this.hgU.hcG.setTitle(this.hgU.getString(2131233673));
                        this.hgU.hcG.ed(true);
                        if (ayo > 0.0d && ayu > 0) {
                            this.hgU.hcG.wg(e.m(ayo * ((double) ayu)));
                        }
                        this.hgU.eWQ.setText(spannableString);
                        g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hgU.axS()), Integer.valueOf(2)});
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
        this.hcI.setOnClickListener(new m(this) {
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            {
                this.hgU = r1;
            }

            public final void ayv() {
                g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hgU.axS()), Integer.valueOf(4)});
                if (this.hgU.hcG.ayn() != 0) {
                    s.makeText(this.hgU.nDR.nEl, 2131236020, 0).show();
                    return;
                }
                long n;
                int ayu = this.hgU.hcF.ayu();
                double ayo = this.hgU.hcG.ayo();
                long j = 0;
                if (this.hgU.mType == 1) {
                    n = e.n(ayo);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(356354, Integer.valueOf(ayu));
                } else {
                    n = e.n(((double) ayu) * ayo);
                    j = e.n(ayo);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(356353, Integer.valueOf(ayu));
                }
                String input = this.hgU.hcH.getInput();
                if (be.kS(input)) {
                    input = this.hgU.getString(2131233606);
                }
                String stringExtra = this.hgU.getIntent().getStringExtra("key_username");
                if (this.hgU.hgR == 1) {
                    k acVar;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
                    if (!this.hgU.hcS || be.kS(stringExtra)) {
                        acVar = new com.tencent.mm.plugin.luckymoney.c.ac(ayu, n, j, this.hgU.mType, input, n.axJ(), null, null, com.tencent.mm.model.k.xF(), com.tencent.mm.model.k.xH(), this.hgU.hcP);
                    } else {
                        acVar = new com.tencent.mm.plugin.luckymoney.c.ac(ayu, n, j, this.hgU.mType, input, n.axJ(), stringExtra, n.eq(stringExtra), com.tencent.mm.model.k.xF(), com.tencent.mm.model.k.xH(), this.hgU.hcP);
                    }
                    this.hgU.b(acVar, false);
                } else {
                    k wVar;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + this.hgU.hgR);
                    this.hgU.gQ(1645);
                    if (!this.hgU.hcS || be.kS(stringExtra)) {
                        wVar = new w(ayu, n, j, this.hgU.mType, input, null, n.axJ(), com.tencent.mm.model.k.xF(), this.hgU.hgR);
                    } else {
                        wVar = new w(ayu, n, j, this.hgU.mType, input, stringExtra, n.axJ(), com.tencent.mm.model.k.xF(), this.hgU.hgR);
                    }
                    this.hgU.b(wVar, false);
                }
                if (this.hgU.dxy != null) {
                    this.hgU.dxy.show();
                } else {
                    this.hgU.dxy = com.tencent.mm.wallet_core.ui.g.a(this.hgU.nDR.nEl, true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass21 hgZ;

                        {
                            this.hgZ = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.hgZ.hgU.dxy != null && this.hgZ.hgU.dxy.isShowing()) {
                                this.hgZ.hgU.dxy.hide();
                            }
                            if (this.hgZ.hgU.nDR.dtW.getVisibility() == 8 || this.hgZ.hgU.nDR.dtW.getVisibility() == 4) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                this.hgZ.hgU.finish();
                            }
                            this.hgZ.hgU.hdT.axF();
                        }
                    });
                }
            }
        });
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
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            {
                this.hgU = r1;
            }

            public final boolean oU() {
                double d;
                if (this.hgU.hcG.ayn() == 3 || this.hgU.hcF.ayn() == 3) {
                    d = 0.0d;
                } else {
                    int ayu = this.hgU.hcF.ayu();
                    d = this.hgU.hcG.ayo();
                    if (this.hgU.mType == 0) {
                        d *= (double) ayu;
                    }
                }
                if (d == 0.0d || d > this.hgU.hat.haj || this.hgU.hcO.aym()) {
                    this.hgU.hcI.setClickable(false);
                    this.hgU.hcI.setEnabled(false);
                } else {
                    this.hgU.hcI.setClickable(true);
                    this.hgU.hcI.setEnabled(true);
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + this.hgU.hcO.aym());
                this.hgU.dIO.btC();
                return false;
            }
        }, false);
        if (this.fzH != null) {
            this.fzH.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI hgU;

                {
                    this.hgU = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.hgU.NP();
                        this.hgU.axg();
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
        a(0, 2130838542, new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI hgU;

            {
                this.hgU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.hgU.hgR == 1) {
                    e.l(this.hgU.nDR.nEl, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                } else {
                    e.l(this.hgU.nDR.nEl, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                }
                return true;
            }
        });
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
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + kVar.getType());
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.c.ac) {
            if (this.dxy != null && this.dxy.isShowing()) {
                this.dxy.hide();
            }
            if (i == 0 && i2 == 0) {
                final com.tencent.mm.plugin.luckymoney.c.ac acVar = (com.tencent.mm.plugin.luckymoney.c.ac) kVar;
                if (acVar.hcp == null || !acVar.hcp.bfE()) {
                    this.hcR = acVar.haG;
                    this.hcQ = acVar.haB;
                    this.hcT = acVar.hcj;
                    PayInfo payInfo = new PayInfo();
                    payInfo.fTG = acVar.hci;
                    payInfo.bkq = 37;
                    payInfo.bkh = this.hcU;
                    com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 1);
                    return true;
                }
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, acVar.hcp.bhe, "", acVar.hcp.hcn, acVar.hcp.hcm, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[]{acVar.hcp.kMP});
                        e.l(this.hgU.nDR.nEl, acVar.hcp.kMP, false);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    {
                        this.hgU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            } else if (i2 == 401) {
                this.hcI.setEnabled(false);
                this.hcI.setClickable(false);
                this.dIO.ea(5000);
                com.tencent.mm.ui.base.g.bf(this, str);
                return true;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = getString(2131236492);
                }
                com.tencent.mm.ui.base.g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    {
                        this.hgU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        }
        if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                if (this.hcS) {
                    com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
                    ad.g(new Runnable(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI hgU;

                        {
                            this.hgU = r1;
                        }

                        public final void run() {
                            this.hgU.finish();
                        }
                    }, 1800);
                } else {
                    ayg();
                    this.hcL.setVisibility(0);
                    this.hcL.postDelayed(new Runnable(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI hgU;

                        {
                            this.hgU = r1;
                        }

                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(this.hgU.nDR.nEl, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            this.hgU.nDR.nEl.startActivity(intent);
                            this.hgU.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, str, "", getString(2131233658), getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    {
                        this.hgU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.hgU.nDR.nEl, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        this.hgU.startActivity(intent);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI hgU;

                    {
                        this.hgU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof v) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (i == 0 && i2 == 0) {
                final v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.axz();
                this.hat = com.tencent.mm.plugin.luckymoney.a.a.axA().axE();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.hat);
                if (this.mType == 1) {
                    this.hcG.hfw = this.hat.haj;
                } else {
                    this.hcG.hfw = this.hat.ham;
                }
                this.hcG.hfx = this.hat.hao;
                this.hcF.mG(this.hat.hai);
                this.hgS = vVar.har;
                this.hgR = vVar.haq;
                if (vVar.hbV && this.hcS) {
                    TextView textView = (TextView) findViewById(2131757909);
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI hgU;

                        {
                            this.hgU = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hgU.axS()), Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.setClass(this.hgU.nDR.nEl, LuckyMoneyCanShareListUI.class);
                            this.hgU.startActivity(intent);
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
                            final /* synthetic */ LuckyMoneyPrepareUI hgU;

                            public final void onClick(View view) {
                                e.l(this.hgU.nDR.nEl, vVar.hbY, false);
                            }
                        });
                    }
                    this.hcN.setVisibility(0);
                }
                g.c cVar = new g.c();
                if (vVar.hca == null || be.kS(vVar.hca.content)) {
                    cVar.textColor = getResources().getColor(2131689792);
                } else {
                    cVar.textColor = getResources().getColor(2131690102);
                }
                g.a(this, this.hcM, vVar.hca, cVar);
                cb(vVar.has, vVar.har);
                b(0.0d, this.hgS);
            }
            return true;
        } else if (kVar instanceof w) {
            gR(1645);
            if (this.dxy != null && this.dxy.isShowing()) {
                this.dxy.hide();
            }
            if (i == 0 && i2 == 0) {
                String str2 = ((w) kVar).eWy;
                if (be.kS(str2)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                return true;
            }
        }
        return false;
    }

    private void cb(String str, String str2) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + str);
        TextView textView = (TextView) findViewById(2131757850);
        if (be.kS(str)) {
            textView.setText(getString(2131233601));
        } else {
            textView.setText(str);
        }
        if (be.kS(str2)) {
            b(0.0d, e.PQ("CNY"));
        } else {
            b(0.0d, str2);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.hgT = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
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
                    View findViewById = findViewById(2131757912);
                    this.hcK.setVisibility(0);
                    n.a(findViewById, null);
                    this.fpp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI hgU;

                        {
                            this.hgU = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.hgU.axS()), Integer.valueOf(6)});
                            n.a(this.hgU, this.hgU.mType, this.hgU.hcR);
                            this.hgU.hcK.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass14 hgW;

                                {
                                    this.hgW = r1;
                                }

                                public final void run() {
                                    this.hgW.hgU.hcK.setVisibility(8);
                                    this.hgW.hgU.ayf();
                                }
                            }, 100);
                        }
                    });
                    ((ImageView) findViewById(2131757914)).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI hgU;

                        {
                            this.hgU = r1;
                        }

                        public final void onClick(View view) {
                            this.hgU.hcK.setVisibility(8);
                            this.hgU.ayf();
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
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = be.getInt(bundleExtra.getString("payState", "2"), 0);
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
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
            editText.setOnFocusChangeListener(new AnonymousClass16(this, false, i, editText));
            editText.setOnClickListener(new AnonymousClass17(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(2131757850);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass18(this, false, editText, view, i));
            }
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI hgU;

                {
                    this.hgU = r1;
                }

                public final void onClick(View view) {
                    this.hgU.NP();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.hcJ == null || !this.hcJ.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.hcJ.setVisibility(8);
        return true;
    }

    protected final void NP() {
        if (this.hcJ != null && this.hcJ.isShown()) {
            this.hcJ.setVisibility(8);
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
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
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
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d);
                if (this.mType == 0) {
                    if (d > this.hat.ham && this.hat.ham > 0.0d) {
                        this.hcO.wf(getString(2131233643, new Object[]{Math.round(this.hat.ham), be.ah(this.hat.has, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.hat.han && this.hat.han > 0.0d) {
                        this.hcO.wf(getString(2131233643, new Object[]{Math.round(this.hat.han), be.ah(this.hat.has, "")}));
                        this.hcF.onError();
                        this.hcG.onError();
                        z = true;
                    }
                    z = false;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
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
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
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
        b(d2, this.hgS);
    }

    private void b(double d, String str) {
        if (be.kS(str)) {
            this.eWN.setText(e.l(d));
        } else {
            this.eWN.setText(str + e.m(d));
        }
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

    public void finish() {
        if (this.hgT != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.hgT);
            com.tencent.mm.ay.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
    }
}
