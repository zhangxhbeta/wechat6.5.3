package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j extends Preference {
    List<HelpCenter> hMG = new LinkedList();
    String hPU;
    OnClickListener hPV = null;
    OnClickListener mOnClickListener = null;
    private View mView = null;

    public j(Context context) {
        super(context);
        setLayoutResource(2130903943);
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
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758098);
        linearLayout.removeAllViews();
        if (this.hMG != null) {
            int size;
            int i;
            View view2;
            if (be.kS(this.hPU) || this.hPV == null) {
                size = this.hMG.size() - 1;
            } else {
                size = this.hMG.size();
            }
            if (size == 0) {
                i = -1;
            } else {
                i = size;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.hMG.size(); i3++) {
                HelpCenter helpCenter = (HelpCenter) this.hMG.get(i3);
                View textView = new TextView(this.mContext);
                textView.setTextColor(this.mContext.getResources().getColor(2131689547));
                textView.setTextSize(0, (float) a.N(this.mContext, 2131493169));
                textView.setIncludeFontPadding(false);
                textView.setText(helpCenter.name);
                textView.setTag(helpCenter);
                textView.setGravity(17);
                textView.setOnClickListener(this.mOnClickListener);
                if (i2 == i) {
                    textView.setTextColor(this.mContext.getResources().getColor(2131689767));
                }
                linearLayout.addView(textView, new LayoutParams(0, -2, 1.0f));
                if (i2 < i) {
                    view2 = new View(this.mContext);
                    view2.setBackgroundColor(this.mContext.getResources().getColor(2131690016));
                    linearLayout.addView(view2, new LayoutParams(a.N(this.mContext, 2131493029), -1));
                }
                i2++;
            }
            if (!be.kS(this.hPU) && this.hPV != null) {
                view2 = new TextView(this.mContext);
                view2.setTextColor(this.mContext.getResources().getColor(2131689547));
                view2.setTextSize(0, (float) a.N(this.mContext, 2131493169));
                view2.setIncludeFontPadding(false);
                view2.setText(this.hPU);
                view2.setGravity(17);
                view2.setOnClickListener(this.hPV);
                if (i2 == i) {
                    view2.setTextColor(this.mContext.getResources().getColor(2131689767));
                }
                linearLayout.addView(view2, new LayoutParams(0, -2, 1.0f));
            }
        }
    }
}
