package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable lGU = getResources().getDrawable(2130838465);
    public a nUo;

    private class a implements TextWatcher {
        final /* synthetic */ MMAutoCompleteTextView nUp;
        private String nUq;

        public a(MMAutoCompleteTextView mMAutoCompleteTextView, String str) {
            this.nUp = mMAutoCompleteTextView;
            this.nUq = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().endsWith(this.nUq)) {
                this.nUp.showDropDown();
            }
        }
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lGU.setBounds(0, 0, this.lGU.getIntrinsicWidth(), this.lGU.getIntrinsicHeight());
        boC();
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMAutoCompleteTextView nUp;

            {
                this.nUp = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMAutoCompleteTextView mMAutoCompleteTextView = this.nUp;
                if (mMAutoCompleteTextView.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - this.nUp.lGU.getIntrinsicWidth()))) {
                    mMAutoCompleteTextView.setText(SQLiteDatabase.KeyEmpty);
                    this.nUp.boE();
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMAutoCompleteTextView nUp;

            {
                this.nUp = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.nUp.boC();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMAutoCompleteTextView nUp;

            {
                this.nUp = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                this.nUp.boC();
            }
        });
    }

    private void boC() {
        if (getText().toString().equals(SQLiteDatabase.KeyEmpty) || !isFocused()) {
            boE();
        } else {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.lGU, getCompoundDrawables()[3]);
        }
    }

    private void boE() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
}
