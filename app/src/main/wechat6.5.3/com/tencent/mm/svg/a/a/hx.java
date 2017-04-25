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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class hx extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.222222f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.05f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(0.6666667f, 80.727776f);
                h.cubicTo(0.6666667f, 36.615704f, 36.554333f, 0.7277778f, 80.666664f, 0.7277778f);
                h.cubicTo(124.779f, 0.7277778f, 160.66667f, 36.615704f, 160.66667f, 80.727776f);
                h.cubicTo(160.66667f, 124.83985f, 124.779f, 160.72778f, 80.666664f, 160.72778f);
                h.cubicTo(36.554333f, 160.72778f, 0.6666667f, 124.83985f, 0.6666667f, 80.727776f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16139513);
                h = c.h(looper);
                h.moveTo(94.666664f, 75.727776f);
                h.lineTo(94.666664f, 72.727776f);
                h.lineTo(94.666664f, 65.727776f);
                h.cubicTo(94.666664f, 57.59596f, 88.18667f, 50.72778f, 80.150536f, 50.72778f);
                h.lineTo(79.18279f, 50.72778f);
                h.cubicTo(71.13917f, 50.72778f, 64.666664f, 57.594822f, 64.666664f, 65.727776f);
                h.lineTo(64.666664f, 72.727776f);
                h.lineTo(64.666664f, 75.727776f);
                h.lineTo(94.666664f, 75.727776f);
                h.close();
                h.moveTo(67.666664f, 66.39445f);
                h.cubicTo(67.666664f, 59.320904f, 72.80921f, 53.72778f, 78.666664f, 53.72778f);
                h.lineTo(80.666664f, 53.72778f);
                h.cubicTo(86.524124f, 53.72778f, 91.666664f, 59.320904f, 91.666664f, 66.39445f);
                h.lineTo(91.666664f, 72.727776f);
                h.lineTo(67.666664f, 72.727776f);
                h.lineTo(67.666664f, 66.39445f);
                h.close();
                h.moveTo(94.666664f, 72.727776f);
                h.lineTo(94.666664f, 75.727776f);
                h.lineTo(101.666664f, 75.727776f);
                h.lineTo(101.666664f, 107.727776f);
                h.lineTo(57.666668f, 107.727776f);
                h.lineTo(57.666668f, 75.727776f);
                h.lineTo(64.666664f, 75.727776f);
                h.lineTo(64.666664f, 72.727776f);
                h.lineTo(57.666668f, 72.727776f);
                h.cubicTo(56.894035f, 72.88537f, 56.49158f, 73.059715f, 55.666668f, 73.727776f);
                h.cubicTo(55.42945f, 73.78284f, 54.912796f, 74.532776f, 54.666668f, 75.727776f);
                h.cubicTo(54.68995f, 75.62584f, 54.666668f, 107.727776f, 54.666668f, 107.727776f);
                h.cubicTo(54.666668f, 108.5316f, 55.248734f, 109.55201f, 55.666668f, 109.727776f);
                h.cubicTo(56.664536f, 110.51654f, 57.305363f, 110.727776f, 57.666668f, 110.727776f);
                h.lineTo(101.666664f, 110.727776f);
                h.cubicTo(103.168816f, 110.727776f, 104.666664f, 109.22566f, 104.666664f, 107.727776f);
                h.lineTo(104.666664f, 75.727776f);
                h.cubicTo(104.666664f, 74.228775f, 103.17769f, 72.727776f, 101.666664f, 72.727776f);
                h.lineTo(94.666664f, 72.727776f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
