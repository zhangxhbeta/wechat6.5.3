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

public final class aeh extends c {
    private final int height = 268;
    private final int width = 268;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 268;
            case 1:
                return 268;
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
                float[] a = c.a(c, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-2763307);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(19.44114f, 1.6814522f);
                h.cubicTo(21.571093f, 1.1815006f, 23.771044f, 1.0515132f, 25.960997f, 1.0215161f);
                h.lineTo(217.99675f, 1.0215161f);
                h.cubicTo(223.20663f, 1.0515132f, 228.63652f, 0.6115558f, 233.57642f, 2.6113622f);
                h.cubicTo(242.6562f, 5.9810357f, 249.10606f, 15.260138f, 248.98607f, 24.969196f);
                h.cubicTo(248.99608f, 91.64274f, 249.01607f, 158.32628f, 248.97607f, 224.99982f);
                h.cubicTo(249.32607f, 237.79858f, 237.84631f, 249.31747f, 225.0366f, 248.97751f);
                h.cubicTo(158.34807f, 249.00749f, 91.64954f, 249.00749f, 24.961018f, 248.97751f);
                h.cubicTo(12.1513f, 249.30746f, 0.681554f, 237.79858f, 1.0115467f, 224.98982f);
                h.cubicTo(1.001547f, 158.32628f, 0.99154717f, 91.65274f, 1.0115467f, 24.989195f);
                h.cubicTo(0.8315507f, 14.180242f, 8.901373f, 4.0212255f, 19.44114f, 1.6814522f);
                h.lineTo(19.44114f, 1.6814522f);
                h.close();
                h.moveTo(20.37277f, 4.5099654f);
                h.cubicTo(11.114031f, 6.4898314f, 3.8050265f, 15.399228f, 4.014998f, 24.928583f);
                h.cubicTo(3.9950006f, 91.63406f, 3.9950006f, 158.32956f, 4.014998f, 225.02504f);
                h.cubicTo(3.7050402f, 236.20428f, 13.8136635f, 246.3236f, 25.00214f, 245.97362f);
                h.cubicTo(91.64307f, 246.01361f, 158.28398f, 246.00362f, 224.92491f, 245.97362f);
                h.cubicTo(234.5036f, 246.2536f, 243.48238f, 238.9341f, 245.4721f, 229.63472f);
                h.cubicTo(246.20201f, 225.79498f, 245.95204f, 221.86525f, 245.98204f, 217.97551f);
                h.cubicTo(245.95204f, 153.64987f, 245.99203f, 89.32423f, 245.96205f, 25.008577f);
                h.cubicTo(246.292f, 13.809336f, 236.17339f, 3.690021f, 224.98491f, 4.029998f);
                h.cubicTo(158.64394f, 3.9800014f, 92.31297f, 4.029998f, 25.982006f, 4.0f);
                h.cubicTo(24.102262f, 4.049997f, 22.222519f, 4.129991f, 20.37277f, 4.5099654f);
                h.lineTo(20.37277f, 4.5099654f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(17.37277f, 1.5099655f);
                h.cubicTo(19.222519f, 1.1299912f, 21.102262f, 1.0499966f, 22.982006f, 1.0f);
                h.cubicTo(89.31297f, 1.029998f, 155.64394f, 0.98000133f, 221.98491f, 1.029998f);
                h.cubicTo(233.17339f, 0.690021f, 243.292f, 10.809336f, 242.96205f, 22.008577f);
                h.cubicTo(242.99203f, 86.32423f, 242.95204f, 150.64987f, 242.98204f, 214.97551f);
                h.cubicTo(242.95204f, 218.86525f, 243.20201f, 222.79498f, 242.4721f, 226.63472f);
                h.cubicTo(240.48238f, 235.9341f, 231.5036f, 243.2536f, 221.92491f, 242.97362f);
                h.cubicTo(155.28398f, 243.00362f, 88.64307f, 243.01361f, 22.00214f, 242.97362f);
                h.cubicTo(10.8136635f, 243.3236f, 0.70504016f, 233.20428f, 1.014998f, 222.02504f);
                h.cubicTo(0.99500066f, 155.32956f, 0.99500066f, 88.63406f, 1.014998f, 21.928583f);
                h.cubicTo(0.80502653f, 12.399228f, 8.114031f, 3.4898314f, 17.37277f, 1.5099655f);
                h.lineTo(17.37277f, 1.5099655f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
