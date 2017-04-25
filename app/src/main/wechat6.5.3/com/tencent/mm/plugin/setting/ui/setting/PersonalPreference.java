package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String bLc;
    private String bld;
    Bitmap cxY = null;
    String dFt = null;
    private TextView exG = null;
    ImageView fSv = null;
    private TextView iJL = null;
    int iJM = -1;
    private OnClickListener iJN;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
        setWidgetLayoutResource(2130904064);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904024, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.fSv == null) {
            this.fSv = (ImageView) view.findViewById(2131756901);
        }
        if (this.cxY != null) {
            this.fSv.setImageBitmap(this.cxY);
        } else if (this.iJM > 0) {
            this.fSv.setImageResource(this.iJM);
        } else if (this.dFt != null) {
            b.m(this.fSv, this.dFt);
        }
        this.fSv.setOnClickListener(this.iJN);
        if (!(this.exG == null || this.bld == null)) {
            this.exG.setText(e.a(this.mContext, this.bld, this.exG.getTextSize()));
        }
        if (this.iJL != null) {
            String str = be.kS(this.bLc) ? this.username : this.bLc;
            if (be.kS(this.bLc) && u.LL(this.username)) {
                this.iJL.setVisibility(8);
            }
            this.iJL.setText(this.mContext.getString(2131231058) + str);
        }
        super.onBindView(view);
    }
}
