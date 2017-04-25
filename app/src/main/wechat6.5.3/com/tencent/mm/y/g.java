package com.tencent.mm.y;

import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.at.d;
import java.util.LinkedList;

public final class g extends w {
    public final boolean eH(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        if (i != 0 && i < 604307701) {
            ak.yW();
            at[] bU = c.wJ().bU("fmessage", 20);
            if (bU == null) {
                v.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                return;
            }
            l.KD();
            v.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + bU.length);
            for (bx bxVar : bU) {
                if (bxVar != null && bxVar.field_msgId != 0) {
                    v.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + bxVar.field_type);
                    String str = bxVar.field_content;
                    if (str != null && str.length() != 0) {
                        f fVar;
                        switch (bxVar.field_type) {
                            case 37:
                                v.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + bxVar.field_content);
                                d MB = d.MB(bxVar.field_content);
                                if (!t.kS(MB.lct) && (MB.scene == 18 || aw.eM(MB.scene))) {
                                    v.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + MB.scene);
                                    break;
                                }
                                fVar = new f();
                                fVar.field_createTime = bxVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = bxVar.field_content;
                                fVar.field_svrId = bxVar.field_msgSvrId;
                                fVar.field_talker = MB.lct;
                                switch (MB.bdn) {
                                    case 2:
                                        fVar.field_type = 1;
                                        break;
                                    case 5:
                                        fVar.field_type = 2;
                                        break;
                                    case 6:
                                        fVar.field_type = 3;
                                        break;
                                    default:
                                        fVar.field_type = 1;
                                        break;
                                }
                                l.KC().a(fVar);
                                break;
                                break;
                            case 40:
                                v.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + bxVar.field_content);
                                a My = a.My(bxVar.field_content);
                                fVar = new f();
                                fVar.field_createTime = bxVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = bxVar.field_content;
                                fVar.field_svrId = bxVar.field_msgSvrId;
                                fVar.field_talker = My.lct;
                                fVar.field_type = 0;
                                l.KC().a(fVar);
                                break;
                            default:
                                v.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + bxVar.field_type);
                                break;
                        }
                    }
                    v.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + bxVar.field_msgId);
                } else {
                    v.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            ak.yW();
            c.vf().set(143618, Integer.valueOf(0));
            l.KD().Kq();
            v.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            ak.yW();
            c.wH().Mc("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            ak.yW();
            c.wK().ai(linkedList);
        }
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
