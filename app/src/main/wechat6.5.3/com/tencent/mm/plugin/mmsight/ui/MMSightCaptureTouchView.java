package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mmdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private long hvE = -1;
    private float hvF = -1.0f;
    private int hvG = 0;
    a hvH;

    public interface a {
        void aBs();

        void aBt();

        void aBu();

        void v(float f, float f2);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                if (this.hvE <= 0 || SystemClock.elapsedRealtime() - this.hvE >= 400) {
                    if (this.hvH != null) {
                        this.hvH.v(motionEvent.getX(), motionEvent.getY());
                    }
                } else if (this.hvH != null) {
                    this.hvH.aBs();
                }
                this.hvE = SystemClock.elapsedRealtime();
                this.hvF = -1.0f;
                this.hvG++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.hvF = -1.0f;
                this.hvG = 0;
                break;
            case 2:
                if (this.hvG >= 2) {
                    float s = s(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[]{Float.valueOf(s)});
                    if (s > 0.0f) {
                        if (this.hvF > 0.0f) {
                            if (Math.abs(s - this.hvF) > 15.0f) {
                                if (s > this.hvF) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.hvH != null) {
                                        this.hvH.aBt();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.hvH != null) {
                                        this.hvH.aBu();
                                    }
                                }
                            }
                        }
                        this.hvF = s;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.hvG++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.hvG--;
                break;
        }
        return true;
    }

    private float s(MotionEvent motionEvent) {
        try {
            if (this.hvG >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                return Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            }
        } catch (Exception e) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[]{e.getMessage()});
        }
        return 0.0f;
    }
}
