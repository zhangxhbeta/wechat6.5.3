package com.tenpay.bankcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tenpay.android.jni.Encrypt;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpayUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class TenpaySegmentEditText extends LinearLayout {
    private static final String TAG = "MyTag";
    private static String mTimeStamp;
    private final int BG_LINE_COLOR;
    private final int BG_LINE_HEIGHT;
    private final int BG_LINE_SIZE;
    private Context mContext;
    private List<EditText> mEditArray;
    EditState mEditState;
    private MyKeyboardWindow mKeyboard;
    private boolean mNoFocus;
    private OnClickListener mOnClickListener;
    private Paint mPaintBg;
    private Paint mPaintSplit;

    public enum EditState {
        DEFAULT,
        BANKCARD,
        BANKCARD_WITH_TAILNUM
    }

    public TenpaySegmentEditText(Context context) {
        this(context, null);
        this.mContext = context;
        init();
    }

    public TenpaySegmentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BG_LINE_COLOR = -11615450;
        this.BG_LINE_SIZE = 4;
        this.BG_LINE_HEIGHT = 9;
        this.mOnClickListener = null;
        this.mNoFocus = true;
        this.mEditState = EditState.DEFAULT;
        this.mContext = null;
        this.mEditArray = new ArrayList();
        this.mKeyboard = null;
        this.mContext = context;
        init();
    }

    private void init() {
        setBackgroundColor(-1);
        setOrientation(0);
        setIsBankcardFormat(true);
        this.mPaintSplit = new Paint();
        this.mPaintSplit.setStrokeWidth(0.0f);
        this.mPaintSplit.setColor(-7829368);
        this.mPaintBg = new Paint();
        this.mPaintBg.setColor(-11615450);
        this.mPaintBg.setStyle(Style.FILL);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setText(String str) {
        Encrypt encrypt = new Encrypt();
        String[] split = encrypt.desedeDecode(str, encrypt.getRandomKey()).split("-");
        removeAllViews();
        this.mNoFocus = true;
        this.mEditArray.clear();
        for (int i = 0; i < split.length; i++) {
            final View editText = new EditText(this.mContext);
            editText.setText(split[i]);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new LengthFilter(split[i].length())});
            editText.setGravity(17);
            editText.setInputType(2);
            editText.setBackgroundColor(0);
            editText.setSelectAllOnFocus(true);
            editText.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TenpaySegmentEditText.this.mOnClickListener != null) {
                        TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                    }
                    if (TenpaySegmentEditText.this.mNoFocus) {
                        TenpaySegmentEditText.this.setFocusable(true);
                        editText.requestFocus();
                        TenpaySegmentEditText.this.mNoFocus = false;
                    }
                }
            });
            setNoSystemInputOnEditText(editText);
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    LogUtil.d(TenpaySegmentEditText.TAG, "edit onFocusChange hasFocus=" + z);
                    if (z) {
                        if (TenpaySegmentEditText.this.mOnClickListener != null) {
                            TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                        }
                        if (TenpaySegmentEditText.this.mKeyboard != null) {
                            LogUtil.d(TenpaySegmentEditText.TAG, "keyboard is not null");
                            TenpaySegmentEditText.this.mKeyboard.setXMode(0);
                            TenpaySegmentEditText.this.mKeyboard.setInputEditText(editText);
                        }
                    }
                }
            });
            addView(editText, new LayoutParams(-2, -1, (float) split[i].length()));
            this.mEditArray.add(editText);
        }
        setFocusable(false);
    }

    public final void setKeyboard(MyKeyboardWindow myKeyboardWindow) {
        this.mKeyboard = myKeyboardWindow;
    }

    public final void setFocusable(boolean z) {
        LogUtil.d(TAG, "setFocusable " + z);
        for (int i = 0; i < this.mEditArray.size(); i++) {
            EditText editText = (EditText) this.mEditArray.get(i);
            editText.setFocusable(z);
            editText.setFocusableInTouchMode(z);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackgroundLine(canvas);
    }

    private void drawBackgroundLine(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = (float) (height - 4);
        canvas.drawRect(0.0f, f, (float) width, (float) height, this.mPaintBg);
        float f2 = f - 9.0f;
        int size = this.mEditArray.size();
        canvas.drawRect(0.0f, f2, 4.0f, f, this.mPaintBg);
        int i = 0;
        float f3 = 0.0f;
        while (i < size) {
            int i2;
            if (i == size - 1) {
                i2 = -4;
            } else {
                i2 = -2;
            }
            float width2 = f3 + ((float) (((EditText) this.mEditArray.get(i)).getWidth() + i2));
            canvas.drawRect(width2, f2, width2 + 4.0f, f, this.mPaintBg);
            i++;
            f3 = width2 - ((float) i2);
        }
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.mEditArray.size(); i++) {
            stringBuffer.append(((EditText) this.mEditArray.get(i)).getText().toString());
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.length() == 0) {
            return null;
        }
        stringBuffer2.trim().replaceAll(" ", "");
        return stringBuffer2;
    }

    public final String getEncryptDataWithHash(boolean z) {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
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
        Encrypt encrypt = new Encrypt();
        return encrypt.desedeEncode(inputText, encrypt.getRandomKey());
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
            } catch (Exception e) {
            }
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public final void ClearInput() {
    }

    public final int getInputLength() {
        String inputText = getInputText();
        if (inputText == null) {
            return 0;
        }
        return inputText.length();
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.valueOf(false)});
        } catch (NoSuchMethodException e) {
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
            } catch (Exception e2) {
                editText.setInputType(0);
            }
        } catch (Exception e3) {
        }
    }
}
