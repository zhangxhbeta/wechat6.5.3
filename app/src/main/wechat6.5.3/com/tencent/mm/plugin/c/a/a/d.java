package com.tencent.mm.plugin.c.a.a;

import com.tencent.mm.sdk.platformtools.v;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> eoq = new HashMap();
    private b eor = null;

    public d(b bVar) {
        this.eor = bVar;
    }

    public final void a(int i, String str, e eVar) {
        v.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", new Object[]{null, Integer.valueOf(i)});
        if (eVar == null) {
            v.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            return;
        }
        c cVar = new c();
        cVar.eon = null;
        cVar.eoo = eVar;
        cVar.aOw = str;
        Vector vector;
        if (this.eoq.containsKey(cVar)) {
            vector = (Vector) this.eoq.get(cVar);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    a(vector, cVar);
                    return;
                } catch (Exception e) {
                    v.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", new Object[]{e.getMessage()});
                    return;
                } finally {
                    vector.clear();
                }
            } else {
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.eoq.put(cVar, vector);
    }

    private void a(Vector<Integer> vector, c cVar) {
        int i;
        int[] iArr;
        v.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i] = ((Integer) vector.elementAt(i)).intValue();
        }
        a aVar = new a(iArr2);
        if (1 == aVar.eom.length) {
            v.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.eom;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i2 : aVar.eom) {
                stringBuilder.append(" " + i2);
            }
            v.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            double e = i.e(aVar.eom, 5);
            double l = i.l(aVar.eom);
            double doubleValue = i.e(0.15d, l).add(new BigDecimal(e)).doubleValue();
            double doubleValue2 = i.e(3.09d, l).add(new BigDecimal(e)).doubleValue();
            v.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + e + "SD = " + l + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[aVar.eom.length];
            int i3 = 0;
            while (i3 < aVar.eom.length) {
                if (((double) aVar.eom[i3]) >= doubleValue && ((double) aVar.eom[i3]) <= doubleValue2) {
                    int i4 = i + 1;
                    iArr3[i] = aVar.eom[i3];
                    i = i4;
                }
                i3++;
            }
            Assert.assertTrue(i != 0);
            iArr2 = new int[i];
            for (i3 = 0; i3 < i; i3++) {
                iArr2[i3] = iArr3[i3];
            }
            stringBuilder = new StringBuilder("");
            stringBuilder.append("Data After GaussianFilter \r\n");
            for (int i22 : iArr2) {
                stringBuilder.append(" " + i22);
            }
            v.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == ret || 0 == ret.length");
        }
        double e2 = i.e(iArr, 5);
        cVar.eop = new BigDecimal(e2).divide(new BigDecimal(1), 3, 4).doubleValue();
        e = (1.0d * e2) / ((double) cVar.eoo.eot.eoX);
        if (e < 1.0d) {
            e = Math.pow(e, 10.0d);
        } else {
            e = (Math.pow(e, 9.9476d) * 0.92093d) + 0.54992d;
        }
        v.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", new Object[]{Double.valueOf(l), Double.valueOf(e2), Double.valueOf(e)});
        this.eor.a(e, cVar);
    }
}
