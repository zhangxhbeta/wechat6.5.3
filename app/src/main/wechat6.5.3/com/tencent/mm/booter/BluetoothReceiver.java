package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Set;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !be.kS(intent.getAction())) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                v.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
                return;
            }
            Set bondedDevices = defaultAdapter.getBondedDevices();
            if (bondedDevices == null || bondedDevices.size() == 0) {
                v.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            } else if (!be.kS(intent.getAction())) {
                v.d("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
                if (ak.uz()) {
                    int intExtra;
                    try {
                        intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                    } catch (Throwable e) {
                        v.e("MicroMsg.BluetoothReceiver", "%s", be.e(e));
                        intExtra = 0;
                    }
                    v.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + intent.getAction() + " state:" + intExtra + " isBluetoothScoOn :" + ak.yX().qU() + " " + ak.yX().qY());
                    if (intExtra == 1) {
                        v.d("MicroMsg.BluetoothReceiver", "sco connected!");
                        v.d("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", ak.yX().qY());
                        d.cbd = true;
                        r0.dM(1);
                    } else if (intExtra == 0) {
                        v.d("MicroMsg.BluetoothReceiver", "sco disconnected!");
                        if (p.ceJ.cdn == 1) {
                            ak.yX().qT();
                        }
                        ak.yX().qR();
                    }
                }
            }
        }
    }
}
