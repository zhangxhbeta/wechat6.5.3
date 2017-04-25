package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<nu> rD(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<nu> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                Node item = elementsByTagName.item(i);
                nu nuVar = new nu();
                String toLowerCase = item.getTextContent().toLowerCase();
                NamedNodeMap attributes = item.getAttributes();
                Node namedItem = attributes.getNamedItem("thumburl");
                if (namedItem != null) {
                    nuVar.hOx = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("cdnurl");
                if (namedItem != null) {
                    nuVar.glb = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("productid");
                if (namedItem != null) {
                    nuVar.mdM = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("designerid");
                if (namedItem != null) {
                    nuVar.mpD = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("aeskey");
                if (namedItem != null) {
                    nuVar.mpF = namedItem.getNodeValue();
                }
                item = attributes.getNamedItem("encrypturl");
                if (item != null) {
                    nuVar.mpE = item.getNodeValue();
                }
                nuVar.mpC = toLowerCase;
                arrayList.add(nuVar);
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static ArrayList<String> rE(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                arrayList.add(elementsByTagName.item(i).getTextContent());
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
