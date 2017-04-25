package com.tencent.mm.plugin.scanner.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.mi;
import com.tencent.mm.e.a.mj;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g extends b {
    public Bitmap iDA;
    private Object iDB = new Object();
    private mj iDC;
    private boolean iDs = false;
    public boolean iDt;
    private boolean iDu;
    private byte[] iDv;
    public boolean[] iDw = new boolean[4];
    private boolean iDx;
    private boolean iDy;
    private boolean iDz;
    private int mCount = 0;

    public g(a aVar, boolean z, boolean z2) {
        super(aVar);
        this.iDt = z;
        this.iDu = z2;
        v.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", new Object[]{Boolean.valueOf(false), Boolean.valueOf(z)});
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        synchronized (this.iDB) {
            long currentTimeMillis = System.currentTimeMillis();
            v.d("MicroMsg.ScanBankCardDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (true == this.iDx) {
                v.d("MicroMsg.ScanBankCardDecoder", "recognize bank succeed, no need more handle");
                z = false;
            } else {
                long currentTimeMillis2;
                int focusedEngineForBankcardInit;
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.15f);
                int width = (((int) (((float) rect.width()) * min)) / 4) * 4;
                int height = (((int) (((float) rect.height()) * min)) / 4) * 4;
                v.d("MicroMsg.ScanBankCardDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.iDy) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    focusedEngineForBankcardInit = QbarNative.focusedEngineForBankcardInit(width, height, 8, this.iDs);
                    v.d("MicroMsg.ScanBankCardDecoder", "focusedEngineForBankcardInit, cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                    if (focusedEngineForBankcardInit != 0) {
                        v.e("MicroMsg.ScanBankCardDecoder", "init failed on init focusedEngine:" + focusedEngineForBankcardInit);
                        z = false;
                    } else {
                        this.iDy = true;
                    }
                }
                if (!this.iDz && true == this.iDy) {
                    v.d("MicroMsg.ScanBankCardDecoder", "init param:%d, %d, %d, %d, %s", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()), Boolean.valueOf(this.iDs)});
                    mk mkVar = new mk();
                    mkVar.bnC.width = width;
                    mkVar.bnC.height = height;
                    mkVar.bnC.bnE = this.iDs;
                    com.tencent.mm.sdk.c.a.nhr.z(mkVar);
                    if (mkVar.bnD.aYJ != 0) {
                        v.e("MicroMsg.ScanBankCardDecoder", "init failed on init recognize bank card:" + mkVar.bnD.aYJ);
                        z = false;
                    } else {
                        this.iDz = true;
                    }
                }
                if (this.iDv == null || this.iDv.length != ((width * height) * 3) / 2) {
                    this.iDv = new byte[(((width * height) * 3) / 2)];
                }
                if (this.iDC == null) {
                    this.iDC = new mj();
                }
                v.d("MicroMsg.ScanBankCardDecoder", "crop image start:%d, %d, dataLen:%d", new Object[]{Integer.valueOf(rect.left - ((width - rect.width()) / 2)), Integer.valueOf(rect.top - ((height - rect.height()) / 2)), Integer.valueOf(bArr.length)});
                long currentTimeMillis3 = System.currentTimeMillis();
                int QIPUtilYUVCrop = QbarNative.QIPUtilYUVCrop(this.iDv, bArr, point.x, point.y, r6, r7, width, height);
                v.d("MicroMsg.ScanBankCardDecoder", "QIPUtilYUVCrop cost: " + (System.currentTimeMillis() - currentTimeMillis3));
                if (QIPUtilYUVCrop != 0) {
                    v.e("MicroMsg.ScanBankCardDecoder", "crop image failed:" + QIPUtilYUVCrop);
                    z = false;
                } else {
                    String value = j.sU().getValue("debug_scan_bank");
                    if (value != null && value.equals("true")) {
                        this.mCount++;
                        a(bArr, point.x, point.y, this.mCount, "_scanImage_org.jpeg");
                        a(this.iDv, width, height, this.mCount, "_scanImage.jpeg");
                    }
                    currentTimeMillis2 = System.currentTimeMillis();
                    focusedEngineForBankcardInit = QbarNative.focusedEngineProcess(this.iDv);
                    v.d("MicroMsg.ScanBankCardDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                    if (focusedEngineForBankcardInit == 0) {
                        v.d("MicroMsg.ScanBankCardDecoder", "image number not enough");
                        z = false;
                    } else if (1 != focusedEngineForBankcardInit) {
                        for (QIPUtilYUVCrop = 0; QIPUtilYUVCrop < 4; QIPUtilYUVCrop++) {
                            this.iDw[QIPUtilYUVCrop] = false;
                        }
                        v.d("MicroMsg.ScanBankCardDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        v.d("MicroMsg.ScanBankCardDecoder", "image is clear enough");
                        for (QIPUtilYUVCrop = 0; QIPUtilYUVCrop < 4; QIPUtilYUVCrop++) {
                            this.iDw[QIPUtilYUVCrop] = false;
                        }
                        currentTimeMillis2 = System.currentTimeMillis();
                        this.iDC.bnv.width = rect.width();
                        this.iDC.bnv.height = rect.height();
                        this.iDC.bnv.bnx = this.iDv;
                        this.iDC.bnv.bny = this.iDw;
                        this.iDC.bnv.bnz = this.iDu;
                        com.tencent.mm.sdk.c.a.nhr.z(this.iDC);
                        v.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        if (!this.iDt) {
                            z = this.iDw[0];
                            this.iDw[0] = this.iDw[2];
                            this.iDw[2] = z;
                            z = this.iDw[1];
                            this.iDw[1] = this.iDw[3];
                            this.iDw[3] = z;
                        }
                        if (1 != this.iDC.bnw.aYJ) {
                            v.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + this.iDC.bnw.aYJ);
                            z = false;
                        } else {
                            long currentTimeMillis4 = System.currentTimeMillis();
                            Options options = new Options();
                            options.inSampleSize = 1;
                            this.iDA = BitmapFactory.decodeByteArray(this.iDC.bnw.bitmapData, 0, this.iDC.bnw.bitmapLen, options).copy(Config.ARGB_8888, true);
                            int[] iArr = this.iDC.bnw.rectX;
                            int[] iArr2 = this.iDC.bnw.rectY;
                            height = (iArr[this.iDC.bnw.cardNumLen - 1] - iArr[0]) + (iArr[1] - iArr[0]);
                            QIPUtilYUVCrop = (int) (((float) height) * 0.21319798f);
                            int i = (int) (((float) iArr[0]) - (((float) height) * 0.04568528f));
                            int i2 = i > 0 ? i : 0;
                            i = ((int) (((float) (height * 2)) * 0.04568528f)) + height;
                            focusedEngineForBankcardInit = (int) ((((((float) (iArr[1] - iArr[0])) * 1.3333334f) / 2.0f) + ((float) iArr2[0])) - ((float) (QIPUtilYUVCrop / 2)));
                            if (focusedEngineForBankcardInit <= 0) {
                                focusedEngineForBankcardInit = 0;
                            }
                            if (i2 + i > this.iDC.bnw.width) {
                                i = this.iDC.bnw.width - i2;
                            }
                            if (focusedEngineForBankcardInit + QIPUtilYUVCrop > this.iDC.bnw.height) {
                                QIPUtilYUVCrop = this.iDC.bnw.height - focusedEngineForBankcardInit;
                            }
                            this.iDA = Bitmap.createBitmap(this.iDA, i2, focusedEngineForBankcardInit, i, QIPUtilYUVCrop);
                            iCS = 3;
                            if (this.iDu) {
                                this.iCR = this.iDC.bnw.bnA;
                            } else {
                                this.iCR = this.iDC.bnw.bnB;
                            }
                            this.iDx = true;
                            v.d("MicroMsg.ScanBankCardDecoder", "scan bank succeed, result:" + this.iCR);
                            v.d("MicroMsg.ScanBankCardDecoder", "crop bitmap cost: " + (System.currentTimeMillis() - currentTimeMillis4));
                            v.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public final void aLM() {
        synchronized (this.iDB) {
            if (true == this.iDy) {
                QbarNative.focusedEngineRelease();
                this.iDy = false;
            }
            if (true == this.iDz) {
                com.tencent.mm.sdk.c.a.nhr.z(new mi());
                this.iDz = false;
            }
            this.iDv = null;
            this.iDA = null;
        }
    }

    public final void aLN() {
        aLM();
    }

    private static void a(byte[] bArr, int i, int i2, int i3, String str) {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        v.d("MicroMsg.ScanBankCardDecoder", "decode() compress jpeg by YuvImage");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/test/" + String.valueOf(i3) + str));
            try {
                fileOutputStream2.write(toByteArray);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e22) {
                    v.a("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                }
            } catch (IOException e3) {
                e22 = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    v.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e22.getMessage()});
                    v.a("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e222) {
                            v.a("MicroMsg.ScanBankCardDecoder", e222, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2222) {
                        v.a("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                    }
                } catch (Throwable th) {
                    e2222 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.ScanBankCardDecoder", e4, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e42) {
                        v.a("MicroMsg.ScanBankCardDecoder", e42, "", new Object[0]);
                    }
                    throw e2222;
                }
            } catch (Throwable th2) {
                e2222 = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw e2222;
            }
        } catch (IOException e5) {
            e2222 = e5;
            v.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e2222.getMessage()});
            v.a("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            byteArrayOutputStream.close();
        }
    }
}
