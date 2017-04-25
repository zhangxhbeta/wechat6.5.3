package com.tencent.mm.ui.chatting;

import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class a {

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
        Fav(1),
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

    public static void a(a aVar, at atVar) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(atVar, pString, pString2)) {
            a(aVar, atVar, pString.value, pString2.value);
        }
    }

    public static void a(a aVar, at atVar, String str, String str2) {
        String str3 = atVar.field_talker;
        boolean endsWith = str3.endsWith("@chatroom");
        String xF = atVar.field_isSend == 1 ? k.xF() : endsWith ? aw.fL(atVar.field_content) : str3;
        com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
        cVar.n("20source_publishid", str + ",");
        cVar.n("21uxinfo", str2 + ",");
        cVar.n("22clienttime", be.Ni() + ",");
        cVar.n("23video_statu", ",");
        cVar.n("24source_type", (atVar.field_type == 62 ? 1 : 2) + ",");
        cVar.n("25scene", (endsWith ? 4 : 3) + ",");
        cVar.n("26action_type", aVar.value + ",");
        cVar.n("27scene_chatname", str3 + ",");
        cVar.n("28scene_username", xF + ",");
        cVar.n("29curr_publishid", ",");
        cVar.n("30curr_msgid", atVar.field_msgSvrId + ",");
        cVar.n("31curr_favid", "0,");
        cVar.n("32elapsed_time", "0,");
        cVar.n("33load_time", "0,");
        cVar.n("34is_load_complete", "0,");
        cVar.n("35destination", "0,");
        cVar.n("36chatroom_membercount", (endsWith ? i.el(str3) : 0) + ",");
        v.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + cVar.JH());
        g.iuh.h(12990, cVar);
    }

    public static void a(c cVar, d dVar, at atVar, int i) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(atVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = atVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String xF = atVar.field_isSend == 1 ? k.xF() : endsWith ? aw.fL(atVar.field_content) : str3;
            com.tencent.mm.modelsns.c cVar2 = new com.tencent.mm.modelsns.c();
            cVar2.n("20source_publishid", str + ",");
            cVar2.n("21uxinfo", str2 + ",");
            cVar2.n("22clienttime", be.Ni() + ",");
            cVar2.n("23video_statu", dVar.value + ",");
            cVar2.n("24source_type", (atVar.field_type == 62 ? 1 : 2) + ",");
            cVar2.n("25scene", (endsWith ? 4 : 3) + ",");
            cVar2.n("26action_type", cVar.value + ",");
            cVar2.n("27scene_chatname", str3 + ",");
            cVar2.n("28scene_username", xF + ",");
            cVar2.n("29curr_publishid", ",");
            cVar2.n("30curr_msgid", atVar.field_msgSvrId + ",");
            cVar2.n("31curr_favid", "0,");
            cVar2.n("32chatroom_membercount", (endsWith ? i.el(str3) : 0) + ",");
            cVar2.n("33chatroom_toMemberCount", i + ",");
            v.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + cVar2.JH());
            g.iuh.h(12991, cVar2);
        }
    }

    static boolean a(at atVar, PString pString, PString pString2) {
        if (atVar.field_type == 62) {
            n lp = p.lp(atVar.field_imgPath);
            if (lp == null) {
                return false;
            }
            ayk com_tencent_mm_protocal_c_ayk = lp.dhT;
            if (com_tencent_mm_protocal_c_ayk == null || be.kS(com_tencent_mm_protocal_c_ayk.cqm)) {
                return false;
            }
            pString.value = com_tencent_mm_protocal_c_ayk.cqn;
            pString2.value = com_tencent_mm_protocal_c_ayk.cqm;
            return true;
        } else if (atVar.field_type != 49) {
            return false;
        } else {
            boolean dE = m.dE(atVar.field_talker);
            String str = atVar.field_content;
            if (dE && atVar.field_content != null && atVar.field_isSend == 0) {
                str = aw.fM(atVar.field_content);
            }
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
            if (dV == null || dV.type != 4 || be.kS(dV.cqg)) {
                return false;
            }
            pString.value = dV.cqn;
            pString2.value = dV.cqm;
            return true;
        }
    }
}
