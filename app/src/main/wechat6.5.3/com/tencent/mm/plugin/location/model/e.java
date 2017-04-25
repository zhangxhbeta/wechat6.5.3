package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class e {
    public static PackageInfo ag(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 1);
        } catch (Throwable e) {
            v.a("MicroMsg.MapUtil", e, "", new Object[0]);
        } catch (Throwable e2) {
            v.a("MicroMsg.MapUtil", e2, "", new Object[0]);
        }
        return packageInfo;
    }

    public static String a(LocationInfo locationInfo) {
        if (locationInfo.bkV == null) {
            locationInfo.bkV = "";
        }
        return "<msg><location x=\"" + locationInfo.gRK + "\" y=\"" + locationInfo.gRL + "\" scale=\"" + locationInfo.zoom + "\" label=\"" + be.KJ(locationInfo.gRM) + "\" poiname=\"" + be.KJ(locationInfo.bkV) + "\" maptype=\"0" + "\" /></msg>";
    }

    public static String a(String str, String str2, View view) {
        OutputStream fileOutputStream;
        v.d("MicroMsg.MapUtil", "w h " + view.getWidth() + " " + ((view.getHeight() / 2) + 20));
        String str3 = str + str2 + ".png";
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), (int) (((double) view.getHeight()) * 0.7d), Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        v.d("MicroMsg.MapUtil", "saveMyBitmap " + str2);
        File file = new File(str + str2 + ".png");
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e) {
            v.a("MicroMsg.MapUtil", e, "", new Object[0]);
            fileOutputStream = null;
        }
        try {
            v.d("MicroMsg.MapUtil", "h " + createBitmap.getHeight() + " w:" + createBitmap.getWidth() + " ");
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.MapUtil", e2, "", new Object[0]);
                }
            }
            createBitmap.recycle();
            return str3;
        } catch (Throwable e3) {
            v.a("MicroMsg.MapUtil", e3, "", new Object[0]);
            return null;
        }
    }

    public static boolean f(double d, double d2) {
        if (Math.abs(d2) > 180.0d || Math.abs(d) > 90.0d) {
            return false;
        }
        return true;
    }
}
