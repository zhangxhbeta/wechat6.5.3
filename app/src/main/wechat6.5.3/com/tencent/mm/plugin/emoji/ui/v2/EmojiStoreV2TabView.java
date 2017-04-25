package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int fql;
    private int fqm = 0;
    private Bitmap fqn;
    private LinearLayout fqo;
    private ImageView fqp;
    private MMTabView fqq;
    private MMTabView fqr;
    a fqs;
    protected OnClickListener fqt = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2TabView fqu;

        {
            this.fqu = r1;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.fqu.fqs != null) {
                this.fqu.fqs.kh(intValue);
            }
        }
    };
    private Matrix mMatrix = new Matrix();

    public interface a {
        void kh(int i);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fql = (i3 - i) / 2;
        int i5 = this.fql;
        if (this.fqn == null || this.fqn.getWidth() != i5) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.fqn == null ? -1 : this.fqn.getWidth());
            objArr[1] = Integer.valueOf(i5);
            v.w(str, str2, objArr);
            this.fqn = Bitmap.createBitmap(i5, com.tencent.mm.bd.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.fqn).drawColor(getResources().getColor(2131690123));
            f(this.fqm, 0.0f);
            this.fqp.setImageBitmap(this.fqn);
        }
        kg(this.fqm);
    }

    private void init() {
        this.fqo = new LinearLayout(getContext());
        this.fqo.setBackgroundResource(2131690127);
        this.fqo.setId(2131755029);
        this.fqo.setOrientation(0);
        addView(this.fqo, new LayoutParams(-1, -2));
        this.fqp = new ImageView(getContext());
        this.fqp.setImageMatrix(this.mMatrix);
        this.fqp.setScaleType(ScaleType.MATRIX);
        this.fqp.setId(2131755030);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2131755029);
        addView(this.fqp, layoutParams);
        this.fqq = kf(0);
        this.fqq.setText(2131232385);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams.weight = 1.0f;
        this.fqo.addView(this.fqq, layoutParams);
        this.fqr = kf(1);
        this.fqr.setText(2131232389);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams.weight = 1.0f;
        this.fqo.addView(this.fqr, layoutParams);
    }

    private MMTabView kf(int i) {
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.fqt);
        return mMTabView;
    }

    public final void f(int i, float f) {
        this.mMatrix.setTranslate(((float) this.fql) * (((float) i) + f), 0.0f);
        this.fqp.setImageMatrix(this.mMatrix);
    }

    public final void kg(int i) {
        this.fqm = i;
        this.fqq.setTextColor(this.fqm == 0 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
        this.fqr.setTextColor(this.fqm == 1 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
    }

    public final void cH(boolean z) {
        if (this.fqr != null) {
            this.fqr.iZ(z);
        }
    }
}
