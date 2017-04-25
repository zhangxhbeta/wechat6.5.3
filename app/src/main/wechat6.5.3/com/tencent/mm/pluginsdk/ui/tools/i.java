package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class i {
    public static InputFilter[] lTR = new InputFilter[]{new LengthFilter(50)};

    public static class a implements TextWatcher {
        public b lTS = null;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.lTS != null) {
                this.lTS.aKK();
            }
        }
    }
}
