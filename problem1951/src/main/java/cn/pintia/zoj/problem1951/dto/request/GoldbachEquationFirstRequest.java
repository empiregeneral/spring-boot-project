package cn.pintia.zoj.problem1951.dto.request;

import cn.pintia.zoj.problem1951.model.annonation.ValidEvenNumber;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GoldbachEquationFirstRequest {
    @NotNull(message = "evenNum must not be null")
    @ValidEvenNumber
    private Integer evenNum;
}
