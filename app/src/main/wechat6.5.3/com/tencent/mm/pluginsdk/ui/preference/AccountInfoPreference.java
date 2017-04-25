package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class AccountInfoPreference extends Preference {
    public p khm;
    public SpannableString lPf;
    public String lPg;
    private int lPh;
    private OnClickListener lPi;
    public String userName;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khm = null;
        this.lPi = null;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131755508);
        if (!(this.userName == null || imageView == null)) {
            b.m(imageView, this.userName);
        }
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) view.findViewById(2131758334);
        if (!(this.userName == null || noMeasuredTextView == null)) {
            noMeasuredTextView.oaP = true;
            noMeasuredTextView.G((float) a.N(this.mContext, 2131493169));
            noMeasuredTextView.setTextColor(a.M(this.mContext, 2131689909));
            noMeasuredTextView.setText(this.lPf == null ? this.userName : this.lPf);
        }
        TextView textView = (TextView) view.findViewById(2131758335);
        if (this.lPg != null && textView != null) {
            textView.setText(view.getResources().getString(2131230899, new Object[]{this.lPg}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(2131758258);
        if (textView != null) {
            if (this.lPh > 99) {
                textView.setText(this.mContext.getString(2131236490));
                textView.setBackgroundResource(s.eN(this.mContext));
                textView.setVisibility(0);
            } else if (this.lPh > 0) {
                textView.setText(this.lPh);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        ((ImageView) view.findViewById(2131758336)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AccountInfoPreference lPj;

            {
                this.lPj = r1;
            }

            public final void onClick(View view) {
                if (this.lPj.khm != null) {
                    g.iuh.h(11264, Integer.valueOf(1));
                    this.lPj.khm.show();
                }
            }
        });
    }
}
