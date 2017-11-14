package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class ProjectManagerHandler2 extends ProjectManagerHandler {
    @Override
    public Object handlerRequest(RequestModel rm) {
        //该项目经理只处理差旅费
        if (PreFeeRequestModel.PRE_FEE.equals(rm.getType())) {
            return preFeeHandler(rm);
        }
        //其它交由父类处理
        return super.handlerRequest(rm);
    }

    private Object preFeeHandler(RequestModel requestModel) {
        PreFeeRequestModel preFeeRequestModel = (PreFeeRequestModel) requestModel;
        if (BigDecimal.valueOf(2000).compareTo(preFeeRequestModel.getPreFee())>=0) {
            return "项目经理同意" + preFeeRequestModel.getUserName() + preFeeRequestModel.getPreFee() + "元的差旅费";
        }else {
            if (successor != null) {
                return successor.handlerRequest(requestModel);
            }
        }
        return super.handlerRequest(requestModel);
    }
}
