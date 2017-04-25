package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.d.e;
import java.net.MalformedURLException;
import java.net.URL;

public class b extends a {
    private String[] a = new String[]{"http://s0.map.gtimg.com/oversea", "http://s1.map.gtimg.com/oversea", "http://s2.map.gtimg.com/oversea", "http://s3.map.gtimg.com/oversea"};

    public b(int i) {
        super(i);
    }

    public URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        int u = e.u();
        int t = e.t();
        String w = e.w();
        int v = e.v();
        String str = this.a[a.a(i + i2, this.a.length)];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?z=").append(i3).append("&x=").append(i).append("&y=").append(i2).append("&styleid=").append(v).append("&scene=").append(u).append("&version=").append(t).append("&ch=").append(w);
        try {
            return new URL(stringBuilder.toString());
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
