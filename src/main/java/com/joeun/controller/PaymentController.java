package com.joeun.controller;

import com.joeun.dto.Payment;
//import com.joeun.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class PaymentController {
    //토큰 발급을 위해 아임포트에서 제공해주는 rest api 사용
//    private final IamportClient iamportClientApi;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    //생성자로 rest api key와 secret을 입력해서 토큰 바로생성.
//
//    public PaymentController() {
//        this.iamportClientApi = new IamportClient("4733323784021880",
//                "UtVnQlGvSCIICvs7ykwQGNz6V2lthPQsq2jPMvjBeqzt1EHr1CgyO2l8Ulw5wIwivnc8fbkmfFgUdp6F");
//    }

    @GetMapping("/portOne.do")
    public String goToTestPay() {
        return "/test/portOne";
    }

    @GetMapping("/payment/validate/")
    @ResponseBody
    public String payValidate(Payment payment, int amount){
        System.out.println("페이먼트 검증 컨트롤러 진입");
        System.out.println("페이먼트 아이디 "+ payment.getPaymentId());
        System.out.println("오더아이디 "+ payment.getOrderId());
        System.out.println("유저아이디 "+ payment.getUserId());
        System.out.println("paid_amount: "+ amount);

        return "";
    }
//
//    /**
//     * impUid로 결제내역 조회.
//     * @param impUid
//     * @return
//     * @throws IamportResponseException
//     * @throws IOException
//     */
//    public IamportResponse<Payment> paymentLookup(String impUid) throws IamportResponseException, IOException {
//        return iamportClientApi.paymentByImpUid(impUid);
//    }
//
//    /**
//     * impUid를 결제 번호로 찾고, 조회해야하는 경우.
//     * 오버로딩.
//     * @param paymentsNo
//     * @return
//     * @throws IamportResponseException
//     * @throws IOException
//     */
//    public IamportResponse<Payment> paymentLookup(long paymentsNo) throws IamportResponseException, IOException{
//        PaymentInfo paymentInfo = paymentService.paymentLookupService(paymentsNo);
//        return iamportClientApi.paymentByImpUid(paymentInfo.getImpUid());
//    }
//
//    /**
//     * 결제검증을 위한 메서드
//     * map에는 imp_uid, amount, actionBoardNo 이 키값으로 넘어옴.
//     * @param map
//     * @return
//     * @throws IamportResponseException
//     * @throws IOException
//     * @throws verifyIamportException
//     */
//    @PostMapping("verifyIamport")
//    public IamportResponse<Payment> verifyIamport(@RequestBody Map<String,String> map) throws IamportResponseException, IOException, verifyIamportException{
//        String impUid = map.get("imp_uid");//실제 결제금액 조회위한 아임포트 서버쪽에서 id
//        long actionBoardNo = Long.parseLong(map.get("actionBoardNo")); //DB에서 물건 가격 조회를 위한 번호
//        int amount = Integer.parseInt(map.get("amount"));//실제로 유저가 결제한 금액
//
//        //아임포트 서버쪽에 결제된 정보 조회.
//        //paymentByImpUid 는 아임포트에 제공해주는 api인 결제내역 조회(/payments/{imp_uid})의 역할을 함.
//        IamportResponse<Payment> irsp = paymentLookup(impUid);
//
//        paymentService.verifyIamportService(irsp, amount, actionBoardNo);
//
//        return irsp;
//    }
}
