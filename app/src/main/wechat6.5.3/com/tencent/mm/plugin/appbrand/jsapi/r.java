package com.tencent.mm.plugin.appbrand.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";
    private Handler mHandler = new Handler(com.tencent.mm.plugin.appbrand.k.a.vA().htb.getLooper());

    private static abstract class b implements SensorEventListener, com.tencent.mm.plugin.appbrand.f.a {
        private com.tencent.mm.plugin.appbrand.k.b dGg;
        a dGh = new a();

        b(f fVar) {
            this.dGh.a(fVar);
            this.dGg = new com.tencent.mm.plugin.appbrand.k.b((long) bx.Qo(), new com.tencent.mm.plugin.appbrand.k.b.a(this) {
                final /* synthetic */ b dGi;

                {
                    this.dGi = r1;
                }

                public final boolean h(Object... objArr) {
                    float[] fArr = (float[]) objArr[0];
                    Map hashMap = new HashMap();
                    hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
                    hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
                    hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
                    this.dGi.dGh.o(hashMap);
                    return bx.Qn().a(this.dGi.dGh);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    v.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                    return;
                }
                boolean i = this.dGg.i(fArr);
                v.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(i)});
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    private static class a extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAccelerometerChange";

        private a() {
        }
    }

    public final void a(final f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            final SensorManager sensorManager = (SensorManager) fVar.mContext.getSystemService("sensor");
            if (sensorManager == null) {
                v.i("MicroMsg.JsApiEnableAccelerometer", "getSystemService(SENSOR_SERVICE) failed.");
                fVar.y(i, c("fail", null));
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                v.i("MicroMsg.JsApiEnableAccelerometer", "get Accelerometer sensor failed.");
                fVar.y(i, c("fail", null));
                return;
            }
            boolean z2;
            String c;
            String str = "JsApi#SensorAccelerometer" + fVar.hashCode();
            com.tencent.mm.model.o.b n;
            if (z) {
                com.tencent.mm.model.o.b fx = o.yx().fx(str);
                if (fx == null) {
                    n = o.yx().n(str, true);
                } else {
                    n = fx;
                }
                if (((b) n.a("sensor_event_listener", b.class)) != null) {
                    v.w("MicroMsg.JsApiEnableAccelerometer", "register failed, sensorEventListener has already registered.");
                    fVar.y(i, c("fail, has enable, should stop pre operation", null));
                    return;
                }
                Object anonymousClass1 = new b(this, fVar) {
                    final /* synthetic */ r dGf;

                    public final void onDestroy() {
                        fVar.b(this);
                        sensorManager.unregisterListener(this);
                    }
                };
                fVar.a(anonymousClass1);
                n.l("sensor_event_listener", anonymousClass1);
                z = sensorManager.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler);
                if (!z) {
                    sensorManager.unregisterListener(anonymousClass1);
                    fVar.b(anonymousClass1);
                    n.recycle();
                    o.yx().fy(str);
                }
                v.i("MicroMsg.JsApiEnableAccelerometer", "register accelerometer sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z)});
                z2 = z;
            } else {
                n = o.yx().fy(str);
                if (n == null) {
                    v.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, keyValueSet do not exist.");
                    fVar.y(i, c("fail", null));
                    return;
                }
                b bVar = (b) n.a("sensor_event_listener", b.class);
                if (bVar == null) {
                    v.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, listener do not exist.");
                    fVar.y(i, c("fail", null));
                    return;
                }
                sensorManager.unregisterListener(bVar);
                fVar.b(bVar);
                n.recycle();
                v.i("MicroMsg.JsApiEnableAccelerometer", "unregister accelerometer sensor finished(s : %s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                c = c("ok", null);
            } else {
                c = c("fail", null);
            }
            fVar.y(i, c);
        } catch (JSONException e) {
            v.i("MicroMsg.JsApiEnableAccelerometer", "json data do not contains parameter enable.");
            fVar.y(i, c("fail", null));
        }
    }
}
