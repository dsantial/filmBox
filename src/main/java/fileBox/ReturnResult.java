package fileBox;

import java.util.ArrayList;
import java.util.List;

public class ReturnResult {
     private String code_retrun;
     private List<DataInfo> datainfos=new ArrayList<DataInfo>();

     public ReturnResult(){}
     public ReturnResult(String code_retrun,List<DataInfo> dataInfos){
         this.code_retrun=code_retrun;
         this.datainfos=dataInfos;
     }

    public String getCode_retrun() {
        return code_retrun;
    }

    public void setCode_retrun(String code_retrun) {
        this.code_retrun = code_retrun;
    }

    public List<DataInfo> getDatainfos() {
        return datainfos;
    }

    public void setDatainfos(List<DataInfo> datainfos) {
        this.datainfos = datainfos;
    }
}
