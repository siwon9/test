package global.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}

/**
 * RuntimeException을 받아온 이유는 한가지 예외가 아닌 여러종류의 예외를 가져오기 위함이다.
 * ValidationException 안에 super(message)는 RuntimeException의 message란다.
 *
 */