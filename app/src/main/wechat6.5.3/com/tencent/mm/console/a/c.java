package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.model.NorMsgSource;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Set;
import java.util.TreeSet;

public final class c implements a {
    static {
        b.a(new c(), "//normsg");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (strArr.length < 2) {
            return false;
        }
        int intValue;
        String toLowerCase;
        long nanoTime;
        int i;
        String str;
        int ww;
        long nanoTime2;
        CharSequence format;
        try {
            if (strArr.length >= 3) {
                intValue = Integer.valueOf(strArr[2]).intValue();
                toLowerCase = strArr[1].toLowerCase();
                nanoTime = System.nanoTime();
                i = -1;
                switch (toLowerCase.hashCode()) {
                    case -625689748:
                        if (toLowerCase.equals("checksofttype")) {
                            boolean z = true;
                            break;
                        }
                        break;
                    case 1078188459:
                        if (toLowerCase.equals("checkmsglevel")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 2078454342:
                        if (toLowerCase.equals("checksofttype2")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 2078454343:
                        if (toLowerCase.equals("checksofttype3")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 2078454344:
                        if (toLowerCase.equals("checksofttype4")) {
                            i = 4;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        for (i = 0; i < intValue; i++) {
                            NorMsgSource.a.checkMsgLevel();
                        }
                        break;
                    case 1:
                        str = context.getApplicationInfo().sourceDir;
                        ak.yW();
                        ww = com.tencent.mm.model.c.ww();
                        for (i = 0; i < intValue; i++) {
                            NorMsgSource.a.checkSoftType(str, ww);
                        }
                        break;
                    case 2:
                        str = context.getApplicationInfo().sourceDir;
                        ak.yW();
                        ww = com.tencent.mm.model.c.ww();
                        for (i = 0; i < intValue; i++) {
                            NorMsgSource.a.checkSoftType2(context, str, ww);
                        }
                        break;
                    case 3:
                        for (i = 0; i < intValue; i++) {
                            NorMsgSource.a.checkSoftType3(context);
                        }
                        break;
                    case 4:
                        for (i = 0; i < intValue; i++) {
                            Set treeSet = new TreeSet();
                            NorMsgSource.a.checkSoftType4(context, treeSet);
                            Toast.makeText(context, treeSet.toString(), 1).show();
                        }
                        break;
                    default:
                        return false;
                }
                nanoTime2 = System.nanoTime() - nanoTime;
                format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
                v.i("MicroMsg.NorMsgTest", format);
                Toast.makeText(context, format, 0).show();
                return true;
            }
        } catch (Exception e) {
        }
        intValue = 1;
        toLowerCase = strArr[1].toLowerCase();
        nanoTime = System.nanoTime();
        i = -1;
        switch (toLowerCase.hashCode()) {
            case -625689748:
                if (toLowerCase.equals("checksofttype")) {
                    boolean z2 = true;
                    break;
                }
                break;
            case 1078188459:
                if (toLowerCase.equals("checkmsglevel")) {
                    i = 0;
                    break;
                }
                break;
            case 2078454342:
                if (toLowerCase.equals("checksofttype2")) {
                    i = 2;
                    break;
                }
                break;
            case 2078454343:
                if (toLowerCase.equals("checksofttype3")) {
                    i = 3;
                    break;
                }
                break;
            case 2078454344:
                if (toLowerCase.equals("checksofttype4")) {
                    i = 4;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                for (i = 0; i < intValue; i++) {
                    NorMsgSource.a.checkMsgLevel();
                }
                break;
            case 1:
                str = context.getApplicationInfo().sourceDir;
                ak.yW();
                ww = com.tencent.mm.model.c.ww();
                for (i = 0; i < intValue; i++) {
                    NorMsgSource.a.checkSoftType(str, ww);
                }
                break;
            case 2:
                str = context.getApplicationInfo().sourceDir;
                ak.yW();
                ww = com.tencent.mm.model.c.ww();
                for (i = 0; i < intValue; i++) {
                    NorMsgSource.a.checkSoftType2(context, str, ww);
                }
                break;
            case 3:
                for (i = 0; i < intValue; i++) {
                    NorMsgSource.a.checkSoftType3(context);
                }
                break;
            case 4:
                for (i = 0; i < intValue; i++) {
                    Set treeSet2 = new TreeSet();
                    NorMsgSource.a.checkSoftType4(context, treeSet2);
                    Toast.makeText(context, treeSet2.toString(), 1).show();
                }
                break;
            default:
                return false;
        }
        nanoTime2 = System.nanoTime() - nanoTime;
        format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
        v.i("MicroMsg.NorMsgTest", format);
        Toast.makeText(context, format, 0).show();
        return true;
    }
}
