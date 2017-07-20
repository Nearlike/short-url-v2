package short_url.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import short_url.entities.Url;

public interface UrlRepository extends CrudRepository<Url, Integer> {
	List<Url> findByUrlShort(String urlShort);
	List<Url> findAll();
}
