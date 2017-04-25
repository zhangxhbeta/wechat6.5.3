package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean nXI;
    private boolean nXJ;
    private boolean nXK;
    private a nXL;
    a nXM;

    public interface a {
        void a(MMRadioImageButton mMRadioImageButton);

        void b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nXJ = true;
    }

    public void toggle() {
        if (!this.nXJ) {
            if (this.nXL != null) {
                this.nXL.b(this);
            }
            if (this.nXM != null) {
                this.nXM.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.nXK);
        }
    }

    public boolean performClick() {
        toggle();
        return false;
    }

    public boolean isChecked() {
        return this.nXK;
    }

    public void setChecked(boolean z) {
        if (this.nXK != z) {
            this.nXK = z;
            setSelected(this.nXK);
            refreshDrawableState();
            if (!this.nXI) {
                this.nXI = true;
                if (this.nXL != null) {
                    this.nXL.a(this);
                }
                if (this.nXM != null) {
                    this.nXM.a(this);
                }
                this.nXI = false;
            }
        }
    }
}
