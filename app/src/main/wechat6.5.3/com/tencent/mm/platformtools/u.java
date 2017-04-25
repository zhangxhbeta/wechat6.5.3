package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class u {

    public static class a {
        public static int F(Context context, String str) {
            Context createPackageContext;
            Context context2 = null;
            try {
                createPackageContext = context.createPackageContext(str, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.YYBMarketVerify", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                createPackageContext = context2;
            }
            if (createPackageContext == null) {
                return 0;
            }
            AssetManager assets = createPackageContext.getAssets();
            Resources resources = new Resources(assets, context.getResources().getDisplayMetrics(), context2);
            try {
                XmlResourceParser a = a(createPackageContext, assets);
            } catch (Throwable e2) {
                v.a("MicroMsg.YYBMarketVerify", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                Object obj = context2;
            }
            if (a == null) {
                return 0;
            }
            int eventType;
            try {
                eventType = a.getEventType();
            } catch (Throwable e3) {
                v.a("MicroMsg.YYBMarketVerify", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                eventType = 0;
            }
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        Object name = a.getName();
                        if (!TextUtils.isEmpty(name) && name.equals("manifest")) {
                            Object a2 = a(a.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode"), resources);
                            if (TextUtils.isEmpty(a2)) {
                                return 0;
                            }
                            return t.getInt(a2, 0);
                        }
                }
                try {
                    eventType = a.nextToken();
                } catch (Throwable e4) {
                    v.a("MicroMsg.YYBMarketVerify", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                } catch (Throwable e42) {
                    v.a("MicroMsg.YYBMarketVerify", e42, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            return 0;
        }

        private static XmlResourceParser a(Context context, AssetManager assetManager) {
            int i = 1;
            try {
                String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
                Method method = AssetManager.class.getMethod("getCookieName", new Class[]{Integer.TYPE});
                if (str == null && context.getPackageName().equals("android")) {
                    str = "/system/framework/framework-res.apk";
                }
                while (i < 20) {
                    if (str != null) {
                        if (str.equals(method.invoke(assetManager, new Object[]{Integer.valueOf(i)}))) {
                            return assetManager.openXmlResourceParser(i, "AndroidManifest.xml");
                        }
                    }
                    i++;
                }
            } catch (Exception e) {
            }
            return assetManager.openXmlResourceParser("AndroidManifest.xml");
        }

        private static String a(String str, Resources resources) {
            if (str != null && str.startsWith("@")) {
                try {
                    str = resources.getString(Integer.parseInt(str.substring(1)));
                } catch (NumberFormatException e) {
                } catch (NotFoundException e2) {
                }
            }
            return str;
        }
    }

    public static class b {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String m(java.io.File r13) {
            /*
            r1 = 0;
            r12 = 0;
            r3 = new java.util.jar.JarFile;	 Catch:{ Exception -> 0x0171, all -> 0x0161 }
            r3.<init>(r13);	 Catch:{ Exception -> 0x0171, all -> 0x0161 }
            r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r4 = new byte[r0];	 Catch:{ Exception -> 0x0175, all -> 0x0166 }
            r5 = r3.entries();	 Catch:{ Exception -> 0x0175, all -> 0x0166 }
            r2 = r1;
        L_0x0010:
            r0 = r5.hasMoreElements();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r0 == 0) goto L_0x017c;
        L_0x0016:
            r0 = r5.nextElement();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r0 = (java.util.jar.JarEntry) r0;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r6 = r0.isDirectory();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r6 != 0) goto L_0x0010;
        L_0x0022:
            r6 = r0.getName();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r7 = "META-INF/";
            r6 = r6.startsWith(r7);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r6 != 0) goto L_0x0010;
        L_0x002f:
            r6 = r0.getName();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r7 = "resources.arsc";
            r7 = r7.equals(r6);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r7 != 0) goto L_0x0010;
        L_0x003c:
            r7 = "AndroidManifest.xml";
            r7 = r7.equals(r6);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r7 != 0) goto L_0x0010;
        L_0x0045:
            r8 = r0.getSize();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r10 = 5120; // 0x1400 float:7.175E-42 double:2.5296E-320;
            r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r7 > 0) goto L_0x0010;
        L_0x004f:
            r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r7 = "voken";
            r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r11 = "name = ";
            r10.<init>(r11);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r6 = r10.append(r6);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r6 = r6.toString();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            com.tencent.mm.sdk.platformtools.v.d(r7, r6);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r2 = r3.getInputStream(r0);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r6 = "voken";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r10 = "get is cost ";
            r7.<init>(r10);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r8 = r10 - r8;
            r7 = r7.append(r8);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r7 = r7.toString();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            com.tencent.mm.sdk.platformtools.v.d(r6, r7);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r2 == 0) goto L_0x0098;
        L_0x008b:
            r6 = 0;
            r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r6 = r2.read(r4, r6, r7);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r7 = -1;
            if (r6 != r7) goto L_0x008b;
        L_0x0095:
            r2.close();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
        L_0x0098:
            r6 = r0.getCertificates();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r6 == 0) goto L_0x00a1;
        L_0x009e:
            r7 = r6.length;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r7 != 0) goto L_0x00d9;
        L_0x00a1:
            r1 = new java.lang.SecurityException;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r5 = "The apk file has unsigned res:";
            r4.<init>(r5);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r0 = r0.getName();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r0 = r4.append(r0);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r0 = r0.toString();	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r1.<init>(r0);	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            throw r1;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
        L_0x00bb:
            r0 = move-exception;
            r1 = r2;
            r2 = r3;
        L_0x00be:
            r3 = "MicroMsg.YYBMarketVerify";
            r4 = "";
            r5 = 0;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00cb }
            com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x00cb }
            throw r0;	 Catch:{ all -> 0x00cb }
        L_0x00cb:
            r0 = move-exception;
            r3 = r2;
            r2 = r1;
        L_0x00ce:
            if (r2 == 0) goto L_0x00d3;
        L_0x00d0:
            r2.close();	 Catch:{ IOException -> 0x0146 }
        L_0x00d3:
            if (r3 == 0) goto L_0x00d8;
        L_0x00d5:
            r3.close();	 Catch:{ IOException -> 0x0153 }
        L_0x00d8:
            throw r0;
        L_0x00d9:
            if (r1 != 0) goto L_0x0179;
        L_0x00db:
            r0 = 0;
            r0 = r6[r0];	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ Exception -> 0x00bb, all -> 0x016a }
            if (r0 != 0) goto L_0x00e5;
        L_0x00e2:
            r1 = r0;
            goto L_0x0010;
        L_0x00e5:
            r1 = r2;
        L_0x00e6:
            if (r0 == 0) goto L_0x0120;
        L_0x00e8:
            r2 = new java.lang.String;	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            r0 = r0.getEncoded();	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            r0 = I(r0);	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            r2.<init>(r0);	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            r0 = r2.getBytes();	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            r0 = com.tencent.mm.sdk.platformtools.z.bi(r0);	 Catch:{ Exception -> 0x0175, all -> 0x016d }
            if (r1 == 0) goto L_0x0102;
        L_0x00ff:
            r1.close();	 Catch:{ IOException -> 0x0106 }
        L_0x0102:
            r3.close();	 Catch:{ IOException -> 0x0113 }
        L_0x0105:
            return r0;
        L_0x0106:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r4 = "";
            r5 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r5);
            goto L_0x0102;
        L_0x0113:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r3 = "";
            r4 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
            goto L_0x0105;
        L_0x0120:
            r0 = "";
            if (r1 == 0) goto L_0x0128;
        L_0x0125:
            r1.close();	 Catch:{ IOException -> 0x0139 }
        L_0x0128:
            r3.close();	 Catch:{ IOException -> 0x012c }
            goto L_0x0105;
        L_0x012c:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r3 = "";
            r4 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
            goto L_0x0105;
        L_0x0139:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r4 = "";
            r5 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r5);
            goto L_0x0128;
        L_0x0146:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r4 = "";
            r5 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r5);
            goto L_0x00d3;
        L_0x0153:
            r1 = move-exception;
            r2 = "MicroMsg.YYBMarketVerify";
            r3 = "";
            r4 = new java.lang.Object[r12];
            com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
            goto L_0x00d8;
        L_0x0161:
            r0 = move-exception;
            r2 = r1;
            r3 = r1;
            goto L_0x00ce;
        L_0x0166:
            r0 = move-exception;
            r2 = r1;
            goto L_0x00ce;
        L_0x016a:
            r0 = move-exception;
            goto L_0x00ce;
        L_0x016d:
            r0 = move-exception;
            r2 = r1;
            goto L_0x00ce;
        L_0x0171:
            r0 = move-exception;
            r2 = r1;
            goto L_0x00be;
        L_0x0175:
            r0 = move-exception;
            r2 = r3;
            goto L_0x00be;
        L_0x0179:
            r0 = r1;
            goto L_0x00e2;
        L_0x017c:
            r0 = r1;
            r1 = r2;
            goto L_0x00e6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.u.b.m(java.io.File):java.lang.String");
        }

        private static char[] I(byte[] bArr) {
            int length = bArr.length;
            char[] cArr = new char[(length * 2)];
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                int i2 = (b >> 4) & 15;
                cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
                i2 = b & 15;
                int i3 = (i * 2) + 1;
                if (i2 >= 10) {
                    i2 = (i2 + 97) - 10;
                } else {
                    i2 += 48;
                }
                cArr[i3] = (char) i2;
            }
            return cArr;
        }
    }

    public static class c {
        public final String aRm;
        public final int drn;
        public final String dro;

        public c(String str, int i, String str2) {
            this.aRm = str;
            this.drn = i;
            this.dro = str2;
        }
    }

    public static boolean a(Context context, ArrayList<c> arrayList, boolean z) {
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!TextUtils.isEmpty(cVar.aRm)) {
                String str;
                String replace;
                String str2 = cVar.aRm;
                List<String> arrayList2 = new ArrayList();
                String packageResourcePath = context.getPackageResourcePath();
                int i;
                if (VERSION.SDK_INT >= 21) {
                    String[] split = packageResourcePath.split("/");
                    str = SQLiteDatabase.KeyEmpty;
                    if (split != null) {
                        CharSequence charSequence;
                        for (i = 0; i < split.length; i++) {
                            if (split[i].contains(context.getPackageName())) {
                                charSequence = split[i];
                                break;
                            }
                        }
                        Object obj = str;
                        if (!TextUtils.isEmpty(charSequence)) {
                            str = packageResourcePath.replace(charSequence, str2 + "-1");
                            if (new File(str).exists()) {
                                arrayList2.add(str);
                            }
                            replace = packageResourcePath.replace(charSequence, str2 + "-2");
                            if (new File(replace).exists()) {
                                arrayList2.add(replace);
                            }
                        }
                    }
                } else {
                    String[] split2 = packageResourcePath.split("/");
                    if (split2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < split2.length; i++) {
                            if (i != split2.length - 1) {
                                stringBuilder.append(split2[i]);
                                stringBuilder.append("/");
                            }
                        }
                        replace = stringBuilder.toString();
                        str = replace + str2 + "-1.apk";
                        if (new File(str).exists()) {
                            arrayList2.add(str);
                        }
                        replace = replace + str2 + "-2.apk";
                        if (new File(replace).exists()) {
                            arrayList2.add(replace);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (String replace2 : arrayList2) {
                        File file = new File(replace2);
                        if (file.exists()) {
                            try {
                                Object obj2;
                                replace2 = SQLiteDatabase.KeyEmpty;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (z) {
                                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(cVar.aRm, 64);
                                    if (packageInfo.signatures.length > 0) {
                                        replace2 = z.Kg(packageInfo.signatures[packageInfo.signatures.length - 1].toCharsString());
                                    }
                                    obj2 = replace2;
                                } else {
                                    str = b.m(file.getAbsoluteFile());
                                }
                                String str3 = "MicroMsg.YYBMarketVerify";
                                String str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms";
                                Object[] objArr = new Object[6];
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = cVar.aRm;
                                objArr[2] = cVar.dro;
                                objArr[3] = obj2;
                                boolean z2 = !TextUtils.isEmpty(obj2) && obj2.equalsIgnoreCase(cVar.dro);
                                objArr[4] = Boolean.valueOf(z2);
                                objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                v.i(str3, str4, objArr);
                                if (!TextUtils.isEmpty(obj2) && obj2.equalsIgnoreCase(cVar.dro)) {
                                    int i2;
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (z) {
                                        i2 = context.getPackageManager().getPackageInfo(cVar.aRm, 0).versionCode;
                                    } else {
                                        i2 = a.F(context, cVar.aRm);
                                    }
                                    str3 = "MicroMsg.YYBMarketVerify";
                                    str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms";
                                    objArr = new Object[6];
                                    objArr[0] = Boolean.valueOf(z);
                                    objArr[1] = cVar.aRm;
                                    objArr[2] = Integer.valueOf(cVar.drn);
                                    objArr[3] = Integer.valueOf(i2);
                                    objArr[4] = Boolean.valueOf(i2 <= cVar.drn);
                                    objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    v.i(str3, str4, objArr);
                                    if (i2 <= cVar.drn) {
                                        return true;
                                    }
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.YYBMarketVerify", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
