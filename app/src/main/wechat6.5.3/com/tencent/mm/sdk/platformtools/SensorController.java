package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jg.EType;
import com.jg.JgMethodChecked;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float nle = 4.2949673E9f;
    private static float nlg = 0.5f;
    public static boolean nln = false;
    public static double nlo = -1.0d;
    private Context context;
    private SensorManager dca;
    private float jxe = -1.0f;
    private float nlf;
    private a nlh;
    private Sensor nli;
    private final boolean nlj;
    private boolean nlk = false;
    public boolean nll = false;
    private float nlm = -1.0f;

    public interface a {
        void bZ(boolean z);
    }

    public SensorController(Context context) {
        if (context == null) {
            this.nlj = false;
            return;
        }
        boolean z;
        this.context = context;
        this.dca = (SensorManager) context.getSystemService("sensor");
        this.nli = this.dca.getDefaultSensor(8);
        if (this.nli != null) {
            this.jxe = Math.min(10.0f, this.nli.getMaximumRange());
        }
        if (this.jxe < 0.0f) {
            v.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.jxe));
            this.jxe = 1.0f;
        }
        if (this.nli != null) {
            z = true;
        } else {
            z = false;
        }
        this.nlj = z;
        this.nlf = nlg + 1.0f;
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public final void a(a aVar) {
        v.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.nll + ", proximitySensor: " + this.nli + ", maxValue: " + this.jxe);
        if (!this.nll) {
            this.nlm = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.dca.registerListener(this, this.nli, 2);
            this.nll = true;
        }
        this.nlh = aVar;
    }

    public final void btX() {
        v.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            v.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.dca.unregisterListener(this, this.nli);
        this.dca.unregisterListener(this);
        this.nll = false;
        this.nlh = null;
        this.nlm = -1.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.sensor != null && this.nli != null && !this.nlk) {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            v.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.jxe), Double.valueOf(3.0d), Double.valueOf(nlo), Float.valueOf(this.nlm), Float.valueOf(this.nli.getMaximumRange()));
            if (nlo > 0.0d) {
                d = nlo;
            }
            float maximumRange = (nlo > 0.0d || this.jxe < 0.0f) ? this.nli.getMaximumRange() : this.jxe;
            v.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.nlh != null && f != this.nlm) {
                        if (f < r0) {
                            v.i("MicroMsg.SensorController", "sensor near-far event near false");
                            this.nlh.bZ(false);
                        } else {
                            v.i("MicroMsg.SensorController", "sensor near-far event far true");
                            this.nlh.bZ(true);
                        }
                        this.nlm = f;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    this.nlk = true;
                }
                if (intExtra == 0) {
                    this.nlk = false;
                }
            }
        }
    }
}
