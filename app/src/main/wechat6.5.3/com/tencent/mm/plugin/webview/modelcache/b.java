package com.tencent.mm.plugin.webview.modelcache;

public final class b {

    public enum a {
        HTTP(1),
        HTTPS(2);
        
        final int bkU;

        private a(int i) {
            this.bkU = i;
        }

        public static boolean sE(int i) {
            return (HTTP.bkU & i) > 0;
        }

        public static boolean sF(int i) {
            return (HTTPS.bkU & i) > 0;
        }

        public static int sG(int i) {
            return HTTP.bkU | i;
        }

        public static int sH(int i) {
            return HTTPS.bkU | i;
        }

        public static String toString(int i) {
            String str = "[ %s | %s ]";
            Object[] objArr = new Object[2];
            objArr[0] = sE(i) ? "http" : "-";
            objArr[1] = sF(i) ? "https" : "-";
            return String.format(str, objArr);
        }
    }
}
