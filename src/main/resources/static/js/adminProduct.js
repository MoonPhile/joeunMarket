function check(button) {
    var buttonId = button.id;
    const imageInputs = document.querySelectorAll('.image-input');
    const imageTypes = ['image/jpeg', 'image/png', 'image/gif']; // 허용되는 이미지 타입
    if (buttonId === 'addProduct') {
        var productId = document.querySelector("input[name='productId']").value;
    } else if (buttonId === 'updateProduct') {
        var productId = document.querySelector("select[name='productId']").value;
    } else {
        alert("비정상적인 접근입니다.")
    }

    var productName = document.querySelector("input[name='productName']").value;
    var productCondition = document.querySelector("input[name='productCondition']").value;
    var productPrice = document.querySelector("input[name='productPrice']").value;
    var productDescription = document.querySelector("textarea[name='productDescription']").value;

    var numberPattern = /^[0-9]+$/;
    var stringPattern = /^[a-zA-Z가-힣!@#$%^&*()\s-=+';:,.<>?/\\"[\]{}\|`~]+$/;


    var hasImage;
    for (var i = 0; i < imageInputs.length; i++) {
        var input = imageInputs[i];
        var files = input.files;

        if (files.length > 0) {
            var file = files[0];
            if (imageTypes.includes(file.type)) {
                console.log("Image selected!");
                hasImage = true;
            } else {
                alert("이미지 파일만 업로드 가능합니다.");
                return;
            }
        }
    }
    if (!numberPattern.test(productId)) {
        alert("상품 ID는 숫자만 입력 가능합니다.");
        return;
    }

    if (!stringPattern.test(productName)) {
        alert("상품 이름은 문자열만 입력 가능합니다.");
        return;
    }

    if (!stringPattern.test(productCondition)) {
        alert("상품 상태는 문자열만 입력 가능합니다.");
        return;

    }
    if (!stringPattern.test(productDescription)) {
        alert("상품 설명은 문자열만 입력 가능합니다.");
        return;
    }

    if (!numberPattern.test(productPrice)) {
        alert("상품 가격은 숫자만 입력 가능합니다.");
        return;
    }

    if (!hasImage) {
        alert("파일을 선택해주세요")
        return;
    }

    console.log("submit^^")
    if (buttonId === 'addProduct') {
        console.log("상품 등록하기")
        document.getElementById('addProductForm').submit();
    } else if (buttonId === 'updateProduct') {
        console.log("상품 수정하기")
        document.getElementById('updateProductForm').submit();
    } else {
        alert("비정상적인 접근입니다.")
    }


}

$(document).ready(function () {
    $('#productId').on('change', function () {
        var selectedProductId = $(this).val();
        const imageInputs = document.querySelectorAll('.image-input');
        $.ajax({
            url: '/getProductInfo', // 백엔드에서 데이터를 가져올 URL
            type: 'GET',
            data: {productId: selectedProductId},
            success: function (product) {
                document.querySelector('input[name="productName"]').value = product.productName;
                document.querySelector('input[name="productCondition"]').value = product.productCondition;
                document.querySelector('input[name="productPrice"]').value = product.productPrice;
                document.querySelector('textarea[name="productDescription"]').value = product.productDescription;
                document.querySelector('p[name="filePath1"]').innerHTML = product.img1;
                document.querySelector('p[name="filePath2"]').innerHTML = product.img2;
                document.querySelector('p[name="filePath3"]').innerHTML = product.img3;
                document.querySelector('p[name="filePath4"]').innerHTML = product.img4;
                var selectCategory = document.querySelector('select[name="productCategoryId"]');
                $(selectCategory).find('option').each(function () {
                    var optionValue = parseInt($(this).val());
                    if (optionValue === product.productCategoryId) {
                        $(this).prop('selected', true);
                    }
                })

            },
            error: function () {
                alert('상품 정보를 가져오는 데 실패했습니다.');
            }
        });
    });
});