package com.tencent.mm.plugin.card.model;

import com.tencent.mm.e.b.z;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends z {
    protected static com.tencent.mm.sdk.h.c.a chq;
    public String eCK = "";
    public String eCL = "";
    public String eCM;
    public String eCN;
    public String eCO;
    public boolean eCP = false;
    public is eCQ;
    public iw eCR;
    public List<a> eCS = null;
    public List<b> eCT = null;
    public int eCU = 0;
    public int eCV = 0;

    public class a {
        public String bns;
        public String eCW;
        public String eCX;
        public int eCY;
        public int eCZ;
        final /* synthetic */ g eDa;
        public String title;

        public a(g gVar) {
            this.eDa = gVar;
        }
    }

    public class b {
        public String description;
        final /* synthetic */ g eDa;
        public String eDb;
        public String eDc;
        public String title;

        public b(g gVar) {
            this.eDa = gVar;
        }
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[19];
        aVar.bXK = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "card_type";
        aVar.nmd.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[1] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "description";
        aVar.nmd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "logo_url";
        aVar.nmd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "time";
        aVar.nmd.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "card_id";
        aVar.nmd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "card_tp_id";
        aVar.nmd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "msg_id";
        aVar.nmd.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msg_id";
        aVar.bXK[8] = "msg_type";
        aVar.nmd.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "jump_type";
        aVar.nmd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "url";
        aVar.nmd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "buttonData";
        aVar.nmd.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[12] = "operData";
        aVar.nmd.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[13] = "report_scene";
        aVar.nmd.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[14] = "read_state";
        aVar.nmd.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "accept_buttons";
        aVar.nmd.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "consumed_box_id";
        aVar.nmd.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "jump_buttons";
        aVar.nmd.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.bXK[18] = "logo_color";
        aVar.nmd.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        aVar.bXK[19] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final is aab() {
        if (this.eCQ != null) {
            return this.eCQ;
        }
        try {
            this.eCQ = (is) new is().az(this.field_buttonData);
            return this.eCQ;
        } catch (Throwable e) {
            v.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new is();
        }
    }

    public final iw aac() {
        if (this.eCR != null) {
            return this.eCR;
        }
        try {
            this.eCR = (iw) new iw().az(this.field_operData);
            return this.eCR;
        } catch (Throwable e) {
            v.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new iw();
        }
    }

    public final void aad() {
        if (this.eCS == null) {
            this.eCS = new ArrayList();
            if (!be.kS(this.field_accept_buttons)) {
                Map q = bf.q(this.field_accept_buttons, "accept_buttons_list");
                if (q != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) q.get(str + ".title");
                        if (!be.kS((String) q.get(str + ".card_id")) || !be.kS(str2)) {
                            int i2 = be.getInt((String) q.get(str + ".end_time"), 0);
                            if (i2 == 0 || ((long) i2) > be.Nh()) {
                                a aVar = new a(this);
                                aVar.title = (String) q.get(str + ".title");
                                aVar.eCW = (String) q.get(str + ".sub_title");
                                aVar.eCX = (String) q.get(str + ".card_ext");
                                aVar.bns = (String) q.get(str + ".card_id");
                                aVar.eCZ = be.getInt((String) q.get(str + ".action_type"), 0);
                                aVar.eCY = i2;
                                this.eCS.add(aVar);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void aae() {
        if (this.eCT == null) {
            this.eCT = new ArrayList();
            if (!be.kS(this.field_jump_buttons)) {
                Map q = bf.q(this.field_jump_buttons, "jump_buttons_list");
                if (q != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".jump_buttons_list.jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        if (!be.kS((String) q.get(str + ".title"))) {
                            b bVar = new b(this);
                            bVar.title = (String) q.get(str + ".title");
                            bVar.description = (String) q.get(str + ".description");
                            bVar.eDb = (String) q.get(str + ".button_wording");
                            bVar.eDc = (String) q.get(str + ".jump_url");
                            this.eCT.add(bVar);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
