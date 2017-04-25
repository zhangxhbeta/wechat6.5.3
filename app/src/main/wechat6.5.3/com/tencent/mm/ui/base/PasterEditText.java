package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText extends EditText {
    private Context context;
    private ClipboardManager jOm = null;
    public int jOn = 0;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.jOm = (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        if (!(this.jOm == null || this.jOm.getText() == null || !(this.jOm.getText() instanceof String) || this.jOm.getText() == null || this.jOm.getText().length() <= 0)) {
            this.jOn += this.jOm.getText().length();
        }
        return super.onTextContextMenuItem(i);
    }
}
