package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.fy;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class a {

    public interface a {
        boolean Q(Activity activity);
    }

    public static void O(Activity activity) {
        if (c.EH("gesture")) {
            fy fyVar = new fy();
            fyVar.bfu.bfw = 0;
            fyVar.bfu.aXH = activity;
            com.tencent.mm.sdk.c.a.nhr.z(fyVar);
            switch (((Integer) fyVar.bfv.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent();
                    intent.setAction("action.verify_pattern");
                    intent.addFlags(131072);
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.setPackage(aa.getPackageName());
                    c.b(activity, "gesture", ".ui.GestureGuardLogicUI", intent);
                    g.iuh.h(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        }
        v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static void a(Activity activity, a aVar) {
        if (c.EH("gesture")) {
            fy fyVar = new fy();
            fyVar.bfu.bfw = 1;
            fyVar.bfu.aXH = activity;
            com.tencent.mm.sdk.c.a.nhr.z(fyVar);
            switch (((Integer) fyVar.bfv.data).intValue()) {
                case 17:
                    if (aVar == null || aVar.Q(activity)) {
                        Intent intent = new Intent();
                        intent.setAction("action.verify_pattern");
                        intent.addFlags(131072);
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.setPackage(aa.getPackageName());
                        c.b(activity, "gesture", ".ui.GestureGuardLogicUI", intent);
                        return;
                    }
                    v.d("MicroMsg.GestureGuardManager", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static void P(Activity activity) {
        if (c.EH("gesture")) {
            Intent intent = new Intent();
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            c.b(activity, "wallet", ".pwd.ui.WalletGestureCheckPwdUI", intent);
            return;
        }
        v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static boolean ati() {
        if (c.EH("gesture")) {
            fy fyVar = new fy();
            fyVar.bfu.bfw = 2;
            com.tencent.mm.sdk.c.a.nhr.z(fyVar);
            try {
                return ((Boolean) fyVar.bfv.data).booleanValue();
            } catch (Throwable e) {
                v.a("MicroMsg.GestureGuardManager", e, "", new Object[0]);
                return false;
            }
        }
        v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
        return false;
    }

    public static boolean bmM() {
        if (c.EH("gesture")) {
            fy fyVar = new fy();
            fyVar.bfu.bfw = 3;
            com.tencent.mm.sdk.c.a.nhr.z(fyVar);
            try {
                return ((Boolean) fyVar.bfv.data).booleanValue();
            } catch (Throwable e) {
                v.a("MicroMsg.GestureGuardManager", e, "", new Object[0]);
                return false;
            }
        }
        v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
        return false;
    }
}
