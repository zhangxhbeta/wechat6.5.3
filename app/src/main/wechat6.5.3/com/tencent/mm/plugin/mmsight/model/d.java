package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d {

    private static class a implements Comparator<Size> {
        private a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public static class b {
        public Point hnk;
        public Point hnl;
        public Point hnm;
        public Point pRb;
        public Point pRc;
        public Point pRd;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.hnk != null) {
                stringBuffer.append(this.hnk.toString() + ",");
            }
            if (this.hnl != null) {
                stringBuffer.append(this.hnl.toString() + ",");
            }
            if (this.hnm != null) {
                stringBuffer.append(this.hnm.toString() + ",");
            }
            if (this.pRb != null) {
                stringBuffer.append(this.pRb.toString() + ",");
            }
            if (this.pRc != null) {
                stringBuffer.append(this.pRc.toString() + ",");
            }
            if (this.pRd != null) {
                stringBuffer.append(this.pRd.toString() + ",");
            }
            return stringBuffer.toString();
        }
    }

    public static b a(Parameters parameters, Point point, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        v.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[]{com.tencent.mm.plugin.mmsight.b.aN(arrayList)});
        float f = ((float) point.x) / ((float) point.y);
        v.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)});
        long dX = be.dX(aa.getContext());
        v.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(dX)});
        b bVar = new b();
        bVar.hnk = a(arrayList, point, z, i);
        if (bVar.hnk != null) {
            bVar.hnl = com.tencent.mm.plugin.mmsight.b.a(point, bVar.hnk, z);
            bVar.hnm = com.tencent.mm.plugin.mmsight.b.a(point, bVar.hnk, z, true);
            i3 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y) {
                    Point a = com.tencent.mm.plugin.mmsight.b.a(point, point2, z);
                    if (a != null) {
                        v.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[]{point2, a});
                        bVar.pRc = new Point(a.x, a.y);
                        bVar.pRb = new Point(point2.x, point2.y);
                        bVar.pRd = com.tencent.mm.plugin.mmsight.b.a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < i2) {
                                return null;
                            }
                            bVar.hnk = new Point(point2.x, point2.y);
                            bVar.hnl = a;
                            bVar.hnm = com.tencent.mm.plugin.mmsight.b.a(point, bVar.hnk, z, true);
                            v.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[]{r5, a, Integer.valueOf(1)});
                            i3 = 1;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i3 = 0;
        }
        v.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[]{bVar.hnk, bVar.hnl, Integer.valueOf(i3)});
        return bVar;
    }

    private static Point a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            return null;
        }
        int i4;
        i2 = (i3 * i) / i2;
        if (z) {
            i4 = i ^ i2;
            i3 = i4 ^ i2;
            i2 = i4 ^ i3;
            i4 = i3;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.width == i3 && size.height == i4) {
                v.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                return new Point(i3, i4);
            } else if (Math.min(size.width, size.height) < i) {
                return null;
            }
        }
        return null;
    }
}
