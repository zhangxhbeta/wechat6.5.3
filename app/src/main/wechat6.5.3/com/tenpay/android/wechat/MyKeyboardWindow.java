package com.tenpay.android.wechat;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MyKeyboardWindow extends LinearLayout {
    public static final int X_MODE_CHARACTER = 1;
    public static final int X_MODE_DOT = 2;
    public static final int X_MODE_NONE = 0;
    private Context mContext;
    private EditText mInputEditText;
    private Button mKey0;
    private Button mKey1;
    private Button mKey2;
    private Button mKey3;
    private Button mKey4;
    private Button mKey5;
    private Button mKey6;
    private Button mKey7;
    private Button mKey8;
    private Button mKey9;
    private ImageButton mKeyD;
    private Button mKeyX;
    private int mXMode = 0;

    private class SecureAccessbilityDelegate extends AccessibilityDelegate {
        private SecureAccessbilityDelegate() {
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return true;
        }

        public void sendAccessibilityEvent(View view, int i) {
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    public MyKeyboardWindow(Context context) {
        super(context);
        init(context);
    }

    public MyKeyboardWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(context).inflate(this.mContext.getResources().getIdentifier("tenpay_number_keyboard", "layout", this.mContext.getPackageName()), this, true);
        this.mKey1 = (Button) inflate.findViewById(getId("tenpay_keyboard_1"));
        this.mKey2 = (Button) inflate.findViewById(getId("tenpay_keyboard_2"));
        this.mKey3 = (Button) inflate.findViewById(getId("tenpay_keyboard_3"));
        this.mKey4 = (Button) inflate.findViewById(getId("tenpay_keyboard_4"));
        this.mKey5 = (Button) inflate.findViewById(getId("tenpay_keyboard_5"));
        this.mKey6 = (Button) inflate.findViewById(getId("tenpay_keyboard_6"));
        this.mKey7 = (Button) inflate.findViewById(getId("tenpay_keyboard_7"));
        this.mKey8 = (Button) inflate.findViewById(getId("tenpay_keyboard_8"));
        this.mKey9 = (Button) inflate.findViewById(getId("tenpay_keyboard_9"));
        this.mKeyX = (Button) inflate.findViewById(getId("tenpay_keyboard_x"));
        this.mKey0 = (Button) inflate.findViewById(getId("tenpay_keyboard_0"));
        this.mKeyD = (ImageButton) inflate.findViewById(getId("tenpay_keyboard_d"));
        OnClickListener anonymousClass1 = new OnClickListener() {
            public void onClick(View view) {
                if (MyKeyboardWindow.this.mInputEditText != null) {
                    if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_x")) {
                        switch (MyKeyboardWindow.this.mXMode) {
                            case 0:
                                return;
                            case 1:
                                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                                return;
                            case 2:
                                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                                return;
                            default:
                                return;
                        }
                    }
                    int i;
                    if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_1")) {
                        i = 8;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_2")) {
                        i = 9;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_3")) {
                        i = 10;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_4")) {
                        i = 11;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_5")) {
                        i = 12;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_6")) {
                        i = 13;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_7")) {
                        i = 14;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_8")) {
                        i = 15;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_9")) {
                        i = 16;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_0")) {
                        i = 7;
                    } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_d")) {
                        i = 67;
                    } else {
                        i = 0;
                    }
                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
                }
            }
        };
        this.mKey1.setOnClickListener(anonymousClass1);
        this.mKey2.setOnClickListener(anonymousClass1);
        this.mKey3.setOnClickListener(anonymousClass1);
        this.mKey4.setOnClickListener(anonymousClass1);
        this.mKey5.setOnClickListener(anonymousClass1);
        this.mKey6.setOnClickListener(anonymousClass1);
        this.mKey7.setOnClickListener(anonymousClass1);
        this.mKey8.setOnClickListener(anonymousClass1);
        this.mKey9.setOnClickListener(anonymousClass1);
        this.mKeyX.setOnClickListener(anonymousClass1);
        this.mKey0.setOnClickListener(anonymousClass1);
        this.mKeyD.setOnClickListener(anonymousClass1);
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.mInputEditText = editText;
            int imeOptions = this.mInputEditText.getImeOptions();
            CharSequence imeActionLabel = this.mInputEditText.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.mKeyX.setText(imeActionLabel);
            }
            switch (imeOptions) {
                case 1:
                    this.mXMode = 0;
                    if (TextUtils.isEmpty(imeActionLabel)) {
                        this.mKeyX.setText("");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setSecureAccessibility(AccessibilityDelegate accessibilityDelegate) {
        this.mKey0.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey1.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey2.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey3.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey4.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey5.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey6.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey7.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey8.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey9.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyX.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyD.setAccessibilityDelegate(accessibilityDelegate);
    }

    public void resetSecureAccessibility() {
        this.mKey0.setAccessibilityDelegate(null);
        this.mKey1.setAccessibilityDelegate(null);
        this.mKey2.setAccessibilityDelegate(null);
        this.mKey3.setAccessibilityDelegate(null);
        this.mKey4.setAccessibilityDelegate(null);
        this.mKey5.setAccessibilityDelegate(null);
        this.mKey6.setAccessibilityDelegate(null);
        this.mKey7.setAccessibilityDelegate(null);
        this.mKey8.setAccessibilityDelegate(null);
        this.mKey9.setAccessibilityDelegate(null);
        this.mKeyX.setAccessibilityDelegate(null);
        this.mKeyD.setAccessibilityDelegate(null);
    }

    public void setXMode(int i) {
        this.mXMode = i;
        switch (i) {
            case 0:
                this.mKeyX.setText("");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keyitem_bottom"));
                return;
            case 1:
                this.mKeyX.setText("X");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                return;
            case 2:
                this.mKeyX.setText(".");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                return;
            default:
                this.mXMode = 0;
                return;
        }
    }

    protected int getId(String str) {
        return this.mContext.getResources().getIdentifier(str, "id", this.mContext.getPackageName());
    }

    protected int getDrawableId(String str) {
        return this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
    }
}
