package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private boolean gSi = false;
    private ClipboardManager jOm = null;
    int jOn = 0;
    private int jOo = 0;
    private int jOp = 0;
    private int jOq = 10;
    private float y;

    static /* synthetic */ int b(SnsEditText snsEditText, int i) {
        int i2 = snsEditText.jOn + i;
        snsEditText.jOn = i2;
        return i2;
    }

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.jOm = (ClipboardManager) this.context.getSystemService("clipboard");
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SnsEditText jOr;

            {
                this.jOr = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.jOr.jOp = charSequence.length();
                if (i2 <= 0) {
                    try {
                        if (this.jOr.jOp > this.jOr.jOo && i3 > 30) {
                            String substring = charSequence.toString().substring(i, i + i3);
                            if ((substring.indexOf("\n") >= 0 && i3 > 30) || i3 > 100) {
                                SnsEditText.b(this.jOr, substring.length());
                                v.d("MicroMsg.SnsEditText", "parsterLen: %d %d", new Object[]{Integer.valueOf(substring.length()), Integer.valueOf(this.jOr.jOn)});
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.SnsEditText", e, "", new Object[0]);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    this.jOr.jOo = charSequence.length();
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.jOq)) {
                this.gSi = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.gSi = false;
        } else if (this.gSi) {
            this.gSi = false;
            return true;
        }
        this.y = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
