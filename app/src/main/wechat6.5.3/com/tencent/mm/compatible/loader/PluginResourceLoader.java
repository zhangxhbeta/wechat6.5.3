package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources cfE;
    private Method cfF;
    private Method cfG;
    private HashMap<String, ZipFile> cfH;
    private final b<WeakReference<ConstantState>> cfI;

    private XmlResourceParser b(String str, int i, int i2, String str2) {
        try {
            return (XmlResourceParser) this.cfG.invoke(this.cfE, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        } catch (Throwable e) {
            v.a("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            return null;
        }
    }

    Drawable loadDrawable(TypedValue typedValue, int i) {
        return a(typedValue, i);
    }

    Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        return a(typedValue, i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource != null) {
            return openRawResource;
        }
        for (Entry value : this.cfH.entrySet()) {
            inputStream = b((ZipFile) value.getValue(), typedValue);
            if (inputStream != null) {
                return inputStream;
            }
        }
        return inputStream;
    }

    private Drawable a(TypedValue typedValue, int i) {
        try {
            return (Drawable) this.cfF.invoke(this.cfE, new Object[]{typedValue, Integer.valueOf(i)});
        } catch (Exception e) {
        } catch (StackOverflowError e2) {
            v.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
        }
        try {
            if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                Object b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                Drawable createFromXml = Drawable.createFromXml(this, b);
                b.close();
                return createFromXml;
            }
        } catch (Exception e3) {
        }
        for (Entry value : this.cfH.entrySet()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        v.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
        while (r1.hasNext()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        v.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(java.util.zip.ZipFile r12, android.util.TypedValue r13) {
        /*
        r11 = this;
        r7 = 1;
        r1 = 0;
        r0 = r13.string;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r0 = r13.assetCookie;
        r2 = (long) r0;
        r0 = 32;
        r2 = r2 << r0;
        r0 = r13.data;
        r4 = (long) r0;
        r4 = r4 | r2;
        r0 = r11.cfI;
        r2 = r0.vD;
        r3 = r0.hO;
        r2 = com.tencent.mm.compatible.loader.b.b(r2, r3, r4);
        if (r2 < 0) goto L_0x0025;
    L_0x001d:
        r3 = r0.vE;
        r3 = r3[r2];
        r6 = com.tencent.mm.compatible.loader.b.vB;
        if (r3 != r6) goto L_0x0043;
    L_0x0025:
        r0 = r1;
    L_0x0026:
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0064;
    L_0x002a:
        r0 = r0.get();
        r0 = (android.graphics.drawable.Drawable.ConstantState) r0;
        if (r0 == 0) goto L_0x0048;
    L_0x0032:
        r0 = r0.newDrawable(r11);
    L_0x0036:
        if (r0 == 0) goto L_0x0066;
    L_0x0038:
        r1 = "MicroMsg.PluginResourceLoader";
        r2 = "get form cache";
        com.tencent.mm.sdk.platformtools.v.v(r1, r2);
        r1 = r0;
        goto L_0x0006;
    L_0x0043:
        r0 = r0.vE;
        r0 = r0[r2];
        goto L_0x0026;
    L_0x0048:
        r0 = r11.cfI;
        r2 = r0.vD;
        r3 = r0.hO;
        r2 = com.tencent.mm.compatible.loader.b.b(r2, r3, r4);
        if (r2 < 0) goto L_0x0064;
    L_0x0054:
        r3 = r0.vE;
        r3 = r3[r2];
        r6 = com.tencent.mm.compatible.loader.b.vB;
        if (r3 == r6) goto L_0x0064;
    L_0x005c:
        r3 = r0.vE;
        r6 = com.tencent.mm.compatible.loader.b.vB;
        r3[r2] = r6;
        r0.vC = r7;
    L_0x0064:
        r0 = r1;
        goto L_0x0036;
    L_0x0066:
        r2 = r13.string;
        r2 = r2.toString();
        r3 = "MicroMsg.PluginResourceLoader";
        r6 = "try load drawable from zip, entry=%s, file=%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00c3 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ Exception -> 0x00c3 }
        r8 = 1;
        r9 = r12.getName();	 Catch:{ Exception -> 0x00c3 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x00c3 }
        com.tencent.mm.sdk.platformtools.v.v(r3, r6, r7);	 Catch:{ Exception -> 0x00c3 }
        r3 = r12.getEntry(r2);	 Catch:{ Exception -> 0x00c3 }
        r1 = r12.getInputStream(r3);	 Catch:{ Exception -> 0x00b0, all -> 0x00b9 }
        r0 = android.graphics.drawable.Drawable.createFromResourceStream(r11, r13, r1, r2);	 Catch:{ Exception -> 0x00b0, all -> 0x00ca }
        if (r1 == 0) goto L_0x0093;
    L_0x0090:
        r1.close();	 Catch:{ Exception -> 0x00c6 }
    L_0x0093:
        if (r0 != 0) goto L_0x009d;
    L_0x0095:
        r1 = r12.getInputStream(r3);	 Catch:{ Exception -> 0x00c3 }
        r0 = android.graphics.drawable.Drawable.createFromStream(r1, r2);	 Catch:{ Exception -> 0x00c3 }
    L_0x009d:
        r1 = r0;
    L_0x009e:
        if (r1 == 0) goto L_0x0006;
    L_0x00a0:
        r0 = r11.cfI;
        r2 = new java.lang.ref.WeakReference;
        r3 = r1.getConstantState();
        r2.<init>(r3);
        r0.put(r4, r2);
        goto L_0x0006;
    L_0x00b0:
        r6 = move-exception;
        if (r1 == 0) goto L_0x0093;
    L_0x00b3:
        r1.close();	 Catch:{ Exception -> 0x00b7 }
        goto L_0x0093;
    L_0x00b7:
        r1 = move-exception;
        goto L_0x0093;
    L_0x00b9:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x00bd:
        if (r2 == 0) goto L_0x00c2;
    L_0x00bf:
        r2.close();	 Catch:{ Exception -> 0x00c8 }
    L_0x00c2:
        throw r1;	 Catch:{ Exception -> 0x00c3 }
    L_0x00c3:
        r1 = move-exception;
        r1 = r0;
        goto L_0x009e;
    L_0x00c6:
        r1 = move-exception;
        goto L_0x0093;
    L_0x00c8:
        r2 = move-exception;
        goto L_0x00c2;
    L_0x00ca:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
        goto L_0x00bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.loader.PluginResourceLoader.a(java.util.zip.ZipFile, android.util.TypedValue):android.graphics.drawable.Drawable");
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        if (typedValue.string != null) {
            try {
                v.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[]{typedValue.string.toString(), zipFile.getName()});
                inputStream = zipFile.getInputStream(zipFile.getEntry(r1));
            } catch (Exception e) {
            }
        }
        return inputStream;
    }
}
