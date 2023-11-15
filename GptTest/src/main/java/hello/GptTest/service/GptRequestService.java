package hello.GptTest.service;

import hello.GptTest.dto.GptRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GptRequestService {

    @Value("${chat-gpt}")
    private String api_key;

    public HttpEntity<String> GetGptRequest(GptRequestDto gptRequestDto){
        //헤더 지정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(api_key);

        String requestBody = "{"
                + "\"model\": \"" + gptRequestDto.getModel() + "\","
                + "\"messages\": ["
                + "    {\"role\": \"system\", \"content\": \"" + gptRequestDto.getLevel() + "\"},"
                + "    {\"role\": \"user\", \"content\": \"" + gptRequestDto.getPrompt() + "\"}"
                + "],"
                + "\"temperature\": " + gptRequestDto.getTemperature()
                + "}";

        return new HttpEntity<>(requestBody, headers);
    }
}
