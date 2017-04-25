package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public abstract class k extends j {
    int jya = 0;

    public k(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
    }

    protected final void aTX() {
        this.jya++;
    }

    public final boolean x(JSONObject jSONObject) {
        if (!super.x(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.jya);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
