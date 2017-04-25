package com.tencent.mm.plugin.base.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class c {
    public static final String eni = aa.getPackageName();
    private static String enj = SQLiteDatabase.KeyEmpty;
    private static char[] enk = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean H(Context context, String str) {
        enj = k.xF();
        String str2 = enj;
        if (context == null || str == null) {
            v.e("MicroMsg.ShortcutManager", "add fail, invalid argument");
        } else {
            v.d("MicroMsg.ShortcutManager", "add shortcut %s", str);
            enj = str2;
            Intent a = a(context, str, true, enj);
            if (a == null) {
                v.e("MicroMsg.ShortcutManager", "add fail, intent is null");
            } else {
                context.sendBroadcast(a);
            }
        }
        return true;
    }

    public static boolean I(Context context, String str) {
        if (context == null || str == null) {
            v.e("MicroMsg.ShortcutManager", "remove fail, invalid argument");
            return false;
        }
        enj = k.xF();
        Intent a = a(context, str, false, enj);
        if (a == null) {
            v.e("MicroMsg.ShortcutManager", "remove fail, intent is null");
            return false;
        }
        context.sendBroadcast(a);
        return true;
    }

    private static Intent a(Context context, String str, boolean z, String str2) {
        if (str == null || context == null) {
            v.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            return null;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a = b.a(str, false, -1);
        if (a == null) {
            v.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a = d.uU(2130838080);
        }
        if (a == null) {
            v.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            Parcelable parcelable = null;
        } else {
            Object createScaledBitmap = Bitmap.createScaledBitmap(a, i, i, false);
        }
        if (parcelable == null) {
            v.e("MicroMsg.ShortcutManager", "no bmp");
            return null;
        }
        ak.yW();
        a LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) <= 0) {
            v.e("MicroMsg.ShortcutManager", "no such user");
            return null;
        }
        String pr = pr(str);
        if (be.kS(pr)) {
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", l.a(LX, str));
        intent.putExtra("duplicate", false);
        Parcelable intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.putExtra("LauncherUI.Shortcut.Username", pr);
        intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent2.putExtra("app_shortcut_custom_id", pr);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", parcelable);
        intent.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", eni);
        intent.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", pr(str2));
        intent.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", pr);
        intent.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", w(LX));
        intent.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        return intent;
    }

    public static int w(u uVar) {
        if (uVar.bvm()) {
            return 2;
        }
        if (m.fo(uVar.field_username)) {
            return 0;
        }
        return 1;
    }

    public static String ba(String str, String str2) {
        try {
            int i;
            int[] iArr = new int[FileUtils.S_IRUSR];
            byte[] bArr = new byte[FileUtils.S_IRUSR];
            for (i = 0; i < FileUtils.S_IRUSR; i++) {
                iArr[i] = i;
            }
            for (i = 0; i < FileUtils.S_IRUSR; i = (short) (i + 1)) {
                bArr[i] = (byte) str2.charAt(i % str2.length());
            }
            int i2 = 0;
            for (i = 0; i < WebView.NORMAL_MODE_ALPHA; i++) {
                i2 = ((i2 + iArr[i]) + bArr[i]) % FileUtils.S_IRUSR;
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
            }
            char[] toCharArray = str.toCharArray();
            char[] cArr = new char[toCharArray.length];
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < toCharArray.length; i = (short) (i + 1)) {
                i2 = (i2 + 1) % FileUtils.S_IRUSR;
                i4 = (i4 + iArr[i2]) % FileUtils.S_IRUSR;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i4];
                iArr[i4] = i5;
                cArr[i] = (char) (((char) iArr[(iArr[i2] + (iArr[i4] % FileUtils.S_IRUSR)) % FileUtils.S_IRUSR]) ^ toCharArray[i]);
            }
            return new String(cArr);
        } catch (Throwable e) {
            v.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", e.getMessage());
            v.a("MicroMsg.ShortcutManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static String pq(String str) {
        String str2 = null;
        if (str == null || str.length() <= 0) {
            return str2;
        }
        String p = be.p(aa.getContext(), Process.myPid());
        String packageName = aa.getPackageName();
        v.i("MicroMsg.ShortcutManager", "process name: %s", p);
        try {
            int ww;
            if (!packageName.equals(p)) {
                ww = z.Mx().dlt.ww();
            } else if (!ak.uz()) {
                return str2;
            } else {
                ak.yW();
                ww = com.tencent.mm.model.c.ww();
            }
            if (str.startsWith("shortcut_")) {
                return ba(new String(pt(str.substring(9))), String.valueOf(ww));
            }
            return str;
        } catch (Exception e) {
            v.a("MicroMsg.ShortcutManager", str2, "exception: %s", e.getMessage());
            return str2;
        }
    }

    public static String pr(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String p = be.p(aa.getContext(), Process.myPid());
        String packageName = aa.getPackageName();
        if (packageName.equals(p) && !ak.uz()) {
            return null;
        }
        v.i("MicroMsg.ShortcutManager", "process name: %s", p);
        try {
            if (packageName.equals(p)) {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                p = ba(str, stringBuilder.append(com.tencent.mm.model.c.ww()).toString());
            } else {
                p = ba(str, z.Mx().dlt.ww());
            }
            if (be.kS(p)) {
                return null;
            }
            return "shortcut_" + R(p.getBytes());
        } catch (Exception e) {
            v.a("MicroMsg.ShortcutManager", null, "exception: %s", e.getMessage());
            return null;
        }
    }

    public static String R(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(enk[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(enk[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static final byte[] pt(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
