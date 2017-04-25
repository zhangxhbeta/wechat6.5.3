package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

public final class f extends a {
    public f(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        if (i3 < 10) {
            return null;
        }
        String str = "http://rtt2.map.qq.com/live/" + i3 + '/' + (i / 10) + '/' + (i2 / 10) + '/' + i + '_' + i2 + ".png?timeKey=" + System.currentTimeMillis();
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            getClass().getSimpleName();
            new StringBuilder("Can not convert ").append(str).append(" to URL.");
            return null;
        }
    }
}
