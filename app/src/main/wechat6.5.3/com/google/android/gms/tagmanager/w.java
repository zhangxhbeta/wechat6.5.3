package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class w {
    private static w aCy;
    volatile String aBV = null;
    volatile String aCA = null;
    private volatile String aCB = null;
    volatile int aCz = a.aCC;

    enum a {
        ;

        static {
            aCC = 1;
            aCD = 2;
            aCE = 3;
            aCF = new int[]{aCC, aCD, aCE};
        }

        public static int[] mh() {
            return (int[]) aCF.clone();
        }
    }

    w() {
    }

    private static String an(String str) {
        return str.split("&")[0].split("=")[1];
    }

    static w mg() {
        w wVar;
        synchronized (w.class) {
            if (aCy == null) {
                aCy = new w();
            }
            wVar = aCy;
        }
        return wVar;
    }

    final synchronized boolean d(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    new StringBuilder("Container preview url: ").append(decode);
                    m.lP();
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.aCz = a.aCE;
                    } else {
                        this.aCz = a.aCD;
                    }
                    this.aCB = uri.getQuery().replace("&gtm_debug=x", "");
                    if (this.aCz == a.aCD || this.aCz == a.aCE) {
                        this.aCA = "/r?" + this.aCB;
                    }
                    this.aBV = an(this.aCB);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        new StringBuilder("Invalid preview uri: ").append(decode);
                        m.lN();
                        z = false;
                    } else if (an(uri.getQuery()).equals(this.aBV)) {
                        new StringBuilder("Exit preview mode for container: ").append(this.aBV);
                        m.lP();
                        this.aCz = a.aCC;
                        this.aCA = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
