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

public final class wx extends c {
    private final int height = 80;
    private final int width = 66;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 80;
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
                a.setColor(-8617594);
                c = c.a(c, 1.0f, 0.0f, -416.0f, 0.0f, 1.0f, -1269.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(482.0f, 1311.7202f);
                h.lineTo(482.0f, 1271.9901f);
                h.cubicTo(482.0f, 1270.3384f, 480.65353f, 1269.0f, 478.9926f, 1269.0f);
                h.lineTo(419.0074f, 1269.0f);
                h.cubicTo(417.3483f, 1269.0f, 416.0f, 1270.3387f, 416.0f, 1271.9901f);
                h.lineTo(416.0f, 1346.0099f);
                h.cubicTo(416.0f, 1347.6616f, 417.34647f, 1349.0f, 419.0074f, 1349.0f);
                h.lineTo(478.9926f, 1349.0f);
                h.cubicTo(480.6517f, 1349.0f, 482.0f, 1347.6613f, 482.0f, 1346.0099f);
                h.lineTo(482.0f, 1316.9371f);
                h.lineTo(449.52548f, 1336.6007f);
                h.lineTo(449.2816f, 1336.748f);
                h.cubicTo(448.97964f, 1336.9077f, 448.63965f, 1337.0f, 448.2788f, 1337.0f);
                h.cubicTo(447.44376f, 1337.0f, 446.71753f, 1336.517f, 446.33582f, 1335.8048f);
                h.lineTo(446.18982f, 1335.4691f);
                h.lineTo(440.107f, 1321.471f);
                h.cubicTo(440.0408f, 1321.3179f, 440.0f, 1321.1458f, 440.0f, 1320.9784f);
                h.cubicTo(440.0f, 1320.3337f, 440.49866f, 1319.8098f, 441.1143f, 1319.8098f);
                h.cubicTo(441.36453f, 1319.8098f, 441.59482f, 1319.8964f, 441.7807f, 1320.0417f);
                h.lineTo(448.9588f, 1325.4017f);
                h.cubicTo(449.48376f, 1325.7621f, 450.11026f, 1325.9731f, 450.78394f, 1325.9731f);
                h.cubicTo(451.18558f, 1325.9731f, 451.5691f, 1325.8942f, 451.92633f, 1325.7583f);
                h.lineTo(482.0f, 1311.7202f);
                h.close();
                h.moveTo(428.0f, 1294.5f);
                h.lineTo(452.0f, 1294.5f);
                h.lineTo(452.0f, 1299.0f);
                h.lineTo(428.0f, 1299.0f);
                h.lineTo(428.0f, 1294.5f);
                h.close();
                h.moveTo(428.0f, 1281.0f);
                h.lineTo(452.0f, 1281.0f);
                h.lineTo(452.0f, 1285.5f);
                h.lineTo(428.0f, 1285.5f);
                h.lineTo(428.0f, 1281.0f);
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
