package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import java.util.List;

public final class av {
    private SensorManager lFK;
    private a nlp;

    static class a implements SensorListener {
        private Runnable bpT;
        private float[] lFN = new float[]{0.0f, 0.0f, 0.0f};

        public a(Runnable runnable) {
            this.bpT = runnable;
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            Object obj = null;
            float[] fArr2 = new float[3];
            int i2 = 0;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.lFN[i2]);
                if (this.lFN[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    v.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.lFN[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.bpT.run();
            }
        }
    }

    public av(Context context) {
        this.lFK = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean F(Runnable runnable) {
        if (this.lFK == null) {
            return false;
        }
        List sensorList = this.lFK.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        this.nlp = new a(runnable);
        this.lFK.registerListener(this.nlp, 2, 3);
        return true;
    }

    public final void btY() {
        if (this.lFK != null && this.nlp != null) {
            this.lFK.unregisterListener(this.nlp, 2);
        }
    }
}
