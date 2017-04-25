package com.tencent.mm.plugin.c.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static boolean by(Context context) {
        v.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean Xu() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    public static boolean Xw() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    public static String aL(long j) {
        return b.br(j);
    }
}
