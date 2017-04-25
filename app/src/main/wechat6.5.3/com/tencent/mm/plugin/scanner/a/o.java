package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.plugin.scanner.a.n.a;
import com.tencent.mm.plugin.scanner.a.n.b;
import com.tencent.mm.plugin.scanner.a.n.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class o {
    private n iwT = new n();

    public final void yP(String str) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    n.iwT = this.iwT;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals("photo")) {
                                            if (!str2.equals("logo")) {
                                                if (!str2.equals("sound")) {
                                                    break;
                                                }
                                                this.iwT.iwE = b(newPullParser);
                                                break;
                                            }
                                            this.iwT.iwD = b(newPullParser);
                                            break;
                                        }
                                        this.iwT.iwC = b(newPullParser);
                                        break;
                                    }
                                    this.iwT.iwJ = a(newPullParser);
                                    break;
                                }
                                this.iwT.iwI = a(newPullParser);
                                break;
                            }
                            this.iwT.iwH = a(newPullParser);
                            break;
                        }
                        this.iwT.iwG = a(newPullParser);
                        break;
                    }
                    this.iwT.iwA = new b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    n nVar;
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals("email")) {
                                                            if (!str2.equals("title")) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals("url")) {
                                                                                if (!str2.equals("organization")) {
                                                                                    break;
                                                                                }
                                                                                this.iwT.iwS = text;
                                                                                break;
                                                                            }
                                                                            this.iwT.url = text;
                                                                            break;
                                                                        }
                                                                        this.iwT.iwR = text;
                                                                        break;
                                                                    }
                                                                    this.iwT.iwQ = text;
                                                                    break;
                                                                }
                                                                this.iwT.iwP = text;
                                                                break;
                                                            }
                                                            this.iwT.title = text;
                                                            break;
                                                        }
                                                        this.iwT.bCc = text;
                                                        break;
                                                    }
                                                    nVar = this.iwT;
                                                    if (nVar.iwO == null) {
                                                        nVar.iwO = new ArrayList();
                                                    }
                                                    if (!(text == null || nVar.iwO.contains(text))) {
                                                        nVar.iwO.add(text);
                                                        break;
                                                    }
                                                }
                                                nVar = this.iwT;
                                                if (nVar.iwN == null) {
                                                    nVar.iwN = new ArrayList();
                                                }
                                                if (!(text == null || nVar.iwN.contains(text))) {
                                                    nVar.iwN.add(text);
                                                    break;
                                                }
                                            }
                                            nVar = this.iwT;
                                            if (nVar.iwM == null) {
                                                nVar.iwM = new ArrayList();
                                            }
                                            if (!(text == null || nVar.iwM.contains(text))) {
                                                nVar.iwM.add(text);
                                                break;
                                            }
                                        }
                                        nVar = this.iwT;
                                        if (nVar.iwL == null) {
                                            nVar.iwL = new ArrayList();
                                        }
                                        if (!(text == null || nVar.iwL.contains(text))) {
                                            nVar.iwL.add(text);
                                            break;
                                        }
                                    }
                                    nVar = this.iwT;
                                    if (nVar.iwK == null) {
                                        nVar.iwK = new ArrayList();
                                    }
                                    if (!(text == null || nVar.iwK.contains(text))) {
                                        nVar.iwK.add(text);
                                        break;
                                    }
                                }
                                this.iwT.iwF = text;
                                break;
                            }
                            this.iwT.iwB = text;
                            break;
                        }
                        this.iwT.aGX = text;
                        break;
                    }
                default:
                    break;
            }
        }
        n.iwT = this.iwT;
    }

    private static a a(XmlPullParser xmlPullParser) {
        return new a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, "locality"), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, "country"));
    }

    private static c b(XmlPullParser xmlPullParser) {
        return new c(xmlPullParser.getAttributeValue(null, Columns.TYPE), xmlPullParser.getAttributeValue(null, "buffer"));
    }
}
