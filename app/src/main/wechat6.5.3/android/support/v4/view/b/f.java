package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

final class f implements Interpolator {
    private final float[] zE;
    private final float[] zF;

    public f(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.zE = new float[i];
        this.zF = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.zE[i2] = fArr[0];
            this.zF[i2] = fArr[1];
        }
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.zE.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.zE[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.zE[length] - this.zE[i];
        if (f2 == 0.0f) {
            return this.zF[i];
        }
        float f3 = (f - this.zE[i]) / f2;
        f2 = this.zF[i];
        return (f3 * (this.zF[length] - f2)) + f2;
    }
}
