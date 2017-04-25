package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class MallFormView extends LinearLayout implements OnFocusChangeListener {
    private TextView eXB;
    public WalletIconImageView ioA;
    public TextView ioB;
    public a ioC;
    private OnFocusChangeListener ioD;
    private OnClickListener ioE;
    private a ioF;
    b ioG;
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
    private int ioU;
    private int ioV;
    private int ioW;
    private boolean ioX;
    private boolean ioY;
    private boolean ioZ;
    private TextView ioy;
    public EditText ioz;
    private int ipa;
    private int ipb;
    private int ipc;

    public interface a {
        void fc(boolean z);
    }

    public MallFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.eXB = null;
        this.ioy = null;
        this.ioz = null;
        this.ioA = null;
        this.ioB = null;
        this.ioC = null;
        this.ioD = null;
        this.ioE = null;
        this.ioF = null;
        this.ioG = null;
        this.ioH = -1;
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
        this.ioU = Integer.MAX_VALUE;
        this.ioV = 1;
        this.ioW = 2130838689;
        this.ioX = true;
        this.ioY = false;
        this.ioZ = true;
        this.ipa = 1;
        this.ipb = 5;
        this.ipc = 2131689822;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPr, i, 0);
        this.ioH = obtainStyledAttributes.getResourceId(2, this.ioH);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.ioI = context.getString(resourceId);
        }
        this.ioM = obtainStyledAttributes.getResourceId(4, this.ioM);
        resourceId = obtainStyledAttributes.getResourceId(5, 0);
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
        this.ioU = obtainStyledAttributes.getInteger(18, this.ioU);
        this.ioV = obtainStyledAttributes.getInteger(19, this.ioV);
        this.ioW = obtainStyledAttributes.getResourceId(20, this.ioW);
        this.ioX = obtainStyledAttributes.getBoolean(21, this.ioX);
        this.ioY = obtainStyledAttributes.getBoolean(23, this.ioY);
        this.ioZ = obtainStyledAttributes.getBoolean(21, this.ioZ);
        this.ipa = obtainStyledAttributes.getInteger(0, this.ipa);
        this.ipb = obtainStyledAttributes.getInteger(1, this.ipb);
        this.ipc = obtainStyledAttributes.getInteger(24, this.ipc);
        obtainStyledAttributes.recycle();
        if (this.ioH > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        inflate(context, this.ioH, this);
        this.eXB = (TextView) findViewById(2131755060);
        this.ioy = (TextView) findViewById(2131755058);
        this.ioz = (EditText) findViewById(2131755056);
        this.ioA = (WalletIconImageView) findViewById(2131755057);
        this.ioB = (TextView) findViewById(2131755059);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void aJw() {
        if (this.ioA != null && !be.kS(getText()) && this.ioz != null && this.ioz.isEnabled() && this.ioz.isClickable() && this.ioz.isFocusable() && this.ioz.isFocused()) {
            this.ioA.h(new OnClickListener(this) {
                final /* synthetic */ MallFormView ipe;

                {
                    this.ipe = r1;
                }

                public final void onClick(View view) {
                    this.ipe.aJx();
                }
            });
        } else if (this.ioA != null) {
            this.ioA.brg();
        } else {
            v.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (this.eXB != null) {
            this.eXB.setText(this.ioI);
            this.eXB.setVisibility(this.ioJ);
        }
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
        if (this.ioz != null) {
            int length;
            this.ioz.setHint(this.ioQ);
            this.ioz.setGravity(this.ioR);
            this.ioz.setTextColor(this.ioS);
            CharSequence charSequence = this.ioT;
            if (this.ioz != null) {
                this.ioz.setText(charSequence);
                EditText editText = this.ioz;
                if (this.ioz != null) {
                    length = this.ioz.getText().length();
                } else {
                    length = 0;
                }
                editText.setSelection(length);
            }
            this.ioz.setBackgroundResource(this.ioW);
            this.ioz.setEnabled(this.ioX);
            this.ioz.setFocusable(this.ioZ);
            this.ioz.setClickable(this.ioY);
            this.ioz.setHintTextColor(this.ipc);
            length = this.ipb;
            if (this.ioz != null) {
                this.ioz.setImeOptions(length);
            }
            length = this.ipa;
            if (this.ioz != null) {
                this.ioz.setInputType(length);
            }
            this.ioz.addTextChangedListener(new TextWatcher(this) {
                private boolean ipd = false;
                final /* synthetic */ MallFormView ipe;

                {
                    this.ipe = r2;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (this.ipe.Ou() != this.ipd) {
                        if (this.ipe.ioC != null) {
                            this.ipe.ioC.fc(this.ipe.Ou());
                        }
                        this.ipd = this.ipe.Ou();
                    }
                    this.ipe.aJw();
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
            this.ioz.setOnFocusChangeListener(this);
        }
        aJw();
        if (this.ioz != null) {
            if (this.ipa == 2) {
                this.ioz.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView ipe;

                    {
                        this.ipe = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.ipa == 4) {
                this.ioz.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView ipe;

                    {
                        this.ipe = r1;
                    }

                    public final int getInputType() {
                        return 1;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.ipa == 128) {
                this.ioz.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.ioz.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView ipe;

                    {
                        this.ipe = r1;
                    }

                    public final int getInputType() {
                        return 18;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.ioz.setRawInputType(18);
            } else if (this.ipa == 3) {
                this.ioz.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView ipe;

                    {
                        this.ipe = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.ioz.setInputType(this.ipa);
            }
            if (this.ioU != -1) {
                this.ioz.setFilters(new InputFilter[]{new LengthFilter(this.ioU)});
            }
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        if (this.ioF == null || !this.ioF.aJt()) {
            super.onMeasure(i, i2);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ioF != null && this.ioF.aJu()) {
            return true;
        }
        if (this.ioz != null && a(this.ioz, motionEvent) && !this.ioz.isClickable()) {
            v.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!a(this.ioA, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            v.d("MicroMsg.WalletFormView", "hy: click on info iv");
            this.ioA.performClick();
            return true;
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
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

    public final String getText() {
        if (this.ioz != null) {
            String obj = this.ioz.getText().toString();
            if (this.ioG == null || !this.ioG.aJv()) {
                return obj;
            }
            return this.ioG.yw(obj);
        }
        v.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.ioD = onFocusChangeListener;
    }

    public final boolean Ou() {
        if (this.ioz != null) {
            int length = this.ioz.getText() == null ? 0 : this.ioz.getText().length();
            if (length > this.ioU || length < this.ioV) {
                return false;
            }
            return this.ioG != null ? this.ioG.a(this) : true;
        } else {
            v.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            return true;
        }
    }

    public final void aJx() {
        if (this.ioz != null) {
            this.ioz.setText("");
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.ioD != null) {
            this.ioD.onFocusChange(this, z);
        }
        if (this.ioC != null) {
            this.ioC.fc(Ou());
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
