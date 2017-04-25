package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.R;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.b.q;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener dxN;
    private TextView dxO;
    private ImageView dxQ;
    private String dxR;
    private String dxS;
    private int dxT;
    private int dxU;
    public boolean dxV;
    private boolean dxX;
    private int dxY;
    private int dxZ;
    private OnClickListener dyb;
    private int gravity;
    private boolean imS;
    private int imeOptions;
    private int inputType;
    private int mode;
    public boolean ocP;
    private a pjA;
    private b pjo;
    private TextView pjp;
    TenpaySecureEditText pjq;
    private int pjr;
    private int pjs;
    private int pjt;
    private boolean pju;
    private String pjv;
    private DatePickerDialog pjw;
    private int pjx;
    private int pjy;
    private h pjz;

    public interface a {
    }

    public interface b {
    }

    static /* synthetic */ void o(EditHintView editHintView) {
        int bLn;
        int bLo;
        switch (editHintView.dxT) {
            case 3:
                editHintView.getContext();
                bLn = q.bLn();
                editHintView.getContext();
                bLo = q.bLo();
                break;
            case 4:
                editHintView.getContext();
                bLn = q.bLp();
                bLo = 2131232258;
                break;
            case NetStatusUtil.MOBILE /*9*/:
                bLn = 2130904672;
                bLo = 2131236114;
                break;
            case NetStatusUtil.LTE /*10*/:
                bLn = 2130904653;
                bLo = 2131236108;
                break;
            default:
                bLo = -1;
                bLn = -1;
                break;
        }
        if (bLn != -1) {
            if (editHintView.pjz == null) {
                editHintView.pjz = b.a(editHintView.getContext(), bLn, editHintView.getResources().getString(bLo), editHintView.getResources().getString(2131234768), new DialogInterface.OnClickListener(editHintView) {
                    final /* synthetic */ EditHintView pjB;

                    {
                        this.pjB = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pjB.pjz.dismiss();
                    }
                });
            }
            editHintView.pjz.show();
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dxR = "";
        this.dxS = "";
        this.inputType = 1;
        this.imS = true;
        this.dxZ = -1;
        this.dxY = 1;
        this.gravity = 19;
        this.pjr = -1;
        this.dxT = -1;
        this.dxX = false;
        this.pjs = 1;
        this.pjt = -1;
        this.background = -1;
        this.dxU = -1;
        this.dxV = true;
        this.ocP = true;
        this.pju = true;
        this.pjv = null;
        this.mode = 0;
        this.pjw = null;
        this.pjx = 0;
        this.pjy = 0;
        this.dyb = new OnClickListener(this) {
            final /* synthetic */ EditHintView pjB;

            {
                this.pjB = r1;
            }

            public final void onClick(View view) {
                if (this.pjB.dxQ.getVisibility() != 0) {
                    return;
                }
                if (this.pjB.dxV && !be.kS(this.pjB.getText())) {
                    this.pjB.pjq.ClearInput();
                } else if (this.pjB.dxT != 1) {
                    EditHintView.o(this.pjB);
                } else if (this.pjB.pjA != null && this.pjB.pju) {
                }
            }
        };
        this.pjz = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPd, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.dxR = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.dxS = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.dxV = obtainStyledAttributes.getBoolean(11, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imS = obtainStyledAttributes.getBoolean(2, true);
        this.dxZ = obtainStyledAttributes.getInteger(12, -1);
        this.dxT = obtainStyledAttributes.getInteger(8, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        this.pjt = obtainStyledAttributes.getColor(9, 2131689547);
        this.background = obtainStyledAttributes.getResourceId(1, -1);
        this.dxU = obtainStyledAttributes.getResourceId(10, 2130838136);
        this.dxY = obtainStyledAttributes.getInteger(13, 1);
        this.ocP = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        View inflate = com.tencent.mm.ui.q.em(context).inflate(2130903469, this, true);
        this.pjq = (TenpaySecureEditText) inflate.findViewById(2131755315);
        this.dxO = (TextView) inflate.findViewById(2131755314);
        this.pjp = (TextView) inflate.findViewById(2131756627);
        this.dxQ = (ImageView) inflate.findViewById(2131755316);
        this.pjq.setImeOptions(this.imeOptions);
        switch (this.dxT) {
            case 0:
                break;
            case 1:
                this.dxZ = 25;
                this.pjq.setIsBankcardFormat(true);
                this.inputType = 2;
                break;
            case 2:
            case NetStatusUtil.MOBILE /*9*/:
                this.dxZ = 30;
                this.inputType = 3;
                break;
            case 3:
                this.dxV = false;
                this.pjq.setIsValidThru(true);
                setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ EditHintView pjB;

                    {
                        this.pjB = r1;
                    }

                    public final void onClick(View view) {
                        if (this.pjB.pjw == null) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(System.currentTimeMillis());
                            instance.add(2, 1);
                            this.pjB.pjx = instance.get(1);
                            this.pjB.pjy = instance.get(2);
                            this.pjB.pjw = new g(this.pjB.getContext(), new OnDateSetListener(this) {
                                final /* synthetic */ AnonymousClass6 pjC;

                                {
                                    this.pjC = r1;
                                }

                                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                                    if (i >= this.pjC.pjB.pjx || i2 >= this.pjC.pjB.pjy) {
                                        DecimalFormat decimalFormat = new DecimalFormat("00");
                                        if (k.xT()) {
                                            this.pjC.pjB.pjv = decimalFormat.format((long) (i2 + 1)) + i;
                                        } else {
                                            this.pjC.pjB.pjv = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
                                        }
                                        this.pjC.pjB.pjq.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                                    } else {
                                        com.tencent.mm.ui.base.g.A(this.pjC.pjB.getContext(), this.pjC.pjB.getContext().getString(2131236172), null);
                                    }
                                    this.pjC.pjB.dxX = this.pjC.pjB.Ou();
                                    if (this.pjC.pjB.pjo != null) {
                                        v.d("MicroMsg.EditHintView", "View:" + this.pjC.pjB.dxS + ", editType:" + this.pjC.pjB.dxT + " inputValid change to " + this.pjC.pjB.dxX);
                                    }
                                }
                            }, this.pjB.pjx, this.pjB.pjy, instance.get(5), instance.getTimeInMillis());
                        }
                        this.pjB.pjw.show();
                    }
                });
                break;
            case 4:
                this.dxZ = 4;
                this.inputType = 2;
                break;
            case 5:
                this.dxZ = 18;
                this.inputType = 4;
                break;
            case 6:
                this.dxZ = 6;
                this.dxO.setVisibility(8);
                this.inputType = 2;
                break;
            case 7:
            case 17:
                this.dxZ = 6;
                this.dxO.setVisibility(8);
                this.pjq.setIsPasswordFormat(true);
                this.pjq.setImeOptions(6);
                this.inputType = 128;
                break;
            case 8:
                this.inputType = 32;
                break;
            case NetStatusUtil.LTE /*10*/:
                if (!this.dxV && this.imS) {
                    break;
                }
            case 12:
                this.dxZ = 12;
                this.pjq.setIsMoneyAmountFormat(true);
                break;
            case 13:
            case 16:
                this.pjq.setIsSecurityAnswerFormat(true);
                break;
            case 14:
                this.dxZ = 3;
                this.dxO.setVisibility(8);
                this.pjq.setIsCvvPaymentFormat(true);
                this.pjq.setImeOptions(6);
                this.inputType = 128;
                break;
            case 15:
                this.dxZ = 4;
                this.dxO.setVisibility(8);
                this.pjq.setIsCvv4PaymentFormat(true);
                this.pjq.setImeOptions(6);
                this.inputType = 128;
                break;
            default:
                this.inputType = 1;
                break;
        }
        bLu();
        this.pjq.setSingleLine(this.ocP);
        if (!this.ocP) {
            this.pjq.setMaxLines(1073741823);
        }
        this.dxQ.setOnClickListener(this.dyb);
        this.pjq.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ EditHintView pjB;

            {
                this.pjB = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.pjB.mode == 4 && this.pjB.Ou()) {
                    this.pjB.mode = 0;
                    this.pjB.pjq.ClearInput();
                }
            }

            public final void afterTextChanged(Editable editable) {
                boolean Ou = this.pjB.Ou();
                if (!(Ou == this.pjB.dxX || this.pjB.pjo == null)) {
                    v.d("MicroMsg.EditHintView", "View:" + this.pjB.dxS + ", editType:" + this.pjB.dxT + " inputValid change to " + Ou);
                    this.pjB.dxX = Ou;
                }
                this.pjB.bLu();
            }
        });
        this.pjq.setOnFocusChangeListener(this);
        if (!be.kS(this.dxR)) {
            this.pjq.setHint(this.dxR);
        }
        if (!be.kS(this.dxS)) {
            this.dxO.setText(this.dxS);
        }
        this.pjq.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.pjq.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView pjB;

                {
                    this.pjB = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 4) {
            this.pjq.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView pjB;

                {
                    this.pjB = r1;
                }

                public final int getInputType() {
                    return 1;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
        } else if (this.inputType == 128) {
            this.pjq.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.pjq.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView pjB;

                {
                    this.pjB = r1;
                }

                public final int getInputType() {
                    return 18;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
            this.pjq.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.pjq.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView pjB;

                {
                    this.pjB = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                }
            });
        } else {
            this.pjq.setInputType(this.inputType);
        }
        if (this.dxZ != -1) {
            this.pjq.setFilters(new InputFilter[]{new LengthFilter(this.dxZ)});
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.imS) {
            this.pjq.setEnabled(false);
            this.pjq.setTextColor(getResources().getColor(this.pjt));
            this.pjq.setFocusable(false);
            this.pjq.setClickable(false);
            this.pjq.setBackgroundResource(2130839576);
            setBackgroundResource(2130838468);
        }
        if (this.dxV) {
            this.dxX = false;
            this.pjq.setBackgroundResource(this.dxU);
            setBackgroundResource(2130839576);
        } else {
            this.dxX = true;
            this.pjq.setEnabled(false);
            this.pjq.setTextColor(getResources().getColor(2131689820));
            this.pjq.setFocusable(false);
            this.pjq.setClickable(false);
            this.pjq.setBackgroundResource(2130839576);
            setBackgroundResource(2130838046);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.dxO == null || this.pjr == -1)) {
            LayoutParams layoutParams = this.dxO.getLayoutParams();
            layoutParams.width = this.pjr;
            this.dxO.setLayoutParams(layoutParams);
        }
        if (k.xT()) {
            int i2;
            TenpaySecureEditText tenpaySecureEditText = this.pjq;
            switch (this.dxT) {
                case 1:
                    i2 = 50;
                    break;
                case 4:
                case 14:
                case 15:
                    i2 = 30;
                    break;
                case 6:
                    i2 = 60;
                    break;
                case 7:
                    i2 = 20;
                    break;
                case 13:
                    i2 = 40;
                    break;
                case 16:
                    i2 = -20;
                    break;
                case 17:
                    i2 = -10;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i2));
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onMeasure(int i, int i2) {
        if (this.dxT == 7 || this.dxT == 17 || this.dxT == 14 || this.dxT == 15) {
            int i3;
            setMeasuredDimension(getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 960.0f), i), getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 720.0f), i2));
            int measuredWidth = getMeasuredWidth();
            if (this.dxT == 7 || this.dxT == 17) {
                i3 = measuredWidth / 6;
            } else if (this.dxT == 14) {
                i3 = measuredWidth / 3;
            } else {
                i3 = measuredWidth / 4;
            }
            i = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i), getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
    }

    public final String getText() {
        switch (this.dxT) {
            case 0:
            case 8:
            case NetStatusUtil.LTE /*10*/:
                return be.ah(this.pjq.getText().toString(), "");
            case 1:
            case 13:
            case 16:
                return this.pjq.getEncryptDataWithHash(false);
            case 2:
            case NetStatusUtil.MOBILE /*9*/:
                return be.ah(this.pjq.getText().toString(), "");
            case 3:
                return be.ah(this.pjv, "").replace("/", "");
            case 4:
            case 14:
            case 15:
                return this.pjq.get3DesEncrptData();
            case 5:
                return this.pjq.get3DesEncrptData();
            case 6:
                return this.pjq.get3DesVerifyCode();
            case 7:
                return this.pjq.getEncryptDataWithHash(true);
            default:
                return be.ah(this.pjq.getText().toString(), "");
        }
    }

    public final boolean Ou() {
        if (!this.dxV && !this.imS) {
            return true;
        }
        switch (this.dxT) {
            case 1:
                return this.pjq.isBankcardNum();
            case 4:
                if (this.pjq.getInputLength() <= 0) {
                    return false;
                }
                return true;
            case 5:
                return this.pjq.isAreaIDCardNum(this.pjs);
            case 7:
            case 17:
                if (this.pjq.getInputLength() != 6) {
                    return false;
                }
                return true;
            case 8:
                return be.Kx(this.pjq.getText().toString());
            case NetStatusUtil.MOBILE /*9*/:
                return this.pjq.isPhoneNum();
            case 12:
                return this.pjq.isMoneyAmount();
            case 14:
                if (this.pjq.getInputLength() != 3) {
                    return false;
                }
                return true;
            case 15:
                if (this.pjq.getInputLength() != 4) {
                    return false;
                }
                return true;
            default:
                if (this.pjq.getInputLength() < this.dxY) {
                    return false;
                }
                return true;
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.dxV = z;
        this.dxQ.setEnabled(true);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.imS = z;
        if (z) {
            this.pjq.setEnabled(true);
            if (this.dxV) {
                this.pjq.setTextColor(getResources().getColor(this.pjt));
            } else {
                this.pjq.setTextColor(getResources().getColor(2131689820));
            }
            this.pjq.setFocusable(true);
            this.pjq.setClickable(true);
            return;
        }
        this.pjq.setEnabled(false);
        if (this.dxV) {
            this.pjq.setTextColor(getResources().getColor(this.pjt));
        } else {
            this.pjq.setTextColor(getResources().getColor(2131689817));
        }
        this.pjq.setFocusable(false);
        this.pjq.setClickable(false);
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

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.dxN = onFocusChangeListener;
    }

    private void bLu() {
        if (this.dxT != 7 && this.dxT != 14 && this.dxT != 15) {
            if (!this.dxV || be.kS(getText())) {
                switch (this.dxT) {
                    case 1:
                        if (this.pju) {
                            this.dxQ.setVisibility(0);
                            this.dxQ.setImageResource(2131166019);
                            return;
                        }
                        this.dxQ.setVisibility(8);
                        return;
                    case 3:
                    case 4:
                    case NetStatusUtil.MOBILE /*9*/:
                    case NetStatusUtil.LTE /*10*/:
                        this.dxQ.setVisibility(0);
                        this.dxQ.setImageResource(2130838856);
                        return;
                    default:
                        this.dxQ.setVisibility(8);
                        return;
                }
            }
            this.dxQ.setVisibility(0);
            this.dxQ.setImageResource(2130838465);
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (this.dxN != null) {
            this.dxN.onFocusChange(this, z);
        }
        v.d("MicroMsg.EditHintView", "View:" + this.dxS + ", editType:" + this.dxT + " onFocusChange to " + z);
        if (this.dxX) {
            this.dxO.setEnabled(true);
        } else {
            this.dxO.setEnabled(false);
        }
    }
}
