package ct;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class br {
    private static br g = null;
    private ArrayList<Float> a = new ArrayList();
    private float b = 0.0f;
    private float c = 0.0f;
    private float d = 100.0f;
    private boolean e = false;
    private boolean f = false;

    public static br a() {
        if (g == null) {
            synchronized (br.class) {
                if (g == null) {
                    g = new br();
                }
            }
        }
        return g;
    }

    private br() {
    }

    public final boolean a(GpsStatus gpsStatus) {
        int maxSatellites = gpsStatus.getMaxSatellites();
        Iterator it = gpsStatus.getSatellites().iterator();
        this.a.clear();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (it.hasNext() && i <= maxSatellites) {
            i++;
            this.a.add(Float.valueOf(((GpsSatellite) it.next()).getSnr()));
        }
        stringBuilder.append(i + "颗卫星,");
        if (this.a.size() >= 5) {
            float[] fArr = new float[this.a.size()];
            for (i = 0; i < fArr.length; i++) {
                fArr[i] = ((Float) this.a.get(i)).floatValue();
            }
            Arrays.sort(fArr);
            float[] fArr2 = new float[5];
            float f = 0.0f;
            for (int i2 = 0; i2 < 5; i2++) {
                fArr2[i2] = fArr[(fArr.length - 1) - i2];
                f += fArr2[i2];
            }
            float f2 = f / 5.0f;
            stringBuilder.append("\n");
            stringBuilder.append("绝对判断：");
            if (fArr2[0] > 35.0f) {
                this.e = true;
                stringBuilder.append("室外|");
            } else if (f2 > 30.0f) {
                this.e = true;
                stringBuilder.append("室外|");
            }
            if (f2 < 22.0f) {
                stringBuilder.append("室内|");
                this.e = false;
            }
            stringBuilder.append("avg" + f2);
            stringBuilder.append("avg'" + (f2 - this.b));
            stringBuilder.append("avgMax" + this.c);
            stringBuilder.append("avgMin" + this.d);
            stringBuilder.append(this.e);
            stringBuilder.append("\n");
            if (this.c < f2) {
                this.c = f2;
            }
            if (this.d > f2) {
                this.d = f2;
            }
            this.b = f2;
            stringBuilder.append("相对判断：");
            if (f2 - this.b > 3.0f) {
                stringBuilder.append("信号增强");
            }
            if (this.b - f2 > 2.0f) {
                stringBuilder.append("信号衰弱");
                this.f = false;
            }
            if (f2 > (this.c + this.d) / 2.0f) {
                this.f = true;
            } else if (f2 < 22.0f) {
                this.f = false;
            }
            if (this.e != this.f) {
                stringBuilder.append("\n冲突" + this.e + "|" + this.f);
            }
            stringBuilder.append("\n最终结果" + this.f);
        }
        return this.f;
    }
}
