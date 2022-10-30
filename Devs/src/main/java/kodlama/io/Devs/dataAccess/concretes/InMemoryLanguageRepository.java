package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages=new ArrayList<Language>();
		
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"Python"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		
		for (Language language : languages) {
			if(language.getId()==id)
			{return language;}
		}
		System.out.println("Bu ID'ye ait bir giriş bulunamamştır.");
        return null;
	}

	@Override
	public void insertLanguage(Language language) {
		languages.add(language);
		
	}

	@Override
	public void deleteLanguage(Language language) {
		languages.remove(language);
		System.out.println("Silinen dil: " + language.getName());
	}

	@Override
	public void updateLanguage(Language language, String newName) {
		languages.get(language.getId()).setName(newName);
		
	}

}
