package com.tencent.mm.plugin.game.e;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.ui.GameDetailUI2;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;

public final class c {
    private static int cUg = -1;
    private static DisplayMetrics guo;
    private static int gzG = -1;
    private static int maxSize = -1;
    private static Rect rect = new Rect();

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        if (guo == null) {
            guo = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(guo);
        }
        return guo.widthPixels;
    }

    public static void W(Context context, String str) {
        if (!be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.game.GameWebViewUI", intent);
        }
    }

    public static void n(Context context, String str, String str2) {
        if (!be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.game.GameWebViewUI", intent);
        }
    }

    public static void o(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str2);
        com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.TransparentWebViewUI", intent);
    }

    public static boolean a(View view, Context context) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            v.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        String str = (String) view.getTag();
        if (be.kS(str)) {
            v.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        a.drp.j(intent, context);
        return true;
    }

    public static Dialog ca(final Context context) {
        View inflate = View.inflate(context, 2130903747, null);
        final i iVar = new i(context, 2131558758);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (context instanceof MMActivity) {
                    ((MMActivity) context).finish();
                }
                iVar.setOnCancelListener(null);
            }
        });
        return iVar;
    }

    public static int ut(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = aa.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            v.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[]{e.toString()});
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int uu(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            return 0;
        }
        PackageInfo packageArchiveInfo = aa.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    public static void uv(String str) {
        com.tencent.mm.ae.a.a GL = n.GL();
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        aVar.cPr = true;
        GL.a(str, null, aVar.GU());
    }

    public static String bK(String str, String str2) {
        return str.replace("${first_nick_name}", str2);
    }

    public static void M(LinkedList<String> linkedList) {
        if (!be.bP(linkedList)) {
            am.bnF().bK(linkedList);
        }
    }

    public static LinkedList<f> asJ() {
        Cursor bnr = am.bnB().bnr();
        LinkedList<f> linkedList = new LinkedList();
        if (bnr == null) {
            v.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (bnr.moveToFirst()) {
                do {
                    f fVar = new f();
                    fVar.b(bnr);
                    linkedList.add(fVar);
                } while (bnr.moveToNext());
            }
            bnr.close();
        }
        return linkedList;
    }

    public static int a(Context context, String str, String str2, Bundle bundle) {
        if (!be.kS(str)) {
            com.tencent.mm.plugin.game.c.a.a uc = com.tencent.mm.plugin.game.c.a.uc(str);
            if (uc.bkU == 2 && !be.kS(uc.url)) {
                n(context, uc.url, "game_center_detail");
                return 7;
            }
        }
        if (be.kS(str2)) {
            int bU = e.bU(aa.getContext());
            if (bU == 2) {
                X(context, str);
                return 7;
            } else if (bU == 1) {
                b(context, bundle);
                return 6;
            } else {
                String buo = be.buo();
                if (be.kS(buo) || buo.toLowerCase().equals("cn")) {
                    X(context, str);
                    return 7;
                }
                b(context, bundle);
                return 6;
            }
        }
        n(context, str2, "game_center_detail");
        return 7;
    }

    public static void X(Context context, String str) {
        if (!be.kS(str)) {
            String string = aa.getContext().getSharedPreferences("game_center_pref", 0).getString("game_detail_jump_url", "");
            if (be.kS(string)) {
                string = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=" + str;
            } else {
                string = string + "?appid=" + str;
            }
            n(context, string, "game_center_detail");
        }
    }

    public static void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, GameDetailUI2.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
