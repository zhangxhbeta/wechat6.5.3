package com.tencent.mm.t.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final String cxq;
    private final Map<e, String> cxl;
    private final Map<String, e> cxm;
    private final Map<Integer, String> cxn;
    private final f cxo;
    private final d cxp;

    public interface c {
        String AP();

        Bitmap g(Bitmap bitmap);
    }

    public interface d {
        OutputStream gt(String str);

        boolean hc(String str);

        InputStream openRead(String str);
    }

    public interface e {
        void AO();

        String AP();

        void AQ();

        void h(Bitmap bitmap);
    }

    public interface f {
        void b(String str, Bitmap bitmap);

        void d(Bitmap bitmap);

        Bitmap gu(String str);
    }

    private static final class h {
        final f cxA;
        private final String cxB;
        private final d cxp;
        final b cxx;
        private final String cxy;
        final c cxz;
        private final k dEa;

        class AnonymousClass2 implements Runnable {
            final /* synthetic */ h cxC;
            final /* synthetic */ Bitmap cxE;

            AnonymousClass2(h hVar, Bitmap bitmap) {
                this.cxC = hVar;
                this.cxE = bitmap;
            }

            public final void run() {
                h hVar = this.cxC;
                Bitmap bitmap = this.cxE;
                e eVar;
                if (bitmap == null || bitmap.isRecycled()) {
                    v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed");
                    eVar = (e) hVar.cxx.cxm.remove(hVar.AT());
                    if (eVar != null) {
                        eVar.AQ();
                        hVar.cxx.cxl.remove(eVar);
                        return;
                    }
                    return;
                }
                v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded");
                eVar = (e) hVar.cxx.cxm.remove(hVar.AT());
                if (eVar != null) {
                    eVar.h(bitmap);
                    hVar.cxx.cxl.remove(eVar);
                }
            }
        }

        private h(String str, c cVar, b bVar, f fVar, d dVar, k kVar, String str2) {
            this.cxy = str;
            this.cxz = cVar;
            this.cxx = bVar;
            this.cxA = fVar;
            this.cxp = dVar;
            this.dEa = kVar;
            this.cxB = str2;
        }

        final String AT() {
            return b.ap(this.cxB, AU());
        }

        final String AU() {
            return this.cxy + (this.cxz == null ? SQLiteDatabase.KeyEmpty : ":transformation:" + this.cxz.AP());
        }

        final Bitmap AV() {
            if (com.tencent.mm.compatible.util.f.sj()) {
                InputStream fileInputStream;
                if (this.cxy.startsWith("file://")) {
                    try {
                        fileInputStream = new FileInputStream(this.cxy.replaceFirst("file://", SQLiteDatabase.KeyEmpty));
                    } catch (Throwable e) {
                        v.a("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file ", new Object[0]);
                        return null;
                    }
                }
                fileInputStream = this.cxp.openRead(b.nv(this.cxy));
                if (fileInputStream == null) {
                    v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadBitmapFromIO, null from disk");
                    AW();
                    fileInputStream = this.cxp.openRead(b.nv(this.cxy));
                    if (fileInputStream == null) {
                        v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadBitmapFromIO, null from network");
                    }
                }
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    Bitmap t = t(fileInputStream);
                    if (t == null || t.isRecycled()) {
                        v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadBitmapFromIO, decode failed");
                        return null;
                    }
                    v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "bmp size %f, url %s", Float.valueOf((float) (android.support.v4.b.b.K(t) / 1024)), this.cxy);
                    return t;
                } catch (Throwable e2) {
                    v.a("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return null;
                }
            }
            v.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadBitmapFromIO, sdcard unavailable");
            return null;
        }

        private Bitmap t(InputStream inputStream) {
            try {
                Bitmap s;
                if (this.dEa != null) {
                    s = this.dEa.s(inputStream);
                } else {
                    s = com.tencent.mm.compatible.f.a.decodeStream(inputStream);
                    be.f((Closeable) inputStream);
                }
                return s;
            } finally {
                be.f((Closeable) inputStream);
            }
        }

        private void AW() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.cxy).openConnection();
                Closeable gt = this.cxp.gt(b.nv(this.cxy));
                if (gt != null) {
                    Closeable bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read != -1) {
                            gt.write(bArr, 0, read);
                        } else {
                            gt.flush();
                            be.f(gt);
                            be.f(bufferedInputStream);
                            return;
                        }
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image ", new Object[0]);
                this.cxp.hc(b.nv(this.cxy));
            }
        }
    }

    private static final class i {
        static final b cxF = new b();
    }

    public interface k {
        Bitmap s(InputStream inputStream);
    }

    private static final class a implements d {
        private a() {
        }

        public final OutputStream gt(String str) {
            try {
                return FileOp.jN(b.cxq + str);
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s", str);
                return null;
            }
        }

        public final InputStream openRead(String str) {
            try {
                return FileOp.openRead(b.cxq + str);
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openRead fileName %s", str);
                return null;
            }
        }

        public final boolean hc(String str) {
            return !be.kS(str) && FileOp.deleteFile(b.cxq + str);
        }
    }

    private static final class b implements f {
        private final com.tencent.mm.a.f<String, Reference<Bitmap>> cxt;

        class AnonymousClass1 extends com.tencent.mm.a.f<String, Reference<Bitmap>> {
            private final Map<Reference<Bitmap>, Integer> cxu = new HashMap();
            final /* synthetic */ b cxv;

            AnonymousClass1(b bVar, int i) {
                this.cxv = bVar;
                super(31457280);
            }

            protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                Reference reference = (Reference) obj2;
                super.entryRemoved(z, (String) obj, reference, (Reference) obj3);
                if (!(reference == null || reference.get() == null || ((Bitmap) reference.get()).isRecycled())) {
                    ((Bitmap) reference.get()).recycle();
                }
                this.cxu.remove(reference);
            }

            protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                Reference reference = (Reference) obj2;
                if (reference == null) {
                    return 0;
                }
                Integer num = (Integer) this.cxu.get(reference);
                if (num != null && num.intValue() >= 0) {
                    return num.intValue();
                }
                int K = (reference.get() == null || ((Bitmap) reference.get()).isRecycled()) ? 0 : android.support.v4.b.b.K((Bitmap) reference.get());
                this.cxu.put(reference, Integer.valueOf(K));
                return K;
            }

            public final void clear() {
                super.clear();
                this.cxu.clear();
            }

            public final void a(com.tencent.mm.a.f.a<String, Reference<Bitmap>> aVar) {
                super.a(aVar);
                this.cxu.clear();
            }
        }

        private b() {
            this.cxt = new AnonymousClass1(this, 31457280);
        }

        public final Bitmap gu(String str) {
            if (be.kS(str)) {
                return null;
            }
            Reference reference = (Reference) this.cxt.get(str);
            if (reference == null || reference.get() == null || ((Bitmap) reference.get()).isRecycled()) {
                return null;
            }
            return (Bitmap) reference.get();
        }

        public final void b(String str, Bitmap bitmap) {
            if (!be.kS(str) && bitmap != null) {
                this.cxt.put(str, new WeakReference(bitmap));
            }
        }

        public final void d(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private static class g implements e {
        final String apU;
        private final WeakReference<ImageView> cxw;
        private final b cxx;
        boolean dAm;

        final ImageView AR() {
            return (ImageView) this.cxw.get();
        }

        private g(ImageView imageView, b bVar) {
            this.dAm = false;
            this.cxw = new WeakReference(imageView);
            this.cxx = bVar;
            this.apU = "ImageView#" + imageView.hashCode();
        }

        private void AS() {
            if (this.cxw.get() != null) {
                this.cxx.cxn.remove(Integer.valueOf(((ImageView) this.cxw.get()).hashCode()));
            }
        }

        public void AO() {
        }

        public final void h(Bitmap bitmap) {
            AS();
            ImageView imageView = (ImageView) this.cxw.get();
            if (imageView != null) {
                imageView.setImageDrawable(new d(imageView.getResources(), bitmap));
            }
            this.dAm = true;
        }

        public final void AQ() {
            AS();
        }

        public final String AP() {
            return this.apU;
        }
    }

    public class j implements e {
        final /* synthetic */ b cxs;

        public j(b bVar) {
            this.cxs = bVar;
        }

        public final void AO() {
        }

        public final void h(Bitmap bitmap) {
        }

        public final void AQ() {
        }

        public final String AP() {
            return "DefaultLoadTarget";
        }
    }

    public static b AL() {
        return i.cxF;
    }

    private b() {
        this.cxl = new ConcurrentHashMap();
        this.cxm = new ConcurrentHashMap();
        this.cxn = new ConcurrentHashMap();
        this.cxo = new b();
        this.cxp = new a();
    }

    public final Bitmap gs(String str) {
        Bitmap bitmap = null;
        if (be.kS(str)) {
            return bitmap;
        }
        Bitmap gu = this.cxo.gu(str);
        if (gu != null) {
            return gu;
        }
        try {
            return com.tencent.mm.compatible.f.a.decodeStream(this.cxp.openRead(nv(str)));
        } catch (Throwable e) {
            v.a("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            return bitmap;
        }
    }

    public final String mF(String str) {
        return a(new j(this), str, null, null);
    }

    private String a(e eVar, String str, c cVar, k kVar) {
        h hVar = new h(str, cVar, this, this.cxo, this.cxp, kVar, eVar.AP());
        String AU = hVar.AU();
        Bitmap gu = this.cxo.gu(AU);
        if (gu == null || gu.isRecycled()) {
            gu = null;
        }
        if (gu != null) {
            eVar.h(gu);
            return AU;
        }
        String AT = hVar.AT();
        this.cxl.put(eVar, AT);
        this.cxm.put(AT, eVar);
        eVar.AO();
        com.tencent.mm.sdk.i.e.a(new Runnable(hVar) {
            final /* synthetic */ h cxC;

            {
                this.cxC = r1;
            }

            public final void run() {
                boolean z;
                Bitmap bitmap;
                boolean z2 = true;
                Bitmap AV = this.cxC.AV();
                h hVar = this.cxC;
                String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
                String str2 = "postLoadInWorkerThread bitmap ok %b";
                Object[] objArr = new Object[1];
                if (AV == null || AV.isRecycled()) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                v.d(str, str2, objArr);
                if (hVar.cxz == null || AV == null || AV.isRecycled()) {
                    bitmap = AV;
                } else {
                    bitmap = hVar.cxz.g(AV);
                    if (bitmap != AV) {
                        hVar.cxA.d(AV);
                    }
                }
                String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
                str = "postLoadInWorkerThread theLoaded bitmap ok %b";
                Object[] objArr2 = new Object[1];
                if (bitmap == null || bitmap.isRecycled()) {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                v.d(str3, str, objArr2);
                hVar.cxA.b(hVar.AU(), bitmap);
                ad.o(new AnonymousClass2(hVar, bitmap));
            }
        }, "AppBrandSimpleImageLoader-DownloadThread");
        return AU;
    }

    public final String a(ImageView imageView, String str, Drawable drawable, c cVar) {
        return a(imageView, str, drawable, cVar, null);
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, c cVar, k kVar) {
        if (imageView == null) {
            return null;
        }
        String str2;
        if (imageView != null) {
            str2 = (String) this.cxn.get(Integer.valueOf(imageView.hashCode()));
            if (str2 != null) {
                e eVar = (e) this.cxm.get(str2);
                if (eVar != null) {
                    str2 = (String) this.cxl.get(eVar);
                    if (!be.kS(str2)) {
                        this.cxm.remove(str2);
                    }
                }
            }
        }
        if (be.kS(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        e anonymousClass1 = new g(this, imageView, this) {
            final /* synthetic */ b cxs;

            public final void AO() {
                if (AR() != null && drawable != null) {
                    AR().setImageDrawable(drawable);
                }
            }
        };
        str2 = a(anonymousClass1, str, cVar, kVar);
        if (anonymousClass1.dAm) {
            return str2;
        }
        this.cxn.put(Integer.valueOf(imageView.hashCode()), ap(anonymousClass1.apU, str2));
        return str2;
    }

    private static String ap(String str, String str2) {
        return str + str2;
    }

    static {
        String str = com.tencent.mm.compatible.util.e.cnj;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        cxq = str;
        com.tencent.mm.sdk.platformtools.h.JX(str);
    }

    private static String nv(String str) {
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.a.g.m(str.getBytes());
    }
}
