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

public final class mt extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                Paint a = c.a(g, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.32f, 0.0f);
                h.lineTo(70.39f, 0.0f);
                h.cubicTo(86.38f, 0.77f, 102.05f, 7.25f, 113.68f, 18.29f);
                h.cubicTo(126.43f, 30.1f, 134.09f, 47.0f, 135.0f, 64.33f);
                h.lineTo(135.0f, 70.4f);
                h.cubicTo(134.19f, 87.57f, 126.72f, 104.36f, 114.22f, 116.2f);
                h.cubicTo(102.61f, 127.48f, 86.84f, 134.13f, 70.71f, 135.0f);
                h.lineTo(64.57f, 135.0f);
                h.cubicTo(48.58f, 134.23f, 32.91f, 127.73f, 21.29f, 116.69f);
                h.cubicTo(8.55f, 104.89f, 0.92f, 88.0f, 0.0f, 70.7f);
                h.lineTo(0.0f, 64.65f);
                h.cubicTo(0.8f, 47.24f, 8.47f, 30.21f, 21.28f, 18.33f);
                h.cubicTo(32.84f, 7.33f, 48.41f, 0.86f, 64.32f, 0.0f);
                h.lineTo(64.32f, 0.0f);
                h.close();
                h.moveTo(57.55f, 3.77f);
                h.cubicTo(42.51f, 6.07f, 28.42f, 13.93f, 18.56f, 25.51f);
                h.cubicTo(8.45f, 37.18f, 2.82f, 52.6f, 3.01f, 68.04f);
                h.cubicTo(3.07f, 83.1f, 8.67f, 98.05f, 18.51f, 109.44f);
                h.cubicTo(28.88f, 121.64f, 43.95f, 129.73f, 59.87f, 131.54f);
                h.cubicTo(73.46f, 133.18f, 87.57f, 130.37f, 99.45f, 123.53f);
                h.cubicTo(112.27f, 116.25f, 122.45f, 104.43f, 127.71f, 90.65f);
                h.cubicTo(133.42f, 75.91f, 133.42f, 59.05f, 127.69f, 44.32f);
                h.cubicTo(121.92f, 29.19f, 110.18f, 16.45f, 95.59f, 9.44f);
                h.cubicTo(83.88f, 3.72f, 70.41f, 1.77f, 57.55f, 3.77f);
                h.lineTo(57.55f, 3.77f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(53.0f, 46.0f);
                h.cubicTo(63.6931f, 44.031647f, 74.275215f, 41.425205f, 85.0f, 39.0f);
                h.cubicTo(86.67598f, 38.51154f, 88.25481f, 40.255775f, 88.0f, 42.0f);
                h.cubicTo(87.96502f, 55.468273f, 88.07494f, 69.00591f, 88.0f, 83.0f);
                h.cubicTo(86.785904f, 90.09529f, 73.42585f, 88.96551f, 73.0f, 82.0f);
                h.cubicTo(73.17604f, 77.21175f, 78.14234f, 75.328766f, 82.0f, 76.0f);
                h.cubicTo(81.98947f, 67.27159f, 81.999466f, 58.87746f, 82.0f, 50.0f);
                h.cubicTo(73.31593f, 52.485237f, 64.66238f, 54.47723f, 56.0f, 57.0f);
                h.cubicTo(56.018814f, 67.39051f, 55.98884f, 78.262245f, 56.0f, 89.0f);
                h.cubicTo(54.589878f, 91.29446f, 52.961094f, 93.920715f, 50.0f, 94.0f);
                h.cubicTo(46.256084f, 93.87116f, 41.209843f, 91.99809f, 41.0f, 88.0f);
                h.cubicTo(41.169872f, 83.19764f, 46.15616f, 81.225464f, 50.0f, 82.0f);
                h.cubicTo(50.03327f, 71.04746f, 49.98331f, 60.453217f, 50.0f, 50.0f);
                h.cubicTo(49.843414f, 48.085007f, 51.382267f, 46.628178f, 53.0f, 46.0f);
                h.lineTo(53.0f, 46.0f);
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
