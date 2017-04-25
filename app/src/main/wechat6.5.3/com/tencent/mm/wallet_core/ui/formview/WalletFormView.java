package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    public TextView eXB;
    public WalletIconImageView ioA;
    public TextView ioB;
    private OnFocusChangeListener ioD;
    private OnClickListener ioE;
    private int ioH;
    private String ioI;
    private int ioJ;
    private String ioK;
    private int ioL;
    private int ioM;
    private int ioN;
    private String ioO;
    private int ioP;
    private String ioQ;
    private int ioR;
    private int ioS;
    private String ioT;
    public int ioU;
    private int ioV;
    private int ioW;
    private boolean ioX;
    private boolean ioY;
    private boolean ioZ;
    public TextView ioy;
    private int ipa;
    private int ipb;
    private int ipc;
    public TenpaySecureEditText pkj;
    public a pkk;
    public com.tencent.mm.wallet_core.ui.formview.a.a pkl;
    public b pkm;
    private int pkn;
    public int pko;
    private int pkp;

    public interface a {
        void fc(boolean z);
    }

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.eXB = null;
        this.ioy = null;
        this.pkj = null;
        this.ioA = null;
        this.ioB = null;
        this.pkk = null;
        this.ioD = null;
        this.ioE = null;
        this.pkl = null;
        this.pkm = null;
        this.ioH = -1;
        this.pkn = this.ioH;
        this.pko = 100;
        this.ioI = "";
        this.ioJ = 0;
        this.ioK = "";
        this.ioL = 8;
        this.ioM = -1;
        this.ioN = 4;
        this.ioO = "";
        this.ioP = 8;
        this.ioQ = "";
        this.ioR = 19;
        this.ioS = 2131689909;
        this.ioT = "";
        this.pkp = 0;
        this.ioU = Integer.MAX_VALUE;
        this.ioV = 1;
        this.ioW = 2130838689;
        this.ioX = true;
        this.ioY = false;
        this.ioZ = true;
        this.ipa = 1;
        this.ipb = 5;
        this.ipc = 2131689822;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPD, i, 0);
        this.ioH = obtainStyledAttributes.getResourceId(2, this.ioH);
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            this.ioI = context.getString(resourceId);
        }
        this.ioM = obtainStyledAttributes.getResourceId(5, this.ioM);
        resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.ioO = context.getString(resourceId);
        }
        this.ioN = obtainStyledAttributes.getInteger(8, this.ioN);
        this.ioJ = obtainStyledAttributes.getInteger(9, this.ioJ);
        this.ioP = obtainStyledAttributes.getInteger(10, this.ioP);
        this.ioL = obtainStyledAttributes.getInteger(11, this.ioL);
        resourceId = obtainStyledAttributes.getResourceId(12, 0);
        if (resourceId != 0) {
            this.ioK = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(13, 0);
        if (resourceId != 0) {
            this.ioQ = context.getString(resourceId);
        }
        this.ioR = obtainStyledAttributes.getInteger(14, this.ioR);
        this.ioS = obtainStyledAttributes.getColor(15, this.ioS);
        resourceId = obtainStyledAttributes.getResourceId(16, 0);
        if (resourceId != 0) {
            this.ioT = context.getString(resourceId);
        }
        this.pkp = obtainStyledAttributes.getInt(17, this.pkp);
        this.ioU = obtainStyledAttributes.getInteger(18, this.ioU);
        this.ioV = obtainStyledAttributes.getInteger(19, this.ioV);
        this.ioW = obtainStyledAttributes.getResourceId(20, this.ioW);
        this.ioX = obtainStyledAttributes.getBoolean(21, this.ioX);
        this.ioY = obtainStyledAttributes.getBoolean(23, this.ioY);
        this.ioZ = obtainStyledAttributes.getBoolean(21, this.ioZ);
        this.ipa = obtainStyledAttributes.getInteger(0, this.ipa);
        this.ipb = obtainStyledAttributes.getInteger(1, this.ipb);
        this.pko = obtainStyledAttributes.getInteger(25, this.pko);
        this.ipc = obtainStyledAttributes.getInteger(24, this.ipc);
        this.pkn = obtainStyledAttributes.getResourceId(3, this.pkn);
        obtainStyledAttributes.recycle();
        if (this.ioH > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (be.kS(this.ioI) || this.ioI.length() <= 6) {
            inflate(context, this.ioH, this);
        } else {
            inflate(context, this.pkn, this);
        }
        this.eXB = (TextView) findViewById(2131755084);
        this.ioy = (TextView) findViewById(2131755082);
        this.pkj = (TenpaySecureEditText) findViewById(2131755077);
        this.ioA = (WalletIconImageView) findViewById(2131755081);
        this.ioB = (TextView) findViewById(2131755083);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void PZ(String str) {
        this.ioI = str;
        bLK();
    }

    public final void Qa(String str) {
        if (this.pkj == null) {
            return;
        }
        if (this.pkm == null || !this.pkm.d(this, str)) {
            this.pkj.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
    }

    public final void setImeOptions(int i) {
        if (this.pkj != null) {
            this.pkj.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.pkj != null) {
            this.pkj.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.pkj == null) {
            return;
        }
        if (this.pkm == null || !this.pkm.c(this, str)) {
            this.pkj.setText(str);
            this.pkj.setSelection(getInputLength());
        }
    }

    private void aJw() {
        if (this.ioA != null && !be.kS(getText()) && this.pkj != null && this.pkj.isEnabled() && this.pkj.isClickable() && this.pkj.isFocusable() && this.pkj.isFocused()) {
            this.ioA.h(new OnClickListener(this) {
                final /* synthetic */ WalletFormView pkq;

                {
                    this.pkq = r1;
                }

                public final void onClick(View view) {
                    this.pkq.aJx();
                }
            });
        } else if (this.ioA != null) {
            this.ioA.brg();
        } else {
            v.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final boolean bLJ() {
        return this.pkj != null ? this.pkj.isFocusable() : false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        bLK();
        if (this.ioy != null) {
            this.ioy.setText(this.ioK);
            this.ioy.setVisibility(this.ioL);
        }
        if (this.ioA != null) {
            this.ioA.setImageResource(this.ioM);
            this.ioA.setVisibility(this.ioN);
        }
        if (this.ioB != null) {
            this.ioB.setText(this.ioO);
            this.ioB.setVisibility(this.ioP);
        }
        getContext();
        if (this.pkj != null) {
            this.pkj.setHint(this.ioQ);
            this.pkj.setGravity(this.ioR);
            this.pkj.setTextColor(this.ioS);
            setText(this.ioT);
            b.a(this.pkj, this.pkp);
            this.pkj.setBackgroundResource(this.ioW);
            this.pkj.setEnabled(this.ioX);
            this.pkj.setFocusable(this.ioZ);
            this.pkj.setClickable(this.ioY);
            this.pkj.setHintTextColor(this.ipc);
            setImeOptions(this.ipb);
            setInputType(this.ipa);
            this.pkj.addTextChangedListener(new TextWatcher(this) {
                private boolean ipd = false;
                final /* synthetic */ WalletFormView pkq;

                {
                    this.pkq = r2;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.pkq.Ou() != this.ipd) {
                        if (this.pkq.pkk != null) {
                            this.pkq.pkk.fc(this.pkq.Ou());
                        }
                        this.ipd = this.pkq.Ou();
                    }
                    this.pkq.aJw();
                }
            });
            this.pkj.setOnFocusChangeListener(this);
        }
        aJw();
        if (this.pkj != null) {
            if (this.ipa == 2) {
                this.pkj.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView pkq;

                    {
                        this.pkq = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.ipa == 4) {
                this.pkj.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView pkq;

                    {
                        this.pkq = r1;
                    }

                    public final int getInputType() {
                        return 1;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.ipa == 128) {
                this.pkj.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.pkj.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView pkq;

                    {
                        this.pkq = r1;
                    }

                    public final int getInputType() {
                        return 18;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.pkj.setRawInputType(18);
            } else if (this.ipa == 3) {
                this.pkj.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView pkq;

                    {
                        this.pkq = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.pkj.setInputType(this.ipa);
            }
            if (this.ioU != -1) {
                this.pkj.setFilters(new InputFilter[]{new LengthFilter(this.ioU)});
            }
        }
        if (this.pkl != null) {
            this.pkl.bex();
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.pkj != null) {
            this.pkj.setHint(charSequence);
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.pkj.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.pkl != null && this.pkl.a(this, motionEvent)) {
            return true;
        }
        if (this.pkj != null && a(this.pkj, motionEvent) && !this.pkj.isClickable()) {
            v.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!a(this.ioA, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            v.d("MicroMsg.WalletFormView", "hy: click on info iv");
            aJw();
            this.ioA.performClick();
            return true;
        }
    }

    final boolean a(View view, MotionEvent motionEvent) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect;
        if (view != null) {
            rect = new Rect();
            view.getHitRect(rect);
            if (view == this.ioA) {
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
            }
        } else {
            rect = null;
        }
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return false;
    }

    private void bLK() {
        if (this.eXB != null) {
            this.eXB.setText(this.ioI);
            this.eXB.setVisibility(this.ioJ);
        }
    }

    public final void setSelection(int i) {
        if (this.pkj != null) {
            this.pkj.setSelection(i);
        }
    }

    public final String getText() {
        if (this.pkj != null) {
            String a = com.tencent.mm.wallet_core.ui.formview.c.a.a(this.pko, this.pkj);
            if (this.pkm == null || !this.pkm.aJv()) {
                return a;
            }
            return this.pkm.e(this, a);
        }
        v.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.pkj != null) {
            return this.pkj.getKeyListener();
        }
        v.w("MicroMsg.WalletFormView", "hy: no content et");
        return null;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void k(OnClickListener onClickListener) {
        this.ioE = onClickListener;
        if (this.ioA != null) {
            this.ioA.setOnClickListener(this.ioE);
        }
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.ioD = onFocusChangeListener;
    }

    public final void a(TextWatcher textWatcher) {
        if (this.pkj != null) {
            this.pkj.addTextChangedListener(textWatcher);
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.pkj != null) {
            this.pkj.setKeyListener(keyListener);
        }
    }

    public final boolean Ou() {
        if (this.pkj != null) {
            int inputLength = this.pkj.getInputLength();
            if (inputLength > this.ioU || inputLength < this.ioV) {
                return false;
            }
            if (this.pkm != null) {
                return this.pkm.h(this);
            }
            return true;
        }
        v.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        return true;
    }

    public final void aJx() {
        if (this.pkj != null) {
            this.pkj.ClearInput();
        }
    }

    public final boolean de(View view) {
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            return true;
        } else if (be.kS(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.eXB == null) {
                return false;
            }
            this.eXB.setEnabled(true);
            return false;
        } else if (Ou()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.eXB != null) {
                this.eXB.setEnabled(true);
            }
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.eXB == null) {
                return false;
            }
            this.eXB.setEnabled(false);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.pkj != null) {
            this.pkj.setFilters(inputFilterArr);
        }
    }

    private int getInputLength() {
        return this.pkj != null ? this.pkj.getInputLength() : 0;
    }

    public final void bLL() {
        if (this.pkj != null) {
            this.pkj.setFocusable(true);
            this.pkj.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.pkj, 0);
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.ioD != null) {
            this.ioD.onFocusChange(this, z);
        }
        if (this.pkk != null) {
            this.pkk.fc(Ou());
        }
        if (Ou()) {
            if (this.eXB != null) {
                this.eXB.setEnabled(true);
            }
        } else if (this.eXB != null) {
            this.eXB.setEnabled(false);
        }
        aJw();
    }
}
