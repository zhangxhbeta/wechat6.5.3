package com.tencent.mm.kernel;

import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public final class d {
    private ProcessProfile cjS;

    public d(ProcessProfile processProfile) {
        this.cjS = processProfile;
    }

    public final synchronized ProcessProfile uZ() {
        return this.cjS;
    }

    public static boolean b(ProcessProfile processProfile) {
        Assert.assertNotNull(processProfile);
        String processName = processProfile.getProcessName();
        return processName != null && processName.equals(aa.getPackageName() + SQLiteDatabase.KeyEmpty);
    }

    public static boolean a(ProcessProfile processProfile, String str) {
        return (processProfile == null || processProfile.getProcessName() == null || !processProfile.getProcessName().equals(aa.getPackageName() + str)) ? false : true;
    }
}
