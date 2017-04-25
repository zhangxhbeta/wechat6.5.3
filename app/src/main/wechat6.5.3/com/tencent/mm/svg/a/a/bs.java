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

public final class bs extends c {
    private final int height = 146;
    private final int width = 146;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 146;
            case 1:
                return 146;
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
                c = c.a(c, 1.0f, 0.0f, -1253.0f, 0.0f, 1.0f, -604.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1392.0f, 648.0f);
                h.cubicTo(1391.1765f, 640.9243f, 1388.8136f, 637.0981f, 1385.0f, 634.0f);
                h.cubicTo(1368.6759f, 620.1181f, 1352.3064f, 611.3989f, 1340.0f, 607.0f);
                h.cubicTo(1331.9325f, 603.179f, 1320.4619f, 603.16736f, 1313.0f, 606.0f);
                h.cubicTo(1298.5f, 612.7752f, 1281.2194f, 622.7355f, 1268.0f, 634.0f);
                h.cubicTo(1264.1866f, 637.0971f, 1261.8236f, 640.92334f, 1261.0f, 648.0f);
                h.cubicTo(1258.6614f, 658.76666f, 1258.3093f, 691.5712f, 1260.0f, 705.0f);
                h.cubicTo(1261.5854f, 711.72626f, 1263.7052f, 714.86237f, 1269.0f, 720.0f);
                h.cubicTo(1276.9417f, 729.21625f, 1297.691f, 742.8615f, 1314.0f, 748.0f);
                h.cubicTo(1320.385f, 750.52856f, 1332.5227f, 750.5996f, 1339.0f, 748.0f);
                h.cubicTo(1355.9169f, 742.55396f, 1376.0575f, 729.21625f, 1384.0f, 720.0f);
                h.cubicTo(1389.294f, 714.86237f, 1391.4147f, 711.72626f, 1392.0f, 705.0f);
                h.cubicTo(1394.6908f, 691.5722f, 1394.3387f, 658.76764f, 1392.0f, 648.0f);
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
