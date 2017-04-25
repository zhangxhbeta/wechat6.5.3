package com.tencent.mm.model;

import com.tencent.mm.e.a.bn;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class p implements d {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null || bmVar.mbW == null) {
            v.f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
        } else {
            v.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(m.a(bmVar.mbW).getBytes("utf-8"))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("deletepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        Node item = childNodes.item(i);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack"))) {
                            NamedNodeMap attributes = item.getAttributes();
                            if (attributes != null) {
                                item = attributes.getNamedItem("type");
                                if (item != null) {
                                    int i2 = be.getInt(item.getNodeValue(), 0);
                                    com.tencent.mm.sdk.c.b bnVar = new bn();
                                    bnVar.aZb.aZc = i2;
                                    com.tencent.mm.sdk.c.a.nhr.z(bnVar);
                                }
                            }
                        }
                    }
                }
                v.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
            } catch (Throwable e) {
                v.e("MicroMsg.DeletePackageMsgExtension", "exception:%s", be.e(e));
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
