package com.patika.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {
    private Long teacherId;

    @NotEmpty(message = "ad soyad alanını boş geçemezsiniz")
    @Size(min=1,max = 255)
    private String teacherNameSurname;

    @NotEmpty(message = "email")
    @Email(message = "uygun formatta mail girmediniz  ")
    private String teacherEmail;

    @NotEmpty(message = "şifreyi boş geçemezsiniz")
   // @Min(value=10,message = "minimum 10 karakter olması gerekiyor")
   // @Max(value=18,message = "maksimum 18 karakter olması gerekiyor")
    @Size(min = 10,max = 18,message = "Minimum 10, maksimum 18 karakter girmeniz gerekiyor!!")
    private String teacherPassword;

}
