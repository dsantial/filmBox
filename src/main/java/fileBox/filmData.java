package fileBox;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class filmData {

    public static String request(String httpUrl, String httpArg) {

        BufferedReader reader = null;

        String result = null;

        StringBuffer sbf = new StringBuffer();

        httpUrl = httpUrl + "?" + httpArg;

        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("charset", "utf-8");

            connection.setRequestProperty("Accept-Encoding", "gzip");

            connection.connect();

            InputStream is = new GZIPInputStream(connection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {

                sbf.append(strRead);

                sbf.append("\r\n");

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }

    public static void main(String[] args) {


        String appid="02533cc94a91c1bf98c93bd7aeda47e3";

        String httpUrl = "https://api.shenjian.io/";

        String httpArg = "appid="+appid;

        String jsonResult = request(httpUrl, httpArg);

        System.out.println(jsonResult);

/**

 * @param urlAll

 * :请求接口

 * @param httpArg

 * :参数

 * @return 返回结果

 */
//ReturnResult allInfo=JSON.parseObject(jsonResult,ReturnResult.class);
//        System.out.printf("json 字符串转简单java对象"+ allInfo.getCode_retrun());
//
//        for (DataInfo ds:allInfo.getDatainfos()){
//            List<DataInfo> dataList=new ArrayList<DataInfo>();
//
//            System.out.printf(ds.getMovieName());
//
//        }

        JSONObject json=JSONObject.parseObject(jsonResult);
//        System.out.printf(JSONObject.toJSONString(json,true));
        JSONArray array =json.getJSONArray("data");

        List<DataInfo> dataInf=new ArrayList<DataInfo>();
        for (int i=0 ;i<array.size();i++){
            JSONObject jo=array.getJSONObject(i);
            DataInfo dataInfo =JSON.parseObject(jo.toJSONString(),DataInfo.class);
            System.out.println(dataInfo.getMovieName());

        }



//List<DataInfo> dainfo=   allInfo.getDatainfos();
// for (int i=0 ;i<.size();i++){
//     System.out.printf(.get(i).getMovieName());
//
// }



    }

}
