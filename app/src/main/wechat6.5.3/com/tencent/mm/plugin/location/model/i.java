package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private SensorManager aHA = ((SensorManager) aa.getContext().getSystemService("sensor"));
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ i gSj;

        {
            this.gSj = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            if (!(this.gSj.gSf == -1000.0d || this.gSj.gSg == -1000.0d)) {
                this.gSj.gSi = f.a(this.gSj.gSg, this.gSj.gSf, (double) f, (double) f2, i, d);
            }
            this.gSj.gSf = (double) f2;
            this.gSj.gSg = (double) f;
            if (this.gSj.gSe == 900.0d || this.gSj.gSd == 900.0d) {
                i iVar = this.gSj;
                i iVar2 = this.gSj;
                double g = f.g((double) f2, (double) f);
                iVar2.gSd = g;
                iVar.gSe = g;
            } else {
                this.gSj.gSe = this.gSj.gSd;
                this.gSj.gSd = f.g((double) f2, (double) f);
            }
            v.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[]{Double.valueOf(this.gSj.gSd), Double.valueOf(this.gSj.gSe), Boolean.valueOf(this.gSj.gSi)});
            return true;
        }
    };
    private c cCR;
    HashSet<WeakReference<a>> dKi = new HashSet();
    private b gSc = new b(this);
    double gSd = 900.0d;
    double gSe = 900.0d;
    double gSf = -1000.0d;
    double gSg = -1000.0d;
    double gSh = 0.0d;
    boolean gSi = false;

    public interface a {
        void f(double d);
    }

    protected class b implements SensorEventListener {
        private float dKD = 0.0f;
        final /* synthetic */ i gSj;
        private long timestamp = 200;

        protected b(i iVar) {
            this.gSj = iVar;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i = 0;
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float af = k.af(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(af - this.dKD) > 3.0f) {
                    i iVar = this.gSj;
                    float f = this.dKD;
                    iVar.gSh = (double) af;
                    String str = "MicroMsg.OrientationSensorMgr";
                    String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Float.valueOf(f);
                    objArr[1] = Float.valueOf(af);
                    if (iVar.dKi != null) {
                        i = iVar.dKi.size();
                    }
                    objArr[2] = Integer.valueOf(i);
                    v.d(str, str2, objArr);
                    if (iVar.dKi != null) {
                        Iterator it = iVar.dKi.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((a) weakReference.get()).f(iVar.awb());
                            }
                        }
                    }
                    this.dKD = af;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public final double awb() {
        if (this.gSi) {
            v.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[]{Double.valueOf(this.gSd)});
            return this.gSd;
        }
        v.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[]{Double.valueOf(this.gSh)});
        return this.gSh;
    }

    private void awc() {
        v.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.cCR == null) {
            this.cCR = c.FY();
        }
        this.cCR.a(this.bYl);
        this.aHA.registerListener(this.gSc, this.aHA.getDefaultSensor(3), 1);
    }

    final void awd() {
        v.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.aHA.unregisterListener(this.gSc);
        c.FY().c(this.bYl);
    }

    public final void a(a aVar) {
        Iterator it = this.dKi.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return;
            }
        }
        this.dKi.add(new WeakReference(aVar));
        v.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[]{Integer.valueOf(this.dKi.size())});
        if (this.dKi.size() == 1) {
            awc();
        }
    }

    public final void b(a aVar) {
        if (this.dKi != null && aVar != null) {
            Iterator it = this.dKi.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                    this.dKi.remove(weakReference);
                    break;
                }
            }
            v.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[]{Integer.valueOf(this.dKi.size())});
            if (this.dKi.size() == 0) {
                awd();
            }
        }
    }
}
