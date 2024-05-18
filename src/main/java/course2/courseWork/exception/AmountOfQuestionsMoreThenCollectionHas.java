package course2.courseWork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountOfQuestionsMoreThenCollectionHas extends RuntimeException {
    public AmountOfQuestionsMoreThenCollectionHas(String message) {
        super(message);
    }
}
