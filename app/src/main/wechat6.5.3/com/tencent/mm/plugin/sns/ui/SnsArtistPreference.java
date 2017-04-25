package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private MMActivity aWn;
    private String fgv;
    private int fgw;
    private int fgx;
    private TextView jLT;
    String jLU;
    private String mTitle;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.aWn = (MMActivity) context;
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = "";
        this.mTitle = "";
        this.fgw = -1;
        this.fgx = 8;
        this.jLT = null;
        this.jLU = "";
        this.aWn = (MMActivity) context;
        setLayoutResource(2130903996);
        setWidgetLayoutResource(2130904064);
    }

    public final void aWv() {
        if (this.jLT != null && this.jLU != null && !this.jLU.equals("") && this.aWn != null) {
            this.jLT.setText(this.aWn.getString(2131235148, new Object[]{this.jLU}));
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        this.mTitle = this.aWn.getString(2131235149);
        layoutInflater.inflate(2130903998, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jLT = (TextView) view.findViewById(2131758234);
        ((TextView) view.findViewById(2131758233)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(2131758235);
        if (textView != null) {
            textView.setVisibility(this.fgx);
            textView.setText(this.fgv);
            if (this.fgw != -1) {
                textView.setBackgroundDrawable(a.a(this.aWn, this.fgw));
            }
        }
        aWv();
    }
}
