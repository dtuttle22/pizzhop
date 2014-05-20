package pizzhop.web.util;

public class ResponseTemplate {

	private String status;

	private Object data;

	private String message;

	private ResponseTemplate(RequestStatus status, Object data, String message) {
		this.status = status.getText();
		this.data = data;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public static ResponseTemplate successResponse(Object data) {
		return new ResponseTemplate(RequestStatus.SUCCESS, data, null);
	}

	public static ResponseTemplate errorResponse(String errorMessage) {
		return new ResponseTemplate(RequestStatus.ERROR, null, errorMessage);
	}

	public static ResponseTemplate successResponse() {
		return new ResponseTemplate(RequestStatus.SUCCESS, null, null);
	}

}
