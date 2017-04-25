package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class e implements a {
    private long cWk = 0;
    b djL;
    public boolean eJx;
    private Timer fUZ;
    public h gFq;
    private boolean hzk;
    public boolean hzl;
    private int hzm;
    public boolean hzn = true;
    public HashSet<String> hzo = new HashSet();
    public com.tencent.mm.plugin.multitalk.ui.widget.e hzp = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
    public MultiTalkGroup hzq = null;
    private k hzr;
    public int hzs = 0;
    public a hzt;
    i.a hzu;
    private boolean hzv;
    ac hzw = new ac(Looper.getMainLooper());
    BroadcastReceiver hzx = new BroadcastReceiver(this) {
        final /* synthetic */ e hzz;

        {
            this.hzz = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (!this.hzz.aCc()) {
                return;
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                this.hzz.hzw.removeCallbacksAndMessages(null);
                this.hzz.hzw.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass13 hzC;

                    {
                        this.hzC = r1;
                    }

                    public final void run() {
                        i.a aCz = i.aCz();
                        if (aCz != this.hzC.hzz.hzu) {
                            i.a aVar = this.hzC.hzz.hzu;
                            this.hzC.hzz.hzu = aCz;
                            if (aVar == i.a.WIFI || aVar == i.a._4G) {
                                if (this.hzC.hzz.hzu == i.a._3GOr_2G) {
                                    v.i("MicroMsg.MT.MultiTalkManager", "switch network to 2G Or 3G");
                                    this.hzC.hzz.nn(0);
                                }
                            } else if (aVar == i.a._3GOr_2G && (this.hzC.hzz.hzu == i.a.WIFI || this.hzC.hzz.hzu == i.a._4G)) {
                                v.i("MicroMsg.MT.MultiTalkManager", "switch network to WIFI or 4G");
                                this.hzC.hzz.nn(1);
                            }
                            if (this.hzC.hzz.hzt != null) {
                                this.hzC.hzz.hzt.a(this.hzC.hzz.hzu);
                                return;
                            }
                            return;
                        }
                        v.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[]{this.hzC.hzz.hzu.name()});
                    }
                }, 8000);
                return;
            }
            v.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[]{Integer.valueOf(i.n(context, intent))});
            if (i.n(context, intent) == 0) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass13 hzC;

                    {
                        this.hzC = r1;
                    }

                    public final void run() {
                        o.aCF().hyY.kw(false);
                    }
                });
            } else {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass13 hzC;

                    {
                        this.hzC = r1;
                    }

                    public final void run() {
                        o.aCF().hyY.kw(true);
                    }
                });
            }
        }
    };
    c hzy = new c<ib>(this) {
        final /* synthetic */ e hzz;

        {
            this.hzz = r2;
            this.nhz = ib.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ib ibVar = (ib) bVar;
            if (ibVar instanceof ib) {
                switch (ibVar.bhW.action) {
                    case 1:
                        ibVar.bhX.bhY = this.hzz.aCc();
                        break;
                }
            }
            return false;
        }
    };

    public e() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hzy);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        aa.getContext().registerReceiver(this.hzx, intentFilter);
        this.gFq = new h(aa.getContext());
        this.djL = new b(aa.getContext());
    }

    public final boolean aCa() {
        if (i.aCy()) {
            return false;
        }
        return i.no(this.hzm);
    }

    public final boolean aCb() {
        if (i.aCy()) {
            return false;
        }
        return i.np(this.hzm);
    }

    public final boolean aCc() {
        boolean z;
        if (this.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Init || this.hzq == null) {
            z = false;
        } else {
            z = true;
        }
        v.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean aCd() {
        boolean z;
        if (this.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Starting || this.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        v.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean aCe() {
        boolean z;
        if (this.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        v.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final long aCf() {
        return System.currentTimeMillis() - this.cWk;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        if (!aCc()) {
            v.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            this.hzq = multiTalkGroup;
            this.hzs = 0;
            this.hzm = 1;
            this.hzo.clear();
            aCg();
            sort();
            return true;
        } else if (i.a(multiTalkGroup, this.hzq)) {
            v.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            MultiTalkGroup multiTalkGroup2 = this.hzq;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.pte) {
                hashMap.put(multiTalkGroupMember.ptf, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.pte) {
                if (!k.xF().equals(multiTalkGroupMember2.ptf) && k.xF().equals(multiTalkGroupMember2.ptg) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.ptf) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.ptf)).status == 20) {
                        String str = multiTalkGroupMember2.ptf;
                        Toast.makeText(aa.getContext(), com.tencent.mm.pluginsdk.ui.d.e.a(aa.getContext(), aa.getContext().getString(2131233952, new Object[]{l.er(str)})), 0).show();
                    }
                }
            }
            this.hzq = multiTalkGroup;
            aCg();
            sort();
            return true;
        } else {
            v.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[]{i.h(this.hzq), i.h(multiTalkGroup)});
            return false;
        }
    }

    private void sort() {
        v.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[]{this.hzq.pte});
        List linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.hzq.pte) {
            if (multiTalkGroupMember.ptf.equals(k.xF())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return -((MultiTalkGroupMember) obj).ptf.compareTo(((MultiTalkGroupMember) obj2).ptf);
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (multiTalkGroupMember.pse > multiTalkGroupMember2.pse) {
                    return -1;
                }
                return multiTalkGroupMember.pse < multiTalkGroupMember2.pse ? 1 : 0;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (!(multiTalkGroupMember.status == 10 && multiTalkGroupMember2.status == 10)) {
                    if (multiTalkGroupMember.status == 10) {
                        return -1;
                    }
                    if (multiTalkGroupMember.status == 10) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        if (obj != null) {
            linkedList.add(obj);
        }
        this.hzq.pte = linkedList;
        v.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[]{this.hzq.pte});
    }

    private void aCg() {
        for (MultiTalkGroupMember multiTalkGroupMember : this.hzq.pte) {
            if (multiTalkGroupMember.status != 10 && this.hzo.remove(multiTalkGroupMember.ptf)) {
                v.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[]{multiTalkGroupMember.ptf});
            }
        }
    }

    public final void a(Activity activity, String str, String str2) {
        boolean z = false;
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eJx);
        objArr[1] = Boolean.valueOf(this.hzl);
        objArr[2] = Boolean.valueOf(this.hzn);
        objArr[3] = this.hzp.toString();
        if (this.hzq == null) {
            z = true;
        }
        objArr[4] = Boolean.valueOf(z);
        v.i(str3, str4, objArr);
        d.aBY();
        if (aCq()) {
            g.f(activity, 2131233958, 2131231164);
        } else if (d.bdy()) {
            g.f(activity, 2131233937, 2131231164);
        } else if (d.bdz()) {
            g.f(activity, 2131233936, 2131231164);
        } else if (com.tencent.mm.ah.a.Hx()) {
            g.f(activity, 2131233931, 2131231164);
        } else if (com.tencent.mm.ah.a.Hw()) {
            g.f(activity, 2131233932, 2131231164);
        } else if (d.bdA()) {
            g.f(activity, 2131233935, 2131231164);
        } else if (aCc()) {
            com.tencent.mm.ah.a.a(activity, 2131233928, null);
        } else {
            List<String> g = be.g(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.ptb = o.aCF().hyY.bMr();
            multiTalkGroup.ptc = str2;
            for (String str5 : g) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.ptf = str5;
                if (str5.equals(k.xF())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.pte.add(multiTalkGroupMember);
            }
            o.aCF().hyY.ay(be.f((Integer) ak.yT().get(1)), k.xF());
            if (o.aCF().hyY.f(multiTalkGroup.ptb, str2, g)) {
                d.aBW();
            } else {
                d.aBX();
            }
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Creating);
            c(multiTalkGroup);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        int i = 4;
        v.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(false), Boolean.valueOf(z3)});
        if (aCc()) {
            kz kzVar = new kz();
            kzVar.bmv.type = 2;
            com.tencent.mm.sdk.c.a.nhr.z(kzVar);
            String l = i.l(this.hzq);
            d.wE(l);
            if (this.hzp != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                boolean k = i.k(this.hzq);
                long aCf = aCf();
                if (!k) {
                    i = z2 ? aCf >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                d.a(k, aCf, l, i);
            } else {
                d.nm(this.hzs);
                d.h((long) this.hzs, l);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.e eVar = this.hzp;
            if (this.hzt != null) {
                this.hzt.aBN();
            }
            this.hzp = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
            aCn();
            aCl();
            RE();
            o.aCE().reset();
            o.aCH().aCA();
            if (this.hzq != null) {
                a(this.hzq, eVar, z2);
                String str = this.hzq.pta;
                if (be.kS(str)) {
                    str = this.hzq.ptb;
                }
                o.aCF().hyY.wN(str);
                this.hzq = null;
            }
            this.hzm = 0;
            this.hzl = true;
            this.eJx = false;
            this.hzn = true;
            this.cWk = 0;
            this.hzs = 0;
            this.hzo.clear();
            return;
        }
        aCn();
        aCl();
        RE();
        this.hzq = null;
        this.hzm = 0;
        this.cWk = 0;
        this.hzs = 0;
        this.hzo.clear();
        this.hzp = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
    }

    public final void b(String str, String str2, boolean z, boolean z2) {
        if (!i.ee(str)) {
            v.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{str});
            ab.a.crZ.a(str, "", new ab.c.a(this) {
                final /* synthetic */ e hzz;

                {
                    this.hzz = r1;
                }

                public final void p(String str, boolean z) {
                }
            });
        }
        at atVar = new at();
        atVar.setType(64);
        atVar.z(System.currentTimeMillis());
        atVar.dh(6);
        atVar.di(2);
        String er = l.er(str2);
        if (!(er == null || er.equals(""))) {
            str2 = er;
        }
        er = str2 + aa.getContext().getString(2131233955);
        atVar.setContent(er);
        if (i.ef(str)) {
            atVar.cH(str);
            ak.yW();
            com.tencent.mm.model.c.wJ().R(atVar);
            ak.yW();
            com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh(str);
            if (Mh != null) {
                if (z) {
                    Mh.df(Mh.field_unReadCount + 1);
                }
                Mh.setContent(er);
                ak.yW();
                if (com.tencent.mm.model.c.wK().a(Mh, str, true) == -1) {
                    v.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + str);
                }
                if (z2) {
                    ((com.tencent.mm.model.ac) ak.oH()).a(atVar);
                    return;
                }
                return;
            }
            Mh = new com.tencent.mm.storage.ab();
            Mh.setUsername(str);
            if (z) {
                Mh.df(1);
            }
            Mh.setContent(er);
            ak.yW();
            com.tencent.mm.model.c.wK().d(Mh);
            if (z2) {
                ((com.tencent.mm.model.ac) ak.oH()).a(atVar);
            }
        }
    }

    public static void wF(String str) {
        v.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        at atVar = new at();
        atVar.setType(64);
        atVar.z(System.currentTimeMillis());
        atVar.dh(6);
        atVar.setContent(aa.getContext().getString(2131233957));
        if (i.ef(str)) {
            atVar.cH(str);
            atVar.setContent(atVar.field_content);
            ak.yW();
            com.tencent.mm.model.c.wJ().R(atVar);
        }
    }

    private static void a(MultiTalkGroup multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e eVar, boolean z) {
        v.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting && z) {
            at atVar = new at();
            atVar.setType(64);
            atVar.z(System.currentTimeMillis());
            atVar.dh(6);
            atVar.setContent(aa.getContext().getString(2131233957));
            if (i.ef(multiTalkGroup.ptc)) {
                atVar.cH(multiTalkGroup.ptc);
                atVar.setContent(atVar.field_content);
                ak.yW();
                com.tencent.mm.model.c.wJ().R(atVar);
            }
        }
    }

    public final void d(int i, Object obj) {
        int i2 = 2131233924;
        v.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -14256:
                v.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = 2131233919;
                if (!(obj == null || ((y) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.bPi().kF(false);
                    break;
                }
            case -14255:
                String str = "MicroMsg.MT.MultiTalkManager";
                String str2 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.hzq;
                objArr[2] = this.hzq != null ? this.hzq.ptc : "";
                v.i(str, str2, objArr);
                if (obj != null) {
                    y yVar = (y) obj;
                    if (yVar != null) {
                        v.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + yVar.lEs);
                        if (yVar.ppS != null) {
                            o.aCI().wP(yVar.ppS.prP);
                            v.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + yVar.ppS.prP);
                        }
                        if (!o.aCF().hyY.wN(yVar.lEs)) {
                            v.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + yVar.lEs);
                        }
                    }
                }
                i2 = 2131233953;
                break;
            case -1400:
                i2 = 2131233918;
                break;
            case -1300:
                i2 = 2131233917;
                break;
            case -1200:
                i2 = 2131233916;
                break;
            case -1100:
                i2 = 2131233915;
                break;
            case -1000:
                i2 = 2131233914;
                break;
            case -900:
                i2 = 2131233927;
                break;
            case -800:
                i2 = 2131233926;
                break;
            case -700:
                i2 = 2131233925;
                break;
            case -500:
                i2 = 2131233923;
                break;
            case -400:
                i2 = 2131233922;
                break;
            case -300:
                i2 = 2131233921;
                break;
            case -200:
                d.eA(false);
                i2 = 2131233920;
                break;
            case -100:
                d.ez(false);
                i2 = 2131233913;
                break;
        }
        if (i != -800 && i != -500) {
            Toast.makeText(aa.getContext(), aa.getContext().getString(i2), 0).show();
            c(false, false, true);
        }
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eJx);
        objArr[1] = Boolean.valueOf(this.hzl);
        objArr[2] = Boolean.valueOf(this.hzn);
        objArr[3] = this.hzp.toString();
        objArr[4] = Boolean.valueOf(this.hzq == null);
        v.i(str, str2, objArr);
        d.aBZ();
        str = i.m(multiTalkGroup);
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (j.sU().getInt("MultitalkBlockReceiver", 0) == 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0 || LX.tK()) {
            v.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
            ad.g(new Runnable(this) {
                final /* synthetic */ e hzz;

                public final void run() {
                    String str = multiTalkGroup.pta;
                    if (be.kS(str)) {
                        str = multiTalkGroup.ptb;
                    }
                    o.aCF().hyY.wN(str);
                }
            }, 1000);
            d.S(3, i.l(multiTalkGroup));
            return;
        }
        if (!(aCc() || d.bdz() || d.bdy() || com.tencent.mm.ah.a.Hw() || com.tencent.mm.ah.a.Hx())) {
            if (((TelephonyManager) aa.getContext().getSystemService("phone")).getCallState() != 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i == 0 && !d.bdA() && com.tencent.mm.i.a.ei(LX.field_type)) {
                if (!i.ee(multiTalkGroup.ptc)) {
                    v.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.ptc});
                    ab.a.crZ.a(multiTalkGroup.ptc, "", null);
                }
                v.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting);
                d.S(1, i.l(multiTalkGroup));
                if (com.tencent.mm.i.a.ei(LX.field_type)) {
                    v.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[]{str, k.xF()});
                    c(multiTalkGroup);
                    return;
                }
                v.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[]{str, k.xF()});
                if (a(multiTalkGroup)) {
                    this.hzk = false;
                    aCh();
                    aCo();
                    return;
                }
                return;
            }
        }
        v.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[]{i.h(multiTalkGroup)});
        if (!i.ee(multiTalkGroup.ptc)) {
            v.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.ptc});
            ab.a.crZ.a(multiTalkGroup.ptc, "", new ab.c.a(this) {
                final /* synthetic */ e hzz;

                {
                    this.hzz = r1;
                }

                public final void p(String str, boolean z) {
                }
            });
        }
        ad.g(new Runnable(this) {
            final /* synthetic */ e hzz;

            public final void run() {
                String str = multiTalkGroup.pta;
                if (be.kS(str)) {
                    str = multiTalkGroup.ptb;
                }
                o.aCF().hyY.wN(str);
            }
        }, 1000);
        d.S(3, i.l(multiTalkGroup));
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        if (a(multiTalkGroup)) {
            this.hzk = false;
            aCh();
            aCo();
            com.tencent.mm.ay.c.b(aa.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
    }

    private void aCh() {
        boolean z;
        if (ak.yX().ra() || ak.yX().qU()) {
            z = false;
        } else {
            z = true;
        }
        this.hzl = z;
        this.eJx = false;
        this.hzu = i.aCz();
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        d.S(2, i.l(multiTalkGroup));
        a(multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting, true);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        v.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        d.ez(true);
        if (a(multiTalkGroup)) {
            aCi();
        }
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        v.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        kz kzVar = new kz();
        kzVar.bmv.type = 1;
        com.tencent.mm.sdk.c.a.nhr.z(kzVar);
        d.eA(true);
        if (this.hzp != com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Creating);
            c(multiTalkGroup);
        }
        if (aCc() && a(multiTalkGroup)) {
            aCi();
        }
    }

    private void aCi() {
        if (i.i(this.hzq)) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
        } else {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Starting);
        }
        if (this.hzt != null) {
            this.hzt.azB();
            return;
        }
        com.tencent.mm.ay.c.b(aa.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        v.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[]{i.h(multiTalkGroup)});
        if (!aCc() || !a(multiTalkGroup)) {
            return;
        }
        if (i.j(this.hzq)) {
            if (this.hzp != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking && i.i(multiTalkGroup)) {
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
            }
            if (this.hzt != null && i.c(this.hzp)) {
                this.hzt.aBP();
            }
        } else if (this.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            c(false, true, false);
        } else {
            c(false, false, false);
        }
    }

    public final void aCj() {
        v.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    }

    public final void ew(boolean z) {
        this.eJx = z;
        if (this.hzt != null) {
            this.hzt.ew(this.eJx);
        }
    }

    public final void aCk() {
        v.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[]{Integer.valueOf(this.hzm)});
    }

    public final void aO(List<aj> list) {
        if (aCc()) {
            this.hzo.clear();
            v.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[]{list});
            for (aj ajVar : list) {
                if (ajVar.prq == 2 || ajVar.prq == 3) {
                    this.hzo.add(ajVar.prp);
                }
            }
            this.hzo.remove(k.xF());
            v.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[]{this.hzo});
            if (this.hzr != null) {
                this.hzr.nq(this.hzo.size());
            }
            if (this.hzt != null) {
                this.hzt.aBQ();
            }
        }
    }

    public final void eB(boolean z) {
        if (aCc() && !this.hzv) {
            this.hzv = true;
            d.b(i.aCw(), o.aCG().aCa(), z);
            Toast.makeText(aa.getContext(), 2131233943, 0).show();
            CharSequence string = aa.getContext().getString(2131233908);
            CharSequence string2 = aa.getContext().getString(2131233946);
            Intent intent = new Intent();
            intent.setClass(aa.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(aa.getContext(), 43, intent, 134217728);
            int i = 2130838803;
            if (com.tencent.mm.compatible.util.d.dX(19)) {
                i = 2130838802;
            }
            Notification a = d.a(new Builder(aa.getContext()).setTicker(string2).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(string2).setContentIntent(activity));
            a.icon = i;
            a.flags |= 32;
            ak.oH().a(43, a, false);
            if (this.hzt != null) {
                this.hzt.aBO();
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ e hzz;

                {
                    this.hzz = r1;
                }

                public final void run() {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.putExtra("enterMainUiWxGroupId", this.hzz.hzq != null ? this.hzz.hzq.ptc : "");
                    intent.setClass(aa.getContext(), MultiTalkMainUI.class);
                    com.tencent.mm.plugin.voip.model.d.bbx().I(intent);
                }
            });
        }
    }

    public final void aCl() {
        this.hzv = false;
        com.tencent.mm.plugin.voip.model.d.bbx().dismiss();
        ((NotificationManager) aa.getContext().getSystemService("notification")).cancel(43);
    }

    public final void aCm() {
        v.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.hzt == null) {
            v.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
        } else if (this.hzo.size() == 0) {
            v.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        } else {
            if (this.hzr == null) {
                v.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[]{Integer.valueOf(this.hzo.size())});
                this.hzr = new k(this.hzt);
                this.hzr.nq(this.hzo.size());
            }
            if (!this.hzr.aVv) {
                this.hzr.start();
            }
        }
    }

    public final void aCn() {
        v.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.hzr != null) {
            this.hzr.stop();
            this.hzr = null;
        }
    }

    public final void eC(boolean z) {
        o.aCF().hyY.eC(z);
        v.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[]{Boolean.valueOf(z)});
        this.hzl = z;
        if (this.hzt != null) {
            this.hzt.ex(this.hzl);
        }
    }

    public final boolean nn(int i) {
        if (!aCd()) {
            return false;
        }
        boolean nn = o.aCF().hyY.nn(i);
        v.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[]{Boolean.valueOf(nn)});
        int i2 = this.hzm;
        this.hzm = i;
        if (aCb()) {
            aCm();
        } else {
            aCn();
        }
        if (this.hzt == null || i2 == this.hzm) {
            return nn;
        }
        this.hzt.bW(i2, this.hzm);
        return nn;
    }

    private void b(com.tencent.mm.plugin.multitalk.ui.widget.e eVar) {
        com.tencent.mm.plugin.multitalk.ui.widget.e eVar2 = this.hzp;
        this.hzp = eVar;
        if (eVar2 != eVar) {
            if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                kz kzVar = new kz();
                kzVar.bmv.type = 1;
                com.tencent.mm.sdk.c.a.nhr.z(kzVar);
                d.a(i.k(this.hzq), aCf(), i.l(this.hzq));
            }
            if (this.hzt != null) {
                this.hzt.a(eVar);
            }
        }
    }

    private void aCo() {
        v.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.fUZ != null) {
            this.fUZ.cancel();
            return;
        }
        this.cWk = System.currentTimeMillis();
        this.hzs = 0;
        this.fUZ = new Timer();
        this.fUZ.schedule(new TimerTask(this) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final void run() {
                if (this.hzz.aCf() >= 45000 && this.hzz.hzp != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 hzA;

                        {
                            this.hzA = r1;
                        }

                        public final void run() {
                            this.hzA.hzz.c(false, true, false);
                        }
                    });
                }
                if (this.hzz.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    e eVar = this.hzz;
                    eVar.hzs++;
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 hzA;

                        {
                            this.hzA = r1;
                        }

                        public final void run() {
                            if (this.hzA.hzz.hzp == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                                com.tencent.mm.plugin.voip.model.d.bbx().rR(this.hzA.hzz.hzs);
                                if (this.hzA.hzz.hzt != null) {
                                    this.hzA.hzz.hzt.aBR();
                                }
                            }
                        }
                    });
                }
            }
        }, 1000, 1000);
    }

    private void RE() {
        if (this.fUZ != null) {
            this.fUZ.cancel();
            this.fUZ = null;
        }
    }

    public final void eD(boolean z) {
        if (!this.hzk) {
            this.gFq.j(2131165830, 0, z);
            this.djL.requestFocus();
            this.hzk = true;
        }
    }

    public final void aCp() {
        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
            final /* synthetic */ e hzz;

            {
                this.hzz = r1;
            }

            public final void run() {
                this.hzz.gFq.stop();
                this.hzz.djL.si();
                ak.yX().setSpeakerphoneOn(this.hzz.hzl);
            }
        }, "MultiTalkManager_stop_ring");
    }

    private static boolean aCq() {
        boolean z;
        Exception e;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                v.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            v.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }
}
