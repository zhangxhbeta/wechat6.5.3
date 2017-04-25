package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.b;
import com.tencent.mm.sdk.platformtools.v;

public final class C2JavaExDevice {
    private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";

    public static void C2Java_onTaskEnd(long j, int i, int i2, String str, byte[] bArr) {
        a.c(j, i, i2, str);
    }

    public static void C2Java_onStateChange(long j, int i, int i2, int i3) {
        a.b(j, i, i2, i3);
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        a.onDeviceRequest(j, s, s2, bArr, i);
    }

    public static void createSession(long j, long j2) {
        b.createSession(j, j2);
    }

    public static boolean sendData(long j, byte[] bArr) {
        return b.sendData(j, bArr);
    }

    public static boolean connect(long j) {
        return b.connect(j);
    }

    public static void destroySession(long j) {
        b.destroySession(j);
    }

    public static void onAirKissCallback(int i, int i2) {
        v.v(TAG, "onAirKissCallback(errType : %d, errCode : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        j.ajh().f(0, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void onReceiveWCLanDeviceDiscPackage(byte[] bArr) {
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceDiscPackage, dataLen(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        j.ajh().f(10, new Object[]{bArr});
    }

    public static void onWCLanDeviceUdpError(int i) {
        v.i(TAG, "onWCLanDeviceUdpError, errCode(%d).", new Object[]{Integer.valueOf(i)});
        j.ajh().f(11, new Object[]{Integer.valueOf(i)});
    }

    public static void onWCLanReceiveResponse(int i, byte[] bArr) {
        String str = TAG;
        String str2 = "onWCLanReceiveResponse, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        j.ajh().f(12, new Object[]{Integer.valueOf(i), bArr});
    }

    public static void onWCLanDeviceConnectStateNotify(String str, int i) {
        v.i(TAG, "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", new Object[]{str, Integer.valueOf(i)});
        j.ajh().f(13, new Object[]{str, Integer.valueOf(i)});
    }

    public static void onReceiveWCLanDeviceProfile(byte[] bArr) {
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceProfile, data(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        j.ajh().f(14, new Object[]{bArr});
    }

    public static void onWCLanFileTransferUpdate(int i, byte[] bArr) {
        String str = TAG;
        String str2 = "onWCLanFileTransferUpdate, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        j.ajh().f(15, new Object[]{Integer.valueOf(i), bArr});
    }

    public static void onWCLanReceiveNotify(String str, byte[] bArr) {
        String str2 = TAG;
        String str3 = "onWCLanReceiveNotify, devclassinfo(%s), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str2, str3, objArr);
        j.ajh().f(16, new Object[]{str, bArr});
    }
}
