package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    public ImageView dQZ;
    private int height;
    private View lLh;
    private TextView lPA;
    public String lPB;
    public boolean lPC;
    private boolean lPD;
    public OnClickListener lwQ;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        this.lPC = false;
        this.lPD = false;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        if (this.lPD) {
            View.inflate(this.mContext, 2130904096, viewGroup2);
        } else {
            View.inflate(this.mContext, 2130904015, viewGroup2);
        }
        this.dQZ = (ImageView) onCreateView.findViewById(2131758252);
        this.lPA = (TextView) onCreateView.findViewById(2131758253);
        this.lLh = onCreateView.findViewById(2131755307);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.dQZ == null) {
            this.dQZ = (ImageView) view.findViewById(2131758252);
        }
        if (this.lPA == null) {
            this.lPA = (TextView) view.findViewById(2131758253);
        }
        if (this.lLh == null) {
            this.lLh = view.findViewById(2131755307);
        }
        if (this.lwQ != null) {
            this.lLh.setOnClickListener(this.lwQ);
        }
        if (this.lPB != null) {
            b.m(this.dQZ, this.lPB);
            this.lPB = null;
        }
        if (this.lPC) {
            this.lPA.setVisibility(8);
            this.lLh.setVisibility(0);
        } else {
            this.lLh.setVisibility(8);
            this.lPA.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2131758240);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
    }
}
