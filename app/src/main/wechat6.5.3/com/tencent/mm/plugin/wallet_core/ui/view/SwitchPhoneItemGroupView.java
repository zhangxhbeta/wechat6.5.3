package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> kWD = new ArrayList();
    public a kWE;
    private OnClickListener kWF = new OnClickListener(this) {
        final /* synthetic */ SwitchPhoneItemGroupView kWG;

        {
            this.kWG = r1;
        }

        public final void onClick(View view) {
            for (SwitchPhoneItemView switchPhoneItemView : this.kWG.kWD) {
                switchPhoneItemView.kWJ.setImageResource(2131165881);
            }
            ((SwitchPhoneItemView) view).kWJ.setImageResource(2131165878);
            if (this.kWG.kWE != null) {
                this.kWG.kWE.cn(view);
            }
        }
    };

    public interface a {
        void cn(View view);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        addView(switchPhoneItemView, i);
        this.kWD.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.kWF);
    }
}
