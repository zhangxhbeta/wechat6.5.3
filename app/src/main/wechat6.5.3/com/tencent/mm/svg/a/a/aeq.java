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

public final class aeq extends c {
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
                a.setColor(-12863723);
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(20.389967f, 3.894499f);
                h.cubicTo(25.58415f, -1.7899388f, 35.671696f, -1.1471756f, 40.12385f, 5.139853f);
                h.cubicTo(45.819405f, 12.8128395f, 43.142094f, 23.930635f, 36.814816f, 30.378355f);
                h.cubicTo(35.431038f, 31.493147f, 34.297943f, 33.853294f, 36.082817f, 35.178993f);
                h.cubicTo(43.28248f, 39.40717f, 51.224163f, 43.20349f, 56.35818f, 50.052937f);
                h.cubicTo(58.89511f, 53.22658f, 58.082893f, 57.545147f, 56.659004f, 61.0f);
                h.cubicTo(38.51947f, 60.879482f, 20.369913f, 60.96987f, 2.2303803f, 60.959827f);
                h.cubicTo(1.0170672f, 57.545147f, 0.104575485f, 53.427444f, 2.4910922f, 50.293976f);
                h.cubicTo(7.5248375f, 43.32401f, 15.596879f, 39.668293f, 22.706291f, 35.289467f);
                h.cubicTo(24.63155f, 33.93364f, 23.418236f, 31.483105f, 22.044485f, 30.257837f);
                h.cubicTo(15.677098f, 23.338089f, 13.631513f, 11.226018f, 20.389967f, 3.894499f);
                h.lineTo(20.389967f, 3.894499f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(49.614113f, 20.012203f);
                h.cubicTo(57.72848f, 20.052027f, 65.83278f, 19.922604f, 73.94714f, 20.081894f);
                h.cubicTo(74.01762f, 21.694714f, 74.01762f, 23.307535f, 73.94714f, 24.920355f);
                h.cubicTo(65.63143f, 25.06969f, 57.315716f, 24.950222f, 49.0f, 25.0f);
                h.cubicTo(49.231552f, 23.3374f, 49.422832f, 21.674803f, 49.614113f, 20.012203f);
                h.lineTo(49.614113f, 20.012203f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(45.0f, 33.156006f);
                h.cubicTo(54.639053f, 32.909058f, 64.29819f, 33.007835f, 73.94729f, 33.096737f);
                h.cubicTo(74.01757f, 34.69697f, 74.01757f, 36.297203f, 73.94729f, 37.897438f);
                h.cubicTo(66.92885f, 37.92707f, 59.90037f, 38.154263f, 52.902016f, 37.818413f);
                h.cubicTo(50.191032f, 36.40586f, 47.23907f, 35.269894f, 45.0f, 33.156006f);
                h.lineTo(45.0f, 33.156006f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(62.0f, 46.0f);
                h.cubicTo(65.97941f, 46.00998f, 69.958824f, 45.98004f, 73.93823f, 46.07984f);
                h.cubicTo(74.01883f, 47.696606f, 74.01883f, 49.313374f, 73.9483f, 50.93014f);
                h.cubicTo(70.70433f, 51.02994f, 67.46036f, 50.99002f, 64.20631f, 51.0f);
                h.cubicTo(63.541393f, 49.303394f, 62.805958f, 47.636726f, 62.0f, 46.0f);
                h.lineTo(62.0f, 46.0f);
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
