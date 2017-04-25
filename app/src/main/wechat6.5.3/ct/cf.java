package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class cf {
    private static List<String> a;

    static {
        List arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("mobile");
        a.add("16wifi");
        a.add("cmcc");
        a.add("360wifi");
        a.add("androidap");
        a.add("htcphone");
        a.add("xiaomi");
        a.add("lenovo");
        a.add("macbook");
    }

    public static void a(List<ScanResult> list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = ((ScanResult) it.next()).BSSID;
            if (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00")) {
                it.remove();
            } else if (hashSet.contains(str)) {
                it.remove();
            } else {
                hashSet.add(str);
            }
        }
    }
}
