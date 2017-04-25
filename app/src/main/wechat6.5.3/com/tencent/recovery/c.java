package com.tencent.recovery;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.recovery.c.b;
import com.tencent.recovery.model.RecoveryExceptionItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class c {
    private static final String TAG = (a.ptH + "Recovery.RecoveryContext");
    public ArrayList<RecoveryExceptionItem> ptS = new ArrayList();

    protected final void clear() {
        b.i(TAG, "clear", new Object[0]);
        this.ptS.clear();
    }

    protected final void f(SharedPreferences sharedPreferences) {
        if (sharedPreferences.contains("KeyHistoryExceptionTypeList")) {
            String[] split = sharedPreferences.getString("KeyHistoryExceptionTypeList", SQLiteDatabase.KeyEmpty).split(" ");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    if (str.length() > 0) {
                        String[] split2 = str.split(";");
                        RecoveryExceptionItem recoveryExceptionItem = new RecoveryExceptionItem();
                        try {
                            recoveryExceptionItem.pua = Boolean.valueOf(split2[0]).booleanValue();
                            recoveryExceptionItem.dyp = Integer.valueOf(split2[1]).intValue();
                            recoveryExceptionItem.type = Integer.valueOf(split2[2]).intValue();
                            this.ptS.add(recoveryExceptionItem);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        b.i(TAG, "RecoveryContext readFromSp %s", toString());
    }

    protected final void a(Editor editor) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.ptS.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((RecoveryExceptionItem) it.next()).toString());
            stringBuffer.append(" ");
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() > 0) {
            editor.putString("KeyHistoryExceptionTypeList", stringBuffer.toString());
        } else {
            editor.remove("KeyHistoryExceptionTypeList");
        }
        b.i(TAG, "RecoveryContext saveToSp %s", toString());
    }

    public final String toString() {
        return this.ptS.toString();
    }

    protected final void b(RecoveryExceptionItem recoveryExceptionItem) {
        if (this.ptS.size() > 15) {
            this.ptS.remove(0);
        }
        this.ptS.add(recoveryExceptionItem);
    }
}
