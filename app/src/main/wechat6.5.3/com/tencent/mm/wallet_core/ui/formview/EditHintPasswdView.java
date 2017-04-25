package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.q;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private OnFocusChangeListener dxN;
    private int kAi;
    private TenpaySecureEditText pkc;
    private int pkd;
    private int pke;
    public int pkf;
    public a pkg;

    public interface a {
        void fc(boolean z);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet);
        this.pkc = null;
        this.pkd = 6;
        this.kAi = 1;
        this.pke = 2130838135;
        this.pkf = 1;
        this.pkg = null;
        this.dxN = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPz, i, 0);
        this.kAi = obtainStyledAttributes.getInteger(0, 1);
        this.pke = obtainStyledAttributes.getResourceId(1, 2130838135);
        this.pkf = obtainStyledAttributes.getInteger(2, 1);
        obtainStyledAttributes.recycle();
        this.pkc = (TenpaySecureEditText) q.em(context).inflate(2130903784, this, true).findViewById(2131755077);
        b.a(this.pkc, this.kAi);
        switch (this.kAi) {
            case 1:
                i2 = 6;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            default:
                v.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                i2 = 6;
                break;
        }
        this.pkd = i2;
        if (this.pkc != null) {
            this.pkc.setBackgroundResource(this.pke);
            this.pkc.setImeOptions(6);
            this.pkc.setInputType(128);
            this.pkc.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ EditHintPasswdView pkh;

                {
                    this.pkh = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.pkh.pkg != null) {
                        this.pkh.pkg.fc(this.pkh.Ou());
                    }
                }
            });
            this.pkc.setOnFocusChangeListener(this);
            super.setEnabled(true);
            super.setClickable(true);
            return;
        }
        v.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String bLI() {
        if (this.pkc != null) {
            return z.Kg(this.pkc.getText().toString());
        }
        v.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        return "";
    }

    private boolean Ou() {
        if (this.pkc == null || this.pkc.getInputLength() != this.pkd) {
            return false;
        }
        return true;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.dxN = onFocusChangeListener;
    }

    public final OnFocusChangeListener getOnFocusChangeListener() {
        return this.dxN;
    }

    public final String getText() {
        if (this.pkc != null) {
            return com.tencent.mm.wallet_core.ui.formview.c.a.a(this.pkf, this.pkc);
        }
        v.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        return "";
    }

    public final void aJx() {
        if (this.pkc != null) {
            this.pkc.ClearInput();
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(b.a(getContext(), 960.0f), i), getDefaultSize(b.a(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.pkd == 0 ? measuredWidth / 6 : measuredWidth / this.pkd;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        setMeasuredDimension(getDefaultSize(measuredWidth, makeMeasureSpec), getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.dxN != null) {
            this.dxN.onFocusChange(this, z);
        }
        if (this.pkg != null) {
            this.pkg.fc(Ou());
        }
    }
}
