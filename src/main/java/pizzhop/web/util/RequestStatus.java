package pizzhop.web.util;

public enum RequestStatus {

	SUCCESS("success"), ERROR("error");

	private String text;

	private RequestStatus(String message) {
		this.text = message;
	}

	public String getText() {
		return text;
	}

	public static RequestStatus fromText(String text) {
		if (text == null)
			throw new NullPointerException("text is null");

		for (RequestStatus status : values()) {
			if (status.getText().equals(text)) {
				return status;
			}
		}

		throw new IllegalArgumentException("No enum constant." + text);

	}

	@Override
	public String toString() {
		return this.text;
	}
}
