package com.tencent.mm.b;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f {
    private static boolean aQk = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> q(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = 0;
        if (r7 != 0) goto L_0x0010;
    L_0x0004:
        r1 = -1;
    L_0x0005:
        if (r1 >= 0) goto L_0x0017;
    L_0x0007:
        r1 = java.lang.System.err;
        r2 = "text not in xml format";
        r1.println(r2);
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = 60;
        r1 = r7.indexOf(r1);
        goto L_0x0005;
    L_0x0017:
        if (r1 <= 0) goto L_0x0032;
    L_0x0019:
        r2 = java.lang.System.err;
        r3 = new java.lang.StringBuilder;
        r4 = "fix xml header from ";
        r3.<init>(r4);
        r3 = r3.append(r1);
        r3 = r3.toString();
        r2.println(r3);
        r7 = r7.substring(r1);
    L_0x0032:
        if (r7 == 0) goto L_0x000f;
    L_0x0034:
        r1 = r7.length();
        if (r1 <= 0) goto L_0x000f;
    L_0x003a:
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        r2 = r2.newDocumentBuilder();	 Catch:{ ParserConfigurationException -> 0x00d1 }
        if (r2 != 0) goto L_0x0052;
    L_0x0049:
        r1 = java.lang.System.err;
        r2 = "new Document Builder failed";
        r1.println(r2);
        goto L_0x000f;
    L_0x0052:
        r3 = new org.xml.sax.InputSource;	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r5 = r7.getBytes();	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r4.<init>(r5);	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r3.<init>(r4);	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r2 = r2.parse(r3);	 Catch:{ DOMException -> 0x00dd, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
        r2.normalize();	 Catch:{ DOMException -> 0x00e0, SAXException -> 0x00da, IOException -> 0x00d7, Exception -> 0x00d4 }
    L_0x0067:
        if (r2 != 0) goto L_0x0072;
    L_0x0069:
        r1 = java.lang.System.err;
        r2 = "new Document failed";
        r1.println(r2);
        goto L_0x000f;
    L_0x0072:
        r2 = r2.getDocumentElement();
        if (r2 != 0) goto L_0x0081;
    L_0x0078:
        r1 = java.lang.System.err;
        r2 = "getDocumentElement failed";
        r1.println(r2);
        goto L_0x000f;
    L_0x0081:
        if (r8 == 0) goto L_0x00a0;
    L_0x0083:
        r3 = r2.getNodeName();
        r3 = r8.equals(r3);
        if (r3 == 0) goto L_0x00a0;
    L_0x008d:
        r0 = "";
        r3 = "";
        a(r1, r0, r3, r2, r6);
    L_0x0096:
        r0 = aQk;
        if (r0 == 0) goto L_0x009d;
    L_0x009a:
        h(r1);
    L_0x009d:
        r0 = r1;
        goto L_0x000f;
    L_0x00a0:
        r2 = r2.getElementsByTagName(r8);
        r3 = r2.getLength();
        if (r3 > 0) goto L_0x00b4;
    L_0x00aa:
        r1 = java.lang.System.err;
        r2 = "parse item null";
        r1.println(r2);
        goto L_0x000f;
    L_0x00b4:
        r0 = r2.getLength();
        r3 = 1;
        if (r0 <= r3) goto L_0x00c3;
    L_0x00bb:
        r0 = java.lang.System.err;
        r3 = "parse items more than one";
        r0.println(r3);
    L_0x00c3:
        r0 = "";
        r3 = "";
        r2 = r2.item(r6);
        a(r1, r0, r3, r2, r6);
        goto L_0x0096;
    L_0x00d1:
        r1 = move-exception;
        goto L_0x000f;
    L_0x00d4:
        r1 = move-exception;
        goto L_0x000f;
    L_0x00d7:
        r1 = move-exception;
        goto L_0x000f;
    L_0x00da:
        r1 = move-exception;
        goto L_0x000f;
    L_0x00dd:
        r2 = move-exception;
        r2 = r0;
        goto L_0x0067;
    L_0x00e0:
        r3 = move-exception;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.b.f.q(java.lang.String, java.lang.String):java.util.Map<java.lang.String, java.lang.String>");
    }

    private static void a(Map<String, String> map, String str, String str2, Node node, int i) {
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
        } else {
            String str3;
            int i2;
            String stringBuilder = new StringBuilder(String.valueOf(str)).append(".").append(node.getNodeName()).toString();
            String stringBuilder2 = new StringBuilder(String.valueOf(str2)).append(".").append(node.getNodeName()).toString();
            if (i > 0) {
                stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append(i).toString();
                map.put(stringBuilder, node.getNodeValue());
                stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder2)).append("#").append(i).toString();
                map.put(stringBuilder2, node.getNodeValue());
                str3 = stringBuilder;
                stringBuilder = stringBuilder2;
            } else {
                map.put(stringBuilder, node.getNodeValue());
                map.put(stringBuilder2, node.getNodeValue());
                str3 = stringBuilder;
                stringBuilder = stringBuilder2;
            }
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);
                    map.put(new StringBuilder(String.valueOf(str3)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                    map.put(new StringBuilder(String.valueOf(stringBuilder)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                Integer num = (Integer) hashMap.get(item2.getNodeName());
                i2 = num == null ? 0 : num.intValue();
                a(map, str3, stringBuilder, item2, i2);
                hashMap.put(item2.getNodeName(), Integer.valueOf(i2 + 1));
            }
        }
    }

    private static void h(Map<String, String> map) {
        if (map.size() <= 0) {
            System.err.println("empty values");
            return;
        }
        for (Entry entry : map.entrySet()) {
            System.err.println("key=" + ((String) entry.getKey()) + " value=" + ((String) entry.getValue()));
        }
    }
}
