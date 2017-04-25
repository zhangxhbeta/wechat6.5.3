package com.tencent.mm.y;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends w {
    public final void transfer(int i) {
        v.i("MicroMsg.App.StepDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (eH(i)) {
            v.i("MicroMsg.App.StepDataTransfer", "start transfer");
            SharedPreferences btm = aa.btm();
            r.i(202, btm.getLong("com.tencent.mm_device_today_time", r.getLong(202, 0)));
            r.ar(201, btm.getInt("com.tencent.mm_device_today_step", r.getInt(201, 0)));
            r.ar(203, btm.getInt("com.tencent.mm_device_previous_step", r.getInt(203, 0)));
            r.i(204, btm.getLong("com.tencent.mm_device_last_step_time", r.getLong(204, 0)));
            int i2 = r.getInt(MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0);
            int i3 = btm.getInt("step_counter_switch", 0);
            if (i2 == 0 && i3 == 1) {
                r.ar(MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 1);
            }
            v.i("MicroMsg.App.StepDataTransfer", "step data migration succ.(tStepCfg:%s, tStepSp:%s, tTimeCfg:%s, tTimeSp:%s, pStepCfg:%s, pStepSp:%s, lStepCfg:%s, lStepSp:%s, switchCfg:%s, switchSp:%s)", Integer.valueOf(r3), Integer.valueOf(r8), Long.valueOf(r4), Long.valueOf(r6), Integer.valueOf(r9), Integer.valueOf(r10), Long.valueOf(r12), Long.valueOf(r14), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public final boolean eH(int i) {
        return i != 0 && i < 637666560;
    }

    public final String getTag() {
        return "MicroMsg.App.StepDataTransfer";
    }
}
