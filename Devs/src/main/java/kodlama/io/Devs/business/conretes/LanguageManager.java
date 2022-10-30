package kodlama.io.Devs.business.conretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public String insert(Language language) {
		if(this.checkName(language.getName())) return "Bu isme sahip bir dil zaten bulunmaktadır";
		
		if(language.getName().isBlank()|| language.getName().isEmpty()) return "İsim alanı boş geçilemez";
		
		this.languageRepository.insertLanguage(language);
		return "Dil başarıyla eklendi";
	}

	@Override
	public String update(Language language) {
		
		if(this.checkName(language.getName())) 
			return "Güncellemek istediğiniz isme sahip bir dil zaten bulunmaktadır";
		
		if(language.getName().isBlank()|| language.getName().isEmpty()) 
			return "Güncellenecek isim alanı boş geçilemez";
		
		this.languageRepository.updateLanguage(language,language.getName());
		return "İşlem başarılı";
	}

	@Override
	public List<Language> getAll() {
		return this.languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {
		return this.languageRepository.getById(id);
	}

	@Override
	public void delete(Language language) {
		languageRepository.deleteLanguage(language);
	}
	
	//ismin önceden kayıtlı olup olmadığının kontrolü
	private boolean checkName(String languageName) {
		List<Language> languages = this.languageRepository.getAll();
		boolean result = false;
		
		for(Language language:languages) {
			if(language.getName().equalsIgnoreCase(languageName)) {
				result = true;
			}
		}
		return result;
	}

}
