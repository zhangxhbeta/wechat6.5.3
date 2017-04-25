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

public final class ud extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                g.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(90.0f, 180.0f);
                h.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                h.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                h.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                h.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                h.close();
                h.moveTo(103.76728f, 117.98263f);
                h.cubicTo(100.49875f, 119.62946f, 96.85723f, 120.66371f, 93.0f, 120.93096f);
                h.lineTo(93.0f, 129.0f);
                h.lineTo(93.0f, 129.0f);
                h.lineTo(107.000854f, 129.0f);
                h.cubicTo(107.552666f, 129.0f, 108.0f, 129.44336f, 108.0f, 130.00937f);
                h.lineTo(108.0f, 131.99063f);
                h.cubicTo(108.0f, 132.5481f, 107.545074f, 133.0f, 107.000854f, 133.0f);
                h.lineTo(74.999146f, 133.0f);
                h.cubicTo(74.447334f, 133.0f, 74.0f, 132.55664f, 74.0f, 131.99063f);
                h.lineTo(74.0f, 130.00937f);
                h.cubicTo(74.0f, 129.4519f, 74.454926f, 129.0f, 74.999146f, 129.0f);
                h.lineTo(89.0f, 129.0f);
                h.lineTo(89.0f, 120.93096f);
                h.lineTo(89.0f, 120.93096f);
                h.cubicTo(74.46945f, 119.92421f, 63.0f, 108.032974f, 63.0f, 93.51188f);
                h.lineTo(63.0f, 88.99816f);
                h.cubicTo(63.0f, 88.45106f, 63.451874f, 88.0f, 64.009285f, 88.0f);
                h.lineTo(65.99039f, 88.0f);
                h.cubicTo(66.55636f, 88.0f, 66.99967f, 88.45177f, 66.99967f, 89.009056f);
                h.lineTo(66.99967f, 93.36467f);
                h.cubicTo(66.99967f, 106.95095f, 78.00566f, 117.0f, 91.0f, 117.0f);
                h.cubicTo(94.46276f, 117.0f, 97.784004f, 116.298294f, 100.79325f, 115.0086f);
                h.lineTo(103.76728f, 117.98263f);
                h.lineTo(103.76728f, 117.98263f);
                h.close();
                h.moveTo(112.10175f, 111.58026f);
                h.cubicTo(116.397675f, 106.74892f, 119.0f, 100.42874f, 119.0f, 93.51188f);
                h.lineTo(119.0f, 88.99816f);
                h.cubicTo(119.0f, 88.44689f, 118.556175f, 88.0f, 117.99989f, 88.0f);
                h.lineTo(115.99589f, 88.0f);
                h.cubicTo(115.44354f, 88.0f, 114.99578f, 88.45739f, 114.99578f, 89.009056f);
                h.lineTo(114.99578f, 93.36467f);
                h.cubicTo(114.99578f, 99.441376f, 112.848305f, 104.76214f, 109.33026f, 108.80877f);
                h.lineTo(112.10175f, 111.58026f);
                h.lineTo(112.10175f, 111.58026f);
                h.close();
                h.moveTo(103.92377f, 103.40227f);
                h.cubicTo(105.85821f, 100.75579f, 107.0f, 97.49277f, 107.0f, 93.96288f);
                h.lineTo(107.0f, 63.976562f);
                h.cubicTo(107.0f, 55.14248f, 99.836555f, 47.969723f, 91.0f, 47.969723f);
                h.cubicTo(82.1615f, 47.969723f, 75.0f, 55.13623f, 75.0f, 63.976562f);
                h.lineTo(75.0f, 74.47851f);
                h.lineTo(103.92377f, 103.40227f);
                h.lineTo(103.92377f, 103.40227f);
                h.close();
                h.moveTo(95.19794f, 109.413284f);
                h.cubicTo(93.86017f, 109.776115f, 92.452736f, 109.96972f, 91.0f, 109.96972f);
                h.cubicTo(82.163445f, 109.96972f, 75.0f, 102.79697f, 75.0f, 93.96288f);
                h.lineTo(75.0f, 89.21535f);
                h.lineTo(95.19794f, 109.413284f);
                h.lineTo(95.19794f, 109.413284f);
                h.close();
                h.moveTo(117.006836f, 126.44923f);
                h.lineTo(60.164734f, 69.60712f);
                h.lineTo(62.99316f, 66.778694f);
                h.lineTo(119.835266f, 123.6208f);
                h.lineTo(117.006836f, 126.44923f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
