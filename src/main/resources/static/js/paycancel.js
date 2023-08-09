//결제 취소 요청 함수 예정
function cancelPay(){
    //필요한 값 변수에 저장
    // var price = document.getElementById('price').value;
    var userId = document.getElementById('userId').value;
    // var orderId = document.getElementById('ordersId').value;
    // var productId = document.getElementById('productId').value;
    // var productName = document.getElementById('productName').value;
    $.ajax({
        url: "/payment/payCancel",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            impUid : imp_uid,            // 결제 고유번호
            orderId: merchant_uid,   // 주문번호
            // paymentPrice: rsp.paid_amount,     // 미입력시 전체 금액 환불
            userId: userId,      //유저 아이디(구매자)
        }),
    }).done(function (data) {
        // 가맹점 서버 결제 API 성공시 로직
    })
}
