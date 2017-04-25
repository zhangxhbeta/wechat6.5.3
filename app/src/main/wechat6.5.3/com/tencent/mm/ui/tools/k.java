package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;

public final class k implements OnGestureListener {
    private final Context context;
    public final GestureDetector oSX = new GestureDetector(this.context, this);
    public a oSY;
    private final int oSZ;
    private final int oTa;
    private final float oTb;
    private final float oTc;

    public interface a {
        void bGk();

        void bGl();

        void bGm();

        void bGn();
    }

    public k(Context context) {
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.oSZ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.oTa = viewConfiguration.getScaledMaximumFlingVelocity();
        this.oTb = (float) b.a(context, 70.0f);
        this.oTc = (float) b.a(context, 50.0f);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.oSY == null) {
            return true;
        }
        v.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.oTc && f > 800.0f && abs2 > this.oTb) {
            this.oSY.bGl();
            return true;
        } else if (abs < this.oTc && f < -800.0f && abs2 < (-this.oTb)) {
            this.oSY.bGm();
            return true;
        } else if (abs2 < this.oTc && f2 > 800.0f) {
            this.oSY.bGn();
            return true;
        } else if (abs2 >= this.oTc || f2 >= -800.0f) {
            return false;
        } else {
            this.oSY.bGk();
            return true;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }
}
