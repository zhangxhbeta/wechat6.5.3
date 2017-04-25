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

public final class afo extends c {
    private final int height = 81;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 81;
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
                a.setColor(-2565928);
                c = c.a(c, 1.0f, 0.0f, -1531.0f, 0.0f, 1.0f, -1102.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1582.0f, 1105.561f);
                h.cubicTo(1574.8075f, 1109.677f, 1570.0f, 1116.952f, 1570.0f, 1125.25f);
                h.lineTo(1570.0f, 1159.75f);
                h.cubicTo(1570.0f, 1165.963f, 1563.955f, 1171.0f, 1556.5f, 1171.0f);
                h.cubicTo(1549.0435f, 1171.0f, 1543.0f, 1165.963f, 1543.0f, 1159.75f);
                h.cubicTo(1543.0f, 1155.328f, 1546.069f, 1151.5135f, 1550.5225f, 1149.6746f);
                h.cubicTo(1550.8435f, 1149.5425f, 1551.169f, 1149.4165f, 1551.5035f, 1149.3055f);
                h.cubicTo(1554.307f, 1148.1805f, 1556.7115f, 1146.0685f, 1557.604f, 1143.616f);
                h.cubicTo(1558.9225f, 1139.995f, 1556.4685f, 1137.061f, 1552.1245f, 1137.061f);
                h.cubicTo(1551.0415f, 1137.061f, 1549.9435f, 1137.244f, 1548.8845f, 1137.574f);
                h.cubicTo(1542.589f, 1139.3815f, 1537.3466f, 1143.3354f, 1534.1995f, 1148.5f);
                h.cubicTo(1532.167f, 1151.8375f, 1531.0f, 1155.67f, 1531.0f, 1159.75f);
                h.cubicTo(1531.0f, 1172.5706f, 1542.439f, 1183.0f, 1556.5f, 1183.0f);
                h.cubicTo(1561.4604f, 1183.0f, 1566.079f, 1181.6815f, 1570.0f, 1179.439f);
                h.cubicTo(1577.1925f, 1175.323f, 1582.0f, 1168.048f, 1582.0f, 1159.75f);
                h.lineTo(1582.0f, 1125.25f);
                h.cubicTo(1582.0f, 1119.037f, 1588.0435f, 1114.0f, 1595.5f, 1114.0f);
                h.cubicTo(1602.955f, 1114.0f, 1609.0f, 1119.037f, 1609.0f, 1125.25f);
                h.cubicTo(1609.0f, 1129.861f, 1605.6715f, 1133.824f, 1600.906f, 1135.561f);
                h.cubicTo(1597.8325f, 1136.5916f, 1595.314f, 1138.816f, 1594.354f, 1141.4515f);
                h.cubicTo(1593.043f, 1145.0544f, 1595.485f, 1147.9764f, 1599.8094f, 1147.9764f);
                h.cubicTo(1600.789f, 1147.9764f, 1601.779f, 1147.8085f, 1602.7435f, 1147.5355f);
                h.cubicTo(1602.901f, 1147.492f, 1603.057f, 1147.444f, 1603.213f, 1147.3975f);
                h.cubicTo(1609.456f, 1145.584f, 1614.667f, 1141.642f, 1617.799f, 1136.5f);
                h.cubicTo(1619.833f, 1133.164f, 1621.0f, 1129.33f, 1621.0f, 1125.25f);
                h.cubicTo(1621.0f, 1112.4294f, 1609.561f, 1102.0f, 1595.5f, 1102.0f);
                h.cubicTo(1590.5396f, 1102.0f, 1585.921f, 1103.3185f, 1582.0f, 1105.561f);
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
