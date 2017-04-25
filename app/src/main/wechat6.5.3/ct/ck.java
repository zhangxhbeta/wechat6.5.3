package ct;

import android.net.wifi.ScanResult;
import ct.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ck extends cj {
    public static final ck a = new ck(Collections.emptyList(), 0);
    private final List<ScanResult> b;
    private final long c;

    public ck(List<ScanResult> list, long j) {
        this.c = j;
        this.b = new ArrayList(list);
    }

    public final List<ScanResult> a() {
        return Collections.unmodifiableList(this.b);
    }

    public final boolean a(long j, long j2) {
        return j - this.c < j2;
    }

    public final boolean a(ck ckVar) {
        List list = ckVar.b;
        List list2 = this.b;
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0 || a.a(list, list2)) {
            return false;
        }
        return true;
    }
}
