package com.example.demo.service;

import com.example.demo.model.InputRequestModel;
import com.example.demo.model.OutPutRespModel;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public OutPutRespModel CheckForNullOrEmpty(InputRequestModel inputRequestModel){
        OutPutRespModel outPutRespModel = new OutPutRespModel();
    if(StringUtils.isNotBlank(inputRequestModel.getName())){
        outPutRespModel.setName(inputRequestModel.getName());
    }
    if(inputRequestModel.getSubjDetails()!=null) {
        if (CollectionUtils.isEmpty(inputRequestModel.getSubjDetails())) {
            outPutRespModel.setSubjDetails(inputRequestModel.getSubjDetails());
        }
    }
        if(inputRequestModel.getSubjDetails()==null) {
                outPutRespModel.setSubjDetails(null);
        }
        if(inputRequestModel.getSubjDetails()!=null) {
            if (CollectionUtils.isNotEmpty(inputRequestModel.getSubjDetails())) {
                outPutRespModel.setSubjDetails(inputRequestModel.getSubjDetails());
            }
        }
    return  outPutRespModel;
    }
}
