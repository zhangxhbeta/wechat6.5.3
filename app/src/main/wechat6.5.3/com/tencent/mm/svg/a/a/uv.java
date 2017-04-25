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

public final class uv extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                a.setColor(-6710887);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(14.949f, 5.8425765f);
                h.cubicTo(21.649f, 1.6792915f, 29.638f, -0.2605797f, 37.503f, 0.0289533f);
                h.cubicTo(45.468f, 0.29652175f, 53.408f, 2.8893397f, 59.778f, 7.714557f);
                h.cubicTo(62.781f, 9.984896f, 65.423f, 12.749436f, 67.47f, 15.911337f);
                h.cubicTo(69.411f, 18.899517f, 70.805f, 22.249115f, 71.491f, 25.74747f);
                h.cubicTo(72.316f, 29.922737f, 72.131f, 34.29269f, 70.953f, 38.38309f);
                h.cubicTo(69.294f, 44.209694f, 65.656f, 49.37037f, 61.004f, 53.215168f);
                h.cubicTo(55.825f, 57.515232f, 49.43f, 60.2638f, 42.799f, 61.347054f);
                h.cubicTo(33.676f, 62.845634f, 24.002f, 61.304123f, 15.968f, 56.670597f);
                h.cubicTo(10.646f, 58.412785f, 5.323f, 60.15697f, 0.0f, 61.90016f);
                h.cubicTo(2.104f, 57.420387f, 4.21f, 52.942608f, 6.312f, 48.461834f);
                h.cubicTo(3.922f, 45.468662f, 2.079f, 42.02522f, 1.034f, 38.337166f);
                h.cubicTo(-0.644f, 32.51755f, -0.26f, 26.141836f, 2.082f, 20.557842f);
                h.cubicTo(4.618f, 14.419743f, 9.327f, 9.31897f, 14.949f, 5.8425765f);
                h.lineTo(14.949f, 5.8425765f);
                h.close();
                h.moveTo(27.728f, 4.9040904f);
                h.cubicTo(21.562f, 6.2858615f, 15.702f, 9.30599f, 11.271f, 13.841675f);
                h.cubicTo(8.666f, 16.505379f, 6.584f, 19.700226f, 5.338f, 23.216555f);
                h.cubicTo(3.605f, 28.044767f, 3.557f, 33.451046f, 5.208f, 38.308212f);
                h.cubicTo(6.376f, 41.79459f, 8.372f, 44.976456f, 10.882f, 47.656136f);
                h.cubicTo(9.586f, 50.4067f, 8.294f, 53.15826f, 7.001f, 55.909824f);
                h.cubicTo(10.312f, 54.807602f, 13.624f, 53.706375f, 16.935f, 52.603157f);
                h.cubicTo(19.917f, 54.464153f, 23.193f, 55.84393f, 26.596f, 56.72351f);
                h.cubicTo(34.704f, 58.804153f, 43.538f, 58.153206f, 51.176f, 54.687794f);
                h.cubicTo(56.381f, 52.325603f, 61.04f, 48.6086f, 64.146f, 43.783382f);
                h.cubicTo(66.169f, 40.65343f, 67.492f, 37.060226f, 67.873f, 33.349213f);
                h.cubicTo(68.256f, 29.74802f, 67.764f, 26.061964f, 66.465f, 22.681417f);
                h.cubicTo(65.237f, 19.464605f, 63.308f, 16.532335f, 60.929f, 14.048342f);
                h.cubicTo(58.65f, 11.667182f, 55.965f, 9.685378f, 53.056f, 8.138873f);
                h.cubicTo(45.369f, 4.055459f, 36.197f, 3.0131402f, 27.728f, 4.9040904f);
                h.lineTo(27.728f, 4.9040904f);
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
