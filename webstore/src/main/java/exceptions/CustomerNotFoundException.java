package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Przemek on 2016-08-22.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer does not exist")
public class CustomerNotFoundException extends RuntimeException {
}
