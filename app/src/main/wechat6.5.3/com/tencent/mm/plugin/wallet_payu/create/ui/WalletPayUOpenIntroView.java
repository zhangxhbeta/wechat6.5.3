package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    ArrayList<View> acG;
    MMAutoHeightViewPager kYV;
    MMPageControlView kYW;
    a kYX;
    d[] kYY;
    Context mContext;

    private class a extends t {
        final /* synthetic */ WalletPayUOpenIntroView kYZ;

        private a(WalletPayUOpenIntroView walletPayUOpenIntroView) {
            this.kYZ = walletPayUOpenIntroView;
        }

        public final int getCount() {
            return this.kYZ.kYY == null ? 0 : this.kYZ.kYY.length;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = (View) this.kYZ.acG.get(i);
            viewGroup.addView(view);
            d dVar = this.kYZ.kYY[i];
            TextView textView = (TextView) view.findViewById(2131757643);
            TextView textView2 = (TextView) view.findViewById(2131758542);
            ((ImageView) view.findViewById(2131755922)).setImageResource(dVar.kYT);
            textView.setText(dVar.titleRes);
            textView2.setText(dVar.kYU);
            return view;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) this.kYZ.acG.get(i));
        }
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130904157, this, true);
        this.kYV = (MMAutoHeightViewPager) inflate.findViewById(2131758015);
        this.kYW = (MMPageControlView) inflate.findViewById(2131758541);
        this.kYW.nWL = 2130904144;
        this.kYW.setVisibility(0);
        this.kYV.yk = new e(this) {
            final /* synthetic */ WalletPayUOpenIntroView kYZ;

            {
                this.kYZ = r1;
            }

            public final void a(int i, float f, int i2) {
            }

            public final void W(int i) {
                if (this.kYZ.kYV.getParent() != null) {
                    this.kYZ.kYV.getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.kYZ.kYW.qw(i);
            }

            public final void X(int i) {
            }
        };
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }
}
