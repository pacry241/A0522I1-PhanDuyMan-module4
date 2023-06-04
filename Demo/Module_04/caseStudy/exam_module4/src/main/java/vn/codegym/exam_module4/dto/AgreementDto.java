package vn.codegym.exam_module4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.exam_module4.entity.Hostel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgreementDto {
    private String id;
    private String personName;
    @NotBlank(message = "CMND không được để trống")
    private String cmnd;
    private LocalDate date;
    private Long time;
    private Double totalPrice;
    private Hostel hostel;
}
