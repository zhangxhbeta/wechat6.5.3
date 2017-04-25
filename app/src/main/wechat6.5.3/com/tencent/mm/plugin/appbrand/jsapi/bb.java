package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bb extends a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final void a(h hVar, JSONObject jSONObject, int i) {
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(hVar.dzg);
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.dJz = System.currentTimeMillis();
        reportSubmitFormTask.dJA = hVar.dNn.dON;
        AppBrandMainProcessService.a(reportSubmitFormTask);
        Map hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.dJz);
        AppBrandStatObject ms = a.ms(hVar.dzg);
        if (ms != null) {
            ms.dJz = reportSubmitFormTask.dJz;
        }
        hVar.y(i, c("ok", hashMap));
    }
}
