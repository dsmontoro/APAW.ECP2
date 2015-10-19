package rest.data.models.daos;

import java.util.List;

import rest.business.models.entities.Theme;

public interface ThemeDao extends GenericDao<Theme, Integer>{
	public Theme findByName(String name);
	public List<String> findAllNames();
}
