package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.g;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View fhF = null;
    private TextView jip;
    private LinearLayout jiq;
    private LinearLayout jir;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        init();
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), 2130903908, this);
        this.fhF = inflate.findViewById(2131757965);
        this.jip = (TextView) inflate.findViewById(2131757966);
        this.jiq = (LinearLayout) inflate.findViewById(2131757968);
        b.a(getContext(), 2.0f);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(2130839218);
        linearLayout.setLayoutParams(layoutParams);
        this.jir = linearLayout;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.fhF != null) {
            this.fhF.setVisibility(i);
        }
    }

    public final void a(k kVar, com.tencent.mm.plugin.sns.ui.b.b bVar) {
        awa n = ah.n(kVar);
        awq com_tencent_mm_protocal_c_awq = n.mTz;
        if (com_tencent_mm_protocal_c_awq == null || com_tencent_mm_protocal_c_awq.mTZ.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        double b = ((double) x.b(kVar, n)) * 1.0d;
        this.jip.setText(getContext().getString(2131235475, new Object[]{Integer.valueOf(n.mTz.mTY), e.m(b / 100.0d)}));
        this.fhF.setTag(kVar);
        this.fhF.setOnClickListener(bVar.kbH);
        LinkedList linkedList = com_tencent_mm_protocal_c_awq.mTZ;
        boolean isEmpty = com_tencent_mm_protocal_c_awq.mTZ.isEmpty();
        int a = b.a(getContext(), 32.0f);
        int a2 = b.a(getContext(), 6.0f);
        int a3 = b.a(getContext(), 10.0f);
        int a4 = b.a(getContext(), 17.0f);
        if (this.jiq != null) {
            int i;
            LinearLayout linearLayout;
            v.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[]{Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(2131493168))});
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.jiq.getParent() != null) {
                    this.jiq.setVisibility(8);
                }
                this.jiq.removeAllViews();
                this.jiq.setVisibility(8);
                linearLayout = this.jiq;
                i = 8;
            } else {
                this.jiq.getParent();
                this.jiq.removeAllViews();
                this.jiq.setVisibility(0);
                this.jiq.setPadding(0, a2, 0, a2);
                View imageView = new ImageView(getContext());
                imageView.setImageResource(2131165586);
                imageView.setPadding(a3, a4, a3, 0);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.jiq.addView(imageView);
                a3 = a.fromDPToPix(getContext(), SnsCommentDetailUI.jMS);
                i = ((int) (f - ((float) a3))) / (a2 + a);
                if (((int) (f - ((float) a3))) % (a2 + a) > a) {
                    i++;
                }
                v.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[]{Integer.valueOf(i)});
                View gVar = new g(getContext());
                gVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                gVar.jEl = i;
                for (a3 = 0; a3 < linkedList.size(); a3++) {
                    avx com_tencent_mm_protocal_c_avx = (avx) linkedList.get(a3);
                    View touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(2130838279);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, a);
                    layoutParams2.setMargins(0, a2, a2, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(com_tencent_mm_protocal_c_avx.mdw);
                    com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_avx.mdw, true);
                    touchImageView.setOnClickListener(bVar.kbw);
                    gVar.addView(touchImageView);
                }
                this.jiq.addView(gVar);
                linearLayout = this.jir;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}
