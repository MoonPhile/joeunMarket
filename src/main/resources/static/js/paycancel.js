//결제 취소 요청 함수 예정
function cancelPay(id){
    console.log(id)
    var orderId = parseInt(id)
    $.ajax({
        url: "/payment/payCancel",
        method: "POST",
        // contentType: "application/json",
        data: {
            orderId: orderId  // 주문번호
        },
    }).done(function (data) {
        // 가맹점 서버 결제 API 성공시 로직
    })
}
//필요한 값 변수에 저장
// var price = document.getElementById('price').value;
// var userId = document.getElementById('userId').value;
// var orderId = document.getElementById('ordersId').value;
// var productId = document.getElementById('productId').value;
// var productName = document.getElementById('productName').value;