package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wenote.c.f;
import com.tencent.mm.plugin.wenote.c.i;
import com.tencent.mm.plugin.wenote.c.l;
import com.tencent.mm.plugin.wenote.ui.a.a;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;

public final class c extends b implements e {
    private static HashMap<f, a> ltS = new HashMap();
    public long bjH = -1;
    public String ltQ = "";
    private f ltR;

    public c() {
        ltA.clear();
        ltB.clear();
        ltz = null;
        ltF = "";
        this.lsA = false;
        ak.vy().a(426, this);
    }

    public final String f(pw pwVar) {
        ez ezVar = new ez();
        ezVar.bdQ.type = 2;
        ezVar.bdQ.bdS = pwVar;
        com.tencent.mm.sdk.c.a.nhr.z(ezVar);
        return ezVar.bdR.path;
    }

    public final void m(pw pwVar) {
        a aVar = this.lty;
        ez ezVar = new ez();
        ezVar.bdQ.type = 28;
        ezVar.bdQ.aZa = aVar.lvF.field_localId;
        ezVar.bdQ.bdS = pwVar;
        com.tencent.mm.sdk.c.a.nhr.z(ezVar);
    }

    public final boolean blY() {
        return false;
    }

    public final void r(Context context, Intent intent) {
        if (!this.lsA) {
            intent.putExtra("key_detail_info_id", this.bjH);
        }
        com.tencent.mm.ay.c.b(context, "wenote", ".ui.webview.WNNoteFavWebViewUI", intent);
    }

    public final void FN(String str) {
        l lVar = (l) this.ltD.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.ltQ);
        if (lVar != null) {
            intent.putExtra("key_detail_data_id", lVar.luu);
        }
        intent.putExtra("key_detail_can_delete", false);
        com.tencent.mm.ay.c.b(aa.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
    }

    public final void FP(String str) {
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.ltQ);
        if (this.ltD.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.wenote.c.e) this.ltD.get(str)).luu);
        }
        com.tencent.mm.ay.c.b(aa.getContext(), "favorite", ".ui.FavImgGalleryUI", intent);
    }

    public final void FO(String str) {
        String str2 = "";
        i iVar = (i) this.ltD.get(str);
        if (iVar == null) {
            g.bf(aa.getContext(), aa.getContext().getString(2131232713));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kwebmap_slat", iVar.lat);
        intent.putExtra("kwebmap_lng", iVar.lng);
        intent.putExtra("kPoiName", iVar.gUr);
        intent.putExtra("Kwebmap_locaion", iVar.cJf);
        if (iVar.lux >= 0.0d) {
            intent.putExtra("kwebmap_scale", iVar.lux);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.bjH);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        com.tencent.mm.ay.c.b(aa.getContext(), "location", ".ui.RedirectUI", intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 426) {
            ez ezVar = new ez();
            ezVar.bdQ.aZJ = kVar;
            ezVar.bdQ.type = 31;
            com.tencent.mm.sdk.c.a.nhr.z(ezVar);
            if (!be.kS(ezVar.bdR.path) && i2 == -435) {
                v.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            ak.vy().b(426, this);
        }
    }

    public final void FQ(String str) {
        this.ltQ = str;
    }
}
