package com.tencent.mm.plugin.scanner.b;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.mo;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;

public final class d extends b {
    private Object cCN = new Object();
    public boolean gdv = false;
    public boolean hoe = true;
    public boolean iAf = false;
    private boolean iDd = false;
    private QbarNative iDe = null;
    private byte[] iDf;
    byte[] iDg;
    int[] iDh = null;
    private int iDi = 0;
    private i iDj = new i();
    private int mMode = 0;

    public d(a aVar, int i, boolean z) {
        super(aVar);
        this.mMode = i;
        this.hoe = z;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        this.aYW = 0;
        this.aYV = 0;
        v.i("MicroMsg.scanner.QBarDecoder", "decode, isNeedFocus: %s", new Object[]{Boolean.valueOf(this.iDj.a(bArr, point, rect, this.hoe))});
        mo moVar = new mo();
        moVar.bnN.bnO = r0;
        com.tencent.mm.sdk.c.a.nhr.z(moVar);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a = a(bArr, point, rect, false, true);
        this.iDi++;
        if (!a && System.currentTimeMillis() - currentTimeMillis <= 80) {
            a = a(bArr, point, rect, true, false);
            this.iDi = 0;
        }
        if (a || this.iDi < 3) {
            return a;
        }
        a = a(bArr, point, rect, true, false);
        this.iDi = 0;
        return a;
    }

    private boolean a(byte[] bArr, Point point, Rect rect, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        v.i("MicroMsg.scanner.QBarDecoder", "decode() start");
        if (this.gdv) {
            v.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
            return false;
        } else if (this.iAf) {
            v.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
            return false;
        } else if (bArr == null || point == null || rect == null) {
            v.e("MicroMsg.scanner.QBarDecoder", "wrong args");
            return false;
        } else {
            this.gdv = true;
            this.iCR = null;
            if (z2) {
                l.iwj.aKU();
            }
            try {
                synchronized (this.cCN) {
                    int height;
                    Rect rect2 = new Rect();
                    int width;
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
                    if (cl(this.mMode, 0)) {
                        c cVar = new c(bArr, point.x, point.y, rect2);
                        int[] iArr = new int[]{cVar.width, cVar.height};
                        int i = 0;
                        if (!(c.rt() || z)) {
                            i = 90;
                            iArr[0] = cVar.height;
                            iArr[1] = cVar.width;
                        }
                        v.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
                        if (this.iDf == null) {
                            this.iDf = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                            this.iDg = new byte[(cVar.width * cVar.height)];
                            v.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                        } else if (this.iDf.length != ((cVar.width * cVar.height) * 3) / 2) {
                            this.iDf = null;
                            this.iDf = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                            this.iDg = null;
                            this.iDg = new byte[(cVar.width * cVar.height)];
                            v.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                        }
                        v.d("MicroMsg.scanner.QBarDecoder", "decode prepare , cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (QbarNative.a(this.iDf, iArr, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 1) {
                            v.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[]{Integer.valueOf(QbarNative.a(this.iDf, iArr, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i))});
                            this.gdv = false;
                            return false;
                        }
                        long j;
                        System.arraycopy(this.iDf, 0, this.iDg, 0, this.iDg.length);
                        v.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (this.iDg != null) {
                            v.d("MicroMsg.scanner.QBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[]{Integer.valueOf(this.iDg.length), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                        }
                        if (this.iDg != null) {
                            if (q.dqU) {
                                String str = e.cnj + "testScan/";
                                FileOp.jS(str);
                                FileOp.l((str + q.dqW) + "_" + iArr[0] + "_" + iArr[1], this.iDg);
                                q.dqW = (q.dqW + 1) % q.dqV;
                                v.i("MicroMsg.scanner.QBarDecoder", "save test scan data in file: %s", new Object[]{str});
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            int g = this.iDe.g(this.iDg, iArr[0], iArr[1]);
                            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                            l.iwj.ci(iArr[0], iArr[1]);
                            l.iwj.aKV();
                            long j2 = currentTimeMillis2;
                            height = g;
                            j = j2;
                        } else {
                            height = -1;
                            j = 0;
                        }
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        l.iwj.cx(j);
                        v.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", new Object[]{Integer.valueOf(height), Long.valueOf(currentTimeMillis3)});
                        if (height != 1) {
                            this.gdv = false;
                            return false;
                        }
                        l.iwj.aKT();
                        l.iwj.cy(j);
                        aLR();
                    } else {
                        aLM();
                        this.gdv = false;
                        return false;
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.scanner.QBarDecoder", e, "decodeInternal error", new Object[0]);
            }
        }
        this.gdv = false;
        v.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", new Object[]{this.iCR, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (be.kS(this.iCR)) {
            return false;
        }
        return true;
    }

    private boolean cl(int i, int i2) {
        if (!this.iDd) {
            this.iDe = new QbarNative();
            QbarNative qbarNative = this.iDe;
            String str = "ANY";
            String str2 = "UTF-8";
            if (qbarNative.ptu < 0) {
                qbarNative.ptu = qbarNative.Init(2, 0, i2, str, str2);
            }
            int i3 = qbarNative.ptu < 0 ? -1 : 1;
            if (i == 1) {
                if (i2 != 1) {
                    this.iDh = new int[3];
                    this.iDh[0] = 2;
                    this.iDh[1] = 3;
                    this.iDh[2] = 4;
                } else {
                    this.iDh = new int[2];
                    this.iDh[0] = 2;
                    this.iDh[1] = 3;
                }
            } else if (i == 2) {
                if (i2 != 1) {
                    this.iDh = new int[3];
                    this.iDh[0] = 0;
                    this.iDh[1] = 3;
                    this.iDh[2] = 4;
                } else {
                    this.iDh = new int[2];
                    this.iDh[0] = 0;
                    this.iDh[1] = 3;
                }
            } else if (i2 != 1) {
                this.iDh = new int[4];
                this.iDh[0] = 2;
                this.iDh[1] = 0;
                this.iDh[2] = 3;
                this.iDh[3] = 4;
            } else {
                this.iDh = new int[3];
                this.iDh[0] = 2;
                this.iDh[1] = 0;
                this.iDh[2] = 3;
            }
            QbarNative qbarNative2 = this.iDe;
            v.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s], readers: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(qbarNative2.SetReaders(this.iDh, this.iDh.length, qbarNative2.ptu)), QbarNative.getVersion(), Arrays.toString(this.iDh)});
            if (i3 <= 0 || r3 <= 0) {
                v.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                return false;
            }
            this.iDd = true;
        }
        return this.iDd;
    }

