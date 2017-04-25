package com.tencent.mm.storage;

import com.tencent.mm.storage.au.b;
import com.tencent.mmdb.FileUtils;
import junit.framework.Assert;

public final class h extends e {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )"};

    public h(au auVar) {
        super(auVar);
        e.a(buZ(), "appbrandmessage");
        a(new b(FileUtils.S_IRUSR, "appbrandmessage", b.a(3000001, 3500000, 102000001, 105000000)));
    }

    public final String Lu(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (u.dW(str)) {
            return "appbrandmessage";
        }
        return null;
    }
}
