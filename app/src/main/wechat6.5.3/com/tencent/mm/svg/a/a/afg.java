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

public final class afg extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(47.924576f, 7.7413077f);
                h.cubicTo(50.345352f, 5.19123f, 52.66651f, 2.5399585f, 55.097248f, 0.0f);
                h.cubicTo(55.74478f, 7.23534f, 56.41224f, 14.47068f, 57.0f, 21.70602f);
                h.cubicTo(49.488617f, 21.979242f, 41.967274f, 22.242346f, 34.45589f, 22.47509f);
                h.cubicTo(37.12572f, 19.459522f, 39.915092f, 16.575506f, 42.565f, 13.549818f);
                h.cubicTo(34.625248f, 10.149714f, 25.04176f, 10.969382f, 18.048405f, 16.170732f);
                h.cubicTo(10.985314f, 21.129217f, 7.159889f, 29.912817f, 7.508561f, 38.534508f);
                h.cubicTo(5.028012f, 38.70654f, 2.5375006f, 38.85833f, 0.056951366f, 39.0f);
                h.cubicTo(-0.5507334f, 28.698496f, 3.732946f, 18.22496f, 11.553151f, 11.596783f);
                h.cubicTo(21.415575f, 2.8536584f, 36.468227f, 1.447068f, 47.924576f, 7.7413077f);
                h.lineTo(47.924576f, 7.7413077f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(44.512123f, 57.352257f);
                h.cubicTo(52.92648f, 52.803265f, 57.97709f, 43.098755f, 57.458054f, 33.515553f);
                h.cubicTo(59.953415f, 33.313374f, 62.448776f, 33.141525f, 64.94414f, 33.0f);
                h.cubicTo(65.54302f, 43.280716f, 61.30091f, 53.763607f, 53.455494f, 60.364697f);
                h.cubicTo(43.583847f, 69.108864f, 28.491903f, 70.58476f, 17.033207f, 64.23639f);
                h.cubicTo(14.587753f, 66.78383f, 12.242114f, 69.42224f, 9.826604f, 72.0f);
                h.cubicTo(9.157847f, 64.60031f, 8.608868f, 57.200623f, 8.0f, 49.800934f);
                h.cubicTo(15.3064165f, 49.780716f, 22.612833f, 49.780716f, 29.91925f, 49.800934f);
                h.cubicTo(27.443853f, 52.722397f, 24.778807f, 55.492226f, 22.413204f, 58.504665f);
                h.cubicTo(29.50003f, 61.345257f, 37.81457f, 61.244167f, 44.512123f, 57.352257f);
                h.lineTo(44.512123f, 57.352257f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
