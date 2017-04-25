package com.tencent.mm.plugin.exdevice.devicestep;

import android.annotation.TargetApi;
import android.hardware.SensorManager;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    private static Boolean frw = null;
    private static Boolean frx = null;
    private static Boolean fry = null;
    private static Boolean frz = null;

    @TargetApi(19)
    public static boolean aiC() {
        try {
            if (frw == null) {
                if (!aa.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter") || ((SensorManager) aa.getContext().getSystemService("sensor")).getDefaultSensor(19) == null) {
                    frw = Boolean.valueOf(false);
                } else {
                    Boolean valueOf = Boolean.valueOf(true);
                    frw = valueOf;
                    return valueOf.booleanValue();
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.StepConfig", "[hakon][Step], Exception in hasStepCounterHardware %s", new Object[]{e.getMessage()});
        }
        return frw.booleanValue();
    }

    public static boolean cI(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        r.ar(302, i);
        frx = Boolean.valueOf(z);
        v.i("MicroMsg.exdevice.StepConfig", "[hakon][Step]configDeviceNeedStepCounter %s", new Object[]{Boolean.valueOf(z)});
        return true;
    }

    public static boolean aiD() {
        try {
            if (frx != null) {
                return frx.booleanValue();
            }
            if (r.getInt(302, 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.exdevice.StepConfig", "[hakon][Step]Exception in isDeviceNeedStepCounter %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    public static boolean cJ(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        r.ar(301, i);
        fry = Boolean.valueOf(z);
        v.i("MicroMsg.exdevice.StepConfig", "[hakon][Step]configUserWantStepCounter %s", new Object[]{Boolean.valueOf(z)});
        return true;
    }

    public static boolean cK(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        r.ar(303, i);
        frz = Boolean.valueOf(z);
        v.i("MicroMsg.exdevice.StepConfig", "[hakon][Step]configUserRecordData %s", new Object[]{Boolean.valueOf(z)});
        return true;
    }

    public static boolean aiE() {
        return frz == null ? true : frz.booleanValue();
    }

    public static boolean aiF() {
        try {
            boolean booleanValue = frx != null ? frx.booleanValue() : r.getInt(302, 0) == 1;
            v.i("MicroMsg.exdevice.StepConfig", "[hakon][Step]deviceNeed %s, userNeed %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(true)});
            if (booleanValue) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.StepConfig", "[hakon][Step]Exception in isBothUserAndDeviceNeedStepCounter %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
