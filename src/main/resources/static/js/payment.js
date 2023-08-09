var IMP = window.IMP;
IMP.init('imp65565347')

//결제 요청 함수
function requestPay() {
    //이하 각종 결제정보를 담는 변수 관리
    // var amount = document.getElementById('amount').value;
    // var nameinput = document.getElementById('nameinput').value;
    var uid = document.getElementById('uid').value;
    IMP.request_pay({
        pg: "kakaopay",
        merchant_uid: uid,   // 주문번호
        // merchant_uid: "ORD20180131-0000011",   // 주문번호
        name: "테스트 구매",                      //상품 이름
        amount: 4500,                         // Number 타입 결제 금액
        buyer_email: "lunatic1702@gmail.com",   //메일
        buyer_name: "조은마켓 기술지원팀",       //
        buyer_tel: "010-6608-3897",         //전화번호
        buyer_addr: "경기도 구리시",      //주소
    }, function (rsp) { // callback
        //결제 값이 요청 값과 같은지 검증합니다
        console.log(rsp)
        console.log(typeof rsp.paid_amount)
        console.log(typeof rsp.imp_uid)
        if (rsp.success) {
            console.log("ajax시작")
            $.ajax({
                url: "/payment/validate",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify({
                    impUid : rsp.imp_uid,            // 결제 고유번호
                    orderId: rsp.merchant_uid,   // 주문번호
                    paymentPrice: rsp.paid_amount,     // 결제 금액
                    userId: 1,      //유저 아이디(구매자)
                }),
            }).done(function (data) {
                // 가맹점 서버 결제 API 성공시 로직
            })

        } else {
            alert("결제에 실패하였습니다. " + rsp.error_msg)
        }

    });
}

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
