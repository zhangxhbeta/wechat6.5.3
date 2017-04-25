package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class ai {
    public String aZD;
    public String aZy;
    public String aeskey;
    public int bNn;
    public String bNo = SQLiteDatabase.KeyEmpty;
    public String bdo;
    public String bea;
    public long bmL;
    public int cQM;
    public String dhC;
    public long dhH;
    public int height;
    public String id;
    public int nvg;
    public int nvh;
    public int nvi;
    public int nvj;
    public String nvk = SQLiteDatabase.KeyEmpty;
    public String nvl;
    public String nvm;
    public String nvn;
    public boolean nvo = true;
    public int width;

    public static ai a(Map<String, String> map, String str, String str2, String str3) {
        if (map == null) {
            return null;
        }
        ai aiVar = new ai();
        aiVar.nvk = str2;
        aiVar.bdo = str;
        aiVar.id = (String) map.get(".msg.emoji.$idbuffer");
        aiVar.dhC = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        aiVar.aZy = str4;
        if (str4 == null) {
            aiVar.aZy = (String) map.get(".msg.emoji.$md5");
        }
        if (!be.kS(aiVar.aZy)) {
            aiVar.aZy = aiVar.aZy.toLowerCase();
        }
        try {
            aiVar.nvg = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                aiVar.nvh = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                aiVar.nvh = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                aiVar.nvi = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                aiVar.nvj = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                aiVar.aZD = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                aiVar.nvl = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                aiVar.nvm = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                aiVar.bea = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                aiVar.nvn = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                aiVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                aiVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                aiVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (!be.kS(str3)) {
                aiVar.bNo = str3;
            }
            v.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d", aiVar.id, aiVar.aZy, Integer.valueOf(aiVar.nvg), Integer.valueOf(aiVar.nvh), Integer.valueOf(aiVar.nvi), Integer.valueOf(aiVar.nvj), aiVar.aZD, aiVar.nvl, aiVar.nvm, aiVar.bea, aiVar.nvn, Integer.valueOf(aiVar.width), Integer.valueOf(aiVar.height));
            return aiVar;
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", be.e(e));
            return null;
        }
    }
}
