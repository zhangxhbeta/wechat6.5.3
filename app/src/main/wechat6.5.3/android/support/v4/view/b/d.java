package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] zC;
    private final float zD = (1.0f / ((float) (this.zC.length - 1)));

    public d(float[] fArr) {
        this.zC = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.zC.length - 1)) * f), this.zC.length - 2);
        float f2 = (f - (((float) min) * this.zD)) / this.zD;
        return ((this.zC[min + 1] - this.zC[min]) * f2) + this.zC[min];
    }
}
