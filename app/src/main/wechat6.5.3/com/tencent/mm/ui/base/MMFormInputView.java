package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;

public class MMFormInputView extends LinearLayout {
    private TextView dtY;
    public EditText idd;
    private int layout;
    private Context mContext;
    private int nVa;
    private int nVb;
    private int[] nVc;
    public OnFocusChangeListener nVd;

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        if (mMFormInputView.nVc != null) {
            mMFormInputView.setPadding(mMFormInputView.nVc[0], mMFormInputView.nVc[1], mMFormInputView.nVc[2], mMFormInputView.nVc[3]);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.nVa = -1;
        this.nVb = -1;
        this.layout = -1;
        this.nVd = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPg, i, 0);
        this.nVb = obtainStyledAttributes.getResourceId(2, -1);
        this.nVa = obtainStyledAttributes.getResourceId(1, -1);
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.dtY = (TextView) findViewById(2131755226);
        this.idd = (EditText) findViewById(2131755280);
        if (this.dtY == null || this.idd == null) {
            v.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.dtY, this.idd);
        } else {
            if (this.nVa != -1) {
                this.dtY.setText(this.nVa);
            }
            if (this.nVb != -1) {
                this.idd.setHint(this.nVb);
            }
        }
        if (this.idd != null) {
            this.idd.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ MMFormInputView nVe;

                {
                    this.nVe = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (view == this.nVe.idd) {
                        this.nVe.nVc = new int[]{this.nVe.getPaddingLeft(), this.nVe.getPaddingTop(), this.nVe.getPaddingRight(), this.nVe.getPaddingBottom()};
                        if (z) {
                            this.nVe.setBackgroundResource(2130838423);
                        } else {
                            this.nVe.setBackgroundResource(2130838424);
                        }
                        MMFormInputView.c(this.nVe);
                    }
                    if (this.nVe.nVd != null) {
                        this.nVe.nVd.onFocusChange(view, z);
                    }
                }
            });
        }
    }

    public final void setInputType(int i) {
        if (this.idd != null) {
            this.idd.setInputType(i);
        } else {
            v.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == null || this.idd == null) {
            v.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.idd);
            return;
        }
        this.idd.addTextChangedListener(textWatcher);
    }

    public final Editable getText() {
        if (this.idd != null) {
            return this.idd.getText();
        }
        v.e("MicroMsg.MMFormInputView", "contentET is null!");
        return null;
    }
}
