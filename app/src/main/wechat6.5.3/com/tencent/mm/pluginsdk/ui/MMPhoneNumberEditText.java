package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.bf.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMPhoneNumberEditText extends EditText {
    public String dXe = SQLiteDatabase.KeyEmpty;
    private OnFocusChangeListener ioD = null;
    public boolean lGT = false;
    public Drawable lGU;
    a lGV;
    public boolean lGW;
    private boolean lGX = false;
    int lGY = 0;

    public interface a {
        void boF();

        void f(MMPhoneNumberEditText mMPhoneNumberEditText);

        void g(MMPhoneNumberEditText mMPhoneNumberEditText);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.lGU = getResources().getDrawable(2130838465);
        this.lGU.setBounds(0, 0, this.lGU.getIntrinsicWidth(), this.lGU.getIntrinsicHeight());
        v.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.lGU.getIntrinsicWidth()), Integer.valueOf(this.lGU.getIntrinsicHeight()));
        boC();
        setHeight(this.lGU.getIntrinsicHeight() + (getResources().getDimensionPixelSize(2131493170) * 5));
        clearFocus();
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMPhoneNumberEditText lGZ;

            {
                this.lGZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMPhoneNumberEditText mMPhoneNumberEditText = this.lGZ;
                if (mMPhoneNumberEditText.getCompoundDrawables()[2] == null) {
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return true;
                }
                if (motionEvent.getX() <= ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - this.lGZ.lGU.getIntrinsicWidth()))) {
                    mMPhoneNumberEditText.requestFocus();
                    mMPhoneNumberEditText.performClick();
                    return true;
                } else if (mMPhoneNumberEditText.isFocused()) {
                    mMPhoneNumberEditText.setText(SQLiteDatabase.KeyEmpty);
                    mMPhoneNumberEditText.boE();
                    return true;
                } else if (this.lGZ.lGV == null) {
                    return true;
                } else {
                    this.lGZ.lGV.f(mMPhoneNumberEditText);
                    return true;
                }
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMPhoneNumberEditText lGZ;

            {
                this.lGZ = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.lGZ.boC();
                if (!charSequence.toString().equals(SQLiteDatabase.KeyEmpty) || this.lGZ.lGX) {
                    if (!charSequence.toString().equals(SQLiteDatabase.KeyEmpty) && this.lGZ.lGX && this.lGZ.lGV != null && this.lGZ.isFocused()) {
                        this.lGZ.lGV.boF();
                    }
                } else if (this.lGZ.lGV != null && this.lGZ.isFocused()) {
                    this.lGZ.lGV.g(this.lGZ);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (be.kS(charSequence.toString())) {
                    this.lGZ.lGX = true;
                } else {
                    this.lGZ.lGX = false;
                }
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMPhoneNumberEditText lGZ;

            {
                this.lGZ = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.lGZ.ioD != null) {
                    this.lGZ.ioD.onFocusChange(view, z);
                }
                this.lGZ.boC();
            }
        });
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.lGY = 0;
            String obj = getText().toString();
            try {
                Hp(obj);
            } catch (IndexOutOfBoundsException e) {
                v.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.lGY));
                if (this.lGY < 3) {
                    this.lGY++;
                    Hp(" " + obj);
                } else {
                    v.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void Hp(String str) {
        int selectionStart = getSelectionStart();
        setText(g.buU().c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.ioD = onFocusChangeListener;
    }

    private void boC() {
        if (getText().toString().equals(SQLiteDatabase.KeyEmpty)) {
            boE();
        } else {
            boD();
        }
    }

    final void boD() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.lGU, getCompoundDrawables()[3]);
    }

    private void boE() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            if (!this.lGT) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
