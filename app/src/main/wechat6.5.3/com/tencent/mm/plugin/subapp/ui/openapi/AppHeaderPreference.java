package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class AppHeaderPreference extends Preference {
    boolean brc = false;
    private TextView dtE;
    private ImageView dtz;
    private boolean hWA = false;
    private TextView hWx;
    private TextView hWy;
    a kgE;

    public interface a {
        Bitmap aZA();

        String aZz();

        String gD(boolean z);

        String getHint();
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.dtz = (ImageView) view.findViewById(2131755444);
        this.dtE = (TextView) view.findViewById(2131756462);
        this.hWx = (TextView) view.findViewById(2131755445);
        this.hWy = (TextView) view.findViewById(2131755446);
        this.hWA = true;
        if (!this.hWA || this.kgE == null) {
            v.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.hWA);
        } else {
            Bitmap aZA = this.kgE.aZA();
            if (!(this.dtz == null || aZA == null || aZA.isRecycled())) {
                this.dtz.setImageBitmap(aZA);
            }
            CharSequence aZz = this.kgE.aZz();
            if (!(this.hWx == null || aZz == null || aZz.length() <= 0)) {
                this.hWx.setText(aZz);
            }
            aZz = this.kgE.getHint();
            if (aZz != null) {
                this.hWy.setText(aZz);
                this.hWy.setVisibility(0);
            } else {
                this.hWy.setVisibility(8);
            }
            boolean z = this.brc;
            if (this.dtE != null) {
                CharSequence gD = this.kgE.gD(z);
                if (z) {
                    if (gD == null || gD.length() <= 0) {
                        this.dtE.setVisibility(8);
                    } else {
                        this.dtE.setTextColor(r.eL(this.mContext));
                        this.dtE.setText(gD);
                        this.dtE.setCompoundDrawablesWithIntrinsicBounds(2130839256, 0, 0, 0);
                    }
                } else if (gD == null || gD.length() <= 0) {
                    this.dtE.setVisibility(8);
                } else {
                    this.dtE.setTextColor(r.eM(this.mContext));
                    this.dtE.setText(gD);
                    this.dtE.setCompoundDrawablesWithIntrinsicBounds(2130839255, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
    }
}
