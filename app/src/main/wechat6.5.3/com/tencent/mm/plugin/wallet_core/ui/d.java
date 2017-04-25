package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    public View eYV;
    private OnClickListener fEl;
    public String gjc;
    public boolean gjg;
    private int hPC = Integer.MAX_VALUE;
    private int hPD = -1;
    private int hPE = -1;
    private View mView = null;

    public d(Context context) {
        super(context, null);
        setLayoutResource(2130903842);
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
        TextView textView = (TextView) view.findViewById(2131757653);
        ((TextView) view.findViewById(2131757652)).setText(getTitle());
        this.eYV = view;
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
            g gVar = new g(this.mContext);
            CharSequence spannableString = new SpannableString(this.gjc);
            gVar.kTx = new a(this) {
                final /* synthetic */ d kRQ;

                {
                    this.kRQ = r1;
                }

                public final void onClick(View view) {
                    if (this.kRQ.fEl != null) {
                        this.kRQ.fEl.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(gVar, this.hPD, this.hPE, 33);
            textView.setText(spannableString);
        }
    }
}
