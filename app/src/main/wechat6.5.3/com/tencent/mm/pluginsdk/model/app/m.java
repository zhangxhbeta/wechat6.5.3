package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class m implements s {
    Vector<String> lAA = new Vector();
    private volatile boolean lAB = false;
    private List<String> lAi = new ArrayList();

    public m() {
        am.ash().a(1, (s) this);
    }

    public final void Ez(String str) {
        v.d("MicroMsg.AppSettingService", "appId = " + str);
        if (be.kS(str)) {
            v.e("MicroMsg.AppSettingService", "add appId is null");
            return;
        }
        if (!this.lAA.contains(str)) {
            this.lAA.add(str);
        }
        arU();
    }

    public final void bK(List<String> list) {
        if (list == null || list.size() == 0) {
            v.e("MicroMsg.AppSettingService", "addAll list is null");
            return;
        }
        for (String str : list) {
            if (!(be.kS(str) || this.lAA.contains(str))) {
                this.lAA.add(str);
            }
        }
        arU();
    }

    private void arU() {
        int i = 20;
        if (this.lAB) {
            v.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
        } else if (this.lAA.size() <= 0) {
            v.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
        } else {
            v.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.lAA.size());
            int size = this.lAA.size();
            if (size <= 20) {
                i = size;
            }
            this.lAB = true;
            this.lAi.addAll(this.lAA.subList(0, i));
            ak.vy().a(new w(1, new ad(this.lAi)), 0);
        }
    }

    public final void a(int i, int i2, String str, v vVar) {
        if (vVar.getType() == 1) {
            this.lAB = false;
            v.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ad) vVar).lAQ.size());
            this.lAA.removeAll(this.lAi);
            this.lAi.clear();
            arU();
        }
    }
}
