package com.tencent.mm.ui.base;

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
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMClearEditText extends EditText {
    public String dXe = SQLiteDatabase.KeyEmpty;
    private OnFocusChangeListener ioD = null;
    public boolean lGT = false;
    final Drawable lGU = getResources().getDrawable(2130838465);
    int lGY = 0;
    private boolean nUG = false;

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bqy();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bqy();
    }

    private void bqy() {
        this.lGU.setBounds(0, 0, this.lGU.getIntrinsicWidth(), this.lGU.getIntrinsicHeight());
        v.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.lGU.getIntrinsicWidth()), Integer.valueOf(this.lGU.getIntrinsicHeight()));
        boC();
        setHeight(this.lGU.getIntrinsicHeight() + (getResources().getDimensionPixelSize(2131493170) * 5));
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMClearEditText nUH;

            {
                this.nUH = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMClearEditText mMClearEditText = this.nUH;
                if (mMClearEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - this.nUH.lGU.getIntrinsicWidth()))) {
                    mMClearEditText.setText(SQLiteDatabase.KeyEmpty);
                    this.nUH.boE();
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMClearEditText nUH;

            {
                this.nUH = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.nUH.boC();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMClearEditText nUH;

            {
                this.nUH = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.nUH.ioD != null) {
                    this.nUH.ioD.onFocusChange(view, z);
                }
                this.nUH.boC();
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
        if (getText().toString().equals(SQLiteDatabase.KeyEmpty) || !isFocused()) {
            boE();
        } else if (!this.nUG) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.lGU, getCompoundDrawables()[3]);
        }
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
