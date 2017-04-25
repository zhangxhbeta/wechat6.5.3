package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.s;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MountReceiver extends BroadcastReceiver {
    private String bXP = SQLiteDatabase.KeyEmpty;
    private ac bXQ = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ MountReceiver bXR;

        public final void handleMessage(Message message) {
            boolean z = true;
            String str = "MicroMsg.MountReceiver";
            String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
            Object[] objArr = new Object[4];
            objArr[0] = this.bXR.bXP;
            objArr[1] = Boolean.valueOf(ak.uz());
            if (this.bXR.context != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(t.Nl());
            v.d(str, str2, objArr);
            if (this.bXR.context != null && t.Nl()) {
                s.ez(this.bXR.context);
            }
        }
    };
    private Context context = null;

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !t.kS(intent.getAction()) && ak.uz()) {
            this.context = context;
            this.bXP = intent.getAction();
            try {
                StatFs statFs = new StatFs(e.cni);
                v.i("MicroMsg.MountReceiver", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", e.cni, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
            } catch (Exception e) {
                v.e("MicroMsg.MountReceiver", "check data size failed :%s", e.getMessage());
            }
            v.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b", this.bXP, Boolean.valueOf(ak.uz()));
            boolean equals = this.bXP.equals("android.intent.action.MEDIA_MOUNTED");
            if (equals || this.bXP.equals("android.intent.action.MEDIA_EJECT") || this.bXP.equals("android.intent.action.MEDIA_SHARED")) {
                Uri data = intent.getData();
                if (data != null) {
                    String path = data.getPath();
                    if (!e.cni.equalsIgnoreCase(path)) {
                        if (equals && e.cni.equalsIgnoreCase("/dev/null")) {
                            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                            if (!t.kS(absolutePath) && absolutePath.equalsIgnoreCase(path)) {
                                q qVar = new q(com.tencent.mm.storage.t.cng + "SdcardInfo.cfg");
                                path = (String) qVar.get(1, SQLiteDatabase.KeyEmpty);
                                int intValue = ((Integer) qVar.get(2, Integer.valueOf(0))).intValue();
                                int i = VERSION.SDK_INT;
                                String str = e.cni;
                                qVar.set(1, absolutePath);
                                qVar.set(2, Integer.valueOf(i));
                                e.dt(absolutePath);
                                v.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), path, Integer.valueOf(i), absolutePath, str, e.cni);
                                g.iuh.a(340, 9, 1, false);
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                if (equals) {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ MountReceiver bXR;

                        {
                            this.bXR = r1;
                        }

                        public final void run() {
                            v.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", this.bXR.bXP, Boolean.valueOf(ak.uz()));
                            if (ak.uz()) {
                                ak.vi();
                                ak.yW();
                                c.vh();
                                this.bXR.bXQ.sendEmptyMessage(0);
                            }
                        }
                    });
                    return;
                }
                s.ey(context);
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ MountReceiver bXR;

                    {
                        this.bXR = r1;
                    }

                    public final void run() {
                        v.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", this.bXR.bXP, Boolean.valueOf(ak.uz()));
                        if (ak.uz()) {
                            ak.vi();
                            ak.yW();
                            c.vh();
                        }
                    }
                });
            }
        }
    }
}
