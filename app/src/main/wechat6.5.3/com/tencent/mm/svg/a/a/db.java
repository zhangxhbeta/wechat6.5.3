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

public final class db extends c {
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
                a.setColor(-8355712);
                c = c.a(c, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(-3.5527137E-15f, 24.0f);
                h.cubicTo(8.006664f, 16.0f, 16.013329f, 8.0f, 24.0f, 3.5527137E-15f);
                h.cubicTo(25.549355f, 1.3682896f, 26.918783f, 2.8764045f, 28.0f, 4.0f);
                h.cubicTo(22.620575f, 9.877653f, 17.152853f, 15.440699f, 12.0f, 21.0f);
                h.cubicTo(23.7601f, 20.973783f, 35.875053f, 20.94382f, 48.0f, 21.0f);
                h.lineTo(48.0f, 27.0f);
                h.cubicTo(35.85506f, 27.026217f, 23.710121f, 26.996254f, 12.0f, 27.0f);
                h.cubicTo(17.11287f, 32.5593f, 22.610579f, 38.142323f, 28.0f, 44.0f);
                h.cubicTo(26.878801f, 45.133583f, 25.519367f, 46.651684f, 24.0f, 48.0f);
                h.cubicTo(15.993336f, 40.019974f, 7.9866724f, 32.019974f, -3.5527137E-15f, 24.0f);
                h.lineTo(-3.5527137E-15f, 24.0f);
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
