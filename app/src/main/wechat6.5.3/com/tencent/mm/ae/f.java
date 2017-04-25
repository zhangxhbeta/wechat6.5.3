package com.tencent.mm.ae;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class f extends g {
    public static int cMa = 0;
    public static long cMn = 0;
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    public com.tencent.mm.a.f<String, Bitmap> cMb = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b<String, Bitmap>(this) {
        final /* synthetic */ f cMo;

        {
            this.cMo = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            String str = (String) obj;
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled()) {
                v.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s bitmap:%s", str, bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    com.tencent.mm.a.f<String, String> cMc = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b<String, String>(this) {
        final /* synthetic */ f cMo;

        {
            this.cMo = r1;
        }

        public final /* bridge */ /* synthetic */ void l(Object obj, Object obj2) {
        }
    });
    private List<b> cMd = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> cMe = new HashMap();
    private Map<Integer, WeakReference<ImageView>> cMf = new HashMap();
    private Map<Integer, WeakReference<View>> cMg = new HashMap();
    private Set<Integer> cMh = new HashSet();
    private Map<String, String> cMi = new HashMap();
    private long cMj = 1;
    private LayoutParams cMk = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> cMl;
    public int cMm = 150;
    private ac cnC = new ac(Looper.getMainLooper());
    public com.tencent.mm.bg.g cuX = null;

    public static class a extends BitmapDrawable {
        public static void a(Bitmap bitmap, ImageView imageView) {
            if (imageView != null && imageView.getResources() != null) {
                Drawable aVar = new a(imageView.getResources(), bitmap);
                if (imageView.getLayerType() == 1) {
                    imageView.destroyDrawingCache();
                    imageView.setLayerType(0, null);
                }
                imageView.setImageDrawable(aVar);
            }
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            if (getBitmap() != null && !getBitmap().isRecycled()) {
                super.draw(canvas);
            } else if (getBitmap() != null) {
                v.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", getBitmap().toString());
            }
        }
    }

    static class b {
        int cMu;
        int cMv;
        int cMw;
        String url;

        b(int i, String str, int i2, int i3) {
            this.cMu = i;
            this.url = str;
            this.cMv = i2;
            this.cMw = i3;
        }
    }

    static /* synthetic */ void a(f fVar, String str) {
        v.d("MicroMsg.ImgInfoStorage", "checkrefresh load done, uri: %s", str);
        fVar.cMh.remove(Integer.valueOf(str.hashCode()));
        for (b bVar : fVar.cMd) {
            if (str.equals(bVar.url)) {
                Bitmap bitmap = (Bitmap) fVar.cMb.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    ImageView imageView = (ImageView) ((WeakReference) fVar.cMe.get(Integer.valueOf(bVar.cMu))).get();
                    if (imageView != null) {
                        v.i("MicroMsg.ImgInfoStorage", "[checkrefresh] bitmap width %d,height %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                        a.a(bitmap, imageView);
                        imageView.setLayoutParams(fVar.cMk);
                        int i = bitmap.getWidth() >= bitmap.getHeight() * 2 ? 1 : 0;
                        int i2 = bitmap.getHeight() >= bitmap.getWidth() * 2 ? 1 : 0;
                        if (!(i == 0 && i2 == 0)) {
                            v.d("MicroMsg.ImgInfoStorage", "bm: w:%d, h:%d ", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                            imageView.setScaleType(ScaleType.CENTER);
                        }
                        if (fVar.cMf.get(Integer.valueOf(bVar.cMv)) != null) {
                            imageView = (ImageView) ((WeakReference) fVar.cMf.get(Integer.valueOf(bVar.cMv))).get();
                            if (imageView != null) {
                                imageView.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                            }
                        }
                        if (fVar.cMg.get(Integer.valueOf(bVar.cMw)) != null) {
                            View view = (View) ((WeakReference) fVar.cMg.get(Integer.valueOf(bVar.cMw))).get();
                            if (view != null) {
                                view.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                            }
                        }
                    }
                }
            }
        }
    }

    public f(com.tencent.mm.bg.g gVar) {
        a(gVar);
        this.cuX = gVar;
        Gr();
    }

    public final void Gr() {
        Cursor rawQuery = this.cuX.rawQuery("SELECT max(id) FROM ImgInfo2", null);
        if (rawQuery.moveToFirst()) {
            this.cMj = rawQuery.getLong(0) + 1;
        }
        rawQuery.close();
        v.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.cMj);
    }

    private static void a(com.tencent.mm.bg.g gVar) {
        Object obj = null;
        Cursor rawQuery = gVar.rawQuery("PRAGMA table_info(ImgInfo2)", null);
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    obj6 = 1;
                }
                if ("iscomplete".equals(string)) {
                    obj5 = 1;
                }
                if ("origImgMD5".equals(string)) {
                    obj4 = 1;
                }
                if ("compressType".equals(string)) {
                    obj3 = 1;
                }
                if ("midImgPath".equals(string)) {
                    obj2 = 1;
                }
                if ("forwardType".equals(string)) {
                    obj = 1;
                }
            }
        }
        rawQuery.close();
        ak.yW();
        long er = c.wE().er(Thread.currentThread().getId());
        if (obj6 == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj5 == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj4 == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj3 == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj2 == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj == null) {
            gVar.dF("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (er > 0) {
            ak.yW();
            c.wE().es(er);
        }
    }

    public final String a(String str, String str2, String str3, boolean z) {
        if (be.kS(str)) {
            return null;
        }
        String str4;
        String str5;
        String str6 = SQLiteDatabase.KeyEmpty;
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = ah(Long.valueOf(str.substring(11)).longValue()).cLv;
            } catch (NumberFormatException e) {
                v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        str4 = str6;
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        ak.yW();
        str6 = c.wP();
        ak.yW();
        String wQ = c.wQ();
        if (be.kS(str4)) {
            str4 = str;
        }
        return h.a(str6, wQ, str5, str4, str3, 1, z);
    }

    public final String l(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public final String iU(String str) {
        if (be.kS(str)) {
            return null;
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = ah(Long.valueOf(str.substring(11)).longValue()).cLv;
            } catch (NumberFormatException e) {
                v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        ak.yW();
        String wP = c.wP();
        ak.yW();
        String wQ = c.wQ();
        String str3 = "th_";
        if (!be.kS(str2)) {
            str = str2;
        }
        return h.e(wP, wQ, str3, str, SQLiteDatabase.KeyEmpty);
    }

    public static String iV(String str) {
        return "THUMBNAIL_DIRPATH://th_" + str;
    }

    public final String iW(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = fC(Integer.valueOf(trim.substring(12)).intValue()).cLx;
            } catch (NumberFormatException e) {
                v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        return l(trim, str2, SQLiteDatabase.KeyEmpty);
    }

    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(8, bArr, z, compressFormat);
    }

    public final String a(byte[] bArr, CompressFormat compressFormat) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String m = com.tencent.mm.a.g.m((be.Ni()).getBytes());
        v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", l(m, "th_", SQLiteDatabase.KeyEmpty));
        try {
            d.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, l(m, "th_", SQLiteDatabase.KeyEmpty), true);
            return "THUMBNAIL_DIRPATH://th_" + m;
        } catch (IOException e) {
            v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            return a(9, bArr, true, compressFormat);
        } catch (Exception e2) {
            v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            return a(9, bArr, true, compressFormat);
        }
    }

    public final String a(byte[] bArr, CompressFormat compressFormat, int i, int i2) {
        OutputStream gt;
        IOException e;
        OutputStream outputStream;
        String a;
        Throwable th;
        Exception e2;
        if (be.bl(bArr)) {
            v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String m = com.tencent.mm.a.g.m((be.Ni()).getBytes());
        String l = l(m, "th_", SQLiteDatabase.KeyEmpty);
        String str = l + ".tmp";
        v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + l);
        try {
            gt = FileOp.gt(str);
            try {
                gt.write(bArr);
                gt.flush();
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a2 = d.a(str, i2, i, false, decodeResultLogger, 0);
                if (a2 != null) {
                    d.a(a2, 100, compressFormat, l, true);
                    v.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", str, l);
                } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                    v.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", str, l);
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 6, decodeResultLogger));
                }
                if (FileOp.aR(str)) {
                    v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (gt != null) {
                    try {
                        gt.close();
                    } catch (Exception e3) {
                    }
                }
                return "THUMBNAIL_DIRPATH://th_" + m;
            } catch (IOException e4) {
                e = e4;
                outputStream = gt;
                try {
                    v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
                    a = a(6, bArr, true, compressFormat);
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    gt = outputStream;
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (gt != null) {
                        try {
                            gt.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e2 = e7;
                try {
                    v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
                    a = a(6, bArr, true, compressFormat);
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (gt != null) {
                        try {
                            gt.close();
                        } catch (Exception e8) {
                        }
                    }
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (gt != null) {
                        gt.close();
                    }
                    throw th;
                }
            }
        } catch (IOException e9) {
            IOException iOException = e9;
            outputStream = null;
            e = iOException;
            v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            a = a(6, bArr, true, compressFormat);
            if (FileOp.aR(str)) {
                v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return a;
        } catch (Exception e10) {
            gt = null;
            e2 = e10;
            v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            a = a(6, bArr, true, compressFormat);
            if (FileOp.aR(str)) {
                v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (gt != null) {
                gt.close();
            }
            return a;
        } catch (Throwable th4) {
            gt = null;
            th = th4;
            if (FileOp.aR(str)) {
                v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (gt != null) {
                gt.close();
            }
            throw th;
        }
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat) {
        OutputStream gt;
        Exception exception;
        OutputStream outputStream;
        Throwable th;
        if (be.bl(bArr)) {
            v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String m = com.tencent.mm.a.g.m((be.Ni()).getBytes());
        String l = l(m, "th_", SQLiteDatabase.KeyEmpty);
        String str = l + ".tmp";
        v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + l);
        try {
            gt = FileOp.gt(str);
            try {
                gt.write(bArr);
                gt.flush();
                int i2 = z ? FileUtils.S_IWUSR : 120;
                int i3 = z ? FileUtils.S_IWUSR : 120;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a = d.a(str, i2, i3, false, decodeResultLogger, 0);
                if (a != null) {
                    d.a(a, 90, compressFormat, l, true);
                    v.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", str, l);
                } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                    v.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", str, l);
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, i, decodeResultLogger));
                }
                if (FileOp.aR(str)) {
                    v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (gt != null) {
                    try {
                        gt.close();
                    } catch (Exception e) {
                    }
                }
                return "THUMBNAIL_DIRPATH://th_" + m;
            } catch (Exception e2) {
                exception = e2;
                outputStream = gt;
                try {
                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 189, 1, false);
                    v.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + m + ", ex = " + exception.getMessage());
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    gt = outputStream;
                    if (FileOp.aR(str)) {
                        v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (gt != null) {
                        try {
                            gt.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (FileOp.aR(str)) {
                    v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (gt != null) {
                    gt.close();
                }
                throw th;
            }
        } catch (Exception e22) {
            exception = e22;
            outputStream = null;
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 189, 1, false);
            v.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + m + ", ex = " + exception.getMessage());
            if (FileOp.aR(str)) {
                v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            gt = null;
            if (FileOp.aR(str)) {
                v.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (gt != null) {
                gt.close();
            }
            throw th;
        }
    }

    public final String f(int i, byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger)) {
            String m = com.tencent.mm.a.g.m((be.Ni()).getBytes());
            String l = l(m, "th_", SQLiteDatabase.KeyEmpty);
            v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + l);
            FileOp.deleteFile(l);
            FileOp.l(l, bArr);
            return "THUMBNAIL_DIRPATH://th_" + m;
        } else if (decodeResultLogger.getDecodeResult() < 2000) {
            return null;
        } else {
            v.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(bArr, i, decodeResultLogger));
            return null;
        }
    }

    public final String w(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = fC(Integer.valueOf(trim.substring(12)).intValue()).cLx;
            } catch (NumberFormatException e) {
                v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            return a(trim.substring(20).substring(3), "th_", SQLiteDatabase.KeyEmpty, z);
        }
        return a(trim, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, z);
    }

    public final Bitmap a(String str, float f, boolean z) {
        return a(str, false, f, z, false, false, -1);
    }

    public final boolean a(ImageView imageView, String str, float f, int i, int i2, int i3, ImageView imageView2, int i4) {
        return a(imageView, str, f, i, i2, true, i3, imageView2, i4, 0, true, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.widget.ImageView r13, java.lang.String r14, float r15, int r16, int r17, boolean r18, int r19, android.widget.ImageView r20, int r21, int r22, boolean r23, android.view.View r24) {
        /*
        r12 = this;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r14);
        if (r2 == 0) goto L_0x0017;
    L_0x0006:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "invalid uri is %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r14;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        r2 = 0;
    L_0x0016:
        return r2;
    L_0x0017:
        r3 = r12.cMi;
        monitor-enter(r3);
        r2 = r12.cMi;	 Catch:{ all -> 0x0041 }
        r2 = r2.containsKey(r14);	 Catch:{ all -> 0x0041 }
        r4 = 0;
        r6 = r12.x(r14, r4);	 Catch:{ all -> 0x0041 }
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r6);	 Catch:{ all -> 0x0041 }
        if (r4 == 0) goto L_0x0044;
    L_0x002b:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = "getFullThumbPathByCache uri is null, uri:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0041 }
        r6 = 0;
        r7 = com.tencent.mm.sdk.platformtools.be.ma(r14);	 Catch:{ all -> 0x0041 }
        r5[r6] = r7;	 Catch:{ all -> 0x0041 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r4, r5);	 Catch:{ all -> 0x0041 }
        r2 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0016;
    L_0x0041:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        throw r2;
    L_0x0044:
        if (r2 != 0) goto L_0x0096;
    L_0x0046:
        r2 = "hd";
        r2 = r6.endsWith(r2);	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x0096;
    L_0x004f:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r2 = com.tencent.mm.modelsfs.FileOp.aR(r2);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0096;
    L_0x0069:
        r2 = r12.cMi;	 Catch:{ all -> 0x0041 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0041 }
        r5 = "hd";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0041 }
        r4 = r4.toString();	 Catch:{ all -> 0x0041 }
        r2.put(r14, r4);	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r6 = r2.toString();	 Catch:{ all -> 0x0041 }
    L_0x0096:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        r10 = 0;
        r3 = 0;
        r2 = "hd";
        r2 = r6.endsWith(r2);
        if (r2 == 0) goto L_0x02ef;
    L_0x00a2:
        r2 = r12.cMb;
        r2 = r2.get(r6);
        r10 = r2;
        r10 = (android.graphics.Bitmap) r10;
        if (r10 != 0) goto L_0x0179;
    L_0x00ad:
        r8 = 1;
        r2 = r12;
        r3 = r13;
        r4 = r20;
        r5 = r24;
        r7 = r15;
        r9 = r19;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
        r2 = 1;
        r3 = 0;
        r4 = r6.length();
        r4 = r4 + -2;
        r6 = r6.substring(r3, r4);
        r5 = r2;
        r2 = r10;
    L_0x00c8:
        if (r2 != 0) goto L_0x02ec;
    L_0x00ca:
        r2 = r12.cMb;
        r2 = r2.get(r6);
        r2 = (android.graphics.Bitmap) r2;
        r4 = r2;
    L_0x00d3:
        if (r4 == 0) goto L_0x01d0;
    L_0x00d5:
        r2 = r4.isRecycled();
        if (r2 != 0) goto L_0x01d0;
    L_0x00db:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "[setbitmapFromUri] bitmap width %d,height %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r4.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r4.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r5);
        r2 = 0;
        r13.setBackgroundDrawable(r2);
        com.tencent.mm.ae.f.a.a(r4, r13);
        r2 = r13.getLayoutParams();
        r2 = r2.width;
        r3 = -2;
        if (r2 == r3) goto L_0x01a6;
    L_0x010d:
        r2 = r12.cMk;
    L_0x010f:
        if (r22 != 0) goto L_0x01ae;
    L_0x0111:
        r3 = 5;
        r2.gravity = r3;
    L_0x0114:
        r13.setLayoutParams(r2);
        r2 = r4.getWidth();
        r2 = (double) r2;
        r5 = r4.getHeight();
        r6 = (double) r5;
        r8 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r6 = r6 * r8;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x01b8;
    L_0x0128:
        r2 = 1;
    L_0x0129:
        r3 = r4.getHeight();
        r6 = (double) r3;
        r3 = r4.getWidth();
        r8 = (double) r3;
        r10 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r8 = r8 * r10;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x01bb;
    L_0x013a:
        r3 = 1;
    L_0x013b:
        if (r2 != 0) goto L_0x013f;
    L_0x013d:
        if (r3 == 0) goto L_0x0144;
    L_0x013f:
        r2 = android.widget.ImageView.ScaleType.CENTER;
        r13.setScaleType(r2);
    L_0x0144:
        if (r20 == 0) goto L_0x015d;
    L_0x0146:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r5 = r4.getHeight();
        r2.<init>(r3, r5);
        if (r22 != 0) goto L_0x01be;
    L_0x0155:
        r3 = 5;
        r2.gravity = r3;
    L_0x0158:
        r0 = r20;
        r0.setLayoutParams(r2);
    L_0x015d:
        if (r24 == 0) goto L_0x0176;
    L_0x015f:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r4 = r4.getHeight();
        r2.<init>(r3, r4);
        if (r22 != 0) goto L_0x01c7;
    L_0x016e:
        r3 = 5;
        r2.gravity = r3;
    L_0x0171:
        r0 = r24;
        r0.setLayoutParams(r2);
    L_0x0176:
        r2 = 1;
        goto L_0x0016;
    L_0x0179:
        r2 = r12.cMb;
        r4 = 0;
        r5 = r6.length();
        r5 = r5 + -2;
        r4 = r6.substring(r4, r5);
        r2 = r2.remove(r4);
        if (r2 == 0) goto L_0x01a2;
    L_0x018c:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "remove low quality thumb from cacheMap, path: ";
        r4.<init>(r5);
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r2, r4);
    L_0x01a2:
        r5 = r3;
        r2 = r10;
        goto L_0x00c8;
    L_0x01a6:
        r2 = r13.getLayoutParams();
        r2 = (android.widget.FrameLayout.LayoutParams) r2;
        goto L_0x010f;
    L_0x01ae:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0114;
    L_0x01b3:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0114;
    L_0x01b8:
        r2 = 0;
        goto L_0x0129;
    L_0x01bb:
        r3 = 0;
        goto L_0x013b;
    L_0x01be:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0158;
    L_0x01c3:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0158;
    L_0x01c7:
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x0171;
    L_0x01cc:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0171;
    L_0x01d0:
        if (r21 <= 0) goto L_0x029f;
    L_0x01d2:
        r0 = r21;
        r13.setBackgroundResource(r0);
        r2 = 0;
        r13.setImageDrawable(r2);
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r16;
        if (r0 >= r2) goto L_0x01e7;
    L_0x01e1:
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r17;
        if (r0 < r2) goto L_0x027a;
    L_0x01e7:
        r0 = r17;
        r1 = r16;
        if (r0 <= r1) goto L_0x026d;
    L_0x01ed:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r17;
        r3 = (float) r0;
        r2 = r2 / r3;
    L_0x01f3:
        r0 = r16;
        r3 = (float) r0;
        r3 = r3 * r2;
        r3 = (int) r3;
        r0 = r17;
        r4 = (float) r0;
        r2 = r2 * r4;
        r2 = (int) r2;
        if (r3 <= 0) goto L_0x0274;
    L_0x01ff:
        r3 = (float) r3;
        r3 = r3 * r15;
        r3 = (int) r3;
        if (r2 <= 0) goto L_0x0277;
    L_0x0204:
        r2 = (float) r2;
        r2 = r2 * r15;
        r2 = (int) r2;
    L_0x0207:
        r4 = (float) r3;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r15;
        r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r4 >= 0) goto L_0x02e9;
    L_0x020f:
        r4 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small width is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r8[r9] = r3;
        com.tencent.mm.sdk.platformtools.v.d(r4, r7, r8);
        r3 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r3 = r3 * r15;
        r3 = (int) r3;
        r4 = r3;
    L_0x0227:
        r3 = (float) r2;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r15;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x0246;
    L_0x022f:
        r3 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small height is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r8[r9] = r2;
        com.tencent.mm.sdk.platformtools.v.d(r3, r7, r8);
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r2 * r15;
        r2 = (int) r2;
    L_0x0246:
        r3 = new android.widget.FrameLayout$LayoutParams;
        r3.<init>(r4, r2);
        if (r22 != 0) goto L_0x0296;
    L_0x024d:
        r2 = 5;
        r3.gravity = r2;
    L_0x0250:
        if (r24 == 0) goto L_0x02e6;
    L_0x0252:
        r0 = r24;
        r0.setLayoutParams(r3);
        r2 = r3;
    L_0x0258:
        r13.setLayoutParams(r2);
        if (r5 != 0) goto L_0x026a;
    L_0x025d:
        r8 = 1;
        r2 = r12;
        r3 = r13;
        r4 = r20;
        r5 = r24;
        r7 = r15;
        r9 = r19;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
    L_0x026a:
        r2 = 0;
        goto L_0x0016;
    L_0x026d:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r16;
        r3 = (float) r0;
        r2 = r2 / r3;
        goto L_0x01f3;
    L_0x0274:
        r3 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x01ff;
    L_0x0277:
        r2 = 75;
        goto L_0x0204;
    L_0x027a:
        if (r16 <= 0) goto L_0x0290;
    L_0x027c:
        r0 = r16;
        r2 = (float) r0;
        r2 = r2 * r15;
        r3 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r3;
        r3 = (int) r2;
        if (r17 <= 0) goto L_0x0293;
    L_0x0286:
        r0 = r17;
        r2 = (float) r0;
        r2 = r2 * r15;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r4;
        r2 = (int) r2;
        goto L_0x0207;
    L_0x0290:
        r16 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x027c;
    L_0x0293:
        r17 = 75;
        goto L_0x0286;
    L_0x0296:
        r2 = 1;
        r0 = r22;
        if (r0 != r2) goto L_0x0250;
    L_0x029b:
        r2 = 3;
        r3.gravity = r2;
        goto L_0x0250;
    L_0x029f:
        r2 = r12.cMl;
        if (r2 == 0) goto L_0x02ab;
    L_0x02a3:
        r2 = r12.cMl;
        r2 = r2.get();
        if (r2 != 0) goto L_0x02ba;
    L_0x02ab:
        r2 = new android.graphics.drawable.ColorDrawable;
        r3 = -1118482; // 0xffffffffffeeeeee float:NaN double:NaN;
        r2.<init>(r3);
        r3 = new java.lang.ref.SoftReference;
        r3.<init>(r2);
        r12.cMl = r3;
    L_0x02ba:
        r2 = r12.cMl;
        r2 = r2.get();
        r2 = (android.graphics.drawable.ColorDrawable) r2;
        r13.setImageDrawable(r2);
        r2 = new android.widget.FrameLayout$LayoutParams;
        if (r16 <= 0) goto L_0x02e0;
    L_0x02c9:
        r0 = r16;
        r3 = (float) r0;
        r3 = r3 * r15;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r3 = r3 * r4;
        r3 = (int) r3;
        if (r17 <= 0) goto L_0x02e3;
    L_0x02d3:
        r0 = r17;
        r4 = (float) r0;
        r4 = r4 * r15;
        r7 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r4 = r4 * r7;
        r4 = (int) r4;
        r2.<init>(r3, r4);
        goto L_0x0258;
    L_0x02e0:
        r16 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x02c9;
    L_0x02e3:
        r17 = 75;
        goto L_0x02d3;
    L_0x02e6:
        r2 = r3;
        goto L_0x0258;
    L_0x02e9:
        r4 = r3;
        goto L_0x0227;
    L_0x02ec:
        r4 = r2;
        goto L_0x00d3;
    L_0x02ef:
        r5 = r3;
        r2 = r10;
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ae.f.a(android.widget.ImageView, java.lang.String, float, int, int, boolean, int, android.widget.ImageView, int, int, boolean, android.view.View):boolean");
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f, boolean z, int i) {
        int hashCode;
        int i2;
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (b bVar : this.cMd) {
            if (hashCode3 == bVar.cMu) {
                v.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", Integer.valueOf(bVar.cMu), bVar.url);
                bVar.url = str;
                if (!this.cMh.contains(Integer.valueOf(hashCode2))) {
                    this.cMh.add(Integer.valueOf(hashCode2));
                    a(str, f, z, i);
                    return;
                }
                return;
            }
        }
        this.cMe.put(Integer.valueOf(hashCode3), new WeakReference(imageView));
        if (imageView2 != null) {
            hashCode = imageView2.hashCode();
            this.cMf.put(Integer.valueOf(hashCode), new WeakReference(imageView2));
            i2 = hashCode;
        } else {
            i2 = 0;
        }
        if (view != null) {
            hashCode = view.hashCode();
            this.cMg.put(Integer.valueOf(hashCode), new WeakReference(view));
        } else {
            hashCode = 0;
        }
        this.cMd.add(new b(hashCode3, str, i2, hashCode));
        if (!this.cMh.contains(Integer.valueOf(hashCode2))) {
            this.cMh.add(Integer.valueOf(hashCode2));
            a(str, f, z, i);
        }
    }

    private void a(String str, float f, boolean z, int i) {
        final String str2 = str;
        final float f2 = f;
        final boolean z2 = z;
        final int i2 = i;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ f cMo;

            public final void run() {
                this.cMo.a(str2, true, f2, true, false, z2, i2);
                this.cMo.cnC.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 cMt;

                    {
                        this.cMt = r1;
                    }

                    public final void run() {
                        f.a(this.cMt.cMo, str2);
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|loadImginBackground";
            }
        });
    }

    public final Bitmap a(String str, float f) {
        return a(str, true, f, false, true, false, 0);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        return a(str, z, f, z2, z3, z4, i, true);
    }

    private Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        return a(str, z, f, z2, z3, z4, i, z5, null);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        Bitmap bitmap2;
        if (!z) {
            str = x(str, true);
        }
        if (str == null) {
            return null;
        }
        Bitmap bitmap3 = null;
        Object obj = bitmap != null ? 1 : null;
        if (z5) {
            bitmap3 = (Bitmap) this.cMb.get(str);
            if (bitmap3 == null) {
                String str2 = "MicroMsg.ImgInfoStorage";
                String str3 = "bm is null:%b,  url:%s";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap3 == null);
                objArr[1] = str;
                v.h(str2, str3, objArr);
            }
        }
        if (bitmap3 != null && !bitmap3.isRecycled() && obj == null) {
            return bitmap3;
        }
        be.Ni();
        if (obj != null) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = d.a(str, f, 0);
        }
        if (bitmap2 == null) {
            return bitmap3;
        }
        int width;
        int height;
        int i2;
        Bitmap createScaledBitmap;
        long currentTimeMillis = System.currentTimeMillis();
        if (str.endsWith("hd")) {
            width = bitmap2.getWidth();
            height = bitmap2.getHeight();
        } else {
            width = (int) ((((float) bitmap2.getWidth()) * f) * 1.25f);
            height = (int) ((((float) bitmap2.getHeight()) * f) * 1.25f);
        }
        if (z3) {
            if (cMa == 0) {
                cMa = com.tencent.mm.bd.a.N(aa.getContext(), 2131493447);
            }
            if (width > cMa || height > cMa) {
                if (width > height) {
                    height = (cMa * height) / width;
                    width = cMa;
                } else if (width == height) {
                    height = cMa;
                    width = cMa;
                } else {
                    width = (cMa * width) / height;
                    height = cMa;
                }
            }
        }
        if (z4) {
            if (((float) width) >= 160.0f * f || ((float) height) >= 160.0f * f) {
                float f2;
                if (height > width) {
                    f2 = (160.0f * f) / ((float) height);
                } else {
                    f2 = (160.0f * f) / ((float) width);
                }
                i2 = (int) (f2 * ((float) height));
                height = (int) (((float) width) * f2);
            } else {
                i2 = height;
                height = width;
            }
            if (((float) height) < 60.0f * f) {
                v.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", Integer.valueOf(height));
                height = (int) (60.0f * f);
            }
            if (((float) i2) < 60.0f * f) {
                v.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", Integer.valueOf(i2));
                i2 = (int) (60.0f * f);
            }
            Context context = aa.getContext();
            int[] iArr = new int[2];
            float f3;
            if (i2 >= height) {
                f3 = ((float) i2) / ((float) height);
                if (f3 <= 2.0f) {
                    i2 = com.tencent.mm.bd.a.N(context, 2131492982);
                    height = (int) (((float) i2) / f3);
                } else {
                    height = com.tencent.mm.bd.a.N(context, 2131492984);
                    i2 = (int) (((float) height) * f3);
                }
            } else {
                f3 = ((float) height) / ((float) i2);
                if (f3 <= 2.0f) {
                    height = com.tencent.mm.bd.a.N(context, 2131492982);
                    i2 = (int) (((float) height) / f3);
                } else {
                    i2 = com.tencent.mm.bd.a.N(context, 2131492984);
                    height = (int) (((float) i2) * f3);
                }
            }
            iArr[0] = height;
            iArr[1] = i2;
            height = iArr[0];
            i2 = iArr[1];
        } else {
            i2 = height;
            height = width;
        }
        try {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, height, i2, true);
        } catch (OutOfMemoryError e) {
            createScaledBitmap = bitmap2;
        }
        if (bitmap2 != createScaledBitmap && obj == null) {
            v.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmap2.toString());
            bitmap2.recycle();
        }
        if (z4) {
            bitmap3 = d.b(createScaledBitmap, i);
        } else if (z2) {
            bitmap3 = d.a(createScaledBitmap, true, (float) com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 3));
            v.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", createScaledBitmap.toString());
            createScaledBitmap.recycle();
        } else {
            bitmap3 = createScaledBitmap;
        }
        str2 = "MicroMsg.ImgInfoStorage";
        str3 = "cached file :%s bitmap time:%s bitmap:%s";
        objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = (System.currentTimeMillis() - currentTimeMillis);
        objArr[2] = bitmap3 == null ? SQLiteDatabase.KeyEmpty : bitmap3.toString();
        v.i(str2, str3, objArr);
        if (bitmap3 == null || obj != null) {
            return bitmap3;
        }
        this.cMb.k(str, bitmap3);
        return bitmap3;
    }

    public final Bitmap a(String str, float f, Context context) {
        return a(str, f, context, -1);
    }

    public final Bitmap a(String str, float f, Context context, int i) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.cMb.get(trim);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(trim, f);
        if (c == null) {
            return c;
        }
        int a;
        int i2;
        int width = c.getWidth();
        int height = c.getHeight();
        if (width >= height) {
            a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, (float) this.cMm);
            i2 = (int) ((((float) height) / ((float) width)) * ((float) a));
        } else {
            i2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, (float) this.cMm);
            a = (int) ((((float) width) / ((float) height)) * ((float) i2));
        }
        if (a <= 0 || i2 <= 0 || a > 2048 || i2 > 2048) {
            v.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", Integer.valueOf(a), Integer.valueOf(i2));
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 188, 1, false);
            bitmap = null;
        } else {
            try {
                bitmap = Bitmap.createScaledBitmap(c, a, i2, true);
            } catch (Exception e) {
                v.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", e.getMessage());
                bitmap = null;
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 188, 1, false);
            }
        }
        if (i != -1) {
            bitmap = d.b(bitmap, i);
        }
        if (c != bitmap) {
            v.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", c.toString());
            c.recycle();
        }
        v.d("MicroMsg.ImgInfoStorage", "cached file " + trim);
        this.cMb.k(trim, bitmap);
        return bitmap;
    }

    public final d j(at atVar) {
        d ai = ai(atVar.field_msgId);
        if (ai.cLu != 0) {
            return ai;
        }
        ai = ah(atVar.field_msgSvrId);
        if (ai.cLu != 0) {
            return ai;
        }
        v.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        return null;
    }

    public final d b(Long l) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)}, null, null, null);
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    private d v(String str, int i) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{str, String.valueOf(i)}, null, null, null);
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    public final void k(at atVar) {
        d j = j(atVar);
        if (j == null || j.cLu == 0) {
            v.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            return;
        }
        FileOp.deleteFile(l(j.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
        FileOp.deleteFile(l(j.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
        FileOp.deleteFile(l(j.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty) + "hd");
        this.cuX.delete("ImgInfo2", "id=?", new String[]{j.cLu});
        if (j.Gp()) {
            j = fC(j.cLE);
            if (j != null) {
                FileOp.deleteFile(l(j.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                FileOp.deleteFile(l(j.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                FileOp.deleteFile(l(j.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty) + "hd");
                this.cuX.delete("ImgInfo2", "id=?", new String[]{j.cLu});
            }
        }
    }

    public final String d(d dVar) {
        String str = null;
        if (dVar != null && dVar.Gp()) {
            Cursor a = a("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{dVar.cLE});
            if (a.moveToFirst()) {
                str = a.getString(0);
            }
            a.close();
        }
        return str;
    }

    public final HashMap<Long, d> a(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msgSvrId in " + (str + ")"), null);
        HashMap<Long, d> hashMap = new HashMap();
        while (a.moveToNext()) {
            d dVar = new d();
            dVar.b(a);
            hashMap.put(Long.valueOf(dVar.bmL), dVar);
        }
        a.close();
        return hashMap;
    }

    public final HashMap<Long, d> b(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msglocalid in " + (str + ")"), null);
        HashMap<Long, d> hashMap = new HashMap();
        while (a.moveToNext()) {
            d dVar = new d();
            dVar.b(a);
            hashMap.put(Long.valueOf(dVar.bmL), dVar);
        }
        a.close();
        return hashMap;
    }

    public final d fC(int i) {
        return b(Long.valueOf((long) i));
    }

    public final d ah(long j) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    public final d ai(long j) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (a != null && a.moveToLast()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ae.d fD(int r9) {
        /*
        r8 = this;
        r2 = 0;
        r0 = "ImgInfo2";
        r1 = 0;
        r3 = "reserved1=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x002d }
        r5 = 0;
        r6 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x002d }
        r4[r5] = r6;	 Catch:{ Exception -> 0x002d }
        r3 = r8.a(r0, r1, r3, r4);	 Catch:{ Exception -> 0x002d }
        if (r3 == 0) goto L_0x005e;
    L_0x0018:
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        if (r0 == 0) goto L_0x005e;
    L_0x001e:
        r1 = new com.tencent.mm.ae.d;	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r1.<init>();	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r1.b(r3);	 Catch:{ Exception -> 0x0058, all -> 0x0050 }
        r0 = r1;
    L_0x0027:
        if (r3 == 0) goto L_0x002c;
    L_0x0029:
        r3.close();
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0030:
        r3 = "MicroMsg.ImgInfoStorage";
        r4 = "Exception :%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0049 }
        r6 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x0049 }
        r5[r6] = r1;	 Catch:{ all -> 0x0049 }
        com.tencent.mm.sdk.platformtools.v.w(r3, r4, r5);	 Catch:{ all -> 0x0049 }
        if (r2 == 0) goto L_0x002c;
    L_0x0045:
        r2.close();
        goto L_0x002c;
    L_0x0049:
        r0 = move-exception;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();
    L_0x004f:
        throw r0;
    L_0x0050:
        r0 = move-exception;
        r2 = r3;
        goto L_0x004a;
    L_0x0053:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x0030;
    L_0x0058:
        r0 = move-exception;
        r2 = r3;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0030;
    L_0x005e:
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ae.f.fD(int):com.tencent.mm.ae.d");
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return this.cuX.query(str, strArr, str2, strArr2, null, null, null);
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        return a(str, strArr, str2, strArr2, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2) {
        return a(str, i, i2, i3, pString, pInt, pInt2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, -1, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.ae.m.a aVar) {
        d a;
        long e;
        if (i == 0) {
            a = a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.cLx;
            e = e(a);
            if (e == -1) {
                return e;
            }
            Ls();
            return e;
        } else if (i == 1) {
            a = a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.cLx;
            a.af(0);
            a.y(0);
            a.fx((int) FileOp.jP(l(a.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
            d a2 = a(str, 0, false, i2, i3, new PInt(), new PInt(), SQLiteDatabase.KeyEmpty, j, str2, str3, bVar2, bVar, aVar);
            a2.iQ(a.cLv);
            a2.iS(a.cLx);
            a2.iR(a.cLw);
            a2.fx(0);
            long er = this.cuX.er(Thread.currentThread().getId());
            a2.fy((int) e(a));
            e = e(a2);
            v.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", Long.valueOf(e), Long.valueOf(a2.cLu), Long.valueOf(a2.cLC), a2.cLv, a2.cLw, Integer.valueOf(a2.cyu));
            if (er > 0) {
                ak.yW();
                c.wE().es(er);
            }
            if (e == -1) {
                return e;
            }
            Ls();
            return e;
        } else {
            Assert.assertTrue(false);
            return 0;
        }
    }

    private long e(d dVar) {
        long insert = this.cuX.insert("ImgInfo2", "id", dVar.py());
        if (insert != -1) {
            dVar.Gq();
        }
        return insert;
    }

    private String w(String str, int i) {
        d v = v(FileOp.jV(str), i);
        if (!be.kS(v.cLx)) {
            String w = w(v.cLx, true);
            if (FileOp.aR(w)) {
                return w;
            }
        }
        return null;
    }

    public final Bitmap a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, com.tencent.mm.a.b bVar) {
        Bitmap bitmap;
        String str3;
        v.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s]", str, Integer.valueOf(i), Boolean.valueOf(z), be.bur());
        Bitmap bitmap2 = (Bitmap) this.cMb.get(str);
        if (bitmap2 == null || bitmap2.isRecycled()) {
            String w = w(str, i);
            if (be.kS(w)) {
                bitmap = bitmap2;
                str3 = str;
            } else if (w.endsWith("hd")) {
                bitmap = bitmap2;
                str3 = w;
            } else {
                bitmap = d.bE(w, 0);
                str3 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int JT = d.JT(str3);
                int JQ = ExifHelper.JQ(str3) + (i2 * 90);
                if (JT > 0) {
                    bitmap = d.b(str3, 2000, 2000, JT, JQ, 0);
                    str3 = w;
                } else {
                    bitmap = d.JU(str3);
                    str3 = w;
                }
            } else {
                str3 = w;
            }
        } else {
            bitmap = bitmap2;
            str3 = null;
        }
        if (bitmap != null) {
            this.cMb.k(str, bitmap);
            pInt.value = bitmap.getWidth();
            pInt2.value = bitmap.getHeight();
            if (z) {
                if (str3 == null) {
                    str3 = w(str, i);
                }
                if (!be.kS(str3) && str3.endsWith("hd")) {
                    str3 = str3.substring(0, str3.length() - 2);
                }
                if (bVar != null) {
                    bVar.nY();
                }
                if (be.kS(str3) || !FileOp.aR(str3)) {
                    try {
                        d.a(bitmap, 100, CompressFormat.JPEG, str2, false);
                    } catch (IOException e) {
                    }
                } else {
                    FileOp.p(str3, str2);
                    v.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", str3);
                }
            }
        }
        return bitmap;
    }

    public static synchronized String Gs() {
        String m;
        synchronized (f.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (cMn == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            cMn = currentTimeMillis;
            m = com.tencent.mm.a.g.m(String.valueOf(currentTimeMillis).getBytes());
        }
        return m;
    }

    public final String a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, com.tencent.mm.a.b bVar) {
        int i2;
        int indexOf;
        boolean z2;
        int i3;
        if (be.kS(str3)) {
            str3 = com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
        }
        String a = a(str3, SQLiteDatabase.KeyEmpty, ".jpg", false);
        if (bVar == null) {
            a = a(str3, SQLiteDatabase.KeyEmpty, ".jpg", true);
        }
        pString.value = str3;
        pString2.value = a;
        if (z && !be.kS(str2) && i == 0) {
            d v = v(str2, i);
            if (!be.kS(v.cLv)) {
                String l = l(v.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                if (bVar != null) {
                    bVar.nY();
                }
                FileOp.p(l, a);
                if (FileOp.jP(l) <= 0) {
                    v.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", str, a);
                } else if (be.kS(v.cLF)) {
                    return null;
                } else {
                    return v.cLF;
                }
            }
        }
        int i4 = 0;
        try {
            if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                i4 = Integer.valueOf(j.sU().getValue("CompressPicLevelForWifi")).intValue();
            } else if (com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                i4 = Integer.valueOf(j.sU().getValue("CompressPicLevelFor2G")).intValue();
            } else {
                i4 = Integer.valueOf(j.sU().getValue("CompressPicLevelFor3G")).intValue();
            }
        } catch (Exception e) {
        }
        v.i("MicroMsg.ImgInfoStorage", "CompressPicLevel-level:%d", Integer.valueOf(i4));
        if (i4 <= 10 || i4 > 100) {
            i2 = 70;
        } else {
            i2 = i4;
        }
        int i5 = 0;
        i4 = 0;
        try {
            String value;
            if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                value = j.sU().getValue("CompressResolutionForWifi");
            } else if (com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                value = j.sU().getValue("CompressResolutionFor2G");
            } else {
                value = j.sU().getValue("CompressResolutionFor3G");
            }
            indexOf = value.indexOf("*");
            if (-1 != indexOf) {
                i5 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                i4 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
            }
        } catch (Exception e2) {
        }
        boolean z3 = false;
        try {
            indexOf = be.getInt(j.sU().getValue("UseOptImage"), 0);
            ak.yW();
            if ((((int) (new o(c.ww()).longValue() / 100)) % 100) + 1 <= indexOf) {
                z3 = true;
            }
            v.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", Boolean.valueOf(z3), Integer.valueOf(indexOf), Long.valueOf(new o(c.ww()).longValue()), Long.valueOf(new o(c.ww()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.b.b.bsI()), Integer.valueOf(VERSION.SDK_INT));
        } catch (Throwable e3) {
            v.e("MicroMsg.ImgInfoStorage", "get useopt :%s", be.e(e3));
            z3 = false;
        }
        if (com.tencent.mm.sdk.b.b.bsI()) {
            z3 = true;
        }
        if (com.tencent.mm.compatible.util.d.dX(16)) {
            z2 = false;
        } else {
            z2 = z3;
        }
        v.i("MicroMsg.ImgInfoStorage", "CompressResolution-width:%d CompressResolution-height:%d", Integer.valueOf(i5), Integer.valueOf(i4));
        if (i5 <= 0) {
            i5 = 960;
        }
        if (i4 <= 0) {
            i4 = 960;
        }
        if (i5 < i4) {
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        }
        int i7 = be.getInt(j.sU().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i7 <= 0) {
            i7 = 100;
        }
        int i8 = i7 * 1024;
        i7 = be.getInt(j.sU().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i7 <= 0 || i7 >= 100) {
            i3 = 10;
        } else {
            i3 = i7;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str);
        Object obj = 1;
        if (queryQuality != 0 && queryQuality <= i2) {
            obj = null;
        }
        v.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", str, a, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i8), Integer.valueOf(i3));
        if (z) {
            boolean z4;
            boolean z5;
            long j;
            boolean z6;
            Options JS = d.JS(str);
            int i9 = JS != null ? JS.outWidth : -1;
            int i10 = JS != null ? JS.outHeight : -1;
            int i11 = 0;
            indexOf = 0;
            if (JS != null) {
                if (i9 < i10) {
                    indexOf = i9;
                    i11 = i10;
                } else {
                    indexOf = i10;
                    i11 = i9;
                }
            }
            long jP = FileOp.jP(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (i != 0 || ((r6 == null && (queryQuality != 0 || (jP <= 204800 && (JS == null || (indexOf <= i4 && i11 <= i5))))) || jP <= ((long) i8))) {
                v.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", Integer.valueOf(queryQuality), Long.valueOf(jP), Integer.valueOf(i9), Integer.valueOf(i10));
                FileOp.p(str, a);
                com.tencent.mm.modelcdntran.g.DZ();
                if (!com.tencent.mm.modelcdntran.c.fk(FileUtils.S_IRUSR)) {
                    v.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i12;
                    int i13 = 0;
                    i7 = 0;
                    try {
                        i13 = Integer.valueOf(j.sU().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        i7 = Integer.valueOf(j.sU().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                    }
                    v.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", Integer.valueOf(i13), Integer.valueOf(i7));
                    if (i13 <= 10 || i13 > 100) {
                        i13 = 52;
                    }
                    if (i7 <= 0 || i7 > 800) {
                        i7 = 800;
                    }
                    if (i5 > i7) {
                        i12 = i7;
                    } else {
                        i12 = i5;
                    }
                    if (i4 > i7) {
                        i8 = i7;
                    } else {
                        i8 = i4;
                    }
                    z4 = true;
                    if (queryQuality != 0 && queryQuality <= i13) {
                        z4 = false;
                    }
                    if (z4 || (queryQuality == 0 && (jP > ((long) (i7 * i7)) || (JS != null && (indexOf > i7 || i11 > i7))))) {
                        pString3.value = com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
                        pString4.value = a(pString3.value, SQLiteDatabase.KeyEmpty, ".jpg", false);
                        v.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", pString3.value, pString4.value, Boolean.valueOf(false), Integer.valueOf(d.a(false, str, i8, i12, CompressFormat.JPEG, i13, pString4.value, bVar)), Integer.valueOf(i8), Integer.valueOf(i12));
                        i7 = i4;
                        i8 = 38;
                        z5 = false;
                        j = 0;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        v.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", Boolean.valueOf(z4), Integer.valueOf(indexOf), Integer.valueOf(i11), Integer.valueOf(i8), Integer.valueOf(i12), pString3.value, pString4.value);
                        j = 0;
                        i7 = 1;
                        i8 = 38;
                        z5 = false;
                    }
                }
                j = 0;
                i7 = 1;
                i8 = 38;
                z5 = false;
            } else {
                if (indexOf < i4) {
                    i4 = indexOf;
                }
                if (i11 < i5) {
                    i7 = i11;
                } else {
                    i7 = i5;
                }
                if (JS == null || i9 >= i10) {
                    indexOf = i7;
                    i7 = i4;
                } else {
                    indexOf = i4;
                }
                if (queryQuality < 55 || !IsJpegFile) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (z4) {
                    i8 = 18;
                } else {
                    i8 = 8;
                }
                long Ni = be.Ni();
                i5 = d.a(z4, str, i7, indexOf, CompressFormat.JPEG, i2, a, bVar);
                if (i5 == 1 || !z4) {
                    i6 = i5;
                    z6 = z4;
                    i4 = i6;
                } else {
                    i8 = 28;
                    i4 = d.a(false, str, i7, indexOf, CompressFormat.JPEG, i2, a, bVar);
                    z6 = false;
                }
                v.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", Long.valueOf(jP), Long.valueOf(FileOp.jP(a)), Long.valueOf((100 * FileOp.jP(a)) / jP), Integer.valueOf(i3), a);
                if ((jP - FileOp.jP(a)) * 100 < ((long) i3) * jP) {
                    FileOp.p(str, a);
                    z6 = false;
                    i8 = 48;
                    i4 = 1;
                }
                long Ni2 = be.Ni() - Ni;
                if (i4 != 1) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 187, 1, false);
                    v.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", str);
                    return null;
                }
                long j2 = Ni2;
                i7 = i4;
                z5 = z6;
                j = j2;
            }
            Options JS2 = d.JS(a);
            i11 = JS2 != null ? JS2.outWidth : -1;
            int i14 = JS2 != null ? JS2.outHeight : -1;
            long jP2 = FileOp.jP(a);
            i3 = MMNativeJpeg.queryQuality(a);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(a);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            Integer[] numArr = new Object[13];
            numArr[0] = Integer.valueOf(i7);
            numArr[1] = Long.valueOf(j);
            numArr[2] = Integer.valueOf(i8);
            numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            numArr[4] = Long.valueOf(jP);
            numArr[5] = Integer.valueOf(i9);
            numArr[6] = Integer.valueOf(i10);
            numArr[7] = Integer.valueOf(i);
            numArr[8] = Long.valueOf(jP2);
            numArr[9] = Integer.valueOf(i11);
            numArr[10] = Integer.valueOf(i14);
            numArr[11] = Integer.valueOf(queryQuality);
            numArr[12] = Integer.valueOf(i3);
            gVar.h(11713, numArr);
            v.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z5), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(jP), Boolean.valueOf(IsJpegFile), Integer.valueOf(i11), Integer.valueOf(i14), Integer.valueOf(i3), Long.valueOf(jP2), Boolean.valueOf(IsJpegFile2), str, a);
            if (i == 0 && jP2 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(a)) {
                String value2 = j.sU().getValue("EnableCDNUploadImg");
                if (!be.kS(value2) && value2.equals("1")) {
                    long Ni3 = be.Ni();
                    if (z5) {
                        String str4 = a + ".prog";
                        FileOp.p(a, str4);
                        z4 = (be.kS(str4) || be.kS(a) || !new File(str4).exists()) ? false : MMJpegOptim.convertToProgressive(str4, a, i2) == 0;
                        FileOp.deleteFile(str4);
                        if (z4) {
                            z6 = z4;
                            i4 = 19;
                        } else {
                            i4 = 29;
                            z6 = MMNativeJpeg.convertToProgressive(a, i2);
                        }
                    } else {
                        i4 = 9;
                        z6 = MMNativeJpeg.convertToProgressive(a, i2);
                    }
                    Ni3 = be.Ni() - Ni3;
                    long jP3 = FileOp.jP(a);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.iuh;
                    Integer[] numArr2 = new Object[14];
                    numArr2[0] = Integer.valueOf(z6 ? 1 : -1);
                    numArr2[1] = Long.valueOf(Ni3);
                    numArr2[2] = Integer.valueOf(i4);
                    numArr2[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    numArr2[4] = Long.valueOf(jP);
                    numArr2[5] = Integer.valueOf(i9);
                    numArr2[6] = Integer.valueOf(i10);
                    numArr2[7] = Integer.valueOf(i);
                    numArr2[8] = Long.valueOf(jP2);
                    numArr2[9] = Integer.valueOf(i11);
                    numArr2[10] = Integer.valueOf(i14);
                    numArr2[11] = Integer.valueOf(queryQuality);
                    numArr2[12] = Integer.valueOf(i3);
                    numArr2[13] = Long.valueOf(jP3);
                    gVar2.h(11713, numArr2);
                    v.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z6), Long.valueOf(jP3), Boolean.valueOf(z5), Integer.valueOf(i4), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(jP), Boolean.valueOf(IsJpegFile), Integer.valueOf(i11), Integer.valueOf(i14), Integer.valueOf(i3), Long.valueOf(jP2), Boolean.valueOf(IsJpegFile2), str, a);
                    if (!z6) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 186, 1, false);
                        v.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", a);
                    }
                }
            }
        }
        return null;
    }

    private d a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.ae.m.a aVar) {
        if (!FileOp.aR(str)) {
            return null;
        }
        String str5;
        String str6;
        PString pString;
        PString pString2;
        PString pString3;
        String a;
        String jV = FileOp.jV(str);
        v.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", str);
        if (FileOp.aR(str)) {
            if (be.kS(str3)) {
                str3 = Gs();
            }
            str5 = "THUMBNAIL_DIRPATH://th_" + str3;
            String a2 = a(str5, "th_", SQLiteDatabase.KeyEmpty, false);
            if (bVar == null) {
                a2 = l(str5, "th_", SQLiteDatabase.KeyEmpty);
            }
            if (z) {
                if (be.kS(str2) || !FileOp.aR(str2)) {
                    long Nj = be.Nj();
                    a(str, i, i3, pInt, pInt2, true, a2, bVar);
                    if (FileOp.aR(a2)) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10921, Long.valueOf(FileOp.jP(a2)), Long.valueOf(FileOp.jP(str)), Integer.valueOf(90), Long.valueOf(be.az(Nj)));
                    } else {
                        v.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    FileOp.p(str2, a2);
                }
                v.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str5);
            }
            str6 = str5;
        } else {
            v.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
            str6 = null;
        }
        if (aVar == null || aVar.cLy != i) {
            com.tencent.mm.a.b bVar3;
            if (aVar == null || aVar.cLy == i) {
                bVar3 = bVar2;
                str5 = str4;
            } else {
                bVar3 = null;
                str5 = null;
            }
            pString = new PString();
            pString2 = new PString();
            pString3 = new PString();
            a = a(str, jV, i, z, pString, pString2, pString3, new PString(), str5, bVar3);
            v.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value);
        } else {
            com.tencent.mm.ae.m.a.a GA = aVar.GA();
            pString = GA.cNW;
            pString2 = GA.cNX;
            a = GA.cLF;
            pString3 = GA.cNY;
            PString pString4 = GA.cNZ;
            v.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value);
        }
        d dVar = new d();
        dVar.bkU = -1;
        long j2 = this.cMj;
        this.cMj = 1 + j2;
        dVar.ag(j2);
        dVar.af(j);
        if (!be.kS(a)) {
            dVar.iT(a);
        }
        dVar.fA(0);
        dVar.bbT = i2;
        dVar.cLT = true;
        if (i2 == 4) {
            ak.yW();
            if (str.startsWith(c.wW())) {
                dVar.fz(3);
            } else {
                dVar.fz(2);
            }
        } else {
            dVar.fz(1);
        }
        if (z) {
            dVar.iQ(pString.value + ".jpg");
            if (!(pString3 == null || be.kS(pString3.value))) {
                dVar.iR(pString3.value + ".jpg");
            }
            if (be.kS(dVar.cLx)) {
                dVar.iS(str6);
            }
            dVar.fx((int) FileOp.jP(pString2.value));
            if (dVar.cyu == 0) {
                v.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", pString2.value);
            }
            dVar.iP(jV);
        }
        dVar.fw((int) be.Nh());
        dVar.fB(i);
        v.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + dVar.cyu);
        return dVar;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        return a(bArr, j, z, SQLiteDatabase.KeyEmpty, 0, str, pString, pInt, pInt2);
    }

    public final long a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        String str3 = "SERVERID://" + j;
        String m = com.tencent.mm.a.g.m(str3.getBytes());
        String l = l(m, "th_", SQLiteDatabase.KeyEmpty);
        if (bArr != null && bArr.length >= 0) {
            Bitmap bd = d.bd(bArr);
            if (bd == null) {
                v.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || bd == null)) {
                try {
                    bd = d.D(bd);
                    pInt.value = bd.getWidth();
                    pInt2.value = bd.getHeight();
                    d.a(bd, 90, CompressFormat.JPEG, l, true);
                } catch (IOException e) {
                    v.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + m + " " + new String(bArr));
                }
            }
        }
        d dVar = new d();
        if (be.kS(str)) {
            str = str3;
        } else {
            dVar.setOffset(i);
            dVar.fx(i);
        }
        dVar.bkU = -1;
        long j2 = this.cMj;
        this.cMj = 1 + j2;
        dVar.ag(j2);
        dVar.iQ(str);
        dVar.iS("THUMBNAIL_DIRPATH://th_" + m);
        pString.value = dVar.cLx;
        if (z) {
            dVar.y(0);
        } else {
            dVar.y(j);
        }
        dVar.iT(str2);
        dVar.fw((int) be.Nh());
        long e2 = e(dVar);
        if (e2 != -1) {
            Ls();
        }
        return e2;
    }

    public final int a(int i, d dVar) {
        return a(Long.valueOf((long) i), dVar);
    }

    public final int a(Long l, d dVar) {
        int i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues py = dVar.py();
        if (py.size() == 0) {
            i = 1;
        } else {
            i = this.cuX.update("ImgInfo2", py, "id=?", new String[]{String.valueOf(l)});
        }
        v.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), py.toString());
        if (i != -1) {
            dVar.Gq();
            Ls();
        }
        return i;
    }

    public final Bitmap a(long j, String str, int i, int i2, int i3, boolean z) {
        Object obj;
        if (z) {
            obj = "location_backgroup_key_from" + j;
        } else {
            String str2 = "location_backgroup_key_tor" + j;
        }
        Bitmap bitmap = (Bitmap) this.cMb.get(obj);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        bitmap = d.f(str, i, i2, i3);
        this.cMb.k(obj, bitmap);
        return bitmap;
    }

    public final boolean a(String str, String str2, int i, int i2) {
        v.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), be.bur());
        long currentTimeMillis = System.currentTimeMillis();
        float density = com.tencent.mm.bd.a.getDensity(aa.getContext());
        if (be.kS(str) || be.kS(str2)) {
            return false;
        }
        String x = x(str2, true);
        if (be.kS(x)) {
            return false;
        }
        String str3;
        String substring;
        int i3;
        int i4;
        boolean a;
        if (x.endsWith("hd")) {
            str3 = x;
            substring = x.substring(0, x.length() - 2);
        } else {
            str3 = x + "hd";
            substring = x;
        }
        Options JS = d.JS(substring);
        if (JS == null || JS.outWidth <= 0 || JS.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 185, 1, false);
            if (e.aQ(substring) > 0) {
                return false;
            }
            JS = new Options();
            d.a(JS);
            v.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", JS, Integer.valueOf(JS.outWidth), Integer.valueOf(JS.outHeight));
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 183, 1, false);
        }
        int i5 = (int) ((((float) JS.outWidth) * density) * 1.25f);
        int i6 = (int) ((((float) JS.outHeight) * density) * 1.25f);
        if (((float) i5) >= 160.0f * density || ((float) i6) >= 160.0f * density) {
            float f;
            if (i6 > i5) {
                f = (160.0f * density) / ((float) i6);
            } else {
                f = (160.0f * density) / ((float) i5);
            }
            i3 = (int) (((float) i5) * f);
            i4 = (int) (f * ((float) i6));
        } else {
            i4 = i6;
            i3 = i5;
        }
        i3 = Math.max(i3, i5);
        i6 = Math.max(i4, i6);
        if (i2 == 0) {
            try {
                a = d.a(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 184, 1, false);
                v.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", e.toString());
                return false;
            }
        }
        a = d.b(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
        v.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", (System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i3), Boolean.valueOf(a));
        a(substring, true, com.tencent.mm.bd.a.getDensity(aa.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.cMi) {
                if (this.cMi.containsKey(str2) && !((String) this.cMi.get(str2)).endsWith("hd")) {
                    this.cMi.put(str2, str3);
                }
            }
            return a;
        }
        com.tencent.mm.plugin.report.service.g.iuh.a(111, 184, 1, false);
        return a;
    }

    public final String x(String str, boolean z) {
        if (str != null && this.cMi.containsKey(str)) {
            return (String) this.cMi.get(str);
        }
        String w = w(str, z);
        if (be.kS(w)) {
            return w;
        }
        this.cMi.put(str, w);
        return w;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String l(com.tencent.mm.storage.at r10) {
        /*
        r6 = 0;
        r1 = 0;
        r8 = 1;
        if (r10 != 0) goto L_0x0011;
    L_0x0006:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "[getBigPicPath] msg is null.";
        com.tencent.mm.sdk.platformtools.v.w(r0, r2);
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = java.lang.System.currentTimeMillis();
        r0 = r10.field_isSend;
        if (r0 != r8) goto L_0x0029;
    L_0x0019:
        r0 = com.tencent.mm.ae.n.GH();
        r2 = r10.field_msgId;
        r0 = r0.ai(r2);
        r2 = r0.cLu;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0033;
    L_0x0029:
        r0 = com.tencent.mm.ae.n.GH();
        r2 = r10.field_msgSvrId;
        r0 = r0.ah(r2);
    L_0x0033:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r2 == 0) goto L_0x0080;
    L_0x003c:
        r2 = r10.field_isSend;
        if (r2 != r8) goto L_0x00a4;
    L_0x0040:
        r3 = com.tencent.mm.ae.e.c(r0);
        r2 = com.tencent.mm.ae.n.GH();
        r6 = "";
        r7 = "";
        r2 = r2.l(r3, r6, r7);
        if (r3 == 0) goto L_0x0062;
    L_0x0054:
        r3 = r3.length();
        if (r3 <= 0) goto L_0x0062;
    L_0x005a:
        r3 = com.tencent.mm.modelsfs.FileOp.aR(r2);
        if (r3 == 0) goto L_0x0062;
    L_0x0060:
        r0 = r2;
        goto L_0x0010;
    L_0x0062:
        r2 = r0.cLv;
        r0 = com.tencent.mm.ae.n.GH();
        r3 = "";
        r6 = "";
        r0 = r0.l(r2, r3, r6);
        if (r2 == 0) goto L_0x0080;
    L_0x0074:
        r2 = r2.length();
        if (r2 <= 0) goto L_0x0080;
    L_0x007a:
        r2 = com.tencent.mm.modelsfs.FileOp.aR(r0);
        if (r2 != 0) goto L_0x0010;
    L_0x0080:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "getBigPicPath use time:%s";
        r3 = new java.lang.Object[r8];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = java.lang.System.currentTimeMillis();
        r4 = r8 - r4;
        r4 = r7.append(r4);
        r4 = r4.toString();
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r2, r3);
        r0 = r1;
        goto L_0x0010;
    L_0x00a4:
        r2 = r0.Go();
        if (r2 == 0) goto L_0x0080;
    L_0x00aa:
        r1 = r0.cLv;
        r2 = r0.Gp();
        if (r2 == 0) goto L_0x00de;
    L_0x00b2:
        r0 = com.tencent.mm.ae.e.a(r0);
        if (r0 == 0) goto L_0x00de;
    L_0x00b8:
        r2 = r0.cLu;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x00de;
    L_0x00be:
        r2 = r0.Go();
        if (r2 == 0) goto L_0x00de;
    L_0x00c4:
        r2 = com.tencent.mm.ae.n.GH();
        r3 = r0.cLv;
        r4 = "";
        r5 = "";
        r2 = r2.l(r3, r4, r5);
        r2 = com.tencent.mm.modelsfs.FileOp.aR(r2);
        if (r2 == 0) goto L_0x00de;
    L_0x00da:
        r0 = r0.cLv;
        goto L_0x0010;
    L_0x00de:
        r0 = r1;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ae.f.l(com.tencent.mm.storage.at):java.lang.String");
    }
}
