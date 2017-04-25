package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import junit.framework.Assert;

final class b {
    String dQm;
    Class dQn;
    Class dQo;
    int dQp = 0;
    AppBrandRemoteTaskController dQq;
    int dW;
    String dzg;

    b(int i) {
        this.dW = i;
        String str = AppBrandUI.class.getName() + (i == 0 ? "" : Integer.valueOf(i));
        String str2 = AppBrandTaskPreloadReceiver.class.getName() + (i == 0 ? "" : Integer.valueOf(i));
        try {
            this.dQn = Class.forName(str);
            this.dQo = Class.forName(str2);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage(), false);
        }
        this.dQm = str;
    }
}
