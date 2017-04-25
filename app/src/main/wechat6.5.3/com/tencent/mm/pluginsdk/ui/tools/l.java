package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.as.u;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class l {
    private static String filePath = null;

    public static boolean a(Fragment fragment, Intent intent, String str) {
        return a(fragment, 226, intent, 1, str, 0);
    }

    public static boolean a(Fragment fragment, int i, Intent intent, int i2, String str, int i3) {
        Parcelable sightParams = new SightParams(1, i3);
        String lb = o.lb(str);
        k.KV();
        String lc = o.lc(lb);
        k.KV();
        sightParams.l(lb, lc, o.ld(lb), e.cgg + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        c.a(fragment, "mmsight", ".ui.SightCaptureUI", intent, 226);
        fragment.aG().overridePendingTransition(2130968673, -1);
        return true;
    }

    public static boolean u(Context context, Intent intent) {
        return a(context, 17, intent, 2, 0);
    }

    public static boolean a(Context context, int i, Intent intent, int i2, int i3) {
        return a(context, i, intent, i2, SQLiteDatabase.KeyEmpty, i3);
    }

    public static boolean a(Context context, int i, Intent intent, int i2, String str, int i3) {
        Parcelable parcelable = null;
        if (intent != null) {
            parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (parcelable == null) {
            parcelable = new SightParams(i2, i3);
        }
        if (i2 == 1) {
            String lb = o.lb(str);
            k.KV();
            String lc = o.lc(lb);
            k.KV();
            parcelable.l(lb, lc, o.ld(lb), e.cgg + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        }
        if (parcelable == null) {
            v.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        }
        intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
        c.b(context, "mmsight", ".ui.SightCaptureUI", intent, i);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(2130968673, -1);
        }
        return true;
    }

    public static boolean a(p pVar, String str, String str2) {
        boolean a = a(pVar, str, str2, 201);
        if (a) {
            b peVar = new pe();
            peVar.bqy.bqz = true;
            a.nhr.z(peVar);
        }
        v.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(201), Boolean.valueOf(a));
        return a;
    }

    private static boolean a(p pVar, String str, String str2, int i) {
        if (u.bi(pVar.nDR.nEl) || com.tencent.mm.ah.a.aT(pVar.nDR.nEl)) {
            return false;
        }
        filePath = str + str2;
        v.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        aV(pVar.nDR.nEl, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Throwable e) {
                v.a("MicroMsg.TakePhotoUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", Uri.fromFile(new File(filePath)));
            try {
                pVar.startActivityForResult(intent, 201);
                return true;
            } catch (ActivityNotFoundException e2) {
                v.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                return false;
            }
        }
        v.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + str);
        return false;
    }

    public static boolean d(Activity activity, String str, String str2, int i) {
        boolean e = e(activity, str, str2, i);
        if (e) {
            b peVar = new pe();
            peVar.bqy.bqz = true;
            a.nhr.z(peVar);
        }
        v.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(i), Boolean.valueOf(e));
        return e;
    }

    private static boolean e(Activity activity, String str, String str2, int i) {
        if (u.bi(activity) || com.tencent.mm.ah.a.aT(activity)) {
            return false;
        }
        filePath = str + str2;
        v.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        aV(activity, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Throwable e) {
                v.a("MicroMsg.TakePhotoUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", Uri.fromFile(new File(filePath)));
            try {
                activity.startActivityForResult(intent, i);
                return true;
            } catch (Exception e2) {
                v.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                return false;
            }
        }
        v.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + str);
        return false;
    }

    private static void aV(Context context, String str) {
        Editor edit = context.getSharedPreferences("system_config_prefs", 0).edit();
        edit.putString("camera_file_path", str);
        edit.commit();
    }

    public static boolean a(Activity activity, int i, Intent intent) {
        b peVar = new pe();
        peVar.bqy.bqz = true;
        a.nhr.z(peVar);
        a(activity, i, 1, 0, intent);
        return true;
    }

    public static boolean R(Activity activity) {
        b peVar = new pe();
        peVar.bqy.bqz = true;
        a.nhr.z(peVar);
        a(activity, 2, 1, 0, 1, false, null);
        return true;
    }

    public static boolean S(Activity activity) {
        b peVar = new pe();
        peVar.bqy.bqz = true;
        a.nhr.z(peVar);
        a(activity, 205, 1, 11, null);
        return true;
    }

    public static boolean k(Fragment fragment) {
        b peVar = new pe();
        peVar.bqy.bqz = true;
        a.nhr.z(peVar);
        a(fragment, 200, 1, 0, 1, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        return true;
    }

    public static boolean T(Activity activity) {
        b peVar = new pe();
        peVar.bqy.bqz = true;
        a.nhr.z(peVar);
        a(activity, 2, 1, 5, null);
        return true;
    }

    public static void b(Fragment fragment, int i, String str, String str2) {
        a(fragment, 217, 9, i, 1, str, str2);
    }

    public static void a(Fragment fragment, int i, String str, String str2) {
        a(fragment, 217, 9, i, 3, str, str2);
    }

    public static void a(Activity activity, int i, int i2, int i3, Intent intent) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.addFlags(67108864);
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
    }

    public static void a(Activity activity, int i, int i2, int i3, int i4, boolean z, Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.putExtra("query_media_type", i4);
        intent2.putExtra("show_header_view", z);
        intent2.addFlags(67108864);
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
    }

    public static void U(Activity activity) {
        a(activity, 2, 1, 10, 1, true, null);
    }

    private static void a(Fragment fragment, int i, int i2, int i3, int i4, String str, String str2) {
        Intent intent = new Intent();
        if (!be.kS(str2)) {
            intent.putExtra("GalleryUI_FromUser", str);
            intent.putExtra("GalleryUI_ToUser", str2);
        }
        intent.putExtra("max_select_count", i2);
        intent.putExtra("query_source_type", i3);
        intent.putExtra("query_media_type", i4);
        if (q.drg) {
            intent.putExtra("show_header_view", true);
        } else {
            intent.putExtra("show_header_view", false);
        }
        intent.addFlags(67108864);
        c.a(fragment, "gallery", ".ui.AlbumPreviewUI", intent, i);
    }

    public static void c(Activity activity, int i, int i2, Intent intent) {
        intent.putExtra("max_select_count", i);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("query_source_type", i2);
        intent.addFlags(67108864);
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent, 4);
    }

    public static void a(Activity activity, String str, int i, int i2, int i3, boolean z) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        Intent intent = new Intent();
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("android.intent.extra.videoQuality", i3);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z ? 1 : 0);
        if (i2 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i2);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        activity.startActivityForResult(intent, i);
    }

    public static String a(Context context, Intent intent, String str) {
        if (filePath == null) {
            filePath = context.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
        }
        if (filePath == null || !com.tencent.mm.a.e.aR(filePath)) {
            filePath = com.tencent.mm.ui.tools.a.b(context, intent, str);
        }
        d.c(filePath, context);
        return filePath;
    }

    public static void h(String str, Context context) {
        d.b(str, context);
    }

    public static String lV(String str) {
        return d.lV(str);
    }

    public static void c(String str, Context context) {
        d.c(str, context);
    }

    @TargetApi(8)
    public static String bqT() {
        return e.cgg;
    }

    public static String MT() {
        return d.MT();
    }
}
