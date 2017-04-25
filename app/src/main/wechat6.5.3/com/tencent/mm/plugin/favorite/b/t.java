package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class t {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
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
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void j(i iVar) {
        if (iVar.field_favProto.mtR != null && !iVar.field_favProto.mtR.isEmpty()) {
            pw pwVar = (pw) iVar.field_favProto.mtR.getFirst();
            pz pzVar = pwVar.msS;
            if (pzVar != null) {
                com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                cVar.n("20source_publishid", pzVar.cqn + ",");
                cVar.n("21uxinfo", pzVar.cqm + ",");
                cVar.n("22clienttime", be.Ni() + ",");
                cVar.n("23source_type", (iVar.field_type == 16 ? 1 : 2) + ",");
                cVar.n("24scene", "5,");
                cVar.n("25scene_chatname", ",");
                cVar.n("26scene_username", iVar.field_fromUser + ",");
                cVar.n("27curr_publishid", ",");
                cVar.n("28curr_msgid", "0,");
                cVar.n("29curr_favid", iVar.field_id + ",");
                cVar.n("30isdownload", "0,");
                cVar.n("31chatroom_membercount", "0,");
                o.a(pwVar.bnY, cVar);
                v.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + cVar.JH());
                g.iuh.h(12989, new Object[]{cVar});
            }
        }
    }

    public static void a(a aVar, i iVar) {
        if (iVar.field_favProto.mtR != null && !iVar.field_favProto.mtR.isEmpty()) {
            pz pzVar = ((pw) iVar.field_favProto.mtR.getFirst()).msS;
            if (pzVar != null) {
                com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                cVar.n("20source_publishid", pzVar.cqn + ",");
                cVar.n("21uxinfo", pzVar.cqm + ",");
                cVar.n("22clienttime", be.Ni() + ",");
                cVar.n("23video_statu", ",");
                cVar.n("24source_type", (iVar.field_type == 16 ? 1 : 2) + ",");
                cVar.n("25scene", "5,");
                cVar.n("26action_type", aVar.value + ",");
                cVar.n("27scene_chatname", ",");
                cVar.n("28scene_username", iVar.field_fromUser + ",");
                cVar.n("29curr_publishid", ",");
                cVar.n("30curr_msgid", "0,");
                cVar.n("31curr_favid", iVar.field_id + ",");
                cVar.n("32elapsed_time", "0,");
                cVar.n("33load_time", "0,");
                cVar.n("34is_load_complete", "0,");
                cVar.n("35destination", "0,");
                cVar.n("36chatroom_membercount", "0,");
                v.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + cVar.JH());
                g.iuh.h(12990, new Object[]{cVar});
            }
        }
    }

    public static void a(c cVar, i iVar, d dVar, int i) {
        if (iVar.field_favProto.mtR != null && !iVar.field_favProto.mtR.isEmpty()) {
            pz pzVar = ((pw) iVar.field_favProto.mtR.getFirst()).msS;
            if (pzVar != null) {
                com.tencent.mm.modelsns.c cVar2 = new com.tencent.mm.modelsns.c();
                cVar2.n("20source_publishid", pzVar.cqn + ",");
                cVar2.n("21uxinfo", pzVar.cqm + ",");
                cVar2.n("22clienttime", be.Ni() + ",");
                cVar2.n("23video_statu", dVar.value + ",");
                cVar2.n("24source_type", (iVar.field_type == 16 ? 1 : 2) + ",");
                cVar2.n("25scene", "5,");
                cVar2.n("26action_type", cVar.value + ",");
                cVar2.n("27scene_chatname", ",");
                cVar2.n("28scene_username", iVar.field_fromUser + ",");
                cVar2.n("29curr_publishid", ",");
                cVar2.n("30curr_msgid", "0,");
                cVar2.n("31curr_favid", iVar.field_id + ",");
                cVar2.n("32chatroom_membercount", "0,");
                cVar2.n("33chatroom_toMemberCount", i + ",");
                v.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + cVar2.JH());
                g.iuh.h(12991, new Object[]{cVar2});
            }
        }
    }
}
