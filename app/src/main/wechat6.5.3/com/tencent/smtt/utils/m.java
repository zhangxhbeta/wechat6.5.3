package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public final class m {
    private static Context mContext = null;
    private static m pzk = null;

    private m() {
    }

    static void Qs(String str) {
        Throwable th;
        if (e.bNT()) {
            DataOutputStream dataOutputStream = null;
            DataOutputStream dataOutputStream2;
            try {
                File file = new File(e.bNU(), "ins.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                dataOutputStream2 = new DataOutputStream(e.H(file));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream2.flush();
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                dataOutputStream2 = null;
                th = th4;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                throw th;
            }
        }
    }

    static void Qt(String str) {
        try {
            System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", str);
        } catch (Exception e) {
        }
    }

    public static m ga(Context context) {
        mContext = context.getApplicationContext();
        if (pzk == null) {
            pzk = new m();
        }
        return pzk;
    }
}
