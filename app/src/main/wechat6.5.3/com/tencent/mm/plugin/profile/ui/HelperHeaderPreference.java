package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private TextView dtE;
    private ImageView dtz;
    private u euW;
    private boolean hWA = false;
    private TextView hWx;
    private TextView hWy;
    private a hWz;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.dtz = (ImageView) view.findViewById(2131755444);
        this.dtE = (TextView) view.findViewById(2131756462);
        this.hWx = (TextView) view.findViewById(2131755445);
        this.hWy = (TextView) view.findViewById(2131755446);
        this.hWA = true;
        NI();
        super.onBindView(view);
    }

    public final void eO(boolean z) {
        if (this.hWz != null) {
            if (z) {
                this.dtE.setTextColor(r.eL(this.mContext));
                this.dtE.setText(2131235101);
                this.dtE.setCompoundDrawablesWithIntrinsicBounds(2130839256, 0, 0, 0);
                return;
            }
            this.dtE.setTextColor(r.eM(this.mContext));
            this.dtE.setText(2131235109);
            this.dtE.setCompoundDrawablesWithIntrinsicBounds(2130839255, 0, 0, 0);
        }
    }

    private void NI() {
        if (!this.hWA || this.euW == null) {
            v.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.hWA + "contact = " + this.euW);
            return;
        }
        String str = this.euW.field_username;
        v.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + str);
        if (this.dtz != null && this.euW.field_username.equals(str)) {
            b.m(this.dtz, str);
        }
        if (this.hWx != null) {
            this.hWx.setText(this.euW.tT());
        }
        if (this.hWz != null) {
            this.hWz.a(this);
            CharSequence hint = this.hWz.getHint();
            if (hint != null) {
                this.hWy.setText(hint);
                this.hWy.setVisibility(0);
                return;
            }
            this.hWy.setVisibility(8);
        }
    }

    public final void a(u uVar, a aVar) {
        Assert.assertTrue(uVar != null);
        this.euW = uVar;
        this.hWz = aVar;
        NI();
    }
}
