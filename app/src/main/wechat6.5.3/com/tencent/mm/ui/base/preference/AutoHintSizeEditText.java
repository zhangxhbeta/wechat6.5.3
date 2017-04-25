package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class AutoHintSizeEditText extends EditText {
    private float obY;
    private Paint obZ;
    private String oca = "";
    private int ocb = Integer.MIN_VALUE;
    private float occ;

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.obY = getTextSize();
        this.occ = this.obY;
        this.obZ = new Paint(getPaint());
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AutoHintSizeEditText ocd;

            {
                this.ocd = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.ocd.a(editable, this.ocd.getHint(), (this.ocd.getWidth() - this.ocd.getPaddingLeft()) - this.ocd.getPaddingRight());
            }
        });
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        if (editable == null || be.kS(editable.toString())) {
            if (charSequence != null && !be.kS(charSequence.toString())) {
                String charSequence2 = charSequence.toString();
                if (!this.oca.equals(charSequence2) || this.ocb != i) {
                    this.oca = charSequence2;
                    this.ocb = i;
                    if (getPaint().measureText(charSequence2) > ((float) i)) {
                        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493204);
                        int fromDPToPix = a.fromDPToPix(getContext(), 1);
                        for (int i2 = ((int) this.obY) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                            this.obZ.setTextSize((float) i2);
                            if (this.obZ.measureText(charSequence2) < ((float) i)) {
                                v.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[]{Integer.valueOf(i2)});
                                this.occ = (float) i2;
                                setTextSize(0, (float) i2);
                                return;
                            }
                        }
                    }
                } else if (getTextSize() != this.occ) {
                    v.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[]{Float.valueOf(this.occ)});
                    setTextSize(0, this.occ);
                }
            } else if (getTextSize() != this.obY) {
                v.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[]{Float.valueOf(this.obY)});
                setTextSize(0, this.obY);
            }
        } else if (getTextSize() != this.obY) {
            v.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[]{Float.valueOf(this.obY)});
            setTextSize(0, this.obY);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        v.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
    }
}
