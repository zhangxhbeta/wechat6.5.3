package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

public final class d extends a {
    private String[] a = new String[]{"http://p0.map.gtimg.com/sateTiles", "http://p1.map.gtimg.com/sateTiles", "http://p2.map.gtimg.com/sateTiles", "http://p3.map.gtimg.com/sateTiles"};

    public d(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
        try {
            return new URL(this.a[a.a(i + pow, 4)] + '/' + i3 + '/' + (i >> 4) + '/' + (pow >> 4) + '/' + i + '_' + pow + ".jpg");
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
