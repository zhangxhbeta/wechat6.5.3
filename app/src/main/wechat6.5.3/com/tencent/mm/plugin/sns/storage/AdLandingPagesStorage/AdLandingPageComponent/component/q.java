package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import org.json.JSONObject;

public final class q extends c {
    private h jxN;
    LinearLayout jyV;

    public q(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
    }

    public final void aTO() {
        super.aTO();
    }

    public final void aTP() {
        super.aTP();
    }

    protected final void aTS() {
        if (((m) this.jxU).jvF == 0) {
            this.jyV.setOrientation(1);
        } else if (((m) this.jxU).jvF == 1) {
            this.jyV.setOrientation(0);
        }
        if (this.jxN == null) {
            this.jxN = new h(((m) this.jxU).jvE, this.context, ((m) this.jxU).bgColor, this.jyV);
            this.jxN.layout();
            return;
        }
        this.jxN.bq(((m) this.jxU).jvE);
    }

    public final View aTM() {
        View view = this.dtW;
        this.jyV = (LinearLayout) view.findViewById(2131759246);
        return view;
    }

    protected final int aGY() {
        return 2130904424;
    }

    public final boolean x(JSONObject jSONObject) {
        if (super.x(jSONObject)) {
            return true;
        }
        return false;
    }
}
