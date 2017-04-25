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

public final class qb extends c {
    private final int height = 75;
    private final int width = 75;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                g.setColor(-15028967);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(4.0f, 60.0f);
                h.lineTo(4.0f, 71.990364f);
                h.cubicTo(4.0f, 73.65254f, 5.348283f, 75.0f, 7.0073853f, 75.0f);
                h.lineTo(66.992615f, 75.0f);
                h.cubicTo(68.65355f, 75.0f, 70.0f, 73.666405f, 70.0f, 71.990364f);
                h.lineTo(70.0f, 3.0096345f);
                h.cubicTo(70.0f, 1.3474593f, 68.65172f, 0.0f, 66.992615f, 0.0f);
                h.lineTo(7.0073853f, 0.0f);
                h.cubicTo(5.346452f, 0.0f, 4.0f, 1.3335965f, 4.0f, 3.0096345f);
                h.lineTo(4.0f, 15.0f);
                h.cubicTo(6.4852815f, 15.0f, 8.5f, 17.014719f, 8.5f, 19.5f);
                h.cubicTo(8.5f, 21.985281f, 6.4852815f, 24.0f, 4.0f, 24.0f);
                h.lineTo(4.0f, 51.0f);
                h.cubicTo(6.4852815f, 51.0f, 8.5f, 53.014717f, 8.5f, 55.5f);
                h.cubicTo(8.5f, 57.985283f, 6.4852815f, 60.0f, 4.0f, 60.0f);
                h.close();
                h.moveTo(35.16073f, 42.33927f);
                h.cubicTo(31.262531f, 38.441074f, 29.43414f, 34.747486f, 29.54121f, 33.381584f);
                h.cubicTo(29.648281f, 32.01568f, 31.987486f, 28.614197f, 31.95635f, 27.008419f);
                h.cubicTo(31.941387f, 26.23667f, 28.530704f, 21.19352f, 28.136374f, 20.583046f);
                h.cubicTo(27.742043f, 19.972572f, 27.281416f, 19.406528f, 26.698536f, 19.512964f);
                h.cubicTo(26.115658f, 19.6194f, 19.69526f, 21.835806f, 20.584337f, 27.494286f);
                h.cubicTo(21.473415f, 33.152767f, 27.573353f, 41.04148f, 31.963337f, 45.536663f);
                h.lineTo(35.16073f, 42.33927f);
                h.close();
                h.moveTo(35.16073f, 42.33927f);
                h.cubicTo(39.058926f, 46.23747f, 42.752514f, 48.06586f, 44.118416f, 47.95879f);
                h.cubicTo(45.48432f, 47.85172f, 48.885803f, 45.512516f, 50.49158f, 45.54365f);
                h.cubicTo(51.263332f, 45.558613f, 56.30648f, 48.969296f, 56.916954f, 49.363625f);
                h.cubicTo(57.527428f, 49.757957f, 58.09347f, 50.218586f, 57.987034f, 50.801464f);
                h.cubicTo(57.8806f, 51.384342f, 55.664196f, 57.80474f, 50.005714f, 56.915665f);
                h.cubicTo(44.347233f, 56.026585f, 36.45852f, 49.926647f, 31.963337f, 45.536663f);
                h.lineTo(35.16073f, 42.33927f);
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
