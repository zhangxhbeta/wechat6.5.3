package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.bd.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LayoutInflater CE;
    private LinearLayout hTU;
    private List<String> hTV;
    private int hTW;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTW = -1;
        this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        this.CE.inflate(2130903415, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.hTU = (LinearLayout) view.findViewById(2131756108);
        av();
    }

    public final void oh(int i) {
        if (i != this.hTW) {
            this.hTW = i;
            av();
        }
    }

    public final void aX(List<String> list) {
        this.hTV = list;
        av();
    }

    private void av() {
        int i = 0;
        if (this.hTU != null) {
            this.hTU.removeAllViews();
            if (this.hTW >= 0) {
                int i2 = this.hTW;
                while (i < 5) {
                    if (i2 <= 0) {
                        oi(2131165306);
                    } else if (i2 <= 10) {
                        oi(2131165304);
                        i2 -= 20;
                    } else {
                        oi(2131165305);
                        i2 -= 20;
                    }
                    i++;
                }
            } else if (this.hTV != null) {
                for (String str : this.hTV) {
                    CdnImageView cdnImageView = new CdnImageView(this.mContext);
                    cdnImageView.G(str, 0, 0);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
                    layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
                    this.hTU.addView(cdnImageView, layoutParams);
                }
            }
        }
    }

    private void oi(int i) {
        ImageView imageView = (ImageView) this.CE.inflate(2130903409, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.hTU.addView(imageView, layoutParams);
    }
}
