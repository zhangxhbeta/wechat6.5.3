package ct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

final class bv implements SensorEventListener {
    private static volatile bv e;
    private final SensorManager a;
    private final boolean b;
    private boolean c;
    private double d;

    public static bv a(Context context) {
        if (e == null) {
            e = new bv(context);
        }
        return e;
    }

    private bv(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
        this.b = this.a != null;
    }

    public final void a(Handler handler) {
        if (this.b && !this.c) {
            try {
                Sensor defaultSensor = this.a.getDefaultSensor(11);
                if (defaultSensor != null) {
                    this.a.registerListener(this, defaultSensor, 3, handler);
                    this.c = true;
                }
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
    }

    public final void a() {
        if (this.b && this.c) {
            this.c = false;
            this.d = Double.NaN;
            this.a.unregisterListener(this);
        }
    }

    public final double b() {
        if (!this.c) {
            return Double.NaN;
        }
        double d;
        synchronized (this) {
            d = this.d;
        }
        return d;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d = (double) fArr2[0];
                synchronized (this) {
                    this.d = (d * 180.0d) / 3.1415926d;
                }
            }
        } catch (Exception e) {
        } catch (Error e2) {
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
