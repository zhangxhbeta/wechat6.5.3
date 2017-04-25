package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public List<j> eBB = new ArrayList();
    private List<a> hMQ = new ArrayList();

    public c() {
        loadFromDB();
        aFL();
        aFK();
        aFM();
    }

    public final void a(j jVar, String str, String str2) {
        if (jVar != null && !TextUtils.isEmpty(str)) {
            a aVar = new a();
            aVar.field_msgId = jVar.blm;
            aVar.field_msgContentXml = str;
            aVar.field_isRead = str2;
            b.aFF();
            if (!b.aFH().a(aVar)) {
                v.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.blm);
            }
            this.hMQ.add(aVar);
        }
    }

    private void loadFromDB() {
        b.aFF();
        Cursor Kp = b.aFH().Kp();
        if (Kp != null && Kp.getCount() > 0) {
            Kp.moveToFirst();
            int columnIndex = Kp.getColumnIndex("msgId");
            int columnIndex2 = Kp.getColumnIndex("msgContentXml");
            int columnIndex3 = Kp.getColumnIndex("isRead");
            while (!Kp.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = Kp.getString(columnIndex);
                aVar.field_msgContentXml = Kp.getString(columnIndex2);
                aVar.field_isRead = Kp.getString(columnIndex3);
                Kp.moveToNext();
                this.hMQ.add(aVar);
            }
        }
        if (Kp != null) {
            Kp.close();
        }
    }

    private void aFK() {
        if (this.eBB != null && this.eBB.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.eBB);
            for (int i = 0; i < arrayList.size(); i++) {
                j jVar = (j) arrayList.get(i);
                if (jVar.hOk != null && com.tencent.mm.plugin.order.c.c.qw(jVar.hOk)) {
                    int intValue = Integer.valueOf(jVar.hOk).intValue();
                    if (!(intValue == 2 || intValue == 1)) {
                        xA(jVar.blm);
                    }
                }
            }
        }
    }

    public static j xz(String str) {
        Map q = bf.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        String str2;
        j jVar = new j();
        jVar.hOk = (String) q.get(".sysmsg.paymsg.PayMsgType");
        jVar.hOl = (String) q.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.hOm = (String) q.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.hOn = (String) q.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.hOo = (String) q.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.blu = (String) q.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.hOp = (String) q.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.hOq = (String) q.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.hOa = (String) q.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.hOr = (String) q.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i = 0;
        while (true) {
            if (i == 0) {
                Object obj = (String) q.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str2 = (String) q.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                String str3 = (String) q.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
                str2 = (String) q.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                break;
            }
            j.a aVar = new j.a();
            aVar.name = obj;
            aVar.jumpUrl = str2;
            if (jVar.hOs == null) {
                jVar.hOs = new ArrayList();
            }
            jVar.hOs.add(aVar);
            i++;
        }
        i = 0;
        while (true) {
            String str4;
            if (i == 0) {
                obj = (String) q.get(".sysmsg.paymsg.NormalSection.Name");
                str2 = (String) q.get(".sysmsg.paymsg.NormalSection.Value");
                str4 = (String) q.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                str3 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
                str2 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
                str4 = (String) q.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                return jVar;
            }
            j.b bVar = new j.b();
            bVar.name = obj;
            bVar.value = str2;
            bVar.jumpUrl = str4;
            if (jVar.hOt == null) {
                jVar.hOt = new ArrayList();
            }
            jVar.hOt.add(bVar);
            i++;
        }
    }

    public final boolean xA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        j xC = xC(str);
        if (xC == null) {
            return false;
        }
        this.eBB.remove(xC);
        if (xC != null) {
            for (int i = 0; i < this.hMQ.size(); i++) {
                a aVar = (a) this.hMQ.get(i);
                if (xC.blm.equals(aVar.field_msgId)) {
                    this.hMQ.remove(aVar);
                    b.aFF();
                    b.aFH().c(aVar, new String[0]);
                    break;
                }
            }
        }
        return true;
    }

    private void aFL() {
        for (int i = 0; i < this.hMQ.size(); i++) {
            a aVar = (a) this.hMQ.get(i);
            String str = aVar.field_msgContentXml;
            j xz = xz(str);
            xz.blm = aVar.field_msgId;
            this.eBB.add(xz);
            v.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:" + str);
        }
    }

    public final boolean xB(String str) {
        if (this.eBB == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.eBB.size(); i++) {
            j jVar = (j) this.eBB.get(i);
            if (jVar != null && jVar.blm.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final j xC(String str) {
        if (this.eBB == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.eBB.size(); i++) {
            j jVar = (j) this.eBB.get(i);
            if (str.equals(jVar.blm)) {
                return jVar;
            }
        }
        return null;
    }

    public final a xD(String str) {
        if (this.hMQ == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.hMQ.size(); i++) {
            a aVar = (a) this.hMQ.get(i);
            if (str.equals(aVar.field_msgId)) {
                return aVar;
            }
        }
        return null;
    }

    public final void aFM() {
        int aFN = aFN();
        ak.yW();
        com.tencent.mm.model.c.vf().set(204820, Integer.valueOf(aFN));
        v.v("MicroMsg.MallPayMsgManager", "save unread msg is :" + aFN);
    }

    public final int aFN() {
        if (this.hMQ == null || this.hMQ.size() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.hMQ.size(); i2++) {
            a aVar = (a) this.hMQ.get(i2);
            if (aVar != null && "0".equals(aVar.field_isRead)) {
                i++;
            }
        }
        v.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:" + i);
        return i;
    }

    public static MallOrderDetailObject a(j jVar) {
        if (jVar == null) {
            return null;
        }
        int i;
        MallOrderDetailObject mallOrderDetailObject = new MallOrderDetailObject();
        MallOrderDetailObject.b bVar = new MallOrderDetailObject.b();
        bVar.hML = jVar.hOo;
        if (TextUtils.isEmpty(jVar.hOm) || !com.tencent.mm.plugin.order.c.c.qw(jVar.hOm)) {
            bVar.hrm = (int) (System.currentTimeMillis() / 1000);
        } else {
            bVar.hrm = Integer.valueOf(jVar.hOm).intValue();
        }
        bVar.bea = jVar.hOn;
        bVar.gkT = jVar.hOp;
        bVar.hMM = jVar.blu;
        mallOrderDetailObject.hMD = bVar;
        List list = jVar.hOs;
        if (list != null && list.size() > 0) {
            mallOrderDetailObject.hMF = new ArrayList();
            for (i = 0; i < list.size(); i++) {
                j.a aVar = (j.a) list.get(i);
                MallOrderDetailObject.a aVar2 = new MallOrderDetailObject.a();
                aVar2.name = aVar.name;
                aVar2.value = "";
                aVar2.jumpUrl = aVar.jumpUrl;
                aVar2.eBV = false;
                mallOrderDetailObject.hMF.add(aVar2);
            }
        }
        list = jVar.hOt;
        if (list != null && list.size() > 0) {
            if (mallOrderDetailObject.hMF == null) {
                mallOrderDetailObject.hMF = new ArrayList();
            }
            for (i = 0; i < list.size(); i++) {
                j.b bVar2 = (j.b) list.get(i);
                aVar2 = new MallOrderDetailObject.a();
                aVar2.name = bVar2.name;
                aVar2.value = bVar2.value;
                aVar2.jumpUrl = bVar2.jumpUrl;
                aVar2.eBV = false;
                if (i == 0) {
                    aVar2.eBV = true;
                }
                mallOrderDetailObject.hMF.add(aVar2);
            }
        }
        mallOrderDetailObject.hMJ = jVar.hOr;
        mallOrderDetailObject.gcD = jVar.hOq;
        if (TextUtils.isEmpty(jVar.hOm) || !com.tencent.mm.plugin.order.c.c.qw(jVar.hOm)) {
            mallOrderDetailObject.hMK = (int) (System.currentTimeMillis() / 1000);
        } else {
            mallOrderDetailObject.hMK = Integer.valueOf(jVar.hOm).intValue();
        }
        return mallOrderDetailObject;
    }
}
