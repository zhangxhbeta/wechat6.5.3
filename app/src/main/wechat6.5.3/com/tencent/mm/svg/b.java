package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

final class b {
    private static a<Paint> nyd = new a();
    private static a<float[]> nye = new a();
    private static a<Matrix> nyf = new a();
    private static a<Path> nyg = new a();
    private static final float[] nyh = new float[9];

    protected static synchronized void b(Looper looper) {
        synchronized (b.class) {
            nyd.a(looper);
            nye.a(looper);
            nyf.a(looper);
            nyg.a(looper);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            paint2 = (Paint) nyd.bya();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            nyd.a(looper, paint2);
        }
        return paint2;
    }

    protected static synchronized float[] c(Looper looper) {
        Object obj;
        synchronized (b.class) {
            obj = (float[]) nye.bya();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(nyh, 0, obj, 0, 9);
            }
            nye.a(looper, obj);
        }
        return obj;
    }

    protected static synchronized Matrix d(Looper looper) {
        Matrix matrix;
        synchronized (b.class) {
            matrix = (Matrix) nyf.bya();
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            nyf.a(looper, matrix);
        }
        return matrix;
    }

    protected static synchronized Path e(Looper looper) {
        Path path;
        synchronized (b.class) {
            path = (Path) nyg.bya();
            if (path == null) {
                path = new Path();
            } else {
                path.reset();
            }
            nyg.a(looper, path);
        }
        return path;
    }
}
