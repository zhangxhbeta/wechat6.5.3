package com.tencent.mm.plugin.scanner.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class k extends b {
    private Object cCN = new Object();
    private boolean gdv = false;
    public boolean hoe = true;
    private boolean iAf = false;
    private float iBk = 1.0f;
    private final int iDR = 25;
    private boolean iDS = false;
    private final int iDT = 1;
    private int iDU = 0;
    private boolean iDV;
    private byte[] iDf;
    private long iyi;
    private int outHeight;
    private int outWidth;
    private int quality = 50;

    public k(a aVar, int i, float f, boolean z, boolean z2) {
        super(aVar);
        this.quality = i;
        this.iBk = f;
        this.hoe = z2;
        this.iDV = z;
        v.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], scaleRate = [%s], needRotate = [%s], ocrMode=[%s]", new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z2), Boolean.valueOf(z)});
    }

    @TargetApi(8)
    public final boolean a(byte[] bArr, Point point, Rect rect) {
        if (this.gdv) {
            v.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            return false;
        }
        this.gdv = true;
        if (bArr == null || point == null || rect == null) {
            boolean z;
            String str = "MicroMsg.scanner.ScanImageDecoder";
            String str2 = "decode() data null:[%s], resolution null:[%s], coverage null:[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(bArr == null);
            if (point == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (rect == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            this.gdv = false;
            return false;
        }
        try {
            if (this.iDU <= 0) {
                this.iDU++;
                this.gdv = false;
                return false;
            }
            synchronized (this.cCN) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (c.rt() || this.hoe) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.gdv = false;
                        return false;
                    }
                }
                rect2.left = (point.x / 2) - rect.height();
                rect2.right = (point.x / 2) + rect.height();
                rect2.top = (point.y / 2) - (rect.width() / 2);
                rect2.bottom = (point.y / 2) + (rect.width() / 2);
                if (rect2.left < 0) {
                    rect2.left = 0;
                }
                if (rect2.right > point.x - 1) {
                    rect2.right = point.x - 1;
                }
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
                if (rect2.bottom > point.y - 1) {
                    rect2.bottom = point.y - 1;
                }
                width = rect2.width() % 4;
                height = rect2.height() % 4;
                if (width != 0) {
                    rect2.right -= width;
                }
                if (height != 0) {
                    rect2.bottom -= height;
                }
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    this.gdv = false;
                    return false;
                }
                c.a cVar = new c(bArr, point.x, point.y, rect2);
                if (cVar.height == 0 || cVar.width == 0) {
                    this.gdv = false;
                    return false;
                } else if (this.iAf) {
                    v.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    return false;
                } else {
                    byte[] aLP = cVar.aLP();
                    if (aLP == null) {
                        this.gdv = false;
                        return false;
                    }
                    if (!this.iDS) {
                        if (c.rt()) {
                            width = b(rect2.width(), rect2.height(), this.iDV, pc(p.ceA.ccT));
                            v.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.iDV), Integer.valueOf(p.ceA.ccT)});
                        } else {
                            width = b(rect2.height(), rect2.width(), this.iDV, pc(p.ceA.ccT));
                            v.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.iDV), Integer.valueOf(p.ceA.ccT)});
                        }
                        if (width == -1) {
                            v.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", new Object[]{Integer.valueOf(width)});
                            return false;
                        }
                        this.iDS = true;
                    }
                    a.iCZ[0] = false;
                    a.iCZ[1] = false;
                    long Nj = be.Nj();
                    QbarNative.FocusPro(aLP, c.rt(), a.iCZ);
                    v.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", new Object[]{Boolean.valueOf(a.iCZ[0]), Boolean.valueOf(a.iCZ[1]), Long.valueOf(be.az(Nj))});
                    if (this.iyi == 0) {
                        this.iyi = System.currentTimeMillis();
                    }
                    if (!a.iCZ[1] && System.currentTimeMillis() - this.iyi > 9000) {
                        v.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        a.iCZ[1] = true;
                        this.iyi = System.currentTimeMillis();
                    }
                    if (a.iCZ[0]) {
                        if (this.iAf) {
                            v.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            return false;
                        }
                        this.outWidth = cVar.width;
                        this.outHeight = cVar.height;
                        int i = 0;
                        width = 0;
                        if (!c.rt()) {
                            i = 1;
                            this.outWidth = cVar.height;
                            this.outHeight = cVar.width;
                        }
                        if (((double) this.iBk) < 0.9d) {
                            width = 1;
                            this.outWidth /= 2;
                            this.outHeight /= 2;
                        }
                        if (this.iDf == null) {
                            this.iDf = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            v.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        } else if (this.iDf.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.iDf = null;
                            this.iDf = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            v.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        }
                        v.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", new Object[]{Integer.valueOf(QbarNative.a(this.iDf, aLP, this.outWidth, this.outHeight, width)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(width)});
                        if (QbarNative.a(this.iDf, aLP, this.outWidth, this.outHeight, width) != 1) {
                            this.iCQ = null;
                            this.gdv = false;
                            return false;
                        } else if (this.iAf) {
                            v.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            return false;
                        } else {
                            if (f.dW(8)) {
                                com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a(this) {
                                    final /* synthetic */ k iDW;

                                    {
                                        this.iDW = r1;
                                    }

                                    public final void run() {
                                        FileOutputStream fileOutputStream;
                                        Throwable e;
                                        FileOutputStream fileOutputStream2 = null;
                                        YuvImage yuvImage = new YuvImage(this.iDW.iDf, 17, this.iDW.outWidth, this.iDW.outHeight, null);
                                        v.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by YuvImage");
                                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        yuvImage.compressToJpeg(new Rect(0, 0, this.iDW.outWidth, this.iDW.outHeight), this.iDW.quality, byteArrayOutputStream);
                                        this.iDW.iCQ = byteArrayOutputStream.toByteArray();
                                        try {
                                            if (q.dpX) {
                                                fileOutputStream = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage.JPEG"));
                                                try {
                                                    fileOutputStream.write(this.iDW.iCQ);
                                                    fileOutputStream.flush();
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    fileOutputStream2 = fileOutputStream;
                                                    try {
                                                        v.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e.getMessage()});
                                                        v.a("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
                                                        if (fileOutputStream2 != null) {
                                                            try {
                                                                fileOutputStream2.close();
                                                            } catch (Throwable e3) {
                                                                v.a("MicroMsg.scanner.ScanImageDecoder", e3, "", new Object[0]);
                                                            }
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Throwable e32) {
                                                            v.a("MicroMsg.scanner.ScanImageDecoder", e32, "", new Object[0]);
                                                            return;
                                                        }
                                                    } catch (Throwable th) {
                                                        e32 = th;
                                                        if (fileOutputStream2 != null) {
                                                            try {
                                                                fileOutputStream2.close();
                                                            } catch (Throwable e4) {
                                                                v.a("MicroMsg.scanner.ScanImageDecoder", e4, "", new Object[0]);
                                                            }
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Throwable e42) {
                                                            v.a("MicroMsg.scanner.ScanImageDecoder", e42, "", new Object[0]);
                                                        }
                                                        throw e32;
                                                    }
                                                } catch (Throwable th2) {
                                                    e32 = th2;
                                                    fileOutputStream2 = fileOutputStream;
                                                    if (fileOutputStream2 != null) {
                                                        fileOutputStream2.close();
                                                    }
                                                    byteArrayOutputStream.close();
                                                    throw e32;
                                                }
                                            }
                                            fileOutputStream = null;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Throwable e322) {
                                                    v.a("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                                                }
                                            }
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Throwable e3222) {
                                                v.a("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                                            }
                                        } catch (IOException e5) {
                                            e3222 = e5;
                                            v.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e3222.getMessage()});
                                            v.a("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            byteArrayOutputStream.close();
                                        }
                                    }
                                });
                            } else {
                                v.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                c cVar2 = new c(this.iDf, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(cVar2.width * cVar2.height)];
                                QbarNative.a(cVar2.iDa, iArr, cVar2.iDb, cVar2.iDc, cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(cVar2.width, cVar2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, cVar2.width, 0, 0, cVar2.width, cVar2.height);
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.iCQ = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (q.dpX) {
                                    d.a(createBitmap, this.quality, CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            v.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", new Object[]{Integer.valueOf(this.iCQ.length)});
                            this.gdv = false;
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", new Object[]{e.toString()});
            v.a("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        }
        this.iCQ = null;
        this.gdv = false;
        return false;
    }

    public final void aLM() {
        v.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.iAf = true;
        if (this.cCN != null) {
            synchronized (this.cCN) {
                if (this.iDS) {
                    v.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", new Object[]{Integer.valueOf(0)});
                    this.iDS = false;
                    v.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(QbarNative.FocusRelease())});
                }
            }
        }
        this.iDf = null;
        c.aLO();
        v.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
    }

    public final void aLN() {
        if (this.iDS) {
            aLM();
        }
        this.gdv = false;
        this.iAf = false;
        this.iDS = false;
    }

    private static int b(int i, int i2, boolean z, int i3) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        if (i3 == 1) {
            return QbarNative.FocusInit(i, i2, z, 6, com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX);
        }
        if (i3 == 2) {
            return QbarNative.FocusInit(i, i2, z, 8, 120);
        }
        if (i3 == 4) {
            return QbarNative.FocusInit(i, i2, z, 13, 80);
        }
        if (i3 == 5) {
            return QbarNative.FocusInit(i, i2, z, 15, 65);
        }
        return QbarNative.FocusInit(i, i2, z, 10, 100);
    }

    private static int pc(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
