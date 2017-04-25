package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedHashMap;
import java.util.List;

public final class h {
    private int bgColor;
    private Context context;
    private int eww;
    private int ewx;
    private ViewGroup ieE;
    private List<n> jBE;
    public LinkedHashMap<String, j> jBF;
    private LayoutInflater jBG;

    public h(List<n> list, Context context, int i, ViewGroup viewGroup) {
        this.jBE = list;
        this.context = context;
        this.bgColor = i;
        this.ieE = viewGroup;
    }

    public final void bq(List<n> list) {
        if (list != null && !list.equals(this.jBE)) {
            this.jBE = list;
            layout();
        }
    }

    public final void layout() {
        if (this.jBE != null && !this.jBE.isEmpty()) {
            if (this.jBF == null) {
                this.jBF = new LinkedHashMap();
            }
            if (this.jBG == null) {
                this.jBG = (LayoutInflater) this.context.getSystemService("layout_inflater");
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                this.eww = windowManager.getDefaultDisplay().getWidth();
                this.ewx = windowManager.getDefaultDisplay().getHeight();
            }
            for (int i = 0; i < this.jBE.size(); i++) {
                n nVar = (n) this.jBE.get(i);
                j jVar = (j) this.jBF.get(nVar.jvG);
                if (jVar != null) {
                    jVar.a(nVar);
                } else {
                    jVar = aj.a(this.context, nVar, this.ieE, this.bgColor);
                    if (jVar != null) {
                        this.jBF.put(nVar.jvG, jVar);
                    }
                }
                try {
                    if (this.ieE != jVar.getView().getParent()) {
                        if (this.ieE.getChildCount() > i) {
                            this.ieE.addView(jVar.getView(), i);
                        } else {
                            this.ieE.addView(jVar.getView());
                        }
                    }
                } catch (Throwable e) {
                    v.e("CompRenderer", "component may have same id %s,%s", new Object[]{nVar.jvG, be.e(e)});
                }
            }
        }
    }
}
