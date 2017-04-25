package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.ad;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class t implements OnClickListener, e {
    private c ghX = null;
    int gjl;
    DialogInterface.OnClickListener gyJ = null;
    private Context mContext;

    public static class a {
        public String aJX;
        public String gyL;
        public String gyM;
        public String url;
    }

    public static class b {
        public String content;
        public Boolean gyN;
        public a gyO;
        public String title;
    }

    public t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.ghX = (c) view.getTag();
            v.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.ghX.field_appId);
            ak.vy().a(1219, this);
            ak.vy().a(new as(this.ghX.field_appId, u.bsY(), this.ghX.bln, this.ghX.ghz), 0);
            return;
        }
        v.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && kVar.getType() == 1219) {
            ak.vy().b(1219, this);
            ad adVar = new ad(((as) kVar).fut.czl.czs);
            b bVar = new b();
            bVar.gyN = Boolean.valueOf(adVar.gjP.gkI);
            bVar.title = adVar.gjP.aXz;
            bVar.content = adVar.gjP.gkY;
            if (adVar.gjP.god != null) {
                bVar.gyO = new a();
                bVar.gyO.aJX = adVar.gjP.god.gkY;
                bVar.gyO.gyL = adVar.gjP.god.gkZ;
                bVar.gyO.gyM = adVar.gjP.god.gla;
                bVar.gyO.url = adVar.gjP.god.glb;
            }
            this.ghX.ghr = bVar.gyN.booleanValue();
            if (!be.kS(bVar.title)) {
                if (bVar.gyO != null) {
                    final String str2 = bVar.gyO.url;
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.mContext);
                    aVar.Op(bVar.title);
                    aVar.Oq(bVar.gyO.aJX);
                    aVar.jk(false);
                    aVar.Os(bVar.gyO.gyL).a(true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ t gyK;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.game.e.c.W(this.gyK.mContext, str2);
                            af.a(this.gyK.mContext, this.gyK.ghX.scene, this.gyK.ghX.bmG, this.gyK.ghX.position, 17, this.gyK.ghX.field_appId, this.gyK.gjl, this.gyK.ghX.bln, this.gyK.ghX.ghF);
                        }
                    });
                    aVar.Ot(bVar.gyO.gyM).b(this.gyJ);
                    aVar.RX().show();
                    return;
                } else if (!be.kS(bVar.content)) {
                    com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this.mContext);
                    aVar2.Op(bVar.title);
                    aVar2.Oq(bVar.content);
                    aVar2.jk(false);
                    aVar2.wp(2131233136).a(this.gyJ);
                    aVar2.RX().show();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(this.mContext);
        aVar3.wn(2131233137);
        aVar3.wp(2131233136);
        aVar3.RX().show();
    }
}
