package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;

final class b {
    int id;
    CharSequence text;

    public b(CharSequence charSequence, int i) {
        this.text = charSequence;
        this.id = i;
    }

    public final void a(RadioButton radioButton) {
        radioButton.setText(this.text);
        radioButton.setId(this.id);
    }
}
