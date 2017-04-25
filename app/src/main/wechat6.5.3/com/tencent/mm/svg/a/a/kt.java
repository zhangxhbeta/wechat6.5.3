package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class kt extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(35.5f, 14.333468f);
                h.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                h.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                h.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                h.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                h.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                h.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(35.5f, 14.333468f);
                h.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                h.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                h.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                h.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                h.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                h.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                h.close();
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.FILL);
                Paint g4 = c.g(looper);
                g4.setFlags(385);
                g4.setStyle(Style.STROKE);
                g3.setColor(WebView.NIGHT_MODE_COLOR);
                g4.setStrokeWidth(1.0f);
                g4.setStrokeCap(Cap.BUTT);
                g4.setStrokeJoin(Join.MITER);
                g4.setStrokeMiter(4.0f);
                g4.setPathEffect(null);
                float[] a2 = c.a(c, 66.0f, 0.0f, 4.999999f, 0.0f, 63.0f, 8.0f);
                d.reset();
                d.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-33702, -44260}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
