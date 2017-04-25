package com.tencent.mm.aj;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String biW;
    public LinkedList<String> cTm = new LinkedList();
    public String url;

    public d(Map<String, String> map) {
        super(map);
    }

    protected final boolean HK() {
        if (this.values == null) {
            v.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        v.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", be.ma(this.TYPE), Integer.valueOf(this.values.size()));
        if (be.kS(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            v.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", be.ma(this.TYPE));
            return false;
        }
        this.url = be.ma((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.biW = be.ma((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.cTm.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.values.keySet()) {
            if (!str.startsWith(cSV)) {
                int length;
                if (str.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str));
                    this.cSZ.add(this.values.get(str));
                    length = ((String) this.values.get(str)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str));
            } else {
                stringBuilder.append((String) this.values.get(str));
            }
        }
        this.cTa.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.cTb.add(Integer.valueOf(stringBuilder.length()));
        this.cSX = stringBuilder.toString();
        v.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.biW, Integer.valueOf(this.cTm.size()));
        return true;
    }
}
