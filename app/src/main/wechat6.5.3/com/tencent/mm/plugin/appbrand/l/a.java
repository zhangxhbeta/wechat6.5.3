package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.appbrand.l.d.d;
import java.net.InetSocketAddress;

public interface a {

    public enum a {
        ;

        static {
            dTl = 1;
            dTm = 2;
            dTn = 3;
            dTo = 4;
            dTp = 5;
            dTq = new int[]{dTl, dTm, dTn, dTo, dTp};
        }
    }

    public enum b {
        ;

        static {
            dTr = 1;
            dTs = 2;
            dTt = new int[]{dTr, dTs};
        }
    }

    InetSocketAddress Sq();

    void a(d dVar);
}
