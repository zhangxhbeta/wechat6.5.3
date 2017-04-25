package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends c {
    private List<j> jvl = new ArrayList();
    private d jxM;
    private h jxN;

    public g(Context context, d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
        this.jxM = dVar;
    }

    protected final void aTS() {
        if (this.jxN == null) {
            this.jxN = new h(this.jxM.jvl, this.context, 0, (FrameLayout) this.dtW);
            this.jxN.layout();
            return;
        }
        this.jxN.bq(this.jxM.jvl);
    }

    protected final View aTT() {
        return new FrameLayout(this.context);
    }

    public final void aTO() {
        super.aTO();
        for (j aTO : this.jvl) {
            aTO.aTO();
        }
    }

    public final void aTP() {
        super.aTP();
        for (j aTP : this.jvl) {
            aTP.aTP();
        }
    }

    public final void K(int i, int i2, int i3) {
        super.K(i, i2, i3);
        for (j K : this.jvl) {
            K.K(i, i2, i3);
        }
    }

    public final void aTU() {
        super.aTU();
        for (j aTU : this.jvl) {
            aTU.aTU();
        }
    }

    public final boolean o(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.x(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (j jVar : this.jvl) {
            JSONObject jSONObject2 = new JSONObject();
            if (jVar != null && jVar.x(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
