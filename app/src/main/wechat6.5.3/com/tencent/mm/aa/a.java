package com.tencent.mm.aa;

import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import junit.framework.Assert;

public final class a extends k implements j {
    private at aXd = new at();
    private e cii;
    private ac handler = new ac(this) {
        final /* synthetic */ a cGz;

        {
            this.cGz = r1;
        }

        public final void handleMessage(Message message) {
            this.cGz.a(TbsLog.TBSLOG_CODE_SDK_INIT, 0, 0, SQLiteDatabase.KeyEmpty, null, null);
        }
    };

    public a(String str, String str2) {
        boolean z = true;
        this.aXd.dh(1);
        this.aXd.cH(str);
        this.aXd.z(aw.fN(str));
        this.aXd.di(1);
        this.aXd.setContent(str2);
        this.aXd.setType(m.fp(str));
        ak.yW();
        long R = c.wJ().R(this.aXd);
        if (R == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        v.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + R);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.aXd.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        return TbsLog.TBSLOG_CODE_SDK_INIT;
    }

    public final int getType() {
        return 522;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.aXd.field_msgId);
        this.aXd.dh(2);
        this.aXd.z(aw.h(this.aXd.field_talker, System.currentTimeMillis() / 1000));
        ak.yW();
        c.wJ().a(this.aXd.field_msgId, this.aXd);
        this.cii.a(0, 0, str, this);
    }
}
