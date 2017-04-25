package com.tencent.mm.plugin.scanner.b;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int iCS = 0;
    protected int aYV;
    protected int aYW;
    protected a iCO = null;
    protected byte[] iCP = null;
    protected byte[] iCQ = null;
    public String iCR;
    public boolean[] iCT = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] dmZ;
        final /* synthetic */ int iCU;
        final /* synthetic */ Point iCV;
        final /* synthetic */ Rect iCW;
        final /* synthetic */ b iCX;

        public AnonymousClass1(b bVar, byte[] bArr, int i, Point point, Rect rect) {
            this.iCX = bVar;
            this.dmZ = bArr;
            this.iCU = i;
            this.iCV = point;
            this.iCW = rect;
        }

        public final void run() {
            byte[] bArr = this.dmZ;
            if (270 == this.iCU) {
                byte[] bArr2 = new byte[this.dmZ.length];
                QbarNative.a(bArr2, this.dmZ, this.iCV.x, this.iCV.y);
                bArr = new byte[this.dmZ.length];
                QbarNative.a(bArr, bArr2, this.iCV.y, this.iCV.x);
                QbarNative.nativeRelease();
            }
            v.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", new Object[]{this.iCV.toString(), this.iCW.toString()});
            if (this.dmZ == null || !this.iCX.a(r0, this.iCV, this.iCW)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iCY;

                    {
                        this.iCY = r1;
                    }

                    public final void run() {
                        if (this.iCY.iCX.iCO != null) {
                            v.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", new Object[]{this.iCY.iCV.toString(), this.iCY.iCW.toString()});
                            this.iCY.iCX.iCO.aLh();
                        }
                    }
                });
            } else {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iCY;

                    {
                        this.iCY = r1;
                    }

                    public final void run() {
                        if (this.iCY.iCX.iCO != null) {
                            this.iCY.iCX.iCO.a(b.iCS, this.iCY.iCX.iCR, this.iCY.iCX.iCQ, this.iCY.iCX.aYV, this.iCY.iCX.aYW);
                        }
                    }
                });
            }
        }
    }

    public interface a {
        public static final boolean[] iCZ = new boolean[2];

        void a(int i, String str, byte[] bArr, int i2, int i3);

        void aLh();
    }

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void aLM();

    public abstract void aLN();

    public b(a aVar) {
        this.iCO = aVar;
    }
}
