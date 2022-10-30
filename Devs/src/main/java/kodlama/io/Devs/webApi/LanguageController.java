package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(int id) {
		return this.languageService.getById(id);
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Language language) {
		return this.languageService.insert(language);
	}
	
	@PostMapping("/update")
	public String update(@RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	
	@DeleteMapping("/delete")
	public void delete(Language language) {
		languageService.delete(language);
	}
	
}
