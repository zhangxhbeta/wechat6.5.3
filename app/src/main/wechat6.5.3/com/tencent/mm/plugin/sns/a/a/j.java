package com.tencent.mm.plugin.sns.a.a;

import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class j {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7),
        DetailTimeline(8);
        
        private int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        public int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private e(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(k kVar, boolean z, boolean z2) {
        int i = 2;
        azr aUp = kVar.aUp();
        List list = aUp.mWq.mom;
        if (list != null && !list.isEmpty()) {
            if ((aUp.mWq.mol == 15 && kVar.qC(32)) || aUp.mWq.mol == 18) {
                int i2;
                list.get(0);
                if (kVar.qC(32) && aUp.mWq.mol == 15) {
                    aUp.mWv.cqm = kVar.aUo().jpt;
                    aUp.mWv.cqn = aUp.gID;
                }
                com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                cVar.n("20source_publishid", aUp.mWv.cqn + ",");
                cVar.n("21uxinfo", aUp.mWv.cqm + ",");
                cVar.n("22clienttime", be.Ni() + ",");
                cVar.n("23souce_type", (aUp.mWq.mol == 15 ? 1 : 2) + ",");
                String str = "24scene";
                StringBuilder stringBuilder = new StringBuilder();
                if (z) {
                    i = 6;
                } else if (aUp.mWq.mol == 15) {
                    i = 1;
                }
                cVar.n(str, stringBuilder.append(i).append(",").toString());
                cVar.n("25scene_chatname", ",");
                cVar.n("26scene_username", aUp.gln + ",");
                cVar.n("27curr_publishid", aUp.gID + ",");
                cVar.n("28curr_msgid", ",");
                cVar.n("29curr_favid", "0,");
                String str2 = "30isdownload";
                stringBuilder = new StringBuilder();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                cVar.n(str2, stringBuilder.append(i2).append(",").toString());
                cVar.n("31chatroom_membercount", "0,");
                o.a(aUp, cVar);
                v.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + cVar.JH());
                g.iuh.h(12989, new Object[]{cVar});
            }
        }
    }

    public static void a(b bVar, a aVar, k kVar) {
        azr aUp = kVar.aUp();
        List list = aUp.mWq.mom;
        if (list != null && !list.isEmpty()) {
            if ((aUp.mWq.mol == 15 && kVar.qC(32)) || aUp.mWq.mol == 18) {
                list.get(0);
                if (kVar.qC(32) && aUp.mWq.mol == 15) {
                    aUp.mWv.cqm = kVar.aUo().jpt;
                    aUp.mWv.cqn = aUp.gID;
                }
                com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                cVar.n("20source_publishid", aUp.mWv.cqn + ",");
                cVar.n("21uxinfo", aUp.mWv.cqm + ",");
                cVar.n("22clienttime", be.Ni() + ",");
                cVar.n("23video_statu", ",");
                cVar.n("24source_type", (aUp.mWq.mol == 15 ? 1 : 2) + ",");
                cVar.n("25scene", bVar.value + ",");
                cVar.n("26action_type", aVar.value + ",");
                cVar.n("27scene_chatname", ",");
                cVar.n("28scene_username", aUp.gln + ",");
                cVar.n("29curr_publishid", aUp.gID + ",");
                cVar.n("30curr_msgid", "0,");
                cVar.n("31curr_favid", "0,");
                cVar.n("32elapsed_time", "0,");
                cVar.n("33load_time", "0,");
                cVar.n("34is_load_complete", "0,");
                cVar.n("35destination", "0,");
                cVar.n("36chatroom_membercount", "0,");
                o.a(aUp, cVar);
                v.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + cVar.JH());
                g.iuh.h(12990, new Object[]{cVar});
            }
        }
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
        cVar.n("20source_publishid", str + ",");
        cVar.n("21uxinfo", str2 + ",");
        cVar.n("22clienttime", be.Ni() + ",");
        cVar.n("23video_statu", ",");
        cVar.n("24source_type", i + ",");
        cVar.n("25scene", i2 + ",");
        cVar.n("26action_type", aVar.value + ",");
        cVar.n("27scene_chatname", str4 + ",");
        cVar.n("28scene_username", str3 + ",");
        cVar.n("29curr_publishid", str5 + ",");
        cVar.n("30curr_msgid", j + ",");
        cVar.n("31curr_favid", i3 + ",");
        cVar.n("32elapsed_time", "0,");
        cVar.n("33load_time", "0,");
        cVar.n("34is_load_complete", "0,");
        cVar.n("35destination", "0,");
        cVar.n("36chatroom_membercount", i4 + ",");
        f.b(str5, cVar);
        v.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + cVar.JH());
        g.iuh.h(12990, new Object[]{cVar});
    }

    public static void a(d dVar, c cVar, e eVar, int i, k kVar) {
        azr aUp = kVar.aUp();
        List list = aUp.mWq.mom;
        if (list != null && !list.isEmpty()) {
            if ((aUp.mWq.mol == 15 && kVar.qC(32)) || aUp.mWq.mol == 18) {
                list.get(0);
                if (kVar.qC(32) && aUp.mWq.mol == 15) {
                    aUp.mWv.cqm = kVar.aUo().jpt;
                    aUp.mWv.cqn = aUp.gID;
                }
                com.tencent.mm.modelsns.c cVar2 = new com.tencent.mm.modelsns.c();
                cVar2.n("20source_publishid", aUp.mWv.cqn + ",");
                cVar2.n("21uxinfo", aUp.mWv.cqm + ",");
                cVar2.n("22clienttime", be.Ni() + ",");
                cVar2.n("23video_statu", eVar.value + ",");
                cVar2.n("24source_type", (aUp.mWq.mol == 15 ? 1 : 2) + ",");
                cVar2.n("25scene", dVar.value + ",");
                cVar2.n("26action_type", cVar.value + ",");
                cVar2.n("27scene_chatname", ",");
                cVar2.n("28scene_username", aUp.gln + ",");
                cVar2.n("29curr_publishid", aUp.gID + ",");
                cVar2.n("30curr_msgid", "0,");
                cVar2.n("31curr_favid", "0,");
                cVar2.n("32chatroom_membercount", "0,");
                cVar2.n("33chatroom_toMemberCount", i + ",");
                o.a(aUp, cVar2);
                v.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + cVar2.JH());
                g.iuh.h(12991, new Object[]{cVar2});
            }
        }
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        com.tencent.mm.modelsns.c cVar2 = new com.tencent.mm.modelsns.c();
        cVar2.n("20source_publishid", str + ",");
        cVar2.n("21uxinfo", str2 + ",");
        cVar2.n("22clienttime", be.Ni() + ",");
        cVar2.n("23video_statu", "3,");
        cVar2.n("24source_type", i + ",");
        cVar2.n("25scene", i2 + ",");
        cVar2.n("26action_type", cVar.value + ",");
        cVar2.n("27scene_chatname", str4 + ",");
        cVar2.n("28scene_username", str3 + ",");
        cVar2.n("29curr_publishid", str5 + ",");
        cVar2.n("30curr_msgid", j + ",");
        cVar2.n("31curr_favid", i3 + ",");
        cVar2.n("32chatroom_membercount", i4 + ",");
        cVar2.n("33chatroom_toMemberCount", i5 + ",");
        v.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + cVar2.JH());
        f.b(str5, cVar2);
        g.iuh.h(12991, new Object[]{cVar2});
    }
}
