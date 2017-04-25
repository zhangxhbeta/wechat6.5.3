package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.al.h;
import com.tencent.mm.bf.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.List;

public final class df {
    List<at> eBB;
    ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ df oxC;

        public final void handleMessage(Message message) {
            if (this.oxC.eBB != null && ak.uz()) {
                v.d("MicroMsg.EggMgr", "post start egg");
                this.oxC.a(this.oxC.oxB, this.oxC.eBB);
            }
        }
    };
    ChattingAnimFrame oxA = null;
    Activity oxB;

    public final void a(Activity activity, List<at> list) {
        if (list != null) {
            for (at atVar : list) {
                Object obj;
                ak.yW();
                if (t.ax(t.e((Long) c.vf().get(68108, null))) * 1000 > 21600000) {
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ df oxC;

                        {
                            this.oxC = r1;
                        }

                        public final void run() {
                            if (ak.uz()) {
                                ak.vy().a(new m(37), 0);
                                ak.yW();
                                c.vf().set(68108, Long.valueOf(t.Nh()));
                            }
                        }
                    }, 10000);
                }
                f afe = a.bmr().afe();
                if (afe == null) {
                    v.d("MicroMsg.EggMgr", "eggList is null");
                    obj = null;
                    continue;
                } else {
                    int Nh = (int) be.Nh();
                    v.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", Integer.valueOf(Nh), Integer.valueOf(afe.cUj.size()));
                    Iterator it = afe.cUj.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        String str = dVar.cUc;
                        Object obj2 = null;
                        if (t.kS(str)) {
                            obj2 = 1;
                        } else {
                            for (String equals : str.split(",")) {
                                if (equals.equals(u.bsY())) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                        }
                        if (obj2 != null) {
                            Iterator it2 = dVar.cTX.iterator();
                            while (it2.hasNext()) {
                                e eVar = (e) it2.next();
                                String str2 = eVar.cUh;
                                if (t.kS(str2)) {
                                    v.e("MicroMsg.EggMgr", "error egg keyWord");
                                } else if (aa(atVar.field_content, str2, eVar.cUi)) {
                                    if (this.oxA == null) {
                                        ViewStub viewStub = (ViewStub) activity.findViewById(2131756047);
                                        if (viewStub != null) {
                                            viewStub.inflate();
                                        }
                                        this.oxA = (ChattingAnimFrame) activity.findViewById(2131756316);
                                    }
                                    if (this.oxA == null) {
                                        v.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                                    } else if (dVar.cUa <= Nh && ((long) Nh) <= ((long) dVar.cUb) + 86400) {
                                        this.oxA.a(dVar);
                                        Z(dVar.cTZ, atVar.field_isSend == 1);
                                        v.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", str2, Integer.valueOf(dVar.cUa), Integer.valueOf(dVar.cUb));
                                        obj = 1;
                                        continue;
                                    } else if (dVar.cUa == dVar.cUb && dVar.cUa == 0) {
                                        this.oxA.a(dVar);
                                        Z(dVar.cTZ, atVar.field_isSend == 1);
                                        v.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", str2);
                                        obj = 1;
                                        continue;
                                    } else {
                                        v.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", str2, Integer.valueOf(dVar.cUa), Integer.valueOf(dVar.cUb));
                                        obj = null;
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            continue;
                        }
                    }
                    v.d("MicroMsg.EggMgr", "no match");
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    return;
                }
            }
        }
    }

    private static boolean aa(String str, String str2, String str3) {
        if (t.kS(str) || t.kS(str2) || aa.getContext() == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || t.kS(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        v.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            g.buU();
                            a Ll = com.tencent.mm.bf.f.buR().Ll(substring);
                            substring = Ll != null ? Ll.text : null;
                            if (!t.kS(substring) && substring.length() + indexOf == i) {
                                v.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                v.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    v.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    v.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length()));
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Throwable e) {
                v.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e.getMessage());
                v.a("MicroMsg.EggMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            }
        } while (indexOf != -1);
        return false;
    }

    private static void Z(int i, boolean z) {
        try {
            h hVar;
            com.tencent.mm.al.g gVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            ak.yW();
            byte[] d = com.tencent.mm.a.e.d(stringBuilder2.append(c.xp()).append("eggresult.rep").toString(), 0, -1);
            if (d != null) {
                v.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (h) new h().az(d);
            } else {
                v.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new h();
            }
            Iterator it = hVar.cUn.iterator();
            while (it.hasNext()) {
                gVar = (com.tencent.mm.al.g) it.next();
                if (gVar.cTZ == i) {
                    if (z) {
                        gVar.cUl++;
                    } else {
                        gVar.cUm++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.al.g();
                        gVar.cTZ = i;
                        if (z) {
                            gVar.cUm = 1;
                        } else {
                            gVar.cUl = 1;
                        }
                        hVar.cUn.add(gVar);
                    }
                    d = hVar.toByteArray();
                    v.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
                    stringBuilder = new StringBuilder();
                    ak.yW();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xp()).append("eggresult.rep").toString(), d, d.length);
                }
            }
            i2 = 0;
            if (i2 == 0) {
                gVar = new com.tencent.mm.al.g();
                gVar.cTZ = i;
                if (z) {
                    gVar.cUm = 1;
                } else {
                    gVar.cUl = 1;
                }
                hVar.cUn.add(gVar);
            }
            d = hVar.toByteArray();
            v.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
            stringBuilder = new StringBuilder();
            ak.yW();
            com.tencent.mm.a.e.b(stringBuilder.append(c.xp()).append("eggresult.rep").toString(), d, d.length);
        } catch (Throwable e) {
            v.w("MicroMsg.EggMgr", "statistics crash : %s", e.getLocalizedMessage());
            v.a("MicroMsg.EggMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
