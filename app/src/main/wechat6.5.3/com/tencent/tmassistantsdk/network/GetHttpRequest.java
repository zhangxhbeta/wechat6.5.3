package com.tencent.tmassistantsdk.network;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.HttpClientUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public abstract class GetHttpRequest {
    protected static final String REQUEST_SERVER_URL = "http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info";
    protected static final String TAG = "NetworkTask";
    protected HttpGet mHttpGet = null;

    protected abstract void onFinished(JSONObject jSONObject, int i);

    protected synchronized boolean sendData(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHttpGet == null) {
                new Thread(new Runnable() {
                    public void run() {
                        Throwable e;
                        String str = str;
                        HttpClient createHttpClient;
                        try {
                            GetHttpRequest.this.mHttpGet = new HttpGet();
                            GetHttpRequest.this.mHttpGet.setURI(new URI(new StringBuilder(GetHttpRequest.REQUEST_SERVER_URL).append(str).toString()));
                            createHttpClient = HttpClientUtil.createHttpClient();
                            try {
                                HttpClientUtil.setProxy(createHttpClient);
                                HttpResponse execute = createHttpClient.execute(GetHttpRequest.this.mHttpGet);
                                if (execute != null && execute.getStatusLine().getStatusCode() == 200) {
                                    HttpEntity entity = execute.getEntity();
                                    if (entity != null) {
                                        byte[] toByteArray = EntityUtils.toByteArray(entity);
                                        if (toByteArray == null || toByteArray.length <= 0) {
                                            TMLog.i(GetHttpRequest.TAG, "data invalidate");
                                            GetHttpRequest.this.onFinished(null, 704);
                                            GetHttpRequest.this.mHttpGet = null;
                                            if (createHttpClient != null) {
                                                createHttpClient.getConnectionManager().shutdown();
                                                return;
                                            }
                                            return;
                                        }
                                        Object str2 = new String(toByteArray, "utf-8");
                                        if (TextUtils.isEmpty(str2)) {
                                            TMLog.i(GetHttpRequest.TAG, "failed to convert byte[] to string");
                                            GetHttpRequest.this.onFinished(null, 606);
                                            GetHttpRequest.this.mHttpGet = null;
                                            if (createHttpClient != null) {
                                                createHttpClient.getConnectionManager().shutdown();
                                                return;
                                            }
                                            return;
                                        }
                                        JSONObject jSONObject = new JSONObject(str2);
                                        TMLog.i(GetHttpRequest.TAG, "success to received data");
                                        GetHttpRequest.this.onFinished(jSONObject, 0);
                                        GetHttpRequest.this.mHttpGet = null;
                                        if (createHttpClient != null) {
                                            createHttpClient.getConnectionManager().shutdown();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                GetHttpRequest.this.onFinished(null, 704);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                }
                            } catch (ConnectTimeoutException e2) {
                                e = e2;
                                try {
                                    v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                                    GetHttpRequest.this.onFinished(null, 601);
                                    GetHttpRequest.this.mHttpGet = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                    }
                                } catch (Throwable th) {
                                    e = th;
                                    GetHttpRequest.this.mHttpGet = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                    }
                                    throw e;
                                }
                            } catch (ConnectException e3) {
                                e = e3;
                                v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 1);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                }
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 602);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                }
                            } catch (Exception e5) {
                                e = e5;
                                v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 604);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                }
                            }
                        } catch (ConnectTimeoutException e6) {
                            e = e6;
                            createHttpClient = null;
                            v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 601);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                        } catch (ConnectException e7) {
                            e = e7;
                            createHttpClient = null;
                            v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 1);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                            createHttpClient = null;
                            v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 602);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                        } catch (Exception e9) {
                            e = e9;
                            createHttpClient = null;
                            v.a(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 604);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            createHttpClient = null;
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                            throw e;
                        }
                    }
                }).start();
            }
        }
        return false;
    }
}
