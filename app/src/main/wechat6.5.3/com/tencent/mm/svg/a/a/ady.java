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

public final class ady extends c {
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
                g.setColor(-12799249);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(85.09563f, 39.728813f);
                h.lineTo(69.08572f, 39.728813f);
                h.lineTo(69.08572f, 35.441456f);
                h.cubicTo(69.08572f, 34.95495f, 68.989655f, 34.49417f, 68.833855f, 34.064964f);
                h.cubicTo(72.43834f, 32.391422f, 74.942856f, 28.754305f, 74.942856f, 24.525423f);
                h.cubicTo(74.942856f, 18.711882f, 70.223175f, 14.0f, 64.4f, 14.0f);
                h.cubicTo(58.576828f, 14.0f, 53.857143f, 18.711882f, 53.857143f, 24.525423f);
                h.cubicTo(53.857143f, 28.755474f, 56.361656f, 32.392593f, 59.966145f, 34.064964f);
                h.cubicTo(59.810345f, 34.49417f, 59.714287f, 34.95495f, 59.714287f, 35.441456f);
                h.lineTo(59.714287f, 39.728813f);
                h.lineTo(36.285713f, 39.728813f);
                h.lineTo(36.285713f, 35.441456f);
                h.cubicTo(36.285713f, 34.95495f, 36.189655f, 34.49417f, 36.033855f, 34.064964f);
                h.cubicTo(39.638344f, 32.391422f, 42.142857f, 28.754305f, 42.142857f, 24.525423f);
                h.cubicTo(42.142857f, 18.711882f, 37.423172f, 14.0f, 31.6f, 14.0f);
                h.cubicTo(25.776829f, 14.0f, 21.057142f, 18.711882f, 21.057142f, 24.525423f);
                h.cubicTo(21.057142f, 28.755474f, 23.561657f, 32.392593f, 27.166143f, 34.064964f);
                h.cubicTo(27.010344f, 34.49417f, 26.914286f, 34.95495f, 26.914286f, 35.441456f);
                h.lineTo(26.914286f, 39.728813f);
                h.lineTo(10.904371f, 39.728813f);
                h.cubicTo(8.747771f, 39.728813f, 7.0f, 41.561405f, 7.0f, 43.822033f);
                h.cubicTo(7.0f, 46.08383f, 8.747771f, 47.915253f, 10.904371f, 47.915253f);
                h.lineTo(26.914286f, 47.915253f);
                h.lineTo(26.914286f, 50.575848f);
                h.lineTo(12.7154f, 76.53739f);
                h.cubicTo(11.685715f, 78.41793f, 12.2972f, 80.82591f, 14.080114f, 81.91354f);
                h.cubicTo(15.863029f, 83.0f, 18.142628f, 82.35444f, 19.172314f, 80.4739f);
                h.lineTo(31.115028f, 58.64066f);
                h.lineTo(43.654f, 80.4739f);
                h.cubicTo(44.550144f, 82.03283f, 46.345943f, 82.72517f, 48.00117f, 82.30415f);
                h.cubicTo(49.655228f, 82.72517f, 51.451027f, 82.03283f, 52.34717f, 80.4739f);
                h.lineTo(64.88615f, 58.64066f);
                h.lineTo(76.82886f, 80.4739f);
                h.cubicTo(77.85854f, 82.35444f, 80.13697f, 83.0f, 81.922226f, 81.91354f);
                h.cubicTo(83.70397f, 80.82591f, 84.31546f, 78.4191f, 83.285774f, 76.53739f);
                h.lineTo(69.08688f, 50.578186f);
                h.lineTo(69.08688f, 47.915253f);
                h.lineTo(85.0968f, 47.915253f);
                h.cubicTo(87.2534f, 47.915253f, 89.001175f, 46.08383f, 89.001175f, 43.822033f);
                h.cubicTo(89.0f, 41.561405f, 87.25223f, 39.728813f, 85.09563f, 39.728813f);
                h.lineTo(85.09563f, 39.728813f);
                h.close();
                h.moveTo(47.99883f, 72.30032f);
                h.lineTo(36.213085f, 51.776917f);
                h.cubicTo(36.2576f, 51.536f, 36.285713f, 51.289238f, 36.285713f, 51.034286f);
                h.lineTo(36.285713f, 47.915253f);
                h.lineTo(59.714287f, 47.915253f);
                h.lineTo(59.714287f, 51.034286f);
                h.cubicTo(59.714287f, 51.289238f, 59.74123f, 51.536f, 59.786915f, 51.776917f);
                h.lineTo(47.99883f, 72.30032f);
                h.lineTo(47.99883f, 72.30032f);
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
