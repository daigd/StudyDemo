package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class ProjectManagerHandler extends Handler {
    @Override
    public Object handlerRequest(RequestModel rm) {
        if (FeeRequestModel.FEE_TYPE.equals(rm.getType())) {
            //项目经理只想处理聚餐费用
            return handlerFeeRequest(rm);
        }else{
            return super.handlerRequest(rm);
        }
    }

    private Object handlerFeeRequest(RequestModel requestModel) {
        FeeRequestModel feeRequestModel = (FeeRequestModel) requestModel;
        //只能审批500元以下的费用
        if (BigDecimal.valueOf(500).compareTo(feeRequestModel.getFee()) > 0) {
            if ("小李".equals(feeRequestModel.getUserName())) {
                return "项目经理同意" + feeRequestModel.getUserName() + feeRequestModel.getFee() + "元的聚餐申请。";
            }else{
                return "项目经理不同意" + feeRequestModel.getUserName() + feeRequestModel.getFee() + "元的聚餐申请。";
            }
        }else{
            if (successor != null) {
                return this.successor.handlerRequest(requestModel);
            }
        }
        return super.handlerRequest(requestModel);
    }
}
