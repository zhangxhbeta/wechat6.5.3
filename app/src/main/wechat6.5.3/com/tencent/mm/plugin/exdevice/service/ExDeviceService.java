package com.tencent.mm.plugin.exdevice.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.plugin.exdevice.devicestep.StepAwakeAlarmReceiver;
import com.tencent.mm.plugin.exdevice.devicestep.a;
import com.tencent.mm.plugin.exdevice.devicestep.c;
import com.tencent.mm.plugin.exdevice.devicestep.d;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.b;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public class ExDeviceService extends Service implements a {
    private SensorManager aHA;
    private x ceL = new x();
    private h.a fxh = null;
    private Sensor fxi;
    private d fxj;
    private boolean fxk = false;

    static /* synthetic */ void e(ExDeviceService exDeviceService) {
        v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step] setSupportDeviceStep()");
        exDeviceService.fxk = false;
        if (exDeviceService.aHA == null) {
            exDeviceService.aHA = (SensorManager) exDeviceService.getSystemService("sensor");
        }
        if (!c.aiF() || exDeviceService.ceL.cfs != 1 || exDeviceService.aHA == null || !exDeviceService.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            return;
        }
        if (exDeviceService.aHA.getDefaultSensor(19) == null) {
            v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], TYPE_STEP_COUNTER sensor null");
            return;
        }
        exDeviceService.fxk = true;
        v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step] isSupportDeviceStep after set:%s", new Object[]{Boolean.valueOf(exDeviceService.fxk)});
    }

    public void onCreate() {
        v.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ExDeviceService fxl;

            {
                this.fxl = r1;
            }

            public final void run() {
                this.fxl.ajK();
                this.fxl.ajI();
            }
        });
    }

    public void onDestroy() {
        v.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ExDeviceService fxl;

            {
                this.fxl = r1;
            }

            public final void run() {
                this.fxl.ajJ();
            }
        });
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!ajH()) {
            v.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            int myPid = Process.myPid();
            b.yH(13);
            Process.killProcess(myPid);
        }
    }

    private static boolean ajH() {
        boolean z;
        PackageManager packageManager = aa.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        v.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        boolean z;
        v.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onStartCommand");
        if (intent == null) {
            z = false;
        } else {
            z = intent.getBooleanExtra("step_stop", false);
            if (z) {
                ajJ();
            }
            v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], isStopFromStart:%s", new Object[]{Boolean.valueOf(z)});
        }
        if (!z) {
            try {
                ajK();
                if (this.fxj != null) {
                    this.fxj.a(this.ceL, this);
                }
                if (getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter") && aiA()) {
                    return super.onStartCommand(intent, 1, i2);
                }
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], Exception onStartCommand %s", new Object[]{e.getMessage()});
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        v.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.fxh == null) {
            this.fxh = new y(this);
        }
        ajK();
        if (this.fxj != null) {
            this.fxj.a(this.ceL, this);
        }
        return this.fxh;
    }

    @TargetApi(19)
    private boolean ajI() {
        try {
            if (!c.aiF()) {
                v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], registerDetector() no need");
                StepAwakeAlarmReceiver.as(aa.getContext());
                return false;
            } else if (this.ceL.cfs != 1) {
                v.i("MicroMsg.exdevice.ExDeviceService", "registerDetector() step switch is off");
                StepAwakeAlarmReceiver.as(aa.getContext());
                return false;
            } else {
                if (this.aHA == null) {
                    this.aHA = (SensorManager) getSystemService("sensor");
                }
                if (this.fxj == null) {
                    this.fxj = new d();
                    this.fxj.a(this.ceL, this);
                }
                if (this.aHA == null || !getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                    v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step] no step sensor");
                    return false;
                }
                this.fxi = this.aHA.getDefaultSensor(19);
                if (this.fxi == null) {
                    v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], TYPE_STEP_COUNTER sensor null");
                    return false;
                }
                boolean registerListener = this.aHA.registerListener(this.fxj, this.fxi, this.ceL.cfo);
                if (registerListener) {
                    this.fxk = true;
                    StepAwakeAlarmReceiver.as(aa.getContext());
                    StepAwakeAlarmReceiver.ar(aa.getContext());
                } else {
                    ajJ();
                }
                v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], registerDetector() ok.(r : %s)", new Object[]{Boolean.valueOf(registerListener)});
                return registerListener;
            }
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], Exception in registerDetector %s", new Object[]{e.getMessage()});
        }
    }

    @TargetApi(19)
    private void ajJ() {
        try {
            v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], unregisterDetector(),isSupportDeviceStep:%s", new Object[]{Boolean.valueOf(this.fxk)});
            if (this.fxk && this.aHA != null && getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                this.aHA.unregisterListener(this.fxj);
                this.fxk = false;
                v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], unregisterDetector() success!");
            }
            StepAwakeAlarmReceiver.as(aa.getContext());
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], Exception in unregisterDetector %s", new Object[]{e.getMessage()});
        }
    }

    public final boolean aiA() {
        if (!this.fxk) {
            v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step] isSupportDeviceStep:%s", new Object[]{Boolean.valueOf(this.fxk)});
            return false;
        } else if (this.ceL.cfs != 1) {
            v.i("MicroMsg.exdevice.ExDeviceService", "refreshStep() step switch is off");
            return false;
        } else {
            try {
                String str = "MicroMsg.exdevice.ExDeviceService";
                String str2 = "[hakon][Step], refreshStep(), %s, %s, %s";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.fxi != null);
                objArr[1] = Boolean.valueOf(this.aHA != null);
                objArr[2] = Boolean.valueOf(this.fxj != null);
                v.i(str, str2, objArr);
                if (this.fxi == null || this.aHA == null || this.fxj == null) {
                    return ajI();
                }
                this.aHA.unregisterListener(this.fxj);
                boolean registerListener = this.aHA.registerListener(this.fxj, this.fxi, this.ceL.cfo);
                if (registerListener && this.fxj != null) {
                    this.fxj.frI = System.currentTimeMillis();
                }
                v.i("MicroMsg.exdevice.ExDeviceService", "try to register counter sensor listener.(succ : %s)", new Object[]{Boolean.valueOf(registerListener)});
                return registerListener;
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.ExDeviceService", "[hakon][Step], Exception in refreshStep %s", new Object[]{e.getMessage()});
                return false;
            }
        }
    }

    public final void aiB() {
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ExDeviceService fxl;

            {
                this.fxl = r1;
            }

            public final void run() {
                this.fxl.fxk = true;
                this.fxl.ajJ();
            }
        });
    }

    private void ajK() {
        if (this.ceL == null) {
            this.ceL = new x();
        }
        try {
            if (this.ceL.cfs != 1) {
                this.ceL.cfo = r.getInt(100, 800000);
                this.ceL.cfp = r.getInt(101, 60000);
                this.ceL.cfr = r.getInt(102, BaseReportManager.MAX_READ_COUNT);
                this.ceL.cfs = r.getInt(103, 0);
            }
            v.i("MicroMsg.exdevice.ExDeviceService", "[hakon][Step]initSensorInfo by sp %s, %s, %s, %s", new Object[]{Integer.valueOf(this.ceL.cfo), Integer.valueOf(this.ceL.cfp), Integer.valueOf(this.ceL.cfr), Integer.valueOf(this.ceL.cfs)});
            com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
                final /* synthetic */ ExDeviceService fxl;

                {
                    this.fxl = r1;
                }

                public final void run() {
                    ExDeviceService.e(this.fxl);
                }
            });
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExDeviceService", "exception in initSensorInfo, %s", new Object[]{e.getMessage()});
        }
    }
}
