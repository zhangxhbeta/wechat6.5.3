package ct;

import java.util.ArrayList;
import java.util.List;

public final class cu {
    private static double[][] a = new double[][]{new double[]{53.540307d, 122.380829d}, new double[]{53.399707d, 120.821285d}, new double[]{52.749594d, 119.919891d}, new double[]{49.95122d, 116.580048d}, new double[]{47.901614d, 115.437469d}, new double[]{47.070122d, 118.381805d}, new double[]{45.213004d, 112.009735d}, new double[]{42.714732d, 107.83493d}, new double[]{42.779275d, 100.100555d}, new double[]{42.90816d, 96.49704d}, new double[]{44.43378d, 95.442352d}, new double[]{45.614037d, 91.091766d}, new double[]{47.606163d, 91.003876d}, new double[]{49.439557d, 87.180634d}, new double[]{47.398349d, 82.961884d}, new double[]{44.964798d, 79.753876d}, new double[]{42.358544d, 79.885712d}, new double[]{40.513799d, 73.689423d}, new double[]{36.5626d, 73.758774d}, new double[]{33.760882d, 76.457977d}, new double[]{31.989442d, 77.688446d}, new double[]{28.497661d, 84.280243d}, new double[]{27.166695d, 88.394279d}, new double[]{26.755421d, 92.118645d}, new double[]{27.936181d, 97.379379d}, new double[]{24.166802d, 97.115707d}, new double[]{21.350781d, 99.972153d}, new double[]{21.105d, 101.707993d}, new double[]{23.120154d, 105.355453d}, new double[]{21.915019d, 106.646605d}, new double[]{21.350781d, 107.684555d}, new double[]{16.762468d, 109.002914d}, new double[]{18.729502d, 111.174774d}, new double[]{21.2689d, 112.782211d}, new double[]{22.998852d, 117.176743d}, new double[]{25.019304d, 119.973391d}, new double[]{27.117813d, 120.890121d}, new double[]{27.76133d, 121.821041d}, new double[]{30.097613d, 123.451653d}, new double[]{33.155948d, 120.999985d}, new double[]{35.209722d, 120.143051d}, new double[]{36.914764d, 122.913322d}, new double[]{39.842286d, 124.273911d}, new double[]{41.294317d, 128.272934d}, new double[]{42.815551d, 131.197872d}, new double[]{45.02695d, 133.172836d}, new double[]{48.04871d, 135.040512d}, new double[]{48.618385d, 134.337387d}, new double[]{47.886881d, 131.700668d}, new double[]{49.196064d, 130.536118d}, new double[]{50.708634d, 127.613754d}, new double[]{53.13359d, 125.833969d}, new double[]{53.657661d, 123.329086d}};
    private static double b = 360.0d;
    private static double c = 360.0d;
    private static double d = -360.0d;
    private static double e = -360.0d;
    private static List<a> f = new ArrayList();

    static class a {
        double a;
        double b;

        public a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    static {
        a();
    }

    private static void a() {
        for (int i = 0; i < a.length; i++) {
            double d = a[i][0];
            double d2 = a[i][1];
            if (d < c) {
                c = d;
            }
            if (d > e) {
                e = d;
            }
            if (d2 < b) {
                b = d2;
            }
            if (d2 > d) {
                d = d2;
            }
            f.add(new a(d, d2));
        }
    }

    public static boolean a(double d, double d2) {
        if (d < c || d2 < b || d > e || d2 > d) {
            return false;
        }
        a aVar = (a) f.get(0);
        int size = f.size();
        a aVar2 = aVar;
        int i = 0;
        int i2 = 1;
        while (i2 <= size) {
            aVar = (a) f.get(i2 % size);
            if (d > Math.min(aVar2.a, aVar.a) && d <= Math.max(aVar2.a, aVar.a) && d2 <= Math.max(aVar2.b, aVar.b) && aVar2.a != aVar.a) {
                double d3 = (((d - aVar2.a) * (aVar.b - aVar2.b)) / (aVar.a - aVar2.a)) + aVar2.b;
                if (aVar2.b == aVar.b || d2 <= d3) {
                    i++;
                }
            }
            i2++;
            aVar2 = aVar;
        }
        if ((i % 2 == 0 ? null : 1) != null) {
            return true;
        }
        return false;
    }
}
