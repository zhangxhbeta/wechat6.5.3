package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private OnClickListener fEl;
    private String gjc;
    private boolean gjg;
    private int hPC = Integer.MAX_VALUE;
    private int hPD = -1;
    private int hPE = -1;
    private View mView = null;

    public f(Context context) {
        super(context);
        setLayoutResource(2130903934);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131758064);
        ((TextView) view.findViewById(2131758063)).setText(getTitle());
        if (this.hPC != Integer.MAX_VALUE) {
            textView.setTextColor(this.hPC);
        }
        if (!this.gjg) {
            textView.setOnClickListener(null);
            textView.setText(e.a(this.mContext, this.gjc, textView.getTextSize()));
        } else if (this.hPD < 0 || this.hPE <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(2131689859));
            textView.setOnClickListener(this.fEl);
            textView.setText(e.a(this.mContext, this.gjc, textView.getTextSize()));
        } else {
            a aVar = new a(this.mContext);
            CharSequence spannableString = new SpannableString(this.gjc);
            aVar.hPW = new a.a(this) {
                final /* synthetic */ f hPF;

                {
                    this.hPF = r1;
                }

                public final void onClick(View view) {
                    if (this.hPF.fEl != null) {
                        this.hPF.fEl.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.hPD, this.hPE, 33);
            textView.setText(spannableString);
        }
    }

    public final void xF(String str) {
        try {
            this.hPC = Color.parseColor(str);
        } catch (Exception e) {
            this.hPC = Integer.MAX_VALUE;
        }
    }

    public final void setContent(String str) {
        this.gjc = str;
        this.gjg = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.gjc = str;
        this.gjg = true;
        this.hPD = i;
        this.hPE = i2;
        this.fEl = onClickListener;
    }
}
