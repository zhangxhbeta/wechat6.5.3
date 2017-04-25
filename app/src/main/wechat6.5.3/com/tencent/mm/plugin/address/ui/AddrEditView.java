package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class AddrEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    a dxL;
    b dxM;
    private OnFocusChangeListener dxN;
    private TextView dxO;
    EditText dxP;
    private ImageView dxQ;
    private String dxR;
    private String dxS;
    private int dxT;
    private int dxU;
    public boolean dxV;
    private int dxW;
    private boolean dxX;
    private int dxY;
    private int dxZ;
    private boolean dya;
    private OnClickListener dyb;
    private String dyc;
    private int gravity;
    private int imeOptions;
    private int inputType;

    public interface a {
        void onClick();
    }

    public interface b {
        void Ow();
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dxR = "";
        this.dxS = "";
        this.inputType = 1;
        this.gravity = 19;
        this.dxT = -1;
        this.background = -1;
        this.dxU = -1;
        this.dxV = true;
        this.dxX = false;
        this.dxY = 1;
        this.dxZ = 30;
        this.dya = true;
        this.dyb = new OnClickListener(this) {
            final /* synthetic */ AddrEditView dyd;

            {
                this.dyd = r1;
            }

            public final void onClick(View view) {
                if (this.dyd.dxQ.getVisibility() != 0) {
                    return;
                }
                if (this.dyd.dxV && this.dyd.dxT != 2 && !be.kS(this.dyd.getText())) {
                    this.dyd.dxP.setText("");
                    this.dyd.bs(this.dyd.dxP.isFocused());
                } else if (this.dyd.dxL != null) {
                    this.dyd.dxL.onClick();
                }
            }
        };
        this.dyc = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOS, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.dxR = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.dxS = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(3, 1);
        this.dxT = obtainStyledAttributes.getInteger(7, 0);
        this.dxV = obtainStyledAttributes.getBoolean(10, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(4, 5);
        this.background = obtainStyledAttributes.getResourceId(1, 2130839576);
        this.dxW = obtainStyledAttributes.getResourceId(12, -1);
        this.dxU = obtainStyledAttributes.getResourceId(9, 2130839576);
        this.dya = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130903087, this, true);
        this.dxP = (EditText) inflate.findViewById(2131755315);
        this.dxP.setTextSize(0, (float) com.tencent.mm.bd.a.N(context, 2131493169));
        this.dxO = (TextView) inflate.findViewById(2131755314);
        this.dxQ = (ImageView) inflate.findViewById(2131755316);
        this.dxQ.setOnClickListener(this.dyb);
        this.dxP.setImeOptions(this.imeOptions);
        this.dxP.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.dxP.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ AddrEditView dyd;

                {
                    this.dyd = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 3) {
            this.dxP.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ AddrEditView dyd;

                {
                    this.dyd = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else {
            this.dxP.setInputType(this.inputType);
        }
        bs(this.dxP.isFocused());
        this.dxP.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AddrEditView dyd;

            {
                this.dyd = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean Ou = this.dyd.Ou();
                if (!(Ou == this.dyd.dxX || this.dyd.dxM == null)) {
                    v.d("MicroMsg.AddrEditView", "View:" + this.dyd.dxS + ", editType:" + this.dyd.dxT + " inputValid change to " + Ou);
                    this.dyd.dxX = Ou;
                    this.dyd.dxM.Ow();
                }
                this.dyd.bs(this.dyd.dxP.isFocused());
            }
        });
        this.dxP.setOnFocusChangeListener(this);
        if (!be.kS(this.dxR)) {
            this.dxP.setHint(this.dxR);
        }
        if (!be.kS(this.dxS)) {
            this.dxO.setText(this.dxS);
        }
        Rect rect = new Rect();
        b(this.dxP, rect);
        if (this.dxV) {
            this.dxX = false;
            this.dxP.setBackgroundResource(this.dxU);
            setBackgroundResource(this.background);
        } else {
            this.dxP.setEnabled(false);
            this.dxP.setTextColor(getResources().getColor(2131689508));
            this.dxP.setFocusable(false);
            this.dxP.setClickable(false);
            this.dxP.setBackgroundResource(2130839576);
            setBackgroundResource(2130838046);
            setPadding(com.tencent.mm.bd.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(this.dxP, rect);
        this.dxP.setGravity(this.gravity);
        if (this.dxW != -1) {
            this.dxQ.setImageResource(this.dxW);
        }
        if (!this.dya) {
            this.dxP.setSingleLine(false);
        }
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String getText() {
        return this.dxP.getText().toString();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.dxV = z;
        this.dxQ.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dxV) {
            boolean z;
            if (this.dxQ.getVisibility() == 0) {
                Rect rect = new Rect();
                this.dxQ.getHitRect(rect);
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
                z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final boolean Ou() {
        String obj = this.dxP.getText().toString();
        switch (this.dxT) {
            case 1:
                if (obj.length() >= this.dxY && obj.length() <= this.dxZ) {
                    if (obj == null) {
                        obj = null;
                    } else {
                        obj = obj.replaceAll("\\D", "");
                        if (obj.startsWith("86")) {
                            obj = obj.substring(2);
                        }
                    }
                    if (PhoneNumberUtils.isGlobalPhoneNumber(obj)) {
                        return true;
                    }
                }
                return false;
            default:
                if (obj.length() >= this.dxY) {
                    return true;
                }
                return false;
        }
    }

    private void bs(boolean z) {
        if (!this.dxV || be.kS(getText())) {
            switch (this.dxT) {
                case 0:
                case 1:
                    this.dxQ.setVisibility(8);
                    return;
                case 2:
                    this.dxQ.setVisibility(0);
                    this.dxQ.setImageResource(2131166014);
                    this.dxQ.setContentDescription(getContext().getString(2131230839));
                    return;
                case 3:
                    this.dxQ.setVisibility(0);
                    this.dxQ.setImageResource(2131166015);
                    this.dxQ.setContentDescription(getContext().getString(2131230860));
                    return;
                default:
                    this.dxQ.setVisibility(8);
                    return;
            }
        }
        this.dxQ.setImageResource(2130838465);
        this.dxQ.setContentDescription(getContext().getString(2131231938));
        switch (this.dxT) {
            case 0:
            case 1:
                if (z) {
                    this.dxQ.setVisibility(0);
                    return;
                } else {
                    this.dxQ.setVisibility(8);
                    return;
                }
            case 2:
                this.dxQ.setVisibility(0);
                this.dxQ.setImageResource(2131166014);
                this.dxQ.setContentDescription(getContext().getString(2131230839));
                return;
            case 3:
                this.dxQ.setVisibility(0);
                this.dxQ.setImageResource(2131166015);
                this.dxQ.setContentDescription(getContext().getString(2131230860));
                return;
            default:
                this.dxQ.setVisibility(8);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.dxN = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.dxN != null) {
            this.dxN.onFocusChange(this, z);
        }
        v.d("MicroMsg.AddrEditView", "View:" + this.dxS + ", editType:" + this.dxT + " onFocusChange to " + z);
        if (this.dxM != null) {
            this.dxM.Ow();
        }
        if (this.dxX) {
            this.dxO.setEnabled(true);
        } else {
            this.dxO.setEnabled(false);
        }
        if (view == this.dxP) {
            Rect rect = new Rect();
            b((View) this, rect);
            if (z) {
                setBackgroundResource(2130838423);
            } else {
                setBackgroundResource(2130838424);
            }
            c(this, rect);
        }
        bs(z);
    }

    public final void mo(String str) {
        this.dxP.setText(str);
        this.dxP.setSelection(this.dxP.getText().length());
        this.dyc = str;
    }

    public final boolean Ov() {
        if (getText().equals(be.ma(this.dyc))) {
            return false;
        }
        return true;
    }

    private static void b(View view, Rect rect) {
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
    }

    private static void c(View view, Rect rect) {
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
