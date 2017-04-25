package com.tencent.mm.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class WeChatSVGRenderC2Java {
    public static Bitmap checkForImageDataURL(String str) {
        return null;
    }

    public static void invert(Matrix matrix, Matrix matrix2) {
        matrix.invert(matrix2);
    }

    public static void doNonScalingStroke(Canvas canvas, Path path, Paint paint) {
        Matrix matrix = canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        canvas.setMatrix(new Matrix());
        Shader shader = paint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        canvas.drawPath(path2, paint);
        canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    public static void setRadialGradient(Paint paint, float f, float f2, float f3, int[] iArr, float[] fArr, Matrix matrix, int i) {
        TileMode tileMode = TileMode.CLAMP;
        if (i != 0) {
            if (i == 2) {
                tileMode = TileMode.MIRROR;
            } else if (i == 3) {
                tileMode = TileMode.REPEAT;
            }
        }
        Shader radialGradient = new RadialGradient(f, f2, f3, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    public static void setLinearGradient(Paint paint, float f, float f2, float f3, float f4, int[] iArr, float[] fArr, Matrix matrix, int i) {
        TileMode tileMode = TileMode.CLAMP;
        if (i != 0) {
            if (i == 2) {
                tileMode = TileMode.MIRROR;
            } else if (i == 3) {
                tileMode = TileMode.REPEAT;
            }
        }
        Shader linearGradient = new LinearGradient(f, f2, f3, f4, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    public static void addPath(Path path, Matrix matrix, Path path2, boolean z) {
        if (z) {
            path.setFillType(path2.getFillType());
        }
        path.addPath(path2, matrix);
    }

    public static float getPathMeasureLength(Path path, Matrix matrix) {
        if (matrix != null) {
            path.transform(matrix);
        }
        return new PathMeasure(path, false).getLength();
    }

    public static void setFillType(Path path, int i) {
        switch (i) {
            case 0:
            case 1:
                path.setFillType(FillType.WINDING);
                return;
            case 2:
                path.setFillType(FillType.EVEN_ODD);
                return;
            default:
                return;
        }
    }

    public static void addTextPath(Paint paint, Path path, String str, float f, float f2) {
        Path path2 = new Path();
        paint.getTextPath(str, 0, str.length(), f, f2, path2);
        path.addPath(path2);
    }

    public static float[] computePathBound(Path path, Matrix matrix) {
        if (matrix != null) {
            path.transform(matrix);
        }
        path.computeBounds(new RectF(), true);
        return new float[]{r0.left, r0.top, r0.right, r0.bottom};
    }

    public static float[] getTextBounds(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF = new RectF(rect);
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom};
    }
}
