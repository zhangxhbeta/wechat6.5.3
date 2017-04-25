package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.aa;
import java.io.File;

public class a {
    public static final String cnf;
    public static final String cng = (cnf + "MicroMsg/");
    public static final String cnh = (cnf + "files/public/");
    public static String cni = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String cnj = (cni + dEh);
    public static String cnk = (cnj + "crash/");
    public static String dEh = "/tencent/MicroMsg/";

    static {
        Context context = aa.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        cnf = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(cng);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
