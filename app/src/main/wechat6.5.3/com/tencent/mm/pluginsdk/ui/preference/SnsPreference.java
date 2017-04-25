package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ks;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private MMActivity aWn;
    private List<aib> gKQ;
    private int iJQ;
    private ak jdP;
    private ImageView lQA;
    private a lQB;
    private QDisFadeImageView lQv;
    private QDisFadeImageView lQw;
    private QDisFadeImageView lQx;
    private ImageView lQy;
    private ImageView lQz;
    private String mTitle;

    static class a extends ColorDrawable {
        public a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.aWn = (MMActivity) context;
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.lQv = null;
        this.lQw = null;
        this.lQx = null;
        this.lQy = null;
        this.lQz = null;
        this.lQA = null;
        this.iJQ = 255;
        this.gKQ = new LinkedList();
        this.lQB = new a();
        this.aWn = (MMActivity) context;
        this.mTitle = context.getString(2131232166);
        setLayoutResource(2130903996);
    }

    private void bqH() {
        ImageView imageView;
        int i = 0;
        if (this.lQv != null) {
            this.lQv.setImageResource(2131690127);
            this.lQv.setVisibility(4);
        }
        if (this.lQw != null) {
            this.lQw.setImageResource(2131690127);
            this.lQw.setVisibility(4);
        }
        if (this.lQx != null) {
            this.lQx.setImageResource(2131690127);
            this.lQx.setVisibility(4);
        }
        if (this.lQv != null && this.gKQ.size() > 0) {
            int i2;
            ImageView imageView2;
            this.lQv.setVisibility(0);
            if (f.sj()) {
                j.ak.lye.b((aib) this.gKQ.get(0), this.lQv, this.aWn.hashCode(), this.jdP);
                imageView = this.lQy;
                if (((aib) this.gKQ.get(0)).efm == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.lQv.setImageResource(2130838790);
                imageView2 = this.lQy;
            }
            imageView = imageView2;
            i2 = 8;
            imageView.setVisibility(i2);
        }
        if (this.lQw != null && this.gKQ.size() >= 2) {
            this.lQw.setVisibility(0);
            if (f.sj()) {
                j.ak.lye.b((aib) this.gKQ.get(1), this.lQw, this.aWn.hashCode(), this.jdP);
                this.lQz.setVisibility(((aib) this.gKQ.get(1)).efm == 6 ? 0 : 8);
            } else {
                this.lQw.setImageResource(2130838790);
            }
        }
        if (this.lQx != null && this.gKQ.size() >= 3) {
            this.lQx.setVisibility(0);
            if (f.sj()) {
                j.ak.lye.b((aib) this.gKQ.get(2), this.lQx, this.aWn.hashCode(), this.jdP);
                imageView = this.lQA;
                if (((aib) this.gKQ.get(2)).efm != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
                return;
            }
            this.lQx.setImageResource(2130838790);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904010, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lQv = (QDisFadeImageView) view.findViewById(2131758242);
        this.lQv.setAlpha(this.iJQ);
        this.lQv.setImageDrawable(this.lQB);
        this.lQw = (QDisFadeImageView) view.findViewById(2131758244);
        this.lQw.setAlpha(this.iJQ);
        this.lQw.setImageDrawable(this.lQB);
        this.lQx = (QDisFadeImageView) view.findViewById(2131758246);
        this.lQx.setAlpha(this.iJQ);
        this.lQx.setImageDrawable(this.lQB);
        TextView textView = (TextView) view.findViewById(2131758233);
        if (!be.kS(this.mTitle)) {
            textView.setText(this.mTitle);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mm.bd.a.N(this.mContext, 2131493077);
            textView.setLayoutParams(layoutParams);
        }
        this.lQy = (ImageView) view.findViewById(2131758243);
        this.lQz = (ImageView) view.findViewById(2131758245);
        this.lQA = (ImageView) view.findViewById(2131758247);
        this.lQy.setVisibility(8);
        this.lQz.setVisibility(8);
        this.lQA.setVisibility(8);
        bqH();
        if (view != null && this.gKQ != null) {
            view.setContentDescription(this.mContext.getString(2131234252, new Object[]{Integer.valueOf(this.gKQ.size())}));
        }
    }

    public final void HO(String str) {
        if (str != null) {
            this.gKQ.clear();
            com.tencent.mm.model.ak.yW();
            u LX = c.wH().LX(str);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                this.jdP = ak.nvt;
            } else if (str.equals(k.xF())) {
                this.jdP = ak.nvt;
            } else {
                this.jdP = ak.nvu;
            }
            ks ksVar = new ks();
            ksVar.blX.username = str;
            com.tencent.mm.sdk.c.a.nhr.z(ksVar);
            if (ksVar.blY.blZ != null) {
                this.gKQ.add(ksVar.blY.blZ);
            }
            if (ksVar.blY.bma != null) {
                this.gKQ.add(ksVar.blY.bma);
            }
            if (ksVar.blY.bmb != null) {
                this.gKQ.add(ksVar.blY.bmb);
            }
            bqH();
        }
    }
}
