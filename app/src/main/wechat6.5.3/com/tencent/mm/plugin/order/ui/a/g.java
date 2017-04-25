package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int hPG;
    private static float hPH = 16.0f;
    f ezq;
    String hPI;
    private String[] hPJ;
    private TruncateAt hPK;
    private boolean hPL = false;
    private View mView = null;

    static /* synthetic */ TextView a(g gVar, String str) {
        TextView textView = new TextView(gVar.mContext);
        textView.setText(str);
        textView.setTextSize(hPH);
        textView.setTextColor(hPG);
        if (gVar.hPL) {
            textView.setSingleLine(true);
            textView.setEllipsize(gVar.hPK);
        } else {
            textView.setSingleLine(false);
        }
        return textView;
    }

    public g(Context context) {
        super(context);
        setLayoutResource(2130903935);
        hPG = context.getResources().getColor(2131689866);
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
        final TextView textView = (TextView) view.findViewById(2131758067);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758066);
        ((TextView) view.findViewById(2131758065)).setText(getTitle());
        if (this.hPJ == null || this.hPJ.length <= 1) {
            textView.setTextColor(hPG);
        } else {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g hPO;

                public final void onClick(View view) {
                    textView.setVisibility(8);
                    for (String a : this.hPO.hPJ) {
                        linearLayout.addView(g.a(this.hPO, a), new LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (this.hPO.ezq != null) {
                        this.hPO.ezq.notifyDataSetChanged();
                    }
                }
            });
        }
        textView.setText(this.hPI);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.hPJ = strArr;
        this.hPK = truncateAt;
        this.hPL = true;
    }
}
