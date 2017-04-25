package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.be;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int fgB;
    private int fgC;
    private ViewGroup fgE;
    private String fgv;
    private int fgw;
    private int fgx;
    private int height;
    private int oct;
    private ImageView ocu;
    private TextView ocv;
    private String ocw;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = "";
        this.fgw = -1;
        this.fgx = 8;
        this.oct = 8;
        this.fgB = 0;
        this.fgC = 8;
        this.ocu = null;
        this.fgE = null;
        this.height = -1;
        this.ocw = "";
        this.context = context;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904043, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(2131493198));
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131756901);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.OL != 0) {
                imageView.setImageResource(this.OL);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
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
        this.ocu = (ImageView) view.findViewById(2131758254);
        this.ocu.setVisibility(this.oct);
        this.fgE = (ViewGroup) view.findViewById(2131758256);
        this.fgE.setVisibility(this.fgB);
        this.ocv = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(2131758279);
        if (be.kS(this.ocw)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.ocw);
    }
}
