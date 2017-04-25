package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String aXz = "";
    public int efm = 0;
    public String gIz = "";
    public String gkC = "";
    public String gmz = "";

    public static a uI(String str) {
        v.d(TAG, "getIPCallActivityMsgInfoFromXML:" + str);
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            v.e(TAG, "msgContent not start with <ActivityInfo");
            return aVar;
        }
        Map q = bf.q(str.substring(indexOf), "ActivityInfo");
        if (q == null) {
            v.e(TAG, "XmlParser values is null, xml %s", new Object[]{str});
            return null;
        }
        if (q.containsKey(".ActivityInfo.Title")) {
            aVar.aXz = (String) q.get(".ActivityInfo.Title");
        }
        if (q.containsKey(".ActivityInfo.Desc")) {
            aVar.gkC = (String) q.get(".ActivityInfo.Desc");
        }
        if (q.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.gmz = (String) q.get(".ActivityInfo.ImgUrl");
        }
        if (q.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.gIz = (String) q.get(".ActivityInfo.StartBtnText");
        }
        if (q.containsKey(".ActivityInfo.Type")) {
            aVar.efm = be.getInt((String) q.get(".ActivityInfo.Type"), 0);
        }
        v.d(TAG, "msgInfo:", new Object[]{aVar.toString()});
        return aVar;
    }
}
