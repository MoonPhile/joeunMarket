package com.joeun.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자 ID는 필수 항목 입니다.")
    private String id;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;


    @NotEmpty(message = "번호는 필수항목입니다.")
    private String phone;

    @NotEmpty(message = "주소는 필수항목입니다.")
    private String address;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

}
