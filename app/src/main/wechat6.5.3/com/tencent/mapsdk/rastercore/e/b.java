package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;

public interface b {
    boolean checkInBounds();

    void destroy();

    void draw(Canvas canvas);

    boolean equalsRemote(b bVar);

    String getId();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    void remove();

    void setVisible(boolean z);

    void setZIndex(float f);
}
