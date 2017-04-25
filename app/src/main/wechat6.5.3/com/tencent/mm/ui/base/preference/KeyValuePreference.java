package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    private TextView hWl;
    public String nEc;
    private Drawable ocO;
    public boolean ocP;
    private boolean ocQ;
    private boolean ocR;
    public boolean ocS;
    private int ocT;
    public int ocU;
    public int ocV;
    private ImageView ocW;
    public Drawable ocX;
    public List<View> ocY;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ocO = null;
        this.ocP = true;
        this.ocQ = false;
        this.nEc = null;
        this.ocR = false;
        this.ocS = false;
        this.ocT = 17;
        this.ocU = 17;
        this.ocV = 0;
        this.ocW = null;
        this.ocX = null;
        this.ocY = new LinkedList();
        setLayoutResource(2130903996);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904018, viewGroup2);
        return onCreateView;
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.hWl = (TextView) view.findViewById(16908304);
        this.hWl.setSingleLine(this.ocP);
        if (this.ocQ) {
            setWidgetLayoutResource(2130904064);
        }
        if (this.ocS) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131755326);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout = (LinearLayout) view.findViewById(2131758261);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.getChildAt(0).setLayoutParams(layoutParams);
            this.hWl.setGravity(this.ocU);
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (!be.kS(this.nEc)) {
            textView.setText(this.nEc);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = a.N(this.mContext, 2131493077);
            textView.setLayoutParams(layoutParams2);
        }
        if (this.ocO != null) {
            ((ImageView) view.findViewById(2131758260)).setImageDrawable(this.ocO);
        }
        this.ocW = (ImageView) view.findViewById(2131756901);
        if (this.ocX != null) {
            this.ocW.setVisibility(this.ocV);
            this.ocW.setImageDrawable(this.ocX);
        } else {
            this.ocW.setVisibility(8);
        }
        if (this.ocR) {
            linearLayout = (LinearLayout) view.findViewById(2131755326);
            if (linearLayout != null) {
                linearLayout.setGravity(this.ocT);
            }
        }
        if (this.ocY.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(2131758261);
            linearLayout.removeAllViews();
            for (View view2 : this.ocY) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
    }

    public final void jz(boolean z) {
        this.ocQ = z;
        if (this.ocQ) {
            setWidgetLayoutResource(2130904064);
        }
    }

    public final void bDd() {
        this.ocR = true;
        this.ocT = 49;
    }
}
