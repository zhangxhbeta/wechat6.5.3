package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    Region oVv;
    private CharSequence oVw;
    private TextView oVx;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    public final void setSummary(CharSequence charSequence) {
        this.oVw = charSequence;
        bJx();
    }

    private void bJx() {
        if (this.oVx != null) {
            if (this.oVw == null || t.kS(this.oVw.toString())) {
                this.oVx.setVisibility(8);
            } else {
                this.oVx.setVisibility(0);
            }
            this.oVx.setText(this.oVw);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904034, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.oVv != null) {
            ((TextView) view.findViewById(2131758269)).setText(this.oVv.getName());
            this.oVx = (TextView) view.findViewById(2131758272);
            bJx();
        }
    }
}
