package com.tencent.mm.model.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    a cvS = null;
    a cvT = null;

    final void gb(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            return;
        }
        v.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", str);
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    a aVar = new a();
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            d dVar = new d();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem("id");
                                if (namedItem != null) {
                                    v.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", namedItem.getNodeValue());
                                    dVar.id = r9;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    v.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", namedItem2.getNodeValue());
                                    dVar.cvU = r7;
                                }
                            }
                            v.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", item.getTextContent());
                            dVar.value = r6;
                            aVar.cvR.put(dVar.id, dVar);
                        } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                            if (item != null) {
                                if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                    v.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", item.getTextContent());
                                    aVar.cvO = r6;
                                }
                            }
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                v.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", item.getTextContent());
                                aVar.cvP = r6;
                            } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                v.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", item.getTextContent());
                                aVar.cvQ = r6;
                            }
                        } else {
                            v.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", item.getTextContent());
                            aVar.cvN = r6;
                        }
                    }
                    if (be.kS(aVar.cvO) || !"0".equals(aVar.cvO)) {
                        this.cvS = aVar;
                    } else {
                        this.cvT = aVar;
                    }
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", e.toString());
        }
    }

    public final boolean Ah() {
        if (this.cvS == null) {
            return false;
        }
        return true;
    }

    public final d ga(String str) {
        d dVar = null;
        if (this.cvS != null) {
            dVar = this.cvS.ga(str);
        }
        if (dVar != null || this.cvT == null) {
            return dVar;
        }
        return this.cvT.ga(str);
    }
}
