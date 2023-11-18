package hello.GptTest.Controller;

import hello.GptTest.dto.GptRequestDto;
import hello.GptTest.service.GptRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatGptController {

    private final GptRequestService gptRequestService;
    private final RestTemplate restTemplate = new RestTemplate();
    private String endPoint = "https://api.openai.com/v1/chat/completions";

    @PostMapping("/gpt-test")
    public ResponseEntity<String> ChatGptResponse(@RequestBody GptRequestDto gptRequestDto){

        HttpEntity<String> entity = gptRequestService.GetGptRequest(gptRequestDto);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(endPoint, entity, String.class);
            log.info("response={}", response);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
