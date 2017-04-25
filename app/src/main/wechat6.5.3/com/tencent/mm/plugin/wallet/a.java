package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    public int index = 0;
    public String kFe = SQLiteDatabase.KeyEmpty;
    public StringBuffer kFf = new StringBuffer();

    public static a bg(String str, int i) {
        a aVar = new a();
        aVar.kFe = str + "," + i;
        return aVar;
    }

    public final void i(int i, Object... objArr) {
        String str;
        if (objArr.length <= 0) {
            v.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
            str = SQLiteDatabase.KeyEmpty;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        aj(i, str);
    }

    public final void aj(int i, String str) {
        String format = String.format("{%d, %s, %d, %s},", new Object[]{Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), str});
        this.index++;
        v.i("MicroMsg.PayLogReport", "test for log " + format);
        this.kFf.append(format);
    }

    public static boolean a(a aVar, Intent intent) {
        if (aVar == null) {
            return false;
        }
        intent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", aVar.index);
        intent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", aVar.kFf.toString());
        intent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", aVar.kFe);
        return true;
    }

    public static a K(Intent intent) {
        int intExtra = intent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
        if (intExtra == -1) {
            return null;
        }
        a aVar = new a();
        aVar.index = intExtra;
        aVar.kFf = new StringBuffer(be.ah(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), SQLiteDatabase.KeyEmpty));
        aVar.kFe = be.ah(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), SQLiteDatabase.KeyEmpty);
        return aVar;
    }
}
