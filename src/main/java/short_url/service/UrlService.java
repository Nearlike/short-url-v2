package short_url.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import short_url.entities.Url;
import short_url.model.UrlRequest;
import short_url.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	UrlRepository urlRepository;

	public Url createUser(UrlRequest urlRequest) throws Exception {
		verifs(urlRequest);

		Url url = new Url();
		url.setUrlShort(generateRandomString());
		url.setUrlLong(urlRequest.getUrlLong());

		if (urlRequest.getPassword() != null)
			url.setPassword(urlRequest.getPassword());

		if (urlRequest.getMaxClics() != null) {
			url.setMaxClics(urlRequest.getMaxClics());
		} else {
			if (urlRequest.getDateEnd() != null && urlRequest.getDateStart() != null) {
				url.setDateEnd(urlRequest.getDateEnd());
				url.setDateStart(urlRequest.getDateStart());
			}
		}

		return urlRepository.save(url);
	}

	public List<Url> getUsers() {
		return urlRepository.findAll();
	}

	public String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(7);
	}

	public void verifs(UrlRequest url) throws Exception {
		UrlValidator urlValidator = new UrlValidator();

		if (!urlValidator.isValid(url.getUrlLong()))
			throw new Exception("Veuillez entrer une URL valide");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();

		if (url.getDateStart() != null || url.getDateEnd() != null) {
			if (format.format(url.getDateEnd()).compareTo(format.format(url.getDateStart())) < 0) {
				throw new Exception("La date de fin doit être égale ou après la date de départ");
			}

			if (format.format(url.getDateEnd()).compareTo(format.format(today)) < 0) {
				throw new Exception("La date de fin doit être égale ou après aujourd'hui");
			}
		}

	}
}
