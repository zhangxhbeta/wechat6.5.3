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

public final class xd extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                Paint a = c.a(g, looper);
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 45.0f, 0.0f, 1.0f, 46.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(42.0f, 2.0f);
                h.cubicTo(42.0f, 1.5267029f, 42.533726f, 1.0f, 43.0f, 1.0f);
                h.lineTo(66.0f, 1.0f);
                h.cubicTo(66.467674f, 1.0f, 67.0f, 1.5246713f, 67.0f, 2.0f);
                h.lineTo(67.0f, 20.0f);
                h.cubicTo(67.0f, 20.473297f, 66.46627f, 21.0f, 66.0f, 21.0f);
                h.lineTo(43.0f, 21.0f);
                h.cubicTo(42.532326f, 21.0f, 42.0f, 20.475328f, 42.0f, 20.0f);
                h.lineTo(42.0f, 2.0f);
                h.close();
                h.moveTo(77.0f, 23.0f);
                h.cubicTo(78.13144f, 23.242155f, 79.0f, 22.596409f, 79.0f, 22.0f);
                h.lineTo(79.0f, 1.0f);
                h.cubicTo(79.0f, 0.2719795f, 78.03951f, -0.19214992f, 77.0f, 0.0f);
                h.cubicTo(76.582535f, 0.55645734f, 72.14961f, 4.76049f, 69.0f, 8.0f);
                h.lineTo(69.0f, 15.0f);
                h.cubicTo(72.226425f, 18.18812f, 76.75826f, 22.516397f, 77.0f, 23.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(29.119242f, 46.28759f);
                h.cubicTo(36.86187f, 54.187935f, 44.198097f, 57.89348f, 46.911064f, 57.67648f);
                h.cubicTo(49.62403f, 57.459484f, 56.380077f, 52.718697f, 59.569485f, 52.781796f);
                h.cubicTo(61.10234f, 52.812122f, 71.11908f, 59.724438f, 72.331604f, 60.523617f);
                h.cubicTo(73.54413f, 61.322792f, 74.66841f, 62.256332f, 74.45701f, 63.437634f);
                h.cubicTo(74.245605f, 64.618935f, 69.84337f, 77.63094f, 58.60445f, 75.82908f);
                h.cubicTo(47.36554f, 74.027214f, 31.696922f, 61.664673f, 22.76856f, 52.767635f);
                h.lineTo(29.119242f, 46.28759f);
                h.lineTo(29.119242f, 46.28759f);
                h.close();
                h.moveTo(29.119242f, 46.28759f);
                h.cubicTo(21.376614f, 38.38724f, 17.74505f, 30.901573f, 17.957714f, 28.13334f);
                h.cubicTo(18.170378f, 25.365108f, 22.816525f, 18.47144f, 22.754683f, 15.217063f);
                h.cubicTo(22.72496f, 13.652983f, 15.950641f, 3.4322f, 15.1674185f, 2.1949737f);
                h.cubicTo(14.384195f, 0.95774764f, 13.469295f, -0.18943463f, 12.311576f, 0.0262743f);
                h.cubicTo(11.153858f, 0.24198322f, -1.5983826f, 4.7338996f, 0.16751018f, 16.201754f);
                h.cubicTo(1.9334029f, 27.66961f, 14.049142f, 43.6574f, 22.76856f, 52.767635f);
                h.lineTo(29.119242f, 46.28759f);
                h.lineTo(29.119242f, 46.28759f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
