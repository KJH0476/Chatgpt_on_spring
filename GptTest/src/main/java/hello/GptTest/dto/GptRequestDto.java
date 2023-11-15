package hello.GptTest.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
public class GptRequestDto {
    /**
     * @model 모델명
     * @level 대화수준
     * @prompt 질문
     * @temperature 다양성 설정 (높을수록 Good)
     */
    private String model;
    private String level;
    private String prompt;
    private String temperature;
}
