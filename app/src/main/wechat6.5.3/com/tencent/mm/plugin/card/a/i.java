package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class i {
    private List<WeakReference<a>> eAR = new ArrayList();
    public List<g> eBB = new ArrayList();
    public int eBC = 0;

    public interface a {
        void Yj();

        void a(g gVar);
    }

    public i() {
        loadFromDB();
        ak.yW();
        Object obj = c.vf().get(139268, null);
        this.eBC = obj == null ? 0 : ((Integer) obj).intValue();
    }

    public final void a(g gVar) {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.a(gVar);
                    }
                }
            }
        }
    }

    public final void Yj() {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.Yj();
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        if (aVar != null) {
            this.eAR.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.eAR != null && aVar != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.eAR.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public static void b(g gVar) {
        if (!af.aam().b(gVar)) {
            v.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
    }

    private void loadFromDB() {
        Cursor Kp = af.aam().Kp();
        if (Kp != null && Kp.getCount() > 0) {
            Kp.moveToFirst();
            int columnIndex = Kp.getColumnIndex("card_type");
            int columnIndex2 = Kp.getColumnIndex("title");
            int columnIndex3 = Kp.getColumnIndex("description");
            int columnIndex4 = Kp.getColumnIndex("logo_url");
            int columnIndex5 = Kp.getColumnIndex("time");
            int columnIndex6 = Kp.getColumnIndex("card_id");
            int columnIndex7 = Kp.getColumnIndex("card_tp_id");
            int columnIndex8 = Kp.getColumnIndex("msg_id");
            int columnIndex9 = Kp.getColumnIndex("msg_type");
            int columnIndex10 = Kp.getColumnIndex("jump_type");
            int columnIndex11 = Kp.getColumnIndex("url");
            int columnIndex12 = Kp.getColumnIndex("buttonData");
            int columnIndex13 = Kp.getColumnIndex("operData");
            int columnIndex14 = Kp.getColumnIndex("report_scene");
            int columnIndex15 = Kp.getColumnIndex("read_state");
            while (!Kp.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = Kp.getInt(columnIndex);
                gVar.field_title = Kp.getString(columnIndex2);
                gVar.field_description = Kp.getString(columnIndex3);
                gVar.field_logo_url = Kp.getString(columnIndex4);
                gVar.field_time = Kp.getInt(columnIndex5);
                gVar.field_card_id = Kp.getString(columnIndex6);
                gVar.field_card_tp_id = Kp.getString(columnIndex7);
                gVar.field_msg_id = Kp.getString(columnIndex8);
                gVar.field_msg_type = Kp.getInt(columnIndex9);
                gVar.field_jump_type = Kp.getInt(columnIndex10);
                gVar.field_url = Kp.getString(columnIndex11);
                gVar.field_buttonData = Kp.getBlob(columnIndex12);
                gVar.field_operData = Kp.getBlob(columnIndex13);
                gVar.field_report_scene = Kp.getInt(columnIndex14);
                gVar.field_read_state = Kp.getInt(columnIndex15);
                Kp.moveToNext();
                this.eBB.add(gVar);
            }
        }
        if (Kp != null) {
            Kp.close();
        }
    }

    public static String f(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            if (be.kS((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + be.KJ(be.ma((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + be.KJ(be.ma((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + be.KJ(be.ma((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + be.KJ(be.ma((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!be.kS(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String g(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (be.kS((String) map.get(str2 + ".card_id")) && be.kS(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + be.KJ(be.ma((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + be.KJ(be.ma((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + be.KJ(be.ma((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + be.KJ(be.ma((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + be.KJ(be.ma((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + be.KJ(be.ma((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!be.kS(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public final boolean pM(String str) {
        if (this.eBB == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.eBB.size(); i++) {
            g gVar = (g) this.eBB.get(i);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean pN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g gVar;
        if (this.eBB == null || TextUtils.isEmpty(str)) {
            gVar = null;
        } else {
            for (int i = 0; i < this.eBB.size(); i++) {
                gVar = (g) this.eBB.get(i);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
            }
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        this.eBB.remove(gVar);
        c(gVar);
        return true;
    }

    public static boolean c(g gVar) {
        boolean z = false;
        if (gVar != null) {
            z = af.aam().c(gVar, new String[0]);
            if (!z) {
                v.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
        }
        return z;
    }

    public final void ZZ() {
        this.eBC = 0;
        ak.yW();
        c.vf().set(139268, Integer.valueOf(this.eBC));
    }

    public static void aaa() {
        v.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        e.a(new Runnable() {
            public final void run() {
                v.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npD, "");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npJ, Integer.valueOf(0));
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npG, "");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npH, "");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npI, "");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npU, "");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.npV, Boolean.valueOf(false));
                if (com.tencent.mm.p.c.us().ay(262152, 266256)) {
                    com.tencent.mm.p.c.us().t(262152, false);
                }
                if (com.tencent.mm.p.c.us().ax(262152, 266256)) {
                    com.tencent.mm.p.c.us().s(262152, false);
                }
                if (com.tencent.mm.p.c.us().a(com.tencent.mm.storage.t.a.npx, com.tencent.mm.storage.t.a.npz)) {
                    com.tencent.mm.p.c.us().a(com.tencent.mm.storage.t.a.npx, false);
                }
                if (com.tencent.mm.p.c.us().a(com.tencent.mm.storage.t.a.npy, com.tencent.mm.storage.t.a.npA)) {
                    com.tencent.mm.p.c.us().a(com.tencent.mm.storage.t.a.npy, false);
                }
                v.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
            }
        }, "clearRedDotAndWording");
    }
}
