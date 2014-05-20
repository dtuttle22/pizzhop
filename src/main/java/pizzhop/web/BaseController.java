package pizzhop.web;

import org.springframework.web.bind.annotation.ExceptionHandler;

import pizzhop.web.util.ResponseTemplate;

public class BaseController {

	@ExceptionHandler(value = Exception.class)
	public ResponseTemplate handleException(Exception ex) {
		return ResponseTemplate.errorResponse(ex.getMessage());
	}
}
