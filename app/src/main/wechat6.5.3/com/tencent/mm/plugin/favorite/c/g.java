package com.tencent.mm.plugin.favorite.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<String, a> fMF = new HashMap();
    private static f<String, Bitmap> fMG = new f(10);
    private static x<String, Bitmap> fMH = new x(20);
    public Context context;
    public e fMC;
    private HashMap<String, String[]> fMD = new HashMap();
    private HashMap<String, String[]> fME = new HashMap();

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ String dhX;
        final /* synthetic */ i fKO;
        final /* synthetic */ pw fKP;
        final /* synthetic */ boolean fMJ = false;

        AnonymousClass3(boolean z, String str, i iVar, pw pwVar) {
            this.dhX = str;
            this.fKO = iVar;
            this.fKP = pwVar;
        }

        public final void run() {
            if (this.fMJ || g.tg(this.dhX)) {
                v.a(this.fKO, this.fKP, this.fMJ);
            }
        }

        public final String toString() {
            return super.toString() + "|getBigImg";
        }
    }

    static /* synthetic */ boolean tg(String str) {
        if (!new File(str).exists()) {
            a aVar = (a) fMF.get(str);
            if (aVar == null) {
                fMF.put(str, new a());
                return true;
            } else if (aVar.sn() > 30000) {
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.cgu = SystemClock.elapsedRealtime();
                return true;
            }
        }
        return false;
    }

    public g(Context context, int i) {
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.fMC = new e(i);
    }

    public final void destory() {
        e eVar = this.fMC;
        synchronized (eVar.cGJ) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ImageEngine", "do clear mark");
            eVar.lTn.clear();
            eVar.lTo.clear();
            eVar.lTn = new HashMap();
            eVar.lTo = new HashMap();
        }
        this.fMD.clear();
        this.fME.clear();
        this.fMC.destory();
        this.context = null;
        this.fMD = null;
        this.fME = null;
        this.fMC = null;
    }

    public final void a(ImageView imageView, final pw pwVar, final i iVar, String str, int i, int i2, int i3) {
        String sX = v.sX(pwVar.luu);
        String[] strArr = null;
        if (pwVar.luu != null) {
            String[] strArr2 = (String[]) this.fME.get(sX);
            if (strArr2 == null) {
                strArr = new String[]{v.g(pwVar)};
                this.fME.put(sX, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.fMC.a(imageView, strArr, str, i, i2, i3);
        if (strArr != null && strArr.length > 0) {
            final String str2 = strArr[0];
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ g fMI;

                public final void run() {
                    if (g.tg(str2)) {
                        v.b(iVar, pwVar, true);
                    }
                }

                public final String toString() {
                    return super.toString() + "|mAttachThumb";
                }
            });
        }
    }

    public final void a(ImageView imageView, pw pwVar, i iVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.sj()) {
                imageView.setImageResource(2130838791);
            } else if (iVar != null) {
                qe qeVar;
                switch (iVar.field_type) {
                    case 4:
                    case 16:
                        if (pwVar != null) {
                            a(imageView, pwVar, iVar, pwVar.aZh, i, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        qp qpVar = iVar.field_favProto.mtc;
                        if (pwVar != null) {
                            String str2;
                            if (qpVar != null) {
                                str = qpVar.bea;
                            }
                            if (be.kS(str)) {
                                str2 = pwVar.aZh;
                            } else {
                                str2 = str;
                            }
                            a(imageView, pwVar, iVar, str2, i, i2, i3);
                            return;
                        } else if (qpVar != null) {
                            this.fMC.a(imageView, null, qpVar.bea, i, i2, i3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (pwVar != null) {
                            a(imageView, pwVar, iVar, pwVar.aZh, i, i2, i3);
                            return;
                        }
                        return;
                    case 10:
                        qeVar = iVar.field_favProto.mte;
                        if (qeVar != null) {
                            this.fMC.a(imageView, null, qeVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        qeVar = iVar.field_favProto.mte;
                        if (qeVar != null) {
                            this.fMC.a(imageView, null, qeVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    case am.CTRL_INDEX /*15*/:
                        qj qjVar = iVar.field_favProto.mtg;
                        if (qjVar != null) {
                            this.fMC.a(imageView, null, qjVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(iVar.field_type)});
                        return;
                }
            }
        }
    }

    public final void b(ImageView imageView, final pw pwVar, final i iVar, int i, int i2, int i3) {
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.sj()) {
                imageView.setImageResource(2130838791);
            } else if (pwVar != null && iVar != null) {
                String str = pwVar.luu;
                if (str != null) {
                    String[] strArr;
                    if (pwVar.luu != null) {
                        String[] strArr2 = (String[]) this.fMD.get(str);
                        if (strArr2 == null) {
                            strArr = new String[]{v.f(pwVar), v.g(pwVar)};
                            this.fMD.put(str, strArr);
                        } else {
                            strArr = strArr2;
                        }
                    } else {
                        strArr = null;
                    }
                    this.fMC.a(imageView, strArr, null, i, i2, i3);
                    if (strArr != null && strArr.length > 0) {
                        final String str2 = strArr[0];
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ g fMI;

                            public final void run() {
                                if (g.tg(str2)) {
                                    v.a(iVar, pwVar, false);
                                }
                            }

                            public final String toString() {
                                return super.toString() + "|attachImg";
                            }
                        });
                    }
                }
            }
        }
    }

    private static Bitmap a(pw pwVar, boolean z, boolean z2) {
        String g;
        int i = 960;
        boolean z3 = true;
        if (z) {
            g = v.g(pwVar);
        } else {
            g = v.f(pwVar);
        }
        if (e.aR(g)) {
            Bitmap bitmap = (Bitmap) fMG.get(g);
            if (bitmap != null) {
                return bitmap;
            }
            if (z2) {
                return null;
            }
            int i2;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(g, options);
            if (bitmap != null) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[]{bitmap});
                bitmap.recycle();
            }
            boolean z4 = d.aZ(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z5;
            if (!d.aY(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z4 || r6) {
                i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                i2 = 960;
            }
            int JQ = ExifHelper.JQ(g);
            if (JQ == 90 || JQ == 270) {
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(g) && MMNativeJpeg.isProgressive(g)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(g);
                String str = "MicroMsg.FavoriteImageLogic";
                String str2 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z3 = false;
                }
                objArr[0] = Boolean.valueOf(z3);
                com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
            } else {
                bitmap = d.b(g, i2, i, false);
            }
            if (bitmap == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + g);
                return null;
            }
            bitmap = d.b(bitmap, (float) JQ);
            fMG.put(g, bitmap);
            return bitmap;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        return null;
    }

    public static Bitmap b(pw pwVar, i iVar, int i) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        if (pwVar.luu == null) {
            return null;
        }
        Bitmap bitmap;
        String f = v.f(pwVar);
        if (e.aR(f)) {
            bitmap = (Bitmap) fMG.get(f);
            if (bitmap != null) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[]{f});
            } else {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(f, options);
                if (bitmap != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[]{bitmap});
                    bitmap.recycle();
                }
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                if (i2 > i) {
                    i3 = (options.outHeight * i) / options.outWidth;
                } else {
                    i = i2;
                }
                i2 = Math.max(1, i);
                i3 = Math.max(1, i3);
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i3)});
                int JQ = ExifHelper.JQ(f);
                if (JQ == 90 || JQ == 270) {
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                }
                bitmap = d.b(f, i3, i2, false);
                if (bitmap == null) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + f);
                    bitmap = null;
                } else {
                    bitmap = d.b(bitmap, (float) JQ);
                    fMG.put(f, bitmap);
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        ak.vA().x(new AnonymousClass3(false, v.f(pwVar), iVar, pwVar));
        return bitmap;
    }

    public static Bitmap i(pw pwVar) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        if (pwVar.luu == null) {
            return null;
        }
        return a(pwVar, false, true);
    }

    public static Bitmap a(final pw pwVar, final i iVar, final boolean z) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        if (pwVar.luu == null) {
            return null;
        }
        Bitmap a = a(pwVar, false, false);
        if (a != null) {
            return a;
        }
        final String f = v.f(pwVar);
        ak.vA().x(new Runnable() {
            public final void run() {
                if (z || g.tg(f)) {
                    v.a(iVar, pwVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|getBigImg";
            }
        });
        return a;
    }

    public static Bitmap a(final pw pwVar, final i iVar) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        if (v.sX(pwVar.luu) == null) {
            return null;
        }
        Bitmap a = a(pwVar, true, false);
        if (a != null) {
            return a;
        }
        final String g = v.g(pwVar);
        ak.vA().x(new Runnable() {
            public final void run() {
                if (g.tg(g)) {
                    v.b(iVar, pwVar, true);
                }
            }

            public final String toString() {
                return super.toString() + "|getThumb";
            }
        });
        return a;
    }

    public static Bitmap a(String str, int i, int i2, boolean z) {
        IOException iOException;
        boolean z2 = false;
        if (e.aR(str)) {
            Bitmap bitmap = (Bitmap) fMH.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                com.tencent.mm.sdk.platformtools.v.d(str2, str3, objArr);
                return bitmap;
            }
            try {
                Bitmap decodeFile;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                d.decodeFile(str, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int JQ = ExifHelper.JQ(str);
                if (JQ == 90 || JQ == 270) {
                    z2 = true;
                    int i5 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i4 / options.inSampleSize > i2 && i3 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                int i6 = (i3 * i2) / i;
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6), Boolean.valueOf(z2)});
                if (i6 <= 0 || i4 <= i6) {
                    options.inJustDecodeBounds = false;
                    decodeFile = d.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i6;
                        rect.bottom = i3;
                    } else {
                        rect.right = i3;
                        rect.bottom = i6;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    decodeFile = newInstance.decodeRegion(rect, options);
                }
                if (decodeFile == null || !z2) {
                    bitmap = decodeFile;
                } else {
                    try {
                        bitmap = d.b(decodeFile, (float) JQ);
                    } catch (IOException e) {
                        IOException iOException2 = e;
                        bitmap = decodeFile;
                        iOException = iOException2;
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                        return bitmap;
                    }
                }
                if (bitmap != null) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2)});
                    fMH.put(str, bitmap);
                    return bitmap;
                }
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                return bitmap;
            } catch (IOException e2) {
                iOException = e2;
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                return bitmap;
            }
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImageLogic", "file not exist");
        return null;
    }

    public static void a(ImageView imageView, pw pwVar, i iVar, boolean z, int i, int i2) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791));
        }
        if (pwVar.luu == null) {
            imageView.setImageResource(2131165527);
        }
        final String f = v.f(pwVar);
        Bitmap a = a(f, i, i2, true);
        if (a == null) {
            imageView.setImageResource(2131165527);
            imageView.setTag(f);
            final int i3 = i;
            final int i4 = i2;
            final i iVar2 = iVar;
            final pw pwVar2 = pwVar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            ak.vA().x(new Runnable() {
                public final void run() {
                    final Bitmap a = g.a(f, i3, i4, false);
                    if (a == null) {
                        g.c(iVar2, pwVar2, z2);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(f)) {
                        ak.vA();
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 fMN;

                            public final void run() {
                                imageView2.setImageBitmap(a);
                            }
                        });
                    }
                }
            });
            return;
        }
        imageView.setImageBitmap(a);
    }

    private static void c(final i iVar, final pw pwVar, final boolean z) {
        final String f = v.f(pwVar);
        ak.vA().x(new Runnable() {
            public final void run() {
                if (z || g.tg(f)) {
                    v.a(iVar, pwVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|reDownload";
            }
        });
    }

    public static void a(i iVar, pw pwVar) {
        c(iVar, pwVar, true);
    }
}
