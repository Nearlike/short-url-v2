package short_url.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import short_url.entities.Url;
import short_url.repository.UrlRepository;

@Service
public class RedirectService {

	@Autowired
	UrlRepository urlRepository;

	public String redirect(String urlShort) throws Exception {
		if (urlShort == null || "".equals(urlShort)) {
			return "champs vide";
		}

		List<Url> urls = urlRepository.findByUrlShort(urlShort);

		Url url = urls.get(0);

		if (url.getMaxClics() != null && url.getMaxClics() < url.getNbClics()) {
			throw new Exception("Url non disponible ! Nombre de clics dépassés");
		}

		if (url.getDateStart() != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			
			if (format.format(today).compareTo(format.format(url.getDateStart())) < 0) {
				throw new Exception("Url non disponible ! Date de validité dépassée");
			}
		}

		url.setNbClics(url.getNbClics() + 1);
		urlRepository.save(url);
		return url.getUrlLong();
	}
}
