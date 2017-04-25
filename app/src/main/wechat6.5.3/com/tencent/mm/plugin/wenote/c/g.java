package com.tencent.mm.plugin.wenote.c;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g {
    public static String N(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static float au(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static String F(Context context, int i) {
        ez ezVar = new ez();
        ezVar.bdQ.type = 21;
        ezVar.bdQ.context = context;
        ezVar.bdQ.bdX = i;
        a.nhr.z(ezVar);
        return ezVar.bdR.path;
    }

    public static String FV(String str) {
        return com.tencent.mm.a.g.m((str + 18 + System.currentTimeMillis()).getBytes());
    }

    public static String g(pw pwVar) {
        ez ezVar = new ez();
        ezVar.bdQ.type = 27;
        ezVar.bdQ.bdS = pwVar;
        a.nhr.z(ezVar);
        return ezVar.bdR.bdZ;
    }

    public static void m(long j, String str) {
        if (j > 0) {
            ez ezVar = new ez();
            ezVar.bdQ.type = 34;
            ezVar.bdQ.aZa = j;
            a.nhr.z(ezVar);
            if (ezVar.bdQ.aZf != null && ezVar.bdQ.aZf.mtR != null && ezVar.bdQ.aZf.mtR.size() > 1 && ((pw) ezVar.bdQ.aZf.mtR.get(0)).msU == null) {
                v.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavitemHtmlidStorage");
                if (!be.kS(str) && e.aR(str)) {
                    try {
                        a(ezVar.bdQ.aZf, j, be.e(new FileInputStream(str)));
                    } catch (FileNotFoundException e) {
                        v.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    private static void a(qf qfVar, long j, String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (!be.kS(str) && str.length() != 0) {
            int indexOf;
            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
            String str2 = "WeNote_";
            while (matcher.find()) {
                String group = matcher.group();
                int indexOf2 = group.indexOf(str2);
                if (indexOf2 == -1) {
                    break;
                }
                int indexOf3 = group.indexOf("\"", indexOf2 + 1);
                if (indexOf3 == -1) {
                    break;
                }
                indexOf = group.indexOf(" ", indexOf2 + 1);
                if (indexOf == -1) {
                    break;
                }
                if (indexOf3 >= indexOf) {
                    indexOf3 = indexOf;
                }
                arrayList.add(group.substring(indexOf2, indexOf3));
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = qfVar.mtR.iterator();
            indexOf = 0;
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                if (i == 0) {
                    pwVar.IT("WeNoteHtmlFile");
                    i++;
                    linkedList.add(pwVar);
                } else {
                    if (pwVar.aKG == 1) {
                        pwVar.IT("-1");
                    } else {
                        int i2 = indexOf + 1;
                        pwVar.IT((String) arrayList.get(indexOf));
                        indexOf = i2;
                    }
                    linkedList.add(pwVar);
                }
            }
            ez ezVar = new ez();
            ezVar.bdQ.type = 33;
            ezVar.bdQ.aZf = qfVar;
            ezVar.bdQ.aZf.mtR = linkedList;
            ezVar.bdQ.aZa = j;
            a.nhr.z(ezVar);
        }
    }

    public static void V(ArrayList<String> arrayList) {
        int i = 0;
        if (b.bma().bmb() == null) {
            v.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            return;
        }
        qf qfVar = b.bma().bmb().ltH;
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (qfVar == null) {
            v.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            return;
        }
        Iterator it = qfVar.mtR.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (!(be.kS(pwVar.msU) || pwVar.msU.contains("WeNoteHtmlFile") || pwVar.msU.contains("-1"))) {
                arrayList2.add(pwVar.msU);
                hashMap.put(pwVar.msU, pwVar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                qfVar.ah(linkedList);
                bmc();
                hashMap.clear();
                return;
            }
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() != 0) {
            List<pw> arrayList3 = new ArrayList();
            Iterator it2 = qfVar.mtR.iterator();
            while (it2.hasNext()) {
                pwVar = (pw) it2.next();
                if (arrayList2.contains(pwVar.msU)) {
                    arrayList3.add(pwVar);
                }
            }
            for (pw pwVar2 : arrayList3) {
                qfVar.mtR.remove(pwVar2);
            }
            bmc();
        }
    }

    public static void bmc() {
        ez ezVar = new ez();
        ezVar.bdQ.type = 30;
        if (b.bma().bmb() != null) {
            ezVar.bdQ.aZf = b.bma().bmb().ltH;
            a.nhr.z(ezVar);
            b.bma().bmb().FQ(ezVar.bdR.path);
        }
    }
}
