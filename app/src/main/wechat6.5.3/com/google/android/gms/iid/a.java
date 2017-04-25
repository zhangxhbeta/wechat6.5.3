package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map<String, a> arD = new HashMap();
    public static e arE;
    private static d arF;
    public static String arJ;
    KeyPair arG;
    public String arH = SQLiteDatabase.KeyEmpty;
    long arI;
    Context mContext;

    private a(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.arH = str;
    }

    static int E(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            new StringBuilder("Never happens: can't find own package ").append(e);
            return i;
        }
    }

    public static a F(Context context) {
        return a(context, null);
    }

    public static synchronized a a(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? SQLiteDatabase.KeyEmpty : bundle.getString("subtype");
            String str = string == null ? SQLiteDatabase.KeyEmpty : string;
            Context applicationContext = context.getApplicationContext();
            if (arE == null) {
                arE = new e(applicationContext);
                arF = new d(applicationContext);
            }
            arJ = Integer.toString(E(applicationContext));
            aVar = (a) arD.get(str);
            if (aVar == null) {
                aVar = new a(applicationContext, str);
                arD.put(str, aVar);
            }
        }
        return aVar;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + MMGIFException.D_GIF_ERR_IMAGE_DEFECT) & WebView.NORMAL_MODE_ALPHA);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static String c(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean kA() {
        String str = arE.get("appVersion");
        if (str == null || !str.equals(arJ)) {
            return true;
        }
        str = arE.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    static e ky() {
        return arE;
    }

    static d kz() {
        return arF;
    }

    public final String b(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        String str3 = SQLiteDatabase.KeyEmpty.equals(this.arH) ? str : this.arH;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        d dVar = arF;
        if (this.arG == null) {
            this.arG = arE.ad(this.arH);
        }
        if (this.arG == null) {
            this.arI = System.currentTimeMillis();
            this.arG = arE.a(this.arH, this.arI);
        }
        KeyPair keyPair = this.arG;
        Intent a = dVar.a(bundle, keyPair);
        if (a != null && a.hasExtra("google.messenger")) {
            a = dVar.a(bundle, keyPair);
        }
        return d.g(a);
    }
}
