package com.tencent.mm.lan_cs;

public final class Client {
    public static a cmR;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            if (Client.cmR != null) {
                Client.cmR.onRecv(str, i, bArr);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Client.cmR != null) {
                Client.cmR.vW();
            }
        }
    }

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    public interface a {
        void onRecv(String str, int i, byte[] bArr);

        void vW();
    }
}
