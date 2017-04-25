package com.tencent.mm.lan_cs;

public final class Server {
    public static a cmS;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            if (Server.cmS != null) {
                Server.cmS.onRecv(str, i, bArr);
            }
        }

        public static void onConnect(String str, int i) {
            if (Server.cmS != null) {
                Server.cmS.onConnect(str, i);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Server.cmS != null) {
                Server.cmS.vW();
            }
        }
    }

    public static class Java2C {
        public static native int send(String str, int i, byte[] bArr);

        private static native Object[] start();

        public static native void stop();
    }

    public interface a {
        void onConnect(String str, int i);

        void onRecv(String str, int i, byte[] bArr);

        void vW();
    }
}
