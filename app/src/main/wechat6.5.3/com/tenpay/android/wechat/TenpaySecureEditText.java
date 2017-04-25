package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.v;
import com.tenpay.android.jni.Encrypt;
import com.tenpay.bankcard.LogUtil;
import java.util.regex.Pattern;

public final class TenpaySecureEditText extends EditText {
    public static final int AREA_ID_CARD_TYPE_HUIXIANG = 5;
    public static final int AREA_ID_CARD_TYPE_SHENFEN = 1;
    public static final int AREA_ID_CARD_TYPE_TAIBAO = 9;
    private static int BANK_CARD_LENGTH_LIMIT = 14;
    private static int CARD_TAIL_SPACE = 15;
    private static int CVV_4_PAYMENT_LENGTH = 4;
    private static int CVV_PAYMENT_LENGTH = 3;
    private static int PASSWD_BLACK_DOT_SIZE = 7;
    private static int PASSWD_LEFT_PADDING = -1500000;
    private static int PASSWD_LENGTH = 6;
    private static final String TAG = "MicroMsg.TenpaySecureEditText";
    private static int VALID_THRU_LEN = 4;
    private static String mTimeStamp;
    private String mCardTailNum;
    private Drawable mClearBtnImg;
    private float mDensity;
    EditState mEditState;
    private char[] mFilterChar;
    private ISecureEncrypt mIEncrypt;
    private boolean mIsCardTailNumCanDisplay;
    private boolean mIsSelfSet;
    private Paint mPaintBackground;
    private OnPasswdInputListener mPasswdListener;
    private Paint mTitlePaint;

    public enum EditState {
        DEFAULT,
        PASSWORD,
        BANKCARD,
        BANKCARD_WITH_TAILNUM,
        VALID_THRU,
        MONEY_AMOUNT,
        CVV_PAYMENT,
        CVV_4_PAYMENT,
        SECURITY_ANSWER
    }

