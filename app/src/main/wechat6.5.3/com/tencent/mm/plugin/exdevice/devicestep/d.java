package com.tencent.mm.plugin.exdevice.devicestep;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d implements SensorEventListener {
    private static int cfs = 0;
    private static int frA = 0;
    private static long frB = 0;
    private static long frC = 0;
    private static long frD = 0;
    private static int frE = 0;
    private static int frF = 0;
    private static long frG = 0;
    private x ceL = new x();
    private a frH;
    public long frI = 0;

    public static int aiG() {
        return frF;
    }

    public static long aiH() {
        return frG;
    }

    public static int aiI() {
        return cfs;
    }

    public d() {
        frG = 0;
        frD = 0;
        frE = 0;
        frF = 0;
    }

    public final void a(x xVar, a aVar) {
        this.ceL = xVar;
        if (this.ceL != null) {
            cfs = this.ceL.cfs;
        }
        this.frH = aVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (this.ceL.cfs != 1) {
            if (this.frH != null) {
                this.frH.aiB();
            }
            v.i("MicroMsg.exdevice.StepDetector", "[hakon][Step]Step change switch off");
        } else if (sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length <= 0) {
            a(sensorEvent);
        } else {
            long bul = be.bul() / 10000;
            v.i("MicroMsg.exdevice.StepDetector", "[hakon][Step]Step change %f, accuracy %s, %s", new Object[]{Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            if (frG != bul || frC != ((long) sensorEvent.values[0])) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = this.ceL.cfp;
                if (currentTimeMillis - this.frI < 90000) {
                    i /= 4;
                }
                if (Math.abs(currentTimeMillis - frB) > ((long) i)) {
                    long j = r.getLong(202, 0);
                    if (frG == 0) {
                        frG = j;
                    }
                    if (frE == 0) {
                        frE = r.getInt(203, 0);
                    }
                    if (frF == 0) {
                        frF = r.getInt(201, 0);
                    }
                    if (((float) frF) != sensorEvent.values[0]) {
                        frC = (long) sensorEvent.values[0];
                        String str = "MicroMsg.exdevice.StepDetector";
                        String str2 = "[hakon][Step]Step change, %s, %s, spToday %s, %s, time %s, %s, %s";
                        Object[] objArr = new Object[7];
                        objArr[0] = Boolean.valueOf(frG == bul);
                        objArr[1] = Integer.valueOf(frE);
                        objArr[2] = Integer.valueOf(frF);
                        objArr[3] = Long.valueOf(frC);
                        objArr[4] = Long.valueOf(frG);
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = Integer.valueOf(sensorEvent.accuracy);
                        v.i(str, str2, objArr);
                        if (frG != bul) {
                            v.i("MicroMsg.exdevice.StepDetector", "[hakon][Step] new day todayTime:%s,beginOfToday:%s", new Object[]{Long.valueOf(frG), Long.valueOf(bul)});
                            r.i(202, bul);
                            frG = bul;
                            r.ar(201, 0);
                            frF = 0;
                            if (frC < 0 || frC >= ((long) this.ceL.cfq)) {
                                v.i("MicroMsg.exdevice.StepDetector", "[hakon][Step] invalid cacheStep=%d", new Object[]{Long.valueOf(frC)});
                            } else {
                                r.ar(203, (int) frC);
                                frE = (int) frC;
                            }
                        } else {
                            if (frD == 0) {
                                frD = r.getLong(204, 0);
                            }
                            if (frG != j) {
                                r.i(202, frG);
                            }
                            long j2 = ((long) ((currentTimeMillis - frD) % 300000 > 0 ? 1 : 0)) + ((currentTimeMillis - frD) / 300000);
                            v.i("MicroMsg.exdevice.StepDetector", "[step] timesOf5Minute(%s).", new Object[]{Long.valueOf(j2)});
                            if (frC < 0 || frC - ((long) frE) > ((long) this.ceL.cfr) * j2) {
                                v.e("MicroMsg.exdevice.StepDetector", "[hakon][step] invalid value %s, %s, interval %s, %s", new Object[]{Long.valueOf(frC), Integer.valueOf(frE), Long.valueOf((currentTimeMillis - frD) / 1000), Integer.valueOf(frA)});
                                a(sensorEvent);
                                if (j2 < 0) {
                                    v.i("MicroMsg.exdevice.StepDetector", "[step] exchange last step time to (%s).", new Object[]{Long.valueOf(currentTimeMillis)});
                                    r.i(204, currentTimeMillis);
                                    frD = currentTimeMillis;
                                    frB = currentTimeMillis;
                                }
                                if (frA <= 0) {
                                    frA++;
                                    return;
                                }
                                r.ar(203, (int) frC);
                                frE = (int) frC;
                                frA = 0;
                                return;
                            }
                            if (r.getLong(205, 0) > frD) {
                                v.i("MicroMsg.exdevice.StepDetector", "[hakon][step] reboot step %s %s", new Object[]{Long.valueOf(r.getLong(205, 0)), Long.valueOf(frD)});
                                if (frC > j2 * ((long) this.ceL.cfr)) {
                                    v.i("MicroMsg.exdevice.StepDetector", "[hakon][step] reboot cache step too large");
                                } else {
                                    frF = (int) (((long) frF) + frC);
                                    r.ar(201, frF);
                                }
                                frE = (int) frC;
                                r.ar(203, frE);
                                frA = 0;
                            } else if (frC >= ((long) frE)) {
                                i = (int) (((long) frF) + (frC - ((long) frE)));
                                v.i("MicroMsg.exdevice.StepDetector", "[hakon][step] update step %s", new Object[]{Integer.valueOf(i)});
                                r.ar(201, i);
                                frF = i;
                                r.ar(203, (int) frC);
                                frE = (int) frC;
                                frA = 0;
                            } else if (frA > 0 || frC < 10) {
                                r.ar(203, (int) frC);
                                frE = (int) frC;
                                frA = 0;
                                return;
                            } else {
                                frA++;
                                return;
                            }
                        }
                        r.i(204, currentTimeMillis);
                        frD = currentTimeMillis;
                        frB = currentTimeMillis;
                    }
                }
            }
        }
    }

    private static void a(SensorEvent sensorEvent) {
        boolean z = false;
        if (sensorEvent == null || sensorEvent.values == null) {
            String str = "MicroMsg.exdevice.StepDetector";
            String str2 = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(sensorEvent == null);
            if (sensorEvent != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            return;
        }
        v.e("MicroMsg.exdevice.StepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[]{Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
        float[] fArr = sensorEvent.values;
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            r10 = new Object[2];
            int i3 = i2 + 1;
            r10[0] = Integer.valueOf(i2);
            r10[1] = Float.valueOf(f);
            v.e("MicroMsg.exdevice.StepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
            i++;
            i2 = i3;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
