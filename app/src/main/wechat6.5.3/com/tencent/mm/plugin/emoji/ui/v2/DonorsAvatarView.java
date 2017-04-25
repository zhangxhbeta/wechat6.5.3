package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ae.n;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int fnl;
    private int fnm;
    private int fnn;
    private int fno;
    private LayoutParams fnp;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
        this.fnl = a.dv(getContext());
        this.fnm = a.N(getContext(), 2131493425);
        this.fnn = a.N(getContext(), 2131492962);
        this.fno = a.N(getContext(), 2131493168);
        this.fnp = new LayoutParams(this.fnm, this.fnm);
        this.fnp.leftMargin = this.fnn;
        this.fnp.rightMargin = this.fnn;
        this.mMaxCount = (this.fnl - (this.fno * 2)) / (this.fnm + (this.fnn * 2));
        v.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[]{Integer.valueOf(this.mMaxCount)});
    }

    public final void b(String str, LinkedList<oi> linkedList) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                oi oiVar = (oi) linkedList.get(i);
                if (oiVar != null) {
                    View imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.fnp);
                    if (be.kS(oiVar.mqz)) {
                        try {
                            imageView.setImageBitmap(b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null), 0, 0));
                        } catch (Throwable e) {
                            v.a("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        n.GL().a(oiVar.mqz, imageView, g.g(str, oiVar.mqz, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
    }
}
