package com.tencent.mm.plugin.location_soso;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mm.plugin.e.b;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.a;
import com.tencent.tencentmap.mapsdk.map.g;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class SoSoMapView extends MapView implements d {
    public static final String TAG = "MicroMsg.SoSoMapView";
    private boolean firstanim = true;
    private b iController;
    private HashMap<String, View> tagsView = new HashMap();

    public SoSoMapView(Context context) {
        super(context);
        init();
    }

    public SoSoMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public com.tencent.tencentmap.mapsdk.map.d getController() {
        return getMapController();
    }

    private void setEnableForeignMap(boolean z) {
        try {
            Method declaredMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
        }
    }

    private void init() {
        this.iController = new b() {
            public void setZoom(int i) {
                v.d(SoSoMapView.TAG, "set Zoom %d", new Object[]{Integer.valueOf(i)});
                SoSoMapView.this.getController().setZoom(i);
            }

            public void animateTo(double d, double d2, int i) {
                v.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2 + " zoom:" + i);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
                } else {
                    SoSoMapView.this.getController().b(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
                }
                SoSoMapView.this.firstanim = false;
                SoSoMapView.this.getController().setZoom(i);
            }

            public void animateTo(double d, double d2) {
                v.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
                } else {
                    SoSoMapView.this.getController().b(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
                }
                SoSoMapView.this.firstanim = false;
            }

            public void setCenter(double d, double d2) {
                SoSoMapView.this.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
            }

            public void offsetCenter(double d, double d2) {
                setCenter((((double) SoSoMapView.this.getMapCenterX()) / 1000000.0d) + d, (((double) SoSoMapView.this.getMapCenterY()) / 1000000.0d) + d2);
            }
        };
    }

    public void addView(View view, double d, double d2) {
        addView(view, new a(-2, -2, new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), 17));
    }

    public b getIController() {
        return this.iController;
    }

    public void setBuiltInZoomControls(boolean z) {
    }

    public void addNullView(View view) {
        v.d(TAG, "addNullView ");
        addView(view);
    }

    public int getMapCenterX() {
        return (int) (getMapCenter().getLatitude() * 1000000.0d);
    }

    public int getMapCenterY() {
        return (int) (getMapCenter().getLongitude() * 1000000.0d);
    }

    public void updateViewLayout(View view, double d, double d2) {
        updateViewLayout(view, new a(-2, -2, new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), 17));
    }

    public void addOverlay(Object obj) {
    }

    public void requestMapFocus() {
        requestFocus();
    }

    public void addView(View view, double d, double d2, String str) {
        this.tagsView.put(str, view);
        addView(view, d, d2);
    }

    public View getViewByItag(String str) {
        if (this.tagsView.containsKey(str)) {
            return (View) this.tagsView.get(str);
        }
        return null;
    }

    public Collection<View> getChilds() {
        return this.tagsView.values();
    }

    public void removeView(View view) {
        super.removeView(view);
        for (String str : this.tagsView.keySet()) {
            View view2 = (View) this.tagsView.get(str);
            if (view2 == null) {
                this.tagsView.remove(view2);
                return;
            } else if (view2.equals(view)) {
                this.tagsView.remove(str);
                return;
            }
        }
    }

    public Set<String> getTags() {
        return this.tagsView.keySet();
    }

    public View removeViewByTag(String str) {
        View view = (View) this.tagsView.get(str);
        removeView(view);
        return view;
    }

    public void clean() {
        this.tagsView.clear();
    }

    public void addLocationPin(View view) {
        addView(view);
    }

    public void zoomToSpan(double d, double d2, double d3, double d4) {
        getController().c(new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2)));
        v.d(TAG, "zoomToSpan " + ((int) (1000000.0d * d3)) + " " + ((int) (1000000.0d * d4)) + "  " + (1000000.0d * d) + " " + (1000000.0d * d2));
        if (d3 != 0.0d && d4 != 0.0d) {
            int i = (int) (1000000.0d * d3);
            int i2 = (int) (1000000.0d * d4);
            g map = getController().pzZ.getMap();
            double d5 = ((double) i) / 1000000.0d;
            double d6 = ((double) i2) / 1000000.0d;
            LatLng latLng = new LatLng(map.getMapCenter().getLatitude() - (d5 / 2.0d), map.getMapCenter().getLongitude() + (d6 / 2.0d));
            map.mapContext.c().a(com.tencent.tencentmap.mapsdk.map.b.b(new Builder().include(latLng).include(new LatLng((d5 / 2.0d) + map.getMapCenter().getLatitude(), map.getMapCenter().getLongitude() - (d6 / 2.0d))).build()).pzX);
            getController().c(new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2)));
        }
    }

    public void updateLocaitonPinLayout(View view, double d, double d2) {
        v.d(TAG, "updateLocationPinLayout");
        updateViewLayout(view, new a(-2, -2, new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), 81));
    }

    public int getZoom() {
        return getZoomLevel();
    }

    public void setMapViewOnTouchListener(OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public Point getPointByGeoPoint(double d, double d2) {
        Point point = new Point();
        PointF a = getProjection().pAd.a(com.tencent.mapsdk.rastercore.f.a.a(new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d))));
        point.x = (int) a.x;
        point.y = (int) a.y;
        return point;
    }

    public void addAnimTrackView(View view, double d, double d2, String str) {
        this.tagsView.put(str, view);
        addView(view, new a(-2, -2, new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), 81));
    }

    public void updateAnimViewLayout(View view, double d, double d2) {
        updateViewLayout(view, new a(-2, -2, new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), 81));
    }

    public float metersToEquatorPixels(double d) {
        return getProjection().pAd.a((float) d);
    }

    public void addView(View view, double d, double d2, int i) {
        GeoPoint geoPoint = new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2));
        if (i == -2) {
            addView(view, new a(-2, -2, geoPoint, 17));
        } else if (i == -1) {
            addView(view, new a(-1, -1, geoPoint, 17));
        } else {
            addView(view, new a(i, i, geoPoint, 17));
        }
    }

    public void updateViewLayout(View view, double d, double d2, int i) {
        GeoPoint geoPoint = new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2));
        if (i == -2) {
            updateViewLayout(view, new a(-2, -2, geoPoint, 17));
        } else if (i == -1) {
            updateViewLayout(view, new a(-1, -1, geoPoint, 17));
        } else {
            updateViewLayout(view, new a(i, i, geoPoint, 17));
        }
    }
}
