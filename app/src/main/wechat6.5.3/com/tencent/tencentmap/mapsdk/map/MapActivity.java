package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class MapActivity extends Activity {
    private List<MapView> mapViewList = new ArrayList();
    private Bundle mysavedInstanceState;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mysavedInstanceState = bundle;
    }

    public void onDestroy() {
        super.onDestroy();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onDestroy();
            }
        }
        this.mapViewList.clear();
    }

    public void onPause() {
        super.onPause();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onPause();
            }
        }
    }

    public void onResume() {
        super.onResume();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onResume();
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onSaveInstanceState(bundle);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onStop();
            }
        }
    }

    public void setMapView(MapView mapView) {
        this.mapViewList.add(mapView);
        mapView.onCreate(this.mysavedInstanceState);
    }
}
