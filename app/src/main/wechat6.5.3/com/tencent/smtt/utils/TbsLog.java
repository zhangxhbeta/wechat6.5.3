package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    private static boolean pzO = false;
    private static s pzP = null;
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    public static void addLog(int i, String str, Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception e) {
                    }
                }
                if (str2 == null) {
                    str2 = SQLiteDatabase.KeyEmpty;
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(1), Character.valueOf('0'), Integer.valueOf(i), str2}));
            } catch (Exception e2) {
            }
        }
    }

    public static void app_extra(String str, Context context) {
        int i = 0;
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = new String[]{"com.tencent.x5sdk.demo", "com.tencent.mtt", "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.mtt.sdk.test", "com.qzone"};
            String[] strArr2 = new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (i < 6) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == 6) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
        }
    }

    public static void d(String str, String str2) {
        if (pzP != null) {
            pzP.d(str, "TBS:" + str2);
        }
    }

    public static void d(String str, String str2, boolean z) {
        d(str, str2);
        if (pzP != null && pzO && z) {
            pzP.ot(str + ": " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (pzP != null) {
            pzP.e(str, "TBS:" + str2);
            pzP.aC("(E)-" + str + "-TBS:" + str2);
        }
    }

    public static void e(String str, String str2, boolean z) {
        e(str, str2);
        if (pzP != null && pzO && z) {
            pzP.ot(str + ": " + str2);
        }
    }

    public static String getTbsLogFilePath() {
        return s.pzR != null ? s.pzR.getAbsolutePath() : null;
    }

    public static void i(String str, String str2) {
        if (pzP != null) {
            pzP.i(str, "TBS:" + str2);
            pzP.aC("(I)-" + str + "-TBS:" + str2);
        }
    }

    public static void i(String str, String str2, boolean z) {
        i(str, str2);
        if (pzP != null && pzO && z) {
            pzP.ot(str + ": " + str2);
        }
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (pzP == null) {
                setTbsLogClient(new s(context));
            }
        }
    }

    public static void setLogView(TextView textView) {
        if (textView != null && pzP != null) {
            pzP.Ux = textView;
        }
    }

    public static boolean setTbsLogClient(s sVar) {
        if (sVar == null) {
            return false;
        }
        pzP = sVar;
        return true;
    }

    public static void v(String str, String str2) {
        if (pzP != null) {
            pzP.v(str, "TBS:" + str2);
        }
    }

    public static void v(String str, String str2, boolean z) {
        v(str, str2);
        if (pzP != null && pzO && z) {
            pzP.ot(str + ": " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (pzP != null) {
            pzP.w(str, "TBS:" + str2);
            pzP.aC("(W)-" + str + "-TBS:" + str2);
        }
    }

    public static void w(String str, String str2, boolean z) {
        w(str, str2);
        if (pzP != null && pzO && z) {
            pzP.ot(str + ": " + str2);
        }
    }
}
