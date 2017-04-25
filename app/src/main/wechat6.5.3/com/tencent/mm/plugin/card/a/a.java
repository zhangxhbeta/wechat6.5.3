package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.e.a.mx.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class a extends c<mx> implements e {
    private mx eAN;

    public a() {
        this.nhz = mx.class.getName().hashCode();
    }

    private boolean a(mx mxVar) {
        if (!ak.uz()) {
            v.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            return false;
        } else if (!(mxVar instanceof mx)) {
            return false;
        } else {
            this.eAN = mxVar;
            Object obj = this.eAN.boj.bol;
            String str = this.eAN.boj.bom;
            int i = this.eAN.boj.bon;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                ZH();
                return false;
            }
            ak.vy().a(651, this);
            v.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
            ak.vy().a(new k(obj, i, "", str, "", "", 0, 0, null), 0);
            return true;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof k) {
            b bVar = new b();
            v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                k kVar2 = (k) kVar;
                int i3 = kVar2.eDo;
                String str2 = kVar2.eDn;
                String str3 = kVar2.eDp;
                if (i3 == 0) {
                    v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.bbq = true;
                    CardInfo cardInfo = new CardInfo();
                    d.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.bol = "";
                    } else {
                        bVar.bol = cardInfo.field_card_id;
                    }
                    af.aap().putValue("key_accept_card_info", cardInfo);
                } else {
                    v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    bVar.bbq = false;
                }
            } else {
                v.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.bbq = false;
            }
            ak.vy().b(651, this);
            this.eAN.bok = bVar;
            ZH();
        }
    }

    private void ZH() {
        if (this.eAN.bpT != null) {
            this.eAN.bpT.run();
        }
        this.eAN = null;
    }
}
