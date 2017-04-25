package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.e.ac;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.d.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class i implements a {
    Activity aXH;
    private ac jEK;
    private int scene = 0;

    public i(Activity activity, int i, ac acVar) {
        this.aXH = activity;
        this.scene = i;
        this.jEK = acVar;
    }

    public final void aW(Object obj) {
        int i = 1;
        boolean z = false;
        Intent intent = new Intent();
        if (this.aXH != null) {
            String str;
            if (obj instanceof com.tencent.mm.plugin.sns.data.a) {
                com.tencent.mm.plugin.sns.data.a aVar = (com.tencent.mm.plugin.sns.data.a) obj;
                v.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.aXH == null));
                k Bq = ad.aSE().Bq(aVar.bde);
                if (aVar.jdE) {
                    b aUm = Bq.aUm();
                    String aUQ = Bq.aUQ();
                    String aUQ2;
                    if (aUm == null || aUm.juz != 1 || be.kS(aUm.juA)) {
                        this.jEK.aSj().a(Bq, false);
                        intent.putExtra("Contact_User", aVar.userName);
                        intent.putExtra("Contact_Scene", 37);
                        com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.aXH);
                        aUQ2 = Bq.aUQ();
                        int i2 = aVar.scene;
                        String str2 = "";
                        if (Bq.field_type != 1) {
                            i = 2;
                        }
                        ak.vy().a(new c(aUQ2, 2, i2, str2, i), 0);
                        return;
                    }
                    aUQ2 = aUm.juA;
                    v.i("Micro.ClickableCallBack", "headClickParam url " + aUQ2 + " " + aUm.juB);
                    Intent intent2 = new Intent();
                    if (aUm.juB == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", aUQ);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", aUQ2);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.aXH);
                    return;
                }
                str = aVar.userName;
                com.tencent.mm.modelsns.a gh = this.scene == 0 ? com.tencent.mm.modelsns.a.gh(719) : com.tencent.mm.modelsns.a.gi(719);
                gh.kj(com.tencent.mm.plugin.sns.data.i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(str);
                gh.JF();
                gh = this.scene == 0 ? com.tencent.mm.modelsns.a.gh(746) : com.tencent.mm.modelsns.a.gi(746);
                gh.kj(str).bg(str.endsWith(com.tencent.mm.model.k.xF()));
                gh.b(intent, "intent_key_StatisticsOplog");
                if (this.scene == 0) {
                    this.jEK.aSj().a(Bq, false);
                }
            } else {
                str = (String) obj;
                if (this.scene == 0) {
                    k kVar = new k();
                    kVar.field_userName = str;
                    this.jEK.aSj().a(kVar, false);
                }
            }
            intent.setClass(this.aXH, SnsUserUI.class);
            Intent e = ad.aSu().e(intent, str);
            if (e == null) {
                this.aXH.finish();
                return;
            }
            this.aXH.startActivity(e);
            if ((e.getFlags() & 67108864) != 0) {
                this.aXH.finish();
            }
        }
    }
}
