package com.tencent.mm.plugin.base.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.m;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static List<com.tencent.mm.u.d.a> enb = new LinkedList();

    public static boolean o(Context context, String str, int i) {
        if (context == null || str == null) {
            v.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            return false;
        }
        b mVar = new m();
        mVar.aWJ.aWH = str;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        if (mVar.aWK.aWL) {
            Bitmap a = a(mVar);
            if (a == null) {
                v.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
                return true;
            }
            Intent a2 = a(context, mVar, i, a(context, a, i), true);
            if (a2 == null) {
                v.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
                return false;
            }
            context.sendBroadcast(a2);
            v.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", str);
            return true;
        }
        v.e("MicroMsg.AppBrandShortcutManager", "no such user");
        return false;
    }

    public static boolean p(Context context, String str, int i) {
        if (context == null || str == null) {
            v.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
            return false;
        }
        b mVar = new m();
        mVar.aWJ.aWH = str;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        if (mVar.aWK.aWL) {
            Intent a = a(context, mVar, i, a(context, a(mVar), i), false);
            if (a == null) {
                v.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                return false;
            }
            context.sendBroadcast(a);
            v.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", str);
            return true;
        }
        v.e("MicroMsg.AppBrandShortcutManager", "no such user");
        return false;
    }

    public static boolean c(Context context, String str, Intent intent) {
        if (context == null) {
            v.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
            return false;
        } else if (intent == null) {
            v.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
            return false;
        } else {
            b mVar = new m();
            mVar.aWJ.aWH = str;
            com.tencent.mm.sdk.c.a.nhr.z(mVar);
            if (mVar.aWK.aWL) {
                String str2 = TextUtils.isEmpty(mVar.aWK.appName) ? str : mVar.aWK.appName;
                Parcelable a = a(mVar);
                Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
                intent2.putExtra("duplicate", false);
                intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                intent2.putExtra("android.intent.extra.shortcut.ICON", a);
                context.sendBroadcast(intent);
                v.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", str);
                return true;
            }
            v.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", str);
            return false;
        }
    }

    private static Intent a(Context context, m mVar, int i, Bitmap bitmap, boolean z) {
        if (context == null || mVar.aWJ.aWH == null) {
            v.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            return null;
        } else if (bitmap == null && z) {
            v.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            return null;
        } else {
            String str = mVar.aWJ.aWH;
            String str2 = TextUtils.isEmpty(mVar.aWK.appName) ? str : mVar.aWK.appName;
            String str3 = mVar.aWK.appId;
            String po = po(str);
            if (be.kS(po)) {
                return null;
            }
            str = z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT";
            String m = g.m((str2 + mVar.aWK.dHg + mVar.aWK.cxh).getBytes());
            Intent intent = new Intent(str);
            intent.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra("type", 1);
            intent2.putExtra("id", po);
            intent2.putExtra("ext_info", po(str3));
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            intent2.putExtra("token", aZ(str3, stringBuilder.append(c.ww()).toString()));
            intent2.putExtra("digest", m);
            intent2.putExtra("ext_info_1", i);
            intent2.setPackage(context.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            return intent;
        }
    }

    private static Bitmap a(m mVar) {
        Bitmap gs = com.tencent.mm.t.a.b.AL().gs(mVar.aWK.dHg);
        if (gs == null || gs.isRecycled()) {
            gs = com.tencent.mm.t.a.b.AL().gs(mVar.aWK.cxh);
        }
        if (gs == null || gs.isRecycled()) {
            return d.uU(2131165440);
        }
        return gs;
    }

    private static Bitmap a(Context context, Bitmap bitmap, int i) {
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int density = (int) (com.tencent.mm.bd.a.getDensity(context) * 48.0f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
        if (i == 2) {
            a(context, createScaledBitmap, com.tencent.mm.bd.a.O(context, 2131236728));
            return createScaledBitmap;
        } else if (i != 1) {
            return createScaledBitmap;
        } else {
            a(context, createScaledBitmap, com.tencent.mm.bd.a.O(context, 2131236729));
            return createScaledBitmap;
        }
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        if (context != null && bitmap != null && !bitmap.isRecycled() && !be.kS(str)) {
            int width = bitmap.getWidth();
            float density = com.tencent.mm.bd.a.getDensity(context);
            float f = 4.0f * density;
            float f2 = density * 2.0f;
            density *= 6.0f;
            Paint paint = new Paint();
            paint.setTextSize(density);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            density = paint.measureText(str);
            FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            Rect rect = new Rect((int) ((((float) width) - density) - (f * 2.0f)), (width * 2) / 3, width, (int) ((f3 + ((float) ((width * 2) / 3))) + (f2 * 2.0f)));
            canvas.drawRect(rect, paint);
            paint.setColor(-1);
            canvas.drawText(str, ((float) rect.left) + f, (((float) rect.top) + f2) - fontMetrics.ascent, paint);
        }
    }

    public static String pn(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String p = be.p(aa.getContext(), Process.myPid());
        v.i("MicroMsg.AppBrandShortcutManager", "process name: %s", p);
        if (str.startsWith("shortcut_")) {
            return c.ba(new String(c.pt(str.substring(9))), p.rJ());
        }
        return str;
    }

    private static String po(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String p = be.p(aa.getContext(), Process.myPid());
        v.i("MicroMsg.AppBrandShortcutManager", "process name: %s", p);
        p = c.ba(str, p.rJ());
        if (be.kS(p)) {
            return null;
        }
        return "shortcut_" + c.R(p.getBytes());
    }

    public static String aZ(String str, String str2) {
        return g.m((g.m(str.getBytes()) + c.ba(str2, str)).getBytes());
    }
}
