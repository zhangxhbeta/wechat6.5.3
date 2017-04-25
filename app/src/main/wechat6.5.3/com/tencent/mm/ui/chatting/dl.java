package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.q.a.a;
import com.tencent.mm.storage.at;

final class dl extends c {
    String aZD;
    String bNm;
    String biB;
    String bnR;
    String bnS;
    String cCj;
    String cqe;
    String desc;
    String designerName;
    String designerRediretctUrl;
    int designerUIN;
    int eKg;
    String iconUrl;
    long lfd;
    int lfe;
    boolean nQK;
    a osd;
    boolean oxP;
    String oxQ;
    boolean oxR;
    boolean oxS;
    String oxT;
    boolean oxU;
    String oxV;
    int pageType;
    int position;
    String secondUrl;
    int tid;
    String title;
    String userName;

    public dl(at atVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.bmk = atVar;
        this.nQK = false;
        this.position = i;
        this.userName = str;
        this.eKg = 10;
        this.oxP = false;
        this.title = str2;
        this.bnR = str3;
        this.bnS = str4;
        this.oxQ = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.bNm = str8;
    }

    public dl(at atVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.bmk = atVar;
        this.nQK = z;
        this.position = i;
        this.userName = str;
        this.eKg = i2;
        this.oxP = z2;
        this.title = str2;
        this.bnR = str3;
        this.bnS = str4;
        this.oxQ = str5;
        this.aZD = str6;
        this.bNm = str7;
        this.oxR = z3;
        this.oxS = z4;
    }

    public dl(at atVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4, String str5) {
        this(atVar, z, i, str, i2, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public dl(at atVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4) {
        this(atVar, z, i, str, i2, z2, str2, str3, str4, null);
    }

    private dl(at atVar, boolean z, int i, String str, int i2, boolean z2) {
        this(atVar, z, i, str, i2, false, null, null, null);
    }

    private dl(at atVar, boolean z, int i, String str, int i2) {
        this(atVar, z, i, str, i2, false);
    }

    public dl(at atVar, boolean z, int i, String str, int i2, byte b) {
        this(atVar, z, i, str, i2);
    }

    public dl(at atVar, boolean z, int i, String str, String str2) {
        this(atVar, z, i, str, 0);
        this.biB = str2;
    }

    public dl(at atVar, String str, int i) {
        this(str, i);
        this.bmk = atVar;
    }

    private dl(String str, int i) {
        this.userName = str;
        this.eKg = i;
    }

    public dl(String str, int i, String str2) {
        this.userName = str;
        this.eKg = i;
        this.biB = str2;
    }

    public dl(at atVar, String str, String str2) {
        this.bmk = atVar;
        this.userName = str;
        this.bmk = atVar;
        this.oxV = str2;
        this.eKg = 6;
    }

    public static dl Pa(String str) {
        dl dlVar = new dl();
        dlVar.eKg = 7;
        dlVar.bNm = str;
        return dlVar;
    }

    public static dl a(a aVar, at atVar) {
        dl dlVar = new dl();
        dlVar.osd = aVar;
        dlVar.bmk = atVar;
        return dlVar;
    }

    public static dl a(at atVar, boolean z, int i) {
        dl dlVar = new dl();
        dlVar.bmk = atVar;
        dlVar.nQK = z;
        dlVar.position = i;
        dlVar.eKg = 0;
        dlVar.oxU = false;
        return dlVar;
    }
}
