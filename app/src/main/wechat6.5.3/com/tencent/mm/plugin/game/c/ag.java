package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.c.n.c;
import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class ag {
    private static String G(LinkedList<g> linkedList) {
        if (be.bP(linkedList)) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            newSerializer.startTag(null, "userinfo");
            newSerializer.attribute(null, "jump_id", gVar.gjk);
            newSerializer.startTag(null, "username");
            try {
                newSerializer.text(be.ah(gVar.userName, ""));
            } catch (Exception e) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "username");
            newSerializer.startTag(null, "nickname");
            try {
                newSerializer.text(be.ah(gVar.aGX, ""));
            } catch (Exception e2) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "nickname");
            newSerializer.startTag(null, "usericon");
            try {
                newSerializer.text(be.ah(gVar.gjh, ""));
            } catch (Exception e3) {
                newSerializer.text("");
            }
            try {
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, "profile");
                try {
                    newSerializer.text(be.ah(gVar.gji, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "profile");
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(be.ah(gVar.gjj, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            } catch (Exception e6) {
                v.e("MicroMsg.GameXmlProcess", e6.getMessage());
                return "";
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    private static String a(LinkedList<g> linkedList, HashMap<String, c> hashMap) {
        if (be.bP(linkedList) || hashMap.isEmpty()) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            c cVar = (c) hashMap.get(gVar.gjk);
            if (cVar != null) {
                newSerializer.startTag(null, "jump");
                newSerializer.attribute(null, "id", gVar.gjk);
                newSerializer.startTag(null, "jump_type");
                try {
                    newSerializer.text(String.valueOf(cVar.gjb));
                } catch (Exception e) {
                    try {
                        newSerializer.text("");
                    } catch (Exception e2) {
                        v.e("MicroMsg.GameXmlProcess", e2.getMessage());
                        return "";
                    }
                }
                newSerializer.endTag(null, "jump_type");
                newSerializer.startTag(null, "jump_url");
                try {
                    newSerializer.text(be.ah(cVar.fBu, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "jump_url");
                newSerializer.endTag(null, "jump");
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    public static String a(String str, LinkedList<g> linkedList, HashMap<String, c> hashMap) {
        if (be.kS(str) || be.bP(linkedList)) {
            return str;
        }
        String G = G(linkedList);
        if (be.kS(G)) {
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, G);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || be.kS(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            v.e("MicroMsg.GameXmlProcess", e.getMessage());
            v.e("MicroMsg.GameXmlProcess", "xml is invalid : " + str);
        }
        return stringBuilder.toString();
    }
}
