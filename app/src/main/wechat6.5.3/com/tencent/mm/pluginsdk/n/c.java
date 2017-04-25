package com.tencent.mm.pluginsdk.n;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c {
    private SensorManager lFK;
    private a lFL;

    public static abstract class a implements SensorEventListener {
        private static int lFO;
        private final float[] lFM = new float[]{2.0f, 2.5f, 0.5f};
        private float[] lFN = new float[3];

        public abstract void aDu();

        public abstract void onRelease();

        public static void reset() {
            v.d("MicroMsg.ShakeSensorListener", "reset threadHold");
            lFO = 5;
            if (Build.MODEL.equals("LG-E510")) {
                lFO = 4;
            }
        }

        static {
            lFO = 5;
            if (Build.MODEL.equals("LG-E510")) {
                lFO = 4;
            }
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = new float[3];
            float[] fArr2 = sensorEvent.values;
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i2] = (float) Math.round((this.lFM[i2] * (fArr2[i2] - this.lFN[i2])) * 0.45f);
                float abs = Math.abs(fArr[i2]);
                if (abs >= 4.0f) {
                    v.v("MicroMsg.ShakeSensorListener", "result:" + abs + " THREAHOLD:" + lFO);
                }
                if (lFO < 9) {
                    if (abs >= 14.0f) {
                        lFO = 9;
                    } else {
                        int i3 = (int) abs;
                        if (lFO < i3 - 4) {
                            lFO = i3 - 4;
                        }
                    }
                }
                if (abs > ((float) lFO)) {
                    i = 1;
                }
                this.lFN[i2] = fArr2[i2];
            }
            if (i != 0) {
                v.d("MicroMsg.ShakeSensorListener", "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
                aDu();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public c(Context context) {
        this.lFK = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean bos() {
        return this.lFL != null;
    }

    public final void bot() {
        if (this.lFL != null) {
            a.reset();
        }
    }

    public final void a(a aVar) {
        arf();
        if (bov()) {
            this.lFL = aVar;
            this.lFK.registerListener(this.lFL, this.lFK.getDefaultSensor(1), 0);
            return;
        }
        v.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    }

    public final void arf() {
        if (this.lFL != null) {
            this.lFL.onRelease();
            this.lFK.unregisterListener(this.lFL, this.lFK.getDefaultSensor(1));
            this.lFL = null;
        }
    }

    public final boolean bou() {
        return bov();
    }

    private boolean bov() {
        if (this.lFK == null) {
            v.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            return false;
        }
        List sensorList = this.lFK.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        return true;
    }
}