    private void aLR() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        int[] iArr = new int[2];
        if (this.iDe.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr) == 1) {
            v.d("MicroMsg.scanner.QBarDecoder", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", new Object[]{stringBuilder.toString(), stringBuilder3.toString(), stringBuilder4.toString(), stringBuilder2.toString(), Integer.valueOf(this.iDe.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr))});
            if (!be.kS(stringBuilder2.toString())) {
                if (stringBuilder.toString().equals("QR_CODE")) {
                    this.iCR = stringBuilder2.toString();
                    iCS = 1;
                } else {
                    this.iCR = stringBuilder.toString() + "," + stringBuilder2;
                    iCS = 2;
                }
            }
            this.aYV = q.zb(stringBuilder.toString());
            this.aYW = iArr[0];
        }
        l lVar = l.iwj;
        String stringBuilder5 = stringBuilder.toString();
        String str = this.iCR;
        String stringBuilder6 = stringBuilder3.toString();
        int i = iArr[0];
        int i2 = iArr[1];
        v.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", new Object[]{stringBuilder5, str, stringBuilder6, Integer.valueOf(i), Integer.valueOf(i2), stringBuilder4.toString()});
        lVar.iwq = stringBuilder5;
        lVar.iwr = str;
        lVar.iws = stringBuilder6;
        lVar.iwt = i;
        lVar.iwu = i2;
        lVar.iwv = r4;
    }

    public final void aLM() {
        v.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[]{Boolean.valueOf(this.iDd)});
        this.iAf = true;
        synchronized (this.cCN) {
            if (this.iDd) {
                QbarNative qbarNative = this.iDe;
                int Release = qbarNative.Release(qbarNative.ptu);
                this.iDe = null;
                this.iDd = false;
                v.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[]{Integer.valueOf(Release)});
                v.d("MicroMsg.scanner.QBarDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(QbarNative.nativeRelease())});
            }
            this.iDj.release();
        }
        this.iDf = null;
        this.iDg = null;
        c.aLO();
    }

    public final void aLN() {
        if (this.iDd) {
            aLM();
            this.iDd = false;
        }
        this.iAf = false;
        this.gdv = false;
    }

    public final com.tencent.mm.plugin.g.a.d a(c.a aVar) {
        com.tencent.mm.plugin.g.a.d dVar = new com.tencent.mm.plugin.g.a.d();
        synchronized (this.cCN) {
            try {
                this.iCR = null;
                if (cl(0, 1)) {
                    int i;
                    v.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc==null:%b", new Object[]{Boolean.valueOf(false)});
                    if (aVar.aLQ() != null) {
                        v.i("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", new Object[]{Integer.valueOf(aVar.aLQ().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height)});
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aVar.aLQ() == null || aVar.width * aVar.height != aVar.aLQ().length) {
                        i = -1;
                    } else {
                        l.iwj.ci(aVar.width, aVar.height);
                        i = this.iDe.g(aVar.aLQ(), aVar.width, aVar.height);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    v.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg decode ScanImage %s, cost: %s", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                    l.iwj.cx(currentTimeMillis2 - currentTimeMillis);
                    l.iwj.aKU();
                    if (i != 1) {
                        this.gdv = false;
                        dVar = null;
                    } else {
                        l.iwj.aKT();
                        l.iwj.cy(currentTimeMillis2 - currentTimeMillis);
                        aLR();
                        dVar.bfz = this.iCR;
                        dVar.aYV = this.aYV;
                        dVar.aYW = this.aYW;
                    }
                } else {
                    aLM();
                    this.gdv = false;
                    dVar = null;
                }
            } catch (Throwable e) {
                v.e("MicroMsg.scanner.QBarDecoder", " Exception in directScanQRCodeImg() " + e.getMessage());
                v.a("MicroMsg.scanner.QBarDecoder", e, "", new Object[0]);
            }
        }
        return dVar;
    }
}
