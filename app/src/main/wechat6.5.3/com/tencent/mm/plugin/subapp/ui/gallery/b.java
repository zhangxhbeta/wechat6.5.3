package com.tencent.mm.plugin.subapp.ui.gallery;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class b {
    public static boolean aZy() {
        return VERSION.SDK_INT >= 5;
    }

    private static boolean t(MotionEvent motionEvent) {
        if (!aZy() || motionEvent.getPointerCount() < 2) {
            return false;
        }
        return true;
    }

    public static float u(MotionEvent motionEvent) {
        float i = i(motionEvent, 0) - i(motionEvent, 1);
        float j = j(motionEvent, 0) - j(motionEvent, 1);
        return (float) Math.sqrt((double) ((i * i) + (j * j)));
    }

    private static float i(MotionEvent motionEvent, int i) {
        if (!t(motionEvent)) {
            return motionEvent.getX();
        }
        a aVar = new a();
        return motionEvent.getX(i);
    }

    private static float j(MotionEvent motionEvent, int i) {
        if (!t(motionEvent)) {
            return motionEvent.getY();
        }
        a aVar = new a();
        return motionEvent.getY(i);
    }
}