    public TenpaySecureEditText(Context context) {
        this(context, null);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mDensity = getResources().getDisplayMetrics().density;
        if (attributeSet != null) {
            int[] resourceDeclareStyleableIntArray = TenpayUtil.getResourceDeclareStyleableIntArray(context, "TenpaySecureEditText");
            if (resourceDeclareStyleableIntArray != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, resourceDeclareStyleableIntArray);
                if (obtainStyledAttributes != null) {
                    setIsPasswordFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isPassword"), false));
                    setIsBankcardFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isBankcard"), false));
                    setIsValidThru(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isValidThru"), false));
                    setBankcardTailNum(obtainStyledAttributes.getString(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_bankcardTailNum")));
                    int resourceId = obtainStyledAttributes.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_rightClearDrawable"), 0);
                    if (resourceId != 0) {
                        setClearBtnDrawableId(resourceId);
                    }
                    obtainStyledAttributes.recycle();
                }
            }
        }
        addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public final void setClearBtnDrawableId(int i) {
        try {
            this.mClearBtnImg = getResources().getDrawable(i);
        } catch (Exception e) {
            this.mClearBtnImg = null;
        }
        if (this.mClearBtnImg != null) {
            this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
            setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], null, TenpaySecureEditText.this.getCompoundDrawables()[3]);
                    } else if (!TenpaySecureEditText.this.getText().toString().equals("") && EditState.PASSWORD != TenpaySecureEditText.this.mEditState && EditState.CVV_PAYMENT != TenpaySecureEditText.this.mEditState && EditState.CVV_4_PAYMENT != TenpaySecureEditText.this.mEditState) {
                        TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], TenpaySecureEditText.this.mClearBtnImg, TenpaySecureEditText.this.getCompoundDrawables()[3]);
                    }
                }
            });
            setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!(EditState.PASSWORD == TenpaySecureEditText.this.mEditState || EditState.CVV_PAYMENT == TenpaySecureEditText.this.mEditState || EditState.CVV_4_PAYMENT == TenpaySecureEditText.this.mEditState)) {
                        TenpaySecureEditText tenpaySecureEditText = TenpaySecureEditText.this;
                        if (tenpaySecureEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((tenpaySecureEditText.getWidth() - tenpaySecureEditText.getPaddingRight()) - TenpaySecureEditText.this.mClearBtnImg.getIntrinsicWidth()))) {
                            tenpaySecureEditText.setText("");
                        }
                    }
                    return false;
                }
            });
            return;
        }
        setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public final void setIsPasswordFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(-16777216);
            this.mEditState = EditState.PASSWORD;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.PASSWORD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsSecurityAnswerFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.SECURITY_ANSWER;
        } else {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsCvvPaymentFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(-16777216);
            this.mEditState = EditState.CVV_PAYMENT;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsCvv4PaymentFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(-16777216);
            this.mEditState = EditState.CVV_4_PAYMENT;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_4_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsValidThru(boolean z) {
        if (z) {
            this.mEditState = EditState.VALID_THRU;
        } else if (EditState.VALID_THRU == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setValidThru(String str) {
        if (str != null && str.length() == VALID_THRU_LEN) {
            setText(str);
            this.mEditState = EditState.VALID_THRU;
        }
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setBankcardTailNum(String str) {
        this.mCardTailNum = str;
        if (str != null && str.length() > 0) {
            this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
            this.mTitlePaint = new Paint();
            this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mTitlePaint.setAntiAlias(true);
            this.mTitlePaint.setTextSize(getTextSize());
            this.mTitlePaint.setColor(-16777216);
        }
    }

    public final void setIsMoneyAmountFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.MONEY_AMOUNT;
        } else if (EditState.MONEY_AMOUNT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setFilterChar(char[] cArr) {
        this.mFilterChar = cArr;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.mEditState == EditState.PASSWORD || this.mEditState == EditState.CVV_PAYMENT || this.mEditState == EditState.CVV_4_PAYMENT) {
            drawPasswdDot(canvas);
            drawCvvPaymentDot(canvas);
            drawCvv4PaymentDot(canvas);
            return;
        }
        super.onDraw(canvas);
        drawCardTailNum(canvas);
    }

    private void drawPasswdDot(Canvas canvas) {
        if (EditState.PASSWORD == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / PASSWD_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCvvPaymentDot(Canvas canvas) {
        if (EditState.CVV_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCvv4PaymentDot(Canvas canvas) {
        if (EditState.CVV_4_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_4_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCardTailNum(Canvas canvas) {
        if (EditState.BANKCARD_WITH_TAILNUM == this.mEditState && this.mIsCardTailNumCanDisplay) {
            int baseline = getBaseline();
            if (baseline == -1) {
                baseline = 44;
            }
            canvas.drawText(this.mCardTailNum, (((float) CARD_TAIL_SPACE) * this.mDensity) + getPaint().measureText(getText().toString()), (float) baseline, this.mTitlePaint);
        }
    }

    public final boolean onTextContextMenuItem(int i) {
        if ((getInputType() & 128) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    protected final void onCreateContextMenu(ContextMenu contextMenu) {
        if ((getInputType() & 128) <= 0 && EditState.PASSWORD != this.mEditState && EditState.CVV_PAYMENT != this.mEditState && EditState.CVV_4_PAYMENT != this.mEditState) {
            super.onCreateContextMenu(contextMenu);
        }
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        String obj;
        if (this.mEditState == EditState.SECURITY_ANSWER) {
            obj = getText().toString();
        } else {
            obj = getText().toString().trim();
        }
        if (obj == null || obj.length() == 0) {
            return null;
        }
        switch (this.mEditState) {
            case BANKCARD:
                return obj.replaceAll(" ", "");
            case BANKCARD_WITH_TAILNUM:
                obj = obj.replaceAll(" ", "");
                if (this.mCardTailNum == null || this.mCardTailNum.length() <= 0) {
                    return obj;
                }
                return obj + this.mCardTailNum;
            case VALID_THRU:
                obj = obj.replaceAll("/", "");
                if (obj == null || obj.length() != VALID_THRU_LEN) {
                    return obj;
                }
                return obj.substring(2) + obj.substring(0, 2);
            case SECURITY_ANSWER:
                return obj;
            default:
                return obj.replaceAll(" ", "").replaceAll("x", "X");
        }
    }

    public final void setSecureEncrypt(ISecureEncrypt iSecureEncrypt) {
        this.mIEncrypt = iSecureEncrypt;
    }

    public final String getEncryptDataWithHash(boolean z) {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt != null) {
            return this.mIEncrypt.encryptPasswd(z, inputText, mTimeStamp);
        }
        if (z) {
            inputText = TenpayUtil.md5HexDigest(inputText);
        }
        Encrypt encrypt = new Encrypt();
        if (mTimeStamp != null) {
            encrypt.setTimeStamp(mTimeStamp);
        }
        return encrypt.encryptPasswd(inputText);
    }

    public final String get3DesEncrptData() {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt != null) {
            return this.mIEncrypt.desedeEncode(inputText, mTimeStamp);
        }
        return new Encrypt().desedeEncode(inputText);
    }

    public final void set3DesEncrptData(String str) {
        if (str != null && str.length() != 0) {
            LogUtil.d("MyTag", "set3DesEncrptData ");
            LogUtil.d("MyTag", "data = " + str);
            Encrypt encrypt = new Encrypt();
            LogUtil.d("MyTag", "decoded = " + encrypt.desedeDecode(str, encrypt.getRandomKey()));
            setText(r0);
        }
    }

    public final String get3DesVerifyCode() {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt != null) {
            return this.mIEncrypt.desedeVerifyCode(inputText, mTimeStamp);
        }
        return new Encrypt().desedeVerifyCode(inputText);
    }

    public final boolean isPhoneNum() {
        if (getText().toString().trim().length() == 11 || getText().toString().contains("**")) {
            return true;
        }
        return false;
    }

    public final boolean isBankcardNum() {
        return getInputLength() >= BANK_CARD_LENGTH_LIMIT || getText().toString().contains("**");
    }

    public final boolean isMoneyAmount() {
        return isMatchPattern("^\\d+(\\.\\d{0,2})?$");
    }

    public final boolean isUserIdNum() {
        String trim = getText().toString().trim();
        if (getInputLength() == 15) {
            return isMatchPattern("^\\d{15}$");
        }
        return TenpayUtil.invalidateID(trim);
    }

    public final boolean isValidThru() {
        return isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
    }

    public final boolean isAreaIDCardNum(int i) {
        String trim = getText().toString().trim();
        if (trim == null || trim.length() == 0) {
            return false;
        }
        trim.replaceAll(" ", "");
        switch (i) {
            case 1:
                return isUserIdNum();
            default:
                return true;
        }
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[z]);
            }
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[z]);
            }
        }
        return z;
    }

    public final void ClearInput() {
        setText("");
    }

    public final int getInputLength() {
        String inputText = getInputText();
        if (inputText == null) {
            return 0;
        }
        return inputText.length();
    }

    protected final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        super.onTextChanged(charSequence, i, i2, i3);
        if (!(this.mFilterChar == null || TextUtils.isEmpty(charSequence))) {
            for (int i5 = i; i5 < i + i3; i5++) {
                for (char c : this.mFilterChar) {
                    if (c == charSequence.charAt(i5)) {
                        String charSequence2 = charSequence.toString();
                        setText(charSequence2.substring(0, i5) + charSequence2.substring(i5 + 1));
                        setSelection(i5);
                        return;
                    }
                }
            }
        }
        String obj = getText().toString();
        boolean z = obj != null && obj.length() > 0;
        this.mIsCardTailNumCanDisplay = z;
        if (!(!isFocused() || this.mClearBtnImg == null || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            if (getText().toString().equals("")) {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
            }
        }
        if (this.mEditState != null) {
            try {
                int length;
                int length2;
                switch (this.mEditState) {
                    case BANKCARD:
                    case BANKCARD_WITH_TAILNUM:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            return;
                        }
                        int i6 = i + i3;
                        if (obj.length() > 0) {
                            if (i6 <= obj.length()) {
                                charSequence2 = obj.substring(0, i6);
                                length = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                length = 0;
                            }
                            String replaceAll = obj.replaceAll(" ", "");
                            StringBuffer stringBuffer = new StringBuffer();
                            length2 = replaceAll.length();
                            i4 = 0;
                            while (i4 + 4 < length2) {
                                stringBuffer.append(replaceAll.substring(i4, i4 + 4));
                                stringBuffer.append(" ");
                                i4 += 4;
                            }
                            stringBuffer.append(replaceAll.substring(i4));
                            replaceAll = stringBuffer.toString();
                            if (i6 <= replaceAll.length()) {
                                charSequence2 = replaceAll.substring(0, i6);
                                i4 = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                i4 = replaceAll.length() - replaceAll.replaceAll(" ", "").length();
                            }
                            i4 = (i4 + i6) - length;
                            this.mIsSelfSet = true;
                            setText(replaceAll);
                            setSelection(i4);
                            return;
                        }
                        return;
                    case VALID_THRU:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            return;
                        }
                        length2 = obj.length();
                        if (length2 != 0 && length2 != 1) {
                            CharSequence replace = obj.replace("/", "");
                            if (!(length2 == 2 && obj.contains("/"))) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(replace.substring(0, 2));
                                stringBuilder.append("/");
                                if (replace.length() > 2) {
                                    stringBuilder.append(replace.substring(2));
                                }
                                replace = stringBuilder.toString();
                            }
                            length = getSelectionStart();
                            this.mIsSelfSet = true;
                            setText(replace);
                            if (length2 != 2) {
                                setSelection(length);
                                return;
                            } else if (obj.contains("/")) {
                                setSelection(1);
                                return;
                            } else if (length == 2) {
                                setSelection(i3 > i2 ? 3 : 2);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case PASSWORD:
                        if (obj.length() == PASSWD_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    case CVV_PAYMENT:
                        if (obj.length() == CVV_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    case CVV_4_PAYMENT:
                        if (obj.length() == CVV_4_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
            v.a(TAG, e, "", new Object[0]);
        }
    }

    public final void setOnPasswdInputListener(OnPasswdInputListener onPasswdInputListener) {
        this.mPasswdListener = onPasswdInputListener;
    }
}
