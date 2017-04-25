package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ba.b;
import com.tencent.mm.protocal.c.anl;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String bob;
    public LinkedList<anl> emi = new LinkedList();
    public int fvC;
    public String fvD;
    public int gFG;
    public long gFH;
    public long gFI;
    public int gFJ;
    public int gFK;
    public int gFL;
    public int gFM;
    public String gFN;
    public int gFO;
    public int gFP;
    public int gFQ;
    public int gFR;
    public int gFS;
    public boolean gFT = false;
    public boolean gFU = false;
    public boolean gFV = false;
    public boolean gFW = true;
    public int gFX = 0;
    public int gFY;
    public int gFZ;
    public int gGa;
    public b gGb;
    public int gGc;
    public int gGd;
    public b gGe;
    public LinkedList<anl> gGf = new LinkedList();
    public int gGg = 999;
    public LinkedList<d> gGh = new LinkedList();
    public String gGi;
    public String gGj;
    public boolean gGk = false;

    public final int auB() {
        if (this.gGh == null || this.gGh.size() <= 0) {
            return this.gFP;
        }
        return ((d) this.gGh.get(0)).gFP;
    }

    public final int auC() {
        if (this.gGh == null || this.gGh.size() <= 0) {
            return this.gFQ;
        }
        return ((d) this.gGh.get(0)).cjs;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.gFG), Long.valueOf(this.gFH), Long.valueOf(this.gFI), Integer.valueOf(this.gFJ), Integer.valueOf(this.gFO), Integer.valueOf(this.gFP), Integer.valueOf(this.gFR), Integer.valueOf(this.gFQ), this.fvD, Integer.valueOf(this.fvC), Integer.valueOf(this.gFM)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.bob, this.gGi}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.emi.iterator();
        while (it.hasNext()) {
            anl com_tencent_mm_protocal_c_anl = (anl) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{com_tencent_mm_protocal_c_anl.mGp, Integer.valueOf(com_tencent_mm_protocal_c_anl.mNM)}));
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        if (this.gGh == null || this.gGh.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.gGh.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}
