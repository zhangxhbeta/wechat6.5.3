package com.tencent.mm.plugin.scanner.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class l extends b {
    private final int iDX;
    private Bitmap iDY;
    public Bitmap iDZ;
    public boolean[] iDw = new boolean[4];
    private boolean iDx = false;
    private boolean iDz = false;
    private final Object lock = new Object();

    public l(a aVar, int i) {
        super(aVar);
        this.iDX = i;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        v.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[]{point, rect, Integer.valueOf(bArr.length)});
        synchronized (this.lock) {
            if (!(this.iDY == null || this.iDY.isRecycled())) {
                v.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
                this.iDY.recycle();
            }
            v.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (this.iDx) {
                v.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                z = false;
            } else {
                int i;
                for (i = 0; i < 4; i++) {
                    this.iDw[i] = false;
                }
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                int width = rect.width();
                int height = rect.height();
                v.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.iDz) {
                    v.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
                    try {
                        LibCardRecog.recognizeCardInit(width, height, this.iDX);
                        this.iDz = true;
                    } catch (Exception e) {
                        v.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", new Object[]{e});
                        this.iDz = false;
                        aLY();
                        z = false;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                CardInfo cardInfo = new CardInfo(width, height);
                int i2 = rect.top;
                try {
                    i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.iDw);
                    v.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", new Object[]{Integer.valueOf(i)});
                    v.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    v.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", new Object[]{Arrays.toString(this.iDw)});
                    if (i == 0) {
                        z = false;
                    } else if (1 != i) {
                        for (i = 0; i < 4; i++) {
                            this.iDw[i] = false;
                        }
                        v.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        for (i = 0; i < 4; i++) {
                            this.iDw[i] = true;
                        }
                        this.iDY = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                        this.iDZ = this.iDY.copy(Config.ARGB_8888, true);
                        this.iDx = true;
                        z = true;
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", new Object[]{e2});
                    this.iDx = false;
                    z = false;
                }
            }
        }
        return z;
    }

    public final void aLM() {
        if (!(this.iDY == null || this.iDY.isRecycled())) {
            this.iDY.recycle();
        }
        aLY();
    }

    public final void aLN() {
        this.iDx = false;
    }

    private static void aLY() {
        v.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
        } catch (Exception e) {
            v.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[]{e});
        }
    }
}
