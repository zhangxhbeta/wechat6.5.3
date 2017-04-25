package com.tencent.mm.modelbiz;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j {

    public static final class a {
        List<a> cCZ = new ArrayList();
        Map<String, Integer> cDa = new HashMap();
        Map<String, WeakReference<Bitmap>> cDb = new HashMap();
        ap cDc = null;

        public interface a {
            void hO(String str);
        }

        public final void a(a aVar) {
            this.cCZ.add(aVar);
        }

        public final void b(a aVar) {
            this.cCZ.remove(aVar);
        }

        public final void Ds() {
            this.cCZ.clear();
        }

        public static String hN(String str) {
            if (!ak.uz()) {
                return SQLiteDatabase.KeyEmpty;
            }
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            return stringBuilder.append(c.xe()).append("/brand_").append(g.m(str.getBytes())).toString();
        }

        final void e(String str, Bitmap bitmap) {
            Bitmap bitmap2 = this.cDb.containsKey(str) ? (Bitmap) ((WeakReference) this.cDb.get(str)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, FileUtils.S_IWUSR, FileUtils.S_IWUSR, true);
                    bitmap2 = d.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
                } catch (OutOfMemoryError e) {
                    bitmap2 = bitmap;
                }
                this.cDb.remove(str);
                this.cDb.put(str, new WeakReference(bitmap2));
            }
            if (bitmap2 != bitmap) {
                v.i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    }

    private static class b implements com.tencent.mm.sdk.platformtools.ap.a {
        private final String cDd;
        public byte[] cxX = null;
        private final String url;

        public b(String str, String str2) {
            this.cDd = str;
            this.url = str2;
        }

        public final boolean AZ() {
            if (be.kS(this.cDd) || be.kS(this.url)) {
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream h = com.tencent.mm.network.b.h(this.url, 3000, 5000);
                if (h == null) {
                    return false;
                }
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = h.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                h.close();
                this.cxX = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (be.bl(this.cxX)) {
                    v.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.cDd);
                    return false;
                }
                if (ak.uz()) {
                    com.tencent.mm.model.ab.a.csa.aC(this.cxX.length, 0);
                    a DG = u.DG();
                    String str = this.cDd;
                    String str2 = this.url;
                    byte[] bArr2 = this.cxX;
                    try {
                        str2 = str + str2;
                        Bitmap bc = d.bc(bArr2);
                        d.a(bc, 100, CompressFormat.PNG, a.hN(str2), false);
                        DG.e(str, bc);
                        v.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        DG.cDa.remove(str);
                    } catch (Throwable e) {
                        v.e("MicroMsg.BrandLogic", "exception:%s", be.e(e));
                    }
                }
                return true;
            } catch (Throwable e2) {
                v.e("MicroMsg.BrandLogic", "exception:%s", be.e(e2));
                v.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.cxX = null;
                return false;
            }
        }

        public final boolean Ba() {
            a DG = u.DG();
            String str = this.cDd;
            int i = 0;
            while (i < DG.cCZ.size()) {
                try {
                    ((a) DG.cCZ.get(i)).hO(str);
                    i++;
                } catch (Throwable e) {
                    v.e("MicroMsg.BrandLogic", "exception:%s", be.e(e));
                }
            }
            return false;
        }
    }

    public static Bitmap hL(String str) {
        boolean z = false;
        if (!be.kS(str)) {
            ak.yW();
            if (c.isSDCardAvailable() && ak.uz()) {
                Bitmap bitmap;
                a DG = u.DG();
                String format = String.format("%s%f", new Object[]{str, Float.valueOf(1.5f)});
                if (DG.cDb.containsKey(format)) {
                    bitmap = (Bitmap) ((WeakReference) DG.cDb.get(format)).get();
                    if (bitmap == null || bitmap.isRecycled()) {
                        bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(str, 1.5f);
                        DG.cDb.remove(format);
                        DG.cDb.put(format, new WeakReference(bitmap));
                    }
                } else {
                    bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(str, 1.5f);
                    DG.cDb.put(format, new WeakReference(bitmap));
                }
                String str2 = "MicroMsg.BrandLogic";
                format = "get verify user icon = %s, is null ? %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                if (bitmap == null) {
                    z = true;
                }
                objArr[1] = String.valueOf(z);
                v.i(str2, format, objArr);
                return bitmap;
            }
        }
        return null;
    }

    public static Bitmap b(final String str, String str2, int i) {
        ak.yW();
        if (!c.isSDCardAvailable()) {
            return fj(i);
        }
        if (str == null || !ak.uz()) {
            return null;
        }
        Bitmap bitmap;
        if (str2 == null) {
            str2 = S(str, null);
            if (str2 == null) {
                return null;
            }
        }
        a DG = u.DG();
        WeakReference weakReference;
        if (DG.cDb.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) DG.cDb.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.JV(a.hN(str + S(str, str2)));
                if (bitmap == null) {
                    v.i("MicroMsg.BrandLogic", "not found brand icon local");
                } else {
                    DG.e(str, bitmap);
                }
            }
            weakReference = (WeakReference) DG.cDb.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ad.o(new Runnable() {
                    public final void run() {
                        a DG = u.DG();
                        String str = str;
                        String str2 = str2;
                        if (be.kS(str) || be.kS(str2)) {
                            v.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
                        } else if (be.ax((long) be.f((Integer) DG.cDa.get(str))) < 300) {
                            v.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str);
                        } else {
                            DG.cDa.put(str, Integer.valueOf((int) be.Nh()));
                            if (DG.cDc == null || DG.cDc.btK()) {
                                DG.cDc = new ap(1, "brand-logic");
                            }
                            DG.cDc.c(new b(str, j.S(str, str2)));
                        }
                    }
                });
                return null;
            }
        }
        bitmap = d.JV(a.hN(str + S(str, str2)));
        if (bitmap == null) {
            v.i("MicroMsg.BrandLogic", "not found brand icon local");
        } else {
            DG.e(str, bitmap);
            weakReference = (WeakReference) DG.cDb.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ad.o(/* anonymous class already generated */);
                return null;
            }
        }
        bitmap = null;
        if (bitmap == null) {
            return bitmap;
        }
        ad.o(/* anonymous class already generated */);
        return null;
    }

    public static Bitmap hM(String str) {
        ak.yW();
        if (!c.isSDCardAvailable()) {
            return fj(0);
        }
        if (str == null || !ak.uz()) {
            return null;
        }
        Bitmap bitmap;
        a DG = u.DG();
        if (DG.cDb.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) DG.cDb.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    private static Bitmap fj(int i) {
        if (i <= 0) {
            return null;
        }
        Options options = new Options();
        d.a(options);
        Bitmap decodeStream = BitmapFactory.decodeStream(aa.getContext().getResources().openRawResource(i), null, options);
        if (decodeStream != null) {
            return d.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
        }
        return decodeStream;
    }

    static String S(String str, String str2) {
        if (str == null || !ak.uz()) {
            return null;
        }
        BizInfo ho = u.Dy().ho(str);
        if (ho.field_brandIconURL != null) {
            return ho.field_brandIconURL;
        }
        return str2;
    }
}
