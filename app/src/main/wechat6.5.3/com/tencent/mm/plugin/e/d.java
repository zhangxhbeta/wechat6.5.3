package com.tencent.mm.plugin.e;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Collection;
import java.util.Set;

public interface d {
    void addLocationPin(View view);

    void addView(View view, double d, double d2);

    void addView(View view, double d, double d2, int i);

    void addView(View view, double d, double d2, String str);

    Collection<View> getChilds();

    b getIController();

    int getMapCenterX();

    int getMapCenterY();

    Point getPointByGeoPoint(double d, double d2);

    Set<String> getTags();

    View getViewByItag(String str);

    int getZoom();

    int getZoomLevel();

    void invalidate();

    void removeView(View view);

    View removeViewByTag(String str);

    void setBuiltInZoomControls(boolean z);

    void setMapViewOnTouchListener(OnTouchListener onTouchListener);

    void updateLocaitonPinLayout(View view, double d, double d2);

    void updateViewLayout(View view, double d, double d2);

    void updateViewLayout(View view, double d, double d2, int i);

    void zoomToSpan(double d, double d2, double d3, double d4);
}
