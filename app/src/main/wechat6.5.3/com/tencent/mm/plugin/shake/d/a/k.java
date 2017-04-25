package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.h.j;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public final class k {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ d iQu;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(d dVar, Context context) {
            this.iQu = dVar;
            this.val$context = context;
        }

        public final void run() {
            k.a(this.iQu, this.val$context, false);
        }
    }

    public static void a(d dVar, Context context, boolean z) {
        if (dVar != null) {
            Intent intent;
            switch (dVar.field_type) {
                case 6:
                    String str = dVar.field_username;
                    ak.yW();
                    u LX = c.wH().LX(str);
                    if (LX != null) {
                        Intent intent2 = new Intent();
                        if (a.ei(LX.field_type) && LX.bvm()) {
                            com.tencent.mm.modelbiz.u.Dy().ho(str);
                            if (dVar.field_distance.equals("1")) {
                                intent2.putExtra("Chat_User", str);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.drp.e(intent2, context);
                                return;
                            }
                        }
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.ay.c.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                case 7:
                    Intent intent3 = new Intent();
                    int i = 18;
                    if (z) {
                        i = 26;
                    }
                    intent3.putExtra("geta8key_scene", i);
                    intent3.putExtra("stastic_scene", 6);
                    intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                    intent3.putExtra("jsapiargs", bundle);
                    intent3.putExtra("rawUrl", dVar.field_username);
                    intent3.putExtra("srcUsername", dVar.field_distance);
                    com.tencent.mm.plugin.shake.a.drp.j(intent3, context);
                    return;
                case 8:
                    intent = new Intent();
                    intent.setClass(context, TVInfoUI.class);
                    intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                    intent.putExtra("key_TV_come_from_shake", true);
                    context.startActivity(intent);
                    return;
                case 9:
                    fz fzVar = new fz();
                    fzVar.bfx.actionCode = 11;
                    fzVar.bfx.bfz = dVar.field_username;
                    fzVar.bfx.context = context;
                    fzVar.bpT = null;
                    com.tencent.mm.sdk.c.a.nhr.a(fzVar, Looper.myLooper());
                    return;
                case 10:
                    intent = new Intent();
                    intent.putExtra("key_product_id", dVar.field_username);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.ay.c.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                    a(dVar.field_distance, dVar.field_username, z ? 4 : 3, context);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean pq(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i;
    }

    public static boolean aNM() {
        if (q.dqa) {
            return true;
        }
        String value = j.sU().getValue("ShowShakeTV");
        v.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[]{value});
        if (be.kS(value) || !value.equals("1")) {
            return false;
        }
        return true;
    }

    public static void a(n nVar, Context context, int i) {
        if (nVar != null) {
            if (be.kS(nVar.field_username) && be.kS(nVar.field_deeplink)) {
                g.iuh.h(12108, new Object[]{be.ma(nVar.field_username), Integer.valueOf(i), Integer.valueOf(0)});
                return;
            }
            a(nVar.field_username, nVar.field_deeplink, i, context);
            v.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
    }

    private static void a(String str, String str2, int i, Context context) {
        if (!be.kS(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i2 = 16;
            if (i == 3 || i == 4) {
                i2 = 17;
            }
            intent.putExtra("translate_link_scene", i2);
            context.startActivity(intent);
            v.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            g.iuh.h(12108, new Object[]{be.ma(str), Integer.valueOf(i), Integer.valueOf(1)});
        }
    }
}
