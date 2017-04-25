package com.tencent.mm.plugin.sns.lucky.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import java.io.InputStream;

public final class a implements b {
    private static Point jgb = null;
    ac handler = new ac(Looper.getMainLooper());
    Bitmap jfE;
    Bitmap jfF;
    aib jfX;
    a jgk;
    boolean jgl = true;

    public interface a {
        void aRx();

        void aRy();

        void aRz();

        void fR(boolean z);
    }

    static /* synthetic */ void b(a aVar) {
        try {
            String aRv = aVar.aRv();
            String aRw = aVar.aRw();
            String aRo = aVar.aRo();
            v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, originBitmapFilePath: %s, blurBitmapFilePath: %s, bigBitmapFilePath: %s", new Object[]{aRw, aRv, aRo});
            aVar.jgl = FileOp.aR(aRw);
            if (aVar.jgl && FileOp.aR(aRo)) {
                v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, local origin small and big bitmap exist, need blur");
                aVar.al(aRw, false);
            } else {
                v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, local origin small bitmap not exist!!!");
                if (FileOp.aR(aRo)) {
                    v.d("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, local origin small bitmap not exist!!! clip from big bitmap");
                    aVar.jfE = d.b(aRo, 200, 200, false);
                    d.a(aVar.jfE, 70, CompressFormat.JPEG, aRw, false);
                    aVar.fQ(true);
                } else {
                    v.d("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, local origin small bitmap not exist!!! big bitmap not exist, need download");
                }
            }
            if (!FileOp.aR(aRo)) {
                v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, local origin bitmap not exist, need download");
                e eVar = new e(aVar.jfX);
                eVar.jdN = aVar.jfX.gID;
                ad.aSz().a(aVar);
                ad.aSz().a(aVar.jfX, 2, eVar, ak.nvx);
                v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "downloadBigImage, mediaObj.id: %s", new Object[]{aVar.jfX.gID});
            }
        } catch (Exception e) {
            v.e("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal error: %s", new Object[]{e.getMessage()});
            aVar.aRu();
        }
    }

    private void al(String str, boolean z) {
        v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "blurFromLocalOriginPic, filename: %s", new Object[]{str});
        this.jfE = i.zS(str).wm();
        fQ(z);
    }

    private void fQ(boolean z) {
        if (this.jfE != null) {
            Bitmap bitmap;
            Bitmap bitmap2;
            int i;
            Bitmap bitmap3 = this.jfE;
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (bitmap3.isMutable()) {
                bitmap = null;
            } else {
                bitmap = Bitmap.createBitmap(bitmap3.getWidth(), bitmap3.getHeight(), Config.ARGB_8888);
            }
            int width = bitmap3.getWidth();
            int height = bitmap3.getHeight();
            int i2 = height / 10;
            int[] iArr = new int[(width * height)];
            bitmap3.getPixels(iArr, 0, width, 0, 0, width, height);
            if (bitmap != null) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = bitmap3;
            }
            for (int i3 = 0; i3 < width; i3++) {
                i = 0;
                while (i < height) {
                    if (i <= i2 || i >= height - i2) {
                        int i4 = (i * width) + i3;
                        int i5 = iArr[i4];
                        iArr[i4] = Color.argb(Math.min(255, Math.max(0, (int) (((float) ((Math.sin((((double) (i <= i2 ? ((float) i) / ((float) i2) : 1.0f - (((float) (i - i2)) / ((float) i2)))) * 3.141592653589793d) - 1.5707963267948966d) + 1.0d) / 2.0d)) * ((float) Color.alpha(i5))))), Color.red(i5), Color.green(i5), Color.blue(i5));
                    }
                    i++;
                }
            }
            bitmap2.setPixels(iArr, 0, bitmap2.getWidth(), 0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            v.d("MicroMsg.SnsLuckyBigBlurImgLoader", "fadeEdge used %dms, fadeLen: %s, width: %s, height: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(i2), Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight())});
            int i6 = Math.max(bitmap3.getWidth(), bitmap3.getHeight()) <= 300 ? 15 : Math.max(bitmap3.getWidth(), bitmap3.getHeight()) <= 400 ? 20 : 25;
            bitmap3 = d.c(bitmap2, i6);
            v.d("MicroMsg.SnsLuckyBigBlurImgLoader", "blur used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.jfF = bitmap3;
            d.a(this.jfF, 70, CompressFormat.JPEG, aRv(), false);
            try {
                String aRw = aRw();
                String aRo = aRo();
                String aRv = aRv();
                if (FileOp.aR(aRo)) {
                    if (this.jfE == null) {
                        this.jfE = i.zS(aRw).wm();
                    }
                    if (this.jfF == null) {
                        this.jfF = i.zS(aRv).wm();
                    }
                    height = this.jfE.getWidth();
                    i = this.jfE.getHeight();
                    InputStream openRead = FileOp.openRead(aRo);
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeStream(openRead, null, options, null, 0, new int[0]);
                    i6 = options.outWidth;
                    int i7 = options.outHeight;
                    float f = ((float) i6) / ((float) height);
                    float f2 = ((float) i7) / ((float) i);
                    if (jgb == null) {
                        jgb = new Point();
                        ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getSize(jgb);
                    }
                    width = jgb.x / 3;
                    if ((f <= 1.0f || f2 <= 1.0f) && (height < width || i < width)) {
                        v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "scaleBitmapIfNeed, too small, xScale: %s, yScale: %s, smallBitmapWidth: %s, smallBitmapHeight: %s, sizeLimit: %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(height), Integer.valueOf(i), Integer.valueOf(width)});
                        i6 = i;
                        i7 = height;
                        while (true) {
                            if (i7 >= width && i6 >= width) {
                                break;
                            }
                            i7 *= 2;
                            i6 *= 2;
                        }
                        this.jfE = Bitmap.createScaledBitmap(this.jfE, i7, i6, true);
                        d.a(this.jfE, 70, CompressFormat.JPEG, aRw, false);
                        d.a(this.jfE, 70, CompressFormat.JPEG, aRo, false);
                        this.jfF = Bitmap.createScaledBitmap(this.jfF, i7, i6, true);
                        d.a(this.jfF, 70, CompressFormat.JPEG, aRv, false);
                        v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "after scale, smallBitmapWidth: %s, smallBitmapHeight: %s", new Object[]{Integer.valueOf(i7), Integer.valueOf(i6)});
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.SnsLuckyBigBlurImgLoader", "scaleBitmapIfNeed error: %s", new Object[]{e.getMessage()});
            }
            this.jfF = null;
            this.jfE = null;
            if (z) {
                aRt();
                return;
            }
            return;
        }
        v.e("MicroMsg.SnsLuckyBigBlurImgLoader", "blurFromLocalOriginPic, local origin bitmap is null!");
        FileOp.deleteFile(aRw());
        FileOp.deleteFile(al.cA(ad.xh(), this.jfX.gID) + i.c(this.jfX));
        aRu();
    }

    final void aRt() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a jgm;

            {
                this.jgm = r1;
            }

            public final void run() {
                if (this.jgm.jgk != null) {
                    this.jgm.jgk.aRy();
                }
            }
        });
    }

    private void aRu() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a jgm;

            {
                this.jgm = r1;
            }

            public final void run() {
                if (this.jgm.jgk != null) {
                    this.jgm.jgk.aRz();
                }
            }
        });
    }

    final String aRv() {
        return al.cA(ad.xh(), this.jfX.gID) + i.g(this.jfX);
    }

    private String aRw() {
        return al.cA(ad.xh(), this.jfX.gID) + i.h(this.jfX);
    }

    final String aRo() {
        return al.cA(ad.xh(), this.jfX.gID) + i.b(this.jfX);
    }

    public final void Aa(String str) {
    }

    public final void ai(String str, boolean z) {
        String str2 = "MicroMsg.SnsLuckyBigBlurImgLoader";
        String str3 = "onImageFinish, snsId: %s, isOk: %s, mediaObj.id: %s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = this.jfX != null ? this.jfX.gID : "";
        v.d(str2, str3, objArr);
        if (z && this.jfX != null && str.equals(this.jfX.gID)) {
            v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "onImageFinish, start blur, bigBitmapFileExist: %b, isLocalOriginBitmapExist: %b", new Object[]{Boolean.valueOf(FileOp.aR(aRo())), Boolean.valueOf(this.jgl)});
            if (this.jgk != null) {
                this.jgk.fR(z);
            }
            try {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                        final /* synthetic */ a jgm;

                        {
                            this.jgm = r1;
                        }

                        public final void run() {
                            try {
                                String d = this.jgm.aRw();
                                if (this.jgm.jgl) {
                                    this.jgm.al(d, true);
                                    return;
                                }
                                this.jgm.jfE = d.b(this.jgm.aRo(), 200, 200, false);
                                d.a(this.jgm.jfE, 70, CompressFormat.JPEG, d, false);
                                this.jgm.fQ(true);
                            } catch (Throwable e) {
                                v.a("MicroMsg.SnsLuckyBigBlurImgLoader", e, "", new Object[0]);
                                v.e("MicroMsg.SnsLuckyBigBlurImgLoader", "onImageFinish, blurFromLocalOriginPic error: %s", new Object[]{e.getMessage()});
                                this.jgm.aRu();
                            }
                        }
                    }, "onImageFinish_blurFromLocalBigPic");
                }
            } catch (Exception e) {
                v.e("MicroMsg.SnsLuckyBigBlurImgLoader", "onImageFinish error: %s", new Object[]{e.getMessage()});
                aRu();
            }
        } else if (!z && this.jfX != null && str.equals(this.jfX.gID)) {
            aRu();
        }
    }

    public final void aRc() {
    }

    public final void aj(String str, boolean z) {
    }

    public static boolean q(aib com_tencent_mm_protocal_c_aib) {
        return FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.g(com_tencent_mm_protocal_c_aib));
    }
}
