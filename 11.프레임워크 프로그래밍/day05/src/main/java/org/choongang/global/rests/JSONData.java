package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData { // 통일성을 위해 정의한 클래스
    private HttpStatus status = HttpStatus.OK;
    private boolean success = true;
    private Object message;
    @NonNull
    private Object data;
}
