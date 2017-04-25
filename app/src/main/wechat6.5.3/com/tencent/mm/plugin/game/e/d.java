package com.tencent.mm.plugin.game.e;

import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void b(f fVar) {
        if (fVar == null) {
            v.e("MicroMsg.GameDataUtil", "Null appInfo");
        } else if (be.kS(fVar.field_appId)) {
            v.e("MicroMsg.GameDataUtil", "Invalid appId");
        } else {
            f fVar2;
            boolean z;
            boolean m;
            String str = fVar.field_appId;
            f aC = g.aC(str, true);
            if (aC == null) {
                aC = new f();
                aC.field_appId = str;
                fVar2 = aC;
                z = true;
            } else {
                fVar2 = aC;
                z = false;
            }
            String bsY = u.bsY();
            if (bsY.equals("zh_CN")) {
                fVar2.field_appName = fVar.field_appName;
            } else if (bsY.equals("zh_TW") || bsY.equals("zh_HK")) {
                fVar2.field_appName_tw = fVar.field_appName;
            } else {
                fVar2.field_appName_en = fVar.field_appName;
            }
            fVar2.field_appType = fVar.field_appType;
            fVar2.field_packageName = fVar.field_packageName;
            fVar2.bE(fVar.bxo);
            fVar2.bH(fVar.bxt);
            fVar2.cN(fVar.bxx);
            fVar2.bI(fVar.bxu);
            fVar2.bN(fVar.bxA);
            fVar2.bO(fVar.bxB);
            fVar2.bL(fVar.bxy);
            fVar2.bM(fVar.bxz);
            fVar2.cO(fVar.bxD);
            if (!be.kS(fVar.bxr)) {
                fVar2.bF(fVar.bxr);
            }
            if (z) {
                m = am.bnB().m(fVar2);
                a.lxJ.Gi(str);
            } else if (fVar2.field_appVersion < fVar.field_appVersion) {
                v.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[]{Integer.valueOf(fVar2.field_appVersion), Integer.valueOf(fVar.field_appVersion)});
                m = am.bnB().a(fVar2, new String[0]);
                a.lxJ.Gi(str);
            } else {
                boolean z2 = (fVar2 == null || be.kS(fVar2.field_appIconUrl)) ? true : (fVar == null || be.kS(fVar.field_appIconUrl)) ? false : !fVar2.field_appIconUrl.equals(fVar.field_appIconUrl);
                if (z2) {
                    v.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[]{fVar2.field_appIconUrl, fVar.field_appIconUrl});
                    fVar2.field_appIconUrl = fVar.field_appIconUrl;
                    m = am.bnB().a(fVar2, new String[0]);
                    am.bnz().bz(str, 1);
                    am.bnz().bz(str, 2);
                    am.bnz().bz(str, 3);
                    am.bnz().bz(str, 4);
                    am.bnz().bz(str, 5);
                } else {
                    m = am.bnB().a(fVar2, new String[0]);
                }
            }
            v.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(m)});
        }
    }

    public static void N(LinkedList<? extends f> linkedList) {
        if (linkedList == null) {
            v.e("MicroMsg.GameDataUtil", "Null appInfos");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b((f) it.next());
        }
    }
}
