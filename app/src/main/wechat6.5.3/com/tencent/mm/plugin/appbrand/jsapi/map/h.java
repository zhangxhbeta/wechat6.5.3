package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.d;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    private class b implements SensorEventListener {
        int bhH;
        com.tencent.mm.model.o.b dHx;
        private float dKD = 0.0f;
        final /* synthetic */ h dKu;
        private long timestamp = 200;

        public b(h hVar, int i, com.tencent.mm.model.o.b bVar) {
            this.dKu = hVar;
            this.bhH = i;
            this.dHx = bVar;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float af = k.af(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(af - this.dKD) > 3.0f) {
                    AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) this.dHx.a(this.bhH, AppbrandMapLocationPoint.class);
                    if (appbrandMapLocationPoint != null) {
                        float f = this.dKD;
                        float f2 = (f < 0.0f || f > 45.0f || af < 315.0f || af >= 360.0f) ? af : af - 360.0f;
                        if ((f < 0.0f || f > 45.0f || af < 315.0f || af >= 360.0f) && f >= 315.0f && f < 360.0f && af >= 0.0f && af <= 45.0f) {
                            f -= 360.0f;
                        }
                        Animation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.7f);
                        rotateAnimation.setDuration(200);
                        rotateAnimation.setFillAfter(true);
                        appbrandMapLocationPoint.dKk.startAnimation(rotateAnimation);
                    }
                    this.dKD = af;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    private static class a extends e {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";

        private a() {
        }
    }

    private static class c extends e {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";

        private c() {
        }
    }

    protected final View a(com.tencent.mm.plugin.appbrand.page.h hVar, JSONObject jSONObject) {
        float f = be.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = be.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            v.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            return null;
        }
        int optInt = jSONObject.optInt("scale", 16);
        View inflate = LayoutInflater.from(hVar.getContext()).inflate(2130903107, null);
        SoSoMapView soSoMapView = (SoSoMapView) inflate.findViewById(2131755380);
        soSoMapView.getIController().setCenter((double) f, (double) f2);
        soSoMapView.getIController().setZoom(optInt);
        soSoMapView.setVisibility(0);
        soSoMapView.getMap().b(new com.tencent.tencentmap.mapsdk.map.g.h(this) {
            final /* synthetic */ h dKu;

            {
                this.dKu = r1;
            }

            public final boolean a(Marker marker) {
                String str = (String) marker.getTag();
                if (str != null && str.equals("cover")) {
                    return true;
                }
                if (be.kS(marker.getTitle()) && be.kS(marker.getSnippet())) {
                    return true;
                }
                if (marker.isInfoWindowShown()) {
                    marker.hideInfoWindow();
                } else {
                    marker.showInfoWindow();
                }
                return false;
            }
        });
        return inflate;
    }

    protected final String a(com.tencent.mm.plugin.appbrand.page.h hVar, boolean z, int i, String str) {
        if (z) {
            Map hashMap = new HashMap();
            hashMap.put("mapId", Integer.valueOf(i));
            return c("ok", hashMap);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("mapId");
    }

    protected final void b(com.tencent.mm.plugin.appbrand.page.h hVar, int i, View view, JSONObject jSONObject) {
        final SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
        com.tencent.mm.model.o.b a = a(hVar, i, true);
        if (jSONObject.optBoolean("showLocation")) {
            final com.tencent.mm.model.o.b a2 = a(hVar, i, true);
            final int i2 = i;
            final com.tencent.mm.plugin.appbrand.page.h hVar2 = hVar;
            AnonymousClass5 anonymousClass5 = new com.tencent.mm.plugin.appbrand.jsapi.map.a.a(this) {
                final /* synthetic */ h dKu;

                public final void d(double d, double d2) {
                    View appbrandMapLocationPoint;
                    v.d("MicroMsg.JsApiInsertMap", "refresh location latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
                    View view = (View) a2.a(i2, AppbrandMapLocationPoint.class);
                    if (view == null) {
                        appbrandMapLocationPoint = new AppbrandMapLocationPoint(hVar2.getContext());
                        soSoMapView.addView(appbrandMapLocationPoint, d, d2);
                        a2.l(i2, appbrandMapLocationPoint);
                    } else {
                        appbrandMapLocationPoint = view;
                    }
                    if (appbrandMapLocationPoint instanceof AppbrandMapLocationPoint) {
                        AppbrandMapLocationPoint appbrandMapLocationPoint2 = (AppbrandMapLocationPoint) appbrandMapLocationPoint;
                        soSoMapView.updateViewLayout(appbrandMapLocationPoint, d, d2);
                        appbrandMapLocationPoint2.dKk.setImageResource(2130838485);
                        if (appbrandMapLocationPoint2.dKn == -1.0d && appbrandMapLocationPoint2.dKo == -1.0d) {
                            appbrandMapLocationPoint2.dKn = d;
                            appbrandMapLocationPoint2.dKl = d;
                            appbrandMapLocationPoint2.dKo = d2;
                            appbrandMapLocationPoint2.dKm = d2;
                            return;
                        }
                        appbrandMapLocationPoint2.dKn = appbrandMapLocationPoint2.dKl;
                        appbrandMapLocationPoint2.dKo = appbrandMapLocationPoint2.dKm;
                        appbrandMapLocationPoint2.dKm = d2;
                        appbrandMapLocationPoint2.dKl = d;
                    }
                }
            };
            a OP = com.tencent.mm.plugin.appbrand.a.a.OP();
            Iterator it = OP.dKi.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.map.a.a) it.next();
                if (aVar != null && aVar.equals(anonymousClass5)) {
                    break;
                }
            }
            OP.dKi.add(anonymousClass5);
            v.i("MicroMsg.AppbrandMapLocationMgr", "registerLocationListener %d", new Object[]{Integer.valueOf(OP.dKi.size())});
            if (OP.dKi.size() == 1) {
                v.i("MicroMsg.AppbrandMapLocationMgr", "registerLocation ");
                OP.dKg.requestLocationUpdates(TencentLocationRequest.create(), OP.dKh);
            }
            final Object bVar = new b(this, i, a2);
            final SensorManager sensorManager = (SensorManager) aa.getContext().getSystemService("sensor");
            sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(3), 1);
            if (((com.tencent.mm.plugin.appbrand.page.h.b) a2.a("mapDestroyListener", com.tencent.mm.plugin.appbrand.page.h.b.class)) == null) {
                final com.tencent.mm.plugin.appbrand.page.h hVar3 = hVar;
                final SoSoMapView soSoMapView2 = soSoMapView;
                final AnonymousClass5 anonymousClass52 = anonymousClass5;
                final com.tencent.mm.model.o.b bVar2 = a2;
                com.tencent.mm.plugin.appbrand.page.h.b anonymousClass6 = new com.tencent.mm.plugin.appbrand.page.h.b(this) {
                    final /* synthetic */ h dKu;

                    public final void onDestroy() {
                        hVar3.b((com.tencent.mm.plugin.appbrand.page.h.b) this);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 dKC;

                            {
                                this.dKC = r1;
                            }

                            public final void run() {
                                if (soSoMapView2 != null) {
                                    soSoMapView2.setVisibility(8);
                                    soSoMapView2.clean();
                                }
                            }
                        });
                        if (sensorManager != null) {
                            sensorManager.unregisterListener(bVar);
                        }
                        a OP = com.tencent.mm.plugin.appbrand.a.a.OP();
                        com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar = anonymousClass52;
                        if (!(OP.dKi == null || aVar == null)) {
                            Iterator it = OP.dKi.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.map.a.a) it.next();
                                if (aVar2 != null && aVar2.equals(aVar)) {
                                    OP.dKi.remove(aVar2);
                                    break;
                                }
                            }
                            v.i("MicroMsg.AppbrandMapLocationMgr", "unregisterLocationListener %d", new Object[]{Integer.valueOf(OP.dKi.size())});
                            if (OP.dKi.size() == 0) {
                                v.i("MicroMsg.AppbrandMapLocationMgr", "unregisterLocation ");
                                OP.dKg.removeUpdates(OP.dKh);
                            }
                        }
                        bVar2.recycle();
                    }
                };
                a2.l("mapDestroyListener", anonymousClass6);
                hVar.a(anonymousClass6);
            }
        } else {
            if (((com.tencent.mm.plugin.appbrand.page.h.b) a.a("mapDestroyListener", com.tencent.mm.plugin.appbrand.page.h.b.class)) == null) {
                final com.tencent.mm.plugin.appbrand.page.h hVar4 = hVar;
                final com.tencent.mm.model.o.b bVar3 = a;
                com.tencent.mm.plugin.appbrand.page.h.b anonymousClass2 = new com.tencent.mm.plugin.appbrand.page.h.b(this) {
                    final /* synthetic */ h dKu;

                    public final void onDestroy() {
                        hVar4.b((com.tencent.mm.plugin.appbrand.page.h.b) this);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 dKw;

                            {
                                this.dKw = r1;
                            }

                            public final void run() {
                                if (soSoMapView != null) {
                                    soSoMapView.setVisibility(8);
                                    soSoMapView.clean();
                                }
                            }
                        });
                        bVar3.recycle();
                    }
                };
                a.l("mapDestroyListener", anonymousClass2);
                hVar.a(anonymousClass2);
            }
        }
        g map = soSoMapView.getMap();
        final int i3 = i;
        final com.tencent.mm.plugin.appbrand.page.h hVar5 = hVar;
        map.mapContext.h().a(new g.e(this) {
            final /* synthetic */ h dKu;

            public final void Qw() {
                c cVar = new c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i3);
                } catch (JSONException e) {
                    v.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                e a = cVar.a(hVar5);
                a.mData = jSONObject.toString();
                a.PX();
            }
        });
        i3 = i;
        hVar5 = hVar;
        map.mapContext.h().a(new d(this) {
            final /* synthetic */ h dKu;
            boolean dKx = false;
            JSONObject dKy = new JSONObject();
            a dKz = new a();

            public final void Qx() {
                try {
                    this.dKy.put("mapId", i3);
                    this.dKy.put(Columns.TYPE, "begin");
                } catch (JSONException e) {
                    v.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                if (!this.dKx) {
                    this.dKx = true;
                    e aa = this.dKz.aa(hVar5.dzg, hVar5.hashCode());
                    aa.mData = this.dKy.toString();
                    aa.PX();
                }
            }

            public final void Qy() {
                try {
                    this.dKy.put("mapId", i3);
                    this.dKy.put(Columns.TYPE, "end");
                } catch (JSONException e) {
                    v.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                this.dKx = false;
                e aa = this.dKz.aa(hVar5.dzg, hVar5.hashCode());
                aa.mData = this.dKy.toString();
                aa.PX();
            }
        });
        try {
            List arrayList;
            JSONArray jSONArray;
            int i4;
            JSONObject jSONObject2;
            float f;
            float f2;
            String ou;
            MarkerOptions markerOptions;
            if (jSONObject.has("markers")) {
                arrayList = new ArrayList();
                jSONArray = new JSONArray(jSONObject.optString("markers"));
                for (i4 = 0; i4 < jSONArray.length(); i4++) {
                    jSONObject2 = (JSONObject) jSONArray.get(i4);
                    f = be.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    f2 = be.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    ou = com.tencent.mm.plugin.appbrand.k.a.ou(jSONObject2.optString("name"));
                    String ou2 = com.tencent.mm.plugin.appbrand.k.a.ou(jSONObject2.optString("desc"));
                    markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng((double) f, (double) f2));
                    markerOptions.title(ou);
                    if (!be.kS(ou2)) {
                        markerOptions.snippet(ou2);
                    }
                    arrayList.add(soSoMapView.addMarker(markerOptions));
                }
                a.l("markers", arrayList);
            }
            try {
                if (jSONObject.has("covers")) {
                    arrayList = new ArrayList();
                    jSONArray = new JSONArray(jSONObject.optString("covers"));
                    for (i4 = 0; i4 < jSONArray.length(); i4++) {
                        jSONObject2 = (JSONObject) jSONArray.get(i4);
                        f = be.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        f2 = be.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        ou = jSONObject2.optString("iconPath");
                        float optDouble = (float) jSONObject2.optDouble("rotate", 0.0d);
                        markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        WebResourceResponse ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(hVar.dzg, ou);
                        if (ar != null) {
                            markerOptions.icon(new BitmapDescriptor(BitmapFactory.decodeStream(ar.getData())));
                        }
                        markerOptions.rotation(optDouble);
                        Marker addMarker = soSoMapView.addMarker(markerOptions);
                        addMarker.setTag("cover");
                        arrayList.add(addMarker);
                    }
                    a.l("converters", arrayList);
                }
            } catch (Exception e) {
                v.e("MicroMsg.JsApiInsertMap", "parse covers error, exception : %s", new Object[]{e});
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiInsertMap", "parse markers error, exception : %s", new Object[]{e2});
        }
    }
}
