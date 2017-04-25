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

public final class vw extends c {
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
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(20.0f, 0.0f);
                h.cubicTo(24.043653f, -0.100149184f, 27.97626f, -0.100149184f, 32.0f, 0.0f);
                h.cubicTo(32.496265f, 1.185864f, 33.113537f, 2.0959656f, 34.0f, 3.0f);
                h.cubicTo(39.09707f, 3.2731621f, 44.52307f, 2.7092948f, 50.0f, 3.0f);
                h.cubicTo(52.66705f, 4.301973f, 51.60176f, 7.7643156f, 52.0f, 10.0f);
                h.cubicTo(34.666668f, 9.980215f, 17.333334f, 9.990108f, 0.0f, 10.0f);
                h.cubicTo(0.37832662f, 7.774208f, -0.68696153f, 4.301973f, 2.0f, 3.0f);
                h.cubicTo(7.447061f, 2.6994023f, 12.892973f, 3.2731621f, 18.0f, 3.0f);
                h.cubicTo(18.866552f, 2.0860732f, 19.483822f, 1.1759715f, 20.0f, 0.0f);
                h.lineTo(20.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(5.042304f, 13.0f);
                h.cubicTo(19.033339f, 13.009979f, 33.001717f, 13.009979f, 46.982407f, 13.0f);
                h.cubicTo(46.930187f, 27.021309f, 47.02996f, 41.042618f, 46.982407f, 54.974316f);
                h.cubicTo(47.14969f, 56.80037f, 46.122017f, 58.936f, 43.986683f, 58.971867f);
                h.cubicTo(32.75228f, 59.085693f, 21.37803f, 58.806267f, 10.035173f, 58.971867f);
                h.cubicTo(8.018272f, 59.095673f, 5.0250483f, 58.656574f, 5.042304f, 55.9737f);
                h.cubicTo(4.905319f, 41.691288f, 5.1547546f, 27.340654f, 5.042304f, 13.0f);
                h.lineTo(5.042304f, 13.0f);
                h.close();
                h.moveTo(33.95864f, 22.990421f);
                h.cubicTo(33.95864f, 22.440388f, 34.401363f, 21.994495f, 34.96657f, 21.994495f);
                h.lineTo(36.945007f, 21.994495f);
                h.cubicTo(37.50167f, 21.994495f, 37.952938f, 22.43404f, 37.952938f, 22.990421f);
                h.lineTo(37.952938f, 48.981445f);
                h.cubicTo(37.952938f, 49.531483f, 37.510216f, 49.97737f, 36.945007f, 49.97737f);
                h.lineTo(34.96657f, 49.97737f);
                h.cubicTo(34.40991f, 49.97737f, 33.95864f, 49.537827f, 33.95864f, 48.981445f);
                h.lineTo(33.95864f, 22.990421f);
                h.close();
                h.moveTo(24.015207f, 22.990421f);
                h.cubicTo(24.015207f, 22.440388f, 24.457928f, 21.994495f, 25.023136f, 21.994495f);
                h.lineTo(27.001574f, 21.994495f);
                h.cubicTo(27.558237f, 21.994495f, 28.009502f, 22.43404f, 28.009502f, 22.990421f);
                h.lineTo(28.009502f, 48.981445f);
                h.cubicTo(28.009502f, 49.531483f, 27.566782f, 49.97737f, 27.001574f, 49.97737f);
                h.lineTo(25.023136f, 49.97737f);
                h.cubicTo(24.466473f, 49.97737f, 24.015207f, 49.537827f, 24.015207f, 48.981445f);
                h.lineTo(24.015207f, 22.990421f);
                h.close();
                h.moveTo(14.071774f, 22.990421f);
                h.cubicTo(14.071774f, 22.440388f, 14.514494f, 21.994495f, 15.079702f, 21.994495f);
                h.lineTo(17.05814f, 21.994495f);
                h.cubicTo(17.614803f, 21.994495f, 18.066069f, 22.43404f, 18.066069f, 22.990421f);
                h.lineTo(18.066069f, 48.981445f);
                h.cubicTo(18.066069f, 49.531483f, 17.623348f, 49.97737f, 17.05814f, 49.97737f);
                h.lineTo(15.079702f, 49.97737f);
                h.cubicTo(14.523039f, 49.97737f, 14.071774f, 49.537827f, 14.071774f, 48.981445f);
                h.lineTo(14.071774f, 22.990421f);
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
