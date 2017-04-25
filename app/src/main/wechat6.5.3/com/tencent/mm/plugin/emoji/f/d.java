package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class d {
    public static ArrayList<a> rF(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("Emotion");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<a> arrayList = new ArrayList();
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                a aVar = new a();
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                int length = childNodes.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = childNodes.item(i2);
                    if (item != null && item.getNodeName() != null && item.getNodeName().equals("ProductID")) {
                        v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", new Object[]{item.getTextContent()});
                        aVar.field_productID = r9;
                    } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("RecType")) {
                        if (item != null) {
                            if (item.getNodeName() != null && item.getNodeName().equals("RecWord")) {
                                v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", new Object[]{item.getTextContent()});
                                aVar.field_recommandWord = r9;
                            }
                        }
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("Name")) {
                            v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", new Object[]{item.getTextContent()});
                            aVar.field_packName = r9;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Panel")) {
                            v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", new Object[]{item.getTextContent()});
                            aVar.field_packGrayIconUrl = r9;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Icon")) {
                            v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", new Object[]{item.getTextContent()});
                            aVar.field_BigIconUrl = r9;
                        } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("ButtonType"))) {
                            v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", new Object[]{item.getTextContent()});
                            aVar.field_buttonType = Integer.valueOf(r9).intValue();
                        }
                    } else {
                        v.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", new Object[]{item.getTextContent()});
                        aVar.field_recommandType = Integer.valueOf(r9).intValue();
                    }
                }
                if (!be.kS(aVar.field_productID)) {
                    aVar.field_recommand = 1;
                    aVar.field_lastUseTime = System.currentTimeMillis();
                    aVar.field_sort = 0;
                    g.iuh.h(12068, new Object[]{Integer.valueOf(1), aVar.field_productID, Integer.valueOf(aVar.field_recommandType)});
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
