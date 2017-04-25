package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    int cdi;
    int fQm;
    int gVE;
    byte[] hnU;
    byte[] hnV;
    int hnW = 0;
    int hnX = 0;
    long hnY = be.Nj();
    int hnZ;
    int hoa;
    int hob;
    int hoc;
    boolean hod;
    boolean hoe;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a hof;
        final /* synthetic */ b hog;

        AnonymousClass1(b bVar, a aVar) {
            this.hog = bVar;
            this.hof = aVar;
        }

        public final void run() {
            b bVar = this.hog;
            v.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[]{Integer.valueOf(bVar.hnZ), Integer.valueOf(bVar.hoa), Integer.valueOf(bVar.gVE), Integer.valueOf(bVar.fQm), Integer.valueOf(bVar.hnX)});
            if (bVar.hob == 21 || bVar.hob == 2130706688) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.hnU, bVar.hnV, bVar.hnZ, bVar.hoa, bVar.gVE, bVar.fQm, 1, bVar.cdi, bVar.hoc, bVar.hoe, bVar.hod);
            } else if (bVar.hob == 19) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.hnU, bVar.hnV, bVar.hnZ, bVar.hoa, bVar.gVE, bVar.fQm, 2, bVar.cdi, bVar.hoc, bVar.hoe, bVar.hod);
            }
            v.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[]{Long.valueOf(be.az(bVar.hnY)), Integer.valueOf(bVar.hnU.length), Integer.valueOf(bVar.hnV.length), Integer.valueOf(bVar.hnX)});
            this.hof.a(this.hog);
            h.hoF.x(this.hog.hnU);
        }
    }

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        this.hob = i3;
        this.gVE = i4;
        this.fQm = i5;
        this.hnZ = i;
        this.hoa = i2;
        this.hoe = z2;
        this.hod = z;
        this.cdi = i6;
        this.hnU = bArr;
        this.hnW = bArr.length;
        this.hnV = h.hoF.h(Integer.valueOf(((i4 * i5) * 3) / 2));
    }
}
