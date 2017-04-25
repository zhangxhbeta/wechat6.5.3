package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class HelperHeaderPreference extends Preference {
    private a lPF = new a();

    public static class a {
        public String ble;
        public String caJ;
        public String lPG;
        public int status;
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        ImageView imageView = (ImageView) view.findViewById(2131755508);
        TextView textView = (TextView) view.findViewById(2131757174);
        TextView textView2 = (TextView) view.findViewById(2131756539);
        TextView textView3 = (TextView) view.findViewById(2131758560);
        if (imageView != null) {
            b.m(imageView, this.lPF.ble);
        }
        if (textView != null) {
            switch (this.lPF.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(r.eM(this.mContext));
                    textView.setText(2131235109);
                    textView.setCompoundDrawablesWithIntrinsicBounds(2130839255, 0, 0, 0);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(r.eL(this.mContext));
                    textView.setText(2131235101);
                    textView.setCompoundDrawablesWithIntrinsicBounds(2130839256, 0, 0, 0);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.lPF.caJ);
        }
        if (textView3 != null) {
            textView3.setText(this.lPF.lPG);
        }
        super.onBindView(view);
    }

    public final void U(String str, String str2, String str3) {
        this.lPF.ble = str;
        this.lPF.caJ = str2;
        this.lPF.lPG = str3;
        super.callChangeListener(null);
    }

    public final void updateStatus(int i) {
        this.lPF.status = i;
        super.callChangeListener(null);
    }
}
