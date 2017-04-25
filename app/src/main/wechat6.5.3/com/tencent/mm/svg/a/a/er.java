package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class er extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                g = c.a(g, looper);
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(65.0f, 53.0f);
                h.cubicTo(65.0f, 55.20933f, 62.761665f, 57.0f, 60.0f, 57.0f);
                h.lineTo(55.0f, 57.0f);
                h.lineTo(55.0f, 41.0f);
                h.lineTo(60.0f, 41.0f);
                h.cubicTo(62.761665f, 41.0f, 65.0f, 42.79111f, 65.0f, 45.0f);
                h.lineTo(65.0f, 53.0f);
                h.close();
                h.moveTo(60.0f, 33.0f);
                h.lineTo(48.0f, 33.0f);
                h.lineTo(48.0f, 65.0f);
                h.lineTo(60.0f, 65.0f);
                h.cubicTo(66.627556f, 65.0f, 72.0f, 59.627556f, 72.0f, 53.0f);
                h.lineTo(72.0f, 45.0f);
                h.cubicTo(72.0f, 38.37289f, 66.627556f, 33.0f, 60.0f, 33.0f);
                h.lineTo(60.0f, 33.0f);
                h.close();
                h.moveTo(48.5f, 78.0f);
                h.cubicTo(32.759857f, 78.0f, 20.0f, 65.24014f, 20.0f, 49.5f);
                h.cubicTo(20.0f, 42.182285f, 22.76043f, 35.511475f, 27.293285f, 30.464714f);
                h.lineTo(29.464714f, 28.293737f);
                h.cubicTo(34.511475f, 23.76043f, 41.182285f, 21.0f, 48.5f, 21.0f);
                h.cubicTo(55.817715f, 21.0f, 62.488525f, 23.76043f, 67.535286f, 28.293737f);
                h.lineTo(69.70671f, 30.464714f);
                h.cubicTo(74.23957f, 35.511475f, 77.0f, 42.182285f, 77.0f, 49.5f);
                h.cubicTo(77.0f, 65.24014f, 64.24014f, 78.0f, 48.5f, 78.0f);
                h.lineTo(48.5f, 78.0f);
                h.close();
                h.moveTo(89.0f, 28.320707f);
                h.lineTo(84.54362f, 23.862083f);
                h.lineTo(78.94612f, 29.462835f);
                h.cubicTo(78.10526f, 28.189201f, 77.189674f, 26.969608f, 76.20072f, 25.813969f);
                h.lineTo(81.34762f, 20.664484f);
                h.lineTo(76.891235f, 16.205858f);
                h.lineTo(71.71237f, 21.387772f);
                h.cubicTo(70.703606f, 20.554144f, 69.645325f, 19.779964f, 68.54969f, 19.056675f);
                h.lineTo(74.14538f, 13.458625f);
                h.lineTo(69.688995f, 9.0f);
                h.lineTo(62.753685f, 15.939241f);
                h.cubicTo(58.37472f, 14.0760765f, 53.558674f, 13.040685f, 48.5f, 13.040685f);
                h.cubicTo(43.441326f, 13.040685f, 38.62528f, 14.0760765f, 34.246315f, 15.939241f);
                h.lineTo(27.311008f, 9.0f);
                h.lineTo(22.854622f, 13.458625f);
                h.lineTo(28.450312f, 19.056675f);
                h.cubicTo(27.354671f, 19.779964f, 26.296392f, 20.554144f, 25.287628f, 21.387772f);
                h.lineTo(20.108767f, 16.205858f);
                h.lineTo(15.652381f, 20.664484f);
                h.lineTo(20.799282f, 25.813969f);
                h.cubicTo(19.810324f, 26.969608f, 18.89474f, 28.189201f, 18.053879f, 29.462835f);
                h.lineTo(12.456387f, 23.862083f);
                h.lineTo(8.0f, 28.320707f);
                h.lineTo(14.937108f, 35.2613f);
                h.cubicTo(13.073078f, 39.64066f, 12.038656f, 44.45868f, 12.038656f, 49.520344f);
                h.cubicTo(12.038656f, 69.66747f, 28.362986f, 86.0f, 48.5f, 86.0f);
                h.cubicTo(68.63702f, 86.0f, 84.96134f, 69.66747f, 84.96134f, 49.520344f);
                h.cubicTo(84.96134f, 44.45868f, 83.92692f, 39.64066f, 82.06289f, 35.2613f);
                h.lineTo(89.0f, 28.320707f);
                h.close();
                h.moveTo(36.0f, 53.0f);
                h.cubicTo(36.0f, 55.20933f, 34.20933f, 57.0f, 32.0f, 57.0f);
                h.lineTo(28.0f, 57.0f);
                h.lineTo(28.0f, 65.0f);
                h.lineTo(32.0f, 65.0f);
                h.cubicTo(38.627556f, 65.0f, 44.0f, 59.627556f, 44.0f, 53.0f);
                h.lineTo(44.0f, 33.0f);
                h.lineTo(36.0f, 33.0f);
                h.lineTo(36.0f, 53.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
