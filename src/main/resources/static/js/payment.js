

//결제 취소 요청 함수 예정
function cancelPay(){
    $.ajax({
        url: "/payment/payCancel",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            impUid : imp_uid,            // 결제 고유번호
            orderId: merchant_uid,   // 주문번호
            // paymentPrice: rsp.paid_amount,     // 미입력시 전체 금액 환불
            userId: 1,      //유저 아이디(구매자)
        }),
    }).done(function (data) {
        // 가맹점 서버 결제 API 성공시 로직
    })
}
