package com.tencent.mm.model.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class a {
    private static DocumentBuilder cwc = null;

    public static class a {
        public List<c> cwd = new LinkedList();
        public List<com.tencent.mm.storage.a> cwe = new LinkedList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.model.c.a.a gi(java.lang.String r21) {
        /*
        r6 = new com.tencent.mm.model.c.a$a;
        r6.<init>();
        r2 = "MicroMsg.ABTestParser";
        r3 = "ABTest msg content: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r21;
        com.tencent.mm.sdk.platformtools.v.v(r2, r3, r4);
        r3 = gk(r21);
        if (r3 != 0) goto L_0x002b;
    L_0x001a:
        r2 = "MicroMsg.ABTestParser";
        r3 = "Msg parsing failed, msg: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r21;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        r2 = r6;
    L_0x002a:
        return r2;
    L_0x002b:
        r2 = r3.getAttributes();
        if (r2 != 0) goto L_0x0033;
    L_0x0031:
        r2 = 0;
        goto L_0x002a;
    L_0x0033:
        r4 = "type";
        r4 = r2.getNamedItem(r4);
        r2 = 1;
        if (r4 == 0) goto L_0x0357;
    L_0x003d:
        r5 = "newabtestinfo";
        r4 = r4.getNodeValue();
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x0357;
    L_0x004a:
        r4 = "prioritylevel";
        r4 = r3.getElementsByTagName(r4);
        r5 = r4.getLength();
        if (r5 <= 0) goto L_0x0357;
    L_0x0057:
        r2 = 0;
        r2 = r4.item(r2);
        r2 = r2.getTextContent();
        r4 = 1;
        r2 = com.tencent.mm.sdk.platformtools.be.getInt(r2, r4);
        r4 = r2;
    L_0x0066:
        r14 = r3.getChildNodes();
        r2 = 0;
        r5 = r2;
    L_0x006c:
        r2 = r14.getLength();
        if (r5 >= r2) goto L_0x034b;
    L_0x0072:
        r3 = r14.item(r5);
        if (r3 == 0) goto L_0x00c8;
    L_0x0078:
        r2 = r3.getNodeType();
        r7 = 1;
        if (r2 != r7) goto L_0x00a1;
    L_0x007f:
        r2 = r3.getNodeName();
        r7 = "exp";
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x00a1;
    L_0x008c:
        r0 = r3;
        r0 = (org.w3c.dom.Element) r0;	 Catch:{ Exception -> 0x0112 }
        r2 = r0;
        r7 = new com.tencent.mm.storage.c;	 Catch:{ Exception -> 0x0112 }
        r7.<init>();	 Catch:{ Exception -> 0x0112 }
        r8 = r2.getAttributes();	 Catch:{ Exception -> 0x0112 }
        if (r8 != 0) goto L_0x00cc;
    L_0x009b:
        r2 = 0;
    L_0x009c:
        r7 = r6.cwd;	 Catch:{ Exception -> 0x0112 }
        r7.add(r2);	 Catch:{ Exception -> 0x0112 }
    L_0x00a1:
        r2 = r3.getNodeType();
        r7 = 1;
        if (r2 != r7) goto L_0x00c8;
    L_0x00a8:
        r2 = r3.getNodeName();
        r7 = "expinfo";
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x00c8;
    L_0x00b5:
        r3 = (org.w3c.dom.Element) r3;	 Catch:{ Exception -> 0x033b }
        r7 = new java.util.LinkedList;	 Catch:{ Exception -> 0x033b }
        r7.<init>();	 Catch:{ Exception -> 0x033b }
        r2 = r3.getAttributes();	 Catch:{ Exception -> 0x033b }
        if (r2 != 0) goto L_0x01d8;
    L_0x00c2:
        r2 = 0;
    L_0x00c3:
        r3 = r6.cwe;	 Catch:{ Exception -> 0x033b }
        r3.addAll(r2);	 Catch:{ Exception -> 0x033b }
    L_0x00c8:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x006c;
    L_0x00cc:
        r9 = "layerid";
        r9 = r8.getNamedItem(r9);	 Catch:{ Exception -> 0x0112 }
        if (r9 != 0) goto L_0x00d7;
    L_0x00d5:
        r2 = 0;
        goto L_0x009c;
    L_0x00d7:
        r9 = r9.getNodeValue();	 Catch:{ Exception -> 0x0112 }
        r7.field_layerId = r9;	 Catch:{ Exception -> 0x0112 }
        r9 = "id";
        r9 = r8.getNamedItem(r9);	 Catch:{ Exception -> 0x0112 }
        if (r9 != 0) goto L_0x00e8;
    L_0x00e6:
        r2 = 0;
        goto L_0x009c;
    L_0x00e8:
        r9 = r9.getNodeValue();	 Catch:{ Exception -> 0x0112 }
        r7.field_expId = r9;	 Catch:{ Exception -> 0x0112 }
        r9 = "business";
        r8 = r8.getNamedItem(r9);	 Catch:{ Exception -> 0x0112 }
        if (r8 != 0) goto L_0x010b;
    L_0x00f7:
        r8 = "";
        r7.field_business = r8;	 Catch:{ Exception -> 0x0112 }
    L_0x00fc:
        r8 = "sequence";
        r8 = r2.getElementsByTagName(r8);	 Catch:{ Exception -> 0x0112 }
        r9 = r8.getLength();	 Catch:{ Exception -> 0x0112 }
        if (r9 != 0) goto L_0x011e;
    L_0x0109:
        r2 = 0;
        goto L_0x009c;
    L_0x010b:
        r8 = r8.getNodeValue();	 Catch:{ Exception -> 0x0112 }
        r7.field_business = r8;	 Catch:{ Exception -> 0x0112 }
        goto L_0x00fc;
    L_0x0112:
        r2 = move-exception;
        r7 = "MicroMsg.ABTestParser";
        r2 = r2.getMessage();
        com.tencent.mm.sdk.platformtools.v.e(r7, r2);
        goto L_0x00a1;
    L_0x011e:
        r9 = 0;
        r8 = r8.item(r9);	 Catch:{ Exception -> 0x0112 }
        r8 = r8.getTextContent();	 Catch:{ Exception -> 0x0112 }
        r10 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getLong(r8, r10);	 Catch:{ Exception -> 0x0112 }
        r7.field_sequence = r8;	 Catch:{ Exception -> 0x0112 }
        r8 = "prioritylevel";
        r8 = r2.getElementsByTagName(r8);	 Catch:{ Exception -> 0x0112 }
        r9 = r8.getLength();	 Catch:{ Exception -> 0x0112 }
        if (r9 <= 0) goto L_0x01d1;
    L_0x013c:
        r9 = 0;
        r8 = r8.item(r9);	 Catch:{ Exception -> 0x0112 }
        r8 = r8.getTextContent();	 Catch:{ Exception -> 0x0112 }
        r9 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getInt(r8, r9);	 Catch:{ Exception -> 0x0112 }
        r7.field_prioritylevel = r8;	 Catch:{ Exception -> 0x0112 }
    L_0x014c:
        r8 = "starttime";
        r8 = r2.getElementsByTagName(r8);	 Catch:{ Exception -> 0x0112 }
        r9 = r8.getLength();	 Catch:{ Exception -> 0x0112 }
        if (r9 <= 0) goto L_0x0172;
    L_0x0159:
        r9 = 0;
        r8 = r8.item(r9);	 Catch:{ Exception -> 0x0112 }
        r8 = r8.getTextContent();	 Catch:{ Exception -> 0x0112 }
        r10 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getLong(r8, r10);	 Catch:{ Exception -> 0x0112 }
        r7.field_startTime = r8;	 Catch:{ Exception -> 0x0112 }
        r8 = r7.field_startTime;	 Catch:{ Exception -> 0x0112 }
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 != 0) goto L_0x017b;
    L_0x0172:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0112 }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r10;
        r7.field_startTime = r8;	 Catch:{ Exception -> 0x0112 }
    L_0x017b:
        r8 = "endtime";
        r8 = r2.getElementsByTagName(r8);	 Catch:{ Exception -> 0x0112 }
        r9 = r8.getLength();	 Catch:{ Exception -> 0x0112 }
        if (r9 <= 0) goto L_0x01a1;
    L_0x0188:
        r9 = 0;
        r8 = r8.item(r9);	 Catch:{ Exception -> 0x0112 }
        r8 = r8.getTextContent();	 Catch:{ Exception -> 0x0112 }
        r10 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getLong(r8, r10);	 Catch:{ Exception -> 0x0112 }
        r7.field_endTime = r8;	 Catch:{ Exception -> 0x0112 }
        r8 = r7.field_endTime;	 Catch:{ Exception -> 0x0112 }
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 != 0) goto L_0x01a8;
    L_0x01a1:
        r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r7.field_endTime = r8;	 Catch:{ Exception -> 0x0112 }
    L_0x01a8:
        r8 = "noreport";
        r8 = r2.getElementsByTagName(r8);	 Catch:{ Exception -> 0x0112 }
        r9 = r8.getLength();	 Catch:{ Exception -> 0x0112 }
        if (r9 <= 0) goto L_0x01c8;
    L_0x01b5:
        r9 = 0;
        r8 = r8.item(r9);	 Catch:{ Exception -> 0x0112 }
        r8 = r8.getTextContent();	 Catch:{ Exception -> 0x0112 }
        r9 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getInt(r8, r9);	 Catch:{ Exception -> 0x0112 }
        if (r8 != 0) goto L_0x01d6;
    L_0x01c5:
        r8 = 1;
    L_0x01c6:
        r7.field_needReport = r8;	 Catch:{ Exception -> 0x0112 }
    L_0x01c8:
        r2 = a(r2);	 Catch:{ Exception -> 0x0112 }
        r7.field_rawXML = r2;	 Catch:{ Exception -> 0x0112 }
        r2 = r7;
        goto L_0x009c;
    L_0x01d1:
        r8 = 0;
        r7.field_prioritylevel = r8;	 Catch:{ Exception -> 0x0112 }
        goto L_0x014c;
    L_0x01d6:
        r8 = 0;
        goto L_0x01c6;
    L_0x01d8:
        r8 = "id";
        r2 = r2.getNamedItem(r8);	 Catch:{ Exception -> 0x033b }
        if (r2 != 0) goto L_0x01e4;
    L_0x01e1:
        r2 = 0;
        goto L_0x00c3;
    L_0x01e4:
        r15 = r2.getNodeValue();	 Catch:{ Exception -> 0x033b }
        r2 = "sequence";
        r2 = r3.getElementsByTagName(r2);	 Catch:{ Exception -> 0x033b }
        r8 = r2.getLength();	 Catch:{ Exception -> 0x033b }
        if (r8 != 0) goto L_0x01f8;
    L_0x01f5:
        r2 = 0;
        goto L_0x00c3;
    L_0x01f8:
        r8 = 0;
        r2 = r2.item(r8);	 Catch:{ Exception -> 0x033b }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x033b }
        r8 = 0;
        r16 = com.tencent.mm.sdk.platformtools.be.getLong(r2, r8);	 Catch:{ Exception -> 0x033b }
        r2 = "starttime";
        r2 = r3.getElementsByTagName(r2);	 Catch:{ Exception -> 0x033b }
        r8 = r2.getLength();	 Catch:{ Exception -> 0x033b }
        if (r8 <= 0) goto L_0x0229;
    L_0x0214:
        r8 = 0;
        r2 = r2.item(r8);	 Catch:{ Exception -> 0x033b }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x033b }
        r8 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getLong(r2, r8);	 Catch:{ Exception -> 0x033b }
        r10 = 0;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 != 0) goto L_0x0354;
    L_0x0229:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x033b }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r10;
        r12 = r8;
    L_0x0231:
        r2 = "endtime";
        r2 = r3.getElementsByTagName(r2);	 Catch:{ Exception -> 0x033b }
        r8 = r2.getLength();	 Catch:{ Exception -> 0x033b }
        if (r8 <= 0) goto L_0x0253;
    L_0x023e:
        r8 = 0;
        r2 = r2.item(r8);	 Catch:{ Exception -> 0x033b }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x033b }
        r8 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.getLong(r2, r8);	 Catch:{ Exception -> 0x033b }
        r10 = 0;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 != 0) goto L_0x0351;
    L_0x0253:
        r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r10 = r8;
    L_0x0259:
        r2 = "noreport";
        r8 = r3.getElementsByTagName(r2);	 Catch:{ Exception -> 0x033b }
        r2 = 0;
        r9 = r8.getLength();	 Catch:{ Exception -> 0x033b }
        if (r9 <= 0) goto L_0x034e;
    L_0x0267:
        r2 = 0;
        r2 = r8.item(r2);	 Catch:{ Exception -> 0x033b }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x033b }
        r8 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.getInt(r2, r8);	 Catch:{ Exception -> 0x033b }
        r8 = 1;
        if (r2 != r8) goto L_0x0301;
    L_0x0278:
        r2 = 1;
    L_0x0279:
        r9 = r2;
    L_0x027a:
        r18 = new java.util.HashMap;	 Catch:{ Exception -> 0x033b }
        r18.<init>();	 Catch:{ Exception -> 0x033b }
        r2 = "args";
        r2 = r3.getElementsByTagName(r2);	 Catch:{ Exception -> 0x033b }
        r3 = r2.getLength();	 Catch:{ Exception -> 0x033b }
        if (r3 <= 0) goto L_0x0304;
    L_0x028c:
        r3 = 0;
        r2 = r2.item(r3);	 Catch:{ Exception -> 0x033b }
        r19 = r2.getChildNodes();	 Catch:{ Exception -> 0x033b }
        r2 = 0;
        r8 = r2;
    L_0x0297:
        r2 = r19.getLength();	 Catch:{ Exception -> 0x033b }
        if (r8 >= r2) goto L_0x0304;
    L_0x029d:
        r0 = r19;
        r3 = r0.item(r8);	 Catch:{ Exception -> 0x033b }
        r2 = r3.getNodeType();	 Catch:{ Exception -> 0x033b }
        r20 = 1;
        r0 = r20;
        if (r2 != r0) goto L_0x02fd;
    L_0x02ad:
        r2 = r3.getNodeName();	 Catch:{ Exception -> 0x033b }
        r20 = "arg";
        r0 = r20;
        r2 = r2.equals(r0);	 Catch:{ Exception -> 0x033b }
        if (r2 == 0) goto L_0x02fd;
    L_0x02bc:
        r0 = r3;
        r0 = (org.w3c.dom.Element) r0;	 Catch:{ Exception -> 0x033b }
        r2 = r0;
        r20 = "key";
        r0 = r20;
        r2 = r2.getElementsByTagName(r0);	 Catch:{ Exception -> 0x033b }
        r3 = (org.w3c.dom.Element) r3;	 Catch:{ Exception -> 0x033b }
        r20 = "value";
        r0 = r20;
        r3 = r3.getElementsByTagName(r0);	 Catch:{ Exception -> 0x033b }
        r20 = r2.getLength();	 Catch:{ Exception -> 0x033b }
        if (r20 == 0) goto L_0x02fd;
    L_0x02da:
        r20 = r3.getLength();	 Catch:{ Exception -> 0x033b }
        if (r20 == 0) goto L_0x02fd;
    L_0x02e0:
        r20 = 0;
        r0 = r20;
        r2 = r2.item(r0);	 Catch:{ Exception -> 0x033b }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x033b }
        r20 = 0;
        r0 = r20;
        r3 = r3.item(r0);	 Catch:{ Exception -> 0x033b }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x033b }
        r0 = r18;
        r0.put(r2, r3);	 Catch:{ Exception -> 0x033b }
    L_0x02fd:
        r2 = r8 + 1;
        r8 = r2;
        goto L_0x0297;
    L_0x0301:
        r2 = 0;
        goto L_0x0279;
    L_0x0304:
        r2 = r18.keySet();	 Catch:{ Exception -> 0x033b }
        r3 = r2.iterator();	 Catch:{ Exception -> 0x033b }
    L_0x030c:
        r2 = r3.hasNext();	 Catch:{ Exception -> 0x033b }
        if (r2 == 0) goto L_0x0348;
    L_0x0312:
        r2 = r3.next();	 Catch:{ Exception -> 0x033b }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x033b }
        r8 = new com.tencent.mm.storage.a;	 Catch:{ Exception -> 0x033b }
        r8.<init>();	 Catch:{ Exception -> 0x033b }
        r8.field_abtestkey = r2;	 Catch:{ Exception -> 0x033b }
        r0 = r18;
        r2 = r0.get(r2);	 Catch:{ Exception -> 0x033b }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x033b }
        r8.field_value = r2;	 Catch:{ Exception -> 0x033b }
        r8.field_expId = r15;	 Catch:{ Exception -> 0x033b }
        r0 = r16;
        r8.field_sequence = r0;	 Catch:{ Exception -> 0x033b }
        r8.field_prioritylevel = r4;	 Catch:{ Exception -> 0x033b }
        r8.field_startTime = r12;	 Catch:{ Exception -> 0x033b }
        r8.field_endTime = r10;	 Catch:{ Exception -> 0x033b }
        r8.field_noReport = r9;	 Catch:{ Exception -> 0x033b }
        r7.add(r8);	 Catch:{ Exception -> 0x033b }
        goto L_0x030c;
    L_0x033b:
        r2 = move-exception;
        r3 = "MicroMsg.ABTestParser";
        r2 = r2.getMessage();
        com.tencent.mm.sdk.platformtools.v.e(r3, r2);
        goto L_0x00c8;
    L_0x0348:
        r2 = r7;
        goto L_0x00c3;
    L_0x034b:
        r2 = r6;
        goto L_0x002a;
    L_0x034e:
        r9 = r2;
        goto L_0x027a;
    L_0x0351:
        r10 = r8;
        goto L_0x0259;
    L_0x0354:
        r12 = r8;
        goto L_0x0231;
    L_0x0357:
        r4 = r2;
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.c.a.gi(java.lang.String):com.tencent.mm.model.c.a$a");
    }

    public static Map<String, String> gj(String str) {
        HashMap hashMap = new HashMap();
        Element gk = gk(str);
        if (gk == null) {
            v.e("MicroMsg.ABTestParser", "Raw XML string parsing failed, xml: %s", str);
            return hashMap;
        }
        NodeList elementsByTagName = gk.getElementsByTagName("args");
        if (elementsByTagName.getLength() > 0) {
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1 && item.getNodeName().equals("arg")) {
                    elementsByTagName = ((Element) item).getElementsByTagName("key");
                    NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("value");
                    if (!(elementsByTagName.getLength() == 0 || elementsByTagName2.getLength() == 0)) {
                        hashMap.put(elementsByTagName.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                    }
                }
            }
        }
        return hashMap;
    }

    private static Element gk(String str) {
        try {
            DocumentBuilder documentBuilder;
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (cwc != null) {
                documentBuilder = cwc;
            } else {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                cwc = documentBuilder;
            }
            Document parse = documentBuilder.parse(inputSource);
            parse.normalize();
            return parse.getDocumentElement();
        } catch (Exception e) {
            v.e("MicroMsg.ABTestParser", e.toString());
            return null;
        }
    }

    private static String a(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            v.e("MicroMsg.ABTestParser", "nodeToString: %s", e.getMessage());
        }
        return stringWriter.toString();
    }
}
