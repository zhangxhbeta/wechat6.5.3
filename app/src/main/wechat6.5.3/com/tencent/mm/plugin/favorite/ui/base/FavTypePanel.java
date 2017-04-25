package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class FavTypePanel extends LinearLayout {
    private LinearLayout fQp = this;
    public a fQq;
    private OnClickListener fQr = new OnClickListener(this) {
        final /* synthetic */ FavTypePanel fQs;

        {
            this.fQs = r1;
        }

        public final void onClick(View view) {
            ImageButton imageButton = (ImageButton) view.findViewById(2131756994);
            int intValue = ((Integer) view.getTag(2131755033)).intValue();
            int intValue2 = ((Integer) view.getTag(2131755048)).intValue();
            if (intValue2 == 0) {
                imageButton.setImageResource(FavTypePanel.kL(intValue));
                view.setTag(2131755048, Integer.valueOf(1));
            } else {
                imageButton.setImageResource(FavTypePanel.kM(intValue));
                view.setTag(2131755048, Integer.valueOf(0));
            }
            if (this.fQs.fQq != null) {
                boolean z;
                a a = this.fQs.fQq;
                if (1 == intValue2) {
                    z = true;
                } else {
                    z = false;
                }
                a.A(intValue, z);
            }
        }
    };

    public interface a {
        void A(int i, boolean z);
    }

    public FavTypePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(this.fQp, 2131165546, 2131232738, 5);
        a(this.fQp, 2131165544, 2131232735, 2);
        a(this.fQp, 2131165550, 2131232740, 3);
        a(this.fQp, 2131165542, 2131232737, 7);
        a(this.fQp, 2131165548, 2131232739, 4);
    }

    private static int kL(int i) {
        switch (i) {
            case 2:
                return 2131165544;
            case 3:
                return 2131165550;
            case 4:
                return 2131165548;
            case 5:
                return 2131165546;
            case 7:
                return 2131165542;
            default:
                return 0;
        }
    }

    private static int kM(int i) {
        switch (i) {
            case 2:
                return 2131165545;
            case 3:
                return 2131165551;
            case 4:
                return 2131165549;
            case 5:
                return 2131165547;
            case 7:
                return 2131165543;
            default:
                return 0;
        }
    }

    private void a(LinearLayout linearLayout, int i, int i2, int i3) {
        View inflate = View.inflate(getContext(), 2130903621, null);
        inflate.setTag(2131755033, Integer.valueOf(i3));
        inflate.setTag(2131755048, Integer.valueOf(1));
        inflate.setOnClickListener(this.fQr);
        ((ImageButton) inflate.findViewById(2131756994)).setImageResource(i);
        ((TextView) inflate.findViewById(2131756995)).setText(i2);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(inflate, layoutParams);
    }

    public final void aw(List<Integer> list) {
        for (int i = 0; i < this.fQp.getChildCount(); i++) {
            View childAt = this.fQp.getChildAt(i);
            Integer num = (Integer) childAt.getTag(2131755033);
            if (list == null || !list.contains(num)) {
                ((ImageButton) childAt.findViewById(2131756994)).setImageResource(kL(num.intValue()));
                childAt.setTag(2131755048, Integer.valueOf(1));
            } else {
                ((ImageButton) childAt.findViewById(2131756994)).setImageResource(kM(num.intValue()));
                childAt.setTag(2131755048, Integer.valueOf(0));
            }
        }
    }
}
