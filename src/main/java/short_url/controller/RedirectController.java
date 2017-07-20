package short_url.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import short_url.service.RedirectService;

@RestController
public class RedirectController {

	@Autowired
	RedirectService redirectService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void createUser(@PathVariable(value = "id") String id, HttpServletResponse httpServletResponse) throws Exception {
		httpServletResponse.setHeader("Location", redirectService.redirect(id));
	}

}
