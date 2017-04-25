package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;

public final class g {
    public static volatile int pvU = -1;
    private static g pvV = null;
    a pvR = null;
    boolean pvS = false;
    private final int pvT = 3;

    public class a {
        int[] pvW;
        int pvX;
        int pvY;

        public final boolean empty() {
            return this.pvY == this.pvX;
        }

        public final String toString() {
            if (empty()) {
                return SQLiteDatabase.KeyEmpty;
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.pvX; i < this.pvY; i++) {
                stringBuilder.append(String.valueOf(this.pvW[i]) + ",");
            }
            i = stringBuilder.length();
            return stringBuilder.delete(i - 1, i).append("]").toString();
        }
    }

    private g() {
    }

    public static g bMS() {
        if (pvV == null) {
            pvV = new g();
        }
        return pvV;
    }

    final void a(Context context, int i, Throwable th) {
        if (pvU == -1) {
            pvU = i;
        }
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
        this.pvS = true;
        if (this.pvS && this.pvR != null && this.pvR.empty()) {
            this.pvS = false;
        }
        if (this.pvS && th != null) {
            String str;
            o fx = o.fx(context);
            if (th != null) {
                str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
                if (str.length() > 1024) {
                    str = str.substring(0, 1024);
                }
                fx.pwZ = str;
            } else {
                fx.pwZ = "NULL";
            }
            str = fx.pwZ;
            fx.setErrorCode(i);
            fx.pwL = System.currentTimeMillis();
            fx.Qn(str);
            fx.a(com.tencent.smtt.sdk.o.a.TYPE_LOAD);
        }
    }

    final void ab(Context context, int i) {
        a(context, i, null);
        TbsLog.e("loaderror", String.valueOf(i));
    }
}
