package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements b, s, e {
    private List<String> iMS;
    private List<String> lAi;
    Map<String, Integer> lAj;
    private ah lAk;
    private List<String> lAq;
    private List<String> lAr;
    private volatile boolean lAs;

    public h() {
        this.lAi = null;
        this.iMS = null;
        this.lAj = null;
        this.lAs = false;
        this.lAk = new ah(Looper.getMainLooper(), new a(this) {
            final /* synthetic */ h lAt;

            {
                this.lAt = r1;
            }

            public final boolean oU() {
                this.lAt.lAj.clear();
                return false;
            }
        }, false);
        this.lAi = new ArrayList();
        this.iMS = new ArrayList();
        this.lAj = new HashMap();
        this.lAq = new Vector();
        this.lAr = new ArrayList();
        this.lAk.ea(600000);
        ak.vy().a(231, (e) this);
        am.ash().a(7, (s) this);
    }

    public final String n(Context context, String str) {
        return g.n(context, str);
    }

    public final void af(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            v.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            pg((String) it.next());
        }
        bnp();
    }

    private synchronized void pg(String str) {
        if (be.kS(str) || this.lAq.contains(str)) {
            v.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
        } else if (Gy(str)) {
            v.i("MicroMsg.AppInfoService", "add appid:[%s]", str);
            this.lAq.add(str);
        } else {
            v.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
        }
    }

    public final void Gx(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoService", "push fail, appId is null");
            return;
        }
        v.i("MicroMsg.AppInfoService", "push appid : " + str);
        pg(str);
        bnp();
    }

    private void bnp() {
        int i = 20;
        if (this.lAs) {
            v.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
        } else if (this.lAq == null || this.lAq.isEmpty()) {
            v.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
        } else {
            int size = this.lAq.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                this.lAr.addAll(this.lAq.subList(0, i));
            }
            if (this.lAr != null && !this.lAr.isEmpty()) {
                this.lAs = true;
                ak.vy().a(new w(7, new ac(this.lAr)), 0);
            }
        }
    }

    private boolean Gy(String str) {
        if (str == null) {
            v.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            return false;
        }
        Integer valueOf = Integer.valueOf(be.a((Integer) this.lAj.get(str), 0));
        if (valueOf.intValue() >= 5) {
            v.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            return false;
        }
        this.lAj.put(str, Integer.valueOf(valueOf.intValue() + 1));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        switch (type) {
            case 231:
                String str2 = ((ab) kVar).appId;
                if (this.lAi.contains(str2)) {
                    this.lAi.remove(str2);
                }
                while (this.iMS.size() > 0) {
                    boolean z;
                    str2 = (String) this.iMS.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        v.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        z = false;
                        continue;
                    } else if (Gy(str2)) {
                        ak.vy().a(new ab(str2), 0);
                        z = true;
                        continue;
                    } else {
                        v.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        z = false;
                        continue;
                    }
                    if (z) {
                        this.lAi.add(str2);
                        return;
                    }
                }
                return;
            case 451:
                synchronized (this) {
                    if (!(this.lAr == null || this.lAr.isEmpty())) {
                        this.lAq.removeAll(this.lAr);
                        this.lAr.clear();
                    }
                }
                this.lAs = false;
                bnp();
                return;
            default:
                v.e("MicroMsg.AppInfoService", "error type: " + type);
                return;
        }
    }

    public final void a(int i, int i2, String str, v vVar) {
        if (vVar.getType() != 7) {
            v.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            return;
        }
        synchronized (this) {
            if (!(this.lAr == null || this.lAr.isEmpty())) {
                this.lAq.removeAll(this.lAr);
                this.lAr.clear();
            }
        }
        this.lAs = false;
        bnp();
    }
}
