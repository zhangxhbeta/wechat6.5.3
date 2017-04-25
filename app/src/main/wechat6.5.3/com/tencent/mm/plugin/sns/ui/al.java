package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ar;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class al {
    private Activity bij;
    private List<aib> gKQ = new ArrayList();

    public al(Activity activity) {
        this.bij = activity;
    }

    public static void d(Activity activity, String str) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            k Bq = f.Bq(str);
            Intent intent = new Intent();
            if (Bq != null) {
                azr aUp = Bq.aUp();
                aib com_tencent_mm_protocal_c_aib = aUp.mWq.mom.size() > 0 ? (aib) aUp.mWq.mom.get(0) : new aib();
                a gh = a.gh(716);
                gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_aib.gID).gk(0).gk(aUp.mWq.mom.size());
                gh.JF();
                a gh2 = a.gh(744);
                gh2.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR());
                gh2.b(intent, "intent_key_StatisticsOplog");
            }
            intent.putExtra("sns_gallery_localId", str);
            intent.putExtra("sns_gallery_position", 0);
            intent.putExtra("sns_gallery_showtype", 1);
            intent.putExtra("K_ad_scene", 1);
            intent.putExtra("k_is_from_sns_main_timeline", true);
            intent.setClass(activity, SnsBrowseUI.class);
            activity.startActivity(intent);
        }
    }

    public final void a(View view, int i, ar arVar) {
        Object tag = view.getTag();
        if (tag instanceof am) {
            am amVar = (am) tag;
            String str = amVar.bde;
            int i2 = amVar.index;
            int i3 = amVar.position;
            if (bb(str, i2)) {
                ak.yW();
                if (c.isSDCardAvailable()) {
                    k Bq = f.Bq(str);
                    if (bb(str, i2)) {
                        Intent intent = new Intent();
                        if (Bq != null) {
                            a gh;
                            if (arVar != null) {
                                arVar.jmQ.v(Bq);
                            }
                            azr aUp = Bq.aUp();
                            aib com_tencent_mm_protocal_c_aib = amVar.index < aUp.mWq.mom.size() ? (aib) aUp.mWq.mom.get(amVar.index) : new aib();
                            if (i == 1) {
                                gh = a.gh(716);
                            } else {
                                gh = a.gi(716);
                            }
                            gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_aib.gID).gk(amVar.index).gk(aUp.mWq.mom.size());
                            gh.JF();
                            gh = i == 1 ? a.gh(744) : a.gi(744);
                            gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR());
                            gh.b(intent, "intent_key_StatisticsOplog");
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i2);
                        intent.putExtra("sns_position", i3);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("k_is_from_sns_main_timeline", amVar.jMd);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.bij, SnsBrowseUI.class);
                        this.bij.startActivity(intent);
                        this.bij.overridePendingTransition(0, 0);
                    }
                }
            }
        }
    }

    private boolean bb(String str, int i) {
        k Bq = f.Bq(str);
        if (Bq == null) {
            return false;
        }
        azr aUp = Bq.aUp();
        if (aUp.mWq == null || aUp.mWq.mom.size() == 0) {
            return false;
        }
        this.gKQ.clear();
        Iterator it = aUp.mWq.mom.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            aib com_tencent_mm_protocal_c_aib = (aib) it.next();
            this.gKQ.add(com_tencent_mm_protocal_c_aib);
            if (i == i2) {
                boolean z;
                g aSB = ad.aSB();
                if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
                    z = false;
                } else if (FileOp.aR(com.tencent.mm.plugin.sns.e.al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.d(com_tencent_mm_protocal_c_aib))) {
                    z = true;
                } else if (FileOp.aR(com.tencent.mm.plugin.sns.e.al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib))) {
                    z = true;
                } else {
                    z = i.b((n) aSB.jiY.get(i.ab(1, com_tencent_mm_protocal_c_aib.gID)));
                }
                if (!z) {
                    return false;
                }
            }
            i2++;
        }
        return true;
    }
}
