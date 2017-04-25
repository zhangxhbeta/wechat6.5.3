package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int fgA;
    private int fgB;
    private int fgC;
    private ImageView fgD;
    private ViewGroup fgE;
    private View fgF;
    LayoutParams fgG;
    private String fgv;
    private int fgw;
    public int fgx;
    private Bitmap fgy;
    private int fgz;
    private int height;
    public int ocF;
    public TextView ocG;
    private int ocH;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = "";
        this.fgw = -1;
        this.fgx = 8;
        this.fgy = null;
        this.fgz = -1;
        this.fgA = 8;
        this.fgB = 0;
        this.fgC = 8;
        this.ocF = 8;
        this.fgD = null;
        this.fgE = null;
        this.fgF = null;
        this.ocG = null;
        this.ocH = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(2130903996);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904017, viewGroup2);
        return onCreateView;
    }

    public final void Oz(String str) {
        this.fgv = str;
        this.fgw = 2130838762;
    }

    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (this.ocG != null && getSummary() != null && getSummary().length() > 0) {
            this.ocG.setText(getSummary());
        }
    }

    public final void setSummary(int i) {
        super.setSummary(i);
        if (this.ocG != null && getSummary() != null && getSummary().length() > 0) {
            this.ocG.setText(getSummary());
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131756901);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.jP != null) {
                imageView.setImageDrawable(this.jP);
                imageView.setVisibility(0);
            } else if (this.OL != 0) {
                imageView.setImageResource(this.OL);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758240);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(2131758235);
        if (textView != null) {
            textView.setVisibility(this.fgx);
            textView.setText(this.fgv);
            if (this.fgw != -1) {
                textView.setBackgroundDrawable(a.a(this.context, this.fgw));
            }
        }
        if (this.fgD == null) {
            this.fgD = (ImageView) view.findViewById(2131758257);
        }
        if (this.fgE == null) {
            this.fgE = (ViewGroup) view.findViewById(2131758256);
        }
        if (this.fgF == null) {
            this.fgF = view.findViewById(2131758258);
        }
        this.fgF.setVisibility(this.fgC);
        if (this.fgy != null) {
            this.fgD.setImageBitmap(this.fgy);
        } else if (this.fgz != -1) {
            this.fgD.setImageResource(this.fgz);
        }
        this.fgD.setVisibility(this.fgA);
        this.fgE.setVisibility(this.fgB);
        if (this.fgG != null) {
            this.fgD.setLayoutParams(this.fgG);
        }
        this.ocG = (TextView) view.findViewById(2131758259);
        if (!(this.ocG == null || getSummary() == null || getSummary().length() <= 0)) {
            this.ocG.setText(getSummary());
            this.ocG.setVisibility(this.ocF);
        }
        if (this.ocG != null && this.ocH != -1) {
            this.ocG.setCompoundDrawablesWithIntrinsicBounds(this.ocH, 0, 0, 0);
            this.ocG.setCompoundDrawablePadding(b.a(this.mContext, 2.0f));
            this.ocG.setVisibility(this.ocF);
        }
    }
}
