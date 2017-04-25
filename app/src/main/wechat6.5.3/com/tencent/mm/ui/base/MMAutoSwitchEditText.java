package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMAutoSwitchEditText extends EditText {
    a nUt = new a(this);

    public static class a implements TextWatcher, OnKeyListener {
        private String dVK;
        private EditText kL;
        int mIndex = 0;
        c nUu;
        b nUv;
        d nUw;
        int nUx = 4;

        public a(EditText editText) {
            this.kL = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            int i = 0;
            this.dVK = editable.toString();
            Object obj = SQLiteDatabase.KeyEmpty;
            if (this.nUw != null) {
                this.nUw.bBQ();
            }
            int i2 = 0;
            while (i < this.dVK.length()) {
                i2++;
                if (i2 > this.nUx) {
                    break;
                }
                obj = obj + this.dVK.charAt(i);
                i++;
            }
            if (i2 > this.nUx) {
                this.kL.setText(obj);
                this.kL.setSelection(obj.length());
            }
            if (i2 >= this.nUx && this.nUu != null) {
                this.nUu.ws(this.mIndex);
            }
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && this.kL.getText().toString().trim().length() == 0 && this.nUv != null) {
                this.nUv.wr(this.mIndex);
            }
            return false;
        }
    }

    public interface b {
        void wr(int i);
    }

    public interface c {
        void ws(int i);
    }

    public interface d {
        void bBQ();
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(this.nUt);
        setOnKeyListener(this.nUt);
    }
}
