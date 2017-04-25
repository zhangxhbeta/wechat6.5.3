package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.v;

public final class e implements a {
    public static e lTi = null;
    public boolean hasInit = false;
    private float[] lTe = new float[3];
    int lTf = -10000;
    int lTg = -10000;
    private SensorManager lTh;
    private SensorEventListener lpG;

    public final int bqP() {
        v.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.lTf);
        return this.lTf;
    }

    public final int getPitch() {
        v.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.lTg);
        return this.lTg;
    }

    public final void dm(Context context) {
        v.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            v.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            return;
        }
        if (this.lTh == null) {
            this.lTh = (SensorManager) context.getSystemService("sensor");
        }
        if (this.lpG == null) {
            this.lpG = new SensorEventListener(this) {
                final /* synthetic */ e lTj;

                {
                    this.lTj = r1;
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() == 3) {
                        this.lTj.lTe[0] = sensorEvent.values[0];
                        this.lTj.lTe[1] = sensorEvent.values[1];
                        this.lTj.lTe[2] = sensorEvent.values[2];
                        if (this.lTj.lTf == -10000) {
                            this.lTj.lTf = (int) this.lTj.lTe[0];
                        } else if (this.lTj.lTe[0] - ((float) this.lTj.lTf) > 300.0f || this.lTj.lTe[0] - ((float) this.lTj.lTf) < -300.0f) {
                            this.lTj.lTf = (int) this.lTj.lTe[0];
                        } else {
                            this.lTj.lTf = (int) ((((double) this.lTj.lTf) * 0.6d) + (((double) this.lTj.lTe[0]) * 0.4d));
                        }
                        if (this.lTj.lTf == 0) {
                            this.lTj.lTf = 1;
                        }
                        if (this.lTj.lTf == 365) {
                            this.lTj.lTf = 364;
                        }
                        if (this.lTj.lTg == -10000) {
                            this.lTj.lTg = (int) this.lTj.lTe[1];
                        } else if (this.lTj.lTe[1] < -68.0f) {
                            int i = (int) (-68.0d + (((double) (this.lTj.lTe[1] + 68.0f)) / 1.5d));
                            if (i < -89) {
                                i = -89;
                            }
                            this.lTj.lTg = i;
                        } else if (this.lTj.lTe[1] > 89.0f) {
                            this.lTj.lTg = 89;
                        } else {
                            this.lTj.lTg = (int) ((((double) this.lTj.lTg) * 0.6d) + (((double) this.lTj.lTe[1]) * 0.4d));
                        }
                    }
                }

                public final void onAccuracyChanged(Sensor sensor, int i) {
                    v.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
                }
            };
        }
        boolean registerListener = this.lTh.registerListener(this.lpG, this.lTh.getDefaultSensor(3), 3);
        this.hasInit = true;
        v.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[]{Boolean.valueOf(registerListener)});
    }

    private void bqQ() {
        v.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.lTh == null || this.lpG == null)) {
            v.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.lTh.unregisterListener(this.lpG);
            this.lTh = null;
            this.lpG = null;
        }
        this.hasInit = false;
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void bkO() {
        lTi = null;
        bqQ();
    }

    public final void cP(Context context) {
        dm(context);
    }

    public final void bkP() {
        bqQ();
    }
}
