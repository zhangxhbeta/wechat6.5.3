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

public final class s extends a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";
    SensorManager aHA;
    private Handler mHandler = new Handler(com.tencent.mm.plugin.appbrand.k.a.vA().htb.getLooper());

    private static abstract class b implements SensorEventListener, com.tencent.mm.plugin.appbrand.f.a {
        private com.tencent.mm.plugin.appbrand.k.b dGg;
        boolean dGk;
        private float[] dGl = new float[3];
        private float[] dGm = new float[3];
        a dGn = new a();

        b(f fVar) {
            this.dGn.a(fVar);
            this.dGg = new com.tencent.mm.plugin.appbrand.k.b((long) bx.Qo(), new com.tencent.mm.plugin.appbrand.k.b.a(this) {
                final /* synthetic */ b dGo;

                {
                    this.dGo = r1;
                }

                public final boolean h(Object... objArr) {
                    v.v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, this.dGo.dGl, this.dGo.dGm);
                    SensorManager.getOrientation(fArr2, fArr);
                    Map hashMap = new HashMap();
                    float toDegrees = (float) Math.toDegrees((double) fArr[0]);
                    if (toDegrees < 0.0f) {
                        toDegrees += 360.0f;
                    }
                    hashMap.put("direction", Float.valueOf(toDegrees));
                    this.dGo.dGn.o(hashMap);
                    return bx.Qn().a(this.dGo.dGn);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.dGk) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    v.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                    return;
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.dGm = sensorEvent.values;
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.dGl = sensorEvent.values;
                } else {
                    return;
                }
                boolean i = this.dGg.i(new Object[0]);
                v.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(i)});
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    private static class a extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onCompassChange";

        private a() {
        }
    }

    public final void a(final f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            if (this.aHA == null) {
                this.aHA = (SensorManager) fVar.mContext.getSystemService("sensor");
            }
            if (this.aHA == null) {
                v.i("MicroMsg.JsApiEnableCompass", "getSystemService(SENSOR_SERVICE) failed.");
                fVar.y(i, c("fail", null));
                return;
            }
            Sensor defaultSensor = this.aHA.getDefaultSensor(2);
            Sensor defaultSensor2 = this.aHA.getDefaultSensor(1);
            if (defaultSensor == null || defaultSensor2 == null) {
                v.i("MicroMsg.JsApiEnableCompass", "get compass or accelerometer sensor failed.");
                fVar.y(i, c("fail", null));
                return;
            }
            boolean z2;
            String c;
            String str = "JsApi#SensorMagneticField" + fVar.hashCode();
            com.tencent.mm.model.o.b n;
            if (z) {
                com.tencent.mm.model.o.b fx = o.yx().fx(str);
                if (fx == null) {
                    n = o.yx().n(str, true);
                } else {
                    n = fx;
                }
                if (((b) n.a("sensor_event_listener", b.class)) != null) {
                    v.w("MicroMsg.JsApiEnableCompass", "register failed, sensorEventListener has already registered.");
                    fVar.y(i, c("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.f.a anonymousClass1 = new b(this, fVar) {
                    final /* synthetic */ s dGj;

                    public final void onDestroy() {
                        fVar.b(this);
                        this.dGj.aHA.unregisterListener(this);
                    }
                };
                fVar.a(anonymousClass1);
                n.l("sensor_event_listener", anonymousClass1);
                z2 = this.aHA.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler) && this.aHA.registerListener(anonymousClass1, defaultSensor2, 3, this.mHandler);
                if (!z2) {
                    this.aHA.unregisterListener(anonymousClass1);
                    anonymousClass1.dGk = true;
                    fVar.b(anonymousClass1);
                    n.recycle();
                    o.yx().fy(str);
                }
                v.i("MicroMsg.JsApiEnableCompass", "register compass sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z2)});
            } else {
                n = o.yx().fy(str);
                if (n == null) {
                    v.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, keyValueSet do not exist.");
                    fVar.y(i, c("fail", null));
                    return;
                }
                b bVar = (b) n.a("sensor_event_listener", b.class);
                if (bVar == null) {
                    v.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, listener do not exist.");
                    fVar.y(i, c("fail", null));
                    return;
                }
                this.aHA.unregisterListener(bVar);
                fVar.b(bVar);
                bVar.dGk = true;
                n.recycle();
                v.i("MicroMsg.JsApiEnableCompass", "unregister compass sensor finished(%s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                c = c("ok", null);
            } else {
                c = c("fail", null);
            }
            fVar.y(i, c);
        } catch (JSONException e) {
            v.i("MicroMsg.JsApiEnableCompass", "json data do not contains parameter enable.");
            fVar.y(i, c("fail", null));
        }
    }
}
