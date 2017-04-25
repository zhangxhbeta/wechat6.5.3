package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class f {
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

    public static void a(PointF pointF, MotionEvent motionEvent) {
        if (pointF != null && motionEvent != null) {
            pointF.set((i(motionEvent, 0) + i(motionEvent, 1)) / 2.0f, (j(motionEvent, 0) + j(motionEvent, 1)) / 2.0f);
        }
    }

    public static void a(PointF pointF, Bitmap bitmap) {
        if (pointF != null && bitmap != null) {
            pointF.set(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
    }

    public static float i(MotionEvent motionEvent, int i) {
        if (!t(motionEvent)) {
            return motionEvent.getX();
        }
        e eVar = new e();
        return motionEvent.getX(i);
    }

    public static float j(MotionEvent motionEvent, int i) {
        if (!t(motionEvent)) {
            return motionEvent.getY();
        }
        e eVar = new e();
        return motionEvent.getY(i);
    }

    public static int x(MotionEvent motionEvent) {
        if (!aZy()) {
            return 1;
        }
        e eVar = new e();
        return motionEvent.getPointerCount();
    }
}
