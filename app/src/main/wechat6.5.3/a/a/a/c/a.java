package a.a.a.c;

import com.tencent.mm.ba.b;
import com.tencent.smtt.sdk.WebView;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    public final OutputStream cyK = null;
    public final byte[] pMp;
    private final a.a.a.b.b.a pMq;

    public a(byte[] bArr) {
        this.pMp = bArr;
        this.pMq = new a.a.a.b.b.a(bArr, 0, bArr.length);
    }

    public final void ab(int i, boolean z) {
        int i2 = 0;
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 0);
        if (z) {
            i2 = 1;
        }
        aVar.cv(i2);
    }

    public final void b(int i, b bVar) {
        a.a.a.b.b.a aVar = this.pMq;
        if (bVar != null) {
            aVar.an(i, 2);
            byte[] toByteArray = bVar.toByteArray();
            aVar.cx(toByteArray.length);
            aVar.i(toByteArray);
        }
    }

    public final void a(int i, double d) {
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        aVar.cv(((int) doubleToLongBits) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 8)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 16)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 24)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 32)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 40)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 48)) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv(((int) (doubleToLongBits >> 56)) & WebView.NORMAL_MODE_ALPHA);
    }

    public final void j(int i, float f) {
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        aVar.cv(floatToIntBits & WebView.NORMAL_MODE_ALPHA);
        aVar.cv((floatToIntBits >> 8) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv((floatToIntBits >> 16) & WebView.NORMAL_MODE_ALPHA);
        aVar.cv((floatToIntBits >> 24) & WebView.NORMAL_MODE_ALPHA);
    }

    public final void dV(int i, int i2) {
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 0);
        if (i2 >= 0) {
            aVar.cx(i2);
        } else {
            aVar.n((long) i2);
        }
    }

    public final void dW(int i, int i2) {
        dV(i, i2);
    }

    public final void C(int i, long j) {
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 0);
        aVar.n(j);
    }

    public final void e(int i, String str) {
        a.a.a.b.b.a aVar = this.pMq;
        if (str != null) {
            aVar.an(i, 2);
            byte[] bytes = str.getBytes("UTF-8");
            aVar.cx(bytes.length);
            aVar.i(bytes);
        }
    }

    public final void dX(int i, int i2) {
        a.a.a.b.b.a aVar = this.pMq;
        aVar.an(i, 2);
        aVar.cx(i2);
    }

    public final void d(int i, int i2, LinkedList<?> linkedList) {
        if (linkedList != null) {
            int i3;
            switch (i2) {
                case 1:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        e(i, (String) linkedList.get(i3));
                    }
                    return;
                case 2:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        dV(i, ((Integer) linkedList.get(i3)).intValue());
                    }
                    return;
                case 3:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        C(i, ((Long) linkedList.get(i3)).longValue());
                    }
                    return;
                case 4:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        a(i, ((Double) linkedList.get(i3)).doubleValue());
                    }
                    return;
                case 5:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        j(i, ((Float) linkedList.get(i3)).floatValue());
                    }
                    return;
                case 6:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        b(i, (b) linkedList.get(i3));
                    }
                    return;
                case 7:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        ab(i, ((Boolean) linkedList.get(i3)).booleanValue());
                    }
                    return;
                case 8:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        com.tencent.mm.ba.a aVar = (com.tencent.mm.ba.a) linkedList.get(i3);
                        dX(i, aVar.aHr());
                        aVar.a(this);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("The data type was not found, the id used was " + i2);
            }
        }
    }

    public final void c(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        if (linkedList != null && linkedList.size() > 0) {
            int i3;
            this.pMq.an(i, 2);
            a.a.a.b.b.a aVar = this.pMq;
            if (linkedList == null || linkedList.size() <= 0) {
                i3 = 0;
            } else {
                i3 = 0;
                int i4 = 0;
                while (i4 < linkedList.size()) {
                    int cy = a.a.a.b.b.a.cy(((Integer) linkedList.get(i4)).intValue()) + i3;
                    i4++;
                    i3 = cy;
                }
            }
            aVar.cx(i3);
            while (i2 < linkedList.size()) {
                this.pMq.cx(((Integer) linkedList.get(i2)).intValue());
                i2++;
            }
        }
    }
}
