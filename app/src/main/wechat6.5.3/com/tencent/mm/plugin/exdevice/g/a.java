package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static void g(long j, int i) {
        b sp = ac.ajq().sp(String.valueOf(j));
        if (sp == null) {
            v.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sp.field_deviceType).append(',');
        stringBuilder.append(sp.field_deviceID).append(',');
        stringBuilder.append(i);
        g.iuh.Y(11232, stringBuilder.toString());
    }
}
