package ale.mach.driver.controllers.errorControl;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

		Map<String, Object> errorAttributes =
				super.getErrorAttributes(webRequest, includeStackTrace);
		errorAttributes.remove("trace");

		return errorAttributes;
	}
}
