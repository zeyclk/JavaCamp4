package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	List<Language> getAll(); //hepsinin listelenmesi
	Language getById(int id); //ID'ye göre listeleme
	void insertLanguage(Language language); //Yeni dil ekleme
	void deleteLanguage(Language language); //Dil silme
	void updateLanguage(Language language,String newName); //Dili güncelleme
	
}
