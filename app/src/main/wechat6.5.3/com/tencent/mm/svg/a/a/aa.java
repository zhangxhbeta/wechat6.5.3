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

public final class aa extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.3958402f, 1.5091976f);
                h.cubicTo(3.783774f, 0.71045625f, 5.511202f, 1.1397798f, 7.0389276f, 1.0f);
                h.cubicTo(20.049559f, 1.0898584f, 33.06019f, 0.9301101f, 46.060833f, 1.0698899f);
                h.cubicTo(48.067844f, 0.95007867f, 49.24609f, 3.1366334f, 48.95652f, 4.913833f);
                h.cubicTo(48.93655f, 15.956433f, 49.046387f, 27.009018f, 48.906597f, 38.061604f);
                h.cubicTo(48.97649f, 40.038486f, 46.8896f, 41.276535f, 45.08229f, 40.947056f);
                h.cubicTo(31.3727f, 40.927086f, 17.66311f, 41.026928f, 3.953521f, 40.90712f);
                h.cubicTo(1.9564942f, 41.026928f, 0.73830783f, 38.890297f, 1.047847f, 37.09313f);
                h.cubicTo(1.0079064f, 26.719473f, 1.0678172f, 16.335835f, 1.0178915f, 5.9521966f);
                h.cubicTo(1.0678172f, 4.4046354f, 0.82817405f, 2.4277503f, 2.3958402f, 1.5091976f);
                h.lineTo(2.3958402f, 1.5091976f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.01634f, 14.457662f);
                h.cubicTo(57.03326f, 10.022178f, 61.740986f, 5.203629f, 66.96736f, 1.0f);
                h.cubicTo(68.35375f, 3.0665324f, 67.924866f, 5.6169353f, 67.97474f, 7.955645f);
                h.cubicTo(67.94482f, 17.713709f, 67.97474f, 27.471775f, 67.97474f, 37.22984f);
                h.cubicTo(68.01463f, 38.590725f, 67.675514f, 39.840725f, 66.95739f, 41.0f);
                h.cubicTo(61.731014f, 36.836693f, 57.08313f, 31.997984f, 52.036285f, 27.612904f);
                h.cubicTo(51.97644f, 23.227823f, 52.006363f, 18.842741f, 52.01634f, 14.457662f);
                h.lineTo(52.01634f, 14.457662f);
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
