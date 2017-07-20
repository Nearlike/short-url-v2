package short_url.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import short_url.entities.Url;
import short_url.model.UrlRequest;
import short_url.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {

	@Autowired
	UrlService urlService;
	
	@RequestMapping(value="/create", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Url> createUser(@RequestBody UrlRequest urlRequest) throws Exception {
        Url url = urlService.createUser(urlRequest);
        return new ResponseEntity<Url>(url,HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/getAll", method= RequestMethod.GET)
    public ResponseEntity<List<Url>> getUsers() throws Exception {
		List<Url> url = urlService.getUsers();
        return new ResponseEntity<List<Url>>(url,HttpStatus.OK);
    }

}
