package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.b;
import java.net.MalformedURLException;
import java.net.URL;

public final class e extends a {
    private String[] a = new String[]{"http://m0.map.gtimg.com/hwap", "http://m1.map.gtimg.com/hwap", "http://m2.map.gtimg.com/hwap", "http://m3.map.gtimg.com/hwap"};

    public e(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        int i4 = 0;
        int i5 = b.a;
        if (objArr != null) {
            try {
                if (objArr.length == 2) {
                    i4 = Integer.parseInt(objArr[0].toString());
                    i5 = Integer.parseInt(objArr[1].toString());
                }
            } catch (Exception e) {
            }
        }
        try {
            int a = a.a(i + i2, this.a.length);
            int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append(this.a[a]);
            stringBuilder.append("?");
            stringBuilder.append("z=");
            stringBuilder.append(i3 - 1);
            stringBuilder.append("&x=");
            stringBuilder.append(i);
            stringBuilder.append("&y=");
            stringBuilder.append(pow);
            stringBuilder.append("&styleid=");
            stringBuilder.append(b.e);
            stringBuilder.append("&scene=");
            stringBuilder.append(i4);
            stringBuilder.append("&version=");
            stringBuilder.append(i5);
            return new URL(stringBuilder.toString());
        } catch (MalformedURLException e2) {
            new StringBuilder("Error new URL with str:").append(null);
            return null;
        }
    }
}
